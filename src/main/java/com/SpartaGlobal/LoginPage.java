package com.SpartaGlobal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ASOSSite {

    @FindBy(id = "EmailAddress")
    WebElement Email;

    @FindBy(id = "Password")
    WebElement Password;

    @FindBy(id = "signin")
    WebElement signIn;

    @FindBy(linkText = "Sign out")
    WebElement signOut;

    @FindBy(id = "EmailAddress-error")
    WebElement emailErrorMessage;

    @FindBy(id = "Password-error")
    WebElement passwordErrorMessage;

    public LoginPage(WebDriver driver)
    {
        super(driver);
    }

    public void fillInUsername (String name) {
        Email.sendKeys(name);
    }

    public void fillInPassword (String password) {
        Password.sendKeys(password);
    }

    public void clickSignInButton() {
        signIn.click();
    }

    public String checkForSignOut() {
        return signOut.getText();
    }

    public String checkForEmailErrorMessage() {
        return emailErrorMessage.getText();
    }

    public String checkForPasswordErrorMessage() {
        return passwordErrorMessage.getText();
    }

}
