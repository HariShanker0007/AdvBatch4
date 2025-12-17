package pracTcs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateCampBasic {
	public static void main(String[] args) throws Throwable {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		// to read data from prop files

		// step 1
		FileInputStream fis = new FileInputStream("C:\\Users\\Lenovo-QSP\\OneDrive\\Desktop\\CommonData\\propertyData.properties");

		// step 2
		Properties prop = new Properties();

		// step 3
		prop.load(fis);

		// Step 4
		String BROWSER = prop.getProperty("browser");
		String URL = prop.getProperty("url");
		String UN = prop.getProperty("un");
		String PW = prop.getProperty("pw");

		driver.get(URL);
		driver.findElement(By.id("username")).sendKeys(UN);
		driver.findElement(By.id("inputPassword")).sendKeys(PW);
		driver.findElement(By.xpath("//button[.='Sign In']")).click();
		driver.findElement(By.xpath("//span[.='Create Campaign']")).click();
		driver.findElement(By.name("campaignName")).sendKeys("instmaaa");
		WebElement tarSize = driver.findElement(By.name("targetSize"));
		tarSize.clear();
		tarSize.sendKeys("4");
		driver.findElement(By.xpath("//button[.='Create Campaign']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@aria-label='close']")).click();
		Actions act = new Actions(driver);
		WebElement icon = driver.findElement(By.xpath("//div[@class='user-icon']"));
		// act.moveToElement(icon).perform();
		icon.click();
		driver.findElement(By.xpath("//div[.='Logout ']")).click();
	}
}
