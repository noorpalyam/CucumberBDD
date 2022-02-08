package com.securends.Stepdefinition;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.securends.dataproviders.ConfigFileReader;
import com.securends.managers.Base;
import com.securends.managers.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class LoginSteps extends Base { 
	//WebDriver driver;

	@Given("^I open Securends Application \"(.*)\"$")
	public void navigate(String url){
		//System.setProperty("webdriver.chrome.driver","D:\\Drivers\\chromedriver_win32\\chromedriver.exe");  
		//driver=new ChromeDriver();
		
		System.out.println("Url:"+ConfigFileReader.getProperty(url));
		DriverFactory.getDriver().get(ConfigFileReader.getProperty(url));         
	       }

	@When("^I Login as admin \"(.*)\",\"(.*)\"$")
	public void login(String username,String password) throws InterruptedException{
		
		//Delay execution for 5 seconds to view the maximize operation
		Thread.sleep(5000);
		driver.manage().window().maximize();
		// saveScreenShot(DriverFactory.getDriver());
		driver.findElement(By.xpath("//*[@id='loginemail']")).sendKeys(ConfigFileReader.getProperty(username));
		driver.findElement(By.xpath("//*[@id='loginpassword']")).sendKeys(ConfigFileReader.getProperty(password));
		// saveScreenShot(DriverFactory.getDriver());
		driver.findElement(By.xpath("//*[@id='Login_submitt']")).click();
		Thread.sleep(5000);
		
	       }

	@When("I Logout of the Application")
	public void i_Logout_of_the_Application() throws InterruptedException {
		
		Thread.sleep(3000);
		// saveScreenShot(DriverFactory.getDriver());
		driver.findElement(By.xpath("//*[@id='react']/div/span/div/div[2]/div[2]/div[1]/header/div/div[3]/div/div/div[1]/button/span[1]/div[2]/span[2]/i")).click();
		// saveScreenShot(DriverFactory.getDriver());
		driver.findElement(By.xpath("//*[@id='menu-list-grow']/ul/li[1]")).click();
		Thread.sleep(3000);
		// saveScreenShot(DriverFactory.getDriver());
		//Close the browser
		driver.quit();

	}
}
