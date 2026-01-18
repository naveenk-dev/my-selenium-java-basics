package dropdown_handling;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;



/*
 * This program demonstrates how to select multiple 
 * options of a dropdown, count them and print 
 * visible texts of each option using for each loop
 * 
 * Tools Used:
 * Java 17, Eclipse IDE, Selenium WebDriver 3.141.59
 */
public class GetAllSelectedOptionsExample 
{
	public static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        
        driver.get("https://demoqa.com/select-menu");
        
        
        WebElement dropdownBox = driver.findElement(By.id("cars"));
        Select dropdown = new Select(dropdownBox);
        
        if(dropdown.isMultiple())
        {
        	System.out.println("this is a multi-select dropdown");
        	dropdown.selectByVisibleText("Volvo");
        	dropdown.selectByVisibleText("Audi");        
        	dropdown.selectByVisibleText("Opel");
        	
        	List<WebElement> options = dropdown.getAllSelectedOptions();
        	System.out.println("Total selcted options count: "+options.size());
        	
        	System.out.println("Selected dropdown options : ");
        	for(WebElement option : options)
        	{       		
        		System.out.println(option.getText());
        	}
        	
        }
        else
        	System.out.println("this isn't a multi-select dropdown.");
        
        
        driver.quit();
        System.out.println("browser closed successfully");
        
    }
}
