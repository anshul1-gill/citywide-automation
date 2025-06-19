package com.dits.citywide.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.dits.citywide.constants.Constants;
import com.dits.citywide.utilities.ElementUtils;

public class CallsPage {

	private WebDriver driver;
	private ElementUtils elementUtils;

	// Calls Section
	private By btnAddNewCall = By.xpath("//a[contains(text(),'Add New Call')]");

	// Add New Call
	private By dropdownOfficerReceivedVia = By.xpath("//select[@id='call_received_from']");
	private By valuesOfficerReceivedVia = By.xpath("//select[@id='call_received_from']");

	private By dropdownPatrolSite = By.xpath("//label[@for=\"site_search\"]");
	private By searchboxPatrolSite = By.cssSelector("input[placeholder='Search...']");
	private By patrolSiteValues = By.xpath("//div[@class='list-none m-0 p-0']/div/span");

	// Reporting Person
	private By txtboxFirstName = By.xpath("//input[@id='rp_first_name']");
	private By txtboxLastName = By.xpath("//input[@id='rp_last_name']");
	private By txtboxPhoneNumber = By.xpath("//input[@id='rp_phone_number']");

//	private By checkboxAssignedAgent = By.xpath("//div[contains(@class,'assigned-agents')]");
	private By btnSaveAddNewCall = By.xpath("//button[@type='submit']");

	private By successMessage = By.xpath("//h2[@id='swal2-title']/span[@class='text-white']");

	private By dataCallId = By
			.xpath("(//tr[@class='bg-white dark:bg-gray-800 dark:text-white bordered-tr']/td[3])[1]/a");

	public CallsPage(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(driver);
	}

	// Calls
	public void doClickAddNewCallButton() {
		elementUtils.waitForElementToBeClickable(btnAddNewCall, Constants.DEFAULT_WAIT).click();
	}

	// Add New Call
	public void fillAddNewCallForm(String officerReceivedVia, String patrolSite) throws InterruptedException {
		elementUtils.waitForElementToBeClickable(dropdownOfficerReceivedVia, Constants.DEFAULT_WAIT).click();
		elementUtils.doSelectBy(valuesOfficerReceivedVia, officerReceivedVia);

		elementUtils.doActionsClick(dropdownPatrolSite);
		elementUtils.waitForElementVisible(searchboxPatrolSite, Constants.SHORT_TIME_OUT_WAIT).sendKeys(patrolSite);
		elementUtils.selectElementThroughLocator(patrolSiteValues, patrolSite, Constants.SHORT_TIME_OUT_WAIT);
	}

	public void fillReportingPersonForm(String firstName, String lastName, String phoneNumber) {
		elementUtils.waitForElementVisible(txtboxFirstName, Constants.DEFAULT_WAIT).sendKeys(firstName);
		elementUtils.waitForElementVisible(txtboxLastName, Constants.DEFAULT_WAIT).sendKeys(lastName);
		elementUtils.waitForElementVisible(txtboxPhoneNumber, Constants.DEFAULT_WAIT).sendKeys(phoneNumber);
	}

	public void selectAvailableUnits(String userId) {
		// elementUtils.waitForElementToBeClickable(checkboxAssignedAgent,
		// Constants.DEFAULT_WAIT).click();
		String userid = userId;
		By label = By.xpath("//label[contains(normalize-space(), '" + userid + "')]");
		// elementUtils.waitForElementToBeClickable(label,
		// Constants.DEFAULT_WAIT).click();
		elementUtils.doClickWithActionsAndWait(label, Constants.DEFAULT_WAIT);
	}

	public void doClickSaveAddNewCall() {
		elementUtils.waitForElementVisible(btnSaveAddNewCall, Constants.DEFAULT_WAIT);
		elementUtils.waitForElementToBeClickable(btnSaveAddNewCall, Constants.DEFAULT_WAIT).click();
	}

	public String getSuccessMessageText() {
		return elementUtils.waitForElementVisible(successMessage, Constants.DEFAULT_WAIT).getText();
	}

	public String getCallId() {
		return elementUtils.waitForElementVisible(dataCallId, Constants.DEFAULT_WAIT).getText();
	}

}
