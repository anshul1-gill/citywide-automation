package com.dits.citywide.pages.fieldagent;

import java.util.LinkedHashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.dits.citywide.constants.Constants;
import com.dits.citywide.utilities.ElementUtils;

public class FieldAgentFieldInterviewPage {

	private WebDriver driver;
	private ElementUtils elementUtils;

	private By btnAddNew = By.xpath("//span[normalize-space()='Add New Field Interview']");
	private By searchBox = By.cssSelector("input[placeholder='Search']");

	private By txtboxSiteSearch = By.xpath("//input[@id='site_id']");
	private By getSiteNameLocator(String siteName) {
		return By.xpath(String.format("//div[contains(text(),'%s')]", siteName));
	}
	
	private By DropdownCallId = By.xpath("//input[@id='call_id']");
	private By datetimeField = By.cssSelector("#interview_datetime");
	private By dropdownActivitycode = By.xpath("//input[@id='activity_code']");

	private By getStateLocator(String stateCode) {
		return By.xpath(String.format("//div[contains(text(),'%s')]", stateCode));
	}
	

	private By txtboxLastName = By.cssSelector("#person_last_name");
	private By txtboxMiddleName = By.cssSelector("#person_middle_initial");
	private By txtboxFirstName = By.cssSelector("#person_first_name");
	private By txtboxNickname = By.cssSelector("#person_nickname_aka");
	private By txtboxphoneNumber = By.xpath("(//input[@type='tel'])[1]");
	private By txtboxDlNumber = By.id("person_license_ID");
	private By dropdownState = By.id("person_license_state");
	private By slectOptionstate = By.xpath("//div[text()='CA']");

	// Address Details
	private By txtStreetNum = By.cssSelector("#street");
	private By txtStreetName = By.xpath("//input[@id='street_name']");
	private By txtUnitNum = By.xpath("//input[@id='apartment']");
	private By txtCity = By.xpath("//input[@id='city']");
	private By dropdownStateAddress = By.xpath("//input[@id='state']");
	private By slectOptionstatetwo = By.xpath("(//div[text()='CA'])[2]");
	private By txtZipCode = By.id("zipcode");

	// Residence Address Details
	
	private By txtResidenceStreetNum = By.id("person_address_street_num");
	private By txtResidenceStreetName = By.xpath("(//input[@id='person_address_street'])[1]");
	private By txtResidenceUnitNum = By.xpath("(//input[@id='person_address_unit_number'])[1]");
	private By txtResidenceCity = By.xpath("(//input[@id='person_address_city'])[1]");
	private By dropdownResidenceState = By.id("person_address_state");
	private By slectOptionstatethree = By.xpath("(//div[text()='CA'])[3]");
	private By txtResidenceZipCode = By.id("person_address_zip");

	// Person Details
	private By dropdownselectrace = By.id("person_race");
	private By dropdownselectgender = By.id("person_gender");
	private By dropdownselecthairtype = By.cssSelector("#hair_type");
	private By dropdownhaircolor = By.id("person_hair");
	private By dropdownEyes = By.id("person_eyes");
	private By dropdownHeight = By.id("person_height");
	private By dropdownBuild = By.cssSelector("#build_type");
	private By txtboxWeight = By.id("person_weight");
	private By dateDOB = By.id("person_dob");
	private By txtboxOddities = By.id("person_oddities_scars");
	private By txtboxClothingWorn = By.id("person_clothing_worn");

	// Vehicle Details
	private By txtboxVehiclePlatenumber = By.id("vehicle_license_number");
	private By dropwdownState = By.xpath("//input[@id='vehicle_license_state']");
	private By txtboxVehicleYear = By.id("vehicle_year");
	private By txtboxSelectMake = By.id("vehicle_make");

	private By getVehicleMakeLocator(String vehicleMake) {
		return By.xpath(String.format("//div[normalize-space(text())='%s']", vehicleMake));
	}

	private By txtboxSelectmodel = By.id("vehicle_model");
	private By txtCLR_1 = By.id("vehicle_color_primary");
	private By txtCLR_2 = By.id("vehicle_color_secondary");
	private By Dropdownvehicletype = By.id("vehicle_type");

	// Companion-0
	private By txtboxCompanionNmae = By.id("companion_0_companion_name");
	private By txtboxCompanionAddress = By.id("companion_0_companion_address");
	private By txtboxPhoneNumber = By.xpath("(//input[@value='+1'])[1]");
	private By txtboxWorkPhone = By.xpath("//label[@title='Work Phone']/following::input[@value='+1']");
	private By dropdownGender = By.cssSelector("input[id='companion_0_companion_gender']");
	private By dropdownRace = By.cssSelector("input[id='companion_0_companion_race']");
	private By dropdownhairtype = By.cssSelector("input[id='companion_0_companion_hair_type']");
	private By dropdownHairColorComp = By.cssSelector("input[id='companion_0_companion_hair']");
	private By dropdownEyesCompanion = By.cssSelector("#companion_0_companion_eyes");
	private By dropdownHeightCompanion = By.cssSelector("input[id='companion_0_companion_height']");
	private By dropdownBuildCompanion = By.cssSelector("input[id='companion_0_companion_height']");
	private By txtWeightCompanion = By.cssSelector("input[id='companion_0_companion_weight']");
	
	// Companion -1
	private By txtboxCompanionOneName = By.id("companion_1_companion_name");
	private By txtboxCompanionOneAddress = By.id("companion_1_companion_address");
	private By txtboxCompanionOnePhoneNumber = By.xpath("(//input[@value='+1'])[1]");
	private By txtboxCompanionOneWorkPhone = By.xpath("//label[@title='Work Phone']/following::input[@value='+1']");
	private By dropdownCompanionOneGender = By.cssSelector("input[id='companion_1_companion_gender']");
	private By dropdownCompanionOneRace = By.cssSelector("input[id='companion_1_companion_race']");
	private By dropdownCompanionOneHairType = By.cssSelector("input[id='companion_1_companion_hair_type']");
	private By dropdownCompanionOneHairColor = By.cssSelector("input[id='companion_1_companion_hair']");
	private By dropdownCompanionOneEyes = By.cssSelector("#companion_1_companion_eyes");
	private By dropdownCompanionOneHeight = By.cssSelector("input[id='companion_1_companion_height']");
	private By dropdownCompanionOneBuild = By.cssSelector("input[id='companion_1_companion_height']");
	private By txtCompanionOneWeight = By.cssSelector("input[id='companion_1_companion_weight']");

	// Report Description
	private By btnAddmore = By.xpath("//button[normalize-space()='Add more']");
	private By txtReportDescription = By.xpath("//textarea[@id='report_desc']");

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

	public void fillBasicDetails(
	        String siteName, String callId, String dateTime, String activityCode,
	        String lastName, String middleName, String firstName, String nickName,
	        String phoneNumber, String dlNumber, String state) throws InterruptedException {

	    // Search and select Site
	    elementUtils.waitForElementVisible(txtboxSiteSearch, Constants.DEFAULT_WAIT);
	    elementUtils.doSendKeys(txtboxSiteSearch, siteName);
	    elementUtils.waitForElementVisible(getSiteNameLocator(siteName), Constants.DEFAULT_WAIT);
	    elementUtils.safeClick(getSiteNameLocator(siteName));

	    // Select Call ID
	    elementUtils.waitForElementVisible(DropdownCallId, Constants.DEFAULT_WAIT);
	    elementUtils.doSendKeys(DropdownCallId, callId);
	    elementUtils.pressEnterKey(); // Simulates doclick after entering callId

	    // Date & Time
	    elementUtils.waitForElementVisible(datetimeField, Constants.DEFAULT_WAIT);
	    elementUtils.doSendKeys(datetimeField, dateTime);

	    // Activity Code
	    elementUtils.waitForElementVisible(dropdownActivitycode, Constants.DEFAULT_WAIT).sendKeys(activityCode);
	    elementUtils.safeClick(dropdownActivitycode);
	    elementUtils.waitForElementVisible(getStateLocator(activityCode), Constants.DEFAULT_WAIT);
	    elementUtils.safeClick(getStateLocator(activityCode));

	    // Personal detailss
	    elementUtils.doSendKeys(txtboxLastName, lastName);
	    elementUtils.doSendKeys(txtboxMiddleName, middleName);
	    elementUtils.doSendKeys(txtboxFirstName, firstName);
	    elementUtils.doSendKeys(txtboxNickname, nickName);
	    elementUtils.doSendKeys(txtboxphoneNumber, phoneNumber);
	    elementUtils.doSendKeys(txtboxDlNumber, dlNumber);
	    Thread.sleep(4000);
	    // State dropdown
	 // Open the State dropdown
	    elementUtils.waitForElementVisible(dropdownState, Constants.DEFAULT_WAIT);
	    elementUtils.safeClick(dropdownState);

	    // Select the option dynamically
	    elementUtils.waitForElementVisible(getStateLocator(state), Constants.DEFAULT_WAIT);
	    elementUtils.safeClick(getStateLocator(state));

	}


	public void fillAddressDetails(String streetNum, String streetName, String unitNum, String city, String state,
			String zipCode) throws InterruptedException {
		elementUtils.waitForElementVisible(txtStreetNum, Constants.DEFAULT_WAIT).sendKeys(streetNum);
		elementUtils.waitForElementVisible(txtStreetName, Constants.DEFAULT_WAIT).sendKeys(streetName);
		Thread.sleep(4000);
		elementUtils.waitForElementVisible(txtUnitNum, Constants.DEFAULT_WAIT).sendKeys(unitNum);
		Thread.sleep(4000);
		elementUtils.waitForElementVisible(txtCity, Constants.DEFAULT_WAIT).sendKeys(city);
		Thread.sleep(4000);
	    elementUtils.selectFromReactDropdown(dropdownStateAddress, state, 25);
		Thread.sleep(4000);
		elementUtils.waitForElementVisible(txtZipCode, Constants.DEFAULT_WAIT).sendKeys(zipCode);
		Thread.sleep(4000);
	}

	public void fillResidenceAddressDetails(String streetNum, String streetName, String unitNum, String city,
			String state, String zipCode) {
		elementUtils.waitForElementVisible(txtResidenceStreetNum, Constants.DEFAULT_WAIT).sendKeys(streetNum);
		elementUtils.waitForElementVisible(txtResidenceStreetName, Constants.DEFAULT_WAIT).sendKeys(streetName);
		elementUtils.waitForElementVisible(txtResidenceUnitNum, Constants.DEFAULT_WAIT).sendKeys(unitNum);
		elementUtils.waitForElementVisible(txtResidenceCity, Constants.DEFAULT_WAIT).sendKeys(city);
		elementUtils.selectFromReactDropdown(dropdownResidenceState, state , 25);
		elementUtils.waitForElementVisible(txtResidenceZipCode, Constants.DEFAULT_WAIT).sendKeys(zipCode);
	}

	public void fillPersonDetails(String race, String gender, String hairType, String hairColor, String eyes,
            String height, String build, String weight, String dob, 
            String oddities, String clothingWorn) throws InterruptedException {

// Wait briefly to ensure dropdowns are fully loaded
            Thread.sleep(2000);

// --- Handle all dropdowns in one loop ---
             Map<By, String> dropdownMap = new LinkedHashMap<>();
            dropdownMap.put(dropdownselectrace, race);
            dropdownMap.put(dropdownselectgender, gender);
            dropdownMap.put(dropdownselecthairtype, hairType);
             dropdownMap.put(dropdownhaircolor, hairColor);
            dropdownMap.put(dropdownEyes, eyes);
            dropdownMap.put(dropdownHeight, height);
            dropdownMap.put(dropdownBuild, build);

// Loop through each dropdown and select the correct value
for (Map.Entry<By, String> entry : dropdownMap.entrySet()) {
elementUtils.selectFromReactDropdown(entry.getKey(), entry.getValue(), Constants.DEFAULT_WAIT);
}

// --- Handle text fields ---
elementUtils.waitForElementVisible(txtboxWeight, Constants.DEFAULT_WAIT).clear();
elementUtils.waitForElementVisible(txtboxWeight, Constants.DEFAULT_WAIT).sendKeys(weight);

elementUtils.waitForElementVisible(dateDOB, Constants.DEFAULT_WAIT).clear();
elementUtils.waitForElementVisible(dateDOB, Constants.DEFAULT_WAIT).sendKeys(dob);

elementUtils.waitForElementVisible(txtboxOddities, Constants.DEFAULT_WAIT).clear();
elementUtils.waitForElementVisible(txtboxOddities, Constants.DEFAULT_WAIT).sendKeys(oddities);

elementUtils.waitForElementVisible(txtboxClothingWorn, Constants.DEFAULT_WAIT).clear();
elementUtils.waitForElementVisible(txtboxClothingWorn, Constants.DEFAULT_WAIT).sendKeys(clothingWorn);
Thread.sleep(5000);
	}



	public void fillVehicleDetails(String plateNumber, String state, String year, String make, String model,
	        String color1, String color2, String vehicleType) throws InterruptedException {

	    elementUtils.waitForElementVisible(txtboxVehiclePlatenumber, Constants.DEFAULT_WAIT).sendKeys(plateNumber);

	    // Select state (React dropdown)
	    elementUtils.selectFromReactDropdown(dropwdownState, state, 25);

	    elementUtils.waitForElementVisible(txtboxVehicleYear, Constants.DEFAULT_WAIT).sendKeys(year);

	    // Make
	    elementUtils.waitForElementVisible(txtboxSelectMake, Constants.DEFAULT_WAIT).sendKeys(make);
	    elementUtils.waitForElementVisible(getVehicleMakeLocator(make), Constants.DEFAULT_WAIT).click();

	    // Model
	    elementUtils.waitForElementVisible(txtboxSelectmodel, Constants.DEFAULT_WAIT).sendKeys(model);

	    // Colors
	    elementUtils.waitForElementVisible(txtCLR_1, Constants.DEFAULT_WAIT).sendKeys(color1);
	    elementUtils.waitForElementVisible(txtCLR_2, Constants.DEFAULT_WAIT).sendKeys(color2);

	    // Vehicle Type (React dropdown)
	    elementUtils.selectFromReactDropdown(Dropdownvehicletype, vehicleType, 25);
	}


	public void fillCompanionDetails(String name, String address, String phoneNumber, String workPhone, String gender,
	        String race, String hairType, String hairColor, String eyes, String height, String build, String weight)
	        throws InterruptedException {

	    // ----------------------------------------------------------------------
	    //                   COMPANION 1 DETAILS (companion_0_)
	    // ----------------------------------------------------------------------
	    elementUtils.waitForElementVisible(txtboxCompanionNmae, Constants.DEFAULT_WAIT).sendKeys(name);
	    elementUtils.waitForElementVisible(txtboxCompanionAddress, Constants.DEFAULT_WAIT).sendKeys(address);
	    Thread.sleep(4000);
	    elementUtils.waitForElementVisible(txtboxPhoneNumber, Constants.DEFAULT_WAIT).sendKeys(phoneNumber);
	    elementUtils.waitForElementVisible(txtboxWorkPhone, Constants.DEFAULT_WAIT).sendKeys(workPhone);
	    Thread.sleep(4000);

	    // Map for COMPANION 1 Dropdowns
	    Map<By, String> dropdownMap = new LinkedHashMap<>();
	    dropdownMap.put(dropdownGender, gender);
	    dropdownMap.put(dropdownRace, race);
	    dropdownMap.put(dropdownhairtype, hairType);
	    dropdownMap.put(dropdownHairColorComp, hairColor);
	    dropdownMap.put(dropdownEyesCompanion, eyes);
	    Thread.sleep(3000);
	    dropdownMap.put(dropdownHeightCompanion, height);
	    dropdownMap.put(dropdownBuildCompanion, build); // Removed intermediate Thread.sleep(2000)

	    // Loop for COMPANION 1
	    for (Map.Entry<By, String> entry : dropdownMap.entrySet()) {
	        elementUtils.selectFromReactDropdown(entry.getKey(), entry.getValue(), Constants.DEFAULT_WAIT);
	        Thread.sleep(2000); // small pause to stabilize UI if needed
	    }

	    elementUtils.waitForElementVisible(txtWeightCompanion, Constants.DEFAULT_WAIT).sendKeys(weight);
	    
	    elementUtils.waitForElementVisible(btnAddmore, Constants.DEFAULT_WAIT).click();


	    // ----------------------------------------------------------------------
	    //                   COMPANION 2 DETAILS (companion_1_)
	    // ----------------------------------------------------------------------
	    elementUtils.waitForElementVisible(txtboxCompanionOneName, Constants.DEFAULT_WAIT).sendKeys(name);
	    elementUtils.waitForElementVisible(txtboxCompanionOneAddress, Constants.DEFAULT_WAIT).sendKeys(address);
	    Thread.sleep(4000);
	    elementUtils.waitForElementVisible(txtboxCompanionOnePhoneNumber, Constants.DEFAULT_WAIT).sendKeys(phoneNumber);
	    elementUtils.waitForElementVisible(txtboxCompanionOneWorkPhone, Constants.DEFAULT_WAIT).sendKeys(workPhone);
	    Thread.sleep(4000); // Added back a pause after phone numbers

	    // Map for COMPANION 2 Dropdowns (Corrected name to dropdownMapTwo for clarity)
	    Map<By, String> dropdownMapTwo = new LinkedHashMap<>(); 
	    dropdownMapTwo.put(dropdownCompanionOneGender, gender);
	    dropdownMapTwo.put(dropdownCompanionOneRace, race);
	    dropdownMapTwo.put(dropdownCompanionOneHairType, hairType);
	    dropdownMapTwo.put(dropdownCompanionOneHairColor, hairColor);
	    dropdownMapTwo.put(dropdownCompanionOneEyes, eyes);
	    dropdownMapTwo.put(dropdownCompanionOneHeight, height);
	    dropdownMapTwo.put(dropdownCompanionOneBuild, build); // Removed intermediate Thread.sleep(4000)

	    // Loop for COMPANION 2
	    // *** FIX IS HERE: Loop over 'dropdownMapTwo' ***
	    for (Map.Entry<By, String> entry : dropdownMapTwo.entrySet()) { 
	        elementUtils.selectFromReactDropdown(entry.getKey(), entry.getValue(), Constants.DEFAULT_WAIT);
	        Thread.sleep(2000); // small pause to stabilize UI if needed
	    }

	    elementUtils.waitForElementVisible(txtCompanionOneWeight, Constants.DEFAULT_WAIT).sendKeys(weight);
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