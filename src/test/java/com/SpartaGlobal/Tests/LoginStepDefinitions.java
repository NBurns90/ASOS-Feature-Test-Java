package com.SpartaGlobal.Tests;

import com.SpartaGlobal.HomePage;
import com.SpartaGlobal.LoginPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;

public class LoginStepDefinitions {

    WebDriver driver = null;
    HomePage homePage;
    LoginPage loginPage;

    @Before
    public void setUp()
    {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }

    @Given("^User clicks sign in$")
    public void user_clicks_sign_up() throws Throwable {
        homePage.clickSignInLink();
    }

    @When("^User enters valid credentials$")
    public void user_enters_valid_credentials() throws Throwable {
        loginPage.fillInUsername("natburns@gmail.com");
        loginPage.fillInPassword("Kenton2810");
    }

    @When("^User clicks login$")
    public void user_clicks_login() throws Throwable {
        loginPage.clickSignInButton();
    }

    @Then("^User is taken to the homepage$")
    public void user_is_taken_to_the_homepage() throws Throwable {
        String URL = driver.getCurrentUrl();
        assertEquals("http://www.asos.com/#", URL);
        Thread.sleep(4000);
    }

    @Then("^Sign out is now an option$")
    public void sign_out_is_now_an_option() throws Throwable {
        homePage.clickAccountButton();
        homePage.checkForSignOutLink();
    }

    @After
    public void tearDown()
    {
        driver.close();
    }
}
