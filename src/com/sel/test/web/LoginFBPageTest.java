package com.sel.test.web;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.sel.base.BaseTest;
import com.sel.page.web.LoginFBPage;

public class LoginFBPageTest extends BaseTest {
	
	private LoginFBPage fb;
	
	@BeforeClass
	public void createObj() {
		fb = new LoginFBPage(driver);
	}
	
	@Test(priority=0)
	public void testLogin() {
		Assert.assertTrue(fb.login());
	}
	
	@DataProvider(name="user-data")
	public Object[][] getExcelData() {
		return excelUtils.getData();
	}
	
	@Test(dataProvider="user-data")
	public void testLoginFB(String username, String password) {
		Assert.assertTrue(fb.loginFB(username, password));
	}
}
