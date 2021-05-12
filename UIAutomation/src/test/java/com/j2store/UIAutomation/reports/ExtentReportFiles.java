package com.j2store.UIAutomation.reports;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.j2store.UIAutomation.baseDrivers.BaseDriver;

public class ExtentReportFiles extends BaseDriver{
	
	public static ExtentReports extent = new ExtentReports();
	public static ExtentSparkReporter spark;
	public static ExtentTest test;
	
	public ExtentReportFiles(String TC){
		spark = new ExtentSparkReporter(System.getProperty("user.dir")+"/target/reports.html");
		extent.attachReporter(spark);
		test = extent.createTest(TC);
	}
	
	public void passlog(String step) {
		test.log(Status.PASS, step);
		if(prop.getProperty("passscreenshot").equals("true")) {
		test.addScreenCaptureFromPath(takeScreenShot(driver));
		}
	}
	public void faillog(String step) {
		test.log(Status.FAIL, step);
		if(prop.getProperty("failscreenshot").equals("true")) {
		test.addScreenCaptureFromPath(takeScreenShot(driver));
		}
	}
	public void infolog(String step) {
		test.log(Status.INFO, step);
	}
	
	public void flushreport() {
		extent.flush();
	}
	
	public String takeScreenShot(WebDriver driver) {
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		String filename = System.currentTimeMillis() + ".png";
		String des = "./target/Images/" + filename;

		File DestFile = new File(des);
		try {
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return des;
	}
}
