package com.testattenti.conversions.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(WebDriver driver) {
        super(driver);
    }


    public void site(String url) {
        driver.get(url);
    }

    public void page(By locator) {
        new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(locator));
        click(locator);
    }

    public void homePage() {
        click(By.cssSelector(".home"));
    }
}