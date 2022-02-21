package com.securends.managers;

import java.net.MalformedURLException;
import java.net.UnknownHostException;

import org.apache.log4j.Logger;

public class DriverManager {

	public Logger log = Logger.getLogger(this.getClass());
	public DriverManager() throws MalformedURLException, UnknownHostException {

		System.out.println("start of DriverManager method in DriverManager class");
		
		if (DriverFactory.getDriver() == null) {
			BrowserFactory browserFactory=new BrowserFactory();
			log.info("middile of DriverManager method in DriverManager class");
			browserFactory.getBrowser();
		}

	}


}

