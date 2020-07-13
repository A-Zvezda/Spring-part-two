package com.flamexander.automation.practice.tests;

import org.testng.annotations.Test;

public class RegistrationTest extends BaseUITest {
    @Test
    public void tryToRegister() {
        homePage.home();
        homePage.goToAuthPage();
        registrationPage.typePersonalInfo("name", "name", "name@gmail.com", "at443nn");
        // ...
        registrationPage.submitRegistration();


    }
}
