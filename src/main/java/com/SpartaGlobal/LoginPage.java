package com.SpartaGlobal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ASOSSite {

    @FindBy(id = "Username")
    WebElement Email;

    @FindBy(id = "Password")
    WebElement Password;

    @FindBy(id = "signin")
    WebElement signIn;

    public LoginPage(WebDriver driver)
    {
        super(driver);
    }

    public void fillInUsername (String name) {
        Email.sendKeys(name);
    }

    public void fillInPassword (String password) {
        Email.sendKeys(password);
    }

    public void clickSignInButton() {

    }

}
