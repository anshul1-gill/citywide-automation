package com.dits.citywide.driverfactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class DriverFactoryApp {

    private AppiumDriver driver;
    private Properties prop;

    // Correct resource path
    private final String filePath = "./src/test/resource/config/config.properties";

    // -------------------------
    // INITIALIZE PROPERTIES
    // -------------------------
    public Properties init_properties() {
        prop = new Properties();

        File file = new File(filePath);

        // Debug print
        System.out.println("Trying to load config from: " + file.getAbsolutePath());
        System.out.println("File exists? " + file.exists());

        try (FileInputStream fis = new FileInputStream(file)) {
            prop.load(fis);
            return prop;
        } catch (IOException e) {
            throw new RuntimeException("Unable to load config.properties at: " + file.getAbsolutePath());
        }
    }

    // -------------------------
    // INITIALIZE DRIVER
    // -------------------------
    public AppiumDriver init_driver(Properties prop) {

        String deviceType = prop.getProperty("deviceType", "android");

        try {
            if (deviceType.equalsIgnoreCase("android") || deviceType.equalsIgnoreCase("emulator")) {
                return setupAndroidDriver(prop);
            } else {
                throw new IllegalArgumentException("Unsupported Device Type: " + deviceType);
            }
        } catch (Exception e) {
            throw new IllegalStateException("Driver initialization failed: " + e.getMessage());
        }
    }

    // -------------------------
    // ANDROID DRIVER SETUP
    // -------------------------
    private AppiumDriver setupAndroidDriver(Properties prop) {

        try {
            String deviceName = prop.getProperty("deviceName");
            String apkPath    = prop.getProperty("apkPath");
            String serverUrl  = prop.getProperty("serverUrl", "http://127.0.0.1:4723/");

            // Validate APK
            File apk = new File(apkPath);
            if (!apk.exists()) {
                throw new RuntimeException("APK NOT FOUND at: " + apk.getAbsolutePath());
            }

            UiAutomator2Options options = new UiAutomator2Options();

            options.setPlatformName("Android");
            options.setAutomationName("UiAutomator2");
            options.setDeviceName(deviceName);
            options.setApp(apkPath);

            // Optional but recommended
            options.setPlatformVersion(prop.getProperty("platformVersion"));
            options.setAutoGrantPermissions(true);
//            options.setAutoDismissAlerts(true);
            options.setNewCommandTimeout(Duration.ofSeconds(300));

            // Emulator support
            if ("emulator".equalsIgnoreCase(prop.getProperty("deviceType"))) {
                options.setAvd(prop.getProperty("avdName"));
            }

            driver = new AndroidDriver(new URL(serverUrl), options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            System.out.println("Android Driver initialized successfully.");
            return driver;

        } catch (Exception e) {
            throw new RuntimeException("Failed to start AndroidDriver → " + e.getMessage());
        }
    }

    // -------------------------
    // CLEANUP
    // -------------------------
    public void cleanupDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
