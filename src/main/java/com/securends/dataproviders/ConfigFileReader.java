package com.securends.dataproviders;

import java.io.*;
import java.util.Properties;

public class ConfigFileReader {

	private static Properties properties;

	private static String filePath = "";

	public static void readPropertyFile(String environment, String client) {

		BufferedReader reader;
		try {
			filePath = getFilePath(environment, client);
			reader = new BufferedReader(new FileReader(filePath));
			properties = new Properties();
			properties.load(reader);
			reader.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at ");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getFilePath(String environment, String client) {
		
		System.out.println("System.getProperty(\"user.dir\"):"+System.getProperty("user.dir"));
		System.out.println("environment:"+environment);
		System.out.println("client:"+client);

		String propertyFilePathWindows = System.getProperty("user.dir") + "\\Config\\" + environment + "\\" + client
				+ "config.properties";
		System.out.println("propertyFilePathWindows:"+propertyFilePathWindows);
		return propertyFilePathWindows;

	}

	/**
	 * Returns the property based on input String
	 * 
	 * @param key
	 *
	 */

	public static String getProperty(String key) {

		try {
			key = properties.getProperty(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return key;
	}

}