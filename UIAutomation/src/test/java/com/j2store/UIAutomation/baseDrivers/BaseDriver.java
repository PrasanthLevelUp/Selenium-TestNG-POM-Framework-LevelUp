package com.j2store.UIAutomation.baseDrivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseDriver {
	
	public WebDriver driver;
	
	public void launchDriver() {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.j2store.org/demo-stores.html");
		driver.manage().window().maximize();
	}

}
