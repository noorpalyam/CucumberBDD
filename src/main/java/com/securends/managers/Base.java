package com.securends.managers;

import org.openqa.selenium.WebDriver;
import java.net.UnknownHostException;
import org.apache.log4j.Logger;

public class Base {

    public Logger log = Logger.getLogger(this.getClass());

    public WebDriver driver;

    public Base()  {

        driver = DriverFactory.getDriver();
        System.out.println("start of Base method in Base class");
    }
    
    /**
     *  launchs application url
     *
     * @Param url
     */
    public void launchApplication(String url) throws UnknownHostException {

        log.info("Opening the application URL :" + url);
        driver.get(url);
    }

}


