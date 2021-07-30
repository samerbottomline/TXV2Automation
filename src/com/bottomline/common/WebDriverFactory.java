package com.bottomline.common;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebDriverFactory {
	
	public WebDriver Create(BrowserType type, Boolean headless)
    {
        switch (type)
        {
            case CHROME:
                return GetDriver(BrowserType.CHROME, headless);

            case FIREFOX:
                return GetDriver(BrowserType.FIREFOX, headless);

            default:
                throw new IllegalArgumentException("No such browser exists yet");
        }
    }

    private WebDriver GetDriver(BrowserType type, Boolean headless)
    {
        switch (type)
        {
            case CHROME:
                ChromeDriver chromeDriver = null;
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("start-maximized");
                if (headless)
                    chromeOptions.addArguments("headless");
                chromeOptions.addArguments("user-data-dir=" + System.getProperty("user.dir") + "\\Chrome Profiles\\Default");

                String chromeDirectory = System.getProperty("user.dir")+"\\Browsers\\chromedriver.exe";
                System.setProperty("webdriver.chrome.driver", chromeDirectory);
                
                try
                {
                    chromeDriver = new ChromeDriver(chromeOptions);
                }
                catch (WebDriverException driverExpection)
                {
                    KillActiveDrivers();
                    chromeDriver = new ChromeDriver(chromeOptions);
                }

                return chromeDriver;

            case FIREFOX:
            	String firefoxDirectory = System.getProperty("user.dir")+"\\Browsers\\firefox.exe";
                System.setProperty("webdriver.gecko.driver", firefoxDirectory);
                
                FirefoxDriver firefoxDriver = new FirefoxDriver();
                firefoxDriver.manage().window().maximize();
                return firefoxDriver;

            case INTERNETEXPLORER:
            	String ieDirectory = System.getProperty("user.dir")+"\\Browsers\\IEDriverServer.exe";
                System.setProperty("webdriver.ie.driver", ieDirectory);
                
            	InternetExplorerDriver ieDriver = new InternetExplorerDriver();
                ieDriver.manage().window().maximize();
                return ieDriver;

            default:
                return null;
        }
    }

    private void KillActiveDrivers()
    {
        String command = "/C taskkill /F /IM \"chromedriver.exe\" /IM \"chrome.exe\"";
        
        try {
			Runtime.getRuntime().exec(command);
		} catch (IOException e) {
			e.printStackTrace();
		}
        
    }
}
