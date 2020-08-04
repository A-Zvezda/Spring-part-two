package com.geekbrains.geekmarketwinter.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage extends BaseActions {
    private static final String HOME_PAGE_URL = "http://localhost:8181/";

    private static final By SIGN_IN_MENU = By.cssSelector("a.login");
    private static final By MENU = By.cssSelector(".navbar-nav");
    private static final By MENU_ITEM = By.cssSelector("a.nav-link");

    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void home() {
        driver.get(HOME_PAGE_URL);
    }

    public void goToAuthPage() {
        //driver.findElement(SIGN_IN_MENU).click();
        List<WebElement> elements = driver.findElements(MENU_ITEM);
        System.out.println(elements);

        for (WebElement o : elements ) {
            if (o.getText().equalsIgnoreCase("btn btn-secondary btn-sm")){
                o.click();
            }
        }
    }

    public void goToShopPage() {
       // WebElement web =  driver.findElement(NAV_ITEM);

        List<WebElement> elements = driver.findElements(MENU_ITEM);
        System.out.println(elements);

        for (WebElement o : elements ) {
            if (o.getText().equalsIgnoreCase("Каталог товаров\n(current)")){
                o.click();
            }
        }
    }

    public void goToCartPage() {
        // WebElement web =  driver.findElement(NAV_ITEM);

        List<WebElement> elements = driver.findElements(MENU_ITEM);
        System.out.println(elements);

        for (WebElement o : elements ) {
            if (o.getText().equalsIgnoreCase("Корзина\n(current)")){
                o.click();
            }
        }

    }

    public void goToProfilePage() {
        // WebElement web =  driver.findElement(NAV_ITEM);

        List<WebElement> elements = driver.findElements(MENU_ITEM);
        System.out.println(elements);


        for (WebElement o : elements ) {
            if (o.getText().equalsIgnoreCase("Профиль\n(current)")){
                o.click();
            }
        }

    }


}
