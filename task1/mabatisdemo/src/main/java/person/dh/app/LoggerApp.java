package person.dh.app;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import person.dh.uitls.BasicLogger;
import person.dh.uitls.LoggerUtils;

/**
 * 测试logger的使用
 */
public class LoggerApp {
	//方法一：在当前类中声明
	private static Logger logger = LogManager.getLogger(Logger.class);
	
	public static void main(String[] args) {
		//logger.info("测试logger的使用");
		LoggerUtils.LOGGER.info("测试logger的使用");
		
		//testSystemOut();
		//testLog4j();
		
	}
	
	public static void testSystemOut() {
		//记录当前时刻毫秒数
		long start = System.currentTimeMillis();
		
		for (int i = 0; i < 1000000; i++) {
			System.out.println("Syso输出：" + i);
		}
		//结束时刻-开始时刻
		long time = System.currentTimeMillis() - start;
		System.out.println("Syso输出用时：" + time + "ms");
	}
	
	public static void testLog4j() {
		long start = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			logger.debug("log4j输出：" + i);
		}
		long time = System.currentTimeMillis() - start;
		System.out.println("所用时间" + time);
	}
}
