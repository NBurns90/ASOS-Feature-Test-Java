package com.SpartaGlobal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ASOSSite {

    @FindBy Username
    WebElement Email;

    @FindBy Password
    WebElement Email;

    public LoginPage(WebDriver driver)
    {
        super(driver);
    }

    public void fillInEmail(String name) {

    }

    public void fillInPassword(String password) {

    }

    public void clickLogin() {

    }



}
