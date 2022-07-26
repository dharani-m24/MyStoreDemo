package com.mystore.utilities;

import org.apache.log4j.Logger;



public class Log {
	
	  public static Logger logger=Logger.getLogger(Log.class);
	  
	  public  static void startTestCase(String testCaseName) {
			logger.info("=============================="+testCaseName+"Test case started"+"====================================");
		}
		
		public  static void info(String message) {
			logger.info(message);
		}
		
		public static  void warn(String message) {
			logger.warn(message);
		}
		
		public static void endTestCase(String testCaseName) {
			logger.info("=============================="+testCaseName+"Test case ended"+"==========================================");
		}

}
