package com.dits.citywide.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.dits.citywide.constants.Constants;
import com.dits.citywide.utilities.ElementUtils;

public class CompanySettingsPage {

	private WebDriver driver;
	private ElementUtils elementUtils;

	private By lnkCompanyDetails = By.xpath("//h4[normalize-space()='Company Details']");
	private By lnkRiverside = By.xpath("//h4[normalize-space()='San Diego']");
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

	private By lnkTeamSupportTemplate = By.xpath("//h4[normalize-space()='Team Support Templates']");

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

	public LeavesPage clickLeavesLink() {
		elementUtils.waitForElementToBeClickable(lnkLeaves, Constants.DEFAULT_WAIT).click();
		return new LeavesPage(driver);
	}

	public ActivityTemplatePage clickActivityCodeLink() {
		elementUtils.waitForElementToBeClickable(lnkActivityCode, Constants.DEFAULT_WAIT).click();
		return new ActivityTemplatePage(driver);
	}

	public BeatsPage clickBeatsLink() {
		elementUtils.waitForElementToBeClickable(lnkBeats, Constants.DEFAULT_WAIT).click();
		return new BeatsPage(driver);
	}

	public ViolationsPage clickViolationsLink() {
		elementUtils.waitForElementToBeClickable(lnkViolations, Constants.DEFAULT_WAIT).click();
		return new ViolationsPage(driver);
	}

	public ActivityTemplatePage clickActivityTemplatesLink() {
		elementUtils.waitForElementToBeClickable(lnkActivityTemplates, Constants.DEFAULT_WAIT).click();
		return new ActivityTemplatePage(driver);
	}

	public RespondingAgenciesPage clickRespondingAgenciesLink() {
		elementUtils.waitForElementToBeClickable(lnkRespondingAgencies, Constants.DEFAULT_WAIT).click();
		return new RespondingAgenciesPage(driver);
	}

	public HRConfigurationsPage clickHRConfigurationsLink() {
		elementUtils.waitForElementToBeClickable(lnkHRConfigurations, Constants.DEFAULT_WAIT).click();
		return new HRConfigurationsPage(driver);
	}

	public TeamSupportTemplatePage clickTeamSupportTemplateLink() {
		elementUtils.waitForElementToBeClickable(lnkTeamSupportTemplate, Constants.DEFAULT_WAIT).click();
		return new TeamSupportTemplatePage(driver);
	}
	
	public ServiceTypePage clickServiceTypeLink() {
	    elementUtils.waitForElementToBeClickable(lnkServiceTypes, Constants.DEFAULT_WAIT).click();
	    return new ServiceTypePage(driver);
	}
	public RankAndPositionPage clickRankAndPositionLink() {
	    elementUtils.waitForElementToBeClickable(lnkRankOrPosition, Constants.DEFAULT_WAIT).click();
	    return new RankAndPositionPage(driver);
	}
	public AssignmentTemplatePage clickAssignmentTemplateLink() {
	    elementUtils.waitForElementToBeClickable(lnkAssignmentTemplates, Constants.DEFAULT_WAIT).click();
	    return new AssignmentTemplatePage(driver);
	}
	// ✅ Opens Company Details Page
	public CompanyDetailsPage clickCompanyDetailsLink() {
	    elementUtils.waitForElementToBeClickable(lnkCompanyDetails, Constants.DEFAULT_WAIT).click();
	    return new CompanyDetailsPage(driver);
	}

	// ✅ Opens Branch Page
	public BranchPage clickBranchLink() {
	    elementUtils.waitForElementToBeClickable(lnkRiverside, Constants.DEFAULT_WAIT).click();
	    return new BranchPage(driver);
	}

	// ✅ Opens Branch Listing Page
	public BranchListingPage clickBranchListingLink() {
	    elementUtils.waitForElementToBeClickable(lnkBranchListing, Constants.DEFAULT_WAIT).click();
	    return new BranchListingPage(driver);
	}

	// ✅ Opens Roles & Permission Page
	public RolesPermissionPage clickRolesAndPermissionLink() {
	    elementUtils.waitForElementToBeClickable(lnkRolesAndPermission, Constants.DEFAULT_WAIT).click();
	    return new RolesPermissionPage(driver);
	}

	// ✅ Opens Mass Mail Page
	public MassMailPage clickMassMailLink() {
	    elementUtils.waitForElementToBeClickable(lnkMassEmail, Constants.DEFAULT_WAIT).click();
	    return new MassMailPage(driver);
	}

	// ✅ Opens System Logs Page
	public SystemLogsPage clickSystemLogsLink() {
	    elementUtils.waitForElementToBeClickable(lnkSystemLogs, Constants.DEFAULT_WAIT).click();
	    return new SystemLogsPage(driver);
	}

	// ✅ Opens Notifications Page
	public NotificationsPage clickNotificationsLink() {
	    elementUtils.waitForElementToBeClickable(lnkNotifications, Constants.DEFAULT_WAIT).click();
	    return new NotificationsPage(driver);
	}

	// ✅ Opens System Configurations Page
	public SystemConfigPage clickSystemConfigurationsLink() {
	    elementUtils.waitForElementToBeClickable(lnkSystemConfigurations, Constants.DEFAULT_WAIT).click();
	    return new SystemConfigPage(driver);
	}


	
	


	


}
