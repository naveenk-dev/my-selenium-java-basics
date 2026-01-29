package browser_options;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/*
* This program demonstrates how to open the 
* chrome browser in incognito mode using Selenium WebDriver.
* 
* Tools Used:
* Java 17, Eclipse IDE, Selenium WebDriver 3.141.59
*/
public class DisableNotificationsExample 
{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		
		driver.get("https://www.irctc.co.in/nget/train-search");
		System.out.println("Page title: "+driver.getTitle());
		
		driver.quit();
		System.out.println("Incognito browser closed successfully...");	

	}
}
