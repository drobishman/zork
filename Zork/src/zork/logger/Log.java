package zork.logger;

import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * this class implements a logger per for the visualization of the interface
 * in console
 * @author Adrian Drob
 *
 */
public class Log {
	private static Logger log = Logger.getLogger("logger");
	private static CustomFormatter formatter = new CustomFormatter();
	private static CustomHandler handler = new CustomHandler (System.out,formatter);
	
	/**
	 * initialize a logger using customed formatter and handler
	 */
	public Log() {
		log.setLevel(Level.ALL);
		log.setUseParentHandlers(false);
		handler.setLevel(Level.ALL);
		log.addHandler(handler);
	}
	
	/**
	 * prints on console a massage of type info
	 * @param message the message to view
	 */
	public void info(String message) {
		log.info(message);
	}
}
