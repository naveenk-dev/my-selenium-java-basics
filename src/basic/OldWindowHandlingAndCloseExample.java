package basic;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * This program demonstrates how to launch the Chrome browser,
 * switch from the parent window to a child window,
 * perform actions, switch back to the parent window,
 * and finally close the browser.
 *
 * Note:
 * This implemented logic is based on Selenium 3 and it may require
 * changes when using Selenium 4 or higher versions.
 *
 * Tools Used:
 * Java 17, Eclipse IDE, Selenium WebDriver 3.141.59
 */
public class OldWindowHandlingAndCloseExample 
{
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
	    WebDriver driver = new ChromeDriver();	  
	    driver.manage().deleteAllCookies();
	    driver.manage().window().maximize();
	    	    
	    driver.get("http://gmail.com");				
	    String parentWindow = driver.getWindowHandle();
	    
	    driver.findElement(By.linkText("Help")).click();
	    
	    //logic to store all windows and switch between parent to child windows.
	    Set<String> allWindows = driver.getWindowHandles();
	    for(String window : allWindows)
	    {
	    	if(!window.equals(parentWindow))
	    	{
	    		driver.switchTo().window(window);
	    		System.out.println("child window title: "+driver.getTitle());
	    		
	    	}
	    }
	    driver.switchTo().window(parentWindow);
	    
	    //this closes parent window only. child window still opened,
	    //even if execution complete
	    driver.close();
	    System.out.println("Browser closed successfully...");
	         
	}
}
