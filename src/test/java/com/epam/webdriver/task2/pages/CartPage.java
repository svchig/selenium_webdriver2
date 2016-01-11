package com.epam.webdriver.task2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.List;

/**
 * Created by Siarhei_Chyhir on 1/11/2016.
 */
public class CartPage extends Page{

//    private WebDriver driver;

    @FindBy(xpath= "//i[@id='gh-cart-i']")
    private WebElement buttonCartNavigation;

    @FindBy(xpath= "//a[@class='action actionLink'][@aria-label='Remove']")
    private WebElement buttonCartRemove;

    @FindBy(xpath= "//i[@id='gh-cart-n']")
    private List<WebElement> allProductsInCart;

    @FindBy(xpath= "//a[@id='gh-ug'][@class='gh-ua gh-control'][@role='button']")
    private WebElement buttonAccountControl;

    @FindBy(xpath= "//li[@id='gh-uo']/a[contains(@href,'signin.ebay.com')]")
    private WebElement linkAccountSignOut;


    public CartPage(WebDriver driver){
        super(driver);//this.driver = driver;
        PageFactory.initElements(getDriver(), this);
    }

    public String getPageTitle(){
        return getDriver().getTitle();
    }

    public int getProductCount(){
        int iProductCount = allProductsInCart.size();
        return iProductCount;
    }

    public CartPage navigateToCart(){
        buttonCartNavigation.click();
        return new CartPage(getDriver());
    }

}
