package navigation_handling;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * this program demonstrates the implementation of 
 * navigate().to() method.
 * 
 * Tools Used:
 * Java 17, Eclipse IDE, Selenium WebDriver 3.141.59
 */
public class NavigationToExample 
{
	public static void main(String args[])
	{
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();		
		
		driver.get("https://demoqa.com");
		
		driver.navigate().to("https://demoqa.com/login");	
		String pageTitle = driver.getTitle();		
		System.out.println("page title after navigation: "+pageTitle);
		
		driver.quit();
		System.out.println("Browser cloased successfully...");		
		
	}
}
