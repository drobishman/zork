package zork.items;

import zork.items.GeneralItem;
import zork.logger.Log;
import zork.themap.Room;
import zork.characters.Player;
/**
 * 
 * Class Key : initialize a Key that opens the access to library of armory
 * 
 *  This class is part of the "Zork" application. 
 * "Zork" is a very simple, text based adventure game.
 * 
 * This Key opens the door to library or armory
 * 
 * @author Adrian
 * @version 21.05.2012
*/

public class Key extends GeneralItem {
	
	
	/**
	 * 
	 * creates an object of type key that opens a door
	 * 
	 * @param name A string that is the name of the item
	 * @param description A string that is a description of the item and his effect
	 * @param pick A boolean meaning if the item can be picked or not
	 * @param consumable A boolean meaning if after use consummates
	 * @param weight A integer that is the weight of the item
	 */
	
	public Key (String name, String description, boolean pick, boolean consumable, int weight){
		
		super(name, description ,pick, consumable, weight);
	}
	
	/**
	 * the effect of the key
	 * 
	 * @param player A player of the game
	 * @param log A logger
	 */
	
	@Override

	public void effect(Player player, Log log) {
		
 		if(player.getPlayerRoom().getName().equals("bedroom")){
 			
 		// unlock the access to the Library
		Room roomToUnlock;
 		roomToUnlock = player.getPlayerRoom().getExit("east");
 		roomToUnlock.setOpen(true);
 		log.info("and unlocked the door to " + roomToUnlock.getName() + " at east");
 		} else{
 			if(player.getPlayerRoom().getName().equals("security")){
 				
 				// unlock the access to the Library
 				Room roomToUnlock;
 		 		roomToUnlock = player.getPlayerRoom().getExit("southeast");
 		 		roomToUnlock.setOpen(true);
 		 		log.info("and unlocked the door to " + roomToUnlock.getName() + " at southeast" );
 			} else{
 				log.info("\nThis item must be used in the right room");
 			}
 		}
	}
}