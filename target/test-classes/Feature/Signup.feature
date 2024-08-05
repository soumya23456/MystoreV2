@signuppage
Feature: User Login
Registered user should be able to login to access account details

Background:
Given User navigates to signup page

@signup @smoke
Scenario: signup with valid credentials
When User enters first name "<fname>"
And enters last name "<lname>"
And enters valid Email "<Email>"
And enters valid Password "<Password>"
And enters valid confirm password "<PPassword>"
Then User should signup successfully










