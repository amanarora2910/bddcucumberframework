# bddcucumberframework
Web Automation Exercise

The following tools and libraries are used:

(1) CucumberJVM 
(2) WebDriver 
(3) Maven 
(4) Extent Report

In order to exeute the test cases, Install the following 
(1) JAVA SE 8 
(2) Maven - version 3.3.1 or higher 
(3) Cucumber plugin for Java

Before executing the project: 
(1) In Configuration.proprties file, change the driverPath according to your machine and In addition you can change it with Relative path rather than absolute. 
 
Improvements :
(1) For improvement, we can make it data driven by creating Java Utilities and adding dependencies in pom.xml as it is a maven based project
Utilize wait, try to have Fluent and Implicit wait mostly, try to avoid explicit wait.
(2) Create Page file for each web page and their locators, it will be easy for maintenance if project size increases and for locators try to use by id, 
and cssSelectors and limit use of xpath. 
(3) Further can implement logger (using log4j, logback etc) for creating log files.

There are 2 way to run the tests: 
(1) Open the project in Eclipse navigate to src > test > java > Runner and right click TestRunner.java to run tests 
(2) Open a command/terminal window, cd to the directory where the project is located and run the following: mvn test

![ExtentReport](https://user-images.githubusercontent.com/29259684/107400608-f5ffa300-6b27-11eb-8ad4-1039c0924a50.PNG)
