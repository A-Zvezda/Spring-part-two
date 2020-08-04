package com.geekbrains.geekmarketwinter.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage extends BaseActions {
    private static final By REGISTRATION_SUBMIT_BTN = By.cssSelector("#submitAccount");

    private static final By FIELD_FIRST_NAME = By.cssSelector("#customer_firstname");
    private static final By FIELD_LAST_NAME = By.cssSelector("#customer_lastname");
    private static final By FIELD_EMAIL = By.cssSelector("#email");
    private static final By FIELD_PASSWORD = By.cssSelector("#passwd");

    public RegistrationPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void submitRegistration() {
        driver.findElement(REGISTRATION_SUBMIT_BTN).click();
    }

    public void typePersonalInfo(String firstName, String lastName, String email, String password) {
        typeInField(FIELD_FIRST_NAME, firstName);
        typeInField(FIELD_LAST_NAME, lastName);
        typeInField(FIELD_EMAIL, email);
        typeInField(FIELD_PASSWORD, password);
    }
}
