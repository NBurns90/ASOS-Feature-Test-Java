package com.SpartaGlobal.TestRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.*;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "Features",
        glue = {"com.SpartaGlobal.Tests"}
)

public class CucumberRunner {



}