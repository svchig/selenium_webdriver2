package com.epam.webdriver.task2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Siarhei_Chyhir on 1/11/2016.
 */
public class ProductListPage extends Page{

//    private WebDriver driver;

    public static final String partialProductName = "TAC FORCE BLACK ";

    @FindBy(xpath= "//input[@id='gh-ac'][@type='text']")
    private WebElement searchTextBox;

    @FindBy(xpath= "//input[@id='gh-btn'][@type='submit']")
    private WebElement buttonSearch;

    @FindBy(id= "ResultSetItems")
    private WebElement SearchResultList;

    @FindBy(partialLinkText= partialProductName)
    private WebElement productNameLink;

    @FindBy(xpath= "//i[@id='gh-cart-i']")
    private WebElement buttonCartNavigation;

    public ProductListPage(WebDriver driver){
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

    public ProductPage selectProductFromList(){
        productNameLink.click();
        return new ProductPage(getDriver());
    }


}
