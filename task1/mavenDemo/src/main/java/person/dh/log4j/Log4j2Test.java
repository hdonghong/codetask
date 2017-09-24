package person.dh.log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4j2Test {
	public static void main(String[] args) {
		Logger logger = LogManager.getLogger(Log4j2Test.class);
		logger.fatal("fatal level");
		logger.error("error level");
		logger.warn("warn level");
		logger.info("info level");
		logger.debug("debug level");
		logger.trace("trace level");
	}
}
