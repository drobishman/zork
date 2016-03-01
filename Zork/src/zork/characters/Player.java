package zork.characters;

import java.util.List;

import zork.themap.Room;
import zork.items.Inventory;
import zork.items.GeneralItem;
import zork.logger.Log;

/**
 * Class Player - a player in an adventure game.
 *
 * This class is part of the "Zork" application. 
 * "Zork" is a very simple, text based adventure game.  
 *
 * A "player" is a character identified as player witch decides the hole story of the game
 * 
 * @author  Drob Adrian Mihai
 * @version 06.05.2012
 */

public class Player extends Character {

	private Room playerRoom;
	private Inventory playerInventory;
	private static final int INFECTEDMOVEMENTS = 7;
	private boolean bagUsed;
	
	/**
	 * creates a player for a game
	 * 
	 * @param name
	 */
	
	public Player (String name){
		
		super(name);
		playerInventory = new Inventory();
		setInfected(false);
		setInfectedMovements(INFECTEDMOVEMENTS);
	}
	
	/**
	 * gets the boolean value bagUsed
	 * 
	 * @return a boolean value
	 */
	
	public boolean getBagUsed (){
		
		return this.bagUsed;
	}
	
	/**
	 * sets true when bag used
	 * 
	 * @param bagUsed a boolean value
	 */
	
	public void setBagUsed (boolean bagUsed){
		
		this.bagUsed = bagUsed;
	}
	
	/**
	 * 
	 *  Clone the current inventory of a player 
	 * 
	 * @param playerInventory current player's inventory
	 * @return a clone of the current  inventory
	 */
	
	public Inventory clonePlayerInventory(Inventory playerInventory){
		
		Inventory clonedPlayerInventory;
		clonedPlayerInventory = new Inventory();
		clonedPlayerInventory.setInventory(Inventory.cloneInventory(playerInventory.getInventory()));
		return clonedPlayerInventory;
		
	}
	
	/**
	 * sets the initial player's room
	 * 
	 * @param playerInventory the current player's room
	 */

	public void setPlayerInventory(Inventory playerInventory){
		
		this.playerInventory = playerInventory;
	}
	
	
	
	
	/**
	 * inserts a item in inventory
	 * 
	 * @param item is a item to insert 
	 */
	
	public void insertIntoInventory(GeneralItem item){
		
		playerInventory.addItem(item);
	}
	
	/**
	 * shows what contains the inventory of player
	 * 
	 */
	
	public void showPlayerInventory(Log log){
		
		log.info("Your inventory contains:  ");
		
		playerInventory.showItems(log);
	}
	
	/**
	 * gets the current player's room
	 * 
	 * @return playerRoom A room
	 */
	
	public Room getPlayerRoom(){
		
		return this.playerRoom;
	}
	
	/**
	 * sets the initial player's room
	 * 
	 * @param playerRoom the current player's room
	 */

	public void setPlayerRoom(Room playerRoom){
		
		this.playerRoom = playerRoom;
	}
	
	/**
	 * gets a vector containing player's items
	 * 
	 * @return a vector containing items
	 */
	
	public List <GeneralItem> getPlayerItems(){
		
		return playerInventory.getInventory();
	}
	
	/**
	 * gets player's inventory
	 * 
	 * @return a inventory
	 */
	
	public Inventory getPlayerInventory(){
		
		return playerInventory;
		
	}
    
}
