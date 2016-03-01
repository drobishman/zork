package zork.themap;

/**
 * 
 * class MapCostants : initialize the constant variables of the map
 * 
 *  This class is part of the "Zork" application. 
 * "Zork" is a very simple, text based adventure game.
 * 
 * this class contains all constants of the class map
 * 
 * @author Adrian
 * @version 28.05.2012
*/

final class MapCostants {
	
	// room constants
	public static final int BATHROOM = 0;
	public static final int BEDROOM = 1;
	public static final int LIBRARY = 2;
	public static final int RAILWAY = 3;
	public static final int STATION = 4;
	public static final int ENTRY = 5;
	public static final int WAREHOUSE = 6;
	public static final int VIRALLAB = 7;
	public static final int ENGINEROOM = 8;
	public static final int ARMORY = 9;
	public static final int MAINFRAMEROOM = 10;
	public static final int SECURITY = 11;
	public static final int WEAPONSLAB = 12;
	public static final int MEETINGROOM = 13;
	public static final int CLOSET = 14;
	
	// direction constants
	public static final String UP = "up";
	public static final String DOWN = "down";
	public static final String NORTH = "north";
	public static final String EAST = "east";
	public static final String SOUTH = "south";
	public static final String WEST = "west";
	public static final String NORTHEAST = "northeast";
	public static final String SOUTHEAST = "southeast";
	public static final String NORTHWEST = "northwest";
	public static final String SOUTHWEST = "southwest";
	
	// items costants
	public static final int DRESS = 0;
	public static final int NOTE0 = 1;
	public static final int SHOWER = 2;
	public static final int SHOTGUN = 3;
	public static final int BOOK = 4;
	public static final int STATUE = 5;
	public static final int AXE = 6;
	public static final int NOTE1 = 7;
	public static final int COMPUTER = 8;
	public static final int ENGINES = 9;
	public static final int MAINFRAME = 10;
	public static final int CAGE = 11;
	public static final int BREAD = 12;
	public static final int COLA = 13;
	public static final int WINE = 14;
	public static final int CHOCOLATE = 15;
	public static final int BAG = 16;
	public static final int PISTOL = 17;
	public static final int CORPSE = 18;
	public static final int PLASMAGUN = 19;
	public static final int NOTE2 = 20;
	public static final int WARP = 21;
	public static final int ANTIDOTE = 22;
	
	// numbers to generate a random map
	public static final int FIRST = 0;
	public static final int LAST = 14;
	
	//item weight costants
	public static final int WEIGHTDRESS = 1;
	public static final int WEIGHTNOTE0 = 1;
	public static final int WEIGHTSHOWER = 0;
	public static final int WEIGHTSHOTGUN = 4;
	public static final int WEIGHTBOOK = 1;
	public static final int WEIGHTSTATUE = 0;
	public static final int WEIGHTAXE = 5;
	public static final int WEIGHTNOTE1 = 1;
	public static final int WEIGHTCOMPUTER = 0;
	public static final int WEIGHTENGINES = 0;
	public static final int WEIGHTMAINFRAME = 0;
	public static final int WEIGHTCAGE = 0;
	public static final int WEIGHTBREAD = 1;
	public static final int WEIGHTCOLA = 1;
	public static final int WEIGHTWINE = 1;
	public static final int WEIGHTCHOCOLATE = 1;
	public static final int WEIGHTBAG = 0;
	public static final int WEIGHTPISTOL = 3;
	public static final int WEIGHTCORPSE = 0;
	public static final int WEIGHTPLASMAGUN = 6;
	public static final int WEIGHTNOTE2 = 1;
	public static final int WEIGHTWARP = 3;
	public static final int WEIGHTANTIDOTE = 1;
	
	// guns shoots
	public static final int SHOOTSSHOTGUN = 2;
	public static final int SHOOTSAXE = 1;
	public static final int SHOOTSPISTOL = 1;
	public static final int SHOOTSPLASMAGUN = 3;
	
	
	/**
	 * constructor of class MapCostants: does nothing because it only initialize some constants for class Map
	 * 
	 */
	private MapCostants(){
		// do nothing
	}

}
