package actions_class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/* 
 * this program demonstrates how to drag one web element 
 * and drop it into another web element using actions class
 * 
 * tools used:
 * Java 17, Eclipse IDE, Selenium WebDriver 3.141.59
 */
public class DragAndDropExample 
{
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://jqueryui.com/droppable/");
		
		WebElement iframeElement  = driver.findElement(By.xpath("//iframe[@class= 'demo-frame']"));
		driver.switchTo().frame(iframeElement);
		
		WebElement draggable = driver.findElement(By.id("draggable"));
		WebElement droppable = driver.findElement(By.id("droppable"));
		
		Actions actions = new Actions(driver);		
		actions.dragAndDrop(draggable, droppable).build().perform();		
		Thread.sleep(500);
		
		System.out.println("droppable text: "+droppable.getText());		
		driver.switchTo().defaultContent();
		
		driver.quit();
		System.out.println("browser closed succssfully...");		
	}

}
