package actions_class;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/* 
 * this program demonstrates how to perform 
 * a double click action on a web element using actions class
 * 
 * tools used:
 * Java 17, Eclipse IDE, Selenium WebDriver 3.141.59
 */
public class DoubleClickExample 
{
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://demoqa.com/buttons");
		WebDriverWait wait = new WebDriverWait(driver,10);
		
		WebElement doubleClickButton = driver.findElement(By.id("doubleClickBtn"));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", doubleClickButton);
		
		wait.until(ExpectedConditions.elementToBeClickable(doubleClickButton));
		
		Actions actions = new Actions(driver);
		actions.doubleClick(doubleClickButton).build().perform();
		
		wait.until(ExpectedConditions.elementToBeClickable(doubleClickButton));
		
		String doubleClickMessage = wait.until
				(ExpectedConditions.visibilityOfElementLocated
						(By.id("doubleClickMessage"))).getText();
		
		System.out.println("Double click button message: "+ doubleClickMessage);
		
		driver.quit();
		System.out.println("browser closed successfully...");
		
	}
}
