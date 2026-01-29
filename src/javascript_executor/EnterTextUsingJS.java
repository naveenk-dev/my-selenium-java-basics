package javascript_executor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/* 
 * this program demonstrates how to enter text 
 * into a web element using javascript executor
 * 
 * tools used:
 * Java 17, Eclipse IDE, Selenium WebDriver 3.141.59
 */
public class EnterTextUsingJS {

    public static void main(String[] args) 
    {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();

            WebDriverWait wait = new WebDriverWait(driver, 10);
            driver.get("https://demoqa.com/text-box");

            //locate input field
            WebElement fullNameInput = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("userName"))
            );

            JavascriptExecutor js = (JavascriptExecutor) driver;

            //scroll for visibility
            js.executeScript("arguments[0].scrollIntoView(true);", fullNameInput);

            //enter text using javascript
            js.executeScript("arguments[0].value='naveen123';", fullNameInput);
            
            Thread.sleep(1500);

            //opt. validation
            String enteredValue = (String) js.executeScript(
                    "return arguments[0].value;", fullNameInput);

            System.out.println("entered value using js: " + enteredValue);

        } 
        catch (Exception e) 
        {
            System.out.println("exception occurred: " + e.getMessage());
        } 
        
        finally 
        {
            driver.quit();
        }
    }
}
