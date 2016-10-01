package com.sel.page.web;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sel.base.BasePage;
import com.sel.util.CustomBy;

public class HomePage extends BasePage {
	
	private static Logger log = Logger.getLogger(HomePage.class);
			
	public HomePage(WebDriver driver) {
		super(driver);
		System.out.println("driver from home page constructor: "+driver);

	}
	
	public boolean isLogoPresent() {
		log.info("Testing logo in HomePage");
		return driver.findElement(CustomBy.getByObject("class-logo")).isDisplayed();
	}
	
	public boolean subjectsLinkPresent() throws InterruptedException {
		log.info("Testing Subjects link in HomePage");
		driver.findElement(CustomBy.getByObject("link-subjects")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		boolean val = driver.findElement(CustomBy.getByObject("subjectsDisp")).isDisplayed();
		driver.navigate().back();
		return val;
	}
	
	public boolean candidateLinkPresent() {
		log.info("Testing Candidate link in HomePage");
		driver.findElement(CustomBy.getByObject("link-candidate")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		boolean val = driver.findElement(CustomBy.getByObject("id-signup-intro")).isDisplayed();
		driver.findElement(CustomBy.getByObject("class-logo")).click();
		return val;
	}
	
	public boolean isBGImagePresent() {
		log.info("Testing Backgroung Image in HomePage");
		return driver.findElement(CustomBy.getByObject("xpath-img1")).isDisplayed();
	}
	
	public boolean screenFirstHeadingPresent() {
		log.info("Testing Screen First Resume Next Heading in Home Page");
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(CustomBy.getByObject("xpath-heading")));
		return ele.isDisplayed();
	}
	
	public boolean screenFirstSubHeadPresent() {
		log.info("Testing Screen First Resume Next Sub Heading in Home Page");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver.findElement(CustomBy.getByObject("class-subhead")).isDisplayed();
	}
	
	public String signUpNowPresent() {
		log.info("Testing SignUp Now Button in Home Page");
		return driver.findElement(CustomBy.getByObject("xpath-signupbtn")).getText();
	}
	
	public boolean featuresHeading() {
		log.info("Testing Features Heading in Home Page");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0, 450)", "");
		return driver.findElement(CustomBy.getByObject("class-pagesechead")).isDisplayed();
	}
	
	public int featurePanels() {
		log.info("Testing Features Panels in Home Page");
		return driver.findElements(CustomBy.getByObject("class-textheadline")).size();
	}
	
	public boolean featuredSubjsHeading() {
		log.info("Testing Featured Subjects Heading in Home Page");
		return driver.findElement(CustomBy.getByObject("xpath-featuredsubjs-mainhead")).isDisplayed();
	}
	
	public boolean featuredSubjsSubHeading() {
		log.info("Testing Featured Subjects Sub Heading in Home Page");
		return driver.findElement(CustomBy.getByObject("xpath-featuredsubjs-subhead")).isDisplayed();
	}
	
	public int featuredSubsDraggableList() {
		log.info("Testing Featured Subjects Draggable List in Home Page");
		return driver.findElements(CustomBy.getByObject("xpath-slick-track")).size();
	}
	
	public boolean browseSubjectsButton() {
		log.info("Testing Browse Subjects Button in Home Page");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
	    jse.executeScript("window.scrollBy(0, 450)", "");
		WebElement ele = driver.findElement(CustomBy.getByObject("id-browse-subjects"));
		Actions action = new Actions(driver);
		action.moveToElement(ele).click().perform();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		ele = wait.until(ExpectedConditions.visibilityOfElementLocated(CustomBy.getByObject("subjectsDisp")));
		boolean val = ele.isDisplayed();
		driver.navigate().back();
		return val;
	}
	
	public boolean isBGImage2Present() {
		log.info("Testing BackGround Image 2 in Home Page");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
	    jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		return driver.findElement(CustomBy.getByObject("xpath-img2")).isDisplayed();
	}
	
	public int checkTestimonials() {
		log.info("Testing Testimonials in Home Page");
		return driver.findElements(CustomBy.getByObject("class-testimonial")).size();
	}
	
	public boolean loginLinkPresent() {
		log.info("Testing Login link in HomePage");
		driver.findElement(CustomBy.getByObject("xpath-login")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		boolean val = driver.findElement(CustomBy.getByObject("id-signup-intro")).isDisplayed();
		return val;
	}
}
