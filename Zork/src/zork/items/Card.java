package zork.items;

import zork.items.GeneralItem;
import zork.themap.Room;
import zork.characters.Player;
import zork.logger.Log;
/**
 * 
 * Class Card : initialize a Card that opens the entrance to Hive or weaponsLab
 * 
 *  This class is part of the "Zork" application. 
 * "Zork" is a very simple, text based adventure game.
 * 
 * The Card is used to open Hive's entry or weaponsLab room
 * 
 * @author Adrian
 * @version 21.05.2012
*/

public class Card extends GeneralItem {
	
	/**
	 * 
	 * creates an object of type card that opens a door
	 * 
	 * @param name A string that is the name of the item
	 * @param description A string that is a description of the item and his effect
	 * @param pick A boolean meaning if the item can be picked or not
	 * @param consumable A boolean meaning if after use consummates
	 * @param weight A integer that is the weight of the item
	 */
	
	public Card (String name, String description, boolean pick, boolean consumable, int weight){
		
		super(name, description ,pick, consumable, weight);
	}
	
	/**
	 * the effect of the card of finger
	 * 
	 * @param player A player of the game
	 * @param log A logger
	 */

	@Override
	public void effect(Player player, Log log) {
		
		if(this.getName().equals("card")){
			if(player.getPlayerRoom().getName().equals("station")){
    		
				// unlock the access to the Entry
				Room roomToUnlock;
				roomToUnlock = player.getPlayerRoom().getExit("east");
				roomToUnlock.setOpen(true);
				log.info("unlocked the main gate to " + roomToUnlock.getName() + " at east");
			}else{
				log.info("\nThis item must be used in room: station to open Hive's main gate");
			}
		}else{
			if(this.getName().equals("finger")){
				if(player.getPlayerRoom().getName().equals("security")){
					
					// unlock the access to the Library
					Room roomToUnlock;
					roomToUnlock = player.getPlayerRoom().getExit("northwest");
					roomToUnlock.setOpen(true);
					log.info("and unlocked the door to " + roomToUnlock.getName() + " at northwest");
				}else{
					log.info("\nThis finger must be used in room security with the finger print scanner");
				}
			}
		}
	}
}