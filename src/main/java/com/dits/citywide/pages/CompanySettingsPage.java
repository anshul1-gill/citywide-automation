package com.dits.citywide.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.dits.citywide.constants.Constants;
import com.dits.citywide.utilities.ElementUtils;

public class CompanySettingsPage {

	private WebDriver driver;
	private ElementUtils elementUtils;

	private By lnkCompanyDetails = By.xpath("//h4[normalize-space()='Company Details']");
	private By lnkRiverside = By.xpath("//h4[normalize-space()='Riverside']");
	private By lnkBranchListing = By.xpath("//h4[normalize-space()='Branch Listing']");
	private By lnkServiceTypes = By.xpath("//h4[normalize-space()='Service Types']");
	private By lnkRolesAndPermission = By.xpath("//h4[normalize-space()='Roles & Permission']");

	private By lnkRankOrPosition = By.xpath("//h4[normalize-space()='Rank/Position']");
	private By lnkBreaks = By.xpath("//h4[normalize-space()='Breaks']");
	private By lnkHolidays = By.xpath("//h4[normalize-space()='Holidays']");
	private By lnkLeaves = By.xpath("//h4[normalize-space()='Leaves']");
	private By lnkActivityCode = By.xpath("//h4[normalize-space()='Activity Code']");

	private By lnkActivityTemplates = By.xpath("//h4[normalize-space()='Activity Templates']");
	private By lnkAssignmentTemplates = By.xpath("//h4[normalize-space()='Assignment Templates']");
	private By lnkViolations = By.xpath("//h4[normalize-space()='Violations']");
	private By lnkBeats = By.xpath("//h4[normalize-space()='Beats']");
	private By lnkMassEmail = By.xpath("//h4[normalize-space()='Mass Email']");

	private By lnkSystemLogs = By.xpath("//h4[normalize-space()='System Logs']");
	private By lnkNotifications = By.xpath("//h4[normalize-space()='Notifications']");
	private By lnkHRConfigurations = By.xpath("//h4[normalize-space()='HR Configurations']");
	private By lnkSystemConfigurations = By.xpath("//h4[normalize-space()='System Configurations']");
	private By lnkRespondingAgencies = By.xpath("//h4[normalize-space()='Responding Agencies']");

	public CompanySettingsPage(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(driver);
	}

	public boolean isCompanyDetailsVisible() {
		return elementUtils.doIsDisplayed(lnkCompanyDetails, Constants.DEFAULT_WAIT);
	}

	public boolean isRiversideVisible() {
		return elementUtils.doIsDisplayed(lnkRiverside, Constants.DEFAULT_WAIT);
	}

	public boolean isBranchListingVisible() {
		return elementUtils.doIsDisplayed(lnkBranchListing, Constants.DEFAULT_WAIT);
	}

	public boolean isServiceTypesVisible() {
		return elementUtils.doIsDisplayed(lnkServiceTypes, Constants.DEFAULT_WAIT);
	}

	public boolean isRolesAndPermissionVisible() {
		return elementUtils.doIsDisplayed(lnkRolesAndPermission, Constants.DEFAULT_WAIT);
	}

	public boolean isRankOrPositionVisible() {
		return elementUtils.doIsDisplayed(lnkRankOrPosition, Constants.DEFAULT_WAIT);
	}

	public boolean isBreaksVisible() {
		return elementUtils.doIsDisplayed(lnkBreaks, Constants.DEFAULT_WAIT);
	}

	public boolean isHolidaysVisible() {
		return elementUtils.doIsDisplayed(lnkHolidays, Constants.DEFAULT_WAIT);
	}

	public boolean isLeavesVisible() {
		return elementUtils.doIsDisplayed(lnkLeaves, Constants.DEFAULT_WAIT);
	}

	public boolean isActivityCodeVisible() {
		return elementUtils.doIsDisplayed(lnkActivityCode, Constants.DEFAULT_WAIT);
	}

	public boolean isActivityTemplatesVisible() {
		return elementUtils.doIsDisplayed(lnkActivityTemplates, Constants.DEFAULT_WAIT);
	}

	public boolean isAssignmentTemplatesVisible() {
		return elementUtils.doIsDisplayed(lnkAssignmentTemplates, Constants.DEFAULT_WAIT);
	}

	public boolean isViolationsVisible() {
		return elementUtils.doIsDisplayed(lnkViolations, Constants.DEFAULT_WAIT);
	}

	public boolean isBeatsVisible() {
		return elementUtils.doIsDisplayed(lnkBeats, Constants.DEFAULT_WAIT);
	}

	public boolean isMassEmailVisible() {
		return elementUtils.doIsDisplayed(lnkMassEmail, Constants.DEFAULT_WAIT);
	}

	public boolean isSystemLogsVisible() {
		return elementUtils.doIsDisplayed(lnkSystemLogs, Constants.DEFAULT_WAIT);
	}

	public boolean isNotificationsVisible() {
		return elementUtils.doIsDisplayed(lnkNotifications, Constants.DEFAULT_WAIT);
	}

	public boolean isHRConfigurationsVisible() {
		return elementUtils.doIsDisplayed(lnkHRConfigurations, Constants.DEFAULT_WAIT);
	}

	public boolean isSystemConfigurationsVisible() {
		return elementUtils.doIsDisplayed(lnkSystemConfigurations, Constants.DEFAULT_WAIT);
	}

	public boolean isRespondingAgenciesVisible() {
		return elementUtils.doIsDisplayed(lnkRespondingAgencies, Constants.DEFAULT_WAIT);
	}

	public BreaksPage clickBreaksLink() {
		elementUtils.waitForElementToBeClickable(lnkBreaks, Constants.DEFAULT_WAIT).click();
		return new BreaksPage(driver);
	}

	public HolidaysPage clickHolidaysLink() {
		elementUtils.waitForElementToBeClickable(lnkHolidays, Constants.DEFAULT_WAIT).click();
		return new HolidaysPage(driver);
	}

}
