package com.sel.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebUIDriver {
	
	public static WebDriver getDriver(ConfigUtils config) {
		WebDriver driver;
		switch(config.BROWSER.toLowerCase()) {
		case "firefox":
			driver = new FirefoxDriver();
			break;
			
		case "chrome": 
			System.setProperty("webdriver.chrome.driver", "chromedriver");
			driver = new ChromeDriver();
			break;
			
		case "ie": 
			System.setProperty("webdriver.ie.driver", "lib/IEServerDriver.exe");
			driver = new InternetExplorerDriver();
			break;
			
		case "safari": 
			driver = new SafariDriver();
			break;
			
		default: 
			driver = new FirefoxDriver();
		}
		driver.get(config.URL);
		return driver;
	}
}

