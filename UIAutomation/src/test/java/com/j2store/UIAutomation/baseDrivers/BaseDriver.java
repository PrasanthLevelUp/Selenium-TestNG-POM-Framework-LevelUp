package com.j2store.UIAutomation.baseDrivers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseDriver {

	public static WebDriver driver;
	public static Properties prop;

	public BaseDriver() {
		try {
		prop = new Properties();
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")
				+ "\\src\\test\\java\\com\\j2store\\UIAutomation\\config\\config.properties");
		prop.load(file);
		prop.setProperty("Test", "LevelUp");
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		}

	public void launchDriver() {
		if (prop.getProperty("broswer").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("https://www.j2store.org/demo-stores.html");
			driver.manage().window().maximize();
		} else if (prop.getProperty("broswer").equals("firefox")) {
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver = new FirefoxDriver();
			driver.get("https://www.j2store.org/demo-stores.html");
			driver.manage().window().maximize();
		} else if (prop.getProperty("broswer").equals("ie")) {

		}

	}

}
