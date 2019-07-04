package com.testattenti.conversions.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperBase {
    protected WebDriver driver;

    public HelperBase(WebDriver driver) {
        this.driver = driver;
    }

    protected void type(By locator, String text) {
        click(locator);
        clear(locator);
        sendKeys(locator, text);
    }

    protected void sendKeys(By locator, String text) {
        if (text != null) {
            driver.findElement(locator).sendKeys(text);
        }
    }

    protected void clear(By locator) {
        driver.findElement(locator).clear();
    }

    protected void click(By locator) {
        driver.findElement(locator).click();
    }

    protected String getText(By locator) {
        return driver.findElement(locator).getText();
    }

}