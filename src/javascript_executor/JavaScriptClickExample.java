package javascript_executor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/* 
 * this program demonstrates how to click 
 * a web element using javascript executor
 * 
 * tools used:
 * Java 17, Eclipse IDE, Selenium WebDriver 3.141.59
 */
public class JavaScriptClickExample 
{

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		try
		{
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			
			//selenium 3x doesn't support
			//WebDriverWait  wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebDriverWait  wait = new WebDriverWait(driver, 10);
			driver.get("https://demoqa.com/buttons");
			
			WebElement jsClickButton = wait.until
					(ExpectedConditions.elementToBeClickable
						(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/div[3]/button")));
			
			Thread.sleep(1500);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			//this not required for a js click.
			//but it is useful to take a screenshot when something goes wrong and
			//for visible clarity
			js.executeScript("arguments[0].scrollIntoView(true);", jsClickButton);
			js.executeScript("arguments[0].click();", jsClickButton);
			
			Thread.sleep(1500);
			WebElement ClickMessage = driver.findElement(By.id("dynamicClickMessage"));

			System.out.println("clicked successfully using javascriptexecutor");
			String buttonMessageText = ClickMessage.getText();
			System.out.println("captured message: "+buttonMessageText);
		}
		
		catch(Exception e)
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
