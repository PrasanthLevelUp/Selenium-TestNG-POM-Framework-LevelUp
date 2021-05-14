package com.j2store.UIAutomation.baseDrivers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseDriver {

	public static WebDriver driver;
	public static Properties prop;
	public static File excelfile;
	public static FileInputStream fis;
	public static XSSFWorkbook xlsxbook;
	public static String TCName;

	public BaseDriver() {
		try {
		//Property File setup	
		prop = new Properties();
		FileInputStream propfile = new FileInputStream(System.getProperty("user.dir")
				+ "\\src\\test\\java\\com\\j2store\\UIAutomation\\config\\config.properties");
		prop.load(propfile);
		
		//excel file setup
		excelfile = new File(System.getProperty("user.dir")+prop.getProperty("testdatapath"));
		fis = new FileInputStream(excelfile);
		xlsxbook = new XSSFWorkbook(fis);
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		}

	public void launchDriver() {
		if (prop.getProperty("broswer").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(prop.getProperty("QAURL"));
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
