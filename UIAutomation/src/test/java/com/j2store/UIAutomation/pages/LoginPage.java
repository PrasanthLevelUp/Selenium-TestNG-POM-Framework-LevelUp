package com.j2store.UIAutomation.pages;

import org.openqa.selenium.support.PageFactory;

import com.j2store.UIAutomation.baseDrivers.BaseDriver;

public class LoginPage extends BaseDriver{

	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	
	public String getpageTitle() {
		return driver.getTitle();
	}

}
