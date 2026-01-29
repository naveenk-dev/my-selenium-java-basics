package javascript_executor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/* 
 * this program demonstrates how to scroll 
 * until a web element is visible using javascript executor
 * 
 * tools used:
 * Java 17, Eclipse IDE, Selenium WebDriver 3.141.59
 */
public class ScrollIntoViewExample 
{

    public static void main(String[] args) 
    {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();

            WebDriverWait wait = new WebDriverWait(driver, 10);
            driver.get("https://demoqa.com/automation-practice-form");

            //element present far below on the page
            WebElement submitButton = wait.until(
                    ExpectedConditions.presenceOfElementLocated(By.id("submit")));

            JavascriptExecutor js = (JavascriptExecutor) driver;

            //scroll element into view
            js.executeScript("arguments[0].scrollIntoView(true);", submitButton);
            Thread.sleep(2000);
            System.out.println("Element scrolled into view successfully");

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
