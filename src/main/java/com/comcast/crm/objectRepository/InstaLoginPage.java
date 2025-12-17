package com.comcast.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InstaLoginPage {

	WebDriver driver;

	
	public InstaLoginPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name = "username")
	private WebElement un;
	
	@FindBy(name = "password")
	private WebElement pw;
	
	public WebElement getUn() {
		return un;
	}

	public WebElement getPw() {
		return pw;
	}

	
}
