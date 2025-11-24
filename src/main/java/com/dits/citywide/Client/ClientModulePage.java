package com.dits.citywide.Client;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.dits.citywide.utilities.ElementUtils;
import com.dits.citywide.constants.Constants;

public class ClientModulePage {
    private WebDriver driver;
    private ElementUtils elementUtils;

    // Placeholder locators for client settings submodules
    private By lnkReports = By.xpath("//a[normalize-space()='Reports']");
    private By lnkPastCalls = By.xpath("//a[normalize-space()='Past Calls']");
    private By lnkPassdown = By.xpath("//a[normalize-space()='Passdown']");
    private By lnkForms = By.xpath("//a[normalize-space()='Forms']");
    private By lnkRequestResponse = By.xpath("//a[normalize-space()='Request Response']");
    private By lnkMyproperties = By.xpath("//a[normalize-space()='My Properties']");
    private By lnkInvoices = By.xpath("//a[normalize-space()='Invoice']");
    private By lnkClientSupport = By.xpath("//a[normalize-space()='Client Support']");
    private By lnkActivityTracking = By.xpath("//a[normalize-space()='Activity Tracking']");

    public ClientModulePage(WebDriver driver) {
        this.driver = driver;
        this.elementUtils = new ElementUtils(driver);
    }

    public boolean isReportVisible() {
        return elementUtils.doIsDisplayed(lnkReports, Constants.DEFAULT_WAIT);
    }

    public void clickReportsLink() {
        elementUtils.waitForElementToBeClickable(lnkReports, Constants.DEFAULT_WAIT).click();
    }	

    public void clickPastCallsLink() {
        elementUtils.waitForElementToBeClickable(lnkPastCalls, Constants.DEFAULT_WAIT).click();
    }

    public void clickPassdownLink() {
        elementUtils.waitForElementToBeClickable(lnkPassdown, Constants.DEFAULT_WAIT).click();
    }

    public void clickFormsLink() {
        elementUtils.waitForElementToBeClickable(lnkForms, Constants.DEFAULT_WAIT).click();
    }
    public void clickRequestResponseLink() {
		elementUtils.waitForElementToBeClickable(lnkRequestResponse, Constants.DEFAULT_WAIT).click();
	}
    public void clickMypropertiesLink() {
		elementUtils.waitForElementToBeClickable(lnkMyproperties, Constants.DEFAULT_WAIT).click();
	}
    public void clickInvoicesLink() {
		elementUtils.waitForElementToBeClickable(lnkInvoices, Constants.DEFAULT_WAIT).click();
	}
    	public void clickClientSupportLink() {
    				elementUtils.waitForElementToBeClickable(lnkClientSupport, Constants.DEFAULT_WAIT).click();
    	}
    public void clickActivityTrackingLink() {
		elementUtils.waitForElementToBeClickable(lnkActivityTracking, Constants.DEFAULT_WAIT).click();
	}
}
