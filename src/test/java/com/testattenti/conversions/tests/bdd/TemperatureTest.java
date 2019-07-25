package com.testattenti.conversions.tests.bdd;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "classpath:bdd",plugin = {"pretty","html:build/cucumber-report"})
public class TemperatureTest extends AbstractTestNGCucumberTests {
}
