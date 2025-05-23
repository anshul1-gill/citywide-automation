package com.dits.citywide.pages;

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
	private By checkboxAssignedAgent = By.xpath("//div[contains(@class,'assigned-agents')]");
	private By btnSaveAddNewCall = By.xpath("//button[@type='submit']");

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

	public void selectAvailableUnits() {
		elementUtils.waitForElementToBeClickable(checkboxAssignedAgent, Constants.DEFAULT_WAIT).click();
	}

	public void doClickSaveAddNewCall() {
		elementUtils.waitForElementToBeClickable(btnSaveAddNewCall, Constants.DEFAULT_WAIT).click();
	}

}
