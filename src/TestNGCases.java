import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGCases {
	
	WebDriver driver;
	String browser="chrome";
	String url="https://www.redbus.in/";
	
	@BeforeClass
	public void initialiseBrowser() {

		// Driver setup --> In the current version of Selenium jar package, all 4 browser's drivers are added by default
		// System.setProperty("webdriver.chrome.driver.","C:\\My Folder\\7-Learning\\QA\\Dependencies\\Web Drivers\\Chrome\\chromedriver-win64\\chromedriver.exe");
									
		if (browser=="chrome") {
			driver= new ChromeDriver();
		}
		else if (browser.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		else if (browser.equals("edge")) {
			driver=new EdgeDriver();
		}
	}
	
	@BeforeClass
	public void loadURL() {
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@Test
	public void verifyPageLoaded() {
		// Verify page load with page title
		String expectedTitle="Book bus tickets online with redBus!";
		String actualTitle=driver.getTitle();
		System.out.println(actualTitle);
		
		Assert.assertTrue(expectedTitle.equals(actualTitle));
		System.out.println("Correct page is loaded");
	}
	
	@AfterClass
	public void quitBrowser() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
		System.out.println("...Program End");
	}
}