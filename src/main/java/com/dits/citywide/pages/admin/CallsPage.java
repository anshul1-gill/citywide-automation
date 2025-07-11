package com.dits.citywide.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.dits.citywide.constants.Constants;
import com.dits.citywide.utilities.ElementUtils;

public class CallsPage {

	private WebDriver driver;
	private ElementUtils elementUtils;

	private By tabOpenCalls = By.xpath("//div[@id='rc-tabs-0-tab-open-calls']");
	private By tabClosedCalls = By.xpath("//div[@id='rc-tabs-0-tab-past-calls']");

	// Calls Section
	private By btnAddNewCall = By.xpath("//span[normalize-space()='Add New Call']");

	// Add New Call
	private By dropdownOfficerReceivedVia = By.xpath("//span[@class='ant-select-selection-item']");
	private By valuesOfficerReceivedVia = By.xpath("(//div[@class='rc-virtual-list-holder-inner'])[1]/div/div");

	private By dropdownPatrolSite = By.xpath("(//span[@class='ant-select-selection-search'])[2]");
	private By searchboxPatrolSite = By.xpath("//input[@id='site_id']");
	private By txtViewSiteNotes = By.xpath("//span[normalize-space()='View site notes']");

	private By dropdownActivityCode = By.xpath("//input[@id='activity_code']");

	// Reporting Person
	private By txtboxFirstName = By.xpath("//input[@id='rp_first_name']");
	private By txtboxLastName = By.xpath("//input[@id='rp_last_name']");
	private By txtboxPhoneNumber = By.xpath("//input[@type='tel']");
	private By btnSaveAddNewCall = By.xpath("//button[@type='submit']");

	private By checkboxSameAsAboveAddress = By.xpath("//span[normalize-space()='Same as above address']");

	private By successMessage = By.xpath("//h2[@id='swal2-title']/span[@class='text-white']");

	private By dataAssignedTo = By.xpath("(//div[@class='call-status'])[1]/p");
	private By dataCallId = By.xpath("(//td[@data-label='Call #'])[1]/a");
	private By dataActivityCode = By.xpath("(//td[@data-label='Activity Code'])[1]");
	private By dataSite = By.xpath("(//td[@data-label='Site'])[1]/a");

	// Suspect Description
	private By btnCollapseSuspectDescription = By.xpath("//span[normalize-space()='Suspect Description']");

	private By txtboxSuspectName = By.xpath("//input[@id='suspect_description_0_name']");
	private By dropdownSuspectGender = By.xpath("//input[@id='suspect_description_0_gender']");
	private By dropdownRace = By.xpath("//input[@id='suspect_description_0_race']");
	private By dropdownHairType = By.xpath("//input[@id='suspect_description_0_hairType']");
	private By dropdownHairColor = By.xpath("//input[@id='suspect_description_0_hair']");
	private By dropdownEyeColor = By.xpath("//input[@id='suspect_description_0_eyes']");
	private By dropdownHeight = By.xpath("//input[@id='suspect_description_0_height']");
	private By dropdownBuild = By.xpath("//input[@id='suspect_description_0_build']");
	private By txtboxWeight = By.xpath("//input[@id='suspect_description_0_weight']");
	private By txtboxAge = By.xpath("//input[@id='suspect_description_0_age']");
	private By txtboxClothingWorn = By.xpath("//input[@id='suspect_description_0_clothing_worn']");
	private By txtboxLastKnownDirection = By.xpath("//input[@id='suspect_description_0_last_know_direction']");

	private By txtboxCallDescription = By.xpath("//textarea[@id='call_description']");

	private By loader = By.xpath("//span[@class='ant-spin-dot ant-spin-dot-spin']");

	public CallsPage(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(driver);
	}

	// Calls
	public boolean isOpenCallsTabDisplayed() {
		return elementUtils.doIsDisplayed(tabOpenCalls, Constants.DEFAULT_WAIT);
	}

	public boolean isClosedCallsTabDisplayed() {
		return elementUtils.doIsDisplayed(tabClosedCalls, Constants.DEFAULT_WAIT);
	}

	public void doClickOpenCallsTab() {
		elementUtils.waitForElementToBeClickable(tabOpenCalls, Constants.DEFAULT_WAIT).click();
	}

	public void doClickClosedCallsTab() {
		elementUtils.waitForElementToBeClickable(tabClosedCalls, Constants.DEFAULT_WAIT).click();
	}

	public void doClickAddNewCallButton() {
		elementUtils.waitForElementToBeClickable(btnAddNewCall, Constants.DEFAULT_WAIT).click();
	}

	// Add New Call

	public void fillAddNewCallForm(String officerReceivedVia, String patrolSite, String activityCode)
			throws InterruptedException {
		elementUtils.waitForElementToBeClickable(dropdownOfficerReceivedVia, Constants.DEFAULT_WAIT).click();
		elementUtils.selectElementThroughLocator(valuesOfficerReceivedVia, officerReceivedVia,
				Constants.SHORT_TIME_OUT_WAIT);
		Thread.sleep(500);
		elementUtils.waitForElementToBeClickable(dropdownPatrolSite, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementVisible(searchboxPatrolSite, Constants.DEFAULT_WAIT).sendKeys(patrolSite);
		elementUtils.pressEnterKey();
		elementUtils.waitForElementVisible(txtViewSiteNotes, Constants.DEFAULT_WAIT);

		elementUtils.waitForInvisibilityOfElementLocated(loader, Constants.DEFAULT_WAIT);
		elementUtils.doActionsClick(dropdownActivityCode);
		elementUtils.waitForElementVisible(dropdownActivityCode, Constants.MEDIUM_TIME_OUT_WAIT).sendKeys(activityCode);
		Thread.sleep(2000);
		elementUtils.pressEnterKey();
	}

	public void fillReportingPersonForm(String firstName, String lastName, String phoneNumber, String demeanor)
			throws InterruptedException {
		elementUtils.waitForElementVisible(txtboxFirstName, Constants.DEFAULT_WAIT).sendKeys(firstName);
		elementUtils.waitForElementVisible(txtboxLastName, Constants.DEFAULT_WAIT).sendKeys(lastName);
		elementUtils.waitForElementVisible(txtboxPhoneNumber, Constants.DEFAULT_WAIT).sendKeys(phoneNumber);
		By xpathDemeanor = By.xpath("//span[contains(normalize-space(), '" + demeanor + "')]");
		elementUtils.waitForElementToBeClickable(xpathDemeanor, Constants.DEFAULT_WAIT).click();
	}

	public void doClickSameAsAboveAddress() {
		elementUtils.waitForElementToBeClickable(checkboxSameAsAboveAddress, Constants.DEFAULT_WAIT).click();
	}

	// Suspect Description
	public void doClickCollapseSuspectDescription() {
		elementUtils.waitForElementToBeClickable(btnCollapseSuspectDescription, Constants.DEFAULT_WAIT).click();
	}

	public void fillSuspectDescriptionForm(String name, String gender, String race, String hairType, String hairColor,
			String eyeColor, String height, String build, String weight, String age, String clothingWorn,
			String lastKnownDirection) throws InterruptedException {

		elementUtils.waitForElementVisible(txtboxSuspectName, Constants.DEFAULT_WAIT).sendKeys(name);
		elementUtils.doClickWithActionsAndWait(dropdownSuspectGender, Constants.DEFAULT_WAIT);
		By xpathGender = By.xpath("//div[@class='ant-select-item-option-content' and text()='" + gender + "']");
		elementUtils.waitForElementToBeClickable(xpathGender, Constants.DEFAULT_WAIT).click();

		elementUtils.doClickWithActionsAndWait(dropdownRace, Constants.DEFAULT_WAIT);
		By xpathRace = By.xpath("//div[@class='ant-select-item-option-content' and text()='" + race + "']");
		elementUtils.waitForElementToBeClickable(xpathRace, Constants.DEFAULT_WAIT).click();

		elementUtils.doClickWithActionsAndWait(dropdownHairType, Constants.DEFAULT_WAIT);
		By xpathHairType = By.xpath("//div[@class='ant-select-item-option-content' and text()='" + hairType + "']");
		elementUtils.waitForElementToBeClickable(xpathHairType, Constants.DEFAULT_WAIT).click();

		elementUtils.doClickWithActionsAndWait(dropdownHairColor, Constants.DEFAULT_WAIT);
		elementUtils.waitForElementVisible(dropdownHairColor, Constants.DEFAULT_WAIT).sendKeys(hairColor);
		elementUtils.pressEnterKey();
		elementUtils.doClickWithActionsAndWait(dropdownEyeColor, Constants.DEFAULT_WAIT);
		elementUtils.waitForElementVisible(dropdownEyeColor, Constants.DEFAULT_WAIT).sendKeys(eyeColor);
		elementUtils.pressEnterKey();

		elementUtils.doClickWithActionsAndWait(dropdownHeight, Constants.DEFAULT_WAIT);
		elementUtils.waitForElementVisible(dropdownHeight, Constants.DEFAULT_WAIT).sendKeys(height);
		elementUtils.pressEnterKey();

		elementUtils.doClickWithActionsAndWait(dropdownBuild, Constants.DEFAULT_WAIT);
		By xpathBuild = By.xpath("//div[@class='ant-select-item-option-content' and text()='" + build + "']");
		elementUtils.waitForElementToBeClickable(xpathBuild, Constants.DEFAULT_WAIT).click();

		elementUtils.waitForElementVisible(txtboxWeight, Constants.DEFAULT_WAIT).sendKeys(weight);
		elementUtils.waitForElementVisible(txtboxAge, Constants.DEFAULT_WAIT).sendKeys(age);
		elementUtils.waitForElementVisible(txtboxClothingWorn, Constants.DEFAULT_WAIT).sendKeys(clothingWorn);
		elementUtils.waitForElementVisible(txtboxLastKnownDirection, Constants.DEFAULT_WAIT)
				.sendKeys(lastKnownDirection);
	}

	public void fillCallDescription(String description) {
		elementUtils.waitForElementVisible(txtboxCallDescription, Constants.DEFAULT_WAIT).sendKeys(description);
	}

	public void selectAvailableUnits(String userId) throws InterruptedException {
		String userid = userId;
		By xpathUnit = By.xpath("//label[contains(normalize-space(), '" + userid + "')]");
		elementUtils.doClickWithActionsAndWait(xpathUnit, Constants.DEFAULT_WAIT);
	}

	public void doClickSaveAddNewCall() {
		elementUtils.waitForElementVisible(btnSaveAddNewCall, Constants.DEFAULT_WAIT);
		elementUtils.waitForElementToBeClickable(btnSaveAddNewCall, Constants.DEFAULT_WAIT).click();
	}

	public String getSuccessMessageText() {
		return elementUtils.waitForElementVisible(successMessage, Constants.DEFAULT_WAIT).getText();
	}
	
	public String getAssignedTo() {
		return elementUtils.waitForElementVisible(dataAssignedTo, Constants.DEFAULT_WAIT).getText();
	}

	public String getCallId() {
		return elementUtils.waitForElementVisible(dataCallId, Constants.DEFAULT_WAIT).getText();
	}

	public String getActivityCode() {
		return elementUtils.waitForElementVisible(dataActivityCode, Constants.DEFAULT_WAIT).getText();
	}

	public String getSite() {
		return elementUtils.waitForElementVisible(dataSite, Constants.DEFAULT_WAIT).getText();
	}

}
