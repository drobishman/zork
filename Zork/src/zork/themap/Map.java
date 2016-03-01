package zork.themap;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import zork.themap.MapCostants;
import zork.themap.Room;

import zork.items.Antidote;
import zork.items.Bag;
import zork.items.Book;
import zork.items.Computer;
import zork.items.Corpse;
import zork.items.Dress;
import zork.items.Item;
import zork.items.GeneralItem;
import zork.items.Mainframe;
import zork.items.Statue;
import zork.items.Warp;
import zork.items.Weapon;

/**
 * 
 * Class Map : initialize the map of the game
 * 
 *  This class is part of the "Zork" application. 
 * "Zork" is a very simple, text based adventure game.
 * 
 * This is the map where the player and enemies aare
 * 
 * @author Adrian
 * @version 28.05.2012
*/

public class Map {
	
	// initialize a array containing the map
	private List <Room> map;
	private List <GeneralItem> items;
	
	/**
	 * Create the map of the game RESIDENT EVIL
	 * 
	 */
	public Map(){
	
		map = insertRooms();
		items = createItems();
		setRoomsExits(map);
		insertItemsInRooms(map,items);
	}
	
	/**
	 * create a array containing rooms and these rooms are 15
	 * 
	 * @return a array containing rooms
	 */
	
	private List <Room> insertRooms(){
		
		// initialize a array containing rooms
		ArrayList <Room> arrayOfRooms;
		
		// create a array containing rooms
		arrayOfRooms = new ArrayList<Room>();
		
		 // create the rooms and inserts them in array
        arrayOfRooms.add(new Room("bathroom","Alice and you wake up after being unconscious in the bathroom", true));
        arrayOfRooms.add(new Room("bedroom","in bedroom where you must get the red dress",true));
        arrayOfRooms.add(new Room("library","in library where are books helpful to open the gate to hive", false));
        arrayOfRooms.add(new Room("railway","inside the railway that carry you inside to hive", false));
        arrayOfRooms.add(new Room("station","in the station where the train stops", true));
        arrayOfRooms.add(new Room("entry","in the room where is the main entry to the hive", false));
        arrayOfRooms.add(new Room("warehouse","in the warehouse, that contains food for the staff as coffee, drinks and food", false));
        arrayOfRooms.add(new Room("viralLab","in the laboratory that experiments on viruses", false));
        arrayOfRooms.add(new Room("engineroom","in the room that contains the generators and engines for energy drain", false));
        arrayOfRooms.add(new Room("armory","in the armory, where are the weapons uset by security", false));
        arrayOfRooms.add(new Room("mainframeroom","in the room that contains the central mainframe of computer security", true));
        arrayOfRooms.add(new Room("security","in security's room, inside this room once where present the guards and at northwest is a fingerprint scanner", false));
        arrayOfRooms.add(new Room("weaponslab","in the laboratory where scientists make weapon experiments ", false));
        arrayOfRooms.add(new Room("meetingroom","in meeting room, used for the presentation", false));
        arrayOfRooms.add(new Room("closet","in the closet used to contain the projects for presentation", true));
        
        return arrayOfRooms;
	}
	
	/**
	 * creates the items used in the game
	 * 
	 * @return a array of items
	 */
	
	private List <GeneralItem> createItems(){
		
		// initialize a array containing items
		ArrayList <GeneralItem> allItems;
		
		//creates a array containing items
		allItems = new ArrayList <GeneralItem>();
		
		//creates items and insert them in array
		allItems.add(new Dress("dress","You wore the dress and now you can go, oops ... but have found a key in his pocket", true, true, MapCostants.WEIGHTDRESS));
		allItems.add(new Item("note","You need to take the red dress because you are nude, use it and you ca go on", true, true, MapCostants.WEIGHTNOTE0));
		allItems.add(new Item("shower","You wake up inside it, you use it and take a shower", false, false, MapCostants.WEIGHTSHOWER));
		allItems.add(new Weapon("shotgun","Kills enemies", true, true, MapCostants.WEIGHTSHOTGUN, MapCostants.SHOOTSSHOTGUN));
		allItems.add(new Book("book","This book is on the desk of library, there is a card as a bookmark, better take it away", true, true, MapCostants.WEIGHTBOOK));
		allItems.add(new Statue("statue","A strange statue of a woman without arms, his nose seens to be a button", false, false,MapCostants.WEIGHTSTATUE));
		allItems.add(new Weapon ("axe", "This weapon can be used to difend your self", true, true, MapCostants.WEIGHTAXE, MapCostants.SHOOTSAXE));
		allItems.add(new Item ("note", "The main door to Hive is closed, only if you have the card can open it", true, true, MapCostants.WEIGHTNOTE1));
		allItems.add(new Computer ("computer", "The Hive's status is: \nInfection in progress: all staff sacrificated \naccess denied to other rooms \naccess granted to mainframe", false, false, MapCostants.WEIGHTCOMPUTER));
		allItems.add(new Item ("engines", "This are the engines used for energy production and recycling of used air", false, false, MapCostants.WEIGHTENGINES));
		allItems.add(new Mainframe("mainframe", "This is the brain of the Hive, it controls every thing, you can deactvate it", false, false, MapCostants.WEIGHTMAINFRAME, false));
		allItems.add(new Item("cage", "This the cage where the Licher has been created and from where he escaped", false, false, MapCostants.WEIGHTCAGE));
		allItems.add(new Item("bread", "You are eating the bread",true, true, MapCostants.WEIGHTBREAD));
		allItems.add(new Item("cola", "You are drinking some cola", true, true, MapCostants.WEIGHTCOLA));
		allItems.add(new Item("wine", "You are drinking some wine", true, true, MapCostants.WEIGHTWINE));
		allItems.add(new Item("chocolate", "You are eating some Chocolate", true, true, MapCostants.WEIGHTCHOCOLATE));
		allItems.add(new Bag("bag","This bag increase your inventory by 5 points", true, true, MapCostants.WEIGHTBAG));
		allItems.add(new Weapon("pistol", " This little weapon can kill a person", true, true, MapCostants.WEIGHTPISTOL, MapCostants.SHOOTSPISTOL));
		allItems.add(new Corpse("corpse", "After killed the zombie you're taking an object from the corpse", false, false, MapCostants.WEIGHTCORPSE));
		allItems.add(new Weapon("plasmagun", "This gun can kill monsters", true, false, MapCostants.WEIGHTPLASMAGUN, MapCostants.SHOOTSPLASMAGUN));	
		allItems.add(new Item("note", "You can get what you need from closet at south", true, true, MapCostants.WEIGHTNOTE2));
		allItems.add(new Warp("warp", "The warp teletrasport you to a random room\n ", true, true, MapCostants.WEIGHTWARP, map.get(createRandomNumber())));
		allItems.add(new Antidote("antidote", "Using the antidote you have been cured if infected else do nothing", true, true, MapCostants.WEIGHTANTIDOTE));
		
		// array with rooms to return
		return allItems;
										
	}
	
	/**
	 * sets all exits of the map
	 * 
	 * @param map is a array of rooms to set its exits
	 */
	
	private void setRoomsExits(List <Room> map){
		
		 // initialize room exits
        map.get(MapCostants.BATHROOM).setExits(MapCostants.SOUTHEAST, map.get(MapCostants.BEDROOM));
        map.get(MapCostants.BEDROOM).setExits(MapCostants.NORTHWEST, map.get(MapCostants.BATHROOM));
        map.get(MapCostants.BEDROOM).setExits(MapCostants.EAST, map.get(MapCostants.LIBRARY));
        map.get(MapCostants.LIBRARY).setExits(MapCostants.WEST, map.get(MapCostants.BEDROOM));
        map.get(MapCostants.LIBRARY).setExits(MapCostants.NORTHWEST, map.get(MapCostants.RAILWAY));
        map.get(MapCostants.RAILWAY).setExits(MapCostants.SOUTHEAST, map.get(MapCostants.LIBRARY));
        map.get(MapCostants.RAILWAY).setExits(MapCostants.DOWN, map.get(MapCostants.STATION));
        map.get(MapCostants.STATION).setExits(MapCostants.UP, map.get(MapCostants.RAILWAY));
        map.get(MapCostants.STATION).setExits(MapCostants.EAST, map.get(MapCostants.ENTRY));
        map.get(MapCostants.ENTRY).setExits(MapCostants.WEST, map.get(MapCostants.STATION));
        map.get(MapCostants.ENTRY).setExits(MapCostants.SOUTH, map.get(MapCostants.WAREHOUSE));
        map.get(MapCostants.ENTRY).setExits(MapCostants.SOUTHEAST, map.get(MapCostants.VIRALLAB));
        map.get(MapCostants.ENTRY).setExits(MapCostants.DOWN, map.get(MapCostants.ENGINEROOM));
        map.get(MapCostants.WAREHOUSE).setExits(MapCostants.NORTH, map.get(MapCostants.ENTRY));
        map.get(MapCostants.VIRALLAB).setExits(MapCostants.NORTHWEST, map.get(MapCostants.ENTRY));
        map.get(MapCostants.ENGINEROOM).setExits(MapCostants.UP,map.get(MapCostants.ENTRY));
        map.get(MapCostants.ENGINEROOM).setExits(MapCostants.EAST, map.get(MapCostants.MAINFRAMEROOM));
        map.get(MapCostants.ENGINEROOM).setExits(MapCostants.NORTHEAST, map.get(MapCostants.ARMORY));
        map.get(MapCostants.MAINFRAMEROOM).setExits(MapCostants.WEST, map.get(MapCostants.ENGINEROOM));
        map.get(MapCostants.ARMORY).setExits(MapCostants.SOUTHWEST, map.get(MapCostants.ENGINEROOM));
        map.get(MapCostants.ENGINEROOM).setExits(MapCostants.DOWN, map.get(MapCostants.SECURITY));
        map.get(MapCostants.SECURITY).setExits(MapCostants.UP, map.get(MapCostants.ENGINEROOM));
        map.get(MapCostants.SECURITY).setExits(MapCostants.NORTHWEST, map.get(MapCostants.WEAPONSLAB));
        map.get(MapCostants.SECURITY).setExits(MapCostants.SOUTHEAST, map.get(MapCostants.MEETINGROOM));
        map.get(MapCostants.WEAPONSLAB).setExits(MapCostants.SOUTHWEST, map.get(MapCostants.SECURITY));
        map.get(MapCostants.MEETINGROOM).setExits(MapCostants.NORTHEAST, map.get(MapCostants.SECURITY));
        map.get(MapCostants.MEETINGROOM).setExits(MapCostants.SOUTH, map.get(MapCostants.CLOSET));
        map.get(MapCostants.CLOSET).setExits(MapCostants.NORTH, map.get(MapCostants.MEETINGROOM));
	}
	
	/**
	 * inserts items into rooms
	 * 
	 * @param map array containing rooms
	 * @param items array containing items
	 */
	
	private void insertItemsInRooms (List <Room> map, List <GeneralItem> items){
		
		 //initialize room's inventory
        map.get(MapCostants.BATHROOM).addRoomInventory(items.get(MapCostants.SHOWER));
        map.get(MapCostants.BEDROOM).addRoomInventory(items.get(MapCostants.DRESS));
        map.get(MapCostants.BEDROOM).addRoomInventory(items.get(MapCostants.NOTE0));
        map.get(MapCostants.LIBRARY).addRoomInventory(items.get(MapCostants.BOOK));
        map.get(MapCostants.LIBRARY).addRoomInventory(items.get(MapCostants.STATUE));
        map.get(MapCostants.LIBRARY).addRoomInventory(items.get(MapCostants.ANTIDOTE));
        map.get(MapCostants.RAILWAY).addRoomInventory(items.get(MapCostants.AXE));
        map.get(MapCostants.STATION).addRoomInventory(items.get(MapCostants.NOTE1));
        map.get(MapCostants.ENTRY).addRoomInventory(items.get(MapCostants.COMPUTER));
        map.get(MapCostants.ENGINEROOM).addRoomInventory(items.get(MapCostants.ENGINES));
        map.get(MapCostants.MAINFRAMEROOM).addRoomInventory(items.get(MapCostants.MAINFRAME));
        map.get(MapCostants.VIRALLAB).addRoomInventory(items.get(MapCostants.CAGE));
        map.get(MapCostants.WAREHOUSE).addRoomInventory(items.get(MapCostants.WINE));
        map.get(MapCostants.WAREHOUSE).addRoomInventory(items.get(MapCostants.ANTIDOTE));
        map.get(MapCostants.WAREHOUSE).addRoomInventory(items.get(MapCostants.CHOCOLATE));
        map.get(MapCostants.WAREHOUSE).addRoomInventory(items.get(MapCostants.COLA));
        map.get(MapCostants.WAREHOUSE).addRoomInventory(items.get(MapCostants.BREAD));
        map.get(MapCostants.WAREHOUSE).addRoomInventory(items.get(MapCostants.BAG));
        map.get(MapCostants.ARMORY).addRoomInventory(items.get(MapCostants.SHOTGUN));
        map.get(MapCostants.ARMORY).addRoomInventory(items.get(MapCostants.PISTOL));
        map.get(MapCostants.ARMORY).addRoomInventory(items.get(MapCostants.ANTIDOTE));
        map.get(MapCostants.SECURITY).addRoomInventory(items.get(MapCostants.CORPSE));
        map.get(MapCostants.CLOSET).addRoomInventory(items.get(MapCostants.PISTOL));
        map.get(MapCostants.CLOSET).addRoomInventory(items.get(MapCostants.CORPSE));
        map.get(MapCostants.CLOSET).addRoomInventory(items.get(MapCostants.ANTIDOTE));
        map.get(MapCostants.WEAPONSLAB).addRoomInventory(items.get(MapCostants.PLASMAGUN));
        map.get(MapCostants.MEETINGROOM).addRoomInventory(items.get(MapCostants.NOTE2));
        map.get(MapCostants.VIRALLAB).addRoomInventory(items.get(MapCostants.WARP));
	}
	
	/**
	 * create a random number used for create the item warp to chose the room to teletrasport
	 * 
	 * @return a random number between 0 - 14
	 */
	
	private int createRandomNumber(){
			
		// used to generate a random number
    	int randomNumber, first = MapCostants.FIRST, last = MapCostants.LAST - first;
	    Random random = new Random();
	   	// creates the random number
	   	randomNumber = (random.nextInt(last)+first);
	    	
	   	return randomNumber;
	}
	
	/**
	 * return a room from the map at a index
	 * 
	 * @param index index of the room to return
	 * @return a Room
	 */
	
	public Room getRoom (int index){
		
		return this.map.get(index);
	}
	
	/**
	 * return a item from items at index
	 * 
	 * @param index Index of the item to return
	 * @return a Item
	 */
	
	public GeneralItem getItem (int index){
		
		return this.items.get(index);
	}
}