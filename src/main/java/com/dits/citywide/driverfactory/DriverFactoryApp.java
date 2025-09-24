package com.dits.citywide.driverfactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class DriverFactoryApp {

	AppiumDriver driver;
	Properties prop;
	
	String filePath = "./src/test/resource/config/config.properties";
	String apkpath = "/Users/ditsdev/Desktop/app-staging-release.apk";
	String serverurl = "http://127.0.0.1:4723";
	String devicename = "Pixel 8";

	public AppiumDriver init_driver(Properties prop) {
		String deviceType = "android";

		try {
			if (deviceType.equalsIgnoreCase("android")) {
				return setupAndroidDriver(prop);
			} else {
				throw new IllegalArgumentException("Unsupported or missing device type: " + deviceType);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new IllegalStateException("Driver initialization failed: " + e.getMessage(), e);
		}
	}

	private AppiumDriver setupAndroidDriver(Properties prop) {
		try {
			UiAutomator2Options options = new UiAutomator2Options()
					.setDeviceName(devicename)
					.setApp(apkpath);
			options.setCapability("autoGrantPermissions", true);
			options.setNewCommandTimeout(Duration.ofSeconds(300));
			options.setAppWaitDuration(Duration.ofSeconds(30));

			if (options.getDeviceName() == null || options.getDeviceName().isEmpty()) {
				throw new IllegalArgumentException("'devicename' is missing or empty (check devicename field).");
			}
			if (options.getApp() == null || options.getApp().isEmpty()) {
				throw new IllegalArgumentException("'apkpath' is missing or empty (check apkpath field).");
			}

			driver = new AndroidDriver(new URL(serverurl), options);
			System.out.println("AndroidDriver initialized successfully.");
			return driver;
		} catch (MalformedURLException e) {
			throw new IllegalStateException("Invalid server URL.", e);
		} catch (Exception e) {
			throw new IllegalStateException("Failed to initialize AndroidDriver.", e);
		}
	}

	public Properties init_properties() {
		prop = new Properties();
		try (FileInputStream fis = new FileInputStream(filePath)) {
			prop.load(fis);
			return prop;
		} catch (FileNotFoundException e) {
			throw new IllegalStateException("Configuration file not found at path: " + filePath, e);
		} catch (IOException e) {
			throw new IllegalStateException("Error occurred while loading properties.", e);
		}
	}

	public AppiumDriver getDriver() {
		return driver;
	}

	public void cleanupDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
			System.out.println("Driver cleaned up.");
		}
	}
}