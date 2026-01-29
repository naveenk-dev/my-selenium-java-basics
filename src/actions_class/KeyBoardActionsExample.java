package actions_class;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/* 
 * this program demonstrates how to perform 
 * keyboard actions like entering values to input fields 
 * on web elements using actions class
 * 
 * tools used:
 * Java 17, Eclipse IDE, Selenium WebDriver 3.141.59
 */
public class KeyBoardActionsExample 
{
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		
		driver.get("https://demoqa.com/text-box");

		WebElement fullName = driver.findElement(By.id("userName"));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", fullName);

		Actions actions = new Actions(driver);
		actions.sendKeys(fullName, "naveen143").sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(1000);
		
		String textBoxValue = fullName.getAttribute("value");
		System.out.println("text box entered value: "+textBoxValue);

		driver.quit();
		System.out.println("browser closed successfully...");
	}
}
