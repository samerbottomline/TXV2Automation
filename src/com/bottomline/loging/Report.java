package com.bottomline.loging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Report {

	private static Logger logger;// = LogManager.getLogger(LoginTest.class);
	
	
	public Report(Class<?> clazz) {
		logger = LogManager.getLogger(clazz);
	}
	
	
	public void Info(String value) {
		logger.info(value);
	}
	
	
}
