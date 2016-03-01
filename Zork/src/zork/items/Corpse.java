package zork.items;

import zork.items.GeneralItem;
import zork.characters.Player;
import zork.logger.*;
/**
 * 
 * Class Book : initialize a Corpse to use in the game
 * 
 *  This class is part of the "Zork" application. 
 * "Zork" is a very simple, text based adventure game.
 * 
 *  The the corpse
 * 
 * @author Adrian
 * @version 21.05.2012
*/

public class Corpse extends GeneralItem {
	
	private boolean usedKey1 = false;
	private boolean usedFinger = false;
	
	/**
	 * 
	 * creates an object of type Corpse that contains a Key
	 * 
	 * @param name A string that is the name of the item
	 * @param description A string that is a description of the item and his effect
	 * @param pick A boolean meaning if the item can be picked or not
	 * @param consumable A boolean meaning if after use consummates
	 * @param weight A integer that is the weight of the item
	 */
	
	public Corpse (String name, String description, boolean pick, boolean consumable, int weight){
		
		super(name, description ,pick, consumable, weight);
	}

	/**
	 * Corpse effect
	 * 
	 * @param player A player of the game
	 * @param log A logger
	 */
	
	@Override
	
	public void effect(Player player, Log log) {
		
		
		if(player.getPlayerRoom().getName().equals("security") && !usedKey1){
			// create a key and insert it in player's inventory
			GeneralItem key1;
			key1 = new Key("guardkey","You used the guardkey", true ,false, 1);
			player.getPlayerInventory().addItem(key1);
			usedKey1 = true;
		}
		if(player.getPlayerRoom().getName().equals("closet") && !usedFinger){
			GeneralItem finger;
			finger = new Card("finger", "Tou have used this finger with fingerprint scanner ", true, false,1);
			player.getPlayerInventory().addItem(finger);
			usedFinger = true;
			}
		
		player.getPlayerInventory().setFreeWeight(player.getPlayerInventory().getFreeWeight()-1);
	}
}