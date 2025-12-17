package pracTestNG;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class IfElse {
	@Test
	public void DemoAssert() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get("https://demowebshop.tricentis.com/");

		String expTitle = "Demo Web Shopss";

		String actual_Title = driver.getTitle();

		// Hard Assert
//		Assert.assertEquals(actual_Title, expTitle);
//		System.out.println("Navigation Done");

		// Soft Assert

		SoftAssert asserts = new SoftAssert();
		asserts.assertEquals(actual_Title, expTitle);
		System.out.println("Navigation Done");
		asserts.assertAll();
	}
}
