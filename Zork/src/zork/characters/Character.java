package zork.characters;

/**
 * Class Character - a caracter in an adventure game.
 *
 * This class is part of the "Zork" application. 
 * "Zork" is a very simple, text based adventure game.  
 *
 * A "character" is could be a player or an enemy of the game
 * 
 * @author  Drob Adrian Mihai
 * @version 06.05.2012
 */

public class Character {
	
	private String name; 
	private boolean dead = false;
	private boolean infected; 
	private int infectedMovements;
	
	/**
	 * creates a object of type of type character that has a name "name" 
	 * 
	 * @param nome Is the name of the object
	 */
	
	public Character(String nome){
		
		setNome(nome);
	}
	
	/**
	 * gets a integer meaning the remaining movements if infected
	 * 
	 * @return A integer that is the number of movements player can do
	 */
	
	public int getInfectedMovements(){
		
		return this.infectedMovements;
	}
	
	/**
	 * 
	 *  decrease the number of infected movements
	 */
	
	public void decreaseInfectedMovements(){
		
		this.infectedMovements --;
	}
	
	/**
	 * sets the number of infected movements you can do
	 * 
	 * @param infectedMovements A integer value
	 */
	
	public void setInfectedMovements(int infectedMovements){
		
		this.infectedMovements = infectedMovements;
	}
	
	/**
	 * gets a Boolean value that indicates if player is infected or not
	 * 
	 * @return A boolean value
	 */
	
	public boolean getInfected(){
		
		return this.infected;
	}
	
	/**
	 * sets if a player is infected or not
	 * 
	 * @param infected A boolean value
	 */
	
	public void setInfected(boolean infected){
		
		this.infected = infected;
	}
	
	/**
	 * Sets the name of the Character
	 * 
	 * @param name Contains the name of the Character
	 */
	
	private void setNome(String name){
		
		this.name = name;
	}
	
	/**
	 * get a string value
	 * 
	 * @return A String value
	 */
	
	public String getName (){
		
		return this.name;
	}

	/**
	 * sets if dead or alive
	 * 
	 * @param dead A boolean value, if true the player is dead
	 */
	
	public void setDead (boolean dead){
		
		this.dead = dead;
	}
	
	/**
	 * get a boolean value
	 * 
	 * @return A boolean value, if true the player is dead
	 */
	
	public boolean getDead (){
		
		return this.dead;
	}
	
}
