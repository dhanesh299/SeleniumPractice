package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Resources.base;

public class HomePage extends base {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	private By sourceCity=By.xpath("//*[@id='src']");
	public WebElement sourceCity() {
		return driver.findElement(sourceCity);
	}
	
	private By destinationCity=By.xpath("//*[@id='dest']");
	public WebElement destinationCity() {
		return driver.findElement(destinationCity);
	}

}
