package com.sel.page.web;

import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sel.base.BasePage;
import com.sel.util.CustomBy;

public class LoginFBPage extends BasePage{
	
	private static Logger log = Logger.getLogger(LoginFBPage.class);
	
	public LoginFBPage(WebDriver driver) {
		super(driver);
	}
	
	public boolean login() {
		log.info("Testing Login in LoginFBPage");
		driver.findElement(CustomBy.getByObject("xpath-login")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		boolean val = driver.findElement(CustomBy.getByObject("id-signup-intro")).isDisplayed();
		return val;
	}
	
	public boolean loginFB(String uname, String pwd) {
		log.info("Testing Login with FaceBook Page in LoginFBPage");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(CustomBy.getByObject("xpath-facebook")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String parentWinId = driver.getWindowHandle();
		WebDriver childWinDriver = null;
		for (String childWinId : driver.getWindowHandles()) {
			childWinDriver = driver.switchTo().window(childWinId); 
		}
	    boolean val = enterUserInfo(uname, pwd);
	    childWinDriver.close();
	    driver.switchTo().window(parentWinId);
	    return val;
	}
	
	public boolean enterUserInfo(String uname, String pwd) {
		log.info("Testing entering user info in FaceBook page..");
		driver.findElement(CustomBy.getByObject("id-email")).sendKeys(uname);
		driver.findElement(CustomBy.getByObject("id-pass")).sendKeys(pwd);
		driver.findElement(CustomBy.getByObject("name-login")).submit();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(CustomBy.getByObject("partial-info")));
		return ele.isDisplayed();
	}
}
