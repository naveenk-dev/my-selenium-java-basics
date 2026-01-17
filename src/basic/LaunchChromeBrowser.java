package basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * This program demonstrates how to launch Google Chrome browser
 * using Selenium WebDriver, navigate to demoqa website,
 * and then close the browser.
 * 
 * Tools Used:
 * Java 17, Eclipse IDE, Selenium WebDriver 3.141.59
 */
public class LaunchChromeBrowser 
{
	public static void main(String[] args) 
	{
		//sets path of chrome .exe file
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		
		//launches browser and takes control over using driver.
        WebDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        
        driver.get("https://demoqa.com");
        
        driver.quit();
        System.out.println("Browser closed successfully...");
	}
}
