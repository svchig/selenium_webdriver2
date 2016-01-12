package com.epam.webdriver.task2.tests;

import com.epam.webdriver.task2.pages.*;
import org.openqa.selenium.By;
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

/*!!!Need to do after language selector will be fixed*/
//    String locale = "English";

//    @Factory(dataProvider = "locales")
//    public EBayTest(String locale){
//        this.locale=locale;
//    }
//
//    @DataProvider(name = "locales", parallel = true)
//    public Object[][] locales() {
//        return new Object[][]{
//                { "English" }, { "Русский" }
//        };
//    }

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
//        startPage.setLanguageSetting(locale);
        Assert.assertTrue(startPage.getPageTitle().contains("eBay"), "eBay page is not opened");

        LoginPage loginPage = startPage.singIn();
        Assert.assertTrue(loginPage.getDriver().getCurrentUrl().contains("signin.ebay"), "Sighin eBay page is not opened");

        HomePage homePage = loginPage.login(USERNAME, PASSWORD);
        Assert.assertTrue(homePage.getDriver().findElement(By.xpath("//a[@id='gh-ug']/b")).getText().contains("Siarhei")
                , "User is not logined on eBay");
        Assert.assertTrue(homePage.getPageTitle().contains("eBay"), "User is not logined on eBay");

        ProductListPage productListPage = homePage.productSearch("knives");
        Assert.assertTrue(productListPage.getDriver().findElements(By.id("ResultSetItems")).size() > 0
                , "Search Result List does not present on eBay");

        ProductPage productPage = productListPage.selectProductFromList();
        Assert.assertTrue(productPage.getDriver()
                .findElement(By.xpath("//h1[@id='itemTitle'][@itemprop='name']")).getText().contains("TAC FORCE BLACK ")
                , "The product page is not opened");

        CartPage cartPage = productPage.addProductToCart();
        Assert.assertTrue(cartPage.getDriver()
                .findElement(By.xpath("//h1[@class='mb15 nowrap']")).getText().contains("Your eBay Shopping Cart")
                , "The shopping cart  page is not opened");


        cartPage.removeProductfromCart();
        cartPage.selectAcountControl();
        cartPage.signOutFromEBay();
    }

    @AfterMethod(description = "WebDriver clean up")
    public void cleanUp(){
        driver.quit();
    }

}
