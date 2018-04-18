package com.SpartaGlobal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Registration extends ASOSSite {

    @FindBy(id = "Email")
    WebElement emailField;

    @FindBy(id = "FirstName")
    WebElement firstNameField;

    @FindBy(id = "LastName")
    WebElement lastNameField;

    @FindBy(id = "Password")
    WebElement passwordField;

    @FindBy(xpath = "//*[@id=\"BirthDay\"]")
    WebElement bDaySelect;

    @FindBy(id = "BirthMonth")
    WebElement bMonthSelect;

    @FindBy(id = "BirthYear")
    WebElement bYearSelect;

    @FindBy(xpath = "//*[@id=\"main\"]/div[1]/div[2]/form/fieldset/div[6]/div[2]")
    WebElement maleRadioBtn;

    @FindBy( xpath = "//*[@id=\"main\"]/div[1]/div[2]/form/fieldset/div[6]/div[1]")
    WebElement femaleRadioBtn;

    @FindBy(id = "register")
    WebElement registerBtn;

    @FindBy(id = "Email-error")
    WebElement emailError;

    @FindBy(xpath = "//*[@id=\"main\"]/div[1]/div[2]/form/fieldset/div[1]/div[1]/span")
    WebElement rEmailError;

    public Registration(WebDriver driver){
        super(driver);
    }

    public void fillInEmail(String email){
        emailField.sendKeys(email);
    }

    public void fillInFirstNameField(String firstName){
        firstNameField.sendKeys(firstName);
    }

    public void fillInLastNameField(String lastName){
        lastNameField.sendKeys(lastName);
    }

    public void fillInPasswordField(String password){
        passwordField.sendKeys(password);
    }

    public void setbDaySelect(int day){
        Select select = new Select(bDaySelect);
        select.getOptions().get(day).click();
    }

    public void setbMonthSelect(int month){
        Select select = new Select(bMonthSelect);
        select.getOptions().get(month).click();
    }

    public void setbYearSelect(int year){
        Select select = new Select(bYearSelect);
        select.getOptions().get(year).click();
    }

    public void clickMaleBtn(){
        maleRadioBtn.click();
    }

    public void clickFemaleBtn(){
        femaleRadioBtn.click();
    }

    public void clickRegisterBtn(){
        registerBtn.click();
    }

    public String emailErrorMessage(){
        return emailError.getText();
    }

    public String rEmailMessage(){
        return rEmailError.getText();
    }
}
