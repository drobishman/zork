package zork.items;

import zork.logger.*;
import zork.characters.Player;
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
public class Item extends GeneralItem {
	
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
	
	public Item (String name, String description, boolean pick, boolean consumable, int weight){
		
		super(name, description ,pick, consumable, weight);
	}
	
	/**
	 * 
	 * the effect of item
	 */
	@Override
	public void effect(Player player, Log log){
		
		// do nothing
	}
}