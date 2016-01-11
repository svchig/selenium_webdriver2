package com.epam.webdriver.task2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Siarhei_Chyhir on 1/4/2016.
 */
public class StartPage {

    public static final String URL = "http://ebay.com";
    private WebDriver driver;

    @FindBy(xpath= "//a[contains(@href,'signin.ebay.com')]")
    private WebElement linkSignIn;

    public StartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void openPage(){
        this.driver.get(URL);
    }

    public LoginPage singIn(){
        linkSignIn.click();
        return new LoginPage(this.driver);
    }
}
