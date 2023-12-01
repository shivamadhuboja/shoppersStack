package myRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = {"pretty","html:target/CucumberReport/cucumberReport.html"},
                 features="@target/failedTests/failed.text",
                  publish=true,
                   glue={"login_stepDefinition","hooks"})
public class FailedTestRunner extends AbstractTestNGCucumberTests {

}
