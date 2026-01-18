package dropdown_handling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/*
* this program demonstrates thow to select a 
* dropdown value using SelectByIndex() method
* 
* Tools Used:
* Java 17, Eclipse IDE, Selenium WebDriver 3.141.59
*/
public class SelectByIndexValueExample 
{
	public static void main(String args[]) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://the-internet.herokuapp.com/dropdown");
	
		//Locates dropdown element
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        
        //Creates Select object to select it
        Select select = new Select(dropdown);
        Thread.sleep(1000);
        
        //selects value using option index position
        //index starts from 0
        //0 --> please select an option(default)
        //1 --> option 1
        //2 --> option 2
        select.selectByIndex(2);
        Thread.sleep(3000);
	
		driver.quit();
		System.out.println("browser closed successfully...");
	}
}
