package webelement_methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * This program demonstrates to validate if a html element such
 * as text box, radio button, etc. are enabled to interact 
 * using isEnabled().
 * 
 * Tools Used:
 * Java 17, Eclipse IDE, Selenium WebDriver 3.141.59
 */
public class IsEnabledMethodExample
{
    public static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        
        //this is only works with selenium 3x version.
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement textBox = driver.findElement(By.xpath("//input[@type='text']"));

        System.out.println("is textbox enabled initially? " + textBox.isEnabled());
        driver.findElement(By.xpath("//button[text()='Enable']")).click();

        //waits until text box becomes enabled
        wait.until(ExpectedConditions.elementToBeClickable(textBox));

        //checks the textbox again to verify whether its enabled or disabled  
        System.out.println("Is TextBox enabled after clicking Enable? " + textBox.isEnabled());


        if (textBox.isEnabled())
        {
            textBox.sendKeys("Selenium isEnabled example");
        }

        driver.quit();
        System.out.println("Browser closed successfully..");
    }
}
