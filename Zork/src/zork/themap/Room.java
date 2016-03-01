package zork.themap;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import zork.items.GeneralItem;
import zork.items.Inventory;
import zork.logger.Log;

import java.util.ArrayList;
import java.util.List;



/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "Zork" application. 
 * "Zork" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  For each existing exit, the room 
 * stores a reference to the neighboring room.
 * 
 * @author  Drob Adrian Mihai
 * @version 27.04.2012
 */

public class Room
{
	private String name;
    private String description;
    private Map<String, Room> exits;  // stores exits of this room.
    private Inventory roomInventory;		//stores the items present in the room
    private boolean open;
    
    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String name, String description, boolean open) 
    {
    	this.name = name;
        this.description = description;
        this.open = open;
        exits = new HashMap<String, Room>();
        roomInventory = new Inventory();
    }
    
    /**
     * gets a boolean value
     * 
     * @return if true the room is open else close
     */
    
    public boolean getOpen (){
    	
    	return this.open;
    }
    
    /**
     * set if true if room is open false other
     * 
     * @param open A boolean value
     */
    
    public void setOpen(boolean open){
    	
    	this.open = open;
    }
    
    /**
	 * 
	 *  Clone the current inventory of a room
	 * 
	 * @param roomInventory current room's inventory
	 * @return a clone of the current  inventory
	 */
	
	public Inventory cloneRoomInventory(Inventory roomInventory){
		
		Inventory clonedRoomInventory;
		clonedRoomInventory = new Inventory();
		clonedRoomInventory.setInventory(Inventory.cloneInventory((ArrayList<GeneralItem>)roomInventory.getInventory()));
		return clonedRoomInventory;
		
	}
    
    /**
     * sets a room's name
     * 
     * @param name String that is the name of the room
     */
    
    public void setRoomName (String name){
    	
    	this.name = name;
    }
    
    /**
     * sets a room's description
     * 
     * @param description String that contains the description of the room
     */
    
    public void setRoomDescription(String description){
    	
    	this.description = description;
    }
    

    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor  The room to which the exit leads.
     */
    public void setExits(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }
    
    /**
     * 
     * sets a new inventory to variable room
     * 
     * @param roomInventory The new inventory to assign
     */
    
    public void setRoomInventory (Inventory roomInventory){
    	
    	this.roomInventory = roomInventory;
    }
    
    /**
     * Define the inventory of this room
     * 
     * @param item The item that will be present inside the room
     */
    
    public void addRoomInventory(GeneralItem item){
    	
    	this.roomInventory.addItem(item);
    }
    
    /**
     * returns the inventory of a room
     * 
     * @return an object of type inventory
     */
    
    public Inventory getRoomInventory(){
    	
    	return this.roomInventory;
    	
    }
    
    /**
     * returns the items inside a inventory
     * 
     * @return a vector containing items
     */
    
    public List <GeneralItem> getRoomItems(){
    	
    	return this.roomInventory.getInventory();
    }
    
    /**
     * @return The short description of the room
     * (the one that was defined in the constructor).
     */
    public String getShortDescription()
    {
        return this.description;
    }
    
    /**
     * @return The name of the room
     * (the one that was defined in the constructor).
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * Return a description of the room in the form:
     *     You are in the kitchen.
     *     Exits: north west
     * @return A long description of this room
     */
    public String getLongDescription()
    {
        return "You are " + description + ".\n" + getExitString();
    }

    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     * @return Details of the room's exits.
     */
    public String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * @param direction The exit's direction.
     * @return The room in the given direction.
     */
    public Room getExit(String direction) 
    {
        return exits.get(direction);
        
    }
    
    /**
     * this method shows the room's inventory
     * 
     */
    
    public void showRoomInventory (Room playerRoom, Log log){
    	
    	log.info("The room " + playerRoom.getName() +  " contains:  ");
    	
    	roomInventory.showItems(log);
    }
    
}