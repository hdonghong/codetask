package person.dh.log4j;

import org.apache.log4j.Logger;

public class Log4jTest {
	public static void main(String[] args) {
		Logger logger = Logger.getLogger(Log4jTest.class);
		logger.fatal("fatal level");
		logger.error("error level");
		logger.warn("warn level");
		logger.info("info level");
		logger.debug("debug level");
		logger.trace("trace level");
	}
}
