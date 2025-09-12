package com.dits.citywide.pages.fieldagent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.dits.citywide.constants.Constants;
import com.dits.citywide.utilities.ElementUtils;

public class FieldAgentFieldInterviewPage {

	private WebDriver driver;
	private ElementUtils elementUtils;

	private By btnAddNew = By.xpath("//a[normalize-space()='Add New']");
	private By searchBox = By.cssSelector("input[placeholder='Search']");

	private By txtboxSiteSearch = By.xpath("//input[@id='site_search']");

	private By getSiteNameLocator(String siteName) {
		return By.xpath(String.format("//div[contains(text(),'%s')]", siteName));
	}

	private By datetimeField = By.cssSelector("#interview_datetime");
	private By dropdownActivitycode = By.cssSelector("input[role='combobox']");
	private By searchActivitycode = By.cssSelector("input[placeholder='Search...']");

	private By getStateLocator(String stateCode) {
		return By.xpath(String.format("//span[contains(text(),'%s')]", stateCode));
	}

	private By txtboxLastName = By.cssSelector("#person_last_name");
	private By txtboxMiddleName = By.cssSelector("#person_middle_initial");
	private By txtboxFirstName = By.cssSelector("#person_first_name");
	private By txtboxNickname = By.cssSelector("#person_nickname_aka");
	private By txtboxphoneNumber = By.id("person_phone_number");
	private By txtboxDlNumber = By.id("person_license_ID");
	private By dropdownState = By.id("person_license_state");

	// Address Details
	private By txtStreetNum = By.cssSelector("#street");
	private By txtStreetName = By.xpath("(//input[@id='person_address_street'])[1]");
	private By txtUnitNum = By.xpath("(//input[@id='person_address_unit_number'])[1]");
	private By txtCity = By.xpath("(//input[@id='person_address_city'])[1]");
	private By dropdownStateAddress = By.id("state");
	private By txtZipCode = By.id("zipcode");

	// Residence Address Details
	private By txtResidenceStreetNum = By.id("person_address_street_num");
	private By txtResidenceStreetName = By.xpath("(//input[@id='person_address_street'])[2]");
	private By txtResidenceUnitNum = By.xpath("(//input[@id='person_address_unit_number'])[2]");
	private By txtResidenceCity = By.xpath("(//input[@id='person_address_city'])[2]");
	private By dropdownResidenceState = By.id("person_address_state");
	private By txtResidenceZipCode = By.id("person_address_zip");

	// Person Details
	private By dropdownselectrace = By.id("person_race2");
	private By dropdownselectgender = By.id("person_gender");
	private By dropdownselecthairtype = By.cssSelector("#hair_type");
	private By dropdownhaircolor = By.id("person_hair");
	private By dropdownEyes = By.id("person_eyes");
	private By dropdownHeight = By.id("person_height");
	private By dropdownBuild = By.cssSelector("#build_type");
	private By txtboxWeight = By.id("person_weight");
	private By dateDOB = By.cssSelector("input[placeholder='MM/DD/YYYY']");
	private By txtboxOddities = By.id("person_oddities_scars");
	private By txtboxClothingWorn = By.id("person_clothing_worn");

	// Vehicle Details
	private By txtboxVehiclePlatenumber = By.id("vehicle_license_number");
	private By dropwdownState = By.id("vehicle_license_state");
	private By txtboxVehicleYear = By.id("ticket_vehicle_year");
	private By txtboxSelectMake = By.id("ticket_vehicle_make");

	private By getVehicleMakeLocator(String vehicleMake) {
		return By.xpath(String.format("//div[normalize-space(text())='%s']", vehicleMake));
	}

	private By txtboxSelectmodel = By.id("ticket_vehicle_model");
	private By txtCLR_1 = By.id("vehicle_color_primary");
	private By txtCLR_2 = By.id("vehicle_color_secondary");
	private By Dropdownvehicletype = By.id("vehicle_type");

	// Companion-1
	private By txtboxCompanionNmae = By.id("companion_arr.0.name");
	private By txtboxCompanionAddress = By.id("companion_arr.0.address");
	private By txtboxPhoneNumber = By.cssSelector("input[id='companion_arr.0.phone']");
	private By txtboxWorkPhone = By.cssSelector("input[id='companion_arr.0.phone_work']");
	private By dropdownGender = By.cssSelector("select[id='companion_arr.0.gender']");
	private By dropdownRace = By.cssSelector("select[id='companion_arr.0.race']");
	private By dropdownhairtype = By.cssSelector("select[id='companion_arr.0.hair_type']");
	private By dropdownHairColorComp = By.cssSelector("select[id='companion_arr.0.hair']");
	private By dropdownEyesCompanion = By.cssSelector("#companion_eyes");
	private By dropdownHeightCompanion = By.cssSelector("select[id='companion_arr.0.height']");
	private By dropdownBuildCompanion = By.cssSelector("select[id='companion_arr.0.build_type']");
	private By txtWeightCompanion = By.cssSelector("input[id='companion_arr.0.weight']");

	// Report Description
	private By txtReportDescription = By.id("report_desc");

	// Crime Potentials
	private By dropdownCrimePotential = By.id("crime_potential_1");
	private By dropdownCrimePotentialtwo = By.id("crime_potential_2");

	private By uploadImage = By.xpath("//input[@type='file']");
	private By txtboxFileName = By.cssSelector("#image_name_0");

	// save field Interview
	private By btnSaveFieldInterview = By.cssSelector("#storeReportFieldInterview");
	private By btnClear = By.xpath("//button[normalize-space()='Clear']");

	// Data
	private By dataIncidentNumber = By.xpath("(//td[@data-label='Incident']/a)[1]");
	private By dataOfficerName = By.xpath("(//td[@data-label='Officer'])[1]");
	private By dataSiteName = By.xpath("(//td[@data-label='Site'])[1]");
	private By dataPersonName = By.xpath("(//td[@data-label='Person'])[1]");
	private By dataArrested = By.xpath("(//td[@data-label='Arrested'])[1]");

	// Delete
	private By getdeleteFieldInterviewDeleteButtonLocator(String incidentNumber) {
		String xpath = String.format(
				"//a[normalize-space()='%s']/../following-sibling::td//button[@title='Delete Field Interview']",
				incidentNumber);
		return By.xpath(xpath);
	}

	private By btnOk = By.xpath("//button[normalize-space()='OK']");
	private By sucessMessage = By.xpath("//div[@role='alert']/h2");

	public FieldAgentFieldInterviewPage(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(driver);
	}

	public void clickOnAddNew() {
		elementUtils.waitForElementVisible(btnAddNew, Constants.DEFAULT_WAIT).click();
	}

	public void searchFieldInterview(String searchText) throws InterruptedException {
		elementUtils.waitForElementVisible(searchBox, Constants.DEFAULT_WAIT).sendKeys(searchText);
		Thread.sleep(4000);
	}

	public void fillBasicDetails(String siteName, String dateTime, String activityCode, String lastName,
			String middleName, String firstName, String nickName, String phoneNumber, String dlNumber, String state)
			throws InterruptedException {
		elementUtils.waitForElementVisible(txtboxSiteSearch, Constants.DEFAULT_WAIT).sendKeys(siteName);
		elementUtils.waitForElementVisible(getSiteNameLocator(siteName), Constants.DEFAULT_WAIT).click();
		Thread.sleep(1000);
		elementUtils.waitForElementVisible(datetimeField, Constants.DEFAULT_WAIT).sendKeys(dateTime);
		Thread.sleep(2000);
		elementUtils.waitForElementVisible(dropdownActivitycode, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementVisible(searchActivitycode, Constants.DEFAULT_WAIT).sendKeys(activityCode);
		elementUtils.waitForElementVisible(getStateLocator(activityCode), Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementVisible(txtboxLastName, Constants.DEFAULT_WAIT).sendKeys(lastName);
		elementUtils.waitForElementVisible(txtboxMiddleName, Constants.DEFAULT_WAIT).sendKeys(middleName);
		elementUtils.waitForElementVisible(txtboxFirstName, Constants.DEFAULT_WAIT).sendKeys(firstName);
		elementUtils.waitForElementVisible(txtboxNickname, Constants.DEFAULT_WAIT).sendKeys(nickName);
		elementUtils.waitForElementVisible(txtboxphoneNumber, Constants.DEFAULT_WAIT).sendKeys(phoneNumber);
		elementUtils.waitForElementVisible(txtboxDlNumber, Constants.DEFAULT_WAIT).sendKeys(dlNumber);
		elementUtils.doSelectBy(dropdownState, state);
	}

	public void fillAddressDetails(String streetNum, String streetName, String unitNum, String city, String state,
			String zipCode) {
		elementUtils.waitForElementVisible(txtStreetNum, Constants.DEFAULT_WAIT).sendKeys(streetNum);
		elementUtils.waitForElementVisible(txtStreetName, Constants.DEFAULT_WAIT).sendKeys(streetName);
		elementUtils.waitForElementVisible(txtUnitNum, Constants.DEFAULT_WAIT).sendKeys(unitNum);
		elementUtils.waitForElementVisible(txtCity, Constants.DEFAULT_WAIT).sendKeys(city);
		elementUtils.doSelectBy(dropdownStateAddress, state);
		elementUtils.waitForElementVisible(txtZipCode, Constants.DEFAULT_WAIT).sendKeys(zipCode);
	}

	public void fillResidenceAddressDetails(String streetNum, String streetName, String unitNum, String city,
			String state, String zipCode) {
		elementUtils.waitForElementVisible(txtResidenceStreetNum, Constants.DEFAULT_WAIT).sendKeys(streetNum);
		elementUtils.waitForElementVisible(txtResidenceStreetName, Constants.DEFAULT_WAIT).sendKeys(streetName);
		elementUtils.waitForElementVisible(txtResidenceUnitNum, Constants.DEFAULT_WAIT).sendKeys(unitNum);
		elementUtils.waitForElementVisible(txtResidenceCity, Constants.DEFAULT_WAIT).sendKeys(city);
		elementUtils.doSelectBy(dropdownResidenceState, state);
		elementUtils.waitForElementVisible(txtResidenceZipCode, Constants.DEFAULT_WAIT).sendKeys(zipCode);
	}

	public void fillPersonDetails(String race, String gender, String hairType, String hairColor, String eyes,
			String height, String build, String weight, String dob, String oddities, String clothingWorn)
			throws InterruptedException {
		Thread.sleep(2000);
		elementUtils.doSelectBy(dropdownselectrace, race);
		elementUtils.doSelectBy(dropdownselectgender, gender);
		elementUtils.doSelectBy(dropdownselecthairtype, hairType);
		elementUtils.doSelectBy(dropdownhaircolor, hairColor);
		elementUtils.doSelectBy(dropdownEyes, eyes);
		elementUtils.doSelectBy(dropdownHeight, height);
		elementUtils.doSelectBy(dropdownBuild, build);
		elementUtils.waitForElementVisible(txtboxWeight, Constants.DEFAULT_WAIT).sendKeys(weight);
		elementUtils.waitForElementVisible(dateDOB, Constants.DEFAULT_WAIT).sendKeys(dob);
		elementUtils.waitForElementVisible(txtboxOddities, Constants.DEFAULT_WAIT).sendKeys(oddities);
		elementUtils.waitForElementVisible(txtboxClothingWorn, Constants.DEFAULT_WAIT).sendKeys(clothingWorn);
	}

	public void fillVehicleDetails(String plateNumber, String state, String year, String make, String model,
			String color1, String color2, String vehicleType) throws InterruptedException {
		elementUtils.waitForElementVisible(txtboxVehiclePlatenumber, Constants.DEFAULT_WAIT).sendKeys(plateNumber);
		elementUtils.doSelectBy(dropwdownState, state);
		elementUtils.waitForElementVisible(txtboxVehicleYear, Constants.DEFAULT_WAIT).sendKeys(year);
		elementUtils.waitForElementVisible(txtboxSelectMake, Constants.DEFAULT_WAIT).sendKeys(make);
		elementUtils.waitForElementVisible(getVehicleMakeLocator(make), Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementVisible(txtboxSelectmodel, Constants.DEFAULT_WAIT).sendKeys(model);
		elementUtils.waitForElementVisible(txtCLR_1, Constants.DEFAULT_WAIT).sendKeys(color1);
		elementUtils.waitForElementVisible(txtCLR_2, Constants.DEFAULT_WAIT).sendKeys(color2);
		elementUtils.doSelectBy(Dropdownvehicletype, vehicleType);
	}

	public void fillCompanionDetails(String name, String address, String phoneNumber, String workPhone, String gender,
			String race, String hairType, String hairColor, String eyes, String height, String build, String weight)
			throws InterruptedException {
		elementUtils.waitForElementVisible(txtboxCompanionNmae, Constants.DEFAULT_WAIT).sendKeys(name);
		elementUtils.waitForElementVisible(txtboxCompanionAddress, Constants.DEFAULT_WAIT).sendKeys(address);
		elementUtils.waitForElementVisible(txtboxPhoneNumber, Constants.DEFAULT_WAIT).sendKeys(phoneNumber);
		elementUtils.waitForElementVisible(txtboxWorkPhone, Constants.DEFAULT_WAIT).sendKeys(workPhone);
		elementUtils.doSelectBy(dropdownGender, gender);
		elementUtils.doSelectBy(dropdownRace, race);
		elementUtils.doSelectBy(dropdownhairtype, hairType);
		elementUtils.doSelectBy(dropdownHairColorComp, hairColor);
		elementUtils.doSelectBy(dropdownEyesCompanion, eyes);
		elementUtils.doSelectBy(dropdownHeightCompanion, height);
		elementUtils.doSelectBy(dropdownBuildCompanion, build);
		elementUtils.waitForElementVisible(txtWeightCompanion, Constants.DEFAULT_WAIT).sendKeys(weight);
	}

	public void fillReportDescription(String reportDescription) {
		elementUtils.waitForElementVisible(txtReportDescription, Constants.DEFAULT_WAIT).sendKeys(reportDescription);
	}

	public void fillCrimePotentials(String crimePotential1, String crimePotential2) throws InterruptedException {
		elementUtils.doSelectBy(dropdownCrimePotential, crimePotential1);
		Thread.sleep(1000);
		elementUtils.doSelectBy(dropdownCrimePotentialtwo, crimePotential2);
	}

	public void fillTrespassAdvisalImages(String filePath) throws InterruptedException {
		if (filePath != null && !filePath.isEmpty()) {
			elementUtils.uploadFile(uploadImage, filePath);
			elementUtils.waitForElementVisible(txtboxFileName, Constants.DEFAULT_WAIT).sendKeys("Trespass Image");
		}
	}

	public boolean isClearButtonDisplayed() {
		return elementUtils.waitForElementVisible(btnClear, Constants.DEFAULT_WAIT).isDisplayed();
	}

	public void saveFieldInterview() throws InterruptedException {
		elementUtils.waitForElementVisible(btnSaveFieldInterview, Constants.DEFAULT_WAIT).click();
		Thread.sleep(5000);
	}

	// Data Validation
	public String getIncidentNumber() {
		return elementUtils.waitForElementVisible(dataIncidentNumber, Constants.DEFAULT_WAIT).getText();
	}

	public String getOfficerName() {
		return elementUtils.waitForElementVisible(dataOfficerName, Constants.DEFAULT_WAIT).getText();
	}

	public String getSiteName() {
		return elementUtils.waitForElementVisible(dataSiteName, Constants.DEFAULT_WAIT).getText();
	}

	public String getPersonName() {
		return elementUtils.waitForElementVisible(dataPersonName, Constants.DEFAULT_WAIT).getText();
	}

	public String getArrested() {
		return elementUtils.waitForElementVisible(dataArrested, Constants.DEFAULT_WAIT).getText();
	}

	public boolean isSearchBoxDisplayed() {
		return elementUtils.waitForElementVisible(searchBox, Constants.DEFAULT_WAIT).isDisplayed();
	}

	// Delete Field Interview
	public void deleteFieldInterview(String incidentNumber) throws InterruptedException {
		elementUtils.waitForElementVisible(getdeleteFieldInterviewDeleteButtonLocator(incidentNumber),
				Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementVisible(btnOk, Constants.DEFAULT_WAIT).click();
	}

	public String getSucessMessage() {
		return elementUtils.waitForElementVisible(sucessMessage, Constants.DEFAULT_WAIT).getText();
	}

}