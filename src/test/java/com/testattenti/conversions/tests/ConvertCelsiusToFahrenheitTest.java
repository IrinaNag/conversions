package com.testattenti.conversions.tests;

import com.testattenti.conversions.model.TestData;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Iterator;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ConvertCelsiusToFahrenheitTest extends TestBase {

    @DataProvider
    public Iterator<Object[]> celsiusData() throws IOException {
        return app.convert().getDataFromFile("src/test/resources/celsiusData.csv");
    }

    @Test(dataProvider = "celsiusData")
    public void testConvertCelsiusToFahrenheit(TestData testData) throws InterruptedException {
        String value = String.valueOf(testData.getValue());
        app.goTo().page(By.linkText("Temperature"));
        app.goTo().page(By.linkText("Celsius to Fahrenheit"));

        app.convert().enterValue(value);
        int answer = app.convert().parsAnswer();

        app.goTo().homePage();

        assertThat(answer, equalTo((int) (testData.getValue() * 1.8 + 32)));
    }
}
