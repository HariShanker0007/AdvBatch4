package com.comcast.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignPage {
	WebDriver driver;

	public CreateCampaignPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(name = "campaignId")
	private WebElement idtf;
	
	@FindBy(name = "campaignName")
	private WebElement nametf;
	
	@FindBy(name = "campaignStatus")
	private WebElement statustf;
	
	@FindBy(name = "targetSize")
	private WebElement sizetf;
	
	@FindBy(name = "expectedCloseDate")
	private WebElement closeDatetf;
	
	@FindBy(name = "targetAudience")
	private WebElement tarAudtf;
	
	@FindBy(name = "description")
	private WebElement descriptiontf;
	
	@FindBy(xpath = "//span[text()='Create Campaign']")
	private WebElement createCampaignbutton;
	
	@FindBy(xpath = "//button[text()='Create Campaign']")
	private WebElement createcampEndbtn;
	
	public WebElement getCreatecampEndbtn() {
		return createcampEndbtn;
	}

	@FindBy(xpath = "//div[@role='alert']")
	private WebElement verifyToastMsg;
	
	@FindBy(xpath = "//button[@aria-label='close']")
	private WebElement closeMessageBtn;

	public WebElement getIdtf() {
		return idtf;
	}

	public WebElement getNametf() {
		return nametf;
	}

	public WebElement getStatustf() {
		return statustf;
	}

	public WebElement getSizetf() {
		return sizetf;
	}

	public WebElement getCloseDatetf() {
		return closeDatetf;
	}

	public WebElement getTarAudtf() {
		return tarAudtf;
	}

	public WebElement getDescriptiontf() {
		return descriptiontf;
	}

	public WebElement getCreateCampaignbutton() {
		return createCampaignbutton;
	}

	public WebElement getVerifyToastMsg() {
		return verifyToastMsg;
	}

	public WebElement getCloseMessageBtn() {
		return closeMessageBtn;
	}
	
	public void createCampaignWithMandatoryDetails(String Campaignname,String targetSize) throws Throwable {
		nametf.sendKeys(Campaignname);
		sizetf.clear();
		sizetf.sendKeys(targetSize);
		createcampEndbtn.click();
	}	
	
	public void createCampaignWithCloseDate(String Campaignname,String targetSize,String ExpectedDate) throws Throwable {
		nametf.sendKeys(Campaignname);
		sizetf.clear();
		sizetf.sendKeys(targetSize);
		closeDatetf.sendKeys(ExpectedDate);	
		createcampEndbtn.click();
	}
	
	public void createCampaignWithStatus(String Campaignname,String status,String targetSize,String ExpectedDate) throws Throwable {
		nametf.sendKeys(Campaignname);
		statustf.sendKeys(status);
		sizetf.clear();
		sizetf.sendKeys(targetSize);
		closeDatetf.sendKeys(ExpectedDate);
		createcampEndbtn.click();
	}
}
