package com.dits.citywide.pages.operationhub;

import org.openqa.selenium.WebDriver;

public class OperationsHubHomePage {
    private WebDriver driver;
    public OperationsHubHomePage(WebDriver driver) {
        this.driver = driver;
    }
    public OperationsHubCallsPage doClickCallsTab() {
        // Stub: Add logic to click Calls tab and return Calls page
        return new OperationsHubCallsPage(driver);
    }
}
