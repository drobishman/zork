package zork.items;

import zork.items.GeneralItem;
import zork.logger.*;
import zork.themap.Room;
import zork.characters.Player;
/**
 * 
 * Class Computer : initialize a computer to use in the game
 * 
 *  This class is part of the "Zork" application. 
 * "Zork" is a very simple, text based adventure game.
 * 
 * The computer is used in game to have informations and to gave access to other room
 * 
 * @author Adrian
 * @version 21.05.2012
*/

public class Computer extends GeneralItem {
	
	/**
	 * 
	 * creates an object of type Computer that unlock to go down and gets informations about Hive's status
	 * 
	 * @param name A string that is the name of the item
	 * @param description A string that is a description of the item and his effect
	 * @param pick A boolean meaning if the item can be picked or not
	 * @param consumable A boolean meaning if after use consummates
	 * @param weight A integer that is the weight of the item
	 */
	
	public Computer (String name, String description, boolean pick, boolean consumable, int weight){
		
		super(name, description ,pick, consumable, weight);
	}
	
	/**
	 * Computer's effect
	 * 
	 * @param player A player of the game
	 * @param log A logger
	 */
	
	@Override

	public void effect(Player player, Log log) {
		
		// Computer's effect
    	// unlock the access to the engineroom
		Room roomToUnlock;
		roomToUnlock = player.getPlayerRoom().getExit("down");
		roomToUnlock.setOpen(true);
		log.info("\n\nYou must go to the mainframe, use the elevator to go down ");
	}
}