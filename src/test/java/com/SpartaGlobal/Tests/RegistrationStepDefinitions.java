package com.SpartaGlobal.Tests;

import com.SpartaGlobal.HomePage;
import com.SpartaGlobal.Registration;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class RegistrationStepDefinitions {

    WebDriver driver = null;
    HomePage homePage;
    Registration registration;

    @Before
    public void setUp()
    {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        homePage = new HomePage(driver);
        registration = new Registration(driver);
    }

    @Given("^User is on the ASOS home page$")
    public void user_is_on_the_ASOS_home_page() throws Throwable {
        driver.get("http://www.asos.com");
    }

    @When("^User clicks on the account icon$")
    public void user_clicks_on_the_account_icon() throws Throwable {
        homePage.clickAccountButton();
    }

    @When("^User clicks on the JOIN link$")
    public void user_clicks_on_the_JOIN_link() throws Throwable {
        homePage.clickJoinLink();
    }

    @When("^User entails valid details$")
    public void user_entails_valid_details() throws Throwable {
        registration.fillInEmail("Bobfakejfakey@gmail.com");
        registration.fillInFirstNameField("Migey");
        registration.fillInLastNameField("Fake");
        registration.fillInPasswordField("Password@1234");
        registration.setbDaySelect(1);
        registration.setbMonthSelect(1);
        registration.setbYearSelect(10);
        registration.clickMaleBtn();
    }

    @When("^User clicks the JOIN ASOS button$")
    public void user_clicks_the_JOIN_ASOS_button() throws Throwable {
        registration.clickRegisterBtn();

    }

    @Then("^User is taken to ITEM BAG page$")
    public void user_is_taken_to_ITEM_BAG_page() throws Throwable {
        String URL = driver.getCurrentUrl();
        assertEquals(URL, "http://www.asos.com/bag?nlid=nav%20header" );
    }

    @When("^User enters valid FirstName$")
    public void user_enters_valid_FirstName() throws Throwable {
        registration.fillInFirstNameField("Christian");

    }

    @When("^User enters valid LastName$")
    public void user_enters_valid_LastName() throws Throwable {
        registration.fillInLastNameField("Bryant");
    }

    @When("^User enters valid Password$")
    public void user_enters_valid_Password() throws Throwable {
        registration.fillInPasswordField("Password@1234");
    }

    @When("^User selects valid DOB$")
    public void user_selects_valid_DOB() throws Throwable {
        registration.setbDaySelect(1);
        registration.setbMonthSelect(1);
        registration.setbYearSelect(10);
    }

    @When("^User selects Gender$")
    public void user_selects_Gender() throws Throwable {
        registration.clickMaleBtn();
    }

    @Then("^User receive's no email error message$")
    public void user_receive_s_no_email_error_message() throws Throwable {
        assertEquals("Oops! You need to type your email here", registration.emailErrorMessage());
    }

    @When("^User enters email in invalid format$")
    public void user_enters_email_in_invalid_format() throws Throwable {
        registration.fillInEmail("Invalid");
    }

    @Then("^User receive's invalid format email error message$")
    public void user_receive_s_invalid_format_email_error_message() throws Throwable {
        assertEquals("Email fail! Please type in your correct email address", registration.emailErrorMessage());
    }

    @When("^User enters email which has already been used$")
    public void user_enters_email_which_has_already_been_used() throws Throwable {
        registration.fillInEmail("cbryant1993@gmail.com");
    }

    @Then("^User receive's already registered email error message$")
    public void user_receive_s_already_registered_email_error_message() throws Throwable {
        assertEquals("The email address has already been allocated to another customer", registration.rEmailMessage());
    }

    @When("^User enters email which is more than 100 characters$")
    public void user_enters_email_which_is_more_than_characters() throws Throwable {
        registration.fillInEmail("sabusahbcusacbasucbsaucbsauhbcuasbcuahsbcuhasbcuahsbcuashbcuhasbcuhasbcuahsbcuhasbcuahsbcuahsbcuahsbcuhsab@hotmail.com");
    }

    @Then("^User receive's email is too long email error message$")
    public void user_receive_s_email_is_too_long_email_error_message() throws Throwable {
        Thread.sleep(4000);
        assertEquals("Name must not exceed 100 characters", registration.rEmailMessage());
    }

    @Then("^User receive's no firstname error message$")
    public void user_receive_s_no_firstname_error_message() throws Throwable {
        assertEquals("We need your first name – it’s nicer that way", registration.noFirstNameErrorMessage());
    }

    @Then("^User receive's no lastname error message$")
    public void user_receive_s_no_lastname_error_message() throws Throwable {
        assertEquals("Last name, too, please!", registration.noLastNameErrorMessage());
    }

    @Then("^User receive's no password error message$")
    public void user_receive_s_no_password_error_message() throws Throwable {
        assertEquals("Hey, we need a password here", registration.noPasswordErrorMessage());
    }

    @When("^User enters an invalid password$")
    public void user_enters_an_invalid_password() throws Throwable {
        registration.fillInPasswordField("Pass");
    }

    @Then("^User receive's invalid password error message$")
    public void user_receive_s_invalid_password_error_message() throws Throwable {
        assertEquals("At least 6 letters and 1 number, please!", registration.invalidPasswordErrorMessage());
    }

    @When("^User selects invalid DOB$")
    public void user_selects_invalid_DOB() throws Throwable {
        registration.setbDaySelect(6);
        registration.setbMonthSelect(6);
        registration.setbYearSelect(1);
    }

    @Then("^User receive's invalid DOB error message$")
    public void user_receive_s_invalid_DOB_error_message() throws Throwable {
        assertEquals("Oops. Looks like you're too young to use ASOS.", registration.invalidDOBErrorMessage());
    }



    @After
    public void tearDown()
    {
        driver.close();
    }

}
