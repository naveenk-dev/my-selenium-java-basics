package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * This program demonstrates how to locate a web element
 * using the cssSelector locator.
 * 
 * tools used:
 * Java 17, Eclipse IDE, Selenium WebDriver 3.141.59
 */
public class LocateByCssSelectorExample 
{
	public static void main(String args[])
	{
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.cssSelector(".input_error.form_input#user-name")).sendKeys("naveen123");
		driver.findElement(By.cssSelector(".input_error.form_input#password"))
		.sendKeys("naveen#123");
		
		driver.findElement(By.id("login-button")).click();
		
		driver.navigate().back();
		driver.quit();
		
		System.out.println("Browser closed successfully...");
	}
}
