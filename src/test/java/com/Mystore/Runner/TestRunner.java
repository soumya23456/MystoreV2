package com.Mystore.Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		plugin= {
				"html:target/cucumberReports/cucumberHTMLReport.html",
				"json:target/cucumberReports/cucumberJSONReport.json",
				"junit:target/cucumberReports/cucumberXMLReport.xml",
				"pretty"
				}, 
		glue = {"com/Mystore/stepDefinitions", 
				"com/Mystore/Hooks", 
				"com/Mystore/pageobjects", 
				"com/Mystore/utilities"}, 
		features = "src/test/resources/Feature",
		tags = "@buypage",
		dryRun = true
		)

public class TestRunner extends AbstractTestNGCucumberTests{

}
