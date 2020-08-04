package com.flamexander.automation.practice.tests;


import com.geekbrains.geekmarketwinter.pom.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class MarketTest {
    WebDriver driver;
    WebDriverWait wait;

    HomePage homePage;

    @BeforeMethod
    public void setUp() {
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.wait = new WebDriverWait(driver, 5);
        this.homePage = new HomePage(driver, wait);
    }

    @AfterMethod
    public void shutdown() {
        driver.quit();
    }
}
