package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ElementUtilities;
import utilities.Utilities;


public class LoginPage {

	private WebDriver driver;
	private ElementUtilities element;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		element=new ElementUtilities(this.driver);
		
	}
	
	@FindBy(id="Email")
	private WebElement emailField;
	
	@FindBy(id="Password")
	private WebElement passwordField;
	
	@FindBy(id="Login")
	private WebElement loginButton;
	
	@FindBy(linkText="Home")
	private WebElement successfulMsg;
	
	@FindBy(xpath="//div[contains(text(),'user ID or password is wrong')]")
	private WebElement warningMsg;
	
	// this method is used to entering data into email field until emailTextField appear 30sec wait
	public void enteringEmailFlied(String email) 
	{
		element.typeTextIntoElement(emailField, email, Utilities.expilictWaitTime);
		
	}
	
	// this method is used to entering data into password field until passwordTextField appear 30sec wait
	public void enterPasswordFlied(String password)
	{
	
		element.typeTextIntoElement(passwordField, password, Utilities.expilictWaitTime);
	}
	
	// this method is used to click on login button until button was visible to 30sec wait
	public void clickLoginButton()
	{
		element.clickOnElement(loginButton, Utilities.expilictWaitTime);
	}
	
	public void verifyingAfterSuccessfulLogin(String message)
	{
		
		Assert.assertEquals("Successful message not displayed", message, successfulMsg.getText());

	}
	
	public void verifyingAfterUnsuccessfulLogin(String message)
	{
		Assert.assertEquals("Warning message not displayed", message, element.javaScriptClick(warningMsg, Utilities.expilictWaitTime));

	}
	
	public void verifyingAfterUnsuccessfulLoginWithoutEnteringEmail(String message)
	{
	    Assert.assertEquals( "Email warning text is not displaying", message, emailField.getAttribute("validationMessage"));

	}
	
	public void verifyingAfterUnsuccessfulLoginWithoutEnteringEmailSymbol(String message)
	{
	    Assert.assertEquals( "Email warning text is not displaying", message, emailField.getAttribute("validationMessage"));

	}
	
	public void verifyingAfterUnsuccessfulLoginWithoutCompletingEmail(String message)
	{
	    Assert.assertEquals( "Email warning text is not displaying", message, emailField.getAttribute("validationMessage"));

	}
	
	public void verifyingAfterUnsuccessfulLoginWithoutEnteringPassword(String message)
	{
	    Assert.assertEquals( "Password warning text is not displaying", message, passwordField.getAttribute("validationMessage"));

	}
}
