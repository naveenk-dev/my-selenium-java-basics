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
 * a simple alert using selenium alert interface
 * 
 * tools used:
 * Java 17, Eclipse IDE, Selenium WebDriver 3.141.59
 */
public class SimpleAlertExample 
{
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		driver.get("https://demoqa.com/alerts");		
		By alertButton = By.id("alertButton");
		
		//Wait for presence of alert button in the dom.
		WebElement button = wait.until(ExpectedConditions.presenceOfElementLocated(alertButton));
		
		((JavascriptExecutor) driver)
		.executeScript("arguments[0].scrollIntoView({block:'center'});", button);
		
		wait.until(ExpectedConditions.elementToBeClickable(button)).click();
		
		//waits until a browser alert appears and then switches driver focus to that alert.
		//this is also useful in the example of delayed alerts.
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());		
		String alertText = alert.getText();
		
		System.out.println("alert text is: "+alertText);
		
		//this clicks ok button in alert.
		alert.accept();
		
		driver.quit();
		System.out.println("browser closed successfully...");				
	}

}
