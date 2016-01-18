package com.epam.webdriver.task2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by Siarhei_Chyhir on 1/11/2016.
 */
public class ProductListPage extends Page{

    private String partialTitleName = "knives";
    private static final String partialProductName = "Tac Force ";

    @FindBy(xpath= "//input[@id='gh-ac'][@type='text']")
    private WebElement searchTextBox;

    @FindBy(xpath= "//input[@id='gh-btn'][@type='submit']")
    private WebElement buttonSearch;

    @FindBy(id= "ResultSetItems")
    private List<WebElement> searchResultListItems;

    @FindBy(partialLinkText= partialProductName)
    private WebElement productNameLink;

    @FindBy(xpath= "//i[@id='gh-cart-i']")
    private WebElement buttonCartNavigation;

    public ProductListPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(getDriver(), this);
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

    public int searchProductsCount(){
        return searchResultListItems.size();
    }

    public Boolean isPageOpened() {
        return checkisPageOpenedByTitle(partialTitleName);
    }
}
