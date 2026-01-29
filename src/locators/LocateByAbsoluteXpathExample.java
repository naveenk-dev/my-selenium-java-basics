package locators;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/* 
 * this program demonstrates how to find 
 * a web element using an absolute xpath locator
 * 
 * tools used:
 * Java 17, Eclipse IDE, Selenium WebDriver 3.141.59 
 */
public class LocateByAbsoluteXpathExample 
{
	public static void main(String args[])
	{
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demoqa.com/login");
		
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/form/div[2]/div[2]/input")).sendKeys("testNaveen@gmail.com");
		
		
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/form/div[3]/div[2]/input")).sendKeys("12345");		
		
		driver.findElement(By.id("login")).click();
		
		driver.quit();
		System.out.println("Browser closed successfully...");
	}
}
