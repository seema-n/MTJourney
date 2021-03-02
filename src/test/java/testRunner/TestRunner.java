package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

import testCommon.TestBase;


@RunWith(Cucumber.class)
@CucumberOptions(
		features= "./src/test/java/features",
		glue= {"stepDefination"},
		plugin= {"pretty", "html:target/cucumber-reports"},
		monochrome= true,
		dryRun = false)

public class TestRunner extends TestBase {


}
