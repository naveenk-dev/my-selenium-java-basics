package javascript_executor;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/* 
 * this program demonstrates how to scroll down 
 * a web page using javascript executor
 * 
 * tools used:
 * Java 17, Eclipse IDE, Selenium WebDriver 3.141.59
 */
public class ScrollDownExample {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();

            driver.get("https://demoqa.com/automation-practice-form");

            JavascriptExecutor js = (JavascriptExecutor) driver;

            //scroll down by pixel
            js.executeScript("window.scrollBy(0, 500);");
            Thread.sleep(1000);
            
            js.executeScript("window.scrollBy(0, 500);");
            Thread.sleep(1000);

            //scroll till bottom of the page
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            Thread.sleep(1000);

            System.out.println("page scrolled down successfully");

        }
        
        catch (Exception e) 
        {
            System.out.println("exception occurred: " + e.getMessage());
        } 
        
        finally
        {
            driver.quit();
            System.out.println("browser closed successfully...");
        }
    }
}
