package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.TestNGCucumberRunner;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features",
        glue = "stepDefiition",
        dryRun = true,
        plugin = {"pretty","html:target/cucumber-reports/cucumber-pretty",
        "json:target/ucumber-reports/CucumberTestReport.json"}
)
public class TestRunner {

}
