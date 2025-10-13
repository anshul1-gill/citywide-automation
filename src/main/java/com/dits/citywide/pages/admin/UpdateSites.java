package com.dits.citywide.pages.admin;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dits.citywide.constants.Constants;
import com.dits.citywide.utilities.ElementUtils;
import org.openqa.selenium.support.ui.Select;  

public class UpdateSites {

	private By tabSites = By.xpath("//span[contains(text(),'Sites')]");
	private By searchSitename = By.xpath("//input[@placeholder='Search']");
	private By btnEditSite = By.cssSelector("button[title='Edit Site']");
	private By inputSiteName = By.xpath("//input[@name='site_name']");
	private By DropdownAgencyBeat = By.xpath("//input[@role='listbox']");
	private By callresponse = By.cssSelector("#call_response_only");
	private By selectStartingpoint = By.xpath("//input[@id='service_starting_time']");
	
	private By checkboxPdfreport = By.xpath("//input[@id='horizontal-list-radio-license']");
	private By reporttime = By.xpath("//input[@type='time']");
	private By clientEmail = By.xpath("//input[@id='reply_to']");
	
	private By dropdownpoliceAgencies = By.xpath("(//span[@class='select2-selection select2-selection--multiple'])[1]");
	private By dropdownFireAgencies = By.xpath("(//span[@class='select2-selection select2-selection--multiple'])[2]");
	private By dropdownmedicAgencies = By.xpath("(//span[@class='select2-selection select2-selection--multiple'])[3]");
	private By dropdownotheragencies = By.xpath("(//span[@class='select2-selection select2-selection--multiple'])[4]");
	private By dropdownSiteQualifications = By.xpath("(//span[@class='select2-selection select2-selection--multiple'])[5]");
	private By dropdownAccoountmanager = By.xpath("(//span[@class='select2-selection select2-selection--multiple'])[6]");
	
	// Site Addreess Details
	private By inputStreetnumber = By.cssSelector("#site_address_street_num");
	private By inputStreetname = By.cssSelector("#site_address_street");
	private By inputStreeCity = By.xpath("//input[@name='site_address_city']");
	private By inputStreeState = By.xpath("//select[@name='site_address_state']");
	private By inputZipcode = By.xpath("//input[@name='site_address_zip']");
	
	// Site Geofancing
	private By inputtyperadius = By.xpath("//input[@name='radius_value']");
	private By DropdownGeofencing = By.xpath("//select[@id='radius_type']");
	
	// Main Conatct Information
	private By inputContactname = By.xpath("//input[@id='contact_name_first']");
	private By inputConatactlastname = By.xpath("//input[@id='contact_name_last']");
	private By inputConatctPhone = By.xpath("//input[@id='contact_phone_main']");
	private By inputmobile = By.xpath("//input[@name='contact_phone_mobile']");
	private By inputContactfax = By.xpath("//input[@name='contact_fax']");
	private By inputContactemail = By.xpath("//input[@name='contact_email']");
	// Site Contacts
//	private By btnAddSiteContact = By.cssSelector("button[title='Add site contact']");
	private By txtboxJobTitle = By.cssSelector("#site_contact_job_title_0");
	private By txtboxContactName = By.cssSelector("#site_contact_name_0");
	private By txtboxNewContactPhone = By.cssSelector("#site_contact_num_0");
	
	private By btnUpdate = By.xpath("//button[normalize-space()='Update']");
	
	//------------2nd tab Property access 
	private By selectPropertyTab = By.xpath("//button[normalize-space()='Property access']");
	private By inputGatecode = By.xpath("//input[@name='gate_codes']");
	private By inputAlarmaem = By.xpath("//input[@name='alarm_code_arm']");
	private By inputunarm = By.xpath("//input[@name='alarm_code_unarm']");
	private By txtAlarmNotes = By.xpath("//textarea[@id='alarm_code_notes']");
	private By radiobtnLockbox = By.xpath("//input[@id='lock_box']");
	private By inputLockBoxcode = By.xpath("//input[@name='lock_box_code']");
	private By txtinputlockboxNotes = By.xpath("//textarea[@id='lock_box_notes']");
	
	//--------------3rdtab parking Enforcement-------------
	private By selectParkingEnforcementTab = By.xpath("//button[normalize-space()='Parking Enforcement']");
	private By inputtowName = By.xpath("//input[@name='towing_company_name']");
	private By inputTowphone = By.xpath("//input[@name='towing_company_phone']");
	private By radiobtn = By.xpath("//input[@id='radio_tow_auth_2']");
	private By TowingNotes = By.xpath("//textarea[@name='tow_company_notes']");
	private By radiobtnparkingenforce = By.xpath("//input[@id='radio_prkng_enf_2']");
	private By txtparkingNotes = By.xpath("//textarea[@id='parking_enforcement_notes']");
	
	//====================4th Site Repports===============================
	private By selectReportTab = By.xpath("//button[normalize-space()='Site Reports']");
	private By txtreportinstructions = By.xpath("//textarea[@id='report_notes']");
	
	//================Overall Site Coverage ====================================
	private By selectOverallSiteCoverage = By.xpath("//button[normalize-space()='Overall Site Coverage']");
	private By txtoverallsitecoverage = By.xpath("//textarea[@id='overall_site_coverage']");
	
	//---------------------Mobile/MultipleSites---------------------------------
	private By selectMobileTab = By.xpath("//button[normalize-space()='Mobile/Multiple Sites']");
	private By btnAddMobileCoverage = By.xpath("//button[normalize-space()='Add Mobile Coverage']");
	private By txtinputbCoveragename = By.xpath("//input[@id='patrol_coverage_name_0']");
	private By dropdownservicetype = By.xpath("(//select[@id='patrol_billing_type_0'])[1]");
	private By selectoption = By.xpath("//option[@value='165']"); //mobile
	private By DropdownMobBillingType = By.xpath("(//select[@id='patrol_billing_type_0'])[2]");
	private By inputBillingrates = By.xpath("//input[@id='patrol_coverage_billing_rate_0']");
	private By inputHolidayrates = By.xpath("//input[@id='patrol_coverage_billingRate_0']");
	private By inputCoverageEnddate = By.xpath("//input[@id='patrol_coverage_date_0']");
	private By dayStarttime = By.xpath("(//input[@id='subject'])[1]");
	private By dayEndtime = By.xpath("(//input[@id='subject'])[2]");
	private By copytoalldaytime  = By.xpath("(//i[@title='Copy first entered time to all'])[1]");
	
	private By dayNumberHits = By.xpath("(//input[@max='50'])[1]");
	private By SwingNumberHits = By.xpath("(//input[@max='50'])[2]");
	private By nightNumberHits = By.xpath("(//input[@max='50'])[3]");
	private By copytoallSwings  = By.xpath("//i[@title='Copy first entered hits to all']");
	
	
	//----------StationaryTab---------------------------------
	private By selectStationaryTab = By.xpath("//button[normalize-space()='Stationary/Single Site']");
	private By txtinputStationaryCoveragename = By.xpath("//input[@id='standing_coverage_0']");
	private By dropdownStationaryservicetype = By.xpath("(//label[normalize-space(text())='Service Type']/following-sibling::select)[2]");
	private By CoverageEnddate = By.cssSelector("#standing_coverage_date_0");
	private By DropdownStaBillingType = By.xpath("(//select[@id='standing_coverage_billingType_0'])[1]");
	private By inputtextBillingRates = By.xpath("(//input[@step='any'])[3]");
	private By inputtextHolidayRates = By.xpath("(//input[@step='any'])[4]");
	private By inputtextPostRates = By.xpath("(//input[@step='any'])[5]");
	
	private By inputtextAllowanceRate = By.xpath("(//input[@step='any'])[6]");
	private By AllowanceType = By.xpath("(//select[@id='standing_coverage_billingType_0'])[2]");
	private By startStationarytime = By.xpath("(//input[@type='time' and @name='subject'])[15]");
	private By endStationarytime = By.xpath("(//input[@type='time' and @name='subject'])[16]");
	private By copytoallStationarytime  = By.xpath("(//i[@title='Copy first entered time to all'])[2]");
	
	
	//-------------------siteArea --------------------------//
	private By btnTabsitearea = By.xpath("//button[normalize-space()='Site Areas']");
	private By inputAreaname = By.xpath("//input[@id='area_name_0']");
	private By inputdoorgatecount = By.xpath("//input[@id='door_count_0']");
	private By txtareanotes = By.xpath("//textarea[@id='area_notes_0']");
	private By inputlockuptime = By.xpath("//input[@name='site_area.0.mon_coverage_from']");
	private By inputunlocktime = By.xpath("//input[@name='site_area.0.mon_coverage_to']");
	private By inputCopytoall = By.xpath("(//i[@title='Copy first entered time to all'])[3]");
	
	//----------------------Temporary Post Order-----------------------------//
	private By btnTabTempPostOrder = By.xpath("//button[normalize-space()='Temporary Post Orders']");
	private By btnCreateNew = By.xpath("//button[normalize-space()='Create New']");
	private By TextFieldexpiredate = By.xpath("//input[@id='expires_date']");
	private By Inputfieldexpiretime = By.xpath("//input[@id='expires_time']");
	private By textdecription = By.xpath("//textarea[@id='post_order_text']");
	
	//=============================================================================================================================================================
	private ElementUtils elementUtils;

	public UpdateSites(ElementUtils elementUtils) {
		this.elementUtils = elementUtils;
	}
	public void clickSites() {
		elementUtils.waitForElementVisible(tabSites, Constants.DEFAULT_WAIT).click();
	}
	
	public void searchSites(String placeholder) {
		elementUtils.waitForElementVisible(searchSitename, Constants.DEFAULT_WAIT).sendKeys(placeholder);
	}
	public void clickEditSite() {
		elementUtils.waitForElementVisible(btnEditSite, Constants.DEFAULT_WAIT).click();
	}
	
	public void updateGeneralDetails(String siteName, List<String> agencyBeat, String callResponse, String startingPoint,
			boolean isPdfReport, String reportTime, String clientEmailID, List<String> policeAgencies,
			List<String> fireAgencies, List<String> medicAgencies, List<String> otherAgencies,
			List<String> siteQualifications, List<String> accountManagers) throws InterruptedException {

		elementUtils.waitForElementVisible(inputSiteName, Constants.DEFAULT_WAIT).clear();
		elementUtils.waitForElementVisible(inputSiteName, Constants.DEFAULT_WAIT).sendKeys(siteName);

		// Multi-selects
		selectMultipleOptions(DropdownAgencyBeat, agencyBeat);
		elementUtils.doSelectByValue(callresponse, callResponse);

		elementUtils.sendKeysUsingJavaScript(selectStartingpoint, startingPoint, Constants.DEFAULT_WAIT);

		// PDF Report checkbox
		if (isPdfReport)
			elementUtils.doClickWithActionsAndWait(checkboxPdfreport, Constants.DEFAULT_WAIT);

		elementUtils.sendKeysUsingJavaScript(reporttime, reportTime, Constants.DEFAULT_WAIT);
		elementUtils.waitForElementVisible(clientEmail, Constants.DEFAULT_WAIT).clear();
		elementUtils.waitForElementVisible(clientEmail, Constants.DEFAULT_WAIT).sendKeys(clientEmailID);

		// Multi-select lists
		selectMultipleOptions(dropdownpoliceAgencies, policeAgencies);
		selectMultipleOptions(dropdownFireAgencies, fireAgencies);
		selectMultipleOptions(dropdownmedicAgencies, medicAgencies);
		selectMultipleOptions(dropdownotheragencies, otherAgencies);
		selectMultipleOptions(dropdownSiteQualifications, siteQualifications);
		selectMultipleOptions(dropdownAccoountmanager, accountManagers);
	}

	private void selectMultipleOptions(By dropdownLocator, List<String> values) throws InterruptedException {
		if (values != null && !values.isEmpty()) {
			for (String value : values) {
				elementUtils.doClickWithActionsAndWait(dropdownLocator, Constants.DEFAULT_WAIT);
				elementUtils.doActionsSendKeys(dropdownLocator, value);
				elementUtils.pressEnterKey();
				Thread.sleep(1000);
			}
		}
	}

	// ---------------- Address Details ----------------
	public void updateAddressDetails(String streetNumber, String streetName, String city, String state,
			String zipCode) {

		elementUtils.waitForElementVisible(inputStreetnumber, Constants.DEFAULT_WAIT).clear();
		elementUtils.waitForElementVisible(inputStreetnumber, Constants.DEFAULT_WAIT).sendKeys(streetNumber);

		elementUtils.waitForElementVisible(inputStreetname, Constants.DEFAULT_WAIT).clear();
		elementUtils.waitForElementVisible(inputStreetname, Constants.DEFAULT_WAIT).sendKeys(streetName);

		elementUtils.waitForElementVisible(inputStreeCity, Constants.DEFAULT_WAIT).clear();
		elementUtils.waitForElementVisible(inputStreeCity, Constants.DEFAULT_WAIT).sendKeys(city);

		elementUtils.doSelectBy(inputStreeState, state);

		elementUtils.waitForElementVisible(inputZipcode, Constants.DEFAULT_WAIT).clear();
		elementUtils.waitForElementVisible(inputZipcode, Constants.DEFAULT_WAIT).sendKeys(zipCode);
	}

	// ---------------- Geofencing ----------------
	public void updateGeofencingDetails(String radiusType, String radiusValue) {
		elementUtils.doSelectBy(DropdownGeofencing, radiusType);
		elementUtils.waitForElementVisible(inputtyperadius, Constants.DEFAULT_WAIT).clear();
		elementUtils.waitForElementVisible(inputtyperadius, Constants.DEFAULT_WAIT).sendKeys(radiusValue);
	}

	// ---------------- Main Contact ----------------
	public void updateMainContactDetails(String contactName, String contactLastName, String contactPhone, String mobile,
			String contactFax, String contactEmail) {

		elementUtils.waitForElementVisible(inputContactname, Constants.DEFAULT_WAIT).clear();
		elementUtils.waitForElementVisible(inputContactname, Constants.DEFAULT_WAIT).sendKeys(contactName);

		elementUtils.waitForElementVisible(inputConatactlastname, Constants.DEFAULT_WAIT).clear();
		elementUtils.waitForElementVisible(inputConatactlastname, Constants.DEFAULT_WAIT).sendKeys(contactLastName);

		elementUtils.waitForElementVisible(inputConatctPhone, Constants.DEFAULT_WAIT).clear();
		elementUtils.waitForElementVisible(inputConatctPhone, Constants.DEFAULT_WAIT).sendKeys(contactPhone);

		elementUtils.waitForElementVisible(inputmobile, Constants.DEFAULT_WAIT).clear();
		elementUtils.waitForElementVisible(inputmobile, Constants.DEFAULT_WAIT).sendKeys(mobile);

		elementUtils.waitForElementVisible(inputContactfax, Constants.DEFAULT_WAIT).clear();
		elementUtils.waitForElementVisible(inputContactfax, Constants.DEFAULT_WAIT).sendKeys(contactFax);

		elementUtils.waitForElementVisible(inputContactemail, Constants.DEFAULT_WAIT).clear();
		elementUtils.waitForElementVisible(inputContactemail, Constants.DEFAULT_WAIT).sendKeys(contactEmail);
	}

	// ---------------- Site Contacts ----------------

	public void updateSiteContactDetails(String contactFirstName, String contactLastName, String contactPhone) {

		elementUtils.waitForElementVisible(txtboxJobTitle, Constants.DEFAULT_WAIT).clear();
		elementUtils.waitForElementVisible(txtboxJobTitle, Constants.DEFAULT_WAIT).sendKeys(contactFirstName);

		elementUtils.waitForElementVisible(txtboxContactName, Constants.DEFAULT_WAIT).clear();
		elementUtils.waitForElementVisible(txtboxContactName, Constants.DEFAULT_WAIT).sendKeys(contactLastName);

		elementUtils.waitForElementVisible(txtboxNewContactPhone, Constants.DEFAULT_WAIT).clear();
		elementUtils.waitForElementVisible(txtboxNewContactPhone, Constants.DEFAULT_WAIT).sendKeys(contactPhone);
	}

	public void clickSaveAndNext() throws InterruptedException {
		elementUtils.waitForElementVisible(btnUpdate, Constants.DEFAULT_WAIT).click();
		Thread.sleep(60000);
	}
	
	// ---------------- Property Access Details ----------------
	public void updatePropertyAccessDetails(String gateCode, String alarmArmCode, String alarmUnarmCode,
	                                        String alarmNotes, boolean isLockboxEnabled, String lockboxCode,
	                                        String lockboxNotes) {

	    // Click Property Access tab
	    elementUtils.waitForElementVisible(selectPropertyTab, Constants.DEFAULT_WAIT).click();

	    // Gate Code
	    elementUtils.waitForElementVisible(inputGatecode, Constants.DEFAULT_WAIT).clear();
	    elementUtils.waitForElementVisible(inputGatecode, Constants.DEFAULT_WAIT).sendKeys(gateCode);

	    // Alarm Codes
	    elementUtils.waitForElementVisible(inputAlarmaem, Constants.DEFAULT_WAIT).clear();
	    elementUtils.waitForElementVisible(inputAlarmaem, Constants.DEFAULT_WAIT).sendKeys(alarmArmCode);

	    elementUtils.waitForElementVisible(inputunarm, Constants.DEFAULT_WAIT).clear();
	    elementUtils.waitForElementVisible(inputunarm, Constants.DEFAULT_WAIT).sendKeys(alarmUnarmCode);

	    // Alarm Notes
	    elementUtils.waitForElementVisible(txtAlarmNotes, Constants.DEFAULT_WAIT).clear();
	    elementUtils.waitForElementVisible(txtAlarmNotes, Constants.DEFAULT_WAIT).sendKeys(alarmNotes);

	    // Lockbox
	    if (isLockboxEnabled) {
	        elementUtils.waitForElementVisible(radiobtnLockbox, Constants.DEFAULT_WAIT).click();
	        elementUtils.waitForElementVisible(inputLockBoxcode, Constants.DEFAULT_WAIT).clear();
	        elementUtils.waitForElementVisible(inputLockBoxcode, Constants.DEFAULT_WAIT).sendKeys(lockboxCode);

	        elementUtils.waitForElementVisible(txtinputlockboxNotes, Constants.DEFAULT_WAIT).clear();
	        elementUtils.waitForElementVisible(txtinputlockboxNotes, Constants.DEFAULT_WAIT).sendKeys(lockboxNotes);
	    }
	}
	
	// ---------------- Parking Enforcement ----------------
	public void updateParkingEnforcementDetails(
	        String towingCompanyName,
	        String towingCompanyPhone,
	        boolean isTowAuthorized,
	        String towingNotes,
	        boolean isParkingEnforced,
	        String parkingNotes
	) {
	    // Click Parking Enforcement tab
	    elementUtils.waitForElementVisible(selectParkingEnforcementTab, Constants.DEFAULT_WAIT).click();

	    // Fill Towing Company Name and Phone
	    elementUtils.waitForElementVisible(inputtowName, Constants.DEFAULT_WAIT).clear();
	    elementUtils.waitForElementVisible(inputtowName, Constants.DEFAULT_WAIT).sendKeys(towingCompanyName);

	    elementUtils.waitForElementVisible(inputTowphone, Constants.DEFAULT_WAIT).clear();
	    elementUtils.waitForElementVisible(inputTowphone, Constants.DEFAULT_WAIT).sendKeys(towingCompanyPhone);

	    // Select Tow Authorization radio button if needed
	    if (isTowAuthorized) {
	        elementUtils.waitForElementVisible(radiobtn, Constants.DEFAULT_WAIT).click();
	    }

	    // Enter Towing Notes
	    elementUtils.waitForElementVisible(TowingNotes, Constants.DEFAULT_WAIT).clear();
	    elementUtils.waitForElementVisible(TowingNotes, Constants.DEFAULT_WAIT).sendKeys(towingNotes);

	    // Select Parking Enforcement radio button if needed
	    if (isParkingEnforced) {
	        elementUtils.waitForElementVisible(radiobtnparkingenforce, Constants.DEFAULT_WAIT).click();
	    }

	    // Optional: Enter Notes (if you have fields for notes, add them here)
	    // elementUtils.waitForElementVisible(textStationaryCoverageNotes, Constants.DEFAULT_WAIT).clear();
	    // elementUtils.waitForElementVisible(textStationaryCoverageNotes, Constants.DEFAULT_WAIT).sendKeys(dayNotes);
	    // elementUtils.waitForElementVisible(textStationarySwingCoverageNotes, Constants.DEFAULT_WAIT).clear();
	    // elementUtils.waitForElementVisible(textStationarySwingCoverageNotes, Constants.DEFAULT_WAIT).sendKeys(swingNotes);
	    // elementUtils.waitForElementVisible(textStationaryNightCoverageNotes, Constants.DEFAULT_WAIT).clear();
	    // elementUtils.waitForElementVisible(textStationaryNightCoverageNotes, Constants.DEFAULT_WAIT).sendKeys(nightNotes);

	    // Optional: Click Save/Update Button
	    // elementUtils.doClickWithActionsAndWait(btnSaveStationaryCoverage, Constants.DEFAULT_WAIT);
	    // Enter Parking Enforcement Notes
	    elementUtils.waitForElementVisible(txtparkingNotes, Constants.DEFAULT_WAIT).clear();
	    elementUtils.waitForElementVisible(txtparkingNotes, Constants.DEFAULT_WAIT).sendKeys(parkingNotes);
	}
	
	//---SiteReports---------------------------
	
	public void siteReporInstructions( String ReportInstructions) {
		elementUtils.waitForElementVisible(selectReportTab, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementVisible(txtreportinstructions, Constants.DEFAULT_WAIT).sendKeys(ReportInstructions);
	}
	
	
	public void overallSiteCoverage( String OverallInstructions) {
		elementUtils.waitForElementVisible(selectOverallSiteCoverage, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementVisible(txtoverallsitecoverage, Constants.DEFAULT_WAIT).sendKeys(OverallInstructions);
	}
	public void updateMobileCoverageDetails(
	        String coverageName, String serviceTypeValue, String billingTypemob, String billingRate,
	        String holidayRate, String coverageEndDate, String dayStartTime, String dayEndTime,
	        String dayHits, String swingHits, String nightHits, boolean copyTimesToAll, boolean copyHitsToAll) {

	    // Click Mobile tab
	    elementUtils.waitForElementVisible(selectMobileTab, Constants.DEFAULT_WAIT).click();

	    // Enter Coverage Name
	    elementUtils.waitForElementVisible(txtinputbCoveragename, Constants.DEFAULT_WAIT).clear();
	    elementUtils.waitForElementVisible(txtinputbCoveragename, Constants.DEFAULT_WAIT).sendKeys(coverageName);

	    // Select Service Type dropdown
	    elementUtils.waitForElementVisible(dropdownservicetype, Constants.DEFAULT_WAIT).click();
	    elementUtils.waitForElementVisible(By.xpath("//option[@value='" + serviceTypeValue + "']"), Constants.DEFAULT_WAIT).click();

	    // Select Billing Type dropdown (instead of clear/sendKeys)
	    elementUtils.waitForElementVisible(DropdownMobBillingType, Constants.DEFAULT_WAIT).click();
	    elementUtils.waitForElementVisible(By.xpath("//option[text()='" + billingTypemob + "']"), Constants.DEFAULT_WAIT).click();

	    // Enter Billing and Holiday Rates
	    elementUtils.waitForElementVisible(inputBillingrates, Constants.DEFAULT_WAIT).clear();
	    elementUtils.waitForElementVisible(inputBillingrates, Constants.DEFAULT_WAIT).sendKeys(billingRate);
	    elementUtils.waitForElementVisible(inputHolidayrates, Constants.DEFAULT_WAIT).clear();
	    elementUtils.waitForElementVisible(inputHolidayrates, Constants.DEFAULT_WAIT).sendKeys(holidayRate);

	    // Enter Coverage End Date using calendar pop-up
	 // Coverage End Date using calendar
	    elementUtils.waitForElementVisible(inputCoverageEnddate, Constants.DEFAULT_WAIT).click();
	    selectDateFromCalendar(coverageEndDate);


	    // Enter Day Start and End Times
	    elementUtils.waitForElementVisible(dayStarttime, Constants.DEFAULT_WAIT).clear();
	    elementUtils.waitForElementVisible(dayStarttime, Constants.DEFAULT_WAIT).sendKeys(dayStartTime);
	    elementUtils.waitForElementVisible(dayEndtime, Constants.DEFAULT_WAIT).clear();
	    elementUtils.waitForElementVisible(dayEndtime, Constants.DEFAULT_WAIT).sendKeys(dayEndTime);

	    // Copy Day Time to All if required
	    if (copyTimesToAll) {
	        elementUtils.waitForElementVisible(copytoalldaytime, Constants.DEFAULT_WAIT).click();
	    }

	    // Enter Number of Hits
	    elementUtils.waitForElementVisible(dayNumberHits, Constants.DEFAULT_WAIT).clear();
	    elementUtils.waitForElementVisible(dayNumberHits, Constants.DEFAULT_WAIT).sendKeys(dayHits);
	    elementUtils.waitForElementVisible(SwingNumberHits, Constants.DEFAULT_WAIT).clear();
	    elementUtils.waitForElementVisible(SwingNumberHits, Constants.DEFAULT_WAIT).sendKeys(swingHits);
	    elementUtils.waitForElementVisible(nightNumberHits, Constants.DEFAULT_WAIT).clear();
	    elementUtils.waitForElementVisible(nightNumberHits, Constants.DEFAULT_WAIT).sendKeys(nightHits);

	    // Copy Hits to All if required
	    if (copyHitsToAll) {
	        elementUtils.waitForElementVisible(copytoallSwings, Constants.DEFAULT_WAIT).click();
	    }
	}

	// Calendar selection helper
	private void selectDateFromCalendar(String dateValue) {
	    // Validate date format dd/MM/yyyy
	    String[] parts = dateValue.split("/");
	    if (parts.length != 3) {
	        throw new IllegalArgumentException("Date must be in dd/MM/yyyy format: " + dateValue);
	    }
	    String day = parts[0];
	    String month = parts[1];
	    String year = parts[2];

	    // Open calendar is assumed already clicked

	    // Select month
	    elementUtils.waitForElementVisible(
	        By.cssSelector("select.flatpickr-monthDropdown-months"), Constants.DEFAULT_WAIT
	    ).sendKeys(String.valueOf(Integer.parseInt(month) - 1)); // 0-based index

	    // Select year
	    elementUtils.waitForElementVisible(
	        By.cssSelector("input.numInput.cur-year"), Constants.DEFAULT_WAIT
	    ).clear();
	    elementUtils.waitForElementVisible(
	        By.cssSelector("input.numInput.cur-year"), Constants.DEFAULT_WAIT
	    ).sendKeys(year);

	    // Select day
	    elementUtils.waitForElementVisible(
	        By.xpath("//span[contains(@class,'flatpickr-day') and text()='" + Integer.parseInt(day) + "']"), 
	        Constants.DEFAULT_WAIT
	    ).click();
	}
	
	public void updateStationaryCoverageDetails(
	        String coverageName, String serviceTypeValue, String coverageEndDate,
	        String billingType, String billingRate, String holidayRate, String postRate,
	        String allowanceRate, String allowanceTypeValue, String startTime, String endTime,
	        boolean copyTimesToAll) throws InterruptedException {

	    // Click on Stationary/Single Site tab
	    elementUtils.doClickWithActionsAndWait(selectStationaryTab, Constants.DEFAULT_WAIT);

	    // Update Coverage Name
	    WebElement coverageNameInput = elementUtils.waitForElementVisible(txtinputStationaryCoveragename, Constants.DEFAULT_WAIT);
	    coverageNameInput.clear();
	    coverageNameInput.sendKeys(coverageName);

	    // Update Service Type
	    elementUtils.doSelectBy(dropdownStationaryservicetype, serviceTypeValue);

	    // Update Coverage End Date
	    elementUtils.sendKeysUsingJavaScript(CoverageEnddate, coverageEndDate, 30);

	    // Update Billing Rates
	    WebElement billingTypeInput = elementUtils.waitForElementVisible(DropdownStaBillingType, Constants.DEFAULT_WAIT);
	    billingTypeInput.sendKeys(billingType);

	    elementUtils.waitForElementVisible(inputtextBillingRates, Constants.DEFAULT_WAIT).clear();
	    elementUtils.waitForElementVisible(inputtextBillingRates, Constants.DEFAULT_WAIT).sendKeys(billingRate);

	    elementUtils.waitForElementVisible(inputtextHolidayRates, Constants.DEFAULT_WAIT).clear();
	    elementUtils.waitForElementVisible(inputtextHolidayRates, Constants.DEFAULT_WAIT).sendKeys(holidayRate);

	    elementUtils.waitForElementVisible(inputtextPostRates, Constants.DEFAULT_WAIT).clear();
	    elementUtils.waitForElementVisible(inputtextPostRates, Constants.DEFAULT_WAIT).sendKeys(postRate);

	    // Update Allowance if provided
	    if (allowanceRate != null && !allowanceRate.isEmpty()) {
	        elementUtils.waitForElementVisible(inputtextAllowanceRate, Constants.DEFAULT_WAIT).clear();
	        elementUtils.waitForElementVisible(inputtextAllowanceRate, Constants.DEFAULT_WAIT).sendKeys(allowanceRate);

	        elementUtils.waitForElementVisible(AllowanceType, Constants.DEFAULT_WAIT).click();
	        elementUtils.waitForElementVisible(By.xpath("//option[@value='" + allowanceTypeValue + "']"), Constants.DEFAULT_WAIT).click();
	    }

	    // Update Start and End Times
	    WebElement startTimeInput = elementUtils.waitForElementVisible(startStationarytime, Constants.DEFAULT_WAIT);
	    startTimeInput.clear();
	    startTimeInput.sendKeys(startTime);

	    WebElement endTimeInput = elementUtils.waitForElementVisible(endStationarytime, Constants.DEFAULT_WAIT);
	    endTimeInput.clear();
	    endTimeInput.sendKeys(endTime);

	    // Copy time to all shifts if required
	    if (copyTimesToAll) {
	        elementUtils.doClickWithActionsAndWait(copytoallStationarytime, Constants.DEFAULT_WAIT);
	    }

	}

	public void updateSiteAreaDetails(
	        String areaName,
	        String doorGateCount,
	        String areaNotes,
	        String lockupTime,
	        String unlockTime,
	        boolean copyTimeToAll) {
		
		elementUtils.doClickWithActionsAndWait(btnTabsitearea, Constants.DEFAULT_WAIT);

	    // Enter Area Name
	    WebElement areaNameField = elementUtils.waitForElementVisible(inputAreaname, Constants.DEFAULT_WAIT);
	    areaNameField.clear();
	    areaNameField.sendKeys(areaName);

	    // Enter Door/Gate Count
	    WebElement doorGateField = elementUtils.waitForElementVisible(inputdoorgatecount, Constants.DEFAULT_WAIT);
	    doorGateField.clear();
	    doorGateField.sendKeys(doorGateCount);

	    // Enter Area Notes
	    WebElement notesField = elementUtils.waitForElementVisible(txtareanotes, Constants.DEFAULT_WAIT);
	    notesField.clear();
	    notesField.sendKeys(areaNotes);

	    // Enter Lockup and Unlock Times
	    WebElement lockupField = elementUtils.waitForElementVisible(inputlockuptime, Constants.DEFAULT_WAIT);
	    lockupField.clear();
	    lockupField.sendKeys(lockupTime);

	    WebElement unlockField = elementUtils.waitForElementVisible(inputunlocktime, Constants.DEFAULT_WAIT);
	    unlockField.clear();
	    unlockField.sendKeys(unlockTime);

	    // Copy times to all if required
	    if (copyTimeToAll) {
	        elementUtils.doClickWithActionsAndWait(inputCopytoall, Constants.DEFAULT_WAIT);
	    }
	}









	
	
}
