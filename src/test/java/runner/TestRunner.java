package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "./features",
         glue = "stepdefinitions"
        // plugin = {"pretty", "html:target/cucumber-reports.html"},
        // monochrome = true
)

public class TestRunner {

}
