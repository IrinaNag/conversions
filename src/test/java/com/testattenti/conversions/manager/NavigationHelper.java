package com.testattenti.conversions.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(WebDriver driver) {
        super(driver);
    }


    public void site(String url) {
        driver.get(url);
    }

    public void page(By locator) throws InterruptedException {
        click(locator);
    }

    public void homePage() {
        click(By.cssSelector(".home"));
    }
}