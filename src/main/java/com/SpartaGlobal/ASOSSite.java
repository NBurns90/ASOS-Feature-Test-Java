package com.SpartaGlobal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class   ASOSSite {

    public WebDriver driver;

    public ASOSSite(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}