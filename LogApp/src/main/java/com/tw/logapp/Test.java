package com.tw.logapp;

import org.apache.log4j.Logger;

public class Test {

	/*
	 * private static Logger logger=Logger.getLogger(Test.class); public static void
	 * main(String[] args) throws IOException { //Create layout //Layout layout=new
	 * SimpleLayout(); //Layout layout=new HTMLLayout(); Layout layout=new
	 * PatternLayout("%m"); //Create appender and link layout Appender appender=new
	 * ConsoleAppender(layout); //Link appender with logger
	 * logger.addAppender(appender); //Print messages logger.debug("FROM DEBUG");
	 * logger.info("FROM INFO"); logger.warn("FROM WARN");
	 * logger.error("FROM ERROR"); logger.fatal("FROM FATAL");
	 * 
	 * }
	 */
	private static Logger logger=Logger.getLogger(Test.class);
	public static void main(String[] args) {
		
		logger.debug("HELLO");
		logger.info("HI");
		logger.warn("HRU");
		logger.error("BYE");
		logger.fatal("GOODBYE");
	}
}
