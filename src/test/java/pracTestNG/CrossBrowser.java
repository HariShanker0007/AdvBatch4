package pracTestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowser {

    WebDriver driver;

    @Parameters("browser")
    @BeforeClass
    public void setup(String browser) {
        System.out.println("Browser received: " + browser);

        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            driver = new ChromeDriver(options);

        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();

        } else {
            throw new RuntimeException("Invalid browser name!!");
        }

        driver.manage().window().maximize();
    }

    @Test
    public void testGoogle() throws Exception {
        driver.get("https://google.com");
        System.out.println("Title on " + driver.getTitle() + 
                           " | Thread: " + Thread.currentThread().getId());
    }
}

