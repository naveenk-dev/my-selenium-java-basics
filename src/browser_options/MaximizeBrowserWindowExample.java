package browser_options;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * This program demonstrates to maximize the 
 * window(full screen mode) of a browser using selenium.
 * 
 * Tools Used:
 * Java 17, Eclipse IDE, Selenium WebDriver 3.141.59
 */
public class MaximizeBrowserWindowExample
{
    public static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        driver.get("https://demoqa.com");
        System.out.println("Page Title: " + driver.getTitle());
        
        driver.quit();
        System.out.println("Browser closed successfully...");
    }
}
