package dropdown_handling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/*
* this program demonstrates throw to select a 
* drop down value using SelectByVisibleText() method
* 
* Tools Used:
* Java 17, Eclipse IDE, Selenium WebDriver 3.141.59
*/
public class SelectByVisibleTextExample 
{
	public static void main(String args[]) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://the-internet.herokuapp.com/dropdown");
	
		//locates dropdown element
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        
        //creates Select object to select it
        Select select = new Select(dropdown);
        Thread.sleep(1000);
        
        //Most readable & preferred method 
        //to perform drop down select operation.
        //Select option by visible text
        select.selectByVisibleText("Option 1");
        Thread.sleep(3000);
	
		driver.quit();
		System.out.println("browser closed successfully...");
	}

}
