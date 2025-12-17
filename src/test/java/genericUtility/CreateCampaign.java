package genericUtility;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.comcast.crm.genricUtilities.ExcelUtilities;
import com.comcast.crm.genricUtilities.PropertiesFileUtility;

public class CreateCampaign {
	public static void main(String[] args) throws Throwable {

		// Creating Object
		PropertiesFileUtility plib = new PropertiesFileUtility();
		ExcelUtilities elib = new ExcelUtilities();

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

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(URL);
		driver.findElement(By.id("username")).sendKeys(UN);
		driver.findElement(By.id("inputPassword")).sendKeys(PW);
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();

		driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
		driver.findElement(By.name("campaignName")).sendKeys(campName);
		WebElement size = driver.findElement(By.name("targetSize"));
		size.clear();
		size.sendKeys(tarSize);
		
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[text()='Create Campaign']")).click();

		WebElement toastmsg = driver.findElement(By.xpath("//div[@role='alert']"));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(toastmsg));
		String msg = toastmsg.getText();
		if (msg.contains(campName)) {
			System.out.println("Campaign Verified and created");
		} else {
			System.out.println("Campaign not verified");
		}
		Thread.sleep(1000);

		driver.findElement(By.xpath("//button[@aria-label='close']")).click();
		WebElement icon = driver.findElement(By.xpath("//div[@class='user-icon']"));
		Actions act = new Actions(driver);
		act.moveToElement(icon).perform();
		WebElement logout = driver.findElement(By.xpath("//div[contains(text(),'Logout')]"));
		logout.click();
	}
}
