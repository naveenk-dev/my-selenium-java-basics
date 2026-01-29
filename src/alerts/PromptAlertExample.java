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
 * a prompt alert like entering values to input fields 
 * and enter text using selenium alert interface
 * 
 * tools used:
 * Java 17, Eclipse IDE, Selenium WebDriver 3.141.59
 */
public class PromptAlertExample 
{
	public static void main(String args[])
	{
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		driver.get("https://demoqa.com/alerts");
		
		By promptAlert = By.id("promtButton");
		WebElement promptAlertButton = wait.until(ExpectedConditions
				.presenceOfElementLocated(promptAlert));
		
		((JavascriptExecutor)driver)
		.executeScript("arguments[0].scrollIntoView(true);", promptAlertButton);
		
		wait.until(ExpectedConditions.elementToBeClickable(promptAlertButton)).click();
		
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.sendKeys("Hello world!");
		alert.accept();
		String promptAlertText = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.id("promptResult"))).getText();
		
		System.out.println("confirm alert message is: "+promptAlertText);		
		System.out.println("confirm alert handled successfully..");
		
		driver.quit();
		System.out.println("browser closed successfully..");
	}
}
