
Feature: Sign up to Mail Travel


  Scenario: Sign up to newsletter
    Given User is on homepage
    When User clicks on SignToNewsLetter
    And User enters all the details 
    | Fields                 | Values          |
    | Title                  | Mr              |
		| First Name             | John            |
		| Last Name              | Morgan          |
		| E-mail Address         | John.m@gmail.com|
		| Postcode							 | SW23EF					 |
		| Phone Number           | 07123456787     |
		And User clicks Signup
    Then User is Signed up successfully
    

     