package com.securends.Testrunner;

import org.apache.log4j.BasicConfigurator;
import org.junit.runner.RunWith;
import org.testng.annotations.*;

import com.securends.dataproviders.ConfigFileReader;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(
	features = "/SecurendsBDD/securends-cucumber-automation/src/test/resources/Features",
	glue= {"com.securends.Stepdefinition"},
			plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
	monochrome=true
)
public class TestRunner  extends AbstractTestNGCucumberTests {
	
	@Override
	@DataProvider(parallel=true)
	public Object[][] scenarios() {

		return super.scenarios();
	}
	
	@BeforeMethod
	@Parameters({"browser","host"})
	public void testParam(@Optional String browser, @Optional String host)
	{
		//driverManager.initialize(browser,host);
		System.setProperty("localbrowser",browser);
		System.setProperty("host",host);
	}

	@BeforeSuite
	@Parameters({"environment","client"})
	public void beforeSuite(String environment,String client)
	{
		BasicConfigurator.configure();
		System.setProperty("localEnvironment",environment);
		System.setProperty("localClient",client);
		//System.setProperty("localApplication", application);
		ConfigFileReader.readPropertyFile(environment,client);
	}

}