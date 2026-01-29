package file_upload_download;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/* 
 * this program demonstrates how to download a file 
 * automatically by setting browser preferences in chrome
 * 
 * tools used:
 * Java 17, Eclipse IDE, Selenium WebDriver 3.141.59
 */
public class FileDownloadExample 
{
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");				
		String downloadPath = System.getProperty("user.dir")+"\\downloads";
		
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("download.default_directory", downloadPath);
		prefs.put("download.prompt_for_download", false);
		
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		
		WebDriver driver = new ChromeDriver(options);		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();	
		driver.get("https://the-internet.herokuapp.com/download");
		
		String fileName = "some-file.txt";
		driver.findElement(By.linkText(fileName)).click();
		
		Thread.sleep(3000);
		
		File downloadedFile = new File(downloadPath+"\\"+fileName);
		if(downloadedFile.exists())
		{
			System.out.println("File downloaded suceessfull...");
		}
		else
			System.out.println("file download failed...");
		
		driver.quit();
		System.out.println("browser closed successfully...");
	}
}
