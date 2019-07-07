package com.testattenti.conversions.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    private String browser;
    protected WebDriver driver;
    private static final String SITE_URI = "https://www.metric-conversions.org";

    private NavigationHelper navigationHelper;
    private ConvertHelper convertHelper;

    public void start() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage (). window (). maximize ();
        navigationHelper = new NavigationHelper(driver);
        navigationHelper.site(SITE_URI);
        convertHelper = new ConvertHelper(driver);
    }

    public void stop() {
        driver.quit();
    }

    public NavigationHelper goTo() {
        return navigationHelper;
    }

    public ConvertHelper convert() {
        return convertHelper;
    }
}
