package utilities;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtilities {

	WebDriver driver;
	
	public ElementUtilities(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void clickOnElement(WebElement element,long duration)
	{
		
		try {
		WebElement webelement = waitForElement(element, duration);
		webelement.click();
		}catch(TimeoutException e)
		{
			
		}
	}
	
	public void typeTextIntoElement(WebElement element,String text,long duration)
	{
		WebElement webelement = waitForElement(element, duration);
		webelement.click();
		webelement.clear();
		webelement.sendKeys(text);
	}
	
	public WebElement waitForElement(WebElement element,long duration)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		WebElement webelement=null;
		try {
         webelement = wait.until(ExpectedConditions.elementToBeClickable(element));
		}catch(TimeoutException e)
		{
			e.printStackTrace();
		}
		
		return webelement;
	}
	
	public String javaScriptClick(WebElement element,long duration)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement webelement = waitForVisibility(element, duration);
		String elementText = (String) js.executeScript("return arguments[0].innerText;", webelement);
		
		return elementText;
	}
	
	public WebElement waitForVisibility(WebElement element,long duration)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		WebElement webelement=null;
		try {
         webelement = wait.until(ExpectedConditions.visibilityOf(element));
		}catch(TimeoutException e)
		{
			e.printStackTrace();
		}
		
		return webelement;
	}
	
	public String waitForGettingTextFromElement(WebElement element,long duration)
	{
		WebElement webelement = waitForElement(element, duration);
		
		return webelement.getText();
	}
}
