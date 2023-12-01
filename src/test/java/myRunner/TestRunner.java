package myRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(plugin = {"pretty","html:target/CucumberReport/cucumberReport.html","rerun:target/failedTests/failed.text"},
                  features="src/test/resources/loginFeatures",
//                  tags="@Signup",
                  publish=true,
                  glue={"login_stepDefinition","hooks"})
public class TestRunner extends AbstractTestNGCucumberTests{

}
 