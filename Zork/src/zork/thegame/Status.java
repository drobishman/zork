package zork.thegame;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
import zork.characters.Player;
import zork.items.Inventory;
import zork.themap.Room;
/**
 * Class Status - the status o entire game play
 *
 * This class is part of the "Zork" application. 
 * "Zork" is a very simple, text based adventure game.  
 *
 * This status will contain path, all previus player inventories and the inventories of all visited rooms
 * 
 * @author  Drob Adrian Mihai
 * @version 06.05.2012
 */

public class Status implements Cloneable {
	
	private Stack <Room> playerPath;
	private Stack <Inventory> playerInventories;
	private Stack <Inventory> roomInventories;
	private boolean win = false;
	private int score = 0;
	private List <Integer> previousScores;
	
	/**
	 * creates a new status
	 * 
	 */
	
	public Status(){

		this.playerPath = new Stack <Room>();
		this.playerInventories = new Stack <Inventory>();
		this.roomInventories = new Stack <Inventory>();
		this.previousScores = new ArrayList <Integer>();
	}
	
	/**
	 * gets a integer value that is the previous score of the player
	 * 
	 * @return A integer
	 */
	
	public int getPreviousScores(){
		
		return this.previousScores.get(previousScores.size()-1);
	}
	
	/**
	 * add a score
	 * 
	 * @param previousScores A integer
	 */
	
	public void addPreviousScores(int previousScores){
		
		this.previousScores.add(previousScores);
	}
	
	/**
	 * remove a score
	 * 
	 */
	
	public void removePreviousScores(){
		
		this.previousScores.remove(previousScores.size()-1);
	}
	
	/**
	 * increases the score
	 * 
	 * @param score Is a integer to add at score
	 */
	
	public void changeScore(int score){
		
		this.score = this.score +score;
	}
	
	/**
	 * gets true if win
	 * 
	 * @return A boolean value
	 */
	
	public boolean getWin () {
		
		return this.win;
	}
	
	/**
	 * sets true if player killed lecher
	 * 
	 * @param win A boolean value
	 */
	
	public void setWin (boolean win){
		
		this.win = win;
	}
	
	/**
	 * gets the score
	 * 
	 * @return A int that is the score
	 */
	
	public int getScore () {
		
		return this.score;
	}
	
	/**
	 * sets to score a new value
	 * 
	 * @param score a integer to assign
	 */
	
	public void setScore(int score){
		
		this.score = score;
	}
	
	/**
     * returns a stack containing room's inventories
     * 
     * @return a stack containing inventories
     */
    
    public Stack <Inventory> getRoomInventories(){
    	
    	return this.roomInventories;
    }
    
    /**
	 * returns the stack containing inventories
	 * 
	 * @return a stack of inventories
	 */
	
	public Stack<Inventory> getPlayerInventories(){
		
		return this.playerInventories;
	}
	
	/**
	 * returns a stack containing all previous room
	 * 
	 * @return a stack of rooms
	 */
	
	public Stack<Room> getPlayerPath(){
		
		return this.playerPath;
		
	}
	
	/**
	 * This method push a status 
	 * 
	 * @param player a player of the game
	 */
	
	public void pushStatus(Player player){
		
		//this is the previous score
		addPreviousScores(score);
		 // push the reference to current player room
        getPlayerPath().push(player.getPlayerRoom()); 
        // push the room inventory into inventories stack
        getRoomInventories().push(player.getPlayerRoom().cloneRoomInventory(player.getPlayerRoom().getRoomInventory()));
        // push the player' inventory in a stack containing inventories
        getPlayerInventories().push(player.clonePlayerInventory(player.getPlayerInventory()));
	}
}
