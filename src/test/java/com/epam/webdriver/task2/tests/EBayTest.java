package com.epam.webdriver.task2.tests;

import com.epam.webdriver.task2.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Siarhei_Chyhir on 1/4/2016.
 */
public class EBayTest {

    public static final String  USERNAME = "siarhei_chyhir@epam.com";
    public static final String PASSWORD = "Sergh13";

    private WebDriver driver;

    @BeforeMethod(description = "WebDriver init")
    public void prepare(){
        driver = new FirefoxDriver();
        driver.get(StartPage.URL);
    }


    @Test(description = "eBay smoke test")
    public void eBaySmokeTest(){
        StartPage startPage = new StartPage(driver);
        Assert.assertTrue(startPage.getPageTitle().contains("Electronics, Cars, Fashion, Collectibles, Coupons and More | eBay")
                , "eBay page is not opened");

        LoginPage loginPage = startPage.singIn();
        Assert.assertTrue(loginPage.getCurrentURL().contains("signin.ebay"), "Sighin eBay page is not opened");

        HomePage homePage = loginPage.login(USERNAME, PASSWORD);
        Assert.assertTrue(homePage.getPageTitle().contains("Electronics, Cars, Fashion, Collectibles, Coupons and More | eBay")
                , "eBay page is not opened");
        Assert.assertTrue(homePage.getCurrentURL().contains("ebay.com"), "eBay home page is not opened");
        Assert.assertTrue(homePage.getAccountName().contains("Siarhei"), "User did not login on eBay");

        ProductListPage productListPage = homePage.productSearch("knives");
        Assert.assertTrue(productListPage.getPageTitle().contains("knives")
                , "Search Result List with knives does not present on eBay");
        Assert.assertTrue(productListPage.searchProductsCount() > 0
                , "No products in Search Result List on eBay");

        ProductPage productPage = productListPage.selectProductFromList();
        Assert.assertTrue(productPage.getPageTitle().toUpperCase().contains("TAC FORCE ")
                , "The product page is not opened");

        CartPage cartPage = productPage.addProductToCart();
        Assert.assertTrue(cartPage.getCurrentURL().contains("cart.payments.ebay.com")
                , "The shopping cart page is not opened");


        cartPage.removeProductFromCart();
        cartPage.selectAccountControl();

        startPage = cartPage.signOutFromEBay();
        System.out.println(startPage.getPageTitle());
        Assert.assertTrue(startPage.getCurrentURL().contains("signin.ebay"), "Sighin eBay page is not opened");


    }

    @AfterMethod(description = "WebDriver clean up")
    public void cleanUp(){
        driver.quit();
    }

}
