package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/* 
 * this program demonstrates how to locate 
 * a web element using relative xpath locator and perform action on it
 * 
 * tools used:
 * Java 17, Eclipse IDE, Selenium WebDriver 3.141.59
 */
public class LocateByRelativeXpathExample 
{
	public static void main(String args[]) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.facebook.com");
		driver.findElement(By.xpath("//div/div[1]/form/div[1]/div[1]/input")).sendKeys("testNaveen@gmail.com");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//div/div[1]/form/div[1]/div[2]/div/input")).sendKeys("12345");
		Thread.sleep(2000);

		driver.quit();
		System.out.println("Browser closed successfully");
	}
}
