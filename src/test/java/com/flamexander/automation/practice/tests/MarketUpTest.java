package com.flamexander.automation.practice.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MarketUpTest extends MarketTest {
    @Test
    public void checkHomePage() {
        homePage.home();
        homePage.goToShopPage();
        homePage.goToAuthPage();
        homePage.goToCartPage();
//        homePage.goToProfilePage();
//        authPage.fillSignInFormAndConfirm(email, password);
//        Assert.assertTrue(authPage.isAlertPresent());
//        Assert.assertEquals(result, authPage.getAlertContainerText());
    }
}
