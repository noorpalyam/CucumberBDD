package com.securends.managers;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;

public final class DriverFactory {

	private static ThreadLocal<WebDriver> drivers = new ThreadLocal<WebDriver>();

	private static List<WebDriver> storedDrivers = new ArrayList<WebDriver>();

	private DriverFactory() {

	}

	public static WebDriver getDriver() {
		return drivers.get();
	}

	public static void addDriver(WebDriver driver) {
		storedDrivers.add(driver);
		drivers.set(driver);
	}

	public static void removeDriver() {
		storedDrivers.remove(drivers.get());
		drivers.remove();
	}
}
