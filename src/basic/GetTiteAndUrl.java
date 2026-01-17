package basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * This program demonstrates how to launch google chrome browser
 * using selenium WebDriver, navigate to demoqa website,
 * captures current page title and URL, prints them,
 * and then close the browser.
 * 
 * Tools Used:
 * Java 17, Eclipse IDE, Selenium WebDriver 3.141.59
 */
public class GetTiteAndUrl 
{
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver(); 
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        driver.get("https://demoqa.com");
        
        String  currentPageTitle = driver.getTitle();        
        String currentPageUrl = driver.getCurrentUrl();
        
        System.out.println("page URL: "+currentPageUrl+"\npage title: "+
        currentPageTitle);
        
        driver.quit();
        System.out.println("Browser closed successfully...");
	}
}
