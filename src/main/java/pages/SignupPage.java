package pages;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.datatable.DataTable;
import utilities.ElementUtilities;
import utilities.Utilities;

public class SignupPage {

	public WebDriver driver;
	private ElementUtilities element;
	
	public SignupPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		element=new ElementUtilities(this.driver);
	}
	
	@FindBy(id="First Name")
	private WebElement firstname;
	
	@FindBy(id="Last Name")
	private WebElement lastname;
	
	@FindBy(id="Male")
	private WebElement male;
	
	@FindBy(xpath="//span[text()='Female']")
	private WebElement maleGender;
	
	@FindBy(id="Female")
	private WebElement female;
	
	@FindBy(xpath="//span[text()='Male']")
	private WebElement femaleGender;
	
	@FindBy(id="Other")
	private WebElement other;
	
	@FindBy(xpath="//span[text()='Other']")
	private WebElement otherGender;
	
	@FindBy(id="Phone Number")
	private WebElement phoneNo;
	
	@FindBy(id="Email Address")
	private WebElement emailId;
	
	@FindBy(id="Password")
	private WebElement passwordField;
	
	@FindBy(id="Confirm Password")
	private WebElement confirmPasswordField;
	
	@FindBy(xpath="//input[@id='Terms and Conditions']")
	private WebElement termConditions;
	
	@FindBy(xpath="//button[text()='Register']")
	private WebElement continueButton;
	
	@FindBy(xpath="//h3[contains(text(),'Welcome to ShoppersStack.')]")
	private WebElement welcomPageText;
	
	@FindBy(id="Register")
	private WebElement registerPage;
	
	@FindBy(xpath="//p[contains(@id,'First Name')]")
	private WebElement firstNameWarning;
	
	@FindBy(xpath="//p[contains(@id,'Last Name')]")
	private WebElement lastNameWarning;
	
	@FindBy(xpath="//p[contains(@id,'Phone Number')]")
	private WebElement phoneNoWarning;
	
	@FindBy(xpath="//p[contains(@id,'Email Address')]")
	private WebElement emailWarning;
	
	@FindBy(xpath="//p[contains(@id,'password')]")
	private WebElement passwordWarning;
	
	@FindBy(xpath="//p[contains(@id,'cnfPassword')]")
	private WebElement confirmPasswordWarning;
	
	public void enteredFirstName(String firstName)
	{
		element.typeTextIntoElement(firstname, firstName, Utilities.expilictWaitTime);
	}
	
	public void enteredLastName(String lastName)
	{
	    element.typeTextIntoElement(lastname, lastName, Utilities.expilictWaitTime);	
	}
	
	public void selectedGender()
	{
       male.click();
	}
	
	public void enteredPhoneNo(String number)
	{
		element.typeTextIntoElement(phoneNo, number, Utilities.expilictWaitTime);
	}
	
	public void enteredEmail(String email)
	{
		element.typeTextIntoElement(emailId, email, Utilities.expilictWaitTime);
	}
	
	public void enteredPassword(String password)
	{
		element.typeTextIntoElement(passwordField, password, Utilities.expilictWaitTime);
	}
	
	public void enteredConfirmPassword(String confirmPassword)
	{
		element.typeTextIntoElement(confirmPasswordField, confirmPassword, Utilities.expilictWaitTime);
	}
	
	public void selectedTermsAndConditions()
	{
		termConditions.click();
	}
	
	public void clickOnContinueButton()
	{
		continueButton.click();
	}
	
	public void verifyingAfterSuccessfulLogin(String message)
	{
	    Assert.assertEquals( "welcom page text is not displaying", message, element.waitForGettingTextFromElement(welcomPageText, Utilities.expilictWaitTime));
	}
	
	public void verifyingAfterUnsuccessfulLogin()
	{
	       Assert.assertFalse(registerPage.isEnabled());

	}
	
	public void verifyingAfterEnteringNotMinimumRangeValuesInMandatoryFieldsUnsuccessfulLogin(DataTable dataTable)
	{
		   Map<String, String> map = dataTable.asMap(String.class, String.class);

	    Assert.assertEquals( "FirstName warning text is not displaying", map.get("firstNameWarning"), firstNameWarning.getText());
	    Assert.assertEquals( "LastName warning text is not displaying", map.get("lastNameWarning"), lastNameWarning.getText());
	    Assert.assertEquals( "PhoneNo warning text is not displaying", map.get("phoneNoWarning"), phoneNoWarning.getText());
	    Assert.assertEquals( "Email warning text is not displaying", map.get("emailWarning"), emailWarning.getText());
	    Assert.assertEquals( "Password warning text is not displaying", map.get("passwordWarning"), passwordWarning.getText());
	    Assert.assertEquals( "ConfirmPassword warning text is not displaying", map.get("confirmPasswordWarning"), confirmPasswordWarning.getText());


	}
}
