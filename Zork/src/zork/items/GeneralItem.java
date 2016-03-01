package zork.items;

import zork.characters.Player;
import zork.logger.Log;

/**
 *  Class Item - initialize a item used in this game
 *  
 * This class is part of the "Zork" application. 
 * "Zork" is a very simple, text based adventure game.
 * 
 * An "Item" is an object that can be used in the game. This items can be used 
 * or not, you can pick them and use or only pick and use after and only use. Every item has
 *  a name, description, if you can pick them or not if is a consumable or not and their weight.
 * 
 * @author Adrian
 * @version 27.04.2012
 */
public abstract class GeneralItem {
	
	private String name;
	private String description;
	private boolean pick;
	private boolean consumable;
	private int weight;
	private boolean used;
	
	/**
	 * creates an object of type item that has a name "name", description "description",
	 * which can be picked or consumed, which has a weight "weight"
	 * 
	 * @param name A string that is the name of the item
	 * @param description A string that is a description of the item and his effect
	 * @param pick A boolean meaning if the item can be picked or not
	 * @param consumable A boolean meaning if after use consummates
	 * @param weight A integer that is the weight of the item
	 */
	
	public GeneralItem (String name, String description, boolean pick, boolean consumable, int weight){
		
		setName(name);
		setDescription(description);
		setPick(pick);
		setConsumable(consumable);
		setWeight(weight);
	}
	
	/**
	 * gets the boolean value used
	 * 
	 * @return a boolean value
	 */
	
	public boolean getUsed (){
		
		return this.used;
	}
	
	/**
	 * sets to a item used or not
	 * 
	 * @param used a boolean value
	 */
	
	public void setUsed (boolean used){
		
		this.used = used;
	}
	
	
	/**
	 * sets the name of a item
	 * 
	 * @param name to asign
	 */
	
	private void setName(String name){
		
		this.name = name;
	}
	
	/**
	 * sets the description
	 * 
	 * @param description to assign
	 */
	
	private void setDescription(String description){
		
		this.description = description;
	}
	
	/**
	 * sets if can be picked
	 * 
	 * @param pick if true the item can be picked up
	 */
	
	private void setPick(boolean pick) {
		
		this.pick = pick;
	}
	
	
	/**
	 * sets if the item can be consumated
	 * 
	 * @param consumable if true the item can be consumated
	 */
	private void setConsumable(boolean consumable){
		
		this.consumable = consumable;
	}
	
	/**
	 * sets the weight of a item 
	 * 
	 * @param weight an integer that indicates the weight
	 */
	
	private void setWeight(int weight){
		
		this.weight = weight;
	}
	
	/**
	 * return a String that contains the name of the object
	 * 
	 * @return object's name
	 */
	
	public String getName (){
		
		return name;
	}
	
	/**
	 * return a String that contains the description of the object
	 * 
	 * @return object's description
	 */
	
	public String getDescription (){
		
		return description;
	}
	
	
	/**
	 *  return true if the item can be picked up
	 * 
	 * @return true if the object can be picked, false otherwise
	 */
	public boolean getPick (){
		
		return pick;
	
	}
	
	
	/**
	 * return true if the item after used disappears from your inventory
	 * 
	 * @return true if the object can be consummate, false otherwise
	 */
	public boolean getConsumable (){
		
		return consumable;
	}
	
	/**
	 * returns the weight of an item
	 * 
	 * @return integer value which is the weight of the object
	 */
	
	public int getWeight (){
		
		return weight;
	}
	
	/**
	 * the effect of GeneralItem
	 * 
	 * @param player A player
	 */
	
	public void effect(Player player, Log log){
		// do nothing
	}
}