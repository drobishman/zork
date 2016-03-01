package zork.items;

import zork.items.GeneralItem;
import zork.logger.Log;
import zork.themap.Room;
import zork.characters.Player;
/**
 * 
 * Class Warp : initialize a Warp that teletrasport you to a random room on the map
 * 
 *  This class is part of the "Zork" application. 
 * "Zork" is a very simple, text based adventure game.
 * 
 * This warp teletrasports you to a random room
 * 
 * @author Adrian
 * @version 21.05.2012
*/

public class Warp extends GeneralItem {
	
	private Room teletrasportRoom;
	
	/**
	 * 
	 * creates an object of type warp that teletrasport the player
	 * 
	 * @param name A string that is the name of the item
	 * @param description A string that is a description of the item and his effect
	 * @param pick A boolean meaning if the item can be picked or not
	 * @param consumable A boolean meaning if after use consummates
	 * @param weight A integer that is the weight of the item
	 */
	
	public Warp (String name, String description, boolean pick, boolean consumable, int weight, Room teletrasportRoom){
		
		super(name, description ,pick, consumable, weight);
		setTeletrasportRoom(teletrasportRoom);
		}
	
	/**
	 * get the room where teletrasport
	 * 
	 * @return A room
	 */
	
	public Room getTeletrasportRoom(){
		
		return this.teletrasportRoom;
	}
	
	/**
	 * stets the room where teletrasport
	 * 
	 * @param teletrasportRoom A room
	 */
	
	private void setTeletrasportRoom(Room teletrasportRoom){
		
		this.teletrasportRoom = teletrasportRoom;
	}

	/**
	 * the effect of the warp
	 * 
	 * @param player A player of the game
	 * @param log A logger
	 */
	
	@Override
	
	public void effect(Player player, Log log) {
		
		// sets the new player's room
 		player.setPlayerRoom(teletrasportRoom);
 
 		log.info((player.getPlayerRoom()).getLongDescription());
 		
 		// warp must disappear 
 		
	}
}