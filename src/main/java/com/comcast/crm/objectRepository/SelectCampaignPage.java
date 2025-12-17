package com.comcast.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectCampaignPage {
	WebDriver driver;

	public SelectCampaignPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "search-input")
	private WebElement searchTf;
	
	@FindBy(xpath = "//button[contains(@onclick,'CAM00001')]")
	private WebElement selBtn;

	public WebElement getSearchTf() {
		return searchTf;
	}

	public WebElement getSelBtn() {
		return selBtn;
	}
	
}
