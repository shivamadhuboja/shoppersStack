package login_stepDefinition;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SignupPage;
import pages.WelcomePage;
import utilities.Utilities;

public class Signup {

	private WebDriver driver;
	private SignupPage signup;
	
	// opening sign-up page
	@Given("User navigate to Sign-up page")
	public void user_navigate_to_sign_up_page() 
	{
	   driver=DriverFactory.getDriver();
	   WelcomePage welcome=new WelcomePage(driver);
	   welcome.clickOnLoginButton();
	   signup=welcome.clickOnCreateAccount();
	}

	// entering valid details in the fields
	@When("User enters below details into the fields")
	public void User_enters_below_details_into_the_fields(DataTable dataTable)
	{
	   Map<String, String> map = dataTable.asMap(String.class, String.class);
	   
	   signup.enteredFirstName(map.get("firstName"));
	   signup.enteredLastName(map.get("lastName"));
	   signup.enteredPhoneNo(map.get("phoneNo"));
	   signup.enteredEmail(Utilities.generateEmail());
	   signup.enteredPassword(map.get("password"));
	   signup.enteredConfirmPassword(map.get("confirmPassword"));
	  
	}
	
	//entering not in range details into below details
	@When("User enters below not in range details into the fields")
	public void User_enters_below_not_in_range_details_into_the_fields(DataTable dataTable)
	{
	   Map<String, String> map = dataTable.asMap(String.class, String.class);
	   
	   signup.enteredFirstName(map.get("firstName"));
	   signup.enteredLastName(map.get("lastName"));
	   signup.enteredPhoneNo(map.get("phoneNo"));
	   signup.enteredEmail(map.get("email"));
	   signup.enteredPassword(map.get("password"));
	   signup.enteredConfirmPassword(map.get("confirmPassword"));
	}

	// selecting the gender
	@And("^Selects gender male$")
	public void selects_gender_male() 
	{
		signup.selectedGender();
	}

	// selecting the terms and conditions
	@And("selects I agree to the Terms and Conditions checkbox")
	public void selects_i_agree_to_the_terms_and_conditions_checkbox() 
	{
		signup.selectedTermsAndConditions();
	}

	// clicking on register button
	@And("Clicks on register button")
	public void clicks_on_register_button()
	{
		signup.clickOnContinueButton();
	}

	// verifying after successful login logging message is displayed
	@Then("User should be successfully navigate Welcom page {string}")
	public void user_should_be_successfully_navigate_welcom_page(String message) 
	{
		signup.verifyingAfterSuccessfulLogin(message);
	}

	// verifying after unsuccessful logging warning message is displayed
	@Then("User should be unable to click on register button")
	public void user_should_be_unable_to_register() 
	{
		signup.verifyingAfterUnsuccessfulLogin();
	}

	@Then("User should be unable to register and warning messages should be display")
	public void User_should_be_unable_to_register_and_warning_messages_should_be_display(DataTable dataTable) 
	{

		signup.verifyingAfterEnteringNotMinimumRangeValuesInMandatoryFieldsUnsuccessfulLogin(dataTable);
	}

}
