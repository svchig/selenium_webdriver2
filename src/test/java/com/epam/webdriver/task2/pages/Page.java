package com.epam.webdriver.task2.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Siarhei_Chyhir on 1/11/2016.
 */
public abstract class Page {

    protected String PAGE_TITLE;

    protected final WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver(){
        return this.driver;
    }

    public Boolean isElementPresent(By locator){
        return driver.findElements(locator).size()>0;
    }

}
