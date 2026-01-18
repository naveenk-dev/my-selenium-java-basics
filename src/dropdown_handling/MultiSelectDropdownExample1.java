package dropdown_handling;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/*
 * This program demonstrates how to select multiple 
 * options of a multi-select dropdown, print 
 * visible texts of each option using for each loop
 * and deselects all selected options.
 * 
 * Tools Used:
 * Java 17, Eclipse IDE, Selenium WebDriver 3.141.59
 */
public class MultiSelectDropdownExample1
{
    public static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        
        driver.get("https://demoqa.com/select-menu");

        WebElement multiSelect = driver.findElement(By.id("cars"));
        
        Select select = new Select(multiSelect);
        if (select.isMultiple())
        {
            System.out.println("this is a multi-select dropdown");

            select.selectByVisibleText("Volvo");
            select.selectByVisibleText("Audi");
            select.selectByVisibleText("Saab");

            List<WebElement> selectedOptions = select.getAllSelectedOptions();

            System.out.println("Selected options are:");
            for (WebElement option : selectedOptions)
            {
                System.out.println(option.getText());
            }

            select.deselectAll();
        }
        else
        {
            System.out.println("this isn't a multi-select dropdown");
        }

        driver.quit();
        System.out.println("browser closed successfully...");
    }
}

