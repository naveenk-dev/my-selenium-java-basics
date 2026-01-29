package screenshots;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/* 
 * this program demonstrates how to take 
 * a screenshot of the current browser window
 * 
 * tools used:
 * Java 17, Eclipse IDE, Selenium WebDriver 3.141.59
 */
public class TakeScreenShotExample 
{
	public static void main(String[] args) throws IOException 
	{
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
                
        WebDriverWait wait = new WebDriverWait(driver, 10);
        
        
        driver.get("https://demoqa.com/login");
        String parentWindowUrl = driver.getCurrentUrl();
               
        wait.until(ExpectedConditions.elementToBeClickable(By.id("userName")))
        .sendKeys("naveen123");
        
        driver.findElement(By.id("password")).sendKeys("naveen#123");
        
        wait.until(ExpectedConditions.elementToBeClickable(By.id("login"))).click();
        
        if(!driver.getCurrentUrl().equals(parentWindowUrl))
        {
        	System.out.println("Login Successful...");
        }
        else
        {
        	TakesScreenshot ts =(TakesScreenshot) driver;
        	File source = ts.getScreenshotAs(OutputType.FILE);
        	File destination = new File("screenshots/loginfailure.jpg");
        	Files.copy(source,destination);
        	System.out.println("Login Unsuccessful...");
        	System.out.println("Screenshot captured successfully");		
        }

        driver.quit();
        System.out.println("browser closed successfully...");   
	}

}
