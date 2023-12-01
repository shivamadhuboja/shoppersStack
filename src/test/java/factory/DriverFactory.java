package factory;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utilities.Utilities;


public class DriverFactory {
	
	public static WebDriver driver;

	public static WebDriver intializeBrowser(String browserName)
	{
		Properties prop = Utilities.intializeProperties();
		if(browserName.equals("chrome"))
			driver=new ChromeDriver();
		else if(browserName.equals("firefox"))
			driver=new FirefoxDriver();
		else if(browserName.equals("edge"))
			driver=new EdgeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.implicitWaitTime));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.pageLoadWaitTime));
		driver.get(prop.getProperty("url"));
		return driver;
	}
	
	public static WebDriver getDriver()
	{
		return driver;
	}
}
