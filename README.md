
## Test Project

### Getting Started

Run tests with command:

```bash
$ ./mvn clean test site
```
List of used emails and measurement of execution time will be generated to `target/app.log` file.

Default TestNG report will be generated to `target/surefire-reports` folder.

Allure report will be generated to `target/site/allure-maven-plugin` folder. (There is underinvestigated issue. It creates report not for all test suites)



### Run tests from IDE

1. Navigate to `src\test\resources\testSuites\MainSuite.xml`.

2. Right click on `MainSuite.xml` file.

3. Select "Run"

### Project Stucture

Package `com.testProject.conf` contains basic configurations e.g. driver creating, tests initializing, helper methods.
Also it contains Page Object classes.

Package `com.testProject.tests` contains tests which will be executed.

Folder `src\test\resources\testSuites` contains test suites (for different thread number) for running. There is main suite that runs all suites (for different threads number).



