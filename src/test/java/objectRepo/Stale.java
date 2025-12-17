package objectRepo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Stale {
public static void main(String[] args) throws Throwable {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	
	driver.get("https://www.netflix.com/in/");
	
	WebElement email = driver.findElement(By.id(":r0:"));
	email.sendKeys("Hari");
	Thread.sleep(2000);
	driver.navigate().refresh();
	email.sendKeys("Hari");
	
}
}
