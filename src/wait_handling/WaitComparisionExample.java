package wait_handling;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
* this program demonstrates the implementation of
* Thread.sleep(), Explicit Wait, Implicit Wait 
* concepts to show the logical differences in a practical way
* using different examples.
* 
* tools used:
* Java 17, Eclipse IDE, Selenium WebDriver 3.141.59
*/
public class WaitComparisionExample 
{
	public static void main(String[] args) throws InterruptedException
    {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        driver.get("https://demoqa.com/login");
        
        //1. Thread.sleep() Example
        //------------------------------------------------------------------------
        driver.findElement(By.id("userName")).sendKeys("testnaveen");       
        driver.findElement(By.id("password")).sendKeys("naveen@123");
        Thread.sleep(3000);
        driver.findElement(By.id("login")).click();        
        Thread.sleep(3000);
        
        String errorMessage1 = driver.findElement(By.id("name")).getText();
        System.out.println("Thread.sleep() message: "+errorMessage1);
        
        //2. Implicit wait() Example
        //-------------------------------------------------------------------------
        //selenium applies max 10 seconds of implicit wait globally 
        //on every findElement() statement from here onwards.
        
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("userName")).sendKeys("testnaveen");       
        driver.findElement(By.id("password")).sendKeys("naveen@123");
        driver.findElement(By.id("login")).click();
        
        String errorMessage2 = driver.findElement(By.id("name")).getText();
        System.out.println("Implicit wait message: "+errorMessage2);
        
        //3. Explicit wait example
        //-------------------------------------------------------------------------
        //selenium applies max 10 seconds of explicit wait 
        //on specific Element for specific conditions before doing actions.
        
        driver.navigate().refresh();
        
        //reset implicit wait to avoid extended delays
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        
        WebDriverWait wait = new WebDriverWait(driver, 10);
        
        driver.findElement(By.id("userName")).sendKeys("testnaveen");       
        driver.findElement(By.id("password")).sendKeys("naveen@123");
        
        //never use findElement() inside explicit wait. it still causes 		//NoSuchElementException/ElementClickInterceptedException.
        //just pass the locator as shown below.
        wait.until(ExpectedConditions.elementToBeClickable
            		 (By.id("login"))).click();
        
        String errorMessage3 = wait.until(ExpectedConditions.visibilityOfElementLocated
        		(By.id("name"))).getText();
        System.out.println("explicit wait message: "+errorMessage3);
        
        driver.quit();
        System.out.println("Browser Closed Successfully.");
         
    }
}
