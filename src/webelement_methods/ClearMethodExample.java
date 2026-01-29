package webelement_methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * This program demonstrates how to clear text inside a focused 
 * input element such as text box, etc using clear() method.
 * 
 * Tools Used:
 * Java 17, Eclipse IDE, Selenium WebDriver 3.141.59
 */
public class ClearMethodExample 
{
	public static void main(String args[]) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.get("https://www.amazon.com");
		
		//never use such condition like this to load DOM/page. this is bad coding.   
		//i use this only for my learning and practice purposes.
		//always use implicit, explicit wait conditions in such cases. that's good coding
		Thread.sleep(5000);
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Selenium Automation TextBooks");
		Thread.sleep(2000);
		
		driver.findElement(By.id("twotabsearchtextbox")).clear();
		Thread.sleep(2000);
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("crime and punishment book");
		Thread.sleep(2000);
		
		driver.quit();
		System.out.println("browser closed successfully");
		
	}
}
