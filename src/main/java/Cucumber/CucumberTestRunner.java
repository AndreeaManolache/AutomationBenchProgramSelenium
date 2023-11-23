package Cucumber;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        glue = {"Cucumber.stepDefinitions"},
        features = {"src/test/java/Cucumber/features"})
public class CucumberTestRunner {
}
