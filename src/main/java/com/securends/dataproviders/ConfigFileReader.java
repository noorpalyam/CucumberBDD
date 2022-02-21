package com.securends.dataproviders;

import java.io.*;
import java.util.Properties;

public class ConfigFileReader {

	private static Properties properties;

	/*public static String localClient = System.getProperty("localClient");
	public static String localApplication = System.getProperty("localApplication");
	public static String localEnvironment = System.getProperty("localEnvironment");*/

	private static String filePath = "";
	private static String applicationName = "";

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

	/*public static void writeToPropertyFile(String key, String value) {

		BufferedReader reader;
		try {

			filePath = getFilePath(localEnvironment, localClient);
			reader = new BufferedReader(new FileReader(filePath));
			properties = new Properties();
			properties.load(reader);
			reader.close();

			BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
			properties.setProperty(key, value);
			properties.store(writer, null);
			writer.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at ");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
*/
	/**
	 * Method to resolve application name from property file based on local/jenkins
	 * input.
	 * 
	 * @return Resolved application name in form of string.
	 */
	/*public static String getApplicationName() {
		try {
			applicationName = localApplication;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return applicationName;
	}*/

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

	/**
	 * Place your file.properties file anywhere in the user directory Pass the
	 * Content Root Path in the filePath argument
	 * 
	 * @param filePath,
	 *            key
	 */
	/*public static String getValueFromAnyPropertyFile(String filePath, String key) {
		BufferedReader reader;
		Properties myProperty = null;
		try {
			reader = new BufferedReader(new FileReader(System.getProperty("user.dir") + filePath));
			myProperty = new Properties();
			myProperty.load(reader);
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("File not found at specified path : " + filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return myProperty.getProperty(key);
	}*/
}