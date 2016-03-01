package zork.characters;

import zork.themap.Room;

import java.util.ArrayList;
import java.util.Random;

/**
 * Class Zombie - a zombie in an adventure game.
 *
 * This class is part of the "Zork" application. 
 * "Zork" is a very simple, text based adventure game.  
 *
 * A "zombie" is a character identified as zombie don't move between room but kills you if don't have a weapon
 * 
 * @author  Drob Adrian Mihai
 * @version 06.05.2012
 */

public class Zombie extends Character {
	
	private static final int FIRST = 0, LAST = 9;
	private Room zombieRoom;
	
	/**
	 * create a zombie
	 * 
	 * @param nome name of the zombie
	 * @param zombieRoom Is the position of the zombie
	 */
	
	public Zombie (String nome, Room zombieRoom, boolean dead){
		
		super(nome);
		setZombieRoom(zombieRoom);
		setDead(dead);
	}
	
	
	/**
	 * sets the position of the zombie
	 * 
	 * @param zombieRoom A room to assign
	 */

	private void setZombieRoom (Room zombieRoom){
		
		this.zombieRoom = zombieRoom;
	}
	
	/**
	 * get Zombie current room
	 * 
	 * @return A room
	 */
	
	public Room getZombieRoom(){
		
		return this.zombieRoom;
	}
	
	/**
	 * a movement of the zombie
	 * 
	 * @param zombie a object of type Zombie
	 */
	
	public void zombieMove(Zombie zombie){
		
		// array containing directions
		ArrayList <String> directions;
		directions = new ArrayList <String>();
		directions.add("east");
		directions.add("west");
		directions.add("south");
		directions.add("north");
		directions.add("northeast");
		directions.add("southeast");
		directions.add("northwest");
		directions.add("southwest");
		directions.add("up");
		directions.add("down");
		
		// generates a direction
		int directionId,  first = FIRST, last = LAST - first;
		Random random = new Random();
		directionId = (random.nextInt(last)+first);
		
		boolean flag = false;
		
		while(!flag){
			
			if(zombie.getZombieRoom().getExit(directions.get(directionId)) == null){
				
				// generate a new directionId
				directionId = (random.nextInt(last)+first);
			}else{
				
				// if direction gets to a valid room, the current room will be replaced by it 				
				Room nextRoom;
				nextRoom = zombie.getZombieRoom().getExit(directions.get(directionId));
				zombie.setZombieRoom(nextRoom);	
				flag = true;
			}
		}
	}
}
