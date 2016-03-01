package zork.items;

import zork.items.GeneralItem;
import zork.logger.Log;
import zork.themap.Room;
import zork.characters.Player;
/**
 * 
 * Class Codes : initialize some codes from mainframe to open doors
 * 
 *  This class is part of the "Zork" application. 
 * "Zork" is a very simple, text based adventure game.
 * 
 * The Codes are used to open some doors (warehouse viralLab...)
 * 
 * @author Adrian
 * @version 21.05.2012
*/

public class Codes extends GeneralItem {
	
	/**
	 * 
	 * creates an object of type Codes used to open rooms
	 * 
	 * @param name A string that is the name of the item
	 * @param description A string that is a description of the item and his effect
	 * @param pick A boolean meaning if the item can be picked or not
	 * @param consumable A boolean meaning if after use consummates
	 * @param weight A integer that is the weight of the item
	 */
	
	public Codes (String name, String description, boolean pick, boolean consumable, int weight){
		
		super(name, description ,pick, consumable, weight);
	}
	
	/**
	 * the effect of the Codes that opens some rooms
	 * 
	 * @param player A player of the game
	 * @param log A logger
	 */
	
	@Override

	public void effect(Player player, Log log) {
				
    		if(player.getPlayerRoom().getName().equals("entry")){
    		// unlock the access to the warehouse and viralLab
 			Room roomToUnlock;
 			roomToUnlock = player.getPlayerRoom().getExit("southeast");
 			roomToUnlock.setOpen(true);
 			log.info(" and unlocked the door to " + roomToUnlock.getName() + " at southeast\n");
 			roomToUnlock = player.getPlayerRoom().getExit("south");
 			roomToUnlock.setOpen(true);
 			log.info(" and unlocked the door to " + roomToUnlock.getName() + " at south");
    		}
    		else{
    			// unlock access to armory and security
    			if(player.getPlayerRoom().getName().equals("engineroom")){
    				
    				Room roomToUnlock;
    	 			roomToUnlock = player.getPlayerRoom().getExit("down");
    	 			roomToUnlock.setOpen(true);
    	 			log.info(" and unlocked the elevator to go down to " + roomToUnlock.getName() + "\n");
    	 			roomToUnlock = player.getPlayerRoom().getExit("northeast");
    	 			roomToUnlock.setOpen(true);
    	 			log.info(" and unlocked the door to " + roomToUnlock.getName() + " at northeast");
    			}
    			else {
    				log.info("\nYou must use this codes when a door is closed but not all dors request codes");
    			}
    		}
	}
}