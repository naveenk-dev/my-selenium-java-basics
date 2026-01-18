package webelement_methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * This program demonstrates how to get the value of
 * any property of an element such as id, name, type, etc 
 * using getAttribute() method.
 * 
 * Tools Used:
 * Java 17, Eclipse IDE, Selenium WebDriver 3.141.59
 */
public class GetAttributeMethodExample 
{
	public static void main(String args[]) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		driver.get("https://demoqa.com/login");
		
		WebElement userName = driver.findElement(By.id("userName"));
		userName.sendKeys("Mukesh Ambani");
		
		String usernameValue = userName.getAttribute("value");
		System.out.println("Entered value in the username text box: "+ usernameValue);
		
		driver.quit();
		System.out.println("Browser Closed Successfully");
	}
}
