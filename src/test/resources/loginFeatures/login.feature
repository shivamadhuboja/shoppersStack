Feature: User Login
Registered User Should be able to login to access account details

Background:
Given User navigate to login page

@Login @Smoke @DataDrivenTest
Scenario Outline: Login with valid credentials
When User enters valid email <email>
And Enters valid password <password>
And Clicks on login button
Then User should login successfully to "Home" page
Examples:
|email             |password |
|"siva0001@gmail.com"|"Siva@111" |
#|"siva0002@gmail.com"|"Siva@111" |
#|"siva0003@gmail.com"|"Siva@111" |

@Login @Invalid
Scenario: Login with invalid credentials
When User enters invalid email "sssss@gmail.com"
And Enters invalid password "22222"
And Clicks on login button
Then User should get a proper warning message "Given user ID or password is wrong"

@Login @Invalid
Scenario: Login with valid email and invalid password
When User enters valid email "Shiva0001@gmail.com"
And Enters invalid password "22222"
And Clicks on login button
Then User should get a proper warning message "Given user ID or password is wrong"

@Login @Invalid
Scenario: Login with invalid email and valid password
When User enters invalid email "sssss@gmail.com"
And Enters valid password "siva@111"
And Clicks on login button
Then User should get a proper warning message "Given user ID or password is wrong"

@Login @Empty
Scenario: Login without entering email and password
And Clicks on login button
Then User should get a proper warning message email and password "Please fill out this field."

@Login @PasswordEmpty
Scenario: Login without entering password
When User enters valid email "Shiva0001@gmail.com"
And Clicks on login button
Then User should get a proper warning password message password "Please fill out this field."

@Login @EmailImcomplete
Scenario: Login without entering full email address
When User enters valid email "sss@"
And Clicks on login button
Then User should get a proper warning message emailfield incomplete "Please enter a part following '@'. 'sss@' is incomplete."
