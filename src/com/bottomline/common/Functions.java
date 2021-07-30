package com.bottomline.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Functions {
	
	public static String GetProperty(String property) {
		Properties prop = new Properties();
		FileInputStream fis;

		try {
			fis = new FileInputStream(System.getProperty("user.dir") + "\\param.properties");
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop.getProperty(property);
	}
	
}
