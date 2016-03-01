package zork.logger;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;

/**
 * 
 * class formatter : is a formatter used by log
 * 
 *  This class is part of the "Zork" application. 
 * "Zork" is a very simple, text based adventure game.
 * 
 * this class overrides the method format to print only the message
 * 
 * @author Adrian
 * @version 28.05.2012
*/

public class CustomFormatter extends Formatter {
	
	/**
	 * constructor of the customFormatter
	 * 
	 */
	public CustomFormatter(){
		
		super();
	}

	@Override
	public String format(LogRecord record) {
		
		return record.getMessage();
	}
	 
	 
}
