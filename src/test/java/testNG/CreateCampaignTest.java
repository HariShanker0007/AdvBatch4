package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.genricUtilities.BaseClass;
import com.comcast.crm.objectRepository.CreateCampaignPage;
import com.comcast.crm.objectRepository.Homepage;

@Listeners(com.comcast.crm.listernersUtility.Listeners.class)
public class CreateCampaignTest extends BaseClass {

	@Test(groups = "smoke")
	public void createCampaignWithMandatoryDetails() throws Throwable {

		// Creating Object of Utilities
		Homepage hp = new Homepage(driver);
		hp.getCreateCampaignBtn().click();

		// Reading the data from excel Sheet
		String campName = elib.toReadDataFromExcel("Campaign", 1, 0);
		String tarSize = elib.toReadDataFromExcel("Campaign", 1, 2);

		CreateCampaignPage ccp = new CreateCampaignPage(driver);
		ccp.createCampaignWithMandatoryDetails(campName, tarSize);

		// Verify the toast msg

		WebElement toastMsg = driver.findElement(By.xpath("//div[@role='alert']"));
		wlib.waitForVisibilityOfElement(driver, toastMsg);
		String msg = toastMsg.getText();
		System.out.println(msg);
		SoftAssert check = new SoftAssert();
		check.assertEquals(msg, "Campaign " + campName + " Successfully Added");
		driver.findElement(By.xpath("//button[@aria-label='close']")).click();
		check.assertAll();
	}

	@Test(priority = 1)
	public void createCampaignWithStatus() throws Throwable {

		// Reading the data from excel Sheet
		String campName = elib.toReadDataFromExcel("Campaign", 1, 0);
		String status = elib.toReadDataFromExcel("Campaign", 1, 1);
		String tarSize = elib.toReadDataFromExcel("Campaign", 1, 2);

		// To get expected close dates
		String reqDate = jlib.toGetReqDate(21);

		// Creating Object
		Homepage hp = new Homepage(driver);
		hp.getCreateCampaignBtn().click();

		CreateCampaignPage ccp = new CreateCampaignPage(driver);
		ccp.createCampaignWithStatus(campName, status, tarSize, reqDate);

		// To verify and close
		WebElement toastMsg = driver.findElement(By.xpath("//div[@role='alert']"));
		wlib.waitForVisibilityOfElement(driver, toastMsg);
		String msg = toastMsg.getText();
		System.out.println(msg);
		SoftAssert check = new SoftAssert();
		check.assertEquals(msg, "Campaign " + campName + " Successfully Added");
		driver.findElement(By.xpath("//button[@aria-label='close']")).click();

		System.out.println("createCampaignWithMandatoryDetails Executed Successfully");

		System.out.println("createCampaignWithStatus Executed Successfully");
		check.assertAll();
	}

	@Test(priority = 2)
	public void createCampaignWithExpectedCloseDate() throws Throwable {

		// Reading the data from excel Sheet
		String campName = elib.toReadDataFromExcel("Campaign", 1, 0);
		String tarSize = elib.toReadDataFromExcel("Campaign", 1, 2);

		// to get expected close Date
		String closeDate = jlib.toGetReqDate(30);

		// Creating Object
		Homepage hp = new Homepage(driver);
		hp.getCreateCampaignBtn().click();

		CreateCampaignPage ccp = new CreateCampaignPage(driver);
		ccp.createCampaignWithCloseDate(campName, tarSize, closeDate);

		// To verify and close
		WebElement toastMsg = driver.findElement(By.xpath("//div[@role='alert']"));
		wlib.waitForVisibilityOfElement(driver, toastMsg);
		String msg = toastMsg.getText();
		System.out.println(msg);
		SoftAssert check = new SoftAssert();
		check.assertEquals(msg, "Campaign " + campName + " Successfully Added");
		driver.findElement(By.xpath("//button[@aria-label='close']")).click();

		System.out.println("createCampaignWithMandatoryDetails Executed Successfully");

		System.out.println("createCampaignWithExpectedCloseDate Executed Successfully");
		check.assertAll();

	}
}
