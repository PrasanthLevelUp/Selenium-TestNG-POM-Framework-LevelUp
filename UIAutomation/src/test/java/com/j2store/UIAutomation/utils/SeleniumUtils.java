package com.j2store.UIAutomation.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.j2store.UIAutomation.baseDrivers.BaseDriver;
import com.j2store.UIAutomation.reports.ExtentReportFiles;

public class SeleniumUtils extends BaseDriver{
	static ExtentReportFiles report;
	
	public SeleniumUtils(){
		report = new ExtentReportFiles();
	}
	
	public void clickEle(WebElement ele,String step) {
		try {
			ele.click();
			report.passlog(step);
		}catch(Exception e) {
			report.faillog(step);
		}	
	}
	
	public void jsClickEle(WebElement ele,String step) {
		try {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ele);
		report.passlog(step);
		}catch(Exception e) {
			report.faillog(step);
		}	
	}
	
	public void equalsstring(String actualUrl, String expectedUrl,String step) {
		try {
			Assert.assertEquals(actualUrl, expectedUrl);
			report.passlog(step);
			}catch(Exception e) {
				report.faillog(step);
				report.infolog(e.getMessage());
			}
	}
	
	public void containsstring(String actualUrl, String expectedUrl,String step) {
		try {
			Assert.assertTrue(actualUrl.contains(expectedUrl));
			report.passlog(step);
			}catch(Exception e) {
				report.faillog(step);
				report.infolog(e.getMessage());
			}
	}
	
	public void selectbyvisibletext(WebElement ele,String select,String step) {
		try {
		Select sel = new Select(ele);
		sel.selectByVisibleText(select);
		report.passlog(step);
		}catch(Exception e) {
			report.faillog(step);
			report.infolog(e.getMessage());
		}
	}
}
