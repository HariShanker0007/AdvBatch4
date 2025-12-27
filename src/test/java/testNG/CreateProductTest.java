package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.genricUtilities.BaseClass;
import com.comcast.crm.genricUtilities.ExcelUtilities;
import com.comcast.crm.genricUtilities.JavaUtility;
import com.comcast.crm.objectRepository.CreateProductPage;
import com.comcast.crm.objectRepository.Homepage;
import com.comcast.crm.objectRepository.ProductPage;

@Listeners(com.comcast.crm.listernersUtility.Listeners.class)

public class CreateProductTest extends BaseClass {

	/**
	 * Login to the Ninja CRM Creates a Product Using Mandatory Fields Logout
	 * 
	 * @param UserName
	 * @param Password
	 * 
	 * @author Hari
	 * 
	 * @return A Product With Mandatory Fields
	 */
	@Test(groups = "smoke")
	public void createProductWithMandatoryDetails() throws Throwable {

		// Creating Object of Utilities
		ExcelUtilities elib = new ExcelUtilities();
		JavaUtility jlib = new JavaUtility();

		int ranNum = jlib.getRandomNumber();

		// Reading Data from Excel Sheet
		String ProdName = elib.toReadDataFromExcel("Product", 1, 0) + ranNum;
		String Drop1 = elib.toReadDataFromExcel("Product", 1, 1);
		String Quan = elib.toReadDataFromExcel("Product", 1, 2);
		String Price = elib.toReadDataFromExcel("Product", 1, 3);
		String Drop2 = elib.toReadDataFromExcel("Product", 1, 4);

		// Clicking on the create Campaign Button in the home page
		Homepage hp = new Homepage(driver);
		hp.getProductsLink().click();

		ProductPage pp = new ProductPage(driver);
		pp.getAddProd().click();

		// Creating the object of CreateCampaign page and Creating a campaign with
		// Mandatory Fields
		CreateProductPage cpp = new CreateProductPage(driver);
		cpp.createProductWithMandatoryDetails(ProdName, Drop1, Quan, Price, Drop2);
		// Verify the toast msg
		// hp.verifyMsg(driver, ProdName);
		WebElement toastMsg = driver.findElement(By.xpath("//div[@role='alert']"));
		wlib.waitForVisibilityOfElement(driver, toastMsg);
		String msg = toastMsg.getText();
		System.out.println(msg);
		SoftAssert check = new SoftAssert();
		check.assertEquals(msg, "Product " + ProdName + " Successfully Added");
		driver.findElement(By.xpath("//button[@aria-label='close']")).click();
		check.assertAll();
		
		System.out.println("Product Successfully done from my end");
		
	}
}

