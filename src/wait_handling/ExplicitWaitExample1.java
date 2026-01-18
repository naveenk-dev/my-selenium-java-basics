package wait_handling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
* this program demonstrates the implementation of
* explicit wait concept using a simple example1.
* 
* tools used:
* Java 17, Eclipse IDE, Selenium WebDriver 3.141.59
*/
public class ExplicitWaitExample1 
{
	public static void main(String args[])
	{
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		driver.manage().window().maximize();
		
		driver.get("https://the-internet.herokuapp.com/dynamic_controls");
		
		WebElement textBox = driver.findElement(By.xpath("//input[@type='text']"));
		
		driver.findElement(By.xpath("//button[text()='Enable']")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(textBox));
		
		if(textBox.isEnabled())
		{
			textBox.sendKeys("Text box enabled..!");
			System.out.println("Textbox enabled...!");
		}
		else
			System.out.println("Textbox not enabled...!");
	}
				
}

