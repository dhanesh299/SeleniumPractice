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

public class base extends Reusables {
	
	public WebDriver driver=null;
	public Boolean jenkinExecutionFlag=null;
	public String testBrowser=null;
	public String testUrl=null;
	
	public void initializeValues() throws IOException {
		
		jenkinExecutionFlag=getBooleanValueFromDataProperties("jenkinsExecutionON");
		
		if (jenkinExecutionFlag.equals(true)) {
			testBrowser=getValueFromJenkinsBuildParamater("browser"); // fetches from Jenkin - Build parameter
		}
		else {
			testBrowser=getStringValueFromDataProperties("testBrowser"); //fetched from data.properties
		}
		
		testUrl=getStringValueFromDataProperties("testUrl");
		System.out.println("Initialise Values - Done!");
	}
	
	public WebDriver initializeBrowser() throws IOException {

		 // Gets value from browser parameter passed by the jenkins
											
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
		return driver; 
	}

}
