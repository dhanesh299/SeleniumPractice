package Resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class base extends OwnMethods {
	
	public WebDriver driver=null;
	public String testBrowser=null;
	public String testUrl=null;
	
	public void initializeValues() throws IOException {
		System.out.println("Intializing values...");
		
		testBrowser=getValueFromPropertiesFile("testBrowser");
		System.out.println("Browser value set");
		
		testUrl=getValueFromPropertiesFile("testUrl");
		System.out.println("URL value set");
		
		System.out.println("Values Initialized.");
	}
	
	public WebDriver initializeBrowser() throws IOException {

		// String browser=System.getProperty("browser"); // Gets value from browser parameter passed by the jenkins
											
		if (testBrowser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("Driver set to Chrome");
		}
		else if (testBrowser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("Driver set to Firefox");
		}
		else if (testBrowser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			System.out.println("Driver set to Edge");
		}
		System.out.println("URL loaded");
		return driver; 
	}

}
