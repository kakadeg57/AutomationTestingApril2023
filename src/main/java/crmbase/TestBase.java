package crmbase;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase
{

	public static WebDriver driver;
	
	public static Properties prop;
	
	public static void initilization()
	{
		try {
		FileInputStream file = new FileInputStream("C:\\Users\\Lenovo\\eclipse-workspace\\AutomationTestingApril23\\config.properties");
		prop = new Properties();
		prop.load(file);
		}
		catch(Exception e)
		{
			System.out.println("properties file is not available");
		}
		
		String browser = prop.getProperty("browser");
		
		//1. chrome
		if(browser.contains("chrome"))
		   {
			// selenium version 4.6 onwards	
			//System.setProperty("webdriver.chrome.driver", "D:\\ChromeDrivers\\chromedriver.exe");  
			
			WebDriverManager.chromedriver().setup();
			
			driver = new ChromeDriver();
		   }
		
		//2. firefox
		else if(browser.contains("firefox"))
			{
			//System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		    }
		//3. edge
		else if(browser.contains("edge"))
		{
		System.out.println("edge browser started");
	    }
		//4. Internet Explorer
		else if(browser.contains("Internet Explorer"))
		{
		System.out.println("Internet Explorer browser started");
	    }
		
		
		else
		{
			System.out.println("please enter valid browser name");
			
		}
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
		driver.manage().deleteAllCookies();
		
		driver.get(prop.getProperty("url"));		
	}
	
	
	
}
