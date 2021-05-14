package com.j2store.UIAutomation.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.j2store.UIAutomation.baseDrivers.BaseDriver;
import com.j2store.UIAutomation.pages.HomePage;
import com.j2store.UIAutomation.pages.LoginPage;
import com.j2store.UIAutomation.reports.ExtentReportFiles;
import com.j2store.UIAutomation.testdata.ExcelApachePOITestData;
import com.j2store.UIAutomation.utils.SeleniumUtils;

public class TC1_VerifyLoginPageDisplayed extends BaseDriver{
	
	HomePage home;
	LoginPage login;
	ExtentReportFiles report;
	ExcelApachePOITestData testdata;
	SeleniumUtils utils;
	
	TC1_VerifyLoginPageDisplayed(){
		super();
	}
	
	@BeforeMethod
	public void preRequest() {
		launchDriver();
		TCName = getClass().getName();
		testdata = new ExcelApachePOITestData();
		report = new ExtentReportFiles();
		utils = new SeleniumUtils();
	}
	
	@Test(priority=1,enabled=false)
	public void verifyHomePage() {
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://www.j2store.org/demo-stores.html";
		utils.equalsstring(actualUrl, expectedUrl,"The home page url is displayed");
	}
	
	@Test(priority=2,enabled=false)
	public void verifyLoginPage() {
		home = new HomePage();
		login= home.clickLogin();
		String actualTitle = login.getpageTitle();
		String expectedTitle = "Login";
		utils.equalsstring(actualTitle, expectedTitle,"The home page url is displayed");
	}
	
	@Test(priority=3)
	public void verifyValidLogin() {
		home = new HomePage();
		login= home.clickLogin();
		login.login(testdata.getData("UserName"), testdata.getData("Password"));
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://www.j2store.org/";
		utils.containsstring(actualUrl, expectedUrl, "Home is disaplayed");
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
		report.flushreport();
	}
	
	
	

}
