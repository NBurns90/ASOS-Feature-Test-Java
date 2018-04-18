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

    @Given("^I am on the ASOS home page$")
    public void i_am_on_the_ASOS_home_page() throws Throwable {
        driver.get("http://www.asos.com");
    }

    @When("^I click on the account icon$")
    public void i_click_on_the_account_icon() throws Throwable {
        homePage.clickAccountButton();
    }

    @When("^I click on the JOIN link$")
    public void i_click_on_the_JOIN_link() throws Throwable {
        homePage.clickJoinLink();
    }

    @When("^I enter valid details$")
    public void i_enter_valid_details() throws Throwable {
        registration.fillInEmail("Bobffffakemcfakerake32y@gmail.com");
        registration.fillInFirstNameField("Migey");
        registration.fillInLastNameField("Fake");
        registration.fillInPasswordField("Password@1234");
        registration.setbDaySelect(1);
        registration.setbMonthSelect(1);
        registration.setbYearSelect(10);
        registration.clickMaleBtn();
    }

    @When("^I click the JOIN ASOS button$")
    public void i_click_the_JOIN_ASOS_button() throws Throwable {
        registration.clickRegisterBtn();

    }

    @Then("^I am taken to Home page$")
    public void i_am_taken_to_ITEM_BAG_page() throws Throwable {
        String URL = driver.getCurrentUrl();
        assertEquals(URL, "http://www.asos.com/?la=2" );

    }

    @Then("^I receive a no email error message$")
    public void i_receive_a_no_email_error_message() throws Throwable {
        Thread.sleep(4000);
        assertEquals("Oops! You need to type your email here", registration.emailErrorMessage());
    }

    @When("^I enter an email in invalid format$")
    public void i_enter_an_email_in_invalid_format() throws Throwable {
        registration.fillInEmail("Invalid");
    }

    @Then("^I receive an invalid format email error message$")
    public void i_receive_an_invalid_format_email_error_message() throws Throwable {
        assertEquals("Email fail! Please type in your correct email address", registration.emailErrorMessage());
    }

    @When("^I enter an email which has already been used$")
    public void i_enter_an_email_which_has_already_been_used() throws Throwable {
        registration.fillInEmail("cbryant1993@gmail.com");
    }

    @Then("^I receive an already registered email error message$")
    public void i_receive_an_already_registered_email_error_message() throws Throwable {
        assertEquals("The email address has already been allocated to another customer", registration.rEmailMessage());
    }

    @When("^I enter an email which is more than 100 characters$")
    public void i_enter_an_email_which_is_more_than_characters() throws Throwable {
        registration.fillInEmail("sabusahbcusacbasucbsaucbsauhbcuasbcuahsbcuhasbcuahsbcuashbcuhasbcuhasbcuahsbcuhasbcuahsbcuahsbcuahsbcuhsab@hotmail.com");
    }

    @Then("^I receive an email is too long email error message$")
    public void I_receive_an_email_is_too_long_email_error_message() throws Throwable {
        Thread.sleep(4000);
        assertEquals("Name must not exceed 100 characters", registration.rEmailMessage());
    }

    @Then("^I receive a no firstname error message$")
    public void I_receive_a_no_firstname_error_message() throws Throwable {
        assertEquals("We need your first name – it’s nicer that way", registration.noFirstNameErrorMessage());
    }

    @Then("^I receive a no lastname error message$")
    public void i_receive_a_no_lastname_error_message() throws Throwable {
        assertEquals("Last name, too, please!", registration.noLastNameErrorMessage());
    }

    @Then("^I receive a no password error message$")
    public void i_receive_a_no_password_error_message() throws Throwable {
        assertEquals("Hey, we need a password here", registration.noPasswordErrorMessage());
    }

    @When("^I enter an invalid password$")
    public void i_enter_an_invalid_password() throws Throwable {
        registration.fillInPasswordField("Pass");
    }

    @Then("^I receive an invalid password error message$")
    public void i_receive_an_invalid_password_error_message() throws Throwable {
        assertEquals("At least 6 letters and 1 number, please!", registration.invalidPasswordErrorMessage());
    }

    @When("^I select invalid DOB$")
    public void i_select_invalid_DOB() throws Throwable {
        registration.setbDaySelect(6);
        registration.setbMonthSelect(6);
        registration.setbYearSelect(1);
    }

    @Then("^I receive an invalid DOB error message$")
    public void i_receive_an_invalid_DOB_error_message() throws Throwable {
        assertEquals("Oops. Looks like you're too young to use ASOS.", registration.invalidDOBErrorMessage());
    }

    @Given("^I enter all valid details except email$")
    public void i_enter_all_valid_details_except_email() throws Throwable {
        registration.fillInFirstNameField("Christian");
        registration.fillInLastNameField("Fake");
        registration.fillInPasswordField("Password@1234");
        registration.setbDaySelect(1);
        registration.setbMonthSelect(1);
        registration.setbYearSelect(10);
        registration.clickMaleBtn();
    }

    @Given("^I enter all valid details except Firstname$")
    public void i_enter_all_valid_details_except_Firstname() throws Throwable {
        registration.fillInEmail("Bobffafakeuitey@gmail.com");
        registration.fillInLastNameField("Fake");
        registration.fillInPasswordField("Password@1234");
        registration.setbDaySelect(1);
        registration.setbMonthSelect(1);
        registration.setbYearSelect(10);
        registration.clickMaleBtn();
    }

    @Given("^I enter all valid details except Lastname$")
    public void i_enter_all_valid_details_except_Lastname() throws Throwable {
        registration.fillInEmail("Bobffafakeuitey@gmail.com");
        registration.fillInFirstNameField("Migey");
        registration.fillInPasswordField("Password@1234");
        registration.setbDaySelect(1);
        registration.setbMonthSelect(1);
        registration.setbYearSelect(10);
        registration.clickMaleBtn();
    }

    @Given("^I enter all valid details except Password$")
    public void i_enter_all_valid_details_except_Password() throws Throwable {
        registration.fillInEmail("Bobffafakeuitey@gmail.com");
        registration.fillInFirstNameField("Migey");
        registration.fillInLastNameField("Fake");
        registration.setbDaySelect(1);
        registration.setbMonthSelect(1);
        registration.setbYearSelect(10);
        registration.clickMaleBtn();
    }

    @Given("^I enter all valid details except DOB$")
    public void i_enter_all_valid_details_except_DOB() throws Throwable {
        registration.fillInEmail("Bobffafakeuitey@gmail.com");
        registration.fillInFirstNameField("Migey");
        registration.fillInLastNameField("Fake");
        registration.fillInPasswordField("Password@1234");
        registration.clickMaleBtn();
    }

    @After
    public void tearDown()
    {
        driver.close();
    }

}
