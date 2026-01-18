package dropdown_handling;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * This program demonstrates how to select multiple 
 * options of a multi-select dropdown which is developed 
 * using new web technology such as react-js, print 
 * visible texts of each option using for each loop
 * and deselects all selected options.
 * 
 * Tools Used:
 * Java 17, Eclipse IDE, Selenium WebDriver 3.141.59
 */
public class MultiSelectDropdownExample2 
{
	public static void main(String[] args) throws InterruptedException
    {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        
        driver.get("https://demoqa.com/select-menu");
        WebDriverWait wait = new WebDriverWait(driver, 10);

        //Click the visible multi select box (wrapper)
        //here, actual interactable element is hidden inside <div>
        //so, first we must click it expand/open.
        WebElement multiSelectBox = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//div[contains(@class,'css-1hwfws3')]")));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", multiSelectBox);
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", multiSelectBox);

        //now this locates real input tag
        WebElement realInput = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//input[@id='react-select-4-input']")
                )
        );

        //Send keys to input
        realInput.sendKeys("Green");
        Thread.sleep(2000);
        realInput.sendKeys(Keys.ENTER);

        realInput.sendKeys("Blue");
        Thread.sleep(2000);
        realInput.sendKeys(Keys.ENTER);

        realInput.sendKeys("Red");
        Thread.sleep(2000);
        realInput.sendKeys(Keys.ENTER);

        driver.quit();      
    }

}
