@loginpage
Feature: User Login
Registered user should be able to login to access account details

Background:
Given User opens Main page
Given User navigates to Login page

@login @validcredentials @smoke @regression
Scenario Outline: Login with valid credentials 
When User enters valid email address "<email>"
And Enter valid password "<password>"
Then User should login successfully
Examples:
|email|password|
|tanjiro@kamado.com|Tanjiro@1216|
|tanjiro2@kamado.com|123452|
|tanjiro3@kamado.com|Tanjiro@1216|
|tanjiro@kamado.com|Tanjiro@|


@login @invalidcredentials @smoke @regression
Scenario: Login with invalid credentials 
When User enters invalid email address "tanjiro@k.com"
And Enter invalid password "12345"

Then User should get proper warning message


@login @invalidvalidcredentials @regression
Scenario: Login with invalid email address and valid password
When User enters invalid email address "tanjiro@k.com"
And Enter valid password "12345"

And User should get the error message for invalid email address


@login @validinvalidcredentials @regression
Scenario: Login with valid email address and invalid password credential 
When User enters valid email address "tanjiro@kamado.com"
And Enter invalid password "1245"

Then User should get the error message for invalid password

@login @nocredentials @regression
Scenario: Login without providing credentials 
When User dont enter any email address
And User dont enter any  password

Then User should get proper warning message