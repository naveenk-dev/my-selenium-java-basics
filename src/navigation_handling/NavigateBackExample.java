package navigation_handling;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * this program demonstrates the implementation of 
 * navigate().back() method.
 * 
 * Tools Used:
 * Java 17, Eclipse IDE, Selenium WebDriver 3.141.59
 */
public class NavigateBackExample
{
    public static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        driver.get("https://demoqa.com");
        
        driver.navigate().to("https://demoqa.com/login");
        driver.navigate().back();

        System.out.println("Page title after navigating back: " + driver.getTitle());

        driver.quit();
        System.out.println("Browser closed successfully");
    }
}
