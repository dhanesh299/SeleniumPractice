import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class calnewportExample {

	public static void main(String[] args) throws InterruptedException {
		//WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://calnewport.com/");
		
		//WebElement notificationBar=driver.findElement(By.xpath("//body/descendant::div[@class='easy-notification-bar easy-notification-bar--align_left easy-notification-bar--sticky easy-notification-bar--collapsible'][1]"));
		
		//WebElement NotifBarBase=driver.findElement(By.xpath("//*[contains(@class,'easy-notification-bar')]"));
		WebElement NotifBarCollapsible=driver.findElement(By.xpath("//*[contains(@class,'easy-notification-bar') and contains(@class,'sticky')]"));
		//System.out.println(NotifBarBase);
		System.out.println(NotifBarCollapsible);
		System.out.println(NotifBarCollapsible.isEnabled());
		
		WebElement notificationBarClose=NotifBarCollapsible.findElement(By.className("easy-notification-bar__close"));
		notificationBarClose.click();
		
		WebElement NotifBarHidden=driver.findElement(By.xpath("//*[contains(@class,'easy-notification-bar') and contains(@class,'hidden')]"));
		System.out.println(notificationBarClose.isDisplayed());
		System.out.println(NotifBarHidden);
		System.out.println(NotifBarHidden.isEnabled());
		if(NotifBarHidden.isEnabled()) {
			System.out.println("Notification bar closed");
		}
		else {
			System.out.println("Notification bar is still open");
		}
		WebElement HomeLink=driver.findElement(By.xpath("//*[@id='menu-item-34']"));
		//HomeLink.click();
		
		WebElement scholarshipLink = driver.findElement(By.linkText("Scholarship"));
		scholarshipLink.click();
		
		
		
		Thread.sleep(3000);
		driver.quit();
	}

}
