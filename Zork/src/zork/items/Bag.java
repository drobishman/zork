package zork.items;

import zork.items.GeneralItem;
import zork.logger.*;
import zork.characters.Player;

/**
 * 
 * Class Bag : initialize a bag that increase your inventory by 5 points
 * 
 *  This class is part of the "Zork" application. 
 * "Zork" is a very simple, text based adventure game.
 * 
 * The bag will increase your inventory
 * 
 * @author Adrian
 * @version 21.05.2012
*/

public class Bag extends GeneralItem {
	
	private static final int EXTENDEDWEIGHT = 6;
	
	/**
	 * 
	 * creates an object of type bag that increase player inventory
	 * 
	 * @param name A string that is the name of the item
	 * @param description A string that is a description of the item and his effect
	 * @param pick A boolean meaning if the item can be picked or not
	 * @param consumable A boolean meaning if after use consummates
	 * @param weight A integer that is the weight of the item
	 */
	
	public Bag (String name, String description, boolean pick, boolean consumable, int weight){
		
		super(name, description ,pick, consumable, weight);
	}
	
	/**
	 * the effect of the bag is increase freeweight
	 * 
	 * @param player A player of the game
	 * @param log A logger
	 */
	
	@Override

	public void effect(Player player, Log log) {
				
		player.getPlayerInventory().setFreeWeight(player.getPlayerInventory().getFreeWeight()+EXTENDEDWEIGHT);
		player.getPlayerItems().remove(this);
		player.getPlayerInventory().setFreeWeight(player.getPlayerInventory().getFreeWeight()-getWeight());
		
	}
}