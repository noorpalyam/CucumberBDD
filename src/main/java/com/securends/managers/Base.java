package com.securends.managers;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import io.qameta.allure.Attachment;

import org.apache.log4j.Logger;

public class Base {


    public Logger log = Logger.getLogger(this.getClass());

    public WebDriver driver;

    public Base()  {

        driver = DriverFactory.getDriver();
    }


    /**
     *  Takes screenshot
     *
     * @Param driver
     */
    @Attachment
    public  byte[] saveScreenShot(WebDriver driver)
    {
        log.info("Taking the screenshot of the current screen :");
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }

}


