package com.bottomline.common;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;


public class Fundamental {
	// creating driver object here, to allow every class that extends this fundamental
	// class to use the same driver and allow scenarios to flow using same driver and having same config before and after execution
	public static WebDriver driver;

	@BeforeClass
	public static void beforeClass() {
		WebDriverFactory driverFactory = new WebDriverFactory();
		driver = driverFactory.Create(BrowserType.CHROME, false);
		driver.get(Functions.GetProperty("BaseURL"));
	}
	
	@AfterClass
	public static void afterClass() {
		driver.quit();
	}
}
