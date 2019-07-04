package com.testattenti.conversions.tests;

import com.testattenti.conversions.model.TestData;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Iterator;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ConvertOuncesToGramsTest extends TestBase {

    @DataProvider
    public Iterator<Object[]> ouncesData() throws IOException {
        return app.convert().getDataFromFile("src/test/resources/ouncesData.csv");
    }

    @Test(dataProvider = "ouncesData")
    public void testConvertOuncesToGrams(TestData testData) throws InterruptedException {
        String value = String.valueOf(testData.getValue());
        app.goTo().page(By.linkText("Weight"));
        app.goTo().page(By.linkText("Ounces to Grams"));

        app.convert().enterValue(value);
        int answer = app.convert().parsAnswer();

        app.goTo().homePage();

        assertThat(answer, equalTo((int) (testData.getValue() / 0.035274)));
    }
}
