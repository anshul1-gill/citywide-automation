package com.dits.citywide.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.dits.citywide.constants.Constants;
import com.dits.citywide.utilities.ElementUtils;

public class CompanySettingsPage {

	private WebDriver driver;
	private ElementUtils elementUtils;

	// ===================== SECTION HEADERS =====================
	// These are the collapsible section headers (h2.section-card-title)
	private static final String SECTION_ORGANIZATION = "Organization Settings";
	private static final String SECTION_HR_WORKFORCE = "HR & Workforce";
	private static final String SECTION_BEATS = "Beats";
	private static final String SECTION_OPERATIONS = "Operations & Dispatch";
	private static final String SECTION_TEMPLATES = "Templates & Activity Configuration";
	private static final String SECTION_NOTIFICATIONS = "Notifications & Communication";
	private static final String SECTION_SYSTEM = "System & Technical Settings";

	// ===================== MODULE LOCATORS =====================
	// Organization Settings
	private By lnkCompanyDetails = By.xpath("//div[@class='item-title' and normalize-space()='Company Details']");
	private By lnkRiverside = By.xpath("//div[@class='item-title' and normalize-space()='Riverside']");
	private By lnkBranchListing = By.xpath("//div[@class='item-title' and normalize-space()='Branch Listing']");
	private By lnkServiceTypes = By.xpath("//div[@class='item-title' and normalize-space()='Service Types']");
	private By lnkRolesAndPermission = By.xpath("//div[@class='item-title' and normalize-space()='Roles & Permission']");
	private By lnkRankOrPosition = By.xpath("//div[@class='item-title' and normalize-space()='Rank/Position']");
	private By lnkBreaks = By.xpath("//div[@class='item-title' and normalize-space()='Breaks']");

	// HR & Workforce
	private By lnkHolidays = By.xpath("//div[@class='item-title' and normalize-space()='Holidays']");
	private By lnkLeaves = By.xpath("//div[@class='item-title' and normalize-space()='Leaves']");
	private By lnkHRConfigurations = By.xpath("//div[@class='item-title' and normalize-space()='HR Configurations']");

	// Beats
	private By lnkBeats = By.xpath("//div[@class='item-title' and normalize-space()='Beats']");

	// Operations & Dispatch
	private By lnkOtherSettings = By.xpath("//div[@class='item-title' and normalize-space()='Other Settings']");
	private By lnkActivityCode = By.xpath("//div[@class='item-title' and normalize-space()='Activity Code']");
	private By lnkViolations = By.xpath("//div[@class='item-title' and normalize-space()='Violations']");
	private By lnkRespondingAgencies = By.xpath("//div[@class='item-title' and normalize-space()='Responding Agencies']");

	// Templates & Activity Configuration
	private By lnkActivityTemplates = By.xpath("//div[@class='item-title' and normalize-space()='Activity Templates']");
	private By lnkAssignmentTemplates = By.xpath("//div[@class='item-title' and normalize-space()='Assignment Templates']");
	private By lnkTeamSupportTemplate = By.xpath("//div[@class='item-title' and normalize-space()='Team Support Templates']");

	// Notifications & Communication
	private By lnkNotificationType = By.xpath("//div[@class='item-title' and normalize-space()='Notification Type']");
	private By lnkMassEmail = By.xpath("//div[@class='item-title' and normalize-space()='Mass Email']");
	private By lnkNotifications = By.xpath("//div[@class='item-title' and normalize-space()='Notifications']");

	// System & Technical Settings
	private By lnkSoundNotification = By.xpath("//div[@class='item-title' and normalize-space()='Sound Notification']");
	private By lnkShiftColorRules = By.xpath("//div[@class='item-title' and normalize-space()='Shift Color Rules']");
	private By lnkCallPriorityColors = By.xpath("//div[@class='item-title' and normalize-space()='Call Priority Colors']");
	private By lnkSystemLogs = By.xpath("//div[@class='item-title' and normalize-space()='System Logs']");
	private By lnkSystemConfigurations = By.xpath("//div[@class='item-title' and normalize-space()='System Configurations']");

	public CompanySettingsPage(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(driver);
	}

	// ===================== SECTION EXPAND HELPER =====================

	/**
	 * Scrolls to and expands a collapsible section if it's not already expanded.
	 * Uses h2.section-card-title to find the section header, then clicks it.
	 */
	public void expandSection(String sectionName) {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		By sectionHeader = By.xpath("//h2[@class='section-card-title' and normalize-space()='" + sectionName + "']");

		WebElement header = elementUtils.waitForElementVisible(sectionHeader, Constants.DEFAULT_WAIT);
		js.executeScript("arguments[0].scrollIntoView({block:'center'});", header);

		try { Thread.sleep(500); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }

		// Click the section header to expand/toggle
		WebElement headerParent = header.findElement(By.xpath("./ancestor::div[contains(@class,'section-card-header')]"));
		headerParent.click();

		try { Thread.sleep(1000); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }

		System.out.println("📂 Expanded section: " + sectionName);
	}

	// ===================== VISIBILITY CHECKS =====================

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

	// ===================== ORGANIZATION SETTINGS =====================

	public CompanyDetailsPage clickCompanyDetailsLink() {
		expandSection(SECTION_ORGANIZATION);
		elementUtils.waitForElementToBeClickable(lnkCompanyDetails, Constants.DEFAULT_WAIT).click();
		return new CompanyDetailsPage(driver);
	}

	public BranchPage clickBranchLink() {
		expandSection(SECTION_ORGANIZATION);
		elementUtils.waitForElementToBeClickable(lnkRiverside, Constants.DEFAULT_WAIT).click();
		return new BranchPage(driver);
	}

	public BranchListingPage clickBranchListingLink() {
		expandSection(SECTION_ORGANIZATION);
		elementUtils.waitForElementToBeClickable(lnkBranchListing, Constants.DEFAULT_WAIT).click();
		return new BranchListingPage(driver);
	}

	public ServiceTypePage clickServiceTypeLink() {
		expandSection(SECTION_ORGANIZATION);
		elementUtils.waitForElementToBeClickable(lnkServiceTypes, Constants.DEFAULT_WAIT).click();
		return new ServiceTypePage(driver);
	}

	public RolesPermissionPage clickRolesAndPermissionLink() {
		expandSection(SECTION_ORGANIZATION);
		elementUtils.waitForElementToBeClickable(lnkRolesAndPermission, Constants.DEFAULT_WAIT).click();
		return new RolesPermissionPage(driver);
	}

	public RankAndPositionPage clickRankAndPositionLink() {
		expandSection(SECTION_ORGANIZATION);
		elementUtils.waitForElementToBeClickable(lnkRankOrPosition, Constants.DEFAULT_WAIT).click();
		return new RankAndPositionPage(driver);
	}

	public BreaksPage clickBreaksLink() {
		expandSection(SECTION_ORGANIZATION);
		elementUtils.waitForElementToBeClickable(lnkBreaks, Constants.DEFAULT_WAIT).click();
		return new BreaksPage(driver);
	}

	// ===================== HR & WORKFORCE =====================

	public HolidaysPage clickHolidaysLink() {
		expandSection(SECTION_HR_WORKFORCE);
		elementUtils.waitForElementToBeClickable(lnkHolidays, Constants.DEFAULT_WAIT).click();
		return new HolidaysPage(driver);
	}

	public LeavesPage clickLeavesLink() {
		expandSection(SECTION_HR_WORKFORCE);
		elementUtils.waitForElementToBeClickable(lnkLeaves, Constants.DEFAULT_WAIT).click();
		return new LeavesPage(driver);
	}

	public HRConfigurationsPage clickHRConfigurationsLink() {
		expandSection(SECTION_HR_WORKFORCE);
		elementUtils.waitForElementToBeClickable(lnkHRConfigurations, Constants.DEFAULT_WAIT).click();
		return new HRConfigurationsPage(driver);
	}

	// ===================== BEATS =====================

	public BeatsPage clickBeatsLink() {
		expandSection(SECTION_BEATS);
		elementUtils.waitForElementToBeClickable(lnkBeats, Constants.DEFAULT_WAIT).click();
		return new BeatsPage(driver);
	}

	// ===================== OPERATIONS & DISPATCH =====================

	public ActivityTemplatePage clickActivityCodeLink() {
		expandSection(SECTION_OPERATIONS);
		elementUtils.waitForElementToBeClickable(lnkActivityCode, Constants.DEFAULT_WAIT).click();
		return new ActivityTemplatePage(driver);
	}

	public ViolationsPage clickViolationsLink() {
		expandSection(SECTION_OPERATIONS);
		elementUtils.waitForElementToBeClickable(lnkViolations, Constants.DEFAULT_WAIT).click();
		return new ViolationsPage(driver);
	}

	public RespondingAgenciesPage clickRespondingAgenciesLink() {
		expandSection(SECTION_OPERATIONS);
		elementUtils.waitForElementToBeClickable(lnkRespondingAgencies, Constants.DEFAULT_WAIT).click();
		return new RespondingAgenciesPage(driver);
	}

	// ===================== TEMPLATES & ACTIVITY CONFIGURATION =====================

	public ActivityTemplatePage clickActivityTemplatesLink() {
		expandSection(SECTION_TEMPLATES);
		elementUtils.waitForElementToBeClickable(lnkActivityTemplates, Constants.DEFAULT_WAIT).click();
		return new ActivityTemplatePage(driver);
	}

	public AssignmentTemplatePage clickAssignmentTemplateLink() {
		expandSection(SECTION_TEMPLATES);
		elementUtils.waitForElementToBeClickable(lnkAssignmentTemplates, Constants.DEFAULT_WAIT).click();
		return new AssignmentTemplatePage(driver);
	}

	public TeamSupportTemplatePage clickTeamSupportTemplateLink() {
		expandSection(SECTION_TEMPLATES);
		elementUtils.waitForElementToBeClickable(lnkTeamSupportTemplate, Constants.DEFAULT_WAIT).click();
		return new TeamSupportTemplatePage(driver);
	}

	// ===================== NOTIFICATIONS & COMMUNICATION =====================

	public MassMailPage clickMassMailLink() {
		expandSection(SECTION_NOTIFICATIONS);
		elementUtils.waitForElementToBeClickable(lnkMassEmail, Constants.DEFAULT_WAIT).click();
		return new MassMailPage(driver);
	}

	public NotificationsPage clickNotificationsLink() {
		expandSection(SECTION_NOTIFICATIONS);
		elementUtils.waitForElementToBeClickable(lnkNotifications, Constants.DEFAULT_WAIT).click();
		return new NotificationsPage(driver);
	}

	// ===================== SYSTEM & TECHNICAL SETTINGS =====================

	public SystemLogsPage clickSystemLogsLink() {
		expandSection(SECTION_SYSTEM);
		elementUtils.waitForElementToBeClickable(lnkSystemLogs, Constants.DEFAULT_WAIT).click();
		return new SystemLogsPage(driver);
	}

	public SystemConfigPage clickSystemConfigurationsLink() {
		expandSection(SECTION_SYSTEM);
		elementUtils.waitForElementToBeClickable(lnkSystemConfigurations, Constants.DEFAULT_WAIT).click();
		return new SystemConfigPage(driver);
	}

}
