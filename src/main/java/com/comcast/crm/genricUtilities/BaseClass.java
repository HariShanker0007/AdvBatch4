package com.comcast.crm.genricUtilities;

import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.comcast.crm.objectRepository.Homepage;
import com.comcast.crm.objectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public WebDriver driver = null;
	public static WebDriver sdriver = null;
	public PropertiesFileUtility plib = new PropertiesFileUtility();
	public WebDriverUtility wlib = new WebDriverUtility();
	public ExcelUtilities elib = new ExcelUtilities();
	public JavaUtility jlib = new JavaUtility();

	@BeforeSuite(groups = "smoke")
	public void beforeSuite() {
		System.out.println("Connecting to DataBase");
	}

	@BeforeTest(groups = "smoke")
	public void beforeTest() {
		System.out.println("Pre Conditions");
	}

//	@Parameters("browser")
	@BeforeClass(groups = "smoke")
	public void beforeClass() throws Throwable {
		String BROWSER = plib.toReadDataFromPropertiesFile("browser");
		if (BROWSER.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (BROWSER.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			Map<String, Object> prefs = new HashMap<>();
			prefs.put("profile.password_manager_leak_detection", false);
			options.setExperimentalOption("prefs", prefs);
			driver = new ChromeDriver(options);
		} else {
			driver = new FirefoxDriver();
		}
		sdriver = driver;//Passing driver ref to static variable

		wlib.toMaximize(driver);
		wlib.waitForPageToLoad(driver);
		System.out.println("Browser Launched");
	}

	@BeforeMethod(groups = "smoke")
	public void beforeMethod() throws Throwable {
		String URL = plib.toReadDataFromPropertiesFile("url");
		String UN = plib.toReadDataFromPropertiesFile("un");
		String PW = plib.toReadDataFromPropertiesFile("pw");
		driver.get(URL);

		LoginPage lp = new LoginPage(driver);
		lp.toLoginToApp(UN, PW);
		System.out.println("Login Done");

	}

	@AfterMethod(groups = "smoke")
	public void afterMethod() throws Throwable {
		Homepage hp = new Homepage(driver);
		hp.logOut(driver);
	}

	@AfterClass(groups = { "smoke", "regression" })
	public void AfterClass() {
		Reporter.log("closing browser", true);
		driver.quit();
	}

	@AfterTest(groups = "smoke")
	public void afterTest() {
		Reporter.log("Post Conditions", true);
	}

	@AfterSuite(groups = "smoke")
	public void afterSuite() {
		Reporter.log("Disconnect DB", true);
	}

}
