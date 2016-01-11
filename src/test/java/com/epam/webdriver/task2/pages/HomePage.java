package com.epam.webdriver.task2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Siarhei_Chyhir on 1/4/2016.
 */
public class HomePage extends Page{

    //private WebDriver driver;

    @FindBy(xpath= "//input[@id='gh-ac'][@type='text']")
    private WebElement searchTextBox;

    @FindBy(xpath= "//input[@id='gh-btn'][@type='submit']")
    private WebElement buttonSearch;

    @FindBy(xpath= "//i[@id='gh-cart-i']")
    private WebElement buttonCartNavigation;

    public HomePage(WebDriver driver){
        super(driver);//this.driver = driver;
        PageFactory.initElements(getDriver(), this);
    }

    public String getPageTitle(){
        return getDriver().getTitle();
    }

    public ProductListPage productSearch(String productName){
        searchTextBox.sendKeys(productName);
        buttonSearch.click();
        return new ProductListPage(getDriver());
    }
}
