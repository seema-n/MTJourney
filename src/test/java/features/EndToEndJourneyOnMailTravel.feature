
Feature: End to end user journey on Mail Travel

  Scenario: Displaying list of holiday attractions
    Given user is on mail travel homepage
    When user searches for "India" as holiday destination
    And clicks on search button
    Then list of attractions are displayed
    
 Scenario: User navigates to holiday details page
 		Given list of attractions are displayed
    When user clicks on first attraction
    Then user is navigated to attraction detail page
    And number of days, price and telephone number is displayed
   
  Scenario: List of Itinerary details
    Given user is on attraction detail page
    When user clicks on Itinerary
    Then list of itinerary is displayed
    And each day in itinerary has a some valid content
    
   Scenario: Navigating to the bookings page
    Given user is on attraction detail page
    When user clicks on book online
    Then the first available date is selected with default price and user clicks continue
    And user is verifies start and end date on transport tab
   
   Scenario: Accommodation details
    Given user is on Accommodation section
    When user makes a room selection
    And selects default value under Extras section
    
   Scenario: Passangers details
   	Given passendgers detail secion is displayed
   	When user enters adult_one details 
   |Mr|John|Na|11|January|2001|
   	When user enters adult_two details 
   |Mrs|Joe|Mai|22|May|2002|
   And user enters lead contact details
   |07123456789|john.na@gmail.com|1|Highfield|London|SW34RG|
   Then payment detail page is displayed

