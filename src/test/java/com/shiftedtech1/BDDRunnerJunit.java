package com.shiftedtech1;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //tags = { "@debug" },
        //tags = { "@smoke" },         /* smoke test only */
        tags = { "@smoke,@debug" }, /* debug or smoke test */
        //tags = { "@smoke","@debug" },  /* debug and smoke test */
        //monochrome = true,
        features = "src/test/resources/features/",
        //features = "src/test/resources/features/LoginFunctionality2.features",
        //features = {"src/test/resources/features/LoginFunctionality2.features",
        //            "src/test/resources/features/LoginFunctionality.features"},
        glue = {"com.shiftedtech1.steps"},
        //dryRun = true,
        plugin={
                "pretty:target/cucumber-test-report/cucumber-pretty.txt",
                "html:target/cucumber-test-report",
                "json:target/cucumber-test-report/cucumber-report.json",
                "junit:target/cucumber-test-report/test-report.xml"
        }
)
public class BDDRunnerJunit {
}
