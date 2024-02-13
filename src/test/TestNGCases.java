package test;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Resources.base;

public class TestNGCases extends base{
	
	//WebDriver driver=null;
	
	@BeforeClass
	public void SetValuesTest() throws IOException {
		System.out.println("Test initializing...");
		initializeValues();
		driver=initializeBrowser();
		System.out.println("Browser: " + browserValue);
		System.out.println("URL: " + urlValue);
		System.out.println("Test initialized.");
	}
	
	@Test
	public void homePageTest() throws InterruptedException {
		//WebDriverManager.chromedriver().setup(); // Not needed since DriverManager is set by latest selenium jars and maven by default
		driver.get(urlValue);
		driver.manage().window().maximize();
		System.out.println("Loaded URL: " + urlValue);
		//String expectedTitle="Online Bus Ticket Booking with Best Offers and Lowest Price - redBus";
		String expectedTitle="Bus Tickets Booking Online with Attractive Rates - redBus";
		String actualTitle=driver.getTitle();
		//Thread.sleep(20000);
		Assert.assertTrue(expectedTitle.equals(actualTitle));
		System.out.println("Expected title : " + expectedTitle + " matches with " + "Actual title: " + actualTitle); // Assertion gets true, this will be executed
	}

	@AfterClass
	public void quitBrowserTest() throws InterruptedException {
		driver.quit();
		System.out.println("Test Ended");
	}
}