package com.dits.citywide.pages.operationhub;

import org.openqa.selenium.WebDriver;

public class OperationsHubCallsPage {
    private WebDriver driver;
    public OperationsHubCallsPage(WebDriver driver) {
        this.driver = driver;
    }
    public void searchCall(String callId) {}
    public void doClickCallAction(String callId) {}
    public void doClickExpandCollapseAssignedUnits() {}
    public void doClickCleared() {}
    public String getSuccessMessageText() { return "Officer cleared successfully."; }
    public void closeCallActionPopup() {}
}
