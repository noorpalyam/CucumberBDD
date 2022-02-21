package com.securends.Stepdefinition;

import java.net.MalformedURLException;
import java.net.UnknownHostException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import com.securends.dataproviders.ConfigFileReader;
import com.securends.managers.Base;
import com.securends.managers.DriverManager;
import com.securends.panels.Login;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class LoginSteps extends Base {

	private Login login;
	public Logger log = Logger.getLogger(this.getClass());

	public LoginSteps(DriverManager manager, Login login) {

		this.login = login;
	}

	@Given("^I open Securends Application \"(.*)\"$")
	public void navigate(String url) throws MalformedURLException, UnknownHostException {

		log.info("Url:" + ConfigFileReader.getProperty(url));
		login.LaunchUrL(ConfigFileReader.getProperty(url));
	}

	@When("^I Login as admin \"(.*)\",\"(.*)\"$")
	public void login(String username, String password) throws InterruptedException {

		// Delay execution for 5 seconds to view the maximize operation
		Thread.sleep(5000);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id='loginemail']")).sendKeys(ConfigFileReader.getProperty(username));
		driver.findElement(By.xpath("//*[@id='loginpassword']")).sendKeys(ConfigFileReader.getProperty(password));
		driver.findElement(By.xpath("//*[@id='Login_submitt']")).click();
		Thread.sleep(5000);

	}

	@When("I Logout of the Application")
	public void logout() throws InterruptedException {

		Thread.sleep(3000);
		/*driver.findElement(By.xpath(
				"//*[@id='react']/div/span/div/div[2]/div[2]/div[1]/header/div/div[3]/div/div/div[1]/button/span[1]/div[2]/span[2]/i"))
		.click();*/
		driver.findElement(By.xpath(
				"//span[@class='loggedUser']/i[@class='fa fa-user-circle-o']"))
				.click();
		driver.findElement(By.xpath("//*[@id='menu-list-grow']/ul/li[1]")).click();
		Thread.sleep(3000);
		// Close the browser
		driver.quit();

	}
}
