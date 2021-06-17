Feature: MakeMyTrip Login

Scenario: Check whether the page is possible to Login without providing user details
Given User is on MakeMyTrip homepage
And Clicks on Login or Create account
When User tries to login with entering Email id " " and Clicks on continue
Then Message is displayed "Please enter a valid Email Id or Mobile Number."

Scenario: Check whether the page is possible to Login by providing wrong user details
Given User is on MakeMyTrip homepage
And Clicks on Login or Create account
When User tries to login with entering Email id "adjbjbj" and Clicks on continue
Then Message is displayed "Please enter a valid Email Id or Mobile Number."


Scenario: Check and log in the page with a valid Email id and Password
Given User is on MakeMyTrip homepage
And Clicks on Login or Create account
When User tries to login with entering Email id "testng.pur.1@gmail.com" and Clicks on continue
And User enters Password "testingpurpose@1" and clicks on Login
Then User lands on MakeMyTrip HomePage and Login Validated

