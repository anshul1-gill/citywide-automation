package com.dits.citywide.utilities;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtils {
	

	    public static String captureScreenshot(WebDriver driver, String testName) {
	        try {
	            String time = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	            String screenshotDir = System.getProperty("user.dir") + "/reports/screenshots/";
	            Files.createDirectories(Paths.get(screenshotDir));

	            String filePath = screenshotDir + testName + "_" + time + ".png";

	            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	            FileHandler.copy(src, new File(filePath));

	            return filePath;
	        } catch (Exception e) {
	            System.out.println("Failed to capture screenshot: " + e.getMessage());
	            return null;
	        }
	    }

}
