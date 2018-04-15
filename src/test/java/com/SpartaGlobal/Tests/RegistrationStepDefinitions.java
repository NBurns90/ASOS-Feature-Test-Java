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
        registration.fillInEmail("Bobfakejames@gmail.com");
        registration.fillInFirstNameField("Mikey");
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
        Thread.sleep(4000);
    }


    @After
    public void tearDown()
    {
        driver.close();
    }

}
