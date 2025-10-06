package com.dits.citywide.basetest;

import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import com.dits.citywide.driverfactory.DriverFactoryApp;

import io.appium.java_client.AppiumDriver;

/**
 * Base class for mobile (Android/iOS) tests. Initializes and quits the Appium
 * driver around each test method.
 */
public class BaseMobileTest {

	public DriverFactoryApp driverFactory;
	public AppiumDriver driver;
	public Properties prop;
	public SoftAssert softAssert;

	@BeforeMethod(alwaysRun = true)
	public void setUp() {
		driverFactory = new DriverFactoryApp();
		prop = driverFactory.init_properties();
		driver = driverFactory.init_driver(prop);
		softAssert = new SoftAssert();
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		if (driverFactory != null) {
			driverFactory.cleanupDriver();
		}
	}
}