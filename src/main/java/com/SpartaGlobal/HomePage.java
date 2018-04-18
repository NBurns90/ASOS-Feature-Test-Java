package com.SpartaGlobal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends ASOSSite {

    @FindBy(id = "myAccountDropdown")
    WebElement accountBtn;

    @FindBy(linkText = "Join")
    WebElement joinLink;

    @FindBy(linkText = "My Account")
    WebElement signInLink;

    public HomePage(WebDriver driver)
    {
        super(driver);
    }

    public void clickAccountButton()
    {
        accountBtn.click();
    }

    public void clickJoinLink(){
        joinLink.click();
    }

    public void clickSignInLink(){
        signInLink.click();
    }

    public void checkForSignOutLink() {
        driver.findElement(By.linkText("Sign Out"));
    }

}
