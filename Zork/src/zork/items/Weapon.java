package zork.items;

import zork.characters.Player;
import zork.logger.Log;

/**
 * 
 * Class Weapon : initialize a weapon to use in the game
 * 
 *  This class is part of the "Zork" application. 
 * "Zork" is a very simple, text based adventure game.
 * 
 * The weapon is used to kill the enemy and it is your primary objective 
 * 
 * @author Adrian
 * @version 02.05.2012
 *
 */
public class Weapon extends Item {
	
	private int shoots;
	
	/**
	 * 
	 * creates an object of type weapon with which you can kill "kills" the enemies
	 * 
	 * @param name A name of type string
	 * @param description A description of type string
	 * @param pick A boolean value
	 * @param consumable A boolean Value
	 * @param weight A integer meaning his weight
	 * @param shoots A integer meaning its shoots
	 */
	
	public Weapon (String name, String description, boolean pick, boolean consumable, int weight, int shoots){
		super(name, description ,pick, consumable, weight);
		setShoots(shoots);
	}
	
	/**
	 * gets the number of remaining shoots
	 * 
	 * @return A integer
	 */
	
	public int getShoots(){
		
		return this.shoots;
	}
	
	/**
	 * set how many shoots has this weapon
	 * 
	 * @param shoots number of shoots
	 */
	
	private void setShoots(int shoots){
		
		this.shoots = shoots;
	}
	
	/**
	 * the effect of object weapon
	 * 
	 * @param player a Game player
	 * @param log A logger
	 */

	@Override
	public void effect(Player player, Log log) {
		
		// decrement number if shoots
		setShoots(getShoots()-1);
		
		//if number of shoots <= 0 will be cancelled from inventory
		if(getShoots() <= 0 && getConsumable()){
			// remove it from inventory because broken
			log.info("The " + getName() + " finished amo or simply broken\n");
			player.getPlayerItems().remove(this);
			player.getPlayerInventory().setFreeWeight(player.getPlayerInventory().getFreeWeight()+getWeight());
		}
	}
}
