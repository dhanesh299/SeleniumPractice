package test;

import java.io.IOException;
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

import Resources.base;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNGCases extends base{
	
	@BeforeClass
	public void initializeTest() throws IOException {
		System.out.println("Test initializing...");
		initializeValues();
		driver=initializeBrowser();
		System.out.println(testUrl);
		System.out.println("Test initialized.");
	}
	
//	@Test
//	public void test1() {
//		System.out.println("test");
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
//		driver.get("https://www.google.com/");
//		driver
//	}
//	
	@Test
	public void loadPage() {
		System.out.println("Loading URL: " + testUrl);
		WebDriverManager.chromedriver().setup();
		driver.get(testUrl);
		String expectedTitle="Online Bus Ticket Booking with Best Offers and Lowest Price - redBus";
		String actualTitle=driver.getTitle();
		System.out.println(actualTitle);
		
		Assert.assertTrue(expectedTitle.equals(actualTitle));
		System.out.println("Correct page is loaded"); // Assertion gets true, this will be executed
	}
	

	@AfterClass(timeOut=3000)
	public void endTest() throws InterruptedException {
//		Thread.sleep(2000);
		driver.quit();
		System.out.println("Test Ended");
	}
}