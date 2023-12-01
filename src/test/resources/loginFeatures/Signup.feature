Feature: User Sign-up Account
User should able register to account

Background:
Given User navigate to Sign-up page

@Signup @Smoke @Regression
Scenario: User should signup to account with all valid details 
When User enters below details into the fields
|firstName|siva|
|lastName|madhu|
|phoneNo |7673952440|
#|email   |AutoGenerateEmail|
|password|Siva@111|
|confirmPassword|Siva@111|
And Selects gender male
And selects I agree to the Terms and Conditions checkbox
And Clicks on register button
Then User should be successfully navigate Welcom page "Welcome to ShoppersStack. Enjoy shopping with us."

@Signup 
Scenario: User should signup to account without select I agree to the Terms and Conditions checkbox
When User enters below details into the fields
|firstName|siva|
|lastName|madhu|
|phoneNo |7673952440|
#|email   |AutoGenerateEmail|
|password|Siva@111|
|confirmPassword|Siva@111|
And Selects gender male
And Clicks on register button
Then User should be unable to click on register button

@Signup
Scenario: User should signup to account without entering any mandatory fields
When Clicks on register button
Then User should be unable to click on register button

@Singup
Scenario: User should signup to account without entering minimum range characters in mandatory fields
When User enters below not in range details into the fields
|firstName|si|
|lastName|ma|
|phoneNo |767395244|
|email   |siv|
|password|siva|
|confirmPassword|Siva|
And Selects gender male
And Clicks on register button
Then User should be unable to register and warning messages should be display
|firstNameWarning       |Must have at least 3 and less than 20 characters                |
|lastNameWarning        |Must have at least 3 and less than 20 characters                |
|phoneNoWarning         |Must be 10 digit                                                |
|emailWarning           |invalid email                                                   |
|passwordWarning        |must contain min 1 number , 1 uppercase ,lowecase , special char|
|confirmPasswordWarning |password does not match                                         |
