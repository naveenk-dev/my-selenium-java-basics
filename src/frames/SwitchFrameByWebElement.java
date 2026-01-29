package frames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/* 
 * this program demonstrates how to switch to a frame 
 * using a web element reference and work inside it
 * 
 * tools used:
 * Java 17, Eclipse IDE, Selenium WebDriver 3.141.59
 */
public class SwitchFrameByWebElement
{
    public static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/nested_frames");

        //main->frame-top
        WebElement frameTop =
                driver.findElement(By.xpath("//frame[@name='frame-top']"));
        driver.switchTo().frame(frameTop);

        //frame-top -> frame-left
        WebElement frameLeft =
                driver.findElement(By.xpath("//frame[@name='frame-left']"));
        driver.switchTo().frame(frameLeft);

        //read left-frame text
        String leftText =
                driver.findElement(By.xpath("//body")).getText();
        System.out.println("Left frame text: " + leftText);

        //back to main page
        driver.switchTo().defaultContent();

        driver.quit();
        System.out.println("browser closed succeffully...");
    }
}
