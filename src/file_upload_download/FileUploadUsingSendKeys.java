package file_upload_download;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/* 
 * this program demonstrates how to upload a file 
 * by using sendKeys method on file input element
 * 
 * tools used:
 * Java 17, Eclipse IDE, Selenium WebDriver 3.141.59
 */
public class FileUploadUsingSendKeys 
{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.get("https://the-internet.herokuapp.com/upload");
		
		driver.findElement(By.id("file-upload")).
		sendKeys("C:\\Users\\navee\\Desktop\\Bug-Defect-Life-Cycle-1.png");
		driver.findElement(By.id("file-submit")).click();
		
		String fileUploadStatus = driver.findElement(By.xpath("//div[2]/div/div/h3")).getText();
		
		if(fileUploadStatus.equals("File Uploaded!"))
		{
			String uploadedFileName = driver.findElement(By.id("uploaded-files")).getText();
			System.out.println("file uploaded successfully.\nuploaded file name: "
			+uploadedFileName);
		}
		else
			System.out.println("file upload failed!");
		
		driver.quit();			
	}

}
