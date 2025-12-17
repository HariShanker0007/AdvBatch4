package pracTestNG;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.comcast.crm.objectRepository.CreateCampaignPage;
import com.comcast.crm.objectRepository.Homepage;
import com.comcast.crm.objectRepository.LoginPage;

import com.comcast.crm.genricUtilities.ExcelUtilities;
import com.comcast.crm.genricUtilities.JavaUtility;
import com.comcast.crm.genricUtilities.PropertiesFileUtility;
import com.comcast.crm.genricUtilities.WebDriverUtility;

public class BasicCreateCamp {

	@Test(priority = -1,invocationCount = 7,threadPoolSize = 4,enabled = false)
	public void createCampWithMandDetails() throws Throwable {
		// Create object of utilities
		PropertiesFileUtility plib = new PropertiesFileUtility();
		ExcelUtilities elib = new ExcelUtilities();
		JavaUtility jlib = new JavaUtility();
		WebDriverUtility wlib = new WebDriverUtility();

		// Reading the data from properties Files
		String BROWSER = plib.toReadDataFromPropertiesFile("browser");
		String URL = plib.toReadDataFromPropertiesFile("url");
		String UN = plib.toReadDataFromPropertiesFile("un");
		String PW = plib.toReadDataFromPropertiesFile("pw");

		// Reading Data from Excel Sheet
		String campName = elib.toReadDataFromExcel("Campaign", 1, 0);
		String tarSize = elib.toReadDataFromExcel("Campaign", 1, 2);

		WebDriver driver = null;
		if (BROWSER.equals("chrome")) {
			ChromeOptions options = new ChromeOptions();
			Map<String, Object> prefs = new HashMap<>();
			prefs.put("profile.password_manager_leak_detection", false);
			options.setExperimentalOption("prefs", prefs);
			driver = new ChromeDriver(options);
		} else if (BROWSER.equals("edge")) {
			// WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			driver = new FirefoxDriver();
		}

		// Maximizing and entering the URL
		wlib.toMaximize(driver);
		wlib.waitForPageToLoad(driver);
		driver.get(URL);

		// Logging In using Propeties Files and POM
		LoginPage lp = new LoginPage(driver);
		lp.toLoginToApp(UN, PW);

		// Clicking on the create Campaign Button in the home page
		Homepage hp = new Homepage(driver);
		hp.getCreateCampaignBtn().click();

		// Creating the object of CreateCampaign page and Creating a campaign with
		// Mandatory Fields
		CreateCampaignPage cp = new CreateCampaignPage(driver);
		cp.createCampaignWithMandatoryDetails(campName, tarSize);

		// Verify the toast msg
		hp.verifyMsg(driver, campName);

		// Logging out the closing the browser
		hp.logOut(driver);
		Thread.sleep(1000);
		driver.quit();
	}

	@Test(dependsOnMethods ="createCampWithMandDetails" )
	public void createCampWithStatus() throws Throwable {
		// Create object of utilities
		PropertiesFileUtility plib = new PropertiesFileUtility();
		ExcelUtilities elib = new ExcelUtilities();
		JavaUtility jlib = new JavaUtility();
		WebDriverUtility wlib = new WebDriverUtility();

		// Reading the data from properties Files
		String BROWSER = plib.toReadDataFromPropertiesFile("browser");
		String URL = plib.toReadDataFromPropertiesFile("url");
		String UN = plib.toReadDataFromPropertiesFile("un");
		String PW = plib.toReadDataFromPropertiesFile("pw");

		// Reading Data from Excel Sheet
		String campName = elib.toReadDataFromExcel("Campaign", 1, 0);
		String status = elib.toReadDataFromExcel("Campaign", 1, 1);
		String tarSize = elib.toReadDataFromExcel("Campaign", 1, 2);

		// Get the Date
		String reqDate = jlib.toGetReqDate(30);

		WebDriver driver = null;
		if (BROWSER.equals("chrome")) {
			ChromeOptions options = new ChromeOptions();
			Map<String, Object> prefs = new HashMap<>();
			prefs.put("profile.password_manager_leak_detection", false);
			options.setExperimentalOption("prefs", prefs);
			driver = new ChromeDriver(options);
		} else if (BROWSER.equals("edge")) {
			// WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			driver = new FirefoxDriver();
		}

		// Maximizing and entering the URL
		wlib.toMaximize(driver);
		wlib.waitForPageToLoad(driver);
		driver.get(URL);

		// Logging In using Propeties Files and POM
		LoginPage lp = new LoginPage(driver);
		lp.toLoginToApp(UN, PW);

		// Clicking on the create Campaign Button in the home page
		Homepage hp = new Homepage(driver);
		hp.getCreateCampaignBtn().click();

		// Creating the object of CreateCampaign page and Creating a campaign with
		// Mandatory Fields
		CreateCampaignPage cp = new CreateCampaignPage(driver);
		cp.createCampaignWithStatus(campName, status, tarSize, reqDate);

		// Verify the toast msg
		hp.verifyMsg(driver, campName);

		// Logging out the closing the browser
		hp.logOut(driver);
		Thread.sleep(1000);
		driver.quit();
	}
	
	@Test(dependsOnMethods ="createCampWithMandDetails")
	public void createCampWithExpCloseDate() throws Throwable {
		// Create object of utilities
		PropertiesFileUtility plib = new PropertiesFileUtility();
		ExcelUtilities elib = new ExcelUtilities();
		JavaUtility jlib = new JavaUtility();
		WebDriverUtility wlib = new WebDriverUtility();

		// Reading the data from properties Files
		String BROWSER = plib.toReadDataFromPropertiesFile("browser");
		String URL = plib.toReadDataFromPropertiesFile("url");
		String UN = plib.toReadDataFromPropertiesFile("un");
		String PW = plib.toReadDataFromPropertiesFile("pw");

		// Reading Data from Excel Sheet
		String campName = elib.toReadDataFromExcel("Campaign", 1, 0);
		String tarSize = elib.toReadDataFromExcel("Campaign", 1, 2);

		// Get the Date
		String reqDate = jlib.toGetReqDate(30);

		WebDriver driver = null;
		if (BROWSER.equals("chrome")) {
			ChromeOptions options = new ChromeOptions();
			Map<String, Object> prefs = new HashMap<>();
			prefs.put("profile.password_manager_leak_detection", false);
			options.setExperimentalOption("prefs", prefs);
			driver = new ChromeDriver(options);
		} else if (BROWSER.equals("edge")) {
			// WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			driver = new FirefoxDriver();
		}

		// Maximizing and entering the URL
		wlib.toMaximize(driver);
		wlib.waitForPageToLoad(driver);
		driver.get(URL);

		// Logging In using Propeties Files and POM
		LoginPage lp = new LoginPage(driver);
		lp.toLoginToApp(UN, PW);

		// Clicking on the create Campaign Button in the home page
		Homepage hp = new Homepage(driver);
		hp.getCreateCampaignBtn().click();

		// Creating the object of CreateCampaign page and Creating a campaign with
		// Mandatory Fields
		CreateCampaignPage cp = new CreateCampaignPage(driver);
		cp.createCampaignWithCloseDate(campName, tarSize, reqDate);

		// Verify the toast msg
		hp.verifyMsg(driver, campName);

		// Logging out the closing the browser
		hp.logOut(driver);
		Thread.sleep(1000);
		driver.quit();
	}

}
