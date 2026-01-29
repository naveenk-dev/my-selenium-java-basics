package frames;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/* 
 * this program demonstrates how to switch to a frame 
 * using frame id and interact with elements inside it
 * 
 * tools used:
 * Java 17, Eclipse IDE, Selenium WebDriver 3.141.59
 */
public class SwitchFrameById 
{

	public static void main(String[] args) 
	{
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        
        try
        {
        	driver.switchTo().frame(driver.findElement(By.id("frame1")));
        	System.out.println("Switched to frame1");
        	
        	//Testing purpose
        	//driver.findElement(By.id("framesWrapper"));
        	
            String frameText = driver.findElement(By.id("sampleHeading")).getText();           
            System.out.println("frame text: "+frameText);
            
            driver.switchTo().defaultContent();           
            System.out.println("Switched back to original content");
        }
        catch(NoSuchElementException nsee)
        {
        	nsee.printStackTrace();
        }                
        finally
        {
        	driver.quit();
            System.out.println("browser closed successfully");
        }

	}

}
