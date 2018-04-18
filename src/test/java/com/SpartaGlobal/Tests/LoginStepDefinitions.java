package com.SpartaGlobal.Tests;

import com.SpartaGlobal.HomePage;
import com.SpartaGlobal.LoginPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class LoginStepDefinitions {

    WebDriver driver = null;

    HomePage homePage;
    LoginPage loginPage;

    @Before
    public void setUp()
    {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
    }

    @Given("^I am on the ASOS login page$")
    public void i_am_on_the_ASOS_login_page() throws Throwable {
        driver.get("https://my.asos.com");
    }

    @When("^I enter valid credentials$")
    public void i_enter_valid_credentials() throws Throwable {
        loginPage.fillInUsername("g2077439@nwytg.com");
        loginPage.fillInPassword("PASSword123");
    }

    @When("^I click the sign in button$")
    public void i_click_the_sign_in_button() throws Throwable {
        loginPage.clickSignInButton();
    }

    @Then("^I am taken to my account page$")
    public void i_am_taken_to_my_account_page() throws Throwable {
        Thread.sleep(4000);
        String URL = driver.getCurrentUrl();
        assertEquals("https://my.asos.com/my-account?lang=en-us", URL);
    }

    @Then("^Sign out is now an option$")
    public void sign_out_is_now_an_option() throws Throwable {
        assertEquals("Sign out", loginPage.checkForSignOut());
    }

    @When("^I leave my email blank and enter a password$")
    public void i_leave_my_email_blank_and_enter_a_password() throws Throwable {
        loginPage.fillInUsername("");
        loginPage.fillInPassword("PASSword123");
    }

    @Then("^I should receive an email error message$")
    public void i_should_receive_an__email_error_message() throws Throwable {
        assertEquals("Whups! You need to type your email here", loginPage.checkForEmailErrorMessage());
    }

    @When("^I leave my password blank and enter a username$")
    public void i_leave_my_password_blank_and_enter_a_username() throws Throwable {
        loginPage.fillInPassword("");
        loginPage.fillInUsername("g2077439@nwytg.com");
    }

    @Then("^I should receive an password error message$")
    public void i_should_receive_an_password_error_message() throws Throwable {
        assertEquals("Hey, we need a password here", loginPage.checkForPasswordErrorMessage());
    }

    @After
    public void tearDown()
    {
        driver.close();
    }
}
