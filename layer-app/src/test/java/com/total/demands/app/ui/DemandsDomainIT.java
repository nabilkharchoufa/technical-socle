package com.total.demands.app.ui;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:fr/sauceDallas/getThingsDone/app/ui",
        plugin = "pretty",
        glue = "com.total.resourceRequest.app.ui")
public class DemandsDomainIT {
}
