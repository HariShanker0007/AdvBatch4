package ddt;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
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

public class CreateCampaignUsingDDT {
	public static void main(String[] args) throws Throwable {

		// Reading the Data from Properties Files
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\Lenovo-QSP\\OneDrive\\Desktop\\CommonData\\propertyData.properties");
		Properties prop = new Properties();
		prop.load(fis);

		String BROWSER = prop.getProperty("browser");
		String URL = prop.getProperty("url");
		String UN = prop.getProperty("un");
		String PW = prop.getProperty("pw");

		// Reading The data from Excel File
		FileInputStream fis2 = new FileInputStream("C:\\Users\\Lenovo-QSP\\OneDrive\\Desktop\\Excel\\Campaign.xlsx");
		Workbook wb = WorkbookFactory.create(fis2);
		String CampName = wb.getSheet("Campaign").getRow(1).getCell(0).getStringCellValue();
		String TarSize = wb.getSheet("Campaign").getRow(1).getCell(2).getStringCellValue();

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
		Thread.sleep(2000);

		driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
		driver.findElement(By.name("campaignName")).sendKeys(CampName);
		WebElement size = driver.findElement(By.name("targetSize"));
		size.clear();
		size.sendKeys(TarSize);
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[text()='Create Campaign']")).click();

		WebElement toastmsg = driver.findElement(By.xpath("//div[@role='alert']"));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(toastmsg));
		String msg = toastmsg.getText();
		if (msg.contains(CampName)) {
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
