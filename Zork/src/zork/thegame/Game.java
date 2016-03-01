package zork.thegame;

import java.util.ConcurrentModificationException;
import java.util.Random;

import zork.items.Bag;
import zork.items.GeneralItem;
import zork.items.Weapon;
import zork.items.Mainframe;
import zork.items.Warp;
import zork.themap.Room;
import zork.characters.Player;
import zork.characters.Zombie;
import zork.command.Command;
import zork.command.CommandWord;
import zork.command.Parser;
import zork.themap.Map;
import zork.logger.*;

/**
 * This class is the main class of the "Zork" application. "Zork" is a very
 * simple, text based adventure game.
 * 
 * The "Zork" application it was modified as "Resident Evil" movie,
 * 
 * As the movie Alice wakes up in the shower and after she dress, the Umberella
 * corporation's disinfestation squad comes and bring her inside the hive
 * 
 * This main class creates and initialises all the others: it creates all rooms,
 * creates the parser and starts the game. It also evaluates and executes the
 * commands that the parser returns.
 * 
 * @author Drob Adrian Mihai
 * @version 27.04.2012
 */

public class Game {

	private static Log log = new Log();
	// initialize costants used to identify items rooms or points
	private static final int MAINFRAME = 10, WAREHOUSE = 6, VIRALLAB = 7,
			ARMORY = 9, SECURITY = 11, CLOSET = 14, USEPOINTS = 100,
			KILLPOINTS = 500, MOVEMENTPOINTS = -10, FREESPACE = 10, FREESPACEBAG = 15,
			LEVEL1 = 4, LEVEL2 = 2, LEVEL3 = 0;;
	// initialize new parser
	private Parser parser;

	// initialize characters and status
	private Player player;
	private Status status;
	private Zombie zombie1;
	private Zombie zombie2;
	private Zombie zombie3;
	private Zombie zombie4;
	private Zombie lecher;
	private Mainframe mainframeStatus;
	// initialize the map
	private Map map;

	/**
	 * Create the game and initialize its internal map.
	 */
	public Game() {
		player = new Player("playerName");
		status = new Status();
		map = new Map();
		status.addPreviousScores(status.getScore());
		setPlayerCurrentRoom();
		setZombiesInRooms();
		setMainframeStatus();

		parser = new Parser();
	}

	/**
	 * 
	 * sets the mainframe status
	 */

	private void setMainframeStatus() {

		// sets the mainframe status
		mainframeStatus = (Mainframe) map.getItem(MAINFRAME);
	}

	/**
	 * sets the current room of the player and update the status of the game
	 * 
	 */

	private void setPlayerCurrentRoom() {

		// start game inside bathroom
		player.setPlayerRoom(map.getRoom(0));
		status.getPlayerPath().push(player.getPlayerRoom());
		status.getRoomInventories().push(
		player.getPlayerRoom().cloneRoomInventory(
		player.getPlayerRoom().getRoomInventory())); // insert the room inventory into inventories stack
		status.getPlayerInventories().push(
		player.clonePlayerInventory(player.getPlayerInventory())); // insert the player inventory in a stack		
	}

	/**
	 * 
	 * sets the zombies into their rooms
	 */

	private void setZombiesInRooms() {

		// initialize new zombies in some rooms
		zombie1 = new Zombie("Employee", map.getRoom(WAREHOUSE), false);
		zombie2 = new Zombie("Agent", map.getRoom(ARMORY), false);
		zombie3 = new Zombie("Agent", map.getRoom(SECURITY), false);
		zombie4 = new Zombie("Manager", map.getRoom(CLOSET), false);
		lecher = new Zombie("Lecher", map.getRoom(VIRALLAB), false);
	}

	/**
	 * Main play routine. Loops until end of play.
	 */
	public void play() {
		printWelcome(log);

		// Enter the main command loop. Here we repeatedly read commands and
		// execute them until the game is over.

		boolean finished = false;
		while (!finished) {
			Command command = parser.getCommand(log);
			finished = processCommand(command);
		}
		log.info("Thank you for playing.");
	}

	/**
	 * Print out the opening message for the player.
	 */
	private void printWelcome(Log log) {
		log.info("\nWelcome to RESIDENT EVIL!"
		+"\nThis game is based on Zork game that is a textual game"
		+"\n'Zork' project was modified by Adrian and became Resident Evil"
		+"\nYou are are Alice and you are the guard to Hive, your mission is to keep save Hive's staff"
		+"\nsomething happend and the hive activate his defences while you are taking a shower"
		+"\nType 'help' if you need help, " +
		"\nType 'verbose' if you want to see a detailed description of each command.\n\n");
	
		log.info((player.getPlayerRoom()).getLongDescription());
	}

	/**
	 * Given a command, process (that is: execute) the command.
	 * 
	 * @param command
	 *            The command to be processed.
	 * @return true If the command ends the game, false otherwise.
	 */
	private boolean processCommand(Command command) {
		boolean wantToQuit = false;

		CommandWord commandWord = command.getCommandWord();

		if (command.hasSecondWord()) {
			
			wantToQuit = commandsTwoWords(command, commandWord);
		} else {
			
				wantToQuit = commandsOneWord(command, commandWord);
		}
		return wantToQuit;
	}

	/**
	 * This is the case when the command word do not have a second word
	 * 
	 * @param command
	 *            A Command
	 * @param commandWord
	 *            A CommandWord
	 * @return a boolean value that identify if quit or not
	 */

	private boolean commandsOneWord(Command command, CommandWord commandWord) {

		boolean wantToQuit = false;

		switch (commandWord) {
		case UNKNOWN:
			log.info("I don't know what you mean...");
			break;

		case HELP:
			printHelp();
			break;

		case QUIT:
			log.info("The player has scored " + status.getScore() + " points\n");
			wantToQuit = quit(command);
			break;

		case BACK:
			try{
				goBack();
			}catch (Exception a){
				log.info("You can't undo when you have just start playing: \n\tGAME OVER Please restart game...\n");
				wantToQuit = true;
			}
			player.getPlayerRoom().getLongDescription();
			break;

		case EXITS:
			log.info((player.getPlayerRoom()).getExitString());
			break;

		case SPACE:
			log.info("Your free space is: "
					+ player.getPlayerInventory().getFreeWeight());
			break;
		case SCORE:
			log.info("Your score is: " + status.getScore());
			break;
		case VERBOSE:
			showVerbose();
			break;
		default:
			log.info("You must specify the object of this command");
			break;
			
		}

		return wantToQuit;
	}
	

	/**
	 * this is the case when the player want to interact with an object
	 * 
	 * @param command
	 *            A Command
	 * @param commandWord
	 *            A CommandWord
	 */

	private void interactObjects(Command command, CommandWord commandWord) {

		switch (commandWord) {
		case VIEW:
			view(command);
			break;
		case TAKE:
			takeItem(command);
			break;
		case DROP:
			dropItem(command);
			break;
		case USE:
			useItem(command);
			break;
		default:
			log.info("I don't know what you mean...");
			break;

		}
	}

	/**
	 * This is the case when command has a second word
	 * 
	 * @param command
	 *            A Command
	 * @param commandWord
	 *            A CommandWord
	 * @return A boolean value that identify if quit or not
	 */

	private boolean commandsTwoWords(Command command, CommandWord commandWord) {

		boolean wantToQuit = false;

		switch (commandWord) {

		case GO:
			goRoom(command);
			if (player.getDead() || status.getWin()) {
				wantToQuit = true;
			}
			break;
		default:
			interactObjects(command, commandWord);
			break;
		}
		return wantToQuit;
	}
	
	/**
	 * Provides a complete description after each command 
	 */

	private void showVerbose() {
		
		log.info("\ngo: \t is the movement command, must be followed by the direction of the movement (north, southeast etc...)\n" +
				"exits: \t show the description of the current room and where are the exits\n" +
				"drop: \t drop a specified item from your inventory\n" +
				"take: \t take specified a item from the room\n" +
				"score: \t shows the current score\n" +
				"back: \t using this command you will turn back to previus status\n" +
				"use: \t use a specified item\n" +
				"view: \t shows the items inside inventory or room\n" +
				"space: \t shows how much free space you have inside inventory\n" +
				"help: \t a guide to the game\n" +
				"quit: \t leave the game\n");
	}

	/**
	 * Print out some help information. Here we print some stupid, cryptic
	 * message and a list of the command words
	 */
	private void printHelp() {
		log.info("\nYou don't remember anything and you don't know where you are\n"
		+"now you are nude in bathroom inside shower.\n"
		+"you need some closets you must get dress\n"
		+"Your command words are: ");
		parser.showCommands(log);
	}
	
	/**
	 * this command view the inventory or the room's inventory
	 * 
	 * @param command A command word
	 */
	
	public void view(Command command) {
		
		if(command.getSecondWord().contains("room")){
			(player.getPlayerRoom()).showRoomInventory(player.getPlayerRoom(), log);
		}else{
			if(command.getSecondWord().contains("inventory")){
				player.showPlayerInventory(log);
			}else{
				log.info("You can view only inventory or room");
			}
		}
	}

	/**
	 * use a item and if consumable will be removed from inventory using a item
	 * will also unlock parts of the map
	 * 
	 * @param command
	 *            Is the name of the object to use
	 */

	public void useItem(Command command) {

		boolean presence = false;

		if(searchInventory(command) || searchInRoom(command)){
			presence = true;
		}

		if (!presence) {
			// message of invalid second word or item not present in room
			log.info("Item's name to be used is not valid or not present in room or your inventory");
		}
	}

	/**
	 * searches a item in Room's inventory
	 * 
	 * @param command A command containing the name of the object to search
	 * @return a boolean value that indicates if the item is present
	 */

	private boolean searchInRoom(Command command) {

		GeneralItem temp = null;

		try{
			for (GeneralItem item : player.getPlayerRoom().getRoomItems()) {

				if (item.getName().contains(command.getSecondWord())) {

					temp = item;

					if (item.getPick()) {
						log.info("You request to use a item that is in room and can carry it" +
								"\nyou should take it first");
					}else{
						
						log.info(item.getDescription());
						item.effect(player, log);
						// if used for the first time assign points else nothing
						if(!item.getUsed()){
							
							status.changeScore(USEPOINTS);
						}
						item.setUsed(true);
					}

					
				}
			}
		}catch (ConcurrentModificationException a) {
			// iteration stop because the content of this inventory changed while iterates
		}
		
		return temp != null;
	}

	/**
	 * searches a Item in player's inventory to use
	 * 
	 * @param command
	 *            a string containing the name of the Item
	 * @return a boolean value set to true if the Item is present
	 */
	private boolean searchInventory(Command command) {

		GeneralItem temp = null;

	try{
			
		
		for (GeneralItem item : player.getPlayerItems()) {

			if (item.getName().contains(command.getSecondWord())) {

				temp = item;

				log.info(item.getDescription());
				
				if(item instanceof Weapon){
					log.info("\nI think not wise to use a weapon if not needed, command ignored");
				}else{
					item.effect(player, log);
					// if used for the first time assign points else nothing
					if(!item.getUsed()){
					
						status.changeScore(USEPOINTS);
					}
					item.setUsed(true);
				
					if (item.getConsumable()) {

						log.info("\nItem " + item.getName() + " removed");
						// remove the item from player's inventory
						player.getPlayerItems().remove(item);
						player.getPlayerInventory().setFreeWeight(player.getPlayerInventory().getFreeWeight() + item.getWeight());
					}
				}

				// If warp used push a position in status
				if (item instanceof Warp) {
					status.pushStatus(player);
				}else{
					if(item instanceof Bag){
						player.setBagUsed(true);
					}
				}
			}
		}
	}catch (ConcurrentModificationException a) {
		// iteration stop because the content of this inventory changed while iterates
	}
		return temp != null;

	}

	/**
	 * drop a item from player's inventory to current room's
	 * 
	 * @param command
	 *            A command word witch indicates to drop and what item to drop
	 */

	private void dropItem(Command command) {

		boolean presence = false; // indicates if the object to drop is present
									// in player inventory

		try {

			for (GeneralItem item : player.getPlayerItems()) {

				if (item.getName().contains(command.getSecondWord())) {

					// sets how much space is present in inventory
					player.getPlayerInventory().setFreeWeight(
							player.getPlayerInventory().getFreeWeight()
									+ item.getWeight());
					// inserts the item in room's inventory
					player.getPlayerRoom().addRoomInventory(item);
					log.info("You are droping the item: " + item.getName() + " inside " + player.getPlayerRoom().getName());
					// remove the item from player's inventory
					player.getPlayerItems().remove(item);
					presence = true;
				}
			}
		} catch (ConcurrentModificationException a) {
			// iteration stop because the content of this inventory changed while iterates
		}
		if (presence) {
			// push the player' inventory in a stack containing inventories
			status.getPlayerInventories().push(
			player.clonePlayerInventory(player.getPlayerInventory()));
		}else{
			log.info("You don't have this object in your inventory");
		}

	}

	/**
	 * take's an object from a room's inventory and puts it inside player's
	 * inventory
	 * 
	 * @param command
	 *            : name of the item to search inside room's inventory
	 */
	private void takeItem(Command command) {

		boolean presence = false; // indicates if the object is present in room

		try {

			for (GeneralItem item : player.getPlayerRoom().getRoomItems()) {

				// control to see if player have enough free space to insert the
				// item in inventory
				if (!(player.getPlayerInventory().getFreeWeight()
						- item.getWeight() >= 0)) {
					log.info("You not gave enough free space in your inventory");
					return;
				}
				if ((item.getName()).contains(command.getSecondWord())
						&& item.getPick()) {

					// sets how much space is present in inventory
					player.getPlayerInventory().setFreeWeight(
							player.getPlayerInventory().getFreeWeight()
									- item.getWeight());
					// inserts new the item from room to playerInventory
					player.insertIntoInventory(item);
					log.info("You are taking the item: " + item.getName() + " from " + player.getPlayerRoom().getName());
					// remove the item from room
					player.getPlayerRoom().getRoomItems().remove(item);
					presence = true;
				}

			}
		} catch (ConcurrentModificationException a) {
			// iteration stop because the content of this inventory changed while iterates
		}
		if (!presence) {
			log.info("Object not present in room or cannot pick it up");
		}
	}
	
	/**
	 * calculates the infection level and show a message
	 * 
	 */
	
	private void infectionStatus (){
		
		if(player.getInfectedMovements() > LEVEL1){
			log.info("\nyou feel like a headache...\n");
		}else{
			if(player.getInfectedMovements() > LEVEL2){
				log.info("\nyou're thirsty and you feel weak\n");
			}else{
				if(player.getInfectedMovements() > LEVEL3){
					log.info("\nyour flesh deteriorates and you feel the need to eat and eat\n");
				}
			}
		}
	}

	/**
	 * Try to go in one direction. If there is an exit, enter the new room,
	 * otherwise print an error message.
	 */
	private void goRoom(Command command) {

		String direction = command.getSecondWord();

		// Try to leave current room.
		Room nextRoom = (player.getPlayerRoom()).getExit(direction);

		if (nextRoom == null) {
			log.info("There is no door!\n");
			log.info((player.getPlayerRoom()).getLongDescription());
			return;
		}
		if (!nextRoom.getOpen()) {
			log.info("Door closed you must use a kind of key to open it");
			return;
		} else {

			// update new current player room
			player.setPlayerRoom(nextRoom);
			// push this status
			status.pushStatus(player);
			
			// movement penality
			status.changeScore(MOVEMENTPOINTS);
			
			if(player.getInfected() && player.getInfectedMovements() > 0){
				player.decreaseInfectedMovements();
				log.info("You are infected and can move other " + player.getInfectedMovements() + " times");
				infectionStatus();
			}else{
				if(player.getInfectedMovements() <= 0){
					log.info("You lose because becamed a zombie...\n\t GAME OVER");
					player.setDead(true);
				}
				
			}
			
			// in this room is lecher
			roomInfected(lecher);
			
			// the lecher moves
			if (mainframeStatus.getSwitchedOff()) {
				lecher.zombieMove(lecher);
			}

			// in this room is zombie1
			roomInfected(zombie1);
			// in this room is zombie2
			roomInfected(zombie2);
			// in this room is zombie3
			roomInfected(zombie3);
			// in this room is zombie4
			roomInfected(zombie4);
			// in this room is lecher
			roomInfected(lecher);

			if (lecher.getDead() && player.getPlayerRoom().getName().equals("library")) {
				status.setWin(true);
				log.info("\nYou WIN!!!\n");
				log.info("\nYou score is: " + status.getScore() + " points\n");
			}
		}
		if(!player.getDead()){
			
		log.info((player.getPlayerRoom()).getLongDescription());
		}
	}

	/**
	 * controls if in this room is a zombie
	 * 
	 * @param zombie
	 *            zombie present
	 */

	private void roomInfected(Zombie zombie) {

		if (player.getPlayerRoom().equals(zombie.getZombieRoom())
				&& !zombie.getDead()) {

			boolean presence = false;
			log.info("In this room is a zombie, if you have a weapon can kill it if not you will die\n");
			try{
				for (GeneralItem item : player.getPlayerItems()) {

					if (item instanceof Weapon) {
						item.effect(player, log);
						zombie.setDead(true);
						presence = true;
						status.changeScore(KILLPOINTS);
						// create a random boolean value
						Random random = new Random();
						// set true or false to variable infected
						player.setInfected(random.nextBoolean());
						if(player.getInfected()){
							log.info("This zombie bit you and now you're infected\n");
						}
					}
				}
			} catch (ConcurrentModificationException a){
				// iterate stops because the used weapon modified the number of items inside player's inventory
			}

			if (!presence) {

				// lose condition :a zombie killed you because you don't have a
				// weapon
				log.info("The zombie killed you because you don't have a weapon. EPIC FAIL!!!");
				log.info("\nYou score is: " + status.getScore() + " points\n");
				player.setDead(true);

			} else {
				// if you have the weapon and kill lecher you win else you
				// killed a static zombie
				if (presence && lecher.getDead()) {
					log.info("You killed lecher... now you must escape from hive, go in Library to win \n");
				}
			}
		}
	}

	/**
	 * "Quit" was entered. Check the rest of the command to see whether we
	 * really quit the game.
	 * 
	 * @return true, if this command quits the game, false otherwise.
	 */
	private boolean quit(Command command) {
		if (command.hasSecondWord()) {
			log.info("Quit what?");
			return false;
		} else {
			return true; // signal that we want to quit
		}
	}
	
	/**
	 * calculate the free space to assign when undo
	 * 
	 * @return A integer that is the current free space after undo
	 */

	private int calculateFreeSpace(){
		
		int freeSpace;
		if(player.getBagUsed()){
			freeSpace = FREESPACEBAG;
		}else{
			freeSpace = FREESPACE;
		}
		
		for(GeneralItem item : player.getPlayerItems()){
			
			freeSpace = freeSpace - item.getWeight();
		}
		
		return freeSpace;
	}
	
	/**
	 * this method is used to go back by one step
	 * 
	 */

	private void goBack() {
		
			if(player.getPlayerRoom().equals(zombie1.getZombieRoom())){
				zombie1.setDead(false);
			}else{
				if(player.getPlayerRoom().equals(zombie2.getZombieRoom())){
					zombie2.setDead(false);
				}else{
					if(player.getPlayerRoom().equals(zombie3.getZombieRoom())){
						zombie3.setDead(false);
					}else{
						if(player.getPlayerRoom().equals(zombie4.getZombieRoom())){
							zombie4.setDead(false);
						}
					}
				}
			}
				
			log.info("Back penality: items you have used don't increase score any more\n");
			// sets playerInventory with the last element of the
			// playerInventories in status
			player.setPlayerInventory(status.getPlayerInventories().peek());
			// calculate the free space
			player.getPlayerInventory().setFreeWeight(calculateFreeSpace());
			// sets the previous score
			status.removePreviousScores();
			status.setScore(status.getPreviousScores());
			// sets room's inventory as it was when entered in the room
			player.getPlayerRoom().setRoomInventory(status.getRoomInventories().peek());
			// in status cancel the last element in room's inventories
			status.getRoomInventories().pop();
			// in status cancel the last element in playerPath
			status.getPlayerPath().pop();
			// setting last element of playerPath as current room
			player.setPlayerRoom(status.getPlayerPath().peek());
			log.info(player.getPlayerRoom().getLongDescription());
	}

	/**
	 * this method is used to start the game
	 */
	public static void main(String[] args) {

		Game game = new Game();
		game.play();

	}
}
