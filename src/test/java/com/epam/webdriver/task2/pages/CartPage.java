package com.epam.webdriver.task2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by Siarhei_Chyhir on 1/11/2016.
 */
public class CartPage extends Page{

    private String partialURL = "cart.payments.ebay.com";

    private final String removeButtonEngLocator = "//a[@class='action actionLink'][@aria-label='Remove']";
    private final String removeButtonRusLocator = "//a[@class='action actionLink'][@aria-label='Удалить']";

    @FindBy(xpath= "//i[@id='gh-cart-i']")
    private WebElement buttonCartNavigation;

    @FindBy(xpath= removeButtonEngLocator)
    private WebElement buttonCartRemoveEng;

    @FindBy(xpath= removeButtonRusLocator)
    private WebElement buttonCartRemoveRu;

    @FindAll({@FindBy(xpath= removeButtonEngLocator),@FindBy(xpath= removeButtonRusLocator) })
    private List<WebElement> buttonCartRemove;

    @FindBy(xpath= "//div[contains(@id,'sellerBucket_')]")
    private List<WebElement> allProductsInCart;

    @FindBys({@FindBy(id = "gh-ug"), @FindBy(xpath= "//a[@class = 'gh-ua gh-control'][@role='button']")})
    private WebElement buttonAccountControl;

    @FindBy(xpath= "//li[@id='gh-uo']/a[contains(@href,'signin.ebay.com')]")
    private WebElement linkAccountSignOut;


    public CartPage(WebDriver driver){
        super(driver);//this.driver = driver;
        PageFactory.initElements(getDriver(), this);
    }

    public int getProductCount(){
        return allProductsInCart.size();
    }

    public CartPage navigateToCart(){
        buttonCartNavigation.click();
        return new CartPage(getDriver());
    }

    public void removeProductFromCart(){
        if (getProductCount()>0)
        buttonCartRemove.iterator().next().click();
    }

    public CartPage selectAccountControl(){
        buttonAccountControl.click();
        return new CartPage(getDriver());
    }

    public StartPage signOutFromEBay(){
        linkAccountSignOut.click();
        return new StartPage(getDriver());
    }

    public boolean isPageOpened(){
        return checkisPageOpenedbyURL(partialURL);
    }
}
