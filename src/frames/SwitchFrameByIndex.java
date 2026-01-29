package frames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/* 
 * this program demonstrates how to switch to a frame 
 * using frame index and interact with elements inside it
 * 
 * tools used:
 * Java 17, Eclipse IDE, Selenium WebDriver 3.141.59
 */
public class SwitchFrameByIndex
{
    public static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/nested_frames");

        //Main -> frame-top(index 0)
        driver.switchTo().frame(0);

        //frame-top -> frame-left(index 0)
        driver.switchTo().frame(0);

        String leftText = driver.findElement(By.tagName("body")).getText();
        System.out.println("Left frame text: " + leftText);

        //frame-left -> frame-top
        driver.switchTo().parentFrame();

        //frame-top -> frame-middle(index 1)
        driver.switchTo().frame(1);

        String middleText =
                driver.findElement(By.id("content")).getText();
        System.out.println("Middle frame text: " + middleText);

        //exit all frames
        driver.switchTo().defaultContent();

        driver.quit();
        System.out.println("Browser closed successfully...");
    }
}
