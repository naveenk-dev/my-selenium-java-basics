package browser_options;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


/*
* This program demonstrates how to run browser without UI, no
* window, no screen, no mouse... just execution happens in background 
* without triggering browser using "headless" browser concept.
* 
* Tools Used:
* Java 17, Eclipse IDE, Selenium WebDriver 3.141.59
*/
public class HeadlessBrowserExample 
{
	public static void main(String args[])
	{
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		
		//this configure/enable headless mode
		options.addArguments("--headless");
		
		//i take 1920×1080. because is Standard desktop/laptop full hd resolution.
		options.addArguments("--window-size=1920,1080");
		
		WebDriver driver = new ChromeDriver(options);
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.get("https://demoqa.com");
		
		System.out.println("Page title: "+driver.getTitle());
		
		driver.quit();
		System.out.println("Browser closed successfully...");
	}
}
