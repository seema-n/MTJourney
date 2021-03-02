# CONTENTS OF THIS FILE
---------------------

 * Introduction
 * Scenarios
 * Steps to run 
 * Results
 * Reports
 * Challenges:
 * Pending
 * Improvements


 * Introduction
This is the framework to cover user journeys on Mail Travel site. 

* Scenarios covered are
1. End to end user journey on Mail Travel
2. Sign up to Mail Travel News Letter

 * Steps to run 
- Clone the project and import on IDE (to Open the project)
- Navigate to testRunner folder and open the TestRunner file
- Run with Junit

* Results
Result of passed or failed tests will be displayed in Junit tab

* Reports
In target folder “cucumber-reports” report is generated

* Challenges:
- At the beginning, I implemented the framework using “Cucumber BDD” and “TestNG”
- While implementing reporting Serenity was not supported using TestNG
- Hence ported the framework to “Junit” and it took a while to make the changes

* Pending
- Have implemented serenity report, however the framework was ported to Junit from TestNG, there are some clashes with the versions and it is not running smoothly
- Once version conflict is resolved, the Serenity reports can be generated
- 
- To generate Serenity report run “mvn clean verify” in project path in the terminal
- Serenity Report link is generated
- On opening the link in browser it displays Serenity Report
- 
- In target Folder there is a EvidenceOfExecutionFile(Result of Successfully executed run)


* Improvements
With some extra time
1. The xpaths page object file can be customised
2. xpaths can be grouped into group of containers
3. Few common methods can be implemented to reuse
4. More assertions can be added
5. Explicit waits need to implemented
