package com.dits.citywide.pages.admin;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dits.citywide.constants.Constants;
import com.dits.citywide.utilities.ElementUtils;
import org.openqa.selenium.support.ui.Select;  

public class SitesPage {

	private WebDriver driver;
	private ElementUtils elementUtils;

	private By btnAddNewSite = By.xpath("//a[normalize-space()='Add New Site']");

	// 1st tab Site Details
	// Site General Details
	private By dropdownBranch = By.id("location_id");
	private By selectOptionBranch = By.cssSelector("#location_id");
	private By inputSiteID = By.xpath("//input[@name='site_id']");
	private By inputSiteName = By.xpath("//input[@name='site_name']");
	private By dropdownAgencybeat = By.xpath("(//span[@role='combobox'])[1]");
	private By callresponse = By.cssSelector("#call_response_only");
	private By selectStartingpoint = By.xpath("//input[@id='service_starting_time']");
	private By selectendingpoint = By.xpath("//input[@id='service_end_time']");

	// service types
	private By checkboxStationary = By.xpath("//input[@id='site_type_108']");
	private By checkboxMobile = By.xpath("//input[@id='site_type_112']");

	private By checkboxPaypostrate = By.xpath("//input[@id='post_pay_rate']");
	private By checkboxautoreport = By.xpath("//input[@id='is_auto_report']");

	// pdfreport
	private By checkboxPdfreport = By.xpath("//input[@id='horizontal-list-radio-license']");
	private By reporttime = By.xpath("//input[@type='time']");
	private By clientEmail = By.xpath("//input[@id='reply_to']");
	private By dropdownpoliceAgencies = By.xpath("(//span[@class='select2-selection select2-selection--multiple'])[2]");
	private By dropdownFireAgencies = By.xpath("(//span[@class='select2-selection select2-selection--multiple'])[3]");
	private By dropdownmedicAgencies = By.xpath("(//span[@class='select2-selection select2-selection--multiple'])[4]");
	private By dropdownotheragencies = By.xpath("(//span[@class='select2-selection select2-selection--multiple'])[5]");
	private By dropdownSiteQualifications = By
			.xpath("(//span[@class='select2-selection select2-selection--multiple'])[6]");
	private By dropdownAccoountmanager = By
			.xpath("(//span[@class='select2-selection select2-selection--multiple'])[7]");

	// Site Addreess Details
	private By inputStreetnumber = By.cssSelector("#site_address_street_num");
	private By inputStreetname = By.cssSelector("#site_address_street");
	private By inputStreeCity = By.xpath("//input[@name='site_address_city']");
	private By inputStreeState = By.xpath("//select[@name='site_address_state']");
	private By inputZipcode = By.xpath("//input[@name='site_address_zip']");

	// Site Geofancing
	private By DropdownGeofencing = By.xpath("//select[@id='radius_type']");
	private By inputtyperadius = By.xpath("//input[@name='radius_value']");

	// Main Conatct Information
	private By inputContactname = By.xpath("//input[@id='contact_name_first']");
	private By inputConatactlastname = By.xpath("//input[@id='contact_name_last']");
	private By inputConatctPhone = By.xpath("//input[@id='contact_phone_main']");
	private By inputmobile = By.xpath("//input[@name='contact_phone_mobile']");
	private By inputContactfax = By.xpath("//input[@name='contact_fax']");
	private By inputContactemail = By.xpath("//input[@name='contact_email']");

	// Site Contacts
	private By btnAddSiteContact = By.cssSelector("button[title='Add site contact']");

	private By txtboxJobTitle = By.cssSelector("#site_contact_job_title_0");
	private By txtboxContactName = By.cssSelector("#site_contact_name_0");
	private By txtboxNewContactPhone = By.cssSelector("#site_contact_num_0");

	private By btnSaveAndNext = By.cssSelector("#submitButton");
	
	// Property access	==============================
	private By inputGatecode = By.xpath("//input[@name='gate_codes']");
	private By inputAlarmaem = By.xpath("//input[@name='alarm_code_arm']");
	private By inputunarm = By.xpath("//input[@name='alarm_code_unarm']");
	private By txtAlarmNotes = By.xpath("//textarea[@id='alarm_code_notes']");
	private By radiobtnLockbox = By.xpath("//input[@id='radio_Lock_box_1']");
	private By inputLockBoxcode = By.xpath("//input[@name='lock_box_code']");
	private By txtinputlockboxNotes = By.xpath("//textarea[@id='lock_box_notes']");
	
	//parking enforcement =====================
	private By inputtowName = By.xpath("//input[@name='towing_company_name']");
	private By inputTowphone = By.xpath("//input[@name='towing_company_phone']");
	private By radiobtn = By.xpath("//input[@id='towing']");
	private By TowingNotes = By.xpath("//textarea[@name='tow_company_notes']");
	private By radiobtnparkingenforce = By.xpath("//input[@id='radio_prkng_enf_1']");
	private By txtparkingNotes = By.xpath("//textarea[@id='parking_enforcement_notes']");
	
	//Sites reports ==========================
	private By txtreportinstructions = By.xpath("//textarea[@id='report_notes']");
	
	//===============================OverallISte Coverage =======================
	private By txtoverallsitecoverage = By.xpath("//textarea[@id='overall_site_coverage']");

	//Add mobile coverage
	private By btnAddMobileCoverage = By.xpath("//button[normalize-space()='Add Mobile Coverage']");
	private By txtinputbCoveragename = By.xpath("//input[@id='patrol_coverage_name_0']");
	private By dropdownservicetype = By.xpath("(//select[@id='patrol_billing_type_0'])[1]");
	private By selectoption = By.xpath("//option[@value='165']"); //mobile
	private By DropdownMobBillingType = By.xpath("(//select[@id='patrol_billing_type_0'])[2]");
	private By inputBillingrates = By.xpath("//input[@id='patrol_coverage_billing_rate_0']");
	private By inputHolidayrates = By.xpath("//input[@id='patrol_coverage_billingRate_0']");
	private By inputCoverageEnddate = By.xpath("//input[@id='patrol_coverage_date_0']");
	private By dayStarttime = By.xpath("(//input[@type='time'])[1]");
	private By dayEndtime = By.xpath("(//input[@type='time'])[2]");
	private By copytoalldaytime  = By.xpath("(//i[@title='Copy first entered time to all'])[1]");
	
	private By dayNumberHits = By.xpath("(//input[@max='50'])[1]");
	private By SwingNumberHits = By.xpath("(//input[@max='50'])[2]");
	private By nightNumberHits = By.xpath("(//input[@max='50'])[3]");
	private By copytoallSwings  = By.xpath("//i[@title='Copy first entered hits to all']");
	
	private By textDayCoverageNotes = By.xpath("//textarea[@id='patrol_coverage_notes_day']");
	private By textSwingCoverageNotes = By.xpath("//textarea[@id='patrol_coverage_notes_swing']");
	private By textNightCoverageNotes = By.xpath("//textarea[@id='patrol_coverage_notes_night']");
	
	//7th Tab Stationary 
	private By btnAddStationaryCoverage = By.xpath("//button[normalize-space()='Add Stationary Coverage']");
	private By txtinputStationaryCoveragename = By.xpath("//input[@id='standing_coverage_1']");
	private By dropdownStationaryservicetype = By.xpath("//label[normalize-space(text())='Service Type']/following-sibling::select");
	private By selectservicetype = By.xpath("//option[@value='157']"); //stationary
	private By CoverageEnddate = By.cssSelector("#standing_coverage_date_1");
	private By DropdownStaBillingType = By.xpath("//select[@id='standing_coverage_billingType_1']");
	private By inputtextBillingRates = By.xpath("(//input[@step='any'])[1]");
	private By inputtextHolidayRates = By.xpath("(//input[@step='any'])[2]");
	private By inputtextPostRates = By.xpath("(//input[@step='any'])[3]");
	
	private By iconAddAllowance = By.xpath("//i[@class='fa-solid fa-plus']");
	private By textboxAllowanceRate = By.xpath("(//input[@step='any'])[4]");
	private By AllowanceType = By.xpath("(//select[@id='standing_coverage_billingType_1'])[2]");
	private By selectAllowanceType = By.xpath("(//option[@value='7'])[1]");
	private By startStationarytime = By.xpath("(//input[@type='time'])[1]");
	private By endStationarytime = By.xpath("(//input[@type='time'])[2]");
	private By copytoallStationarytime  = By.xpath("(//i[@title='Copy first entered time to all'])[1]");
	private By textStationaryCoverageNotes = By.xpath("//textarea[@id='standing_coverage_notes_day']");
	private By textStationarySwingCoverageNotes = By.xpath("//textarea[@id='standing_coverage_notes_swing']");
	private By textStationaryNightCoverageNotes = By.xpath("//textarea[@id='standing_coverage_notes_night']");	
	
	
	
	//------------------Site Area Tab-------------------------
	private By btnAddnewsitearea = By.xpath("//button[normalize-space()='Add New Site Area']");
	
	private By inputAreaname = By.xpath("//input[@id='area_name_1']");
	private By inputdoorgatecount = By.xpath("//input[@id='door_count_1']");
	private By txtareanotes = By.xpath("//textarea[@id='area_notes_1']");
	
	private By inputlockuptime = By.xpath("//input[@name='site_area.1.mon_coverage_from']");
	private By inputunlocktime = By.xpath("//input[@name='site_area.1.mon_coverage_to']");
	;
	private By inputCopytoall = By.xpath("//i[@title='Copy first entered time to all']");
	
	//Temporary Post Order ===========
//	private By btnCreateNew = By.xpath("//button[normalize-space()='Create New']");
//	private By ModalinputExpiredate = By.xpath("//input[@id='expires_date']");
//	private By ModalexpireTime = By.xpath("//input[@id='expires_time']");
//	private By ModaltxtPostorder = By.xpath("//textarea[@id='post_order_text']");
//	private By btnAddtempost = By.xpath("//button[normalize-space()='Add Temporary Post Order']");
	
//    private By btnnavSiteDoc = By.xpath("//button[normalize-space()='Site Doc / Payment Terms']");
    //====================Site Doc /Payment terms================
	
	
    private By inputClientname = By.xpath("//input[@id='client_name_first']");
    private By inputClientLastname = By.xpath("//input[@id='client_name_last']");
    private By inputClientCompanyname = By.xpath("//input[@id='client_company_name']");
    private By inputClientdisplayname = By.xpath("//input[@id='client_display_name']");
    private By inputClientPhone = By.xpath("//input[@id='client_phone_main']");
    private By inputClientMobile = By.xpath("//input[@name='client_phone_mobile']");
    private By inputClientFax = By.xpath("//input[@name='client_fax']");	
    private By inputClientEmail = By.xpath("//input[@name='client_email']");
    private By inputClienterms = By.xpath("//input[@name='client_terms']");
    private By dropdownBilling = By.xpath("//label[normalize-space(text())='Billing Cycle']/following-sibling::select");
    private By selectbillingoption = By.xpath("//option[normalize-space()='Weekly']");
    private By billingStartdate = By.xpath("//input[@id='client_billing_date']");
    private By invoiceNumbers = By.xpath("//input[@id='client_billing_invoice']");
    
    private By togglebtnHours = By.xpath("//input[@name='projected_hours']");
    private By inputBillingaddess = By.xpath("//input[@id='client_address_street_num']");
    private By inputClientStreetname = By.xpath("//input[@id='client_address_street']");
    private By inputClientcity = By.xpath("//input[@id='client_address_city']");
    private By DropdownClientState = By.xpath("//select[@id='client_address_state']");
    private By selectClientstate = By.xpath("//option[@value='AK']");
    private By inputClientZipcode = By.xpath("//input[@id='client_address_zip']");
    private By inputClientCountry = By.xpath("//input[@id='client_address_country']");
    
    //======COMMENTS/COMPLIMENTS
    private By textComments = By.xpath("//textarea[@id='standing_coverage_notes_day']");

	// ================================
	private By searchSite = By.cssSelector("input[placeholder='Search']");
	private By btnViewSite = By.cssSelector("button[title='View Site']");
	private By btnEditSite = By.cssSelector("button[title='Edit Site']");
	private By btnDeleteSite = By.cssSelector("button[title='Delete Site']");
	//=====================================
	
	
	private By btnFilters = By.xpath("//button[contains(text(),'Filters')]"); //Here i need click
	private By dropdownStatus = By.cssSelector("#table-filter-status");
	private By btntoggle = By.xpath("(//div[contains(@class,'w-11 h-6 ')])[1]");
	private By btnmodalOk = By.xpath("//button[normalize-space()='OK']");
	
	//Post Order
	private By btnpostorder = By.xpath("//button[normalize-space()='Post Orders']");
	// Assignment fields
	private By txtaddAssignmentName = By.xpath("//input[@id='assignment_task']");
	private By dropdownAssignmentTemplate = By.cssSelector("#assignment_template");
	// private By selectOption = By.xpath("//option[@value='91VN06']");
	private By dropdownCoverage = By.cssSelector("#assignment_type");
	// private By selectCoverageOption = By.xpath("//option[text()='Fire -
	// Stationary/Single Site']");
	private By dropdowndayofweek = By.cssSelector("#day-of-week");	
	private By searchdayofweek = By.xpath("(//input[@type='search'])[7]");
	private By txtAssignments = By.xpath("//h4[normalize-space()='Assignments']");

	private By getAssignmentByName(String assignmentName) {
		String xpath = "//th[normalize-space()='" + assignmentName + "']";
		return By.xpath(xpath);
	}

	private By getTemplateNameByAssignment(String assignmentName) {
		String xpath = "(//th[normalize-space()='" + assignmentName + "']/following-sibling::td)[1]";
		return By.xpath(xpath);
	}

	private By getCoverageTypeByAssignment(String assignmentName) {
		String xpath = "(//th[normalize-space()='" + assignmentName + "']/following-sibling::td)[2]";
		return By.xpath(xpath);
	}

	private By getDaysOfWeekByAssignment(String assignmentName) {
		String xpath = "(//th[normalize-space()='" + assignmentName + "']/following-sibling::td)[3]";
		return By.xpath(xpath);
	}

	private By getAssignmentTimeSlotByAssignment(String assignmentName) {
		String xpath = "(//th[normalize-space()='" + assignmentName + "']/following-sibling::td)[4]";
		return By.xpath(xpath);
	}

	private By getAddedByAssignment(String assignmentName) {
		String xpath = "(//th[normalize-space()='" + assignmentName + "']/following-sibling::td)[5]";
		return By.xpath(xpath);
	}

	private By deleteButtonByAssignmentName(String assignmentName) {
		String xpath = "//th[normalize-space()='" + assignmentName + "']"
				+ "/following-sibling::td//div[@class='flex gap-2']/button[2]";
		return By.xpath(xpath);
	}

	private By btnOkButton = By.xpath("//button[normalize-space()='OK']");

	// Check Point
	private By btnCheckPoint = By.xpath("//a[normalize-space()='Check Point']");
	private By txtHeadingCheckPoint = By.xpath("//h1[@class='heading-text']");
	private By btnAddNewCheckPoint = By.xpath("//span[normalize-space()='Add Checkpoint']");
	private By txtCheckpointName = By.id("label");
	private By txtCheckpointDescription = By.id("description");
	private By dropdownCheckpointType = By.xpath("(//div[@class='ant-select-selector'])[2]");

	private By getCheckpointByType(String checkpointType) {
		String xpath = "//div[@title='" + checkpointType + "']";
		return By.xpath(xpath);
	}

	private By btnSave = By.xpath("//button[@type='submit']");
	private By btnBack = By.xpath("//span[normalize-space()='Back']");

	private By sucessMessage = By
			.xpath("//div[@class='swal2-icon swal2-success swal2-icon-show']/following-sibling::h2/span");
	private By deleteCheckpointSucessMessage = By
			.xpath("//div[@class='Toastify__toast-body']/div/following-sibling::div");
	private By loader = By.xpath("//span[@class='ant-spin-dot ant-spin-dot-spin']");

	private By getDayOption(String day) {
		String xpath = "//li[normalize-space(text())='" + day + "']";
		return By.xpath(xpath);
	}

	private By AddAssignmentTime = By.xpath("//input[@id='assignment_time']");
	private By AddsnitchTime = By.xpath("//input[@id='assignment_grace_time']");
	private By btnAddAssignment = By.xpath("//button[normalize-space()='Add Assignment']");
	private By btnUpdatepostorder = By.xpath("//button[normalize-space()='Update']");

	private By getCheckpointByName(String checkpointName) {
		String xpath = "//td[normalize-space()='" + checkpointName + "']";
		return By.xpath(xpath);
	}

	private By getCheckpointDescriptionByName(String checkpointName) {
		String xpath = "(//td[normalize-space()='" + checkpointName + "']/following-sibling::td)[1]";
		return By.xpath(xpath);
	}

	private By getCheckpointTypeByName(String checkpointName) {
		String xpath = "(//td[normalize-space()='" + checkpointName + "']/following-sibling::td)[2]";
		return By.xpath(xpath);
	}

	private By getCheckpointSiteNameByName(String checkpointName) {
		String xpath = "(//td[normalize-space()='" + checkpointName + "']/following-sibling::td)[3]";
		return By.xpath(xpath);
	}

	private By deleteButtonByCheckpointName(String checkpointName) {
		String xpath = "//td[normalize-space()='" + checkpointName + "']"
				+ "/following-sibling::td[@data-label='Actions']" + "//div[@class='actionicons deleteIcon']";
		return By.xpath(xpath);
	}

	// Scan Rules
	private By tabScanRules = By.cssSelector("#rc-tabs-1-tab-2");
	private By btnAddScanRule = By.xpath("//span[normalize-space()='Add Scan Rule']");
	private By txtADDScanTime = By.xpath("//input[@id='scan_deadline_time']");
	private By txtAddsnitchTime = By.xpath("//input[@id='grace_period']");
	private By dropdownActiveDays = By.xpath("(//div[@class='ant-select-selector'])[2]");
	private By btnSaveScan = By.xpath("//button[@type='submit']/span[text()='Add Scan Rule']");

	// Actions Rules
	private By tabActionsRules = By.cssSelector("#rc-tabs-1-tab-3");
	private By btnAddactionRule = By.xpath("//button[@type='button']/span[text()='Add Action Rule']");
	private By txtboxAddpriority = By.xpath("//input[@id='priority']");
	private By dropdownInputtype = By.xpath("(//div[@class='ant-select-selector'])[2]");

	public By getInputType(String text) {
		return By.xpath("//div[contains(text(),'" + text + "')]");
	}

	private By txtboxDirective = By.xpath("//input[@Id='directive']");
	private By btnSaveAction = By.xpath("//button[@type='submit']/span[text()='Add Action Rule']");

	// QR Code
	private By tabViewQRcode = By.cssSelector("#rc-tabs-1-tab-4");

	public SitesPage(WebDriver driver) {
		this.driver = driver;
		this.elementUtils = new ElementUtils(driver);
	}

	public void doClickAddNewSiteButton() {
		elementUtils.waitForElementVisible(btnAddNewSite, Constants.DEFAULT_WAIT).click();
	}

	public void searchSite(String siteName) {
		elementUtils.waitForElementVisible(searchSite, Constants.DEFAULT_WAIT).sendKeys(siteName);
	}

	public void clickViewSite() {
		elementUtils.waitForElementVisible(btnViewSite, Constants.DEFAULT_WAIT).click();
	}

	public void clickEditSite() {
		elementUtils.waitForElementVisible(btnEditSite, Constants.DEFAULT_WAIT).click();
	}

	public void clickDeleteSite() {
		elementUtils.waitForElementVisible(btnDeleteSite, Constants.DEFAULT_WAIT).click();
	}

	// Post Orders
//	public void clickPostOrders() {
//		elementUtils.waitForElementVisible(btnpostorder, Constants.DEFAULT_WAIT).click();
//	}

	public void fillAddAssignmentForm(String assignmentName, String template, String coverageType,
			List<String> daysOfWeek, String assignmentTime, String snitchTime) throws InterruptedException {
		elementUtils.waitForElementVisible(txtaddAssignmentName, Constants.DEFAULT_WAIT).sendKeys(assignmentName);
		elementUtils.doSelectBy(dropdownAssignmentTemplate, template);
		WebElement dropdown = elementUtils.waitForElementVisible(dropdownCoverage, Constants.DEFAULT_WAIT);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement option = wait.until(ExpectedConditions
		    .visibilityOfElementLocated(By.xpath(".//option[normalize-space(text())='" + coverageType.trim() + "']")));
		option.click();
		Thread.sleep(3000);



//		for (String day : daysOfWeek) {
//			elementUtils.doClickWithActionsAndWait(dropdowndayofweek, Constants.DEFAULT_WAIT);
//			elementUtils.doActionsSendKeys(searchdayofweek, day);
//			elementUtils.pressEnterKey();
//		}
		for (String day : daysOfWeek) {
//		    // Open the dropdown for each day
//		    elementUtils.doClickWithActionsAndWait(dropdowndayofweek, Constants.DEFAULT_WAIT);
//
//		    // Wait for the specific day option to be visible and click it
//		    elementUtils.waitForElementVisible(getDayOption(day), Constants.DEFAULT_WAIT).click();
//
//		    // Wait for the dropdown to close before next iteration
//		    new WebDriverWait(driver, Duration.ofSeconds(Constants.DEFAULT_WAIT))
//		            .until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("ul.select2-results__options")));
			elementUtils.doSelectBy(dropdowndayofweek, day);
		}

		elementUtils.waitForElementVisible(AddAssignmentTime, Constants.DEFAULT_WAIT).sendKeys(assignmentTime);
		elementUtils.pressEnterKey();
		elementUtils.waitForElementVisible(AddsnitchTime, Constants.DEFAULT_WAIT).sendKeys(snitchTime);
	}

	public void clickAddAssignment() {
		elementUtils.waitForElementVisible(btnAddAssignment, Constants.DEFAULT_WAIT).click();
	}

	public void clickUpdatePostOrder() {
		elementUtils.waitForInvisibilityOfElementLocated(sucessMessage, Constants.DEFAULT_WAIT);
		elementUtils.waitForElementVisible(btnUpdatepostorder, Constants.DEFAULT_WAIT).click();
	}

	public String getAssignmentName(String assignmentName) {
		return elementUtils.waitForElementVisible(getAssignmentByName(assignmentName), Constants.DEFAULT_WAIT)
				.getText();
	}

	public String getTemplateName(String assignmentName) {
		return elementUtils.waitForElementVisible(getTemplateNameByAssignment(assignmentName), Constants.DEFAULT_WAIT)
				.getText();
	}

	public String getCoverageType(String assignmentName) {
		return elementUtils.waitForElementVisible(getCoverageTypeByAssignment(assignmentName), Constants.DEFAULT_WAIT)
				.getText();
	}

	public String getDaysOfWeek(String assignmentName) {
		return elementUtils.waitForElementVisible(getDaysOfWeekByAssignment(assignmentName), Constants.DEFAULT_WAIT)
				.getText();
	}

	public String getAssignmentTimeSlot(String assignmentName) {
		return elementUtils
				.waitForElementVisible(getAssignmentTimeSlotByAssignment(assignmentName), Constants.DEFAULT_WAIT)
				.getText();
	}

	public String getAddedBy(String assignmentName) {
		return elementUtils.waitForElementVisible(getAddedByAssignment(assignmentName), Constants.DEFAULT_WAIT)
				.getText();
	}

	public String getAssignmentsText() {
		return elementUtils.waitForElementVisible(txtAssignments, Constants.DEFAULT_WAIT).getText();
	}

	// Check Point Methods
	public void clickCheckPointThatOpensNewTab() {
		elementUtils.waitForElementVisible(btnCheckPoint, Constants.DEFAULT_WAIT).click();
		elementUtils.switchToNewTab(Constants.DEFAULT_WAIT);
	}

	public String getHeadingCheckPoint() {
		return elementUtils.waitForElementVisible(txtHeadingCheckPoint, Constants.DEFAULT_WAIT).getText();
	}

	public void clickAddNewCheckPoint() {
		elementUtils.waitForElementVisible(btnAddNewCheckPoint, Constants.DEFAULT_WAIT).click();
	}

	public void fillCheckPointForm(String checkpointName, String checkpointDescription, String checkpointType) {
		elementUtils.waitForElementVisible(txtCheckpointName, Constants.DEFAULT_WAIT).sendKeys(checkpointName);
		elementUtils.waitForElementVisible(txtCheckpointDescription, Constants.DEFAULT_WAIT)
				.sendKeys(checkpointDescription);
		elementUtils.doClickWithActionsAndWait(dropdownCheckpointType, Constants.DEFAULT_WAIT);
		elementUtils.waitForElementVisible(getCheckpointByType(checkpointType), Constants.DEFAULT_WAIT).click();
	}

	public void clickSave() {
		elementUtils.waitForElementVisible(btnSave, Constants.DEFAULT_WAIT).click();
	}

	public void clickTabScanRules() {
		elementUtils.waitForInvisibilityOfElementLocated(deleteCheckpointSucessMessage, Constants.DEFAULT_WAIT);
		elementUtils.waitForElementVisible(tabScanRules, Constants.DEFAULT_WAIT).click();
	}

	public void clickAddScanRule() {
		elementUtils.waitForElementVisible(btnAddScanRule, Constants.DEFAULT_WAIT).click();
	}

	public void fillAddScanRuleForm(String scanTime, String snitchTime, List<String> activeDays) {
		elementUtils.waitForElementVisible(txtADDScanTime, Constants.DEFAULT_WAIT).sendKeys(scanTime);
		elementUtils.pressEnterKey();
		elementUtils.waitForElementVisible(txtAddsnitchTime, Constants.DEFAULT_WAIT).sendKeys(snitchTime);
		elementUtils.waitForElementToBeClickable(dropdownActiveDays, Constants.DEFAULT_WAIT).click();
		for (String day : activeDays) {
			By dayOption = By.xpath("//div[@title='" + day + "' and contains(@class,'ant-select-item-option')]");
			elementUtils.waitForElementVisible(dayOption, Constants.DEFAULT_WAIT).click();
		}
	}

	public void clickSaveScanRule() {
		elementUtils.waitForElementVisible(btnSaveScan, Constants.DEFAULT_WAIT).click();
	}

	public void clickTabActionsRules() {
		elementUtils.waitForElementVisible(tabActionsRules, Constants.DEFAULT_WAIT).click();
	}

	public void clickAddActionRule() {
		elementUtils.waitForElementVisible(btnAddactionRule, Constants.DEFAULT_WAIT).click();
	}

	public void fillAddActionRuleForm(String priority, String inputType, String directive) {
		elementUtils.waitForElementVisible(txtboxAddpriority, Constants.DEFAULT_WAIT).sendKeys(priority);
		elementUtils.doClickWithActionsAndWait(dropdownInputtype, Constants.DEFAULT_WAIT);
		elementUtils.waitForElementVisible(getInputType(inputType), Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementVisible(txtboxDirective, Constants.DEFAULT_WAIT).sendKeys(directive);
	}

	public void clickSaveActionRule() {
		elementUtils.waitForElementVisible(btnSaveAction, Constants.DEFAULT_WAIT).click();
	}

	public void clickTabViewQRcode() {
		elementUtils.waitForElementVisible(tabViewQRcode, Constants.DEFAULT_WAIT).click();
	}

	public void clickBack() throws InterruptedException {
		elementUtils.waitForInvisibilityOfElementLocated(loader, Constants.DEFAULT_WAIT);
		elementUtils.doClickWithActionsAndWait(btnBack, Constants.DEFAULT_WAIT);
	}

	public String getSuccessMessage() {
		return elementUtils.waitForElementVisible(sucessMessage, Constants.MEDIUM_TIME_OUT_WAIT).getText();
	}

	public String getDeleteCheckpointSuccessMessage() {
		return elementUtils.waitForElementVisible(deleteCheckpointSucessMessage, Constants.MEDIUM_TIME_OUT_WAIT)
				.getText();
	}

	public String getCheckpointName(String checkpointName) {
		return elementUtils.waitForElementVisible(getCheckpointByName(checkpointName), Constants.DEFAULT_WAIT)
				.getText();
	}

	public String getCheckpointDescription(String checkpointName) {
		return elementUtils
				.waitForElementVisible(getCheckpointDescriptionByName(checkpointName), Constants.DEFAULT_WAIT)
				.getText();
	}

	public String getCheckpointType(String checkpointName) {
		return elementUtils.waitForElementVisible(getCheckpointTypeByName(checkpointName), Constants.DEFAULT_WAIT)
				.getText();
	}

	public String getCheckpointSiteName(String checkpointName) {
		return elementUtils.waitForElementVisible(getCheckpointSiteNameByName(checkpointName), Constants.DEFAULT_WAIT)
				.getText();
	}

	public boolean isDeleteAssignmentPresent(String assignmentName) {
		return elementUtils.doIsDisplayed(deleteButtonByAssignmentName(assignmentName), Constants.DEFAULT_WAIT);
	}

	public void clickDeleteAssignmentByName(String assignmentName) {
		elementUtils.waitForElementVisible(deleteButtonByAssignmentName(assignmentName), Constants.DEFAULT_WAIT)
				.click();
	}

	public void clickOkButton() {
		elementUtils.waitForElementVisible(btnOkButton, Constants.DEFAULT_WAIT).click();
	}

	public boolean isDeleteCheckpointPresent(String checkpointName) {
		return elementUtils.doIsDisplayed(deleteButtonByCheckpointName(checkpointName), Constants.DEFAULT_WAIT);
	}

	public void clickDeleteCheckpointByName(String checkpointName) {
		elementUtils.waitForElementVisible(deleteButtonByCheckpointName(checkpointName), Constants.DEFAULT_WAIT)
				.click();
	}

	public String getScanRuleSuccessMessage() {
		return elementUtils.waitForElementVisible(deleteCheckpointSucessMessage, Constants.MEDIUM_TIME_OUT_WAIT)
				.getText();
	}

	public String getActionRuleSuccessMessage() {
		return elementUtils.waitForElementVisible(deleteCheckpointSucessMessage, Constants.MEDIUM_TIME_OUT_WAIT)
				.getText();
	}

	// // 1st tab Site Details
	// Site General Details
	public void selectBranch(String branchName) {
		elementUtils.waitForElementVisible(dropdownBranch, Constants.DEFAULT_WAIT);
		elementUtils.doSelectBy(selectOptionBranch, branchName);
	}

	public void fillGeneralDetails(String siteName, List<String> agencyBeat, String callResponse, String startingPoint,
			String endingPoint, boolean isStationary, boolean isMobile, boolean isPayPostRate, boolean isAutoReport,
			boolean isPdfReport, String reportTime, String clientEmailID, List<String> policeAgencies,
			List<String> fireAgencies, List<String> medicAgencies, List<String> otherAgencies,
			List<String> siteQualifications, List<String> accountManagers) throws InterruptedException {

		// elementUtils.waitForElementVisible(inputSiteID,
		// Constants.DEFAULT_WAIT).sendKeys(siteID);
		elementUtils.waitForElementVisible(inputSiteName, Constants.DEFAULT_WAIT).sendKeys(siteName);

		// Handle list dropdowns
//		selectMultipleOptions(dropdownAgencybeat, agencyBeat);
//		elementUtils.doSelectByValue(callresponse, callResponse); 
		selectMultipleOptions(dropdownAgencybeat, agencyBeat);
		elementUtils.doSelectByValue(callresponse, callResponse); 
		
		elementUtils.sendKeysUsingJavaScript(selectStartingpoint, startingPoint, Constants.DEFAULT_WAIT);
		elementUtils.sendKeysUsingJavaScript(selectendingpoint, endingPoint, Constants.DEFAULT_WAIT);

		// Checkboxes
		if (isStationary)
			elementUtils.doClickWithActionsAndWait(checkboxStationary, Constants.DEFAULT_WAIT);
		if (isMobile)
			elementUtils.doClickWithActionsAndWait(checkboxMobile, Constants.DEFAULT_WAIT);
		if (isPayPostRate)
			elementUtils.doClickWithActionsAndWait(checkboxPaypostrate, Constants.DEFAULT_WAIT);
		if (isAutoReport)
			elementUtils.doClickWithActionsAndWait(checkboxautoreport, Constants.DEFAULT_WAIT);
		if (isPdfReport)
			elementUtils.doClickWithActionsAndWait(checkboxPdfreport, Constants.DEFAULT_WAIT);

		elementUtils.sendKeysUsingJavaScript(reporttime, reportTime, Constants.DEFAULT_WAIT);
		elementUtils.waitForElementVisible(clientEmail, Constants.DEFAULT_WAIT).sendKeys(clientEmailID);

		// Handle multi-select lists
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

	public void fillAddressDetails(String streetNumber, String streetName, String city, String state, String zipCode) {
		elementUtils.waitForElementVisible(inputStreetnumber, Constants.DEFAULT_WAIT).sendKeys(streetNumber);
		elementUtils.waitForElementVisible(inputStreetname, Constants.DEFAULT_WAIT).sendKeys(streetName);
		elementUtils.waitForElementVisible(inputStreeCity, Constants.DEFAULT_WAIT).sendKeys(city);
		elementUtils.doSelectBy(inputStreeState, state);
		elementUtils.waitForElementVisible(inputZipcode, Constants.DEFAULT_WAIT).sendKeys(zipCode);
	}

	public void fillGeofencingDetails(String radiusType, String radiusValue) {
		elementUtils.doSelectBy(DropdownGeofencing, radiusType);
		elementUtils.waitForElementVisible(inputtyperadius, Constants.DEFAULT_WAIT).sendKeys(radiusValue);
	}

	public void fillMainContactDetails(String contactName, String contactLastName, String contactPhone, String mobile,
			String contactFax, String contactEmail) {
		elementUtils.waitForElementVisible(inputContactname, Constants.DEFAULT_WAIT).sendKeys(contactName);
		elementUtils.waitForElementVisible(inputConatactlastname, Constants.DEFAULT_WAIT).sendKeys(contactLastName);
		elementUtils.waitForElementVisible(inputConatctPhone, Constants.DEFAULT_WAIT).sendKeys(contactPhone);
		elementUtils.waitForElementVisible(inputmobile, Constants.DEFAULT_WAIT).sendKeys(mobile);
		elementUtils.waitForElementVisible(inputContactfax, Constants.DEFAULT_WAIT).sendKeys(contactFax);
		elementUtils.waitForElementVisible(inputContactemail, Constants.DEFAULT_WAIT).sendKeys(contactEmail);
	}

	public void clickAddSiteContact() {
		elementUtils.waitForElementVisible(btnAddSiteContact, Constants.DEFAULT_WAIT).click();
	}

	public void fillSiteContactDetails(String contactFirstName, String contactLastName, String contactPhone) {
		elementUtils.waitForElementVisible(txtboxJobTitle, Constants.DEFAULT_WAIT).sendKeys(contactFirstName);
		elementUtils.waitForElementVisible(txtboxContactName, Constants.DEFAULT_WAIT).sendKeys(contactLastName);
		elementUtils.waitForElementVisible(txtboxNewContactPhone, Constants.DEFAULT_WAIT).sendKeys(contactPhone);
	}

	public void clickSaveAndNext() throws InterruptedException {
		elementUtils.waitForElementVisible(btnSaveAndNext, Constants.DEFAULT_WAIT).click();
		Thread.sleep(60000);
	}
	
	public void fillPropertyAccessDetails(String gateCode, String alarmArm, String alarmUnarm, String alarmNotes, boolean hasLockBox, String lockBoxCode, String lockBoxNotes) {
		elementUtils.waitForElementVisible(inputGatecode, Constants.DEFAULT_WAIT).sendKeys(gateCode);
		elementUtils.waitForElementVisible(inputAlarmaem, Constants.DEFAULT_WAIT).sendKeys(alarmArm);
		elementUtils.waitForElementVisible(inputunarm, Constants.DEFAULT_WAIT).sendKeys(alarmUnarm);
		elementUtils.waitForElementVisible(txtAlarmNotes, Constants.DEFAULT_WAIT).sendKeys(alarmNotes);
		if (hasLockBox) {
			elementUtils.doClickWithActionsAndWait(radiobtnLockbox, Constants.DEFAULT_WAIT);
			elementUtils.waitForElementVisible(inputLockBoxcode, Constants.DEFAULT_WAIT).sendKeys(lockBoxCode);
			elementUtils.waitForElementVisible(txtinputlockboxNotes, Constants.DEFAULT_WAIT).sendKeys(lockBoxNotes);
		}
	}
		
		public void fillParkingEnforcementDetails(String towingCompanyName, String towingCompanyPhone, boolean hasTowing, String towingNotes, boolean hasParkingEnforcement, String parkingNotes) {
			elementUtils.waitForElementVisible(inputtowName, Constants.DEFAULT_WAIT).sendKeys(towingCompanyName);
			elementUtils.waitForElementVisible(inputTowphone, Constants.DEFAULT_WAIT).sendKeys(towingCompanyPhone);
			if (hasTowing) {
				elementUtils.doClickWithActionsAndWait(radiobtn, Constants.DEFAULT_WAIT);
				elementUtils.waitForElementVisible(TowingNotes, Constants.DEFAULT_WAIT).sendKeys(towingNotes);
				
			}
			if (hasParkingEnforcement) {
				elementUtils.doClickWithActionsAndWait(radiobtnparkingenforce, Constants.DEFAULT_WAIT);
				elementUtils.waitForElementVisible(txtparkingNotes, Constants.DEFAULT_WAIT).sendKeys(parkingNotes);
			}
}
		
		public void fillsitereportinstrctions(String txtreport ) {
			elementUtils.waitForElementVisible(txtreportinstructions , Constants.DEFAULT_WAIT).sendKeys(txtreport);
		}
	
		public void filloverallsitercoverage(String txtoverallcoverage ) {
			elementUtils.waitForElementVisible(txtoverallsitecoverage , Constants.DEFAULT_WAIT).sendKeys(txtoverallcoverage);
		}
		public void fillMobileCoverageDetails(
		        String coverageName, String serviceTypeValue,String billingTypemob,String billingRate,String holidayRate,String coverageEndDate, String dayStartTime, 
		        String dayEndTime, String dayHits, String swingHits, String nightHits,String dayNotes, String swingNotes, String nightNotes,
		        boolean copyTimesToAll, 
		        boolean copyHitsToAll) {

		    // Click Add Mobile Coverage
		    elementUtils.doClickWithActionsAndWait(btnAddMobileCoverage, Constants.DEFAULT_WAIT);

		    // Enter Coverage Name
		    elementUtils.waitForElementVisible(txtinputbCoveragename, Constants.DEFAULT_WAIT).sendKeys(coverageName);

		    // Select Service Type
		    elementUtils.waitForElementVisible(dropdownservicetype, Constants.DEFAULT_WAIT).click();
		    elementUtils.waitForElementVisible(By.xpath("//option[@value='" + serviceTypeValue + "']"), Constants.DEFAULT_WAIT).click();

		    // Enter Billing and Holiday Rates
		    elementUtils.waitForElementVisible(DropdownMobBillingType, Constants.DEFAULT_WAIT).sendKeys(billingTypemob);
		    elementUtils.waitForElementVisible(inputBillingrates, Constants.DEFAULT_WAIT).sendKeys(billingRate);
		    elementUtils.waitForElementVisible(inputHolidayrates, Constants.DEFAULT_WAIT).sendKeys(holidayRate);

		    // Enter Coverage End Date
		    elementUtils.waitForElementVisible(inputCoverageEnddate, Constants.DEFAULT_WAIT).sendKeys(coverageEndDate);

		    // Enter Day Start and End Times
		    elementUtils.waitForElementVisible(dayStarttime, Constants.DEFAULT_WAIT).sendKeys(dayStartTime);
		    elementUtils.waitForElementVisible(dayEndtime, Constants.DEFAULT_WAIT).sendKeys(dayEndTime);

		    // Copy Day Time to All if required
		    if (copyTimesToAll) {
		        elementUtils.doClickWithActionsAndWait(copytoalldaytime, Constants.DEFAULT_WAIT);
		    }

		    // Enter Number of Hits
		    elementUtils.waitForElementVisible(dayNumberHits, Constants.DEFAULT_WAIT).sendKeys(dayHits);
		    elementUtils.waitForElementVisible(SwingNumberHits, Constants.DEFAULT_WAIT).sendKeys(swingHits);
		    elementUtils.waitForElementVisible(nightNumberHits, Constants.DEFAULT_WAIT).sendKeys(nightHits);

		    // Copy Hits to All if required
		    if (copyHitsToAll) {
		        elementUtils.doClickWithActionsAndWait(copytoallSwings, Constants.DEFAULT_WAIT);
		    }

		    // Enter Coverage Notes
		    elementUtils.waitForElementVisible(textDayCoverageNotes, Constants.DEFAULT_WAIT).sendKeys(dayNotes);
		    elementUtils.waitForElementVisible(textSwingCoverageNotes, Constants.DEFAULT_WAIT).sendKeys(swingNotes);
		    elementUtils.waitForElementVisible(textNightCoverageNotes, Constants.DEFAULT_WAIT).sendKeys(nightNotes);
		}
		
		public void fillStationaryCoverageDetails(
		        String coverageName,String serviceTypeValue,String coverageEndDate,String billingtypestat,String billingRate,String holidayRate,String postRate,
		        String allowanceRate,String allowanceTypeValue,String startTime,String endTime,String dayNotes,String swingNotes,
		        String nightNotes,
		        boolean copyTimesToAll) throws InterruptedException {

		    // Click Add Stationary Coverage
		    elementUtils.doClickWithActionsAndWait(btnAddStationaryCoverage, Constants.DEFAULT_WAIT);
		    

		    // Enter Coverage Name
		    elementUtils.waitForElementVisible(txtinputStationaryCoveragename, Constants.DEFAULT_WAIT).sendKeys(coverageName);
		    Thread.sleep(5000);
		    // Select Service Type
//		    elementUtils.waitForElementVisible(dropdownStationaryservicetype, Constants.DEFAULT_WAIT).click();
		    
		    
		    
//		    WebElement ele = elementUtils.waitForElementVisible(
//		            By.xpath("//option[contains(normalize-space(.),'" + serviceTypeValue + "')]"),
//		            Constants.DEFAULT_WAIT
//		    );
//		    ele.click();
		    elementUtils.doSelectBy(dropdownStationaryservicetype, serviceTypeValue);
		    elementUtils.sendKeysUsingJavaScript(CoverageEnddate, coverageEndDate, 30);

		    // Enter Coverage End Date
//		    WebElement endDateElement = elementUtils.waitForElementVisible(CoverageEnddate, Constants.DEFAULT_WAIT);
//
//		    // Better: clear first
//		    endDateElement.click();
//		    endDateElement.clear();
//
//		    // Actions chain in one go
//		    new Actions(driver)
//		            .moveToElement(endDateElement)
//		            .click()
//		            .sendKeys(coverageEndDate)
//		            .build()
//		            .perform();
		    // Enter Billing Rates
		    elementUtils.waitForElementVisible(DropdownStaBillingType, Constants.DEFAULT_WAIT).sendKeys(billingtypestat);
		    elementUtils.waitForElementVisible(inputtextBillingRates, Constants.DEFAULT_WAIT).sendKeys(billingRate);
		    elementUtils.waitForElementVisible(inputtextHolidayRates, Constants.DEFAULT_WAIT).sendKeys(holidayRate);
		    elementUtils.waitForElementVisible(inputtextPostRates, Constants.DEFAULT_WAIT).sendKeys(postRate);

		    // Add Allowance if provided
		    if (allowanceRate != null && !allowanceRate.isEmpty()) {
		        elementUtils.doClickWithActionsAndWait(iconAddAllowance, Constants.DEFAULT_WAIT);
		        elementUtils.waitForElementVisible(textboxAllowanceRate, Constants.DEFAULT_WAIT).sendKeys(allowanceRate);
		        elementUtils.waitForElementVisible(AllowanceType, Constants.DEFAULT_WAIT).click();
		        elementUtils.waitForElementVisible(By.xpath("//option[@value='" + allowanceTypeValue + "']"), Constants.DEFAULT_WAIT).click();
		    }

		    // Enter Start and End Times
		    elementUtils.waitForElementVisible(startStationarytime, Constants.DEFAULT_WAIT).sendKeys(startTime);
		    elementUtils.waitForElementVisible(endStationarytime, Constants.DEFAULT_WAIT).sendKeys(endTime);

		    // Copy time to all shifts if required
		    if (copyTimesToAll) {
		        elementUtils.doClickWithActionsAndWait(copytoallStationarytime, Constants.DEFAULT_WAIT);
		    }

		    // Enter Coverage Notes
		    elementUtils.waitForElementVisible(textStationaryCoverageNotes, Constants.DEFAULT_WAIT).sendKeys(dayNotes);
		    elementUtils.waitForElementVisible(textStationarySwingCoverageNotes, Constants.DEFAULT_WAIT).sendKeys(swingNotes);
		    elementUtils.waitForElementVisible(textStationaryNightCoverageNotes, Constants.DEFAULT_WAIT).sendKeys(nightNotes);
		}
		
		public void fillSiteAreaDetails(
		        String areaName,
		        String doorGateCount,
		        String areaNotes,
		        String lockupTime,
		        String unlockTime,
		        boolean copyTimeToAll) {

		    // Click Add New Site Area
		    elementUtils.doClickWithActionsAndWait(btnAddnewsitearea, Constants.DEFAULT_WAIT);

		    // Enter Area Name
		    elementUtils.waitForElementVisible(inputAreaname, Constants.DEFAULT_WAIT).sendKeys(areaName);

		    // Enter Door/Gate Count
		    elementUtils.waitForElementVisible(inputdoorgatecount, Constants.DEFAULT_WAIT).sendKeys(doorGateCount);

		    // Enter Area Notes
		    elementUtils.waitForElementVisible(txtareanotes, Constants.DEFAULT_WAIT).sendKeys(areaNotes);

		    // Enter Lockup and Unlock Times
		    elementUtils.waitForElementVisible(inputlockuptime, Constants.DEFAULT_WAIT).sendKeys(lockupTime);
		    elementUtils.waitForElementVisible(inputunlocktime, Constants.DEFAULT_WAIT).sendKeys(unlockTime);

		    // Copy times to all if required
		    if (copyTimeToAll) {
		        elementUtils.doClickWithActionsAndWait(inputCopytoall, Constants.DEFAULT_WAIT);
		    }
		}

//		public void fillTemporaryPostOrderDetails(
//		        String expireDate,
//		        String expireTime,
//		        String postOrderText) {
//
//		    // Click Create New button
//		    elementUtils.doClickWithActionsAndWait(btnCreateNew, Constants.DEFAULT_WAIT);
//
//		    // Enter Expire Date
//		    elementUtils.waitForElementVisible(ModalinputExpiredate, Constants.DEFAULT_WAIT).sendKeys(expireDate);
//
//		    // Enter Expire Time
//		    elementUtils.waitForElementVisible(ModalexpireTime, Constants.DEFAULT_WAIT).sendKeys(expireTime);
//
//		    // Enter Post Order Text
//		    elementUtils.waitForElementVisible(ModaltxtPostorder, Constants.DEFAULT_WAIT).sendKeys(postOrderText);
//
//		    // Click Add Temporary Post Order
//		    elementUtils.doClickWithActionsAndWait(btnAddtempost, Constants.DEFAULT_WAIT);
//		}
//
		
		public void fillSiteDocPaymentTerms(
		        String firstName,
		        String lastName,
		        String companyName,
		        String displayName,
		        String phone,
		        String mobile,
		        String fax,
		        String email,
		        String terms,
		        String billingCycle,
		        String billingStartDate,
		        String invoiceNumber,
		        boolean autoSelectBillingCycle,
		        boolean Togglehours ,
		        String streetNumber,
		        String streetName,
		        String city,
		        String state,
		        String zipCode,
		        String country)  {

		    // Navigate to Site Doc / Payment Terms
//		    elementUtils.doClickWithActionsAndWait(btnnavSiteDoc, Constants.DEFAULT_WAIT);

		    // Fill client details
		    elementUtils.waitForElementVisible(inputClientname, Constants.DEFAULT_WAIT).sendKeys(firstName);
		    elementUtils.waitForElementVisible(inputClientLastname, Constants.DEFAULT_WAIT).sendKeys(lastName);
		    elementUtils.waitForElementVisible(inputClientCompanyname, Constants.DEFAULT_WAIT).sendKeys(companyName);
		    elementUtils.waitForElementVisible(inputClientdisplayname, Constants.DEFAULT_WAIT).sendKeys(displayName);
		    elementUtils.waitForElementVisible(inputClientPhone, Constants.DEFAULT_WAIT).sendKeys(phone);
		    elementUtils.waitForElementVisible(inputClientMobile, Constants.DEFAULT_WAIT).sendKeys(mobile);
		    elementUtils.waitForElementVisible(inputClientFax, Constants.DEFAULT_WAIT).sendKeys(fax);
		    elementUtils.waitForElementVisible(inputClientEmail, Constants.DEFAULT_WAIT).sendKeys(email);
		    elementUtils.waitForElementVisible(inputClienterms, Constants.DEFAULT_WAIT).sendKeys(terms);

		    // Billing cycle selection (dynamic)
		    if (autoSelectBillingCycle) {
		        WebElement dropdown = elementUtils.waitForElementVisible(dropdownBilling, Constants.DEFAULT_WAIT);
		        Select select = new Select(dropdown);
		        select.selectByVisibleText("Weekly");

		    }


		    // Fill billing start date and invoice number
		    elementUtils.waitForElementVisible(billingStartdate, Constants.DEFAULT_WAIT).sendKeys(billingStartDate);
		    elementUtils.waitForElementVisible(invoiceNumbers, Constants.DEFAULT_WAIT).sendKeys(invoiceNumber);
		    if (Togglehours) {
		        elementUtils.doClickWithActionsAndWait(togglebtnHours, Constants.DEFAULT_WAIT);
		    }
		    
		    elementUtils.waitForElementVisible(inputBillingaddess, Constants.DEFAULT_WAIT).sendKeys(streetNumber);
		    elementUtils.waitForElementVisible(inputClientStreetname, Constants.DEFAULT_WAIT).sendKeys(streetName);
		    elementUtils.waitForElementVisible(inputClientcity, Constants.DEFAULT_WAIT).sendKeys(city);

		    WebElement stateDropdown = elementUtils.waitForElementVisible(DropdownClientState, Constants.DEFAULT_WAIT);
		    Select stateSelect = new Select(stateDropdown);
		    stateSelect.selectByValue(state);


		    elementUtils.waitForElementVisible(inputClientZipcode, Constants.DEFAULT_WAIT).sendKeys(zipCode);
		    elementUtils.waitForElementVisible(inputClientCountry, Constants.DEFAULT_WAIT).sendKeys(country);
		    
		}
		public void addCompliments(String Comments) {
			elementUtils.waitForElementVisible(textComments, Constants.DEFAULT_WAIT).sendKeys(Comments);}
		
		
		public void enableSiteAndShowEnabled(String disableOption, String enableOption) throws InterruptedException {
		    // 1. Click Filters
		    elementUtils.doClickWithActionsAndWait(btnFilters, Constants.DEFAULT_WAIT);

		    // 2. Select 'Show Disable' to find disabled sites
		    WebElement dropdown = elementUtils.waitForElementVisible(dropdownStatus, Constants.DEFAULT_WAIT);
		    Select select = new Select(dropdown);
		    Thread.sleep(5000);
		    select.selectByVisibleText(disableOption);
		    Thread.sleep(5000);
		    // 3. Click the toggle to enable the first site
		    elementUtils.doClickWithActionsAndWait(btntoggle, Constants.DEFAULT_WAIT);
		    
		    // 4. Click OK in modal
		    elementUtils.doClickWithActionsAndWait(btnmodalOk, Constants.DEFAULT_WAIT);
		    Thread.sleep(50000);
		    // 5. Click Filters again
		    elementUtils.doClickWithActionsAndWait(btnFilters, Constants.DEFAULT_WAIT);

		    // 6. Select 'Show Enabled' to view enabled sites
		    WebElement dropdown2 = elementUtils.waitForElementVisible(dropdownStatus, Constants.DEFAULT_WAIT);
		    Select select2 = new Select(dropdown2);
		    select2.selectByVisibleText(enableOption);
		    Thread.sleep(5000);
		}



		
		
}