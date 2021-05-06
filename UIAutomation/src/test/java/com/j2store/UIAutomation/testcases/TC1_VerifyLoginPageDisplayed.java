package com.j2store.UIAutomation.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.j2store.UIAutomation.baseDrivers.BaseDriver;
import com.j2store.UIAutomation.pages.HomePage;
import com.j2store.UIAutomation.pages.LoginPage;

public class TC1_VerifyLoginPageDisplayed extends BaseDriver{
	
	HomePage home;
	LoginPage login;
	@BeforeMethod
	public void preRequest() {
		launchDriver();
	}
	
	@Test(priority=1,enabled=false)
	public void verifyHomePage() {
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://www.j2store.org/demo-stores.html";
		Assert.assertEquals(actualUrl, expectedUrl);
	}
	
	@Test(priority=2)
	public void verifyLoginPage() {
		home = new HomePage();
		login= home.clickLogin();
		String actualTitle = login.getpageTitle();
		String expectedTitle = "Login";
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	

}
