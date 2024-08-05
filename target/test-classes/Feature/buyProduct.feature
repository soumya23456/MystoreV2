@buypage
Feature: User buy prodcut
User select product and buy product

Background:
Given User opens Main page


@search @smoke @regression
Scenario Outline: Login with credentials
Given User navigates to LogIn page
When User enter email address "<email1>"
And User enter password "<password1>"
Then User logged in successfully

When User enters product name
And searches for product
And User should get redirected to product page
And product found successfully


And User selects product size
And selects product color
And clicks product to add to cart button
And product cart alert message appears


And User opens add to cart dropdown
And clicked on procced to check out
And enters to shipping page
And clicked on Next button
And clicked on place order button
And product checked out successfully


And clicked on order number
And prints order
And closes driver
And views order details
Then logouts 
Examples:
|email1|password1|
|tanjiro@kamado.com|Tanjiro@1216|
