package com.epam.webdriver.task2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Siarhei_Chyhir on 1/11/2016.
 */
public class ProductPage extends Page {

    private String partialTitleName = "TAC FORCE ";

    private final String buttonCartNavigationLocator = "//i[@id='gh-cart-i']";
    private final String buttonCartLocator = "//a[@id='isCartBtn_btn'][@role='button']";
    private final String linkToCartLocator = "//span[@id='atcLnk']/a";

    @FindBy(xpath = buttonCartNavigationLocator)
    private WebElement buttonCartNavigation;

    @FindBy(xpath= buttonCartLocator)
    private WebElement buttonCart;

    @FindBy(xpath= linkToCartLocator)
    private WebElement linkToCart;

    @FindAll({@FindBy(xpath= buttonCartLocator),@FindBy(xpath= linkToCartLocator)})
    private WebElement addOrGoToCart;

    public ProductPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(getDriver(), this);
    }

    public CartPage addProductToCart(){
        addOrGoToCart.click();
        return new CartPage(getDriver());
    }

    public CartPage navigateToCart(){
        buttonCartNavigation.click();
        return new CartPage(getDriver());
    }

    public Boolean isPageOpened() {
        return checkisPageOpenedByTitle(partialTitleName);
    }
}
