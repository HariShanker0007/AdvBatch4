package com.comcast.crm.objectRepository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.genricUtilities.WebDriverUtility;

	public class LoginPage extends WebDriverUtility{
		WebDriver driver;

		public LoginPage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}

		//Auto healing concept using 2 locators on the same webelement
		
		//@FindAll any one of the locators must be true
		@FindAll({@FindBy(id = "username"),@FindBy(name = "username")})
		private WebElement username;
		
		//@FindBys ---> 2Locators must be true
		@FindBy(id = "inputPassword")
		private WebElement password;
		
		@FindBy(xpath = "//button[text()='Sign In']")
		private WebElement loginbtn;

		public WebElement getUsertf() {
			return username;
		}

		public WebElement getPwtf() {
			return password;
		}

		public WebElement getLoginbtn() {
			return loginbtn;
		}
		
		public void toLoginToApp(String un,String pw) {
			username.sendKeys(un);
			password.sendKeys(pw);
			loginbtn.click();
		}
}
