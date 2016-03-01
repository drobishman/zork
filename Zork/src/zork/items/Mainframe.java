package zork.items;

import zork.items.GeneralItem;
import zork.logger.Log;
import zork.characters.Player;
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

public class Mainframe extends GeneralItem {
	
	private boolean switchedOff;
	
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
	
	public Mainframe (String name, String description, boolean pick, boolean consumable, int weight, boolean switchedOff){
		
		super(name, description ,pick, consumable, weight);
		setSwitchedOff(switchedOff);
	}
	
	/**
	 * sets if switchedOff on true or false
	 * 
	 * @param switchedOff a boolean value
	 */
	
	private void setSwitchedOff(boolean switchedOff){
		
		this.switchedOff = switchedOff;
	}
	
	/**
	 * gets true or false if the mainframe is switched off or not
	 * 
	 * @return boolean value
	 */
	
	public boolean getSwitchedOff(){
		
		return this.switchedOff;
	}
	
	/**
	 * Mainframe' effect
	 * 
	 * @param player A player of the game
	 * @param log A logger
	 */
	
	@Override
	public void effect(Player player, Log log) {
		
		// Mainframe's effect
    	if(getName().equals("mainframe")){
		log.info("\nShows the hologram of a girl (Queen) who tells you not to turn off the mainframe"
		+"\nYour actual mission is to save Hive's staff, and the Queen keeps them lock"
		+"\nYou decide to turn off the Queen"
		+"\nWhile the Queen is turning off, genereates some access codes batter take them");
		
		setSwitchedOff(true);
		
		// create a list of codes and insert it in player's inventory
			GeneralItem codes;
			codes = new Codes("codes","Codes used:\n", true ,false, 1);
			player.getPlayerInventory().addItem(codes);
			player.getPlayerInventory().setFreeWeight(player.getPlayerInventory().getFreeWeight()-1);
    	}
	}
}