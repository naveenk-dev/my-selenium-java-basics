package actions_class;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/* 
 * this program demonstrates how to perform 
 * right click action on a web element using actions class
 * 
 * tools used:
 * Java 17, Eclipse IDE, Selenium WebDriver 3.141.59
 */
public class RightClickExample 
{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		driver.get("https://the-internet.herokuapp.com/context_menu");
		
		var box = driver.findElement(By.id("hot-spot"));
		
		Actions actions = new Actions(driver);
		
		actions.contextClick(box).build().perform();
		
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		System.out.println("alert text: "+alert.getText());
		alert.accept();
		
		driver.quit();
		System.out.println("browser closed successfully...");
				
	}
}
