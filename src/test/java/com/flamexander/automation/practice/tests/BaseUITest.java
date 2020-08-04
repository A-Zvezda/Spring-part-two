package com.flamexander.automation.practice.tests;

import com.geekbrains.geekmarketwinter.pom.AuthPage;
import com.geekbrains.geekmarketwinter.pom.HomePage;
import com.geekbrains.geekmarketwinter.pom.RegistrationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;



import java.util.concurrent.TimeUnit;

public class BaseUITest {
    WebDriver driver;
    WebDriverWait wait;

    HomePage homePage;
    AuthPage authPage;
    RegistrationPage registrationPage;

    @BeforeMethod
    public void setUp() {
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.wait = new WebDriverWait(driver, 5);
        this.homePage = new HomePage(driver, wait);
        this.authPage = new AuthPage(driver, wait);
        this.registrationPage = new RegistrationPage(driver, wait);
    }

    @AfterMethod
    public void shutdown() {
        driver.quit();
    }
}
