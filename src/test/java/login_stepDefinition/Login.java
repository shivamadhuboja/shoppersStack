package login_stepDefinition;

import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.WelcomePage;

public class Login {

	private WebDriver driver;
    private LoginPage login;
    
    // opening login page
	@Given("User navigate to login page")
	public void user_navigate_to_login_page() 
	{
		 driver=DriverFactory.getDriver();
		 WelcomePage welcome=new WelcomePage(driver);
		login = welcome.clickOnLoginButton();
	}

	// entering the email id
	@When("User enters valid email {string}")
	public void user_enters_valid_email(String validEmail) throws InterruptedException 
	{
		
		login.enteringEmailFlied(validEmail);
	}

	// entering password
	@And("Enters valid password {string}")
	public void enters_valid_password(String validPassword)
	{
		
		login.enterPasswordFlied(validPassword);
	
	}
	
	// clicking on login button
	@And("Clicks on login button")
	public void clicks_on_login_button() 
	{
		
		login.clickLoginButton();
	   
	}

	// verifying the after login welcome page is displayed or not
	@Then("User should login successfully to {string} page")
	public void user_should_login_successfully(String message)
	{
		
		login.verifyingAfterSuccessfulLogin(message);
	}

	// entering the invalid email id
	@And("User enters invalid email {string}")
	public void user_enters_invalid_email(String invalidEmail) 
	{
		
		login.enteringEmailFlied(invalidEmail);
	 
	}

	// entering the invalid password
	@And("Enters invalid password {string}")
	public void enters_invalid_password(String invalidPassword) 
	{
		
		login.enterPasswordFlied(invalidPassword);
	}

	// verifying the warning message
	@Then("User should get a proper warning message {string}")
	public void user_should_get_a_proper_warning_message(String message) 
	{
		
		login.verifyingAfterUnsuccessfulLogin(message);
	}

	// verifying after unsuccessful logging warning message is displayed
	@Then("User should get a proper warning message email and password {string}")
	public void User_should_get_a_proper_warning_message_email_and_password(String message) 
	{
	    login.verifyingAfterUnsuccessfulLoginWithoutEnteringEmail(message);
	}
	
	// verifying after unsuccessful logging warning message is displayed
	@Then("User should get a proper warning password message password {string}")
	public void User_should_get_a_proper_warning_password_message(String message) 
	{
	    login.verifyingAfterUnsuccessfulLoginWithoutEnteringPassword(message);
	}
	
	// verifying after unsuccessful logging warning message is displayed
	@Then("User should get a proper warning message emailfield incomplete {string}")
	public void User_should_get_a_proper_warning_message_emailfield(String message) 
	{
		login.verifyingAfterUnsuccessfulLoginWithoutCompletingEmail(message);
	}
}
