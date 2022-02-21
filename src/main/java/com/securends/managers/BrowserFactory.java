package com.securends.managers;

import com.securends.dataproviders.ConfigFileReader;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.net.MalformedURLException;
import java.net.UnknownHostException;


public class BrowserFactory {

	public WebDriver driver;
	public Logger log = Logger.getLogger(this.getClass());
	public String chromedriverpath = "";
	public String firefoxdriverpath = "";
	public String edgedriverpath = "";
	/*public String host = System.getProperty("host");*/
	public String environment = System.getProperty("environment");
	/*public String browser = System.getProperty("Browser") != null ? System.getProperty("Browser")
			: System.getProperty("localbrowser");*/
	public final String HOME = System.getProperty("user.dir");
	
	public WebDriver getBrowser() throws MalformedURLException, UnknownHostException {
		log.info("browser:"+System.getProperty("localbrowser"));
		if (System.getProperty("host").equalsIgnoreCase("local")) {

			if (System.getProperty("localbrowser").equalsIgnoreCase("chrome")) {
				chromedriverpath = ConfigFileReader.getProperty("chromedriverpathWindows");
				System.setProperty("webdriver.chrome.driver", HOME + chromedriverpath);
				ChromeOptions chrome_options = new ChromeOptions();
				chrome_options.addArguments("excludeSwitches", "disable-popup-blocking");
				chrome_options.addArguments("--start-maximized");
				driver = new ChromeDriver(chrome_options);
				log.info("Chrome:");

			}
			if (System.getProperty("localbrowser").equalsIgnoreCase("firefox")) {

				firefoxdriverpath = ConfigFileReader.getProperty("firefoxdriverpathWindows");
				System.setProperty("webdriver.gecko.driver", HOME + firefoxdriverpath);
				FirefoxOptions options = new FirefoxOptions();
				options.addPreference("browser.download.folderList", 2);
				options.addPreference("browser.helperApps.neverAsk.saveToDisk",
						"multipart/x-zip,application/zip,application/x-zip-compressed,application/x-compressed,application/msword,application/csv,text/csv,image/png ,image/jpeg, application/pdf, text/html,text/plain,  application/excel, application/vnd.ms-excel, application/x-excel, application/x-msexcel, application/octet-stream,application/msexcel,application/json");
				driver = new FirefoxDriver(options);
				log.info("firefox:");

			}
			if (System.getProperty("localbrowser").equalsIgnoreCase("edge")) {
				edgedriverpath = ConfigFileReader.getProperty("edgedriverpathWindows");
				System.setProperty("webdriver.edge.driver", HOME + edgedriverpath);
				driver = new EdgeDriver();
				log.info("edge:");

			}

		}

		driver.manage().window().maximize();
		DriverFactory.addDriver(driver);
		return driver;
	}
}