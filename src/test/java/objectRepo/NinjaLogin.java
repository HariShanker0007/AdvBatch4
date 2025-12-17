package objectRepo;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.genricUtilities.ExcelUtilities;
import com.comcast.crm.genricUtilities.JavaUtility;
import com.comcast.crm.genricUtilities.PropertiesFileUtility;
import com.comcast.crm.genricUtilities.WebDriverUtility;
import com.comcast.crm.objectRepository.LoginPage;

public class NinjaLogin {
	public static void main(String[] args) throws Throwable {
		
		
		PropertiesFileUtility plib = new PropertiesFileUtility();
		ExcelUtilities elib = new ExcelUtilities();
		JavaUtility jlib = new JavaUtility();
		WebDriverUtility wlib = new WebDriverUtility();

		// Reading the data from property file
		String BROWSER = plib.toReadDataFromPropertiesFile("browser");
		String URL = plib.toReadDataFromPropertiesFile("url");
		String UN = plib.toReadDataFromPropertiesFile("un");
		String PW = plib.toReadDataFromPropertiesFile("pw");

		// Reading the data from excel Sheet
		String campName = elib.toReadDataFromExcel("Campaign", 1, 0);
		String tarSize = elib.toReadDataFromExcel("Campaign", 1, 2);

		WebDriver driver = null;

		if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.equals("chrome")) {
			ChromeOptions options = new ChromeOptions();
			Map<String, Object> prefs = new HashMap<>();
			prefs.put("profile.password_manager_leak_detection", false);
			options.setExperimentalOption("prefs", prefs);
			driver = new ChromeDriver(options);
		} else {
			driver = new FirefoxDriver();
		}
		
		wlib.toMaximize(driver);
		wlib.waitForPageToLoad(driver);
		driver.get(URL);
		
		LoginPage lp = new LoginPage(driver);	
//		lp.getUsertf().sendKeys(UN);
//		lp.getPwtf().sendKeys(PW);
//		lp.getLoginbtn().click();
		
		lp.toLoginToApp(UN, PW);

	}
}
