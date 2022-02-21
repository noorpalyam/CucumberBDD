package com.securends.Testrunner;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.testng.annotations.*;

import com.securends.dataproviders.ConfigFileReader;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	features = "/SecurendsBDD/securends-cucumber-automation/src/test/resources/Features",
	glue= {"com.securends.Stepdefinition"},
			plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
					tags = {"@sanityTest"},
	monochrome=true
)

public class TestRunner  extends AbstractTestNGCucumberTests {
	
	public Logger log = Logger.getLogger(this.getClass());
	
	@Override
	@DataProvider(parallel=true)
	public Object[][] scenarios() {

		return super.scenarios();
	}
	
	//@BeforeMethod
	@BeforeTest
	@Parameters({"browser","host"})
	public void testParam(@Optional String browser, @Optional String host)
	{
		log.info("browser:"+browser);
		log.info("host:"+host);
		System.setProperty("localbrowser",browser);
		System.setProperty("host",host);
		log.info("End of test param method in Test Runner class");
	}
	

	//@BeforeSuite
	@BeforeTest
	@Parameters({"environment","client"})
	public void beforeSuite(String environment,String client)
	{
		BasicConfigurator.configure();
		System.setProperty("localEnvironment",environment);
		System.setProperty("localClient",client);
		ConfigFileReader.readPropertyFile(environment,client);
		log.info("End of before suite method in Test Runner class");
	}

}