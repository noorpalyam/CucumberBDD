package com.securends.managers;

import com.securends.dataproviders.ConfigFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

/*import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;*/

import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;


public class BrowserFactory {

    public WebDriver driver;
    public String chromedriverpath = "";
    public String firefoxdriverpath = "";
    public  String host = System.getProperty("host");
    public String environment=System.getProperty("environment");
    public String browser =  System.getProperty("Browser")!=null?System.getProperty("Browser"):System.getProperty("localbrowser");
    public final String HOME = System.getProperty("user.dir");

    public WebDriver getBrowser() throws MalformedURLException , UnknownHostException {

        if (host.equalsIgnoreCase("local")) {

            if (browser.equalsIgnoreCase("chrome")) {
               /* if (System.getProperty("os.name").contains("Mac")) {
                    chromedriverpath = ConfigFileReader.getProperty("chromedriverpathMac");
                } else {*/
                    chromedriverpath = ConfigFileReader.getProperty("chromedriverpathWindows");
               /* }*/
                System.setProperty("webdriver.chrome.driver", HOME + chromedriverpath);
              //  String filepath = "Z:\\\\TestCenterRepository\\AutomationTesting\\Vantage\\SalesDemoData\\BVT\\PreviewReportsDownload";
              //  String filepath1=filepath.replace("/","\\");
                Map<String, Object> chromePrefs = new HashMap<String, Object>();
               /* chromePrefs.put("profile.default_content_settings.popups", 0);
                chromePrefs.put("download.default_directory", filepath);
                chromePrefs.put("download.prompt_for_download", false);*/
                ChromeOptions chrome_options = new ChromeOptions();
               // chrome_options.setExperimentalOption("prefs", chromePrefs);
                /*DesiredCapabilities capabilities = DesiredCapabilities.htmlUnit().Chrome();
                capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
                capabilities.setCapability(ChromeOptions.CAPABILITY, chrome_options);*/
                chrome_options.addArguments("excludeSwitches", "disable-popup-blocking");
                driver = new ChromeDriver(chrome_options);
            }
                //chrome_options.addArguments("--headless");
                //chrome_options.addArguments("--no-sandbox");
                //chrome_options.addArguments("--remote-debugging-port=9222");
            if (browser.equalsIgnoreCase("firefox")) {

                if (System.getProperty("os.name").contains("Mac")) {
                    firefoxdriverpath = ConfigFileReader.getProperty("firefoxdriverpathMac");
                } else {
                    firefoxdriverpath = ConfigFileReader.getProperty("firefoxdriverpathWindows");
                }
                System.setProperty("webdriver.gecko.driver", HOME + firefoxdriverpath);
//                    String filepath = "Z:\\\\TestCenterRepository\\AutomationTesting\\Vantage\\SalesDemoData\\BVT\\PreviewReportsDownload";
//                    System.out.println(filepath);
                    FirefoxOptions options = new FirefoxOptions();
                    //FirefoxProfile profile = new FirefoxProfile();
                    options.addPreference("browser.download.folderList", 2);
//                    options.addPreference("browser.download.dir", filepath);
//                    options.addPreference("browser.download.defaultFolder", filepath);
                    options.addPreference("browser.helperApps.neverAsk.saveToDisk", "multipart/x-zip,application/zip,application/x-zip-compressed,application/x-compressed,application/msword,application/csv,text/csv,image/png ,image/jpeg, application/pdf, text/html,text/plain,  application/excel, application/vnd.ms-excel, application/x-excel, application/x-msexcel, application/octet-stream,application/msexcel,application/json");
                    //options.addPreference("browser.download.defaultFolder",filepath);
                    driver = new FirefoxDriver(options);

            }
           
        }

        driver.manage().window().maximize();
        DriverFactory.addDriver(driver);
        return driver;
    }
}