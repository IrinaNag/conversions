package com.testattenti.conversions.model;

public class TestData {
    int value;

    public TestData(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "TestData{" +
                "value=" + value +
                '}';
    }
}