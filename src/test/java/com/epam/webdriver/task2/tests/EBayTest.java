package com.epam.webdriver.task2.tests;

import com.epam.webdriver.task2.pages.HomePage;
import com.epam.webdriver.task2.pages.LoginPage;
import com.epam.webdriver.task2.pages.StartPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

/**
 * Created by Siarhei_Chyhir on 1/4/2016.
 */
public class EBayTest {

    public static final String  USERNAME = "siarhei_chyhir@epam.com";
    public static final String PASSWORD = "Sergh13";


    @Test
    public void oneCanLogineBay(){
        WebDriver driver = new FirefoxDriver();
        StartPage startPage = new StartPage(driver);
        startPage.openPage();
        LoginPage loginPage = startPage.singIn();
        HomePage homePage = loginPage.login(USERNAME, PASSWORD);
        homePage.getPageTitle();
    }
}
