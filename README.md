# MMTDigitalTechnicalTest --- Sriranjani Vaidhyanathan

## How to run the tests (intelliJ)

1: In the run configuration drop down, select the junit runner (for Eg: 'EndToEndTestRunner' and run it. This will run all of the 
end to end tests (annotated @endtoend) in the feature file. Similary I have included separate runners for each type of tests. 
  1. SmokeTestRunner - covers a few happy path scenarios to test 
  2. LoginTestRunner - runs all the login tests including the accessibility ones
  3. InventoryTestRunner - runs all the tests covering adding and removing items in basket
2: The tests can be run on different browsers by changing the webdriver.driver property in the serenity.properties file 
and all the driver.exe files are included in the project along with their path

## How to generate the serenity report

1: After you have run all the tests, go to the configuration drop down and select the maven runner 'Generate Report'. Run this and wait
for the build to succeed. This will generate the serenity report but we will need to follow the next step in order to view it.

2: To view the report, in the left hand menu go to following path - target > site > serenity. Look for the index.html file, right click on
it and select open in browser and choose your browser preference. You should be able to view the serenity report.
