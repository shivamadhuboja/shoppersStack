package hooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.Utilities;

public class MyHooks {

	public WebDriver driver;
	
	@Before
	public void launchingBrowser()
	{
	  Properties prop = Utilities.intializeProperties();
	  System.out.println(prop.getProperty("browser"));
      driver=DriverFactory.intializeBrowser(prop.getProperty("browser"));
      driver=DriverFactory.getDriver();
	}
	
	@After
	public void tearDown(Scenario scenario)
	{
		String scenarioName=scenario.getName().replace(" ", "_");
		
		if(scenario.isFailed())
		{
			byte[] screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenShot, "image/png", scenarioName);
		}
       driver.manage().window().minimize();
       driver.quit();

	}
}
