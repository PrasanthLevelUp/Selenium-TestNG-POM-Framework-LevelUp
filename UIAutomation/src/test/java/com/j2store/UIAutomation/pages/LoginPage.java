package com.j2store.UIAutomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.j2store.UIAutomation.baseDrivers.BaseDriver;

public class LoginPage extends BaseDriver{
	
	@FindBy(xpath = "//input[@id='username']") WebElement usernameField;
	@FindBy(xpath = "//input[@id='password']") WebElement passwordField;
	@FindBy(xpath = "//button[contains(text(),'Log in')]") WebElement loginBtn;
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void login(String username,String password) {
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		loginBtn.click();
	}
	
	
	public String getpageTitle() {
		return driver.getTitle();
	}

}
