package com.epam.webdriver.task2.tests;

import com.epam.webdriver.task2.pages.HomePage;
import com.epam.webdriver.task2.pages.LoginPage;
import com.epam.webdriver.task2.pages.ProductListPage;
import com.epam.webdriver.task2.pages.StartPage;
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
        Assert.assertTrue(startPage.getPageTitle().contains("eBay"), "eBay page is not opened");

        LoginPage loginPage = startPage.singIn();
        Assert.assertTrue(loginPage.getDriver().getCurrentUrl().contains("signin.ebay"), "Sighin eBay page is not opened");

        HomePage homePage = loginPage.login(USERNAME, PASSWORD);
        Assert.assertTrue(homePage.getDriver().findElement(By.xpath("//a[@id='gh-ug']/b")).getText().contains("Siarhei")
                , "User is not logined on eBay");
        Assert.assertTrue(homePage.getPageTitle().contains("eBay"), "User is not logined on eBay");

        ProductListPage productListPage = homePage.productSearch("knives");

    }

    @AfterMethod(description = "WebDriver clean up")
    public void cleanUp(){
        driver.quit();
    }

}
