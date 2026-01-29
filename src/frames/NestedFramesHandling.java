package frames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/* 
 * this program demonstrates how to switch between 
 * nested frames and interact with elements inside them
 * 
 * tools used:
 * Java 17, Eclipse IDE, Selenium WebDriver 3.141.59
 */
public class NestedFramesHandling 
{

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        
        try
        {
        	//main->frame-top
        	WebElement frameTop = driver.findElement(By.xpath("//frame[@name='frame-top']"));
        	driver.switchTo().frame(frameTop);
        	
        	//frame-top(parent)->frame-left
        	WebElement frameLeft = driver.findElement(By.xpath("//frame[@name= 'frame-left']"));
        	driver.switchTo().frame(frameLeft);
        	String frameLeftText = driver.findElement(By.xpath("//body")).getText();
        	System.out.println("left frame text is: "+frameLeftText);
        	
        	//frame-left->frame-top
        	driver.switchTo().parentFrame();
        	
        	//frame-top(parent)->frame-middle
        	WebElement frameMiddle = driver.findElement(By.xpath("//frame[@name= 'frame-middle']"));
        	driver.switchTo().frame(frameMiddle);
        	String frameMiddleText = driver.findElement(By.xpath("//div[@id= 'content']")).getText();
        	System.out.println("middle frame text is: "+frameMiddleText);
        	
        	//switches back to parent(frame-top).
        	driver.switchTo().parentFrame();
        	
        	//frame-top -> frame-right
        	WebElement frameRight = driver.findElement(By.xpath("//frame[@name= 'frame-right']"));
        	driver.switchTo().frame(frameRight);
        	String frameRightText = driver.findElement(By.xpath("//body")).getText();
        	System.out.println("right frame text is: "+frameRightText);
        	
        	//switches back to parent(frame-top).
        	driver.switchTo().parentFrame();
        	
        	//switches back to original webpage(main).
        	driver.switchTo().parentFrame(); 
        	
        	//instead of above two lines, we can simply use 
        	//driver.switchTo().defaultContent() to directly jump to 
        	//main with single line.
        	
        	//main->frame-bottom
        	WebElement frameBottom = driver.findElement(By.xpath("//frame[@name= 'frame-bottom']"));
        	driver.switchTo().frame(frameBottom);
        	String frameBottomText = driver.findElement(By.xpath("//body")).getText();
        	System.out.println("bottom frame text is: "+frameBottomText);
        	
        	
        	//switches back to main webpage.
        	driver.switchTo().parentFrame();
        	
        	System.out.println
        	("browser focus returned to original content successfully in the end.");	
        }        
        catch(Exception e)
        {
        	e.printStackTrace();
        }       
        finally
        {
        	driver.quit();
        	System.out.println("Browser closed successfully...");
        }
	}

}
