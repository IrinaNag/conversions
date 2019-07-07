package com.testattenti.conversions.manager;

import com.testattenti.conversions.model.TestData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Collectors;

public class ConvertHelper extends HelperBase {

    public ConvertHelper(WebDriver driver) {
        super(driver);
    }


    public void enterValue(String value) {
        new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#argumentConv")));
        type(By.cssSelector("#argumentConv"), value);
    }

    private String getAnswer() {
        new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#answer")));
        return getText(By.cssSelector("#answer"));
    }

    public int parsAnswer() {
        String answer = getAnswer();
        int index1 = answer.indexOf(' ') + 1;
        int index2 = 0;
        for (int i = index1 + 1; i < answer.length() - 1; i++) {
            if (answer.substring(i, i + 1).matches("\\D")) {
                index2 = i;
                break;
            }
        }
        return Integer.parseInt(answer.substring(index1, index2));
    }

    public Iterator<Object[]> getDataFromFile(String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            return reader.lines().flatMap(line -> Arrays.stream(line.split(";")))
                    .mapToInt(str -> Integer.parseInt(str))
                    .mapToObj(x -> new Object[]{new TestData(x)})
                    .collect(Collectors.toList()).iterator();
        }
    }
}
