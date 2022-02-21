package com.securends.panels;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;

import com.securends.managers.Base;
import com.securends.managers.DriverFactory;

public class Login extends Base{

	public Login(){

		PageFactory.initElements(DriverFactory.getDriver(), this);
		System.out.println(DriverFactory.getDriver() + "--- this is the driver instance in Login");
		
	}
	
	public void LaunchUrL (String url)
	{
		try {
			launchApplication(url);
			DriverFactory.getDriver().navigate().refresh();
			DriverFactory.getDriver().manage().window().maximize();

		} catch (WebDriverException e) {
			org.testng.Assert.assertFalse(true, "Unable to get the instance of the Webdriver");
		} catch (Exception e) {
			org.testng.Assert.assertFalse(true, "Unable to access webdriver");
		}
	}
}