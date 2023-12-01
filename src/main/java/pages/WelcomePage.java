package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ElementUtilities;
import utilities.Utilities;

public class WelcomePage {

	public WebDriver driver;
	private ElementUtilities element;
	public WelcomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		element=new ElementUtilities(this.driver);
	}
	
	@FindBy(xpath="//button[text()='Login']")
	private WebElement loginButton;
	
	@FindBy(id="Create Account")
	private WebElement createAccount;
	
	public LoginPage clickOnLoginButton()
	{
		element.clickOnElement(loginButton, Utilities.expilictWaitTime);
		
		return new LoginPage(driver);
	}
	

	public SignupPage clickOnCreateAccount()
	{
		element.clickOnElement(createAccount, Utilities.expilictWaitTime);
		
		return new SignupPage(driver);
	}
}
