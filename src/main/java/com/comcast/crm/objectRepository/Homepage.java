package com.comcast.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.genricUtilities.WebDriverUtility;

import junit.framework.Assert;

public class Homepage extends WebDriverUtility {
	WebDriver driver;

	public Homepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Create Campaign']")
	private WebElement createCampaignBtn;

	@FindBy(linkText = "Campaigns")
	private WebElement CampaignLink;

	@FindBy(linkText = "Contacts")
	private WebElement ContactsLink;

	@FindBy(linkText = "Leads")
	private WebElement LeadsLink;

	@FindBy(linkText = "Opportunities")
	private WebElement OpportunitiesLink;

	@FindBy(linkText = "Products")
	private WebElement ProductsLink;

	@FindBy(linkText = "Quotes")
	private WebElement QuotesLink;

	@FindBy(linkText = "Purchase Order")
	private WebElement PurchaseOrderLink;

	@FindBy(linkText = "Sales Order")
	private WebElement SalesOrderLink;

	@FindBy(linkText = "Invoice")
	private WebElement InvoiceLink;

	@FindBy(xpath = "//li[text()=\"Admin Console\"]")
	private WebElement AdminConsole;

	@FindBy(xpath = "//*[name()='svg' and @data-icon='user']")
	private WebElement usericonlogo;

	@FindBy(xpath = "//div[text()='Logout ']")
	private WebElement logoutbtn;

	@FindBy(xpath = "//div[text()='Create User']")
	private WebElement createuser;

	@FindBy(xpath = "//div[text()='View Users']")
	private WebElement viewuser;

	@FindBy(xpath = "//div[@role='alert']")
	private WebElement verifyToastMsg;

	@FindBy(xpath = "//button[@aria-label='close']")
	private WebElement closeMessageBtn;

	public WebElement getCloseMessageBtn() {
		return closeMessageBtn;
	}

	public WebElement getVerifyToastMsg() {
		return verifyToastMsg;
	}

	public WebElement getCreateCampaignBtn() {
		return createCampaignBtn;
	}

	public WebElement getCampaignLink() {
		return CampaignLink;
	}

	public WebElement getContactsLink() {
		return ContactsLink;
	}

	public WebElement getLeadsLink() {
		return LeadsLink;
	}

	public WebElement getOpportunitiesLink() {
		return OpportunitiesLink;
	}

	public WebElement getProductsLink() {
		return ProductsLink;
	}

	public WebElement getQuotesLink() {
		return QuotesLink;
	}

	public WebElement getPurchaseOrderLink() {
		return PurchaseOrderLink;
	}

	public WebElement getSalesOrderLink() {
		return SalesOrderLink;
	}

	public WebElement getInvoiceLink() {
		return InvoiceLink;
	}

	public WebElement getAdminConsole() {
		return AdminConsole;
	}

	public WebElement getUsericonlogo() {
		return usericonlogo;
	}

	public WebElement getLogoutbtn() {
		return logoutbtn;
	}

	public WebElement getCreateuser() {
		return createuser;
	}

	public WebElement getViewuser() {
		return viewuser;
	}

	public void createUser(WebDriver driver) throws Throwable {
		Thread.sleep(1000);
		mouseHoverOnWebelemment(driver, AdminConsole);
		createuser.click();
	}

	/**
	 * This method will mouse hover on admin console and click on view user
	 * 
	 * @param driver
	 * @throws Throwable
	 */
	public void viewUser(WebDriver driver) throws Throwable {
		Thread.sleep(1000);
		mouseHoverOnWebelemment(driver, AdminConsole);
		viewuser.click();
	}

	/**
	 * 
	 * @param driver
	 * @throws Throwable
	 */
	public void logOut(WebDriver driver) throws Throwable {
		mouseHoverOnWebelemment(driver, getUsericonlogo());
		Thread.sleep(1000);
		logoutbtn.click();
	}

	/**
	 * This method is used to Verify the toast msg
	 * 
	 * @param driver
	 * @return
	 */

	public String verifyMsg(WebDriver driver, String textMsg) throws Throwable {
		WebDriverUtility wlib = new WebDriverUtility();
		wlib.waitForVisibilityOfElement(driver,verifyToastMsg);
		String msg = verifyToastMsg.getText();
		System.out.println(msg);
		Assert.assertEquals(msg,"Campaign "+textMsg+" Successfully Added");
		closeMessageBtn.click();
		Thread.sleep(1000);
		return msg;
	}
}
