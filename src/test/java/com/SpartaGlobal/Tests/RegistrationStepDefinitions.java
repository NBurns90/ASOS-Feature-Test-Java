package com.SpartaGlobal.Tests;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;

public class RegistrationStepDefinitions {

    WebDriver driver = null;

    @Before
    public void setUp()
    {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }


    @After
    public void tearDown()
    {
        driver.close();
    }

}
