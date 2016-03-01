package zork.logger;

import java.io.OutputStream;
import java.util.logging.*;

/**
 * 
 * class CustomHandler : it is a custom handler used by Log
 * 
 *  This class is part of the "Zork" application. 
 * "Zork" is a very simple, text based adventure game.
 * 
 * this class overrides the method publish of handler to insert a log every time a logger is called
 * 
 * @author Adrian
 * @version 28.05.2012
*/

public class CustomHandler extends StreamHandler{
	
/**
 * is the constructor of the customed handler
 * 
 * @param out a output stream 
 * @param formatter a formatter
 */
	public CustomHandler(OutputStream out, Formatter formatter){
		super(out, formatter);
	}
	
	@Override
	public synchronized void publish(LogRecord record){
		super.publish(record);
		flush();
	}
	
}

