package zork.command;
/**
 * Representations for all the valid command words for the game.
 * 
 * @author  Drob Adrian Mihai
 * @version 27.04.2012
 */
public enum CommandWord
{
    // A value for each command word, plus one for unrecognized
    // commands.
    GO, QUIT, HELP, UNKNOWN, BACK, VIEW, TAKE, DROP, USE, EXITS, SPACE, SCORE, VERBOSE;
}