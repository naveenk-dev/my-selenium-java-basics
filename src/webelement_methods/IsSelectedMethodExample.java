package webelement_methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * This program demonstrates to validate if a particular/desired 
 * html element such as options in drop down, radio button, check boxes, etc 
 * selected or not using isSelected().
 * 
 * Tools Used:
 * Java 17, Eclipse IDE, Selenium WebDriver 3.141.59
 */

public class IsSelectedMethodExample 
{
	public static void main(String[] args)
    {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	    driver.manage().deleteAllCookies();
	    driver.manage().window().maximize();
	
	    driver.get("https://the-internet.herokuapp.com/checkboxes");
    
	    WebElement checkBox1 = driver.findElement(By.xpath("//input[@type='checkbox']"));
	    System.out.println("is checkbox1 selected initially? " + checkBox1.isSelected());
	    
	    WebElement checkBox2 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]"));
	    System.out.println("is checkbox2 selected initially? " + checkBox2.isSelected());
	    
	    checkBox1.click();
	    System.out.println("is checkbox1 selected now? " + checkBox1.isSelected());
	    
	    driver.quit();
	    System.out.println("browser closed successfully");
    }
}
