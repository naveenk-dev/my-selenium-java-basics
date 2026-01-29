package actions_class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/* 
 * this program demonstrates how to perform 
 * mouse hover action on a web element using actions class
 * 
 * tools used:
 * Java 17, Eclipse IDE, Selenium WebDriver 3.141.59
 */
public class MouseHoverExample {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://the-internet.herokuapp.com/hovers");
		
		/*
		 * Exception in thread "main" org.openqa.selenium.InvalidSelectorException: 
		 * invalid selector: The result of the 
		 * xpath expression "//div[@class='figure'][2]/img/@src" is: [object Attr]. 
		 * It should be an element.
		*/
		WebElement userProfile = 
				driver.findElement(
						By.xpath("//div[@class='figure'][2]/img/@src"));
		Actions actions = new Actions(driver);
		
		actions.moveToElement(userProfile).build().perform();
		
		String userprofileText =
				driver.findElement
				((By.xpath
				("//div[@class='figure'][2]/div[@class='figcaption']/h5"))).getText();
		
		System.out.println("mouse hover text: "+userprofileText);
		
		driver.quit();
		System.out.println("browser closed successfully...");
		
	}

}
