package zork.items;

import zork.items.GeneralItem;
import zork.logger.*;
import zork.characters.Player;

/**
 * 
 * Class Antidote : initialize a Antodote
 * 
 *  This class is part of the "Zork" application. 
 * "Zork" is a very simple, text based adventure game.
 * 
 * this antidote will cure you from infection if used in time
 * 
 * @author Adrian
 * @version 21.05.2012
*/

public class Antidote extends GeneralItem {
	
	private static final int INFECTEDMOVEMENT = 7;
	
	/**
	 * 
	 * creates an object of type Antidote
	 * 
	 * @param name A string that is the name of the item
	 * @param description A string that is a description of the item and his effect
	 * @param pick A boolean meaning if the item can be picked or not
	 * @param consumable A boolean meaning if after use consummates
	 * @param weight A integer that is the weight of the item
	 */
	
	public Antidote (String name, String description, boolean pick, boolean consumable, int weight){
		
		super(name, description ,pick, consumable, weight);
	}
	
	/**
	 * the effect of antidote
	 * 
	 * @param player A player of the game
	 * @param log A Logger
	 */

	@Override
	public void effect(Player player, Log log) {
				
		player.setInfected(false);
		player.setInfectedMovements(INFECTEDMOVEMENT);
		
	}
}