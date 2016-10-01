package com.sel.base;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.sel.util.ConfigUtils;
import com.sel.util.CustomBy;
import com.sel.util.ExcelUtils;
import com.sel.util.WebUIDriver;

public abstract class BaseTest {
	
	public WebDriver driver;
	public ExcelUtils excelUtils;
	Object[][] data = null;
	
	@BeforeClass
	public void setup() throws IOException {
		ConfigUtils config = new ConfigUtils();
		driver = WebUIDriver.getDriver(config);
		CustomBy.loadProperties();
		excelUtils = new ExcelUtils();
	}
	
	@AfterClass
	public void teardown() {
		driver.quit();
	}
}
