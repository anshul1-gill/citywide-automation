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
    private By lnkLogRefNo = By.xpath("(//td[@data-label='Log Ref.']//div[contains(@class,'anchor-style')])[1]");
    private By lnkPastCalls = By.xpath("//a[normalize-space()='Past Calls']");
    private By lnkPastCallsNo = By
            .xpath("(//td[@data-label='Call #']//div[contains(@class,'incident-number link-in-table')])[1]");
    private By lnkPastCallsSiteNo = By
            .xpath("(//td[@data-label='Site']//a[contains(@class,'incident-number link-in-table')])[1]");

    private By lnkPassdown = By.xpath("//a[normalize-space()='Passdown']");
    private By passdownSiteDropdown = By.xpath("//input[@id='patrol_site_id']");

    // =============================================================================//
    private By lnkForms = By.xpath("//a[normalize-space()='Forms']");
    private By lnkParkingIncidentNumber = By
            .xpath("(//td[@data-label='Incident']//a[contains(@class,'link-in-table')])[1]");
    private By BackButton = By.xpath("//span[normalize-space()='Back']");
    private By lnkTrespassNotice = By.xpath("(//div[normalize-space()='Trespass Notices'])[2]");
    private By lnkTrespasslink = By
            .xpath("(//td[@data-label='Incident']//a[contains(@href,'/client/form/trespass/view')])[1]");
    private By lnkFieldinterview = By.xpath("(//div[normalize-space()='Field Interviews'])[2]");
    private By lnkFieldinterviewLink = By
            .xpath("(//td[@data-label='Incident']//a[contains(@href,'/client/form/field/view')])[1]");

    private By lnkIncidentReport = By.xpath("(//div[normalize-space()='Incident Reports'])[2]");
    private By lnkIncidentReportLink = By
            .xpath("(//td[@data-label='Incident']//a[contains(@href,'/client/form/incident/view')])[1]");

    // =========================Request
    // response====================================================//
    private By lnkRequestResponse = By.xpath("//a[normalize-space()='Request Response']");
    private By lnkbuttonAddRequest = By
            .xpath("//a[@href='https://stage.commandhubsolutions.com/client/add-client-calls']");
    private By lnkPhoneNumber = By.xpath("//input[@type='tel']");
    private By ReportingAddress = By.xpath("//input[@id='reporting_address']");
    private By Description = By.xpath("//textarea[@id='call_description']");
    private By lnkSubmit = By.xpath("(//span[normalize-space()='Request Response'])[2]");
    // ==================================================================//

    private By lnkMyproperties = By.xpath("//a[normalize-space()='My Properties']");
    private By SiteDetails = By.xpath("//div[@id='rc-tabs-0-tab-site_map']");
    private By lnkSiteAccess = By.xpath("//div[@id='rc-tabs-0-tab-property_access']");
    private By lnkSitePostOrder = By.xpath("//div[@id='rc-tabs-0-tab-post_orders']");
    private By lnkSiteAreas = By.xpath("//div[@id='rc-tabs-0-tab-site_areas']");
    private By lnkParkingEnforcements = By.xpath("//div[@id='rc-tabs-0-tab-parking_enforcement']");
    private By lnkSiteContacts = By.xpath("//div[@id='rc-tabs-0-tab-coverage']");
    private By lnkSiteReports = By.xpath("//div[@id='rc-tabs-0-tab-reports']");
    private By lnkSiteDocuments = By.xpath("//div[@id='rc-tabs-0-tab-document']");
    private By lnkSiteComments = By.xpath("//div[@id='rc-tabs-0-tab-comment']");

    private By lnkInvoices = By.xpath("//a[normalize-space()='Invoice']");

    private By lnkClientSupport = By.xpath("//a[normalize-space()='Client Support']");
    private By lnkRequestSupport = By.xpath(".//span[normalize-space()='Add New Request']");
    private By lnkSubject = By.xpath("//input[@id='request_message_subject']");
    private By lnkDescription = By.xpath("//textarea[@id='request_message_text']");
    private By lnkSubmitRequest = By.xpath("//button[@type='submit' and normalize-space()='Save']");
    private By lnkBack = By.xpath("//button[@type='button' and normalize-space()='Back']");

    private By lnkActivityTracking = By.xpath("//a[normalize-space()='Activity Tracking']");

    public ClientModulePage(WebDriver driver) {
        this.driver = driver;
        this.elementUtils = new ElementUtils(driver);
    }

    public boolean isReportVisible() throws InterruptedException {
        Thread.sleep(1000);
        return elementUtils.doIsDisplayed(lnkReports, Constants.DEFAULT_WAIT);
    }

    public void clickReportsLink() throws InterruptedException {
        Thread.sleep(1000);
        elementUtils.waitForElementToBeClickable(lnkReports, Constants.DEFAULT_WAIT).click();
        Thread.sleep(1000);
        elementUtils.waitForElementToBeClickable(lnkLogRefNo, Constants.DEFAULT_WAIT).click();
        Thread.sleep(1000);
        elementUtils.waitForElementToBeClickable(BackButton, Constants.DEFAULT_WAIT).click();
    }

    public void clickPastCallsLink() throws InterruptedException {
        Thread.sleep(1000);
        elementUtils.waitForElementToBeClickable(lnkPastCalls, Constants.DEFAULT_WAIT).click();
        Thread.sleep(1000);
        elementUtils.waitForElementToBeClickable(lnkPastCallsNo, Constants.DEFAULT_WAIT).click();
        Thread.sleep(1000);
        elementUtils.waitForElementToBeClickable(BackButton, Constants.DEFAULT_WAIT).click();
        // Thread.sleep(1000);
        // elementUtils.waitForElementToBeClickable(lnkPastCallsSiteNo,
        // Constants.DEFAULT_WAIT).click();
        // Thread.sleep(1000);
        // elementUtils.waitForElementToBeClickable(BackButton,
        // Constants.DEFAULT_WAIT).click();

    }

    public void clickPassdownLink() throws InterruptedException {
        Thread.sleep(1000);
        elementUtils.waitForElementToBeClickable(lnkPassdown, Constants.DEFAULT_WAIT).click();
        Thread.sleep(1000);
        elementUtils.selectFromReactDropdown(passdownSiteDropdown, "1218 - Richmond");
    }

    public void clickFormsLink() throws InterruptedException {
        Thread.sleep(1000);
        elementUtils.waitForElementToBeClickable(lnkForms, Constants.DEFAULT_WAIT).click();
        Thread.sleep(1000);
        elementUtils.waitForElementToBeClickable(lnkParkingIncidentNumber, Constants.DEFAULT_WAIT).click();
        Thread.sleep(1000);
        elementUtils.waitForElementToBeClickable(BackButton, Constants.DEFAULT_WAIT).click();
        Thread.sleep(1000);
        elementUtils.waitForElementToBeClickable(lnkTrespassNotice, Constants.DEFAULT_WAIT).click();
        Thread.sleep(1000);
        elementUtils.waitForElementToBeClickable(lnkTrespasslink, Constants.DEFAULT_WAIT).click();
        Thread.sleep(1000);
        elementUtils.waitForElementToBeClickable(BackButton, Constants.DEFAULT_WAIT).click();
        Thread.sleep(1000);
        elementUtils.waitForElementToBeClickable(lnkFieldinterview, Constants.DEFAULT_WAIT).click();
        Thread.sleep(1000);
        elementUtils.waitForElementToBeClickable(lnkFieldinterviewLink, Constants.DEFAULT_WAIT).click();
        Thread.sleep(1000);
        elementUtils.waitForElementToBeClickable(BackButton, Constants.DEFAULT_WAIT).click();
        Thread.sleep(1000);
        elementUtils.waitForElementToBeClickable(lnkIncidentReport, Constants.DEFAULT_WAIT).click();
        Thread.sleep(1000);
        elementUtils.waitForElementToBeClickable(lnkIncidentReportLink, Constants.DEFAULT_WAIT).click();
        Thread.sleep(1000);
        elementUtils.waitForElementToBeClickable(BackButton, Constants.DEFAULT_WAIT).click();

    }

    public void clickRequestResponseLink() throws InterruptedException {
        Thread.sleep(1000);
        elementUtils.waitForElementToBeClickable(lnkRequestResponse, Constants.DEFAULT_WAIT).click();
        Thread.sleep(1000);
        elementUtils.waitForElementToBeClickable(lnkbuttonAddRequest, Constants.DEFAULT_WAIT).click();
        Thread.sleep(1000);
        elementUtils.doSendKeys(lnkPhoneNumber, "1234567890");
        elementUtils.doSendKeys(ReportingAddress, "123 Main St");
        elementUtils.doSendKeys(Description, "Test description for request response");
        Thread.sleep(1000);
        elementUtils.waitForElementToBeClickable(lnkSubmit, Constants.DEFAULT_WAIT).click();
    }

    public void clickMypropertiesLink() throws InterruptedException {
        Thread.sleep(2000);
        elementUtils.waitForElementToBeClickable(lnkMyproperties, Constants.DEFAULT_WAIT).click();
        Thread.sleep(2000);
        elementUtils.waitForElementToBeClickable(SiteDetails, Constants.DEFAULT_WAIT).click();
        Thread.sleep(2000);
        elementUtils.waitForElementToBeClickable(lnkSiteAccess, Constants.DEFAULT_WAIT).click();
        Thread.sleep(2000);
        elementUtils.waitForElementToBeClickable(lnkSitePostOrder, Constants.DEFAULT_WAIT).click();
        Thread.sleep(2000);
        elementUtils.waitForElementToBeClickable(lnkSiteAreas, Constants.DEFAULT_WAIT).click();
        Thread.sleep(2000);
        elementUtils.waitForElementToBeClickable(lnkParkingEnforcements, Constants.DEFAULT_WAIT).click();
        Thread.sleep(2000);
        elementUtils.waitForElementToBeClickable(lnkSiteContacts, Constants.DEFAULT_WAIT).click();
        Thread.sleep(2000);
        elementUtils.waitForElementToBeClickable(lnkSiteReports, Constants.DEFAULT_WAIT).click();
        Thread.sleep(2000);
        elementUtils.waitForElementToBeClickable(lnkSiteDocuments, Constants.DEFAULT_WAIT).click();
        Thread.sleep(2000);
        elementUtils.waitForElementToBeClickable(lnkSiteComments, Constants.DEFAULT_WAIT).click();

    }

    public void clickInvoicesLink() throws InterruptedException {
        Thread.sleep(1000);
        elementUtils.waitForElementToBeClickable(lnkInvoices, Constants.DEFAULT_WAIT).click();
    }

    public void clickClientSupportLink() throws InterruptedException {
        elementUtils.waitForElementToBeClickable(lnkClientSupport, Constants.DEFAULT_WAIT).click();
        Thread.sleep(2000);
        elementUtils.waitForElementToBeClickable(lnkRequestSupport, Constants.DEFAULT_WAIT).click();
        Thread.sleep(1000);
        elementUtils.doSendKeys(lnkSubject, "Test Support Request");
        Thread.sleep(2000);
        elementUtils.doSendKeys(lnkDescription, "This is a test support request description"
                + "Please assist with this issue.");
        Thread.sleep(2000);
        elementUtils.waitForElementToBeClickable(lnkSubmitRequest, Constants.DEFAULT_WAIT).click();

    }

    public void clickActivityTrackingLink() throws InterruptedException {
        Thread.sleep(1000);
        elementUtils.waitForElementToBeClickable(lnkActivityTracking, Constants.DEFAULT_WAIT).click();
    }
}
