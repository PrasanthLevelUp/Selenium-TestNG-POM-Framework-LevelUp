package com.j2store.UIAutomation.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.j2store.UIAutomation.baseDrivers.BaseDriver;
import com.j2store.UIAutomation.pages.HomePage;
import com.j2store.UIAutomation.pages.LoginPage;
import com.j2store.UIAutomation.reports.ExtentReportFiles;

public class TC1_VerifyLoginPageDisplayed extends BaseDriver{
	
	HomePage home;
	LoginPage login;
	ExtentReportFiles report;
	
	TC1_VerifyLoginPageDisplayed(){
		super();
	}
	
	@BeforeMethod
	public void preRequest() {
		launchDriver();
		report = new ExtentReportFiles("TC1_VerifyLoginPageDisplayed");
		String test = prop.getProperty("Test");
	}
	
	@Test(priority=1,enabled=false)
	public void verifyHomePage() {
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://www.j2store.org/demo-stores.html";
		try {
		Assert.assertEquals(actualUrl, expectedUrl);
		report.passlog("The home page url is displayed");
		}catch(Exception e) {
			report.faillog("The home page url is not displayed");
			report.infolog(e.getMessage());
		}
	}
	
	@Test(priority=2,enabled=false)
	public void verifyLoginPage() {
		home = new HomePage();
		login= home.clickLogin();
		String actualTitle = login.getpageTitle();
		String expectedTitle = "Login";
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@Test(priority=3)
	public void verifyValidLogin() {
		home = new HomePage();
		login= home.clickLogin();
		login.login("prasanth", "niho");
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://www.j2store.org/";
		Assert.assertTrue(actualUrl.contains(expectedUrl));
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
		report.flushreport();
	}
	
	
	

}
