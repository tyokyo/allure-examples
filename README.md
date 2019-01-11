# Examples of using allure-framework

This repository contains some simple examples of using allure-framework features.

## How to run?

### Tests
Execute all the tests using maven through command-line:
```bash
 mvn clean test -DsuiteFile=src/test/resources/allExamples.xml
```

Single test suite can be run by specifying the XMl file, e.g.:
 ```bash
  mvn clean test -DsuiteFile=src/test/resources/5_retries.xml
 ```
 
### Report
After tests finished, generate a report:

```bash
 mvn allure:report
```
Then you can find generated report by path: `/target/allure-report/index.html`.

If you run tests locally, you can use the following command to open a report in your default browser without generating:
```bash
 mvn allure:serve
```
In order to use **allure:serve** you need to [install allure](https://docs.qameta.io/allure/#_installing_a_commandline) first.