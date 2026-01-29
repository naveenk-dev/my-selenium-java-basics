package alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/* 
 * this program demonstrates how to handle 
 * multiple alerts one after another using selenium alert interface
 * 
 * tools used:
 * Java 17, Eclipse IDE, Selenium WebDriver 3.141.59
 */
public class MultipleAlertsExample
{
    public static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.get("https://demoqa.com/alerts");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        //simple alert
        WebElement alertButton1 = driver.findElement(By.id("alertButton"));
        
        js.executeScript("arguments[0].scrollIntoView(true);",
                alertButton1);
        alertButton1.click();

        Alert alert1 = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println("simple alert text: " + alert1.getText());
        alert1.accept();

        //Delayed Alert with 5 seconds
        WebElement alertButton2 = driver.findElement(By.id("timerAlertButton"));
        alertButton2.click();
        
        Alert alert2 = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println("Delayed alert text: " + alert2.getText());
        alert2.accept();

        //confirm alert
        WebElement alertButton3 = driver.findElement(By.id("confirmButton"));
        alertButton3.click();
        
        Alert alert3 = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println("Confirmation alert text: " + alert3.getText());
        alert3.dismiss(); // Cancel

        //Prompt Alert
        WebElement alertButton4 = driver.findElement(By.id("promtButton"));
        alertButton4.click();
        
        Alert alert4 = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println("prompt alert text: " + alert4.getText());
        alert4.sendKeys("naveen143");
        alert4.accept();
        
        System.out.println("All alerts handled successfully");
        
        driver.quit();
        System.out.println("browser closed successfully");
        
    }
}
