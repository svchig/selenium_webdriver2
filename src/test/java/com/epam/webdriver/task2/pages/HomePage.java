package com.epam.webdriver.task2.pages;

import org.openqa.selenium.WebDriver;

/**
 * Created by Siarhei_Chyhir on 1/4/2016.
 */
public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public String getPageTitle(){
        return this.driver.getTitle();
    }
}
