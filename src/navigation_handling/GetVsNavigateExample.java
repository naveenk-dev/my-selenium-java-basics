package navigation_handling;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
* this program demonstrates the practical difference 
* between get() and navigate().to() methods
* 
* Tools Used:
* Java 17, Eclipse IDE, Selenium WebDriver 3.141.59
*/
public class GetVsNavigateExample 
{
	public static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        driver.get("https://demoqa.com");
        System.out.println("oened using get(): " + driver.getTitle());

        driver.navigate().to("https://demoqa.com/login");
        System.out.println("opened using navigate().to(): " + driver.getTitle());

        driver.quit();
    }
}
