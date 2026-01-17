package basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

/*
 * This program demonstrates how to launch MS Edge browser
 * using Selenium WebDriver, navigate to Flipkart website,
 * and then close the browser.
 * 
 * Tools Used:
 * Java 17, Eclipse IDE, Selenium WebDriver 3.141.59
 */
public class LaunchMsEdgeBrowser 
{
	public static void main(String[] args)
	{
		System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.manage().deleteAllCookies();
	    driver.manage().window().maximize();
        driver.get("https://www.flipkart.com");
        driver.quit();
        System.out.println("Browser closed successfully...");
	}
}
