package javascript_executor;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/* 
 * this program demonstrates how to scroll up 
 * a web page using javascript executor
 * 
 * tools used:
 * Java 17, Eclipse IDE, Selenium WebDriver 3.141.59
 */
public class ScrollUpExample {

    public static void main(String[] args) 
    {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();

            driver.get("https://demoqa.com/automation-practice-form");

            JavascriptExecutor js = (JavascriptExecutor) driver;

            //scrolls down first.
            js.executeScript("window.scrollBy(0, 800);");
            Thread.sleep(1000);

            js.executeScript("window.scrollBy(0, 800);");
            Thread.sleep(1000);

            //Scroll up by pixels
            js.executeScript("window.scrollBy(0, -500);");
            Thread.sleep(1000);

            //scrolls completely to top
            js.executeScript("window.scrollTo(0, 0);");
            Thread.sleep(1000);

            System.out.println("Page scrolled up successfully");

        } 
        
        catch (Exception e) 
        {
            System.out.println("Exception occurred: " + e.getMessage());
        } 
        finally 
        {
            driver.quit();
        }
    }
}
