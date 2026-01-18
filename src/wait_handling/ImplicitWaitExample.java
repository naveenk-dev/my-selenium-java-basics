package wait_handling;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * this program demonstrates the implementation of
 * implicit wait concept using a simple login example.
 * 
 * tools used:
 * Java 17, Eclipse IDE, Selenium WebDriver 3.141.59
 */
public class ImplicitWaitExample 
{
	public static void main(String[] args) throws InterruptedException
    {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        /*
         * selenium waits up to 20 seconds
         * If element appears earlier it moves immediately and 
         * doesn't wait for 20 seconds
         * This single statement Applies to all element searches(findElement/s())		   
         */
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.get("https://demoqa.com/login");
        driver.findElement(By.id("userName")).sendKeys("testnaveen");       
        driver.findElement(By.id("password")).sendKeys("naveen@123");
        driver.findElement(By.id("login")).click();

        driver.quit();
        System.out.println("browser closed successfully...");
    }
}
