package com.epam.webdriver.task2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Siarhei_Chyhir on 1/11/2016.
 */
public class ProductPage extends Page {

//    private WebDriver driver;

    @FindBy(xpath= "//a[@id='isCartBtn_btn'][@role='button']")
    private WebElement buttonCart;

    @FindBy(xpath= "//i[@id='gh-cart-i']")
    private WebElement buttonCartNavigation;

    public ProductPage(WebDriver driver){
        super(driver);//this.driver = driver;
        PageFactory.initElements(getDriver(), this);
    }

    public String getPageTitle(){
        return getDriver().getTitle();
    }

    public CartPage addProductToCart(){
        buttonCart.click();
        return new CartPage(getDriver());
    }

    public CartPage navigateToCart(){
        buttonCartNavigation.click();
        return new CartPage(getDriver());
    }
}
