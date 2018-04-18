# ASOS-Feature-Test-Java

## Purpose
The purpose of this project will be to test the Login/Registration features of ASOS' website using Cucumber in Java.

### Technology and Software used
* Maven
* Java
* Selenium
* Cucumber

### Installation
#### Requirement
* IDE which can run Junit
* JDK 8 <

1. Go to https://github.com/NBurns90/ASOS-Feature-Test-Java
2. Download Zip file
3. In the terminal run 'mvn install' (for external dependencies)
4. Open project in IDE 
5. In terminal run 'cucumber' to run all tests

* Note: For valid registration scenario to pass you will need to change the the email to an email not registered with asos in the RegistrationStepDefinitions.java file within this method:
```java
    @When("^I enter valid details$")
    public void i_enter_valid_details() throws Throwable {
        registration.fillInEmail("fakeemail@fake.com");
        registration.fillInFirstNameField("Mikey");
        registration.fillInLastNameField("Fake");
        registration.fillInPasswordField("Password@1234");
        registration.setbDaySelect(1);
        registration.setbMonthSelect(1);
        registration.setbYearSelect(10);
        registration.clickMaleBtn();
    }
```

## What's Being Tested
### Outline
We have proposed that we test 2 high risk features on the ASOS website.  The Login and the Registration parts of the website.

### Registration
1. Valid Registration
      * Valid details which can result in a valid registration
2. Invalid Validation within:
      * Email
      * First
      * Last Name
      * Password
      * Date of Birth
      
### Login
1. Valid Login
      * Valid details which can result in a valid login
2. Invalid Login within boundaries of:
      * Email
      * Password
