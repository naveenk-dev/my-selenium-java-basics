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
 * a confirmation alert pop up using selenium Alert interface
 * 
 * tools used:
 * Java 17, Eclipse IDE, Selenium WebDriver 3.141.59
 */
public class ConfirmationAlertExample 
{
	public static void main(String args[])
	{
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		driver.get("https://demoqa.com/alerts");
		
		By alertButton = By.id("confirmButton");
		WebElement confirmAlertButton = wait.until(ExpectedConditions
				.presenceOfElementLocated(alertButton));
		
		//"arguments[0].scrollIntoView(true);" also works.
		((JavascriptExecutor)driver)
		.executeScript("arguments[0].scrollIntoView({block:'center'});",confirmAlertButton);
		
		wait.until(ExpectedConditions.elementToBeClickable(confirmAlertButton)).click();
		
		Alert confirmAlert = wait.until(ExpectedConditions.alertIsPresent());
		confirmAlert.accept();
		
		String confirmAlertText = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.id("confirmResult"))).getText();
		System.out.println("confirm alert message is: "+confirmAlertText);
		
		System.out.println("confirm alert handled successfully..");
		
		driver.quit();
		System.out.println("browser closed successfully..");
		
	}
}
