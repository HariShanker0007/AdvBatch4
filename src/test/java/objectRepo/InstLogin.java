package objectRepo;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import com.comcast.crm.objectRepository.InstaLoginPage;

public class InstLogin {
public static void main(String[] args) throws Throwable {
	
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	
	driver.get("https://www.instagram.com/");
	
	InstaLoginPage ilp= new InstaLoginPage(driver);
	ilp.getUn().sendKeys("Hari");
	ilp.getPw().sendKeys("Hari");
	Thread.sleep(2000);
	driver.navigate().refresh();
	ilp.getUn().sendKeys("Hari");
	ilp.getPw().sendKeys("Hari");
	
}
}
