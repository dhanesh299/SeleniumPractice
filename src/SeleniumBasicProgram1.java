import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumBasicProgram1 {

	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("Program start...");
		// Change to be seen in git repository after push
		// Try 2
		// push from user 2
		// push from user 1
		// Hey hi
		// to be merged message from dhanesh to master
		// message 2 from vanjivel to merge with dhanesh
		// dhanesh
		
		// Driver setup --> In the current version of Selenium jar package, all 4 browser's drivers are added by default
		// System.setProperty("webdriver.chrome.driver.","C:\\My Folder\\7-Learning\\QA\\Dependencies\\Web Drivers\\Chrome\\chromedriver-win64\\chromedriver.exe");
		// WebDriverManager.chromedriver().setup();
		
		// Driver declaration
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.redbus.in/");
		System.out.println("Page load complete!");
		
		driver.manage().window().maximize();

		// Verify page load with page title
		String expectedTitle="Book bus tickets online with redBus!";
		String actualTitle=driver.getTitle();
		System.out.println(actualTitle);
		
		if(expectedTitle.equals(actualTitle)) {
			System.out.println("The correct url is loaded!");
			
		}
		
		Thread.sleep(3000);
		// Locators
		WebElement source=driver.findElement(By.id("src"));
//		try {
			WebElement pageName=driver.findElement(By.name("page_name")); // Not found by eye; but exists in the page
//		}
//		catch(NoSuchElementException nsee) {
//			nsee.printStackTrace();
//		}
		WebElement toSection=driver.findElement(By.className("sc-ifAKCX gLwVlD"));
		WebElement linkHyderabadToChennaiBuses=driver.findElement(By.linkText("Hyderabad to Bangalore Bus"));
		WebElement helpLink=driver.findElement(By.xpath("//*[@id='help_redcare']"));
		WebElement accountMenu=driver.findElement(By.cssSelector("#account_dd"));
		
		Boolean isSourceDisplayed=driver.findElement(By.id("src")).isDisplayed();
		System.out.println("Source Displayed: " + isSourceDisplayed);
		
		try {
			WebElement noElement=driver.findElement(By.name("dwd23ewfefw")); // Not found by eye; but exists in the page
		}
		catch(NoSuchElementException nsee) {
			nsee.printStackTrace();
			System.out.println("Exception Handled!");
		}
		
		// Quit driver session
		Thread.sleep(2000);
		driver.quit();
		System.out.println("...Program End");
	}
}