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
		System.out.println("drivers.get():"+drivers.get());
		System.out.println("start of getDriver method in DriverFactory class");
		return drivers.get();
	}

	public static void addDriver(WebDriver driver) {
		storedDrivers.add(driver);
		System.out.println("drivers.set(driver):"+driver);
		System.out.println("start of addDriver method in DriverFactory class");
		drivers.set(driver);
	}

	public static void removeDriver() {
		storedDrivers.remove(drivers.get());
		System.out.println("start of remove Driver method in DriverFactory class");
		drivers.remove();
	}
}
