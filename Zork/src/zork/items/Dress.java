package zork.items;

import zork.items.GeneralItem;
import zork.characters.Player;
import zork.logger.*;
/**
 * 
 * Class Axe : initialize a weapon to use in the game
 * 
 *  This class is part of the "Zork" application. 
 * "Zork" is a very simple, text based adventure game.
 * 
 * The Axe is used to kill the secondary enemies 
 * 
 * @author Adrian
 * @version 21.05.2012
*/

public class Dress extends GeneralItem {
	
	/**
	 * 
	 * creates an object of type weapon with which you can kill "kills" the enemy or not
	 * 
	 * @param name A string that is the name of the item
	 * @param description A string that is a description of the item and his effect
	 * @param pick A boolean meaning if the item can be picked or not
	 * @param consumable A boolean meaning if after use consummates
	 * @param weight A integer that is the weight of the item
	 */
	
	public Dress (String name, String description, boolean pick, boolean consumable, int weight){
		
		super(name, description ,pick, consumable, weight);
	}
	
	/**
	 * Dress effect
	 * 
	 * @param player A player of the game
	 * @param log A logger
	 */
	
	@Override

	public void effect(Player player, Log log) {
		
		
		 // create a key and insert it in player's inventory
		GeneralItem key0;
		key0 = new Key("key","You have used the key ", true, false, 1);	
		player.getPlayerInventory().addItem(key0);
	 	player.getPlayerInventory().setFreeWeight(player.getPlayerInventory().getFreeWeight()-1);
	}
}
