package com.dits.citywide.pages.fieldagent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.dits.citywide.constants.Constants;
import com.dits.citywide.utilities.ElementUtils;

public class FieldAgentParkingCitationPage {

	private WebDriver driver;
	private ElementUtils elementUtils;

	// Locators
	private By createnewParkingCitation = By.xpath("//button[normalize-space()='Add New Citation']");

	private By txtboxsiteSearch = By.cssSelector("#site_id");

	private By getSiteNameLocator(String siteName) {
		return By.xpath(String.format("//div[contains(text(),'%s')]", siteName));
	}

	private By datetime = By.cssSelector("#notice_datetime");
	private By dropdownactivitycodeValue = By.id("activity_code");
	private By txtboxVin = By.id("ticket_vin");
	private By txtboxLicenseNumber = By.id("ticket_license_number");
	private By dropdownselectState = By.id("ticket_license_state");

	private By getStateLocator(String state) {
		return By.xpath(String.format("//div[contains(text(),'%s')]", state));
	}

	private By txtboxExpireDate = By.cssSelector("#ticket_license_expire_date");
	private By dropdownSelectColor = By.id("ticket_vehicle_color");
	private By txtboxYear = By.cssSelector("#ticket_vehicle_year");
	private By txtboxSelectMake = By.id("ticket_vehicle_make");

	private By getVehicleNameLocator(String vehicleName) {
		return By.xpath(String.format("//div[contains(text(),'%s')]", vehicleName));
	}

	private By txtboxSelectmodel = By.id("ticket_vehicle_model");

	private By dropdownSelectViolation = By.id("vehicle_violation");
	private By txtboxAdditionalDetails = By.id("ticket_added_details");

	private By dropdownViolation = By.id("vehicle_violation");
	private By txtadditionalDetails = By.id("ticket_added_details");
	private By uploadFile = By.xpath("//input[@type='file']");
	private By buttnOk = By.xpath("//button[normalize-space()='OK']");
	private By txtboxFileName = By.cssSelector("#Name0");
	
	private By btnScanUpdate = By.xpath("//button[normalize-space()='Scan And Update']");
	
	

	// Impounded Fields
	private By btnShowImpoundedFields = By.xpath("//button[normalize-space()='Show Impounded Fields']"); 
	private By txtboxImpoundedDateandTime = By.xpath("//input[@id='ticket_impound_datetime']");
	private By txtboxTowingCompany = By.cssSelector("#ticket_towing_company");

	private By saveParkingCitation = By.cssSelector("#parkingCitation");
	private By btnClear = By.xpath("(//button[normalize-space()='Clear'])[1]");

	private By searchData = By.cssSelector("input[placeholder='Search']");

	// Data validation
	private By dataIncidentNumber = By.xpath("(//td[@data-label='Incident'])[1]/a");
	private By dataOfficerName = By.xpath("(//td[@data-label='Officer'])[1]");
	private By dataSiteName = By.xpath("(//td[@data-label='Site'])[1]/a");
	private By dataVehicle = By.xpath("(//td[@data-label='Vehicle'])[1]");
	private By dataLicenseNo = By.xpath("(//td[@data-label='License'])[1]");
	private By dataVehicleViolation = By.xpath("(//td[@data-label='Vehicle violation'])[1]");
	private By dataImpound = By.xpath("(//td[@data-label='Impound'])[1]");
	private By dataNoticeDate = By.xpath("(//td[@data-label='Notice Date'])[1]");

	private By loader = By.xpath("//span[@class='ant-spin-dot ant-spin-dot-spin']");

	// Delete
	private By getIncidentDeleteButtonLocator(String incidentNumber) {
		String xpath = String.format(
				"//a[normalize-space()='%s']/../following-sibling::td//button[@title='Delete Citation']",
				incidentNumber);
		return By.xpath(xpath);
	}

	// private By btnDelete =
	// By.xpath("//div[@class='action-option']/button[@title='Delete Citation']");
	private By btnOk = By.xpath("//button[normalize-space()='OK']");
	private By sucessMessage = By.xpath("//div[@role='alert']/h2");

	// Update
	private By getIncidentEditButtonLocator(String incidentNumber) {
		String xpath = String.format(
				"//a[normalize-space()='%s']/../following-sibling::td//button[@title='Edit Citation']", incidentNumber);
		return By.xpath(xpath);
	}

	private By txtHeaderEditParkingCitation = By
			.xpath("//div[@class='breadcrumbs']//li[normalize-space()='Edit Parking Citation']");
	private By dropdownactivitycode = By.cssSelector("input[role='combobox']");
	private By searchActivityCode = By.cssSelector("input[placeholder='Search...']");

	private By getActivityCodeLocator(String code) {
		return By.xpath(String.format("//span[contains(text(),'%s')]", code));
	}

	public FieldAgentParkingCitationPage(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(driver);
	}

	public void clickCreateNewParkingCitation() {
		elementUtils.waitForElementVisible(createnewParkingCitation, Constants.DEFAULT_WAIT).click();
	}

	public void fillParkingCitationForm(String sitename, String dateTime, String activityCode, String vinNumber,
	        String licenseNo, String selectState, String expireDate, String vehicleColor, String year,
	        String vehicleMake, String vehicleModel, String violation, String additionalDetails)
	        throws InterruptedException {

	    // 1. Site Search and Selection
	    elementUtils.waitForElementVisible(txtboxsiteSearch, Constants.DEFAULT_WAIT).sendKeys(sitename);
	    elementUtils.waitForElementVisible(getSiteNameLocator(sitename), Constants.DEFAULT_WAIT).click();

	    // 2. Date/Time and Activity Code
	    elementUtils.waitForElementVisible(datetime, Constants.DEFAULT_WAIT).sendKeys(dateTime);
	    elementUtils.pressEscapeKey();
	    
	    Thread.sleep(5000);
	    // Activity Code using Actions Class
	    WebElement activityCodeDropdown = elementUtils.waitForElementVisible(dropdownactivitycodeValue, Constants.DEFAULT_WAIT);
	    Actions actions = new Actions(driver); // Assuming 'driver' is accessible
	    actions.moveToElement(activityCodeDropdown)
	           .click()
	           .sendKeys(activityCode)
	           .pause(Duration.ofMillis(500)) 
	           .sendKeys(Keys.DOWN)
	           .sendKeys(Keys.ENTER)
	           .build()
	           .perform();

	    // 3. Vehicle Identification
	    Thread.sleep(4000);
	    elementUtils.waitForElementVisible(txtboxVin, Constants.DEFAULT_WAIT).sendKeys(vinNumber);
	    Thread.sleep(4000);
	    elementUtils.waitForElementVisible(txtboxLicenseNumber, Constants.DEFAULT_WAIT).sendKeys(licenseNo);
	    Thread.sleep(4000);
	    // 4. State Selection (Auto-complete pattern)
	    elementUtils.waitForElementVisible(dropdownselectState, Constants.DEFAULT_WAIT).sendKeys(selectState);
	    Thread.sleep(4000);
	    elementUtils.waitForElementVisible(getStateLocator(selectState), Constants.DEFAULT_WAIT).click();
	    
	    // 5. Vehicle Details
	    elementUtils.waitForElementVisible(txtboxExpireDate, Constants.DEFAULT_WAIT).sendKeys(expireDate);
	    
	    // --- REPLACED doSelectBy with selectFromReactDropdown for Color ---
	    WebElement colorDropdown = elementUtils.waitForElementVisible(dropdownSelectColor, Constants.DEFAULT_WAIT);

	    // Reuse the existing Actions object if possible, or create a new one.
	    // For simplicity and coherence, we'll continue the sequence.
	    actions = new Actions(driver); // Reinitialize/reuse the actions object
	    actions.moveToElement(colorDropdown)
	           .click()
	           .sendKeys(vehicleColor) // Uses the dynamic variable (e.g., "Red")
	           .pause(Duration.ofMillis(500)) // Pause for suggestions to appear
	           .sendKeys(Keys.DOWN)
	           .sendKeys(Keys.ENTER)
	           .build()
	           .perform();
	    // -------------------

	    elementUtils.waitForElementVisible(txtboxYear, Constants.DEFAULT_WAIT).sendKeys(year);

	    // 6. Vehicle Make (Auto-complete pattern)
	    elementUtils.waitForElementVisible(txtboxSelectMake, Constants.DEFAULT_WAIT).sendKeys(vehicleMake);
	    elementUtils.waitForElementVisible(getVehicleNameLocator(vehicleMake), Constants.DEFAULT_WAIT).click();

	    // 7. Vehicle Model (Auto-complete pattern)
	    elementUtils.waitForElementVisible(txtboxSelectmodel, Constants.DEFAULT_WAIT).sendKeys(vehicleModel);
	    elementUtils.waitForElementVisible(getVehicleNameLocator(vehicleModel), Constants.DEFAULT_WAIT).click();

	    // --- REPLACED doSelectBy with selectFromReactDropdown for Violation ---
	    WebElement violationDropdown = elementUtils.waitForElementVisible(dropdownViolation, Constants.DEFAULT_WAIT);
	    actions = new Actions(driver);
	    actions.moveToElement(violationDropdown)
	           .click()
	           .sendKeys(violation)
	           .pause(Duration.ofMillis(500)) // Pause for suggestions to appear
	           .sendKeys(Keys.DOWN)
	           .sendKeys(Keys.ENTER)
	           .build()
	           .perform();

	    // 8. Violation and Details
	    elementUtils.waitForElementVisible(txtadditionalDetails, Constants.DEFAULT_WAIT).sendKeys(additionalDetails);
	}
	
	
	public void clickOnImpoundedFields() {
		elementUtils.waitForElementVisible(btnShowImpoundedFields, Constants.DEFAULT_WAIT).click();
	}

	public void fillImpoundedFields(String dateTime, String towingCompany) {
		elementUtils.sendKeysUsingJavaScript(txtboxImpoundedDateandTime, dateTime, Constants.DEFAULT_WAIT);
		elementUtils.waitForElementVisible(txtboxTowingCompany, Constants.DEFAULT_WAIT).sendKeys(towingCompany);
	}

	public void parkingCitationImagesUpload(String filePath) throws InterruptedException {
		if (filePath != null && !filePath.isEmpty()) {
			elementUtils.uploadFile(uploadFile, filePath);
			
			Thread.sleep(3000);
			elementUtils.waitForElementVisible(buttnOk, Constants.DEFAULT_WAIT).click();
			elementUtils.waitForElementVisible(txtboxFileName, Constants.DEFAULT_WAIT).sendKeys("Trespass Image");
		}
	}
	
	public void ScanandUpdatebutton() {
		elementUtils.waitForElementVisible(btnScanUpdate, Constants.DEFAULT_WAIT).click();
	}
	
	
	public void saveParkingCitation() {
		elementUtils.waitForElementVisible(saveParkingCitation, Constants.DEFAULT_WAIT).click();
	}

	public boolean isClearButtonDisplayed() {
		return elementUtils.waitForElementVisible(btnClear, Constants.DEFAULT_WAIT).isDisplayed();
	}

	public void clearForm() {
		elementUtils.waitForElementVisible(btnClear, Constants.DEFAULT_WAIT).click();
	}

	public boolean isSearchBoxDisplayed() {
		return elementUtils.waitForElementVisible(searchData, Constants.DEFAULT_WAIT).isDisplayed();
	}

	public void searchParkingCitation(String licenseNo) {
		elementUtils.waitForInvisibilityOfElementLocated(loader, Constants.DEFAULT_WAIT);
		elementUtils.waitForElementVisible(searchData, Constants.DEFAULT_WAIT).sendKeys(licenseNo);
	}

	public String getIncidentNumber() {
		return elementUtils.waitForElementVisible(dataIncidentNumber, Constants.DEFAULT_WAIT).getText();
	}

	public String getOfficerName() {
		elementUtils.waitForInvisibilityOfElementLocated(loader, Constants.DEFAULT_WAIT);
		return elementUtils.waitForElementVisible(dataOfficerName, Constants.DEFAULT_WAIT).getText();
	}

	public String getSiteName() {
		return elementUtils.waitForElementVisible(dataSiteName, Constants.DEFAULT_WAIT).getText();
	}

	public String getVehicle() {
		return elementUtils.waitForElementVisible(dataVehicle, Constants.DEFAULT_WAIT).getText();
	}

	public String getLicenseNo() {
		return elementUtils.waitForElementVisible(dataLicenseNo, Constants.DEFAULT_WAIT).getText();
	}

	public String getVehicleViolation() {
		return elementUtils.waitForElementVisible(dataVehicleViolation, Constants.DEFAULT_WAIT).getText();
	}

	public boolean isSucessMessageDispalyed() {
		return elementUtils.doIsDisplayed(sucessMessage, Constants.DEFAULT_WAIT);
	}

	// Delete Parking Citation

	public void deleteParkingCitation(String incidentNumber) throws InterruptedException {
		elementUtils.waitForElementVisible(getIncidentDeleteButtonLocator(incidentNumber), Constants.DEFAULT_WAIT)
				.click();
		// elementUtils.waitForElementVisible(btnDelete,
		// Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementVisible(btnOk, Constants.DEFAULT_WAIT).click();
	}

	public boolean isDeleteSuccessMessageDisplayed() {
		return elementUtils.doIsDisplayed(sucessMessage, Constants.DEFAULT_WAIT);
	}

	// Update Parking Citation

	public void clickOnEditButton(String incidentNumber) throws InterruptedException {
		elementUtils.waitForElementVisible(getIncidentEditButtonLocator(incidentNumber), Constants.DEFAULT_WAIT)
				.click();
	}

	public boolean isEditParkingCitationHeaderDisplayed() {
		return elementUtils.doIsDisplayed(txtHeaderEditParkingCitation, Constants.DEFAULT_WAIT);
	}

	public void updateParkingCitation(String sitename, String dateTime, String activityCode, String vinNumber,
			String licenseNo, String selectState, String expireDate, String vehicleColor, String year,
			String vehicleMake, String vehicleModel, String violation, String additionalDetails, String filePath)
			throws InterruptedException {
		elementUtils.waitForInvisibilityOfElementLocated(loader, Constants.DEFAULT_WAIT);
		elementUtils.clearTextBoxWithActions(txtboxsiteSearch);
		elementUtils.doActionsSendKeys(txtboxsiteSearch, sitename);
		elementUtils.waitForElementVisible(getSiteNameLocator(sitename), Constants.DEFAULT_WAIT).click();

		elementUtils.clearTextBoxWithJS(datetime, Constants.DEFAULT_WAIT);
		elementUtils.sendKeysUsingJavaScript(datetime, dateTime, Constants.DEFAULT_WAIT);
		elementUtils.pressEscapeKey();
		Thread.sleep(2000);

		elementUtils.doClickWithActionsAndWait(dropdownactivitycode, Constants.DEFAULT_WAIT);
		elementUtils.doActionsSendKeys(searchActivityCode, activityCode);
		elementUtils.waitForElementVisible(getActivityCodeLocator(activityCode), Constants.DEFAULT_WAIT).click();

		elementUtils.clearTextBoxWithActions(txtboxVin);
		elementUtils.doActionsSendKeys(txtboxVin, vinNumber);

		elementUtils.clearTextBoxWithActions(txtboxLicenseNumber);
		elementUtils.doActionsSendKeys(txtboxLicenseNumber, licenseNo);
		elementUtils.clearTextBoxWithActions(dropdownselectState);
		elementUtils.doActionsSendKeys(dropdownselectState, selectState);
		// elementUtils.waitForElementVisible(getStateLocator(selectState),
		// Constants.DEFAULT_WAIT).click();
		elementUtils.clearTextBoxWithActions(txtboxExpireDate);
		elementUtils.doActionsSendKeys(txtboxExpireDate, expireDate);
		elementUtils.doSelectBy(dropdownSelectColor, vehicleColor);
		elementUtils.clearTextBoxWithActions(txtboxYear);
		elementUtils.doActionsSendKeys(txtboxYear, year);
		elementUtils.clearTextBoxWithActions(txtboxSelectMake);
		elementUtils.doActionsSendKeys(txtboxSelectMake, vehicleMake);
		elementUtils.waitForElementVisible(getVehicleNameLocator(vehicleMake), Constants.DEFAULT_WAIT).click();
		elementUtils.clearTextBoxWithActions(txtboxSelectmodel);
		elementUtils.doActionsSendKeys(txtboxSelectmodel, vehicleModel);
		// elementUtils.waitForElementVisible(getVehicleNameLocator(vehicleModel),
		// Constants.DEFAULT_WAIT).click();
		elementUtils.doSelectBy(dropdownViolation, violation);
		elementUtils.clearTextBoxWithActions(txtadditionalDetails);
		elementUtils.doActionsSendKeys(txtadditionalDetails, additionalDetails);
	}

	public void updateImpoundedFields(String dateTime, String towingCompany) {
		elementUtils.clearTextBoxWithJS(txtboxImpoundedDateandTime, Constants.DEFAULT_WAIT);
		elementUtils.sendKeysUsingJavaScript(txtboxImpoundedDateandTime, dateTime, Constants.DEFAULT_WAIT);
		elementUtils.clearTextBoxWithActions(txtboxTowingCompany);
		elementUtils.doActionsSendKeys(txtboxTowingCompany, towingCompany);
	}

	public void updateParkingCitationImagesUpload(String filePath) {
		if (filePath != null && !filePath.isEmpty()) {
			elementUtils.uploadFile(uploadFile, filePath);
			elementUtils.waitForElementVisible(txtboxFileName, Constants.DEFAULT_WAIT)
					.sendKeys("Updated Trespass Image");
		}
	}

}