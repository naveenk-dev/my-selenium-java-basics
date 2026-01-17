package basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * This program demonstrates how to launch Google Chrome browser
 * using Selenium WebDriver, navigate to demoqa website,
 * perform forward, backward, refresh and 
 * closes the browsers entirely.
 * 
 * Tools Used:
 * Java 17, Eclipse IDE, Selenium WebDriver 3.141.59
 */
public class BasicBrowserFlow
{
    public static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        driver.get("https://demoqa.com");

        String title = driver.getTitle();
        System.out.println("Page Title: " + title);

        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + currentUrl);
        
        driver.navigate().to("https://demoqa.com/login");     
        driver.navigate().back();
        driver.navigate().refresh();

        driver.quit();

        System.out.println("Browser closed successfully...");
    }
}
