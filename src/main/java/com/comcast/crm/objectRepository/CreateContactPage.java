package com.comcast.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CreateContactPage {
	WebDriver driver;

	public CreateContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "organizationName")
	private WebElement orgName;

	@FindBy(name = "title")
	private WebElement title;

	@FindBy(name = "department")
	private WebElement department;

	@FindBy(name = "officePhone")
	private WebElement officePhone;

	@FindBy(name = "contactName")
	private WebElement contactName;

	@FindBy(name = "mobile")
	private WebElement mobile;

	@FindBy(name = "email")
	private WebElement email;

	@FindBy(xpath = "(//*[name()='svg' and @data-icon='plus'])")
	private WebElement plusIcon;

	@FindBy(xpath = "(//button[.='Create Contact'])")
	private WebElement creConBtn;

	public WebElement getOrgName() {
		return orgName;
	}

	public WebElement getTitle() {
		return title;
	}

	public WebElement getDepartment() {
		return department;
	}

	public WebElement getOfficePhone() {
		return officePhone;
	}

	public WebElement getContactName() {
		return contactName;
	}

	public WebElement getMobile() {
		return mobile;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPlusIcon() {
		return plusIcon;
	}

	
	public WebElement getCreConBtn() {
		return creConBtn;
	}

	public void createContactWithMandatory(String OrgName, String titles, String contname, String tenRanNum) throws Throwable {
		orgName.sendKeys(OrgName);
		title.sendKeys(titles);
		contactName.sendKeys(contname);
		mobile.sendKeys(tenRanNum + "");
		plusIcon.click();
 } 
	
}
