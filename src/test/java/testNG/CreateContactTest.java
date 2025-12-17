package testNG;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.genricUtilities.BaseClass;
import com.comcast.crm.objectRepository.ContactPage;
import com.comcast.crm.objectRepository.CreateContactPage;
import com.comcast.crm.objectRepository.Homepage;
import com.comcast.crm.objectRepository.SelectCampaignPage;


@Listeners(com.comcast.crm.listernersUtility.Listeners.class)

public class CreateContactTest extends BaseClass {
	
	/**
	 * Login to the Ninja CRM
	 * Creates a Contact Using Mandatory Fields
	 * Logout
	 * 
	 * @param UserName
	 * @param Password
	 * 
	 * @author Hari
	 * 
	 *@return A Contact With Mandatory Fields
	 */
	@Test(groups = "smoke")
	public void createContactWithMandatoryDetails() throws Throwable {
		

		// Random Number
		int ranNum = jlib.getRandomNumber();
		
		//Hello
		
		// 10 digit Num
		String tenRanNum = jlib.getTenDigitRandomNumber() + "";

		// Reading Data from Excel Sheet
		String orgName = elib.toReadDataFromExcel("Contact", 1, 0) + ranNum;
		String title =  elib.toReadDataFromExcel("Contact", 1, 1);
		// String dep = elib.toReadDataFromExcel("Contact", 1, 2);
		// String ofcPhon = elib.toReadDataFromExcel("Contact", 1, 3);
		String contNam = elib.toReadDataFromExcel("Contact", 1, 4);
		// String mobi = elib.toReadDataFromExcel("Contact", 1, 5);
	//	 String email = elib.toReadDataFromExcel("Contact", 1, 6);

		// Creating object of homepage
		Homepage hp = new Homepage(driver);
		hp.getContactsLink().click();

		ContactPage cp = new ContactPage(driver);
		cp.getCreContBtn().click();

		String pid = driver.getWindowHandle();
		
		System.out.println(driver.getTitle());

		CreateContactPage ccp = new CreateContactPage(driver);
		ccp.createContactWithMandatory(orgName, title, contNam, tenRanNum);
		//ccp.getPlusIcon().click();

//		switch driver control to child window

		wlib.switchToChildWindow(driver);
		Thread.sleep(1000);
		System.out.println(driver.getTitle());

		SelectCampaignPage scp = new SelectCampaignPage(driver);
		scp.getSelBtn().click();

		wlib.switchToParentWindow(driver, pid);

		ccp.getCreConBtn().click();

		// Verify the toast msg
		
		//hp.verifyMsg(driver, contNam);
		WebElement toastMsg = driver.findElement(By.xpath("//div[@role='alert']"));
		wlib.waitForVisibilityOfElement(driver, toastMsg);
		String msg = toastMsg.getText();
		System.out.println(msg);
		SoftAssert check = new SoftAssert();
		check.assertEquals(msg,"Contact "+contNam+" Successfully Added");
		driver.findElement(By.xpath("//button[@aria-label='close']")).click();
		check.assertAll();
		

	}
}
