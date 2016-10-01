package com.sel.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;

public class CustomBy {
	public static final String LOCATORS_FILE = "//Users//madhavim//Documents//workspace//SeleniumAutomation//resources//locators.properties";
	public static Properties prop;
	
	public static void loadProperties() throws IOException {
		prop = new Properties();
		try {
			prop.load(new FileReader(LOCATORS_FILE));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
	}
	
	public static By getByObject(String locatorKey) {
		By by = null;
		String[] key = locatorKey.split("-");
		String value = prop.getProperty(locatorKey);
		
		if(key[0].contains("id")) {
			by = By.id(value);
		} else if(key[0].contains("name")) {
			by = By.name(value);
		} else if(key[0].contains("class")) {
			by = By.className(value);
		} else if(key[0].contains("xpath")) {
			by = By.xpath(value);
		} else if(key[0].contains("link")) {
			by = By.linkText(value);
		} else if(key[0].contains("partial")) {
			by = By.partialLinkText(value);
		} else if(key[0].contains("tag")) {
			by = By.tagName(value);
		} else {
			by = By.cssSelector(value);
		}
		//System.out.println("key[0]: "+key[0]);
		//System.out.println("by: "+by.toString());
		return by;
	}
}
