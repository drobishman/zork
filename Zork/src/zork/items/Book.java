package zork.items;

import zork.items.GeneralItem;
import zork.logger.*;
import zork.characters.Player;
/**
 * 
 * Class Book : initialize a Book to use in the game
 * 
 *  This class is part of the "Zork" application. 
 * "Zork" is a very simple, text based adventure game.
 * 
 *  The Book is used to have informations how to access to the Hive
 * 
 * @author Adrian
 * @version 21.05.2012
*/

public class Book extends GeneralItem {
	
	/**
	 * 
	 * creates an object of type book that contains a Book
	 * 
	 * @param name A string that is the name of the item
	 * @param description A string that is a description of the item and his effect
	 * @param pick A boolean meaning if the item can be picked or not
	 * @param consumable A boolean meaning if after use consummates
	 * @param weight A integer that is the weight of the item
	 */
	
	public Book (String name, String description, boolean pick, boolean consumable, int weight){
		
		super(name, description ,pick, consumable, weight);
	}

	/**
	 * Book's effect
	 * 
	 * @param player A player of the game
	 * @param log A logger
	 */
	
	@Override
	
	public void effect(Player player, Log log) {
		
			// create a key and insert it in player's inventory
			GeneralItem card;
			card = new Card("card","Using this card you have ", true ,false, 1);
			player.getPlayerInventory().addItem(card);
			player.getPlayerInventory().setFreeWeight(player.getPlayerInventory().getFreeWeight()-1);
	}
}
