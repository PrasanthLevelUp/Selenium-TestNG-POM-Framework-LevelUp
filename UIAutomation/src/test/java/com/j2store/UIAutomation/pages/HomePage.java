package com.j2store.UIAutomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.j2store.UIAutomation.baseDrivers.BaseDriver;

public class HomePage extends BaseDriver {
	
	@FindBy(xpath="//a[contains(text(),'Login')]") WebElement loginBtn; 
	@FindBy(xpath="//p/a[contains(text(),'Demo')]") WebElement demoBtn; 
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage clickLogin() {
		loginBtn.click();
		return new LoginPage();
	}
	
	
}
