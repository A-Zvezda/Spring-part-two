package com.flamexander.automation.practice.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;

public class SeleniumTest {
    WebDriver driver;

    @BeforeSuite
    public void init() {
        driver = new ChromeDriver();
    }

    @Test
    public void simpleTest() {
       // driver.get("http://yandex.ru");
        driver.get("http://127.0.0.1:8080/");
//        WebElement webElement = driver.findElement(By.cssSelector(".input__control.input__input"));
//        webElement.click();
//        webElement.clear();
//        webElement.sendKeys("Java");
//        webElement.submit();
//
//        List<WebElement> webElementList = driver
//                .findElement(By.cssSelector(".content__left"))
//                .findElements(By.cssSelector(".serp-item"));
//
//        Assert.assertEquals(webElementList.size(), 11);



//        driver.get("http://automationpractice.com/index.php");
//        WebElement btnLogin = driver.findElement(By.cssSelector(".login"));
//        btnLogin.click();
//        Assert.assertEquals(driver.findElement(By.cssSelector(".page-heading")).getText().toLowerCase(), "Authentication".toLowerCase());
    }

    @AfterSuite
    public void shutdown() {
        driver.quit();
    }
}
