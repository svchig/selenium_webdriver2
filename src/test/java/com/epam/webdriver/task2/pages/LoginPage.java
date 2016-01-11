package com.epam.webdriver.task2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Siarhei_Chyhir on 1/4/2016.
 */
public class LoginPage extends Page{

    //private WebDriver driver;

    @FindBy(xpath= "//input[@id='userid'][@class='fld'][@type='text']")
    private WebElement inputLogin;

    @FindBy(xpath= "//input[@id='pass'][@class='fld'][@type='password']")
    private WebElement inputPassword;

    @FindBy(xpath= "//input[@id='sgnBt'][@type='submit']")
    private WebElement buttonSignIn;

    public LoginPage(WebDriver driver){
        super(driver);//this.driver = driver;
        PageFactory.initElements(getDriver(), this);
    }

    public String getPageTitle(){
        return getDriver().getTitle();
    }

    public HomePage login(String username, String password){
        inputLogin.sendKeys(username);
        inputPassword.sendKeys(password);
        buttonSignIn.click();
        return new HomePage(getDriver());
    }
}
