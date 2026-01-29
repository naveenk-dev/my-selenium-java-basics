package screenshots;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/* 
 * this program demonstrates how to take 
 * a screenshot of the current browser window
 * 
 * tools used:
 * Java 17, Eclipse IDE, Selenium WebDriver 3.141.59
 */
public class TakeScreenshotExample2 {

	public static void main(String[] args) throws IOException 
	{
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.get("http://orangehrm.qedgetech.com/build1");		
		
		WebDriverWait wait = new WebDriverWait(driver, 15);
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Qedge123!@#");
		driver.findElement(By.id("btnLogin")).click();
		
		driver.findElement(By.partialLinkText("Welcome")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Change Password"))).click();
		
		//code to capture Screenshot of the page
		TakesScreenshot ts = (TakesScreenshot)driver;
		File srcfile = ts.getScreenshotAs(OutputType.FILE);
		File trgfile = new File("screenshots/change_password_defect.png");			
		FileUtils.copyFile(srcfile, trgfile);
		driver.quit();

	}

}
