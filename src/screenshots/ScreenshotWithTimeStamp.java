package screenshots;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/* 
 * this program demonstrates how to take a screenshot 
 * and save it with date and time in the file name
 * 
 * tools used:
 * Java 17, Eclipse IDE, Selenium WebDriver 3.141.59
 */
public class ScreenshotWithTimeStamp 
{
	public static void main(String args[]) throws IOException
	{
		System.setProperty("webdriver.chrome.driver", 
				"drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		driver.get("https://demoqa.com/login");
		String initialUrl = driver.getCurrentUrl();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("userName")))
		.sendKeys("naveenk_777");
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("password")))
		.sendKeys("naveenk_199@#");
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("login")))
		.click();
		
		if(driver.getCurrentUrl().equals(initialUrl))
		{
			takeScreenshot(driver, "LoginFailure");
			System.out.println("login failed... screenshot captured!");	
		}
		else
			System.out.println("login successful...");
		driver.quit();
		System.out.println("Browser closed successfully.");

	}
	
	public static void takeScreenshot(WebDriver driver, String screenshotName) 
			throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		File folder = new File("screenshots");
		System.out.println("Working directory: " + System.getProperty("user.dir"));
		if(!folder.exists())
		{
			folder.mkdirs();
		}
		
	    /*
		 * MM: Month
		 * mm: minutes
		 * HH: 12h format
		 * hh: 24h format
		*/		
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss")
				.format(new Date());		
		File destination = new File(folder, screenshotName+"_"+timeStamp+".png");
		
		Files.copy(source,destination);
	}
}
