package com.SpartaGlobal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends ASOSSite {

<<<<<<< HEAD
=======
    @FindBy(id = "myAccountDropdown")
    WebElement accountBtn;

    @FindBy(linkText = "Join")
    WebElement joinLink;

>>>>>>> registration
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

}
