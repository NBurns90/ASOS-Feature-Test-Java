package com.SpartaGlobal.Tests;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;

public class LoginStepDefinitions {

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
