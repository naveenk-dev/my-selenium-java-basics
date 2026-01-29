package actions_class;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/* 
 * this program demonstrates how to copy text from one input field 
 * and paste it into another input field using keyboard actions
 * 
 * tools used:
 * Java 17, Eclipse IDE, Selenium WebDriver 3.141.59
 */
public class CopyAndPasteExample 
{
	public static void main(String args[]) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		
		driver.get("https://demoqa.com/text-box");
		
		WebElement currentAddress = driver.findElement(By.id("currentAddress"));
		WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", currentAddress);
		
		Actions actions = new Actions(driver);
		
		actions.sendKeys(currentAddress, "andhra pradesh, guntur").build().perform();
		Thread.sleep(1000);
		
		actions.keyDown(Keys.CONTROL)
		.sendKeys("a")
		.keyUp(Keys.CONTROL).build().perform();
		Thread.sleep(1000);
		
		actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();
		Thread.sleep(1000);
		
		actions.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(1000);
		
		actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();
		Thread.sleep(1000);
		
		String pastedText = permanentAddress.getAttribute("value");
		System.out.println("Permanent address value: "+pastedText);
		
		System.out.println("Keyboard copy-paste successful");
		Thread.sleep(1000);
		
		driver.quit();
		System.out.println("browser closed successfully...");
		
	}
}
