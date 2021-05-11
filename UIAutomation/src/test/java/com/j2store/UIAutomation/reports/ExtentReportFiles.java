package com.j2store.UIAutomation.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportFiles {
	
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
	}
	public void faillog(String step) {
		test.log(Status.FAIL, step);
	}
	public void infolog(String step) {
		test.log(Status.INFO, step);
	}
	
	public void flushreport() {
		extent.flush();
	}
}
