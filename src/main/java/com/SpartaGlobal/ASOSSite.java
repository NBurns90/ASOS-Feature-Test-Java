package com.SpartaGlobal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class ASOSSite {

    public WebDriver driver;

    public ASOSSite(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void homePage() {
        HomePage homePage = new HomePage(driver);
    }

    public void loginPage() {
        LoginPage loginPage = new LoginPage(driver);
    }

    public void registration(){
        Registration registration = new Registration(driver);
    }

}
