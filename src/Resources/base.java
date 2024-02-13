package Resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Resources.Reusables;
import io.github.bonigarcia.wdm.WebDriverManager;
public class base extends Reusables {
	
	public WebDriver driver=null;
	
	public String browserKey="testBrowser";
	public String browserValue=null;
	public String urlKey="testUrl";
	public String urlValue=null;
	
	public String jenkinFlagKey="jenkinsExecutionON";
	public String jenkinBrowserParameter="browser";
	public String jenkinFlagValue=null;

	
	public void initializeValues() throws IOException {
		
		jenkinFlagValue=getValueFromDataProperties(jenkinFlagKey);
		
		if (jenkinFlagValue.equals("true")) {
			browserValue=getValueFromSystemProperty(jenkinBrowserParameter); // fetches from Jenkin - Build parameter
		}
		else {
			browserValue=getValueFromDataProperties(browserKey); //fetched from data.properties
		}
		
		urlValue=getValueFromDataProperties(urlKey);
		System.out.println("Initialise Values - Done!");

	}
	
	public WebDriver initializeBrowser() throws IOException {

		 // Gets value from browser parameter passed by the jenkins
											
		if (browserValue.equals("chrome")) {
			//WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("Driver set to Chrome");
		}
		else if (browserValue.equals("firefox")) {
			//WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("Driver set to Firefox");
		}
		else if (browserValue.equals("edge")) {
			//WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			System.out.println("Driver set to Edge");
		}
		return driver;

	}

}
