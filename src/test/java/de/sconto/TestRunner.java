package de.sconto;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
        glue="de/sconto/stepDefinitions",
        tags = "@invalidEmail",
        plugin = {"pretty","json:build/cucumber-report/cucumber.json"})
public class TestRunner {
}

