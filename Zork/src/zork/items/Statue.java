package zork.items;

import zork.items.GeneralItem;
import zork.logger.Log;
import zork.themap.Room;
import zork.characters.Player;
/**
 * 
 * Class Statue : initialize a statue to use in the game
 * 
 *  This class is part of the "Zork" application. 
 * "Zork" is a very simple, text based adventure game.
 * 
 * The Statue is used to open a hidden door to railway
 * 
 * @author Adrian
 * @version 21.05.2012
*/

public class Statue extends GeneralItem {
	
	/**
	 * 
	 * creates an object of type statue 
	 * 
	 * @param name A string that is the name of the item
	 * @param description A string that is a description of the item and his effect
	 * @param pick A boolean meaning if the item can be picked or not
	 * @param consumable A boolean meaning if after use consummates
	 * @param weight A integer that is the weight of the item
	 */
	
	public Statue (String name, String description, boolean pick, boolean consumable, int weight){
		
		super(name, description ,pick, consumable, weight);
	}
	
	/**
	 * statue's effect
	 * 
	 * @param player A player of game
	 * @param log A logger
	 */
	
	@Override

	public void effect(Player player, Log log) {
		
		Room roomToUnlock;
		roomToUnlock = player.getPlayerRoom().getExit("northwest");
		roomToUnlock.setOpen(true);
		log.info("\nTouching statues's nose a hidden door opened to northwest");
	
	}
}
