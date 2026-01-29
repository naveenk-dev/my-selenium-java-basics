package locators;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/* 
 * this program demonstrates how to locate 
 * web elements using tag name locator and perform actions on them
 * 
 * tools used:
 * Java 17, Eclipse IDE, Selenium WebDriver 3.141.59
 */
public class LocateByTagNameExample 
{
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.calculator.net");
		
		//this captures all elements of same type(input) as a List<WebElement> Collection.
		List <WebElement> inputTagElements = driver.findElements(By.tagName("input"));
		System.out.println("There are total "+inputTagElements.size()+" input tag "
				+ "elements in the page");
		
		driver.quit();
		System.out.println("Browser closed successfully...");
	}
}
