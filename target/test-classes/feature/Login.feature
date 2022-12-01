Feature: Application Login
Scenario: Login with valid credentials
Given Open any Browser
And Navigate to loginpage
When user enters username as "sethuram416@gmail.com" and password as "Sethu@416"
And user clicks on login button
Then verify user is able to successfully login
