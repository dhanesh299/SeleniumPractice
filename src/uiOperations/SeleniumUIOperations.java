package uiOperations;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import Resources.base;

public class SeleniumUIOperations extends base {
	
	@BeforeClass
	public void initializeTest() throws IOException {
		System.out.println("Test initializing...");
		initializeValues();
		driver=initializeBrowser();
		System.out.println(urlValue);
		System.out.println("Test initialized.");
	}
	
	@Test (enabled=false)
	public void getMethods() {
		String sourceCity="Coimbatore";
		driver.get(urlValue); // Opens the passed URL
		System.out.println(driver.getTitle()); // Returns the page title displayed on the title bar of a browser
		System.out.println(driver.getCurrentUrl()); // Returns current URL
		// Enter data into text box
		driver.findElement(By.xpath("//*[@id='src']")).sendKeys(sourceCity);
		if(sourceCity.equals(driver.findElement(By.xpath("//*[@id='src']")).getText()));
			System.out.println("The source text contains" + sourceCity);
		}
	
	@Test
	public void enterSearch() throws InterruptedException {
		driver.get(urlValue); 
		System.out.println("Executing Enter Search TEST!!!");
		HomePage hp=new HomePage(driver);
		hp.sourceCity().clear();
		hp.sourceCity().sendKeys("Chennai");
		hp.destinationCity().sendKeys("Bengaluru");
		Thread.sleep(3000);
	}
	
	
	@AfterClass(timeOut=5000)
	public void endTest() throws InterruptedException {
		driver.quit();
		System.out.println("Test Ended");
	}

}
