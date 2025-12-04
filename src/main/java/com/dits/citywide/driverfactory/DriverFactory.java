package com.dits.citywide.driverfactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {

    // Thread-safe driver storage so listeners can access the current driver
    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public WebDriver driver;
    public Properties prop;
    private String filePath = "./src/test/resource/config/config.properties";

    // Static getter for current WebDriver (used in ExtentReportListener)
    public static WebDriver getDriver() {
        return tlDriver.get();
    }

    // Initialize WebDriver based on browser in properties
    public WebDriver initDriver(Properties prop) {
        String browserName = prop.getProperty("browser").trim();

        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver",
                    "/home/ditsdev151/Public/chromedriver-linux64/chromedriver");

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--disable-notifications");
            options.addArguments("--disable-infobars");
            options.addArguments("--incognito");

            driver = new ChromeDriver(options);
            driver.manage().deleteAllCookies();

        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
            driver.manage().deleteAllCookies();

        } else if (browserName.equalsIgnoreCase("safari")) {
            driver = new SafariDriver();

        } else if (browserName.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
            driver.manage().deleteAllCookies();

        } else {
            System.out.println("Driver not exit");
        }

        driver.manage().window().maximize();
        driver.get(prop.getProperty("url").trim());

        // store driver in ThreadLocal for global access
        tlDriver.set(driver);

        return driver;
    }

    // Load properties from config file
    public Properties initProperties() {
        prop = new Properties();

        try {
            FileInputStream fis = new FileInputStream(filePath);
            prop.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }

    // Update the value of an existing key in the properties file
    public void updatePropertyValue(String key, String newValue) {
        try {
            FileInputStream fis = new FileInputStream(filePath);
            prop.load(fis);
            fis.close();

            prop.setProperty(key, newValue);

            FileOutputStream fos = new FileOutputStream(filePath);
            prop.store(fos, null);
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
