package com.dits.citywide.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class PerformanceUtils {

    private WebDriver driver;

    public PerformanceUtils(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Captures page load time using browser performance timing
     */
    public long getPageLoadTimeInSeconds() {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        long loadTime = (Long) js.executeScript(
            "return Math.round((performance.timing.loadEventEnd - performance.timing.navigationStart) / 1000);"
        );

        return loadTime;
    }

    /**
     * Captures DOM content load time
     */
    public long getDomContentLoadTimeInSeconds() {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        long domTime = (Long) js.executeScript(
            "return Math.round((performance.timing.domContentLoadedEventEnd - performance.timing.navigationStart) / 1000);"
        );

        return domTime;
    }
}
