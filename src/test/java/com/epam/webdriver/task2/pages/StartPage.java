package com.epam.webdriver.task2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Siarhei_Chyhir on 1/4/2016.
 */
public class StartPage extends Page{

    public static final String URL = "http://ebay.com";
    //private WebDriver driver;

    @FindBy(xpath= "//a[contains(@href,'signin.ebay.com')]")
    private WebElement linkSignIn;

    public StartPage(WebDriver driver){
        super(driver);//this.driver = driver;
        PageFactory.initElements(getDriver(), this);
    }

    public StartPage openPage(){
        getDriver().get(URL);
        return this;
    }

    public LoginPage singIn(){
        linkSignIn.click();
        return new LoginPage(getDriver());
    }

    public String getPageTitle(){
        return getDriver().getTitle();
    }
}
