# MMTDigitalTechnicalTest --- Sriranjani Vaidhyanathan

## Pre Requisites

The tests should be run on a windows machine and the following browsers are supported.
  1. Chrome
  2. Edge
  3. Firefox
Support for mac OS and safari browser will be added in subsequent releases.

## How to run the tests (intelliJ)

1: In the run configuration drop down, select the junit runner (for Eg: 'EndToEndTestRunner' and run it. This will run all of the 
end to end tests (annotated @endtoend) in the feature file. Similary I have included separate runners for each type of tests. 
  1. SmokeTestRunner - covers a few happy path scenarios to test 
  2. LoginTestRunner - runs all the login tests including the accessibility ones
  3. InventoryTestRunner - runs all the tests covering adding and removing items in basket


2: The tests can be run on different browsers by changing the webdriver.driver property in the serenity.properties file 
and all the driver.exe files are included in the project along with their path

3: To run tests from Command line : 
mvn clean verify -B -Pserenity serenity:aggregate -Dserenity.outputDirectory=./target/site/serenity "-Dcucumber.options=--tags @endtoend
(Scenarios with tag @endtoend will be run)


## How to generate the serenity report

1: After you have run all the tests, go to the configuration drop down and select the maven runner 'Generate Report'. Run this and wait
for the build to succeed. This will generate the serenity report but we will need to follow the next step in order to view it.

2: To view the report, in the left hand menu go to following path - target > site > serenity. Look for the index.html file, right click on
it and select open in browser and choose your browser preference. You should be able to view the serenity report.
