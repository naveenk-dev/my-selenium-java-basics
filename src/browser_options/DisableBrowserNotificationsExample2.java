package browser_options;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DisableBrowserNotificationsExample2
{
    public static void main(String[] args) throws InterruptedException
    {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();

        Map<String, Object> prefs = new HashMap<>();

        //blocks browser popups
        prefs.put("profile.default_content_setting_values.notifications", 2);
        prefs.put("profile.default_content_setting_values.geolocation", 2);

        //disable password manager
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);

        options.setExperimentalOption("prefs", prefs);
        
        WebDriver driver = new ChromeDriver(options);
        
        driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();       
        Thread.sleep(1000);
        
        driver.findElement(By.id("react-burger-menu-btn")).click();
        Thread.sleep(1000);
        
        driver.findElement(By.id("logout_sidebar_link")).click();
        Thread.sleep(2000);
        
        driver.quit();
        System.out.println("Browser closed successfully...");
    }
}
