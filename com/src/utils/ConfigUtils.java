package com.sel.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigUtils {

	public static final String CONFIG_FILE = "//Users//madhavim//Documents//workspace//SeleniumAutomation//resources//config.properties";
	String BROWSER;
	String URL;
	
	public ConfigUtils() throws IOException {
		Properties prop = new Properties();
		try {
			prop.load(new FileReader(CONFIG_FILE));
			BROWSER = prop.getProperty("browser");
			//System.out.println("BROWSER:"+BROWSER);
			URL = prop.getProperty("url");
			//System.out.println("URL:"+URL);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
	}
}
