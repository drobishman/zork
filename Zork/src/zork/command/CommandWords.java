package zork.command;
import java.util.HashMap;
import java.util.Map;

import zork.logger.Log;


/**
 * This class is part of the "Zork" application. 
 * "Zork" is a very simple, text based adventure game.
 * 
 * This class holds an enumeration of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author  Drob Adrian Mihai
 * @version 27.04.2012
 */

public class CommandWords
{
    // A mapping between a command word and the CommandWord
    // associated with it.
    private Map<String, CommandWord> validCommands;

    /**
     * Constructor - initialize the command words.
     */
    public CommandWords()
    {
        validCommands = new HashMap<String, CommandWord>();
        validCommands.put("go", CommandWord.GO);
        validCommands.put("help", CommandWord.HELP);
        validCommands.put("quit", CommandWord.QUIT);
        validCommands.put("back", CommandWord.BACK);
        validCommands.put("view", CommandWord.VIEW);
        validCommands.put("take", CommandWord.TAKE);
        validCommands.put("drop", CommandWord.DROP);
        validCommands.put("use", CommandWord.USE);
        validCommands.put("exits", CommandWord.EXITS);
        validCommands.put("space", CommandWord.SPACE);
        validCommands.put("score", CommandWord.SCORE);
        validCommands.put("verbose", CommandWord.VERBOSE);
    }

    /**
     * Find the CommandWord associated with a command word.
     * @param commandWord The word to look up (as a string).
     * @return The CommandWord correspondng to commandWord, or UNKNOWN
     *         if it is not a valid command word.
     */
    public CommandWord getCommandWord(String commandWord)
    {
        CommandWord command = validCommands.get(commandWord);
        if(command != null) {
            return command;
        }
        else {
            return CommandWord.UNKNOWN;
        }
    }
    
    /**
     * Check whether a given String is a valid command word. 
     * @return true if it is, false if it isn't.
     */
    public boolean isCommand(String aString)
    {
        return validCommands.containsKey(aString);
    }

    /**
     * Print all valid commands to System.out.
     */
    public void showAll(Log log) 
    {
        for(String command : validCommands.keySet()) {
        	log.info(command + "  ");
        }
        log.info("");
    }
}
