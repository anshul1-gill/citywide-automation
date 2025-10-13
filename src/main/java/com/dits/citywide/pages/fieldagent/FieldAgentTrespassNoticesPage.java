package com.dits.citywide.pages.fieldagent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.dits.citywide.constants.Constants;
import com.dits.citywide.utilities.ElementUtils;

public class FieldAgentTrespassNoticesPage {

	private WebDriver driver;
	private ElementUtils elementUtils;

	public FieldAgentTrespassNoticesPage(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(driver);
	}

	// Locators for Trespass Notices page
	private By createNewTrespassNotice = By.id("new-trespass");
	private By txtboxSiteSearch = By.cssSelector("#site_search");

	private By getSiteNameLocator(String siteName) {
		return By.xpath(String.format("//div[contains(text(),'%s')]", siteName));
	}

	private By datetime = By.cssSelector("#notice_datetime");
	private By dropdownActivityCode = By.id("search_code");

	private By getStateLocator(String stateCode) {
		return By.xpath(String.format("//div[contains(text(),'%s')]", stateCode));
	}

	private By uploadFile = By.xpath("//input[@type='file']");
	private By txtboxFileName = By.cssSelector("#image_name_0");
	private By btnClear = By.xpath("(//button[normalize-space()='Clear'])[1]");
	private By searchData = By.cssSelector("input[placeholder='Search']");
	private By loader = By.xpath("//span[@class='ant-spin-dot ant-spin-dot-spin']");
	private By saveTrespassNotice = By.id("TrespassAdvisal");
	private By successMessage = By.cssSelector("#swal2-title>span");

	// Trespasser Details Locators
	private By txtPersonLastName = By.id("person_last_name");
	private By txtPersonMiddleInitial = By.id("person_middle_initial");
	private By txtPersonFirstName = By.id("person_first_name");
	private By txtPersonLicenseID = By.id("person_license_ID");
	private By dropdownPersonLicenseState = By.id("person_license_state");
	private By txtPersonLicenseExp = By.xpath("//label[normalize-space()='DL exp']/following-sibling::input");
	private By txtPersonAddressStreetNum = By.id("person_address_street_num");
	private By txtPersonAddressStreet = By.id("person_address_street");
	private By txtPersonAddressUnitNumber = By.id("person_address_unit_number");
	private By txtPersonAddressCity = By.id("person_address_city");
	private By dropdownPersonAddressState = By.id("person_address_state");
	private By txtPersonAddressZip = By.id("person_address_zip");

	private By txtboxVehicleYear = By.id("vehicle_year");
	private By txtboxVehicleMake = By.id("vehicle_make");
	private By txtboxVehicleModel = By.id("vehicle_model");
	private By txtboxVehicleColor = By.id("vehicle_color");
	private By txtboxVehiclePlate = By.id("vehicle_plate");
	private By dropdownVehicleState = By.id("vehicle_state");

	private By dropdownPersonGender = By.id("person_gender");
	private By dropdownPersonRace = By.id("person_race3");
	private By dropdownHairType = By.id("hair_type");
	private By dropdownPersonHair = By.id("person_hair");
	private By dropdownPersonEyes = By.id("person_eyes");
	private By dropdownPersonHeight = By.id("person_height");
	private By dropdownBuildType = By.id("build_type");
	private By txtPersonWeight = By.id("person_weight");

	// Method to click on Create New Trespass Notice button
	public void clickCreateNewTrespassNotice() {
		elementUtils.waitForElementVisible(createNewTrespassNotice, Constants.DEFAULT_WAIT).click();
	}

	// Locators for Location Details section
	private By txtReportStreetNum = By.id("report_street_num");
	private By txtReportStreet = By.id("report_street");
	private By txtReportUnitNumber = By.id("report_unit_number");
	private By txtReportCity = By.id("report_city");
	private By dropdownReportState = By.id("report_state");
	private By txtReportZip = By.id("report_zip");

	// Trespass Narrative section
	private By txtboxTresspassNarrative = By.id("notice_notes");

	private By getOptionLocator(String option) {
		return By.xpath(String.format("//label[normalize-space()='%s']", option));
	}

	private By txtboxRespondingAgency = By.id("responding_agency_name");
	private By txtboxTimeOfContact = By.id("time_of_contact");

	private By getDidTheyShowUpLocator(String option) {
		return By.xpath(String.format("(//label[normalize-space()='%s'])[2]", option));
	}

	private By txtboxPDOfficerName = By.cssSelector("input[id='`']");
	private By txtboxPDCaseNumber = By.id("pd_case_number");
	private By txtboxOfficerBadgeNumber = By.id("responding_agency_officer_badge_num");
	private By txtboxIncidentNumber = By.id("responding_agency_case_number");

	private By getWasPersonArrestedLocator(String option) {
		return By.xpath(String.format("(//label[normalize-space()='%s'])[3]", option));
	}

	// Delete
	private By txtboxCharge = By.cssSelector("#person_charges");

	private By getIncidentDeleteButtonLocator(String incidentNumber) {
		String xpath = String.format(
				"//a[normalize-space()='%s']/../following-sibling::td//button[@title='Delete Trespass']",
				incidentNumber);
		return By.xpath(xpath);
	}

	private By btnOk = By.xpath("//button[normalize-space()='OK']");
	private By sucessMessage = By.xpath("//div[@role='alert']/h2");

	// Update
	private By getIncidentEditButtonLocator(String incidentNumber) {
		String xpath = String.format(
				"//a[normalize-space()='%s']/../following-sibling::td//button[@title='Edit Trespass']", incidentNumber);
		return By.xpath(xpath);
	}

	// Data
	private By dataIncidentNumber = By.xpath("(//td[@data-label='Incident']/a)[1]");
	private By dataBranchName = By.xpath("(//td[@data-label='Branch'])[1]");
	private By dataOfficerName = By.xpath("(//td[@data-label='Officer'])[1]");
	private By dataSiteName = By.xpath("(//td[@data-label='Site'])[1]");
	private By dataPerson = By.xpath("(//td[@data-label='Person'])[1]");

	private By txtNoItemsFound = By.xpath("//span[contains(text(),'No items found.')]");

	// Fill Location Details section
	public void fillLocationDetails(String siteName, String dateTime, String activityCode, String streetNum,
			String streetName, String unitNumber, String city, String state, String zip) throws InterruptedException {
		elementUtils.waitForElementVisible(txtboxSiteSearch, Constants.DEFAULT_WAIT).sendKeys(siteName);
		elementUtils.waitForElementVisible(getSiteNameLocator(siteName), Constants.DEFAULT_WAIT).click();
		Thread.sleep(1000);
		elementUtils.waitForElementVisible(datetime, Constants.DEFAULT_WAIT).sendKeys(dateTime);
		// elementUtils.pressEscapeKey();
		Thread.sleep(1000);
		elementUtils.doSelectByValue(dropdownActivityCode, activityCode);
		elementUtils.waitForElementVisible(txtReportStreetNum, Constants.DEFAULT_WAIT).sendKeys(streetNum);
		elementUtils.waitForElementVisible(txtReportStreet, Constants.DEFAULT_WAIT).sendKeys(streetName);
		elementUtils.waitForElementVisible(txtReportUnitNumber, Constants.DEFAULT_WAIT).sendKeys(unitNumber);
		elementUtils.waitForElementVisible(txtReportCity, Constants.DEFAULT_WAIT).sendKeys(city);
		elementUtils.doSelectBy(dropdownReportState, state);
		elementUtils.waitForElementVisible(txtReportZip, Constants.DEFAULT_WAIT).sendKeys(zip);
	}

	// Fill Trespasser Details section
	public void fillTrespasserDetails(String firstName, String middleInitial, String lastName, String licenseID,
			String licenseState, String licenseExp, String addressStreetNum, String addressStreet,
			String addressUnitNumber, String addressCity, String addressState, String addressZip, String vehicleYear,
			String vehicleMake, String vehicleModel, String vehicleColor, String vehiclePlate, String vehicleState,
			String gender, String race, String hairType, String hair, String eyes, String height, String buildType,
			String weight) throws InterruptedException {
		elementUtils.waitForElementVisible(txtPersonFirstName, Constants.DEFAULT_WAIT).sendKeys(firstName);
		elementUtils.waitForElementVisible(txtPersonMiddleInitial, Constants.DEFAULT_WAIT).sendKeys(middleInitial);
		elementUtils.waitForElementVisible(txtPersonLastName, Constants.DEFAULT_WAIT).sendKeys(lastName);
		elementUtils.waitForElementVisible(txtPersonLicenseID, Constants.DEFAULT_WAIT).sendKeys(licenseID);
		elementUtils.waitForElementVisible(dropdownPersonLicenseState, Constants.DEFAULT_WAIT).sendKeys(licenseState);
		elementUtils.waitForElementVisible(txtPersonLicenseExp, Constants.DEFAULT_WAIT).sendKeys(licenseExp);
		elementUtils.waitForElementVisible(txtPersonAddressStreetNum, Constants.DEFAULT_WAIT)
				.sendKeys(addressStreetNum);
		elementUtils.waitForElementVisible(txtPersonAddressStreet, Constants.DEFAULT_WAIT).sendKeys(addressStreet);
		elementUtils.waitForElementVisible(txtPersonAddressUnitNumber, Constants.DEFAULT_WAIT)
				.sendKeys(addressUnitNumber);
		elementUtils.waitForElementVisible(txtPersonAddressCity, Constants.DEFAULT_WAIT).sendKeys(addressCity);
		elementUtils.doSelectBy(dropdownPersonAddressState, addressState);
		elementUtils.waitForElementVisible(txtPersonAddressZip, Constants.DEFAULT_WAIT).sendKeys(addressZip);

		elementUtils.waitForElementVisible(txtboxVehicleYear, Constants.DEFAULT_WAIT).sendKeys(vehicleYear);
		elementUtils.waitForElementVisible(txtboxVehicleMake, Constants.DEFAULT_WAIT).sendKeys(vehicleMake);
		elementUtils.waitForElementVisible(txtboxVehicleModel, Constants.DEFAULT_WAIT).sendKeys(vehicleModel);
		elementUtils.waitForElementVisible(txtboxVehicleColor, Constants.DEFAULT_WAIT).sendKeys(vehicleColor);
		elementUtils.waitForElementVisible(txtboxVehiclePlate, Constants.DEFAULT_WAIT).sendKeys(vehiclePlate);
		elementUtils.doSelectBy(dropdownVehicleState, vehicleState);

		elementUtils.waitForElementVisible(dropdownPersonGender, Constants.DEFAULT_WAIT).sendKeys(gender);
		elementUtils.waitForElementVisible(dropdownPersonRace, Constants.DEFAULT_WAIT).sendKeys(race);
		elementUtils.waitForElementVisible(dropdownHairType, Constants.DEFAULT_WAIT).sendKeys(hairType);
		elementUtils.waitForElementVisible(dropdownPersonHair, Constants.DEFAULT_WAIT).sendKeys(hair);
		elementUtils.waitForElementVisible(dropdownPersonEyes, Constants.DEFAULT_WAIT).sendKeys(eyes);
		elementUtils.waitForElementVisible(dropdownPersonHeight, Constants.DEFAULT_WAIT).sendKeys(height);
		elementUtils.waitForElementVisible(dropdownBuildType, Constants.DEFAULT_WAIT).sendKeys(buildType);
		elementUtils.waitForElementVisible(txtPersonWeight, Constants.DEFAULT_WAIT).sendKeys(weight);
	}

	// Fill Trespass Narrative section
	public void fillTrespassNarrative(String violationReason, String additionalDetails) {
		elementUtils.waitForElementVisible(txtboxTresspassNarrative, Constants.DEFAULT_WAIT).sendKeys(violationReason);
//		elementUtils.waitForElementVisible(getOptionLocator(additionalDetails), Constants.DEFAULT_WAIT).click();
//		elementUtils.waitForElementVisible(txtboxRespondingAgency, Constants.DEFAULT_WAIT)
//				.sendKeys("Police Department");
//		elementUtils.waitForElementVisible(txtboxTimeOfContact, Constants.DEFAULT_WAIT).sendKeys("09/09/2025 10:30");
//		elementUtils.waitForElementVisible(getDidTheyShowUpLocator("Yes"), Constants.DEFAULT_WAIT).click();
//		elementUtils.waitForElementVisible(txtboxPDOfficerName, Constants.DEFAULT_WAIT).sendKeys("Officer John");
//		elementUtils.waitForElementVisible(txtboxPDCaseNumber, Constants.DEFAULT_WAIT).sendKeys("PD12345");
//		elementUtils.waitForElementVisible(txtboxOfficerBadgeNumber, Constants.DEFAULT_WAIT).sendKeys("B123");
//		elementUtils.waitForElementVisible(txtboxIncidentNumber, Constants.DEFAULT_WAIT).sendKeys("IN12345");
//		elementUtils.waitForElementVisible(getWasPersonArrestedLocator("Yes"), Constants.DEFAULT_WAIT).click();
//		elementUtils.waitForElementVisible(txtboxCharge, Constants.DEFAULT_WAIT).sendKeys("Trespassing");
	}

	// Fill Trespass Advisal Images section
	public void fillTrespassAdvisalImages(String filePath) throws InterruptedException {
		if (filePath != null && !filePath.isEmpty()) {
			elementUtils.uploadFile(uploadFile, filePath);
			elementUtils.waitForElementVisible(txtboxFileName, Constants.DEFAULT_WAIT).sendKeys("Trespass Image");
		}
	}

	public void saveTrespassNotice() throws InterruptedException {
		elementUtils.waitForElementVisible(saveTrespassNotice, Constants.DEFAULT_WAIT).click();
		Thread.sleep(5000);
	}

	public boolean isClearButtonDisplayed() {
		return elementUtils.waitForElementVisible(btnClear, Constants.DEFAULT_WAIT).isDisplayed();
	}

	public void searchTrespassNotice(String employeeID) throws InterruptedException {
		elementUtils.waitForElementVisible(searchData, Constants.DEFAULT_WAIT).clear();
		elementUtils.waitForElementVisible(searchData, Constants.DEFAULT_WAIT).sendKeys(employeeID);
	}

	public void searchTrespassNoticeID(String trespassNoticeID) throws InterruptedException {
		elementUtils.waitForElementVisible(searchData, Constants.DEFAULT_WAIT).clear();
		elementUtils.waitForElementVisible(searchData, Constants.DEFAULT_WAIT).sendKeys(trespassNoticeID);
		elementUtils.waitForInvisibilityOfElementLocated(successMessage, Constants.DEFAULT_WAIT);
	}

	public String getIncidentNumber() {
		return elementUtils.waitForElementVisible(dataIncidentNumber, Constants.DEFAULT_WAIT).getText();
	}

	public String getBranchName() {
		return elementUtils.waitForElementVisible(dataBranchName, Constants.DEFAULT_WAIT).getText();
	}

	public String getOfficerName() {
		return elementUtils.waitForElementVisible(dataOfficerName, Constants.DEFAULT_WAIT).getText();
	}

	public String getSiteName() {
		return elementUtils.waitForElementVisible(dataSiteName, Constants.DEFAULT_WAIT).getText();
	}

	public String getPersonName() {
		return elementUtils.waitForElementVisible(dataPerson, Constants.DEFAULT_WAIT).getText();
	}

	public boolean isSearchBoxDisplayed() {
		return elementUtils.waitForElementVisible(searchData, Constants.DEFAULT_WAIT).isDisplayed();
	}

	public String isSuccessMessageDisplayed() {
		return elementUtils.waitForElementVisible(successMessage, Constants.DEFAULT_WAIT).getText();
	}

	// Delete Trespass Notice
	public void deleteParkingCitation(String incidentNumber) throws InterruptedException {
		elementUtils.waitForElementVisible(getIncidentDeleteButtonLocator(incidentNumber), Constants.DEFAULT_WAIT)
				.click();
		elementUtils.waitForElementVisible(btnOk, Constants.DEFAULT_WAIT).click();
	}

	public String getNoRecordFoundMessage() {
		return elementUtils.waitForElementVisible(txtNoItemsFound, Constants.DEFAULT_WAIT).getText();
	}

	// Update Trespass Notice
	public void clickOnEditButton(String incidentNumber) {
		elementUtils.waitForElementVisible(getIncidentEditButtonLocator(incidentNumber), Constants.DEFAULT_WAIT)
				.click();
		elementUtils.pressEnterKey();
	}

	public void updateLocationDetails(String siteName, String dateTime, String activityCode, String streetNum,
			String streetName, String unitNumber, String city, String state, String zip) throws InterruptedException {

		// Update Site
		elementUtils.clearTextBoxWithActions(txtboxSiteSearch);
		elementUtils.doActionsSendKeys(txtboxSiteSearch, siteName);
		elementUtils.waitForElementVisible(getSiteNameLocator(siteName), Constants.DEFAULT_WAIT).click();

		// Update Date/Time
//		elementUtils.clearTextBoxWithJS(datetime, Constants.DEFAULT_WAIT);
//		elementUtils.sendKeysUsingJavaScript(datetime, dateTime, Constants.DEFAULT_WAIT);
//		//elementUtils.pressEscapeKey();
//		Thread.sleep(1000);

		// Update Activity Code
		elementUtils.doSelectByValue(dropdownActivityCode, activityCode);

		// Update Street Number
		elementUtils.clearTextBoxWithActions(txtReportStreetNum);
		elementUtils.doActionsSendKeys(txtReportStreetNum, streetNum);

		// Update Street Name
		elementUtils.clearTextBoxWithActions(txtReportStreet);
		elementUtils.doActionsSendKeys(txtReportStreet, streetName);

		// Update Unit Number
		elementUtils.clearTextBoxWithActions(txtReportUnitNumber);
		elementUtils.doActionsSendKeys(txtReportUnitNumber, unitNumber);

		// Update City
		elementUtils.clearTextBoxWithActions(txtReportCity);
		elementUtils.doActionsSendKeys(txtReportCity, city);

		// Update State
		elementUtils.doSelectBy(dropdownReportState, state);

		// Update Zip
		elementUtils.clearTextBoxWithActions(txtReportZip);
		elementUtils.doActionsSendKeys(txtReportZip, zip);

		Thread.sleep(120000);
	}

	public void updateTrespasserDetails(String firstName, String middleInitial, String lastName, String licenseID,
			String licenseState, String licenseExp, String addressStreetNum, String addressStreet,
			String addressUnitNumber, String addressCity, String addressState, String addressZip, String vehicleYear,
			String vehicleMake, String vehicleModel, String vehicleColor, String vehiclePlate, String vehicleState,
			String gender, String race, String hairType, String hair, String eyes, String height, String buildType,
			String weight) throws InterruptedException {

		elementUtils.waitForInvisibilityOfElementLocated(loader, Constants.DEFAULT_WAIT);

		// Person Info
		elementUtils.clearTextBoxWithActions(txtPersonFirstName);
		elementUtils.doActionsSendKeys(txtPersonFirstName, firstName);

		elementUtils.clearTextBoxWithActions(txtPersonMiddleInitial);
		elementUtils.doActionsSendKeys(txtPersonMiddleInitial, middleInitial);

		elementUtils.clearTextBoxWithActions(txtPersonLastName);
		elementUtils.doActionsSendKeys(txtPersonLastName, lastName);

		elementUtils.clearTextBoxWithActions(txtPersonLicenseID);
		elementUtils.doActionsSendKeys(txtPersonLicenseID, licenseID);

		elementUtils.clearTextBoxWithActions(dropdownPersonLicenseState);
		elementUtils.doActionsSendKeys(dropdownPersonLicenseState, licenseState);

		elementUtils.clearTextBoxWithActions(txtPersonLicenseExp);
		elementUtils.doActionsSendKeys(txtPersonLicenseExp, licenseExp);

		// Address
		elementUtils.clearTextBoxWithActions(txtPersonAddressStreetNum);
		elementUtils.doActionsSendKeys(txtPersonAddressStreetNum, addressStreetNum);

		elementUtils.clearTextBoxWithActions(txtPersonAddressStreet);
		elementUtils.doActionsSendKeys(txtPersonAddressStreet, addressStreet);

		elementUtils.clearTextBoxWithActions(txtPersonAddressUnitNumber);
		elementUtils.doActionsSendKeys(txtPersonAddressUnitNumber, addressUnitNumber);

		elementUtils.clearTextBoxWithActions(txtPersonAddressCity);
		elementUtils.doActionsSendKeys(txtPersonAddressCity, addressCity);

		elementUtils.doSelectBy(dropdownPersonAddressState, addressState);

		elementUtils.clearTextBoxWithActions(txtPersonAddressZip);
		elementUtils.doActionsSendKeys(txtPersonAddressZip, addressZip);

		// Vehicle Info
		elementUtils.clearTextBoxWithActions(txtboxVehicleYear);
		elementUtils.doActionsSendKeys(txtboxVehicleYear, vehicleYear);

		elementUtils.clearTextBoxWithActions(txtboxVehicleMake);
		elementUtils.doActionsSendKeys(txtboxVehicleMake, vehicleMake);

		elementUtils.clearTextBoxWithActions(txtboxVehicleModel);
		elementUtils.doActionsSendKeys(txtboxVehicleModel, vehicleModel);

		elementUtils.clearTextBoxWithActions(txtboxVehicleColor);
		elementUtils.doActionsSendKeys(txtboxVehicleColor, vehicleColor);

		elementUtils.clearTextBoxWithActions(txtboxVehiclePlate);
		elementUtils.doActionsSendKeys(txtboxVehiclePlate, vehiclePlate);

		elementUtils.doSelectBy(dropdownVehicleState, vehicleState);

		// Person Characteristics
		elementUtils.clearTextBoxWithActions(dropdownPersonGender);
		elementUtils.doActionsSendKeys(dropdownPersonGender, gender);

		elementUtils.clearTextBoxWithActions(dropdownPersonRace);
		elementUtils.doActionsSendKeys(dropdownPersonRace, race);

		elementUtils.clearTextBoxWithActions(dropdownHairType);
		elementUtils.doActionsSendKeys(dropdownHairType, hairType);

		elementUtils.clearTextBoxWithActions(dropdownPersonHair);
		elementUtils.doActionsSendKeys(dropdownPersonHair, hair);

		elementUtils.clearTextBoxWithActions(dropdownPersonEyes);
		elementUtils.doActionsSendKeys(dropdownPersonEyes, eyes);

		elementUtils.clearTextBoxWithActions(dropdownPersonHeight);
		elementUtils.doActionsSendKeys(dropdownPersonHeight, height);

		elementUtils.clearTextBoxWithActions(dropdownBuildType);
		elementUtils.doActionsSendKeys(dropdownBuildType, buildType);

		elementUtils.clearTextBoxWithActions(txtPersonWeight);
		elementUtils.doActionsSendKeys(txtPersonWeight, weight);
	}

	public void updateTrespassNarrative(String violationReason, String additionalDetails) throws InterruptedException {

		elementUtils.waitForInvisibilityOfElementLocated(loader, Constants.DEFAULT_WAIT);

		// Violation Reason
		elementUtils.clearTextBoxWithActions(txtboxTresspassNarrative);
		elementUtils.doActionsSendKeys(txtboxTresspassNarrative, violationReason);

//	    // Additional Details (if dropdown or text-based)
//	    elementUtils.waitForElementVisible(getOptionLocator(additionalDetails), Constants.DEFAULT_WAIT).click();
//
//	    // Responding Agency
//	    elementUtils.clearTextBoxWithActions(txtboxRespondingAgency);
//	    elementUtils.doActionsSendKeys(txtboxRespondingAgency, "Police Department");
//
//	    // Time of Contact
//	    elementUtils.clearTextBoxWithJS(txtboxTimeOfContact, Constants.DEFAULT_WAIT);
//	    elementUtils.sendKeysUsingJavaScript(txtboxTimeOfContact, "09/09/2025 10:30", Constants.DEFAULT_WAIT);
//	    elementUtils.pressEscapeKey();
//
//	    // Did They Show Up
//	    elementUtils.waitForElementVisible(getDidTheyShowUpLocator("Yes"), Constants.DEFAULT_WAIT).click();
//
//	    // Officer Name
//	    elementUtils.clearTextBoxWithActions(txtboxPDOfficerName);
//	    elementUtils.doActionsSendKeys(txtboxPDOfficerName, "Officer John");
//
//	    // Case Number
//	    elementUtils.clearTextBoxWithActions(txtboxPDCaseNumber);
//	    elementUtils.doActionsSendKeys(txtboxPDCaseNumber, "PD12345");
//
//	    // Officer Badge Number
//	    elementUtils.clearTextBoxWithActions(txtboxOfficerBadgeNumber);
//	    elementUtils.doActionsSendKeys(txtboxOfficerBadgeNumber, "B123");
//
//	    // Incident Number
//	    elementUtils.clearTextBoxWithActions(txtboxIncidentNumber);
//	    elementUtils.doActionsSendKeys(txtboxIncidentNumber, "IN12345");
//
//	    // Was Person Arrested
//	    elementUtils.waitForElementVisible(getWasPersonArrestedLocator("Yes"), Constants.DEFAULT_WAIT).click();
//
//	    // Charge
//	    elementUtils.clearTextBoxWithActions(txtboxCharge);
//	    elementUtils.doActionsSendKeys(txtboxCharge, "Trespassing");
	}

}