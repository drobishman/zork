package zork.items;

import java.util.List;
import java.util.ArrayList;
import zork.logger.Log;


/**
 * 
 * Class Inventory : initialize a inventory to use in the game
 * 
 *  This class is part of the "Zork" application. 
 * "Zork" is a very simple, text based adventure game.
 * 
 * the inventory is used to carry items and can be used by class room and player 
 * 
 * @author Adrian
 * @version 02.05.2012
 * 
 */

public class Inventory {
	
	private static final int FREEWEIGHT = 10;
	private List <GeneralItem> inventory;
	private int freeWeight;
	
	/**
	 * creates an inventory
	 * 
	 */
	public Inventory (){
		inventory = new ArrayList <GeneralItem>();
		freeWeight = FREEWEIGHT;
		
	}
	
	/**
	 * set to inventory a new inventory
	 * 
	 * @param inventory A inventory to assign
	 */
	
	public void setInventory (List <GeneralItem> inventory){
		
		this.inventory = inventory;
		
	}
	
	/**
	 * clone the ArrayList containing items
	 * 
	 * @param list A List to make a clone
	 * @return list A cloned list
	 */
	
	public static List <GeneralItem> cloneInventory (List <GeneralItem> list){
				
		return new ArrayList<GeneralItem>(list);
	}
	
	/**
	 * sets the player's inventory free weight
	 * 
	 * @param freeWeight player's inventory free weight
	 */
	
	public void setFreeWeight (int freeWeight){
		
		this.freeWeight = freeWeight;
	}
	
	/**
	 *  get's the weight limit
	 * 
	 * @return int that indicates the weight limit
	 */
	
	public int getFreeWeight(){
		
		return freeWeight;
	}
	
	 /**
     * Define the inventory of this player
     * 
     * @param item The item that will be add to players's inventory
     */
    
    public void addItem(GeneralItem item){
    	
    	this.inventory.add(item);
    }
    
    /**
     * get's the vector inventory
     * 
     * @return a vector containing items
     */
    
    public List <GeneralItem> getInventory(){
    	
    	return inventory;
    }
    
   /**
    * shows on video the items that are present inside vector 
    * 
    */
    
    public void showItems (Log log){
    	
    	if(this.inventory.isEmpty()){
    		log.info(" nothing");
    	}
    	
    	for(GeneralItem item : this.inventory){
    		
    		log.info(item.getName()+" ");
    	}
    }

}
