package dropdown_handling;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


/* this program demonstrates how to capture 
 * all options of a dropdown, counts them, 
 * and finally prints them on the console
 * 
 * Tools Used:
 * Java 17, Eclipse IDE, Selenium WebDriver 3.141.59
 */
public class GetAllOptionsExample 
{
	public static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        
        driver.get("https://demoqa.com/select-menu");
        
        WebElement dropdownBox = driver.findElement(By.id("oldSelectMenu"));
        Select dropdown = new Select(dropdownBox);
        
        List<WebElement> options = dropdown.getOptions();
        int optionsCount = options.size();
        
        System.out.println("Total Dropdown Options Count: "+optionsCount);
        for(WebElement option : options)
        {
        	System.out.println(option.getText());
        }
        
        driver.quit();
        System.out.println("browser closed successfully");
        
    }

}
