package com.sel.test.web;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.sel.base.BaseTest;
import com.sel.page.web.HomePage;

public class HomePageTest extends BaseTest{

	private HomePage hp;
	
	@BeforeClass
	public void createObj() {
		hp = new HomePage(driver);
		System.out.println("driver from home page Test create obj: "+driver);
	}
		
	@Test(priority=1)
	public void testTSLogoPresent() {
		Assert.assertTrue(hp.isLogoPresent());
	}

	@Test(priority=2)
	public void testIsBGImagePresent() {
		Assert.assertTrue(hp.isBGImagePresent());
	}
	
	@Test(priority=3)
	public void testScreenFirstHeading() {
		Assert.assertTrue(hp.screenFirstHeadingPresent());
	}
	
	@Test(priority=4)
	public void testScreenFirstSubHeading() {
		Assert.assertTrue(hp.screenFirstSubHeadPresent());	
	}
	
	@Test(priority=5)
	public void testSignUpNowPresent() {
		Assert.assertEquals(hp.signUpNowPresent(), "SIGN UP - NOW");
	}
	
	@Test(priority=6)
	public void testFeaturesHeading() {
		Assert.assertTrue(hp.featuresHeading());
	}
	
	@Test(priority=7)
	public void testFeaturePanels() {
		Assert.assertEquals(hp.featurePanels(), 6);
	}
	
	@Test(priority=8)
	public void testFeaturedSubjsHeading() {
		Assert.assertTrue(hp.featuredSubjsHeading());
	}
	
	@Test(priority=9)
	public void testFeaturedSubjsSubHeading() {
		Assert.assertTrue(hp.featuredSubjsSubHeading());
	}
		
	@Test(priority=10)
	public void testFeaturedSubsDraggableList() {
		Assert.assertEquals((hp.featuredSubsDraggableList()), 34);
	}
	
	@Test(priority=11)
	public void testBrowseSubjectsButton() {
		Assert.assertTrue(hp.browseSubjectsButton());
	}
	
	@Test(priority=12)
	public void testIsBGImage2Present() {
		Assert.assertTrue(hp.isBGImage2Present());
	}
	
	@Test(priority=13)
	public void testTestimonials() {
		Assert.assertEquals(hp.checkTestimonials(), 3);
	}
	
	@Test(priority=14)
	public void testSubjectsLinkPresent() throws InterruptedException {
		Assert.assertTrue(hp.subjectsLinkPresent());
	}
	
	@Test(priority=15)
	public void testCandidateLinkPresent() {
		Assert.assertTrue(hp.candidateLinkPresent());
	}
	
	@Test(priority=16)
	public void testLoginLinkPresent() {
		Assert.assertTrue(hp.loginLinkPresent());
	}

}
