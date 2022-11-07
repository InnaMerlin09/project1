Project structure:
1. pom.xml to manage project and dependencies
2. resources package for configurations and cucumber feature files with test scenarios (BDD model)
3. utilities package with utility classes:
   ConfigReader class to read properties
   Driver class to initialize driver
4. stepDefs package for connection with cucumber scenario steps:
   Steps class for each feature file with code for execution of Gherkin Steps
   Hooks class with Before and After annotations to set up and close browser
5. runners package with the Glue for connecting step definitions and Cucumber files
6. pages package to utilize POM design pattern:
   parent BasePage with page factory for process optimisation
   separate page classes with all corresponding locators and methods

To run the project:
1. Clone project from GitHub:
2. Run the whole feature file or each scenario separately clicking on Run Test icon on the left side