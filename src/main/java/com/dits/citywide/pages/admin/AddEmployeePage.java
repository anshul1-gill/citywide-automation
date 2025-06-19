package com.dits.citywide.pages.admin;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.dits.citywide.constants.Constants;
import com.dits.citywide.utilities.Calendar;
import com.dits.citywide.utilities.ElementUtils;
import com.dits.citywide.utilities.StringUtils;

public class AddEmployeePage {

	private WebDriver driver;
	private ElementUtils elementUtils;

// 1. Personal Information

	// Upload User Profile Picture
	private By txtUploadUserProfilePicture = By.xpath("//div[text()='Upload User Profile Picture']");
	private By imgUpload = By.xpath("//input[@type='file']");

	private By txtImageUploadSucessMessage = By.xpath("//div[contains(text(),'Upload successfully.')]");

	// Personal Information
	private By txtPersonalInformation = By.xpath("(//div[text()='Personal Information'])[2]");
	private By txtboxFirstName = By.id("Personal Information_first_name");
	private By txtboxMiddleName = By.id("Personal Information_middle_name");
	private By txtboxLastName = By.id("Personal Information_last_name");
	private By dropdownGender = By.xpath("(//span[@class='ant-select-selection-placeholder'])[1]");
	private By genderValues = By.xpath("//div[@class='rc-virtual-list-holder-inner']/div/div");
	private By birthDatecalender = By.cssSelector("input[id='Personal Information_birthdate']");
	private By txtboxSocialSecurityNumber = By.id("Personal Information_social_security_number");

	private By dropdownRole = By.xpath("(//div[@class='ant-select-selection-search'])[1]");

	private By dropdownRank = By.xpath("(//span[@class='ant-select-selection-search'])[3]");

	private By dropdownEthnicCode = By.xpath("(//span[@class='ant-select-selection-search'])[4]");

	private By txtboxPrimaryEmail = By.id("Personal Information_email");
	private By txtboxAlternateEmail = By.id("Personal Information_email_address_alternate");

	private By dropdownPrimaryPhoneNumberCountryCode = By.xpath("(//div[@class='selected-flag'])[1]");
	private By countrycodeList = By.xpath("//ul[@class='country-list ']/li/span");
	private By txtboxPrimaryPhoneNumber = By.xpath("(//input[@type='tel'])[1]");

	private By dropdownSecondaryPhoneNumberCountryCode = By.xpath("(//div[@class='selected-flag'])[2]");
	private By txtboxSecondaryPhoneNumber = By.xpath("(//input[@type='tel'])[2]");

	private By txtboxEmergencyName = By.id("Personal Information_emergency_contact_name");

	private By dropdownEmergencyNumberCountryCode = By.xpath("(//div[@class='selected-flag'])[3]");
	private By txtboxEmergencyNumber = By.xpath("(//input[@type='tel'])[3]");

	private By txtboxEmergencyRelationship = By.id("Personal Information_emergency_contact_relationship");

	private By txtboxPassword = By.id("Personal Information_password");
	private By txtboxConfirmPassword = By.id("Personal Information_confirm_password");

	private By dropdownBranches = By.xpath("(//div[@class='ant-select-selection-search'])[2]");

	private By dropdownBlacklistedSite = By.xpath("(//div[@class='ant-select-selection-search'])[3]");

	// Residence Address
	private By txtboxStreetName = By.id("Personal Information_residence_street_address_2");
	private By txtboxStreetId = By.id("Personal Information_residence_street_address_1");
	private By txtboxStreetNumber = By.id("Personal Information_residence_address");
	private By txtboxCity = By.id("Personal Information_residence_city");

	private By dropdownState = By.id("Personal Information_residence_state");
	// private By dropdownStateValues =
	// By.xpath("(//div[@class='rc-virtual-list-holder-inner'])[5]/div");

	private By txtboxZipCode = By.id("Personal Information_residence_zip_code");

	private By dropdownCountry = By.id("Personal Information_residence_country");
	private By countrySearch = By.id("Personal Information_residence_country");
	private By dropdownCountryValues = By.xpath("//div[@class='ant-select-item-option-content']");

	// Mailing Address
	private By checkboxSameAsAbove = By.xpath("(//span[contains(text(),'Same as above')])[1]");

	private By txtboxMailingAddressStreetName = By.id("Personal Information_mailing_street_address_2");
	private By txtboxMailingAddressStreetId = By.id("Personal Information_mailing_street_address_1");
	private By txtboxMailingAddressStreetNumber = By.id("Personal Information_mailing_address");
	private By txtboxMailingAddressCity = By.id("Personal Information_mailing_city");

	private By dropdownMailingState = By.id("Personal Information_mailing_state");
	private By dropdownMailingStateValues = By.xpath("(//div[@class='rc-virtual-list-holder-inner'])[9]/div");

	private By txtboxMailingZipCode = By.id("Personal Information_mailing_zip_code");

	private By dropdownMailingCountry = By.id("Personal Information_mailing_country");
	private By dropdownMailingCountryValues = By.xpath("(//div[@class='rc-virtual-list-holder-inner'])[10]/div");

	private By txtboxNote = By.id("Personal Information_emergency_note");

// 2. Employment Information
	private By tabEmploymentInformation = By.xpath("//div[text()='Employment Information']");

	// Employment Information
	private By dropdownEmploymentStatus = By.xpath("(//span[@class='ant-select-selection-item'])[2]");
	private By dropdownEmploymentStatusValues = By.xpath("//div[@class='rc-virtual-list-holder-inner']/div/div");
	private By calenderHireDate = By.id("Employment Information_hire_date");
	private By employeeId = By.cssSelector("input[id='Employment Information_badge_number']");
	private By txtboxEmploymentInformationNotes = By.id("Employment Information_employement_notes");

	// Class Code
	private By dropdownWCClassCode = By.xpath("(//span[contains(@class,'ant-select-selection-search')])[3]");
	private By classCodeSearch = By.id("Employment Information_class_code_0_class_code");
	private By dropdownWCClassCodeValues = By.xpath("(//div[@class='rc-virtual-list-holder-inner'])[2]/div/div");

	// Employment Type
	private By dropdownEmploymentType = By.xpath("(//span[@class='ant-select-selection-search'])[4]");
	private By employmentTypeSearch = By.id("Employment Information_employment_type_0_employment_type");
	private By dropdownEmploymentTypeValues = By.xpath("(//div[@class='rc-virtual-list-holder-inner'])[3]/div/div");

	// Department Type
	private By dropdownDepartmentType = By.xpath("(//span[@class='ant-select-selection-search'])[5]");
	private By departmentTypeSearch = By.id("Employment Information_department_type_0_department");
	private By dropdownDepartmentTypeValues = By.xpath("(//div[@class='rc-virtual-list-holder-inner'])[4]/div/div");

// 3. Permits
	private By tabPermits = By.xpath("//div[text()='Permits']");

	// License Details
	private By btnAddLicenseDetails = By.xpath("//span[contains(text(), 'Add License Details')]");
	private By txtDriverLicense = By.xpath(
			"//div[contains(@class,'ant-card ant-card-bordered overview')]//span[@class='baseTitle']");
	private By dropdownLicenseState = By.xpath("(//span[@class='ant-select-selection-search'])[2]");
	private By txtboxDriverLicenseNumber = By.id("permit_number");
	private By calenderDateOfIssue = By.xpath("(//div[@class='ant-picker-input'])[1]");
	private By calenderDateOfIssueSearch = By.id("date_of_issue");
	private By calenderDateOfExpiration = By.xpath("(//div[@class='ant-picker-input'])[2]");
	private By calenderDateOfExpirationSearch = By.id("date_of_expiry");
	private By uploadDriverLicense = By.xpath("//input[@type='file']");
	private By btnAddLicense = By.xpath("(//span[contains(text(),'Add License Details')])[2]");

	private By dataDriverLicenseNumber = By
			.xpath("//tbody[@class='ant-table-tbody']//td[@data-label=\"Driver's License Number\"]");
	private By dataDateOfIssue = By.xpath("//tbody[@class='ant-table-tbody']//td[@data-label='Date of Issue']");
	private By dataDateOfExpiration = By
			.xpath("//tbody[@class='ant-table-tbody']//td[@data-label='Date of Expiration']");
	private By dataState = By.xpath("//tbody[@class='ant-table-tbody']//td[@data-label='State']");

	// Guard Card
	private By btnAddGuardCard = By.xpath("//span[contains(text(), 'Add Guard Card')]");
	private By txtGuardCard = By.xpath(
			"//div[contains(@class,'ant-card ant-card-bordered overview')]//span[@class='baseTitle']");
	private By txtboxGuardCardPermitNumber = By.id("permit_number");

	private By calenderDateOfIssueGuardCard = By.xpath("//label[@title='Date of Issue']");
	private By calenderDateOfIssueSearchGuardCard = By.id("date_of_issue");
	private By calenderDateOfExpirationGuardCard = By.xpath("//label[@title='Date of Expiration']");
	private By calenderDateOfExpirationSearchGuardCard = By.id("date_of_expiry");
	private By btnSaveGuardCard = By.xpath("(//span[contains(text(),'Add Guard Card')])[2]");

	private By dataGaurdCardPermitNumber = By
			.xpath("//tbody[@class='ant-table-tbody']//td[@data-label='Permit Number']");
	private By dataGaurdCardDateOfIssue = By
			.xpath("(//tbody[@class='ant-table-tbody']//td[@data-label='Date of Issue'])[2]");
	private By dataGaurdCardDateOfExpiration = By
			.xpath("(//tbody[@class='ant-table-tbody']//td[@data-label='Date of Expiration'])[2]");

	// Firearms Qualification
	private By btnAddFirearmsQualification = By.xpath("//span[contains(text(), 'Add Firearms Qualification')]");
	private By txtFirearmsQualification = By.xpath(
			"//div[contains(@class,'ant-card ant-card-bordered overview')]//span[@class='baseTitle']");

	private By txtboxFirearmsPermitNumber = By.id("permit_number");
	private By calenderDateOfIssueFirearms = By.xpath("//label[@title='Date of Issue']");
	private By calenderDateOfIssueSearchFirearms = By.id("date_of_issue");
	private By calenderDateOfExpirationFirearms = By.xpath("//label[@title='Date of Expiration']");
	private By calenderDateOfExpirationSearchFirearms = By.id("date_of_expiry");

	private By txtboxFirearmsCaliber = By.id("firearms_0_caliber");
	private By txtboxFirearmsSerial = By.id("firearms_0_serial");
	private By txtboxFirearmsMake = By.id("firearms_0_make");
	private By txtboxFirearmsModel = By.id("firearms_0_model");

	private By btnSaveFirearms = By.xpath("(//span[contains(text(),'Add Firearms Qualification')])[2]");

	private By dataFirearmsPermitNumber = By
			.xpath("(//tbody[@class='ant-table-tbody']//td[@data-label='Permit Number'])[2]");
	private By dataFirearmsDateOfIssue = By
			.xpath("(//tbody[@class='ant-table-tbody']//td[@data-label='Date of Issue'])[3]");
	private By dataFirearmsDateOfExpiration = By
			.xpath("(//tbody[@class='ant-table-tbody']//td[@data-label='Date of Expiration'])[3]");

	// Baton
	private By btnAddBaton = By.xpath("//span[contains(text(), 'Add Baton')]");
	private By txtBaton = By.xpath(
			"//div[contains(@class,'ant-card ant-card-bordered overview')]//span[@class='baseTitle']");
	private By txtboxBatonPermitNumber = By.id("permit_number");
	private By calenderDateOfIssueBaton = By.xpath("//label[@title='Date of Issue']");
	private By calenderDateOfIssueSearchBaton = By.id("date_of_issue");
	private By calenderDateOfExpirationBaton = By.xpath("//label[@title='Date of Expiration']");
	private By calenderDateOfExpirationSearchBaton = By.id("date_of_expiry");

	private By btnSaveBaton = By.xpath("(//span[contains(text(),'Add Baton')])[2]");

	private By dataBatonPermitNumber = By
			.xpath("(//tbody[@class='ant-table-tbody']//td[@data-label='Permit Number'])[3]");
	private By dataBatonDateOfIssue = By
			.xpath("(//tbody[@class='ant-table-tbody']//td[@data-label='Date of Issue'])[4]");
	private By databatonDateOfExpiration = By
			.xpath("(//tbody[@class='ant-table-tbody']//td[@data-label='Date of Expiration'])[4]");

	// ECD
	private By btnAddECD = By.xpath("//span[contains(text(), 'Add ECD')]");
	private By txtECD = By.xpath(
			"//div[contains(@class,'ant-card ant-card-bordered overview')]//span[@class='baseTitle']");
	private By txtboxPermitNumberECD = By.id("permit_number");
	private By calenderDateOfIssueECD = By.xpath("//label[@title='Date of Issue']");
	private By calenderDateOfIssueSearchECD = By.id("date_of_issue");
	private By calenderDateOfExpirationECD = By.xpath("//label[@title='Date of Expiration']");
	private By calenderDateOfExpirationSearchECD = By.id("date_of_expiry");

	private By btnSaveECD = By.xpath("(//span[contains(text(), 'Add ECD')])[2]");

	private By dataECDPermitNumber = By
			.xpath("(//tbody[@class='ant-table-tbody']//td[@data-label='Permit Number'])[4]");
	private By dataECDDateOfIssue = By.xpath("(//tbody[@class='ant-table-tbody']//td[@data-label='Date of Issue'])[5]");
	private By dataECDDateOfExpiration = By
			.xpath("(//tbody[@class='ant-table-tbody']//td[@data-label='Date of Expiration'])[5]");

	// OC Spray
	private By btnAddOCSpray = By.xpath("//span[contains(text(), 'Add OC Spray')]");
	private By txtOCSpray = By.xpath(
			"//div[contains(@class,'ant-card ant-card-bordered overview')]//span[@class='baseTitle']");
	private By txtboxPermitNumberOCSpray = By.id("permit_number");
	private By calenderDateOfIssueOCSpray = By.xpath("//label[@title='Date of Issue']");
	private By calenderDateOfIssueSearchOCSpray = By.id("date_of_issue");
	private By calenderDateOfExpirationOCSpray = By.xpath("//label[@title='Date of Expiration']");
	private By calenderDateOfExpirationSearchOCSpray = By.id("date_of_expiry");

	private By btnSaveOCSpray = By.xpath("(//span[contains(text(), 'Add OC Spray')])[2]");
	private By dataOCSprayPermitNumber = By
			.xpath("(//tbody[@class='ant-table-tbody']//td[@data-label='Permit Number'])[5]");
	private By dataOCSprayDateOfIssue = By
			.xpath("(//tbody[@class='ant-table-tbody']//td[@data-label='Date of Issue'])[6]");
	private By dataOCSprayDateOfExpiration = By
			.xpath("(//tbody[@class='ant-table-tbody']//td[@data-label='Date of Expiration'])[6]");

	// Other Permit
	private By btnAddOtherPermit = By.xpath("//span[contains(text(), 'Add Other Permit')]");
	private By txtOtherPermit = By.xpath(
			"//div[contains(@class,'ant-card ant-card-bordered overview')]//span[@class='baseTitle']");
	private By txtboxPermitNumberOtherPermit = By.id("permit_number");
	private By calenderDateOfIssueOtherPermit = By.xpath("//label[@title='Date of Issue']");
	private By calenderDateOfIssueSearchOtherPermit = By.id("date_of_issue");
	private By calenderDateOfExpirationOtherPermit = By.xpath("//label[@title='Date of Expiration']");
	private By calenderDateOfExpirationSearchOtherPermit = By.id("date_of_expiry");

	private By btnSaveOtherPermit = By.xpath("(//span[contains(text(),'Add Other Permit')])[2]");
	private By dataOtherPermitPermitNumber = By
			.xpath("(//tbody[@class='ant-table-tbody']//td[@data-label='Permit Number'])[6]");
	private By dataOtherPermitDateOfIssue = By
			.xpath("(//tbody[@class='ant-table-tbody']//td[@data-label='Date of Issue'])[7]");
	private By dataOtherPermitDateOfExpiration = By
			.xpath("(//tbody[@class='ant-table-tbody']//td[@data-label='Date of Expiration'])[7]");

//4. Pay Information
	private By tabPayInformation = By.xpath("//div[text()='Pay Information' and @class='menuItem']");
	private By txtboxEmployeePayRate = By.id("Pay Information_pay_info_0_pay_rate");
	private By dropdownPayCycle = By.xpath("(//span[contains(@class,'ant-select-selection-search')])[2]");
	private By dropdownValuesPayCycle = By.xpath("(//div[@class='rc-virtual-list-holder-inner'])[1]/div/div");
	private By checkboxAdditionalPay = By.xpath("//span[@class='ant-checkbox-label']");
	private By txtboxAllowanceRate = By.id("Pay Information_pay_info_0_allowanceList_0_allowance_rate");
	private By dropdownAllowanceType = By.xpath("(//span[contains(@class,'ant-select-selection-search')])[3]");
	private By dropdownSearchAllowanceType = By.id("Pay Information_pay_info_0_allowanceList_0_allowance_id");

	private By txtboxCommissionName = By.id("Pay Information_commission_info_0_pay_commission");

	private By dropdownCommissionType = By.xpath("(//span[@class='ant-select-selection-search'])[3]");
	private By dropdownSearchCommissionType = By.id("Pay Information_commission_info_0_commission_type");

	private By txtboxCommissionRate = By.id("Pay Information_commission_info_0_commission_rate");

	private By dropdownCommissionCycle = By.xpath("(//span[contains(@class,'ant-select-selection-search')])[4]");
	private By dropdownSearchCommissionCycle = By.id("Pay Information_commission_info_0_commission_cycle");

	private By calenderEffectiveDate = By.xpath("//div[@class='ant-picker-input']");
	private By calenderSearchEffectiveDate = By.id("Pay Information_commission_info_0_commission_efffective_date");

//5. Additional Documents
	private By tabAdditionalDocuments = By.xpath("//div[text()='Additional Documents' and @class='menuItem']");
	// Upload Document
	private By btnAddAdditionalDocument = By.xpath("//span[normalize-space()='Add Additional Document']");
	private By txtAdditionalDocument = By.xpath(
			"//div[contains(@class,'ant-card ant-card-bordered overview')]//span[@class='baseTitle']");
	private By txtboxName = By.id("Name0");
	private By txtboxDescription = By.id("Description0");
	private By btnSaveAdditionalDocument = By
			.xpath("(//button[contains(normalize-space(), 'Add Additional Document')])[2]");

	private By dataFileName = By.xpath("//tbody[@class='ant-table-tbody']//td[@data-label='File Name']");
	private By dataDecrption = By.xpath("//tbody[@class='ant-table-tbody']//td[@data-label='Description']");
	private By dataThumbnail = By.xpath("//tbody[@class='ant-table-tbody']//td[@data-label='Thumbnail']");

// 6. Available Times
	private By tabAvailableTimes = By.xpath("//div[text()='Available Times' and @class='menuItem']");

	private By txtDays = By.xpath("//div[contains(text(),'Days')]");
	private By txtDayShiftTime = By.xpath("//div[contains(text(),'Day Shift time')]");
	private By btnSelectAll = By.id("select_all");

	private By txtboxStartTimeMonday = By.id("monday_dayShift");
	private By txtboxEndTimeMonday = By.id("monday_swingShift");

// 7. Access
	private By tabAccess = By.xpath("//div[text()='Access' and @class='menuItem']");

	// Module Access
	private By checkboxView = By.xpath("(//input[@class='ant-checkbox-input'])[1]");
	private By checkboxAdd = By.xpath("(//input[@class='ant-checkbox-input'])[2]");
	private By checkboxEdit = By.xpath("(//input[@class='ant-checkbox-input'])[3]");
	private By checkboxDelete = By.xpath("(//input[@class='ant-checkbox-input'])[4]");
	private By btnSavePermissions = By.xpath("//span[contains(text(),'Save Permissions')]");

// 8. References
	private By tabReferences = By.xpath("//div[text()='References' and @class='menuItem']");
	private By btnAddUserReference = By.xpath("//span[contains(text(),'Add User Reference')]");
	private By txtUserReferences = By.xpath(
			"//div[contains(@class,'ant-card ant-card-bordered overview')]//span[@class='baseTitle']");

	private By userReferencesName = By.id("reference_name");
	private By userReferencesRelationship = By.id("reference_relationship");
	private By userReferencesTitle = By.id("reference_title");
	private By userReferencesPhone = By.xpath("//input[@type='tel']");
	private By userReferencesEmail = By.id("reference_email");
	private By btnSubmitAddUserReference = By.cssSelector("button[type='submit']");

	private By dataUserReferencesName = By.xpath("//tbody[@class='ant-table-tbody']//td[@data-label='Name']");
	private By dataUserReferencesRelationship = By
			.xpath("//tbody[@class='ant-table-tbody']//td[@data-label='Relationship']");
	private By dataUserReferencesTitle = By.xpath("//tbody[@class='ant-table-tbody']//td[@data-label='Title']");
	private By dataUserReferencesPhone = By.xpath("//tbody[@class='ant-table-tbody']//td[@data-label='Phone #']");
	private By dataUserReferencesEmail = By.xpath("//tbody[@class='ant-table-tbody']//td[@data-label='Email']");

	// Common locators
	private By btnSave = By.xpath("//span[text()='Save']");
	private By txtSucessMessage = By.cssSelector("div[role='alert'] div:nth-child(2)");
	private By uploadFile = By.xpath("//input[@type='file']");

	public AddEmployeePage(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(driver);
	}


	// Upload User Profile
	public boolean isUploadUserProfilePictureTextDisplayed() {
		return elementUtils.doIsDisplayed(txtUploadUserProfilePicture, Constants.DEFAULT_WAIT);
	}

	public boolean isImageUploadSuccessMessageDisplayed() {
		return elementUtils.doIsDisplayed(txtImageUploadSucessMessage, Constants.DEFAULT_WAIT);
	}

	public boolean isPersonalInformationTextDisplayed() {
		return elementUtils.doIsDisplayed(txtPersonalInformation, Constants.DEFAULT_WAIT);
	}

	public void uploadProfileImage() {
		WebElement fileInput = elementUtils.getElement(imgUpload);
		String absolutePath = new File("./src/test/resource/testdata/image.jpeg").getAbsolutePath();
		System.out.println("Uploading file from path: " + absolutePath);
		fileInput.sendKeys(absolutePath);
	}

// 1. Personal Information
	public void fillPersonalInformation(String firstName, String middleName, String lastName, String gender,
			String month, String Year, String date, String socialSecurityNumber, String role, String rank,
			String ethnicCode, String primaryEmail, String alternateEmail, String countryCode,
			String primanyPhoneNumber, String alternatePhoneNumber, String emergencyName, String emergencyPhoneNumber,
			String emergencyRelationship, String password, String confirmPassword, String branchName,
			String blacklistedSiteName) throws InterruptedException {

		elementUtils.waitForElementVisible(txtboxFirstName, Constants.SHORT_TIME_OUT_WAIT).sendKeys(firstName);
		elementUtils.waitForElementVisible(txtboxMiddleName, Constants.SHORT_TIME_OUT_WAIT).sendKeys(middleName);
		elementUtils.waitForElementVisible(txtboxLastName, Constants.SHORT_TIME_OUT_WAIT).sendKeys(lastName);

		WebElement genderElement = elementUtils.waitForElementToBeClickable(dropdownGender,
				Constants.SHORT_TIME_OUT_WAIT);
		elementUtils.doClickWithActions(genderElement);
		elementUtils.selectElementThroughLocator(genderValues, gender, Constants.SHORT_TIME_OUT_WAIT);

		elementUtils.waitForElementToBeVisibleAndEnabled(birthDatecalender, Constants.DEFAULT_WAIT);
		elementUtils.waitForElementToBeClickable(birthDatecalender, Constants.SHORT_TIME_OUT_WAIT).click();
		Calendar.selectDatePrevious(driver, month, Year, date);

		elementUtils.waitForElementVisible(txtboxSocialSecurityNumber, Constants.SHORT_TIME_OUT_WAIT)
				.sendKeys(socialSecurityNumber);

		WebElement roleElement = elementUtils.waitForElementToBeClickable(dropdownRole, Constants.SHORT_TIME_OUT_WAIT);
		elementUtils.doClickWithActions(roleElement);
		String roleText = StringUtils.convertToCamelCase(role);
		By rolexpath = elementUtils.getOptionByText(roleText);
		elementUtils.clickElementWithScroll(rolexpath, Constants.DEFAULT_WAIT);

		WebElement rankElement = elementUtils.waitForElementToBeClickable(dropdownRank, Constants.SHORT_TIME_OUT_WAIT);
		elementUtils.doClickWithActions(rankElement);
		By rankxpath = elementUtils.getOptionByText(rank);
		elementUtils.doClickWithActionsAndWait(rankxpath, Constants.SHORT_TIME_OUT_WAIT);

		WebElement ethnicCodeElement = elementUtils.waitForElementToBeClickable(dropdownEthnicCode,
				Constants.SHORT_TIME_OUT_WAIT);
		elementUtils.doClickWithActions(ethnicCodeElement);
		String ethnicCodeText = StringUtils.convertToCamelCase(ethnicCode);
		By xpathethnicCode = elementUtils.getOptionByText(ethnicCodeText);
		elementUtils.clickElementWithScroll(xpathethnicCode, Constants.SHORT_TIME_OUT_WAIT);

		elementUtils.waitForElementVisible(txtboxPrimaryEmail, Constants.SHORT_TIME_OUT_WAIT).sendKeys(primaryEmail);
		elementUtils.waitForElementVisible(txtboxAlternateEmail, Constants.SHORT_TIME_OUT_WAIT)
				.sendKeys(alternateEmail);

		WebElement primaryPhoneNumberCountryCodElement = elementUtils
				.waitForElementToBeClickable(dropdownPrimaryPhoneNumberCountryCode, Constants.SHORT_TIME_OUT_WAIT);
		elementUtils.doClickWithActions(primaryPhoneNumberCountryCodElement);
		elementUtils.selectElementThroughLocator(countrycodeList, countryCode, Constants.SHORT_TIME_OUT_WAIT);
		elementUtils.waitForElementVisible(txtboxPrimaryPhoneNumber, Constants.SHORT_TIME_OUT_WAIT)
				.sendKeys(primanyPhoneNumber);

		WebElement secondaryPhoneNumberCountryCodElement = elementUtils
				.waitForElementToBeClickable(dropdownSecondaryPhoneNumberCountryCode, Constants.SHORT_TIME_OUT_WAIT);
		elementUtils.doClickWithActions(secondaryPhoneNumberCountryCodElement);
		elementUtils.selectElementThroughLocator(countrycodeList, countryCode, Constants.SHORT_TIME_OUT_WAIT);
		elementUtils.waitForElementVisible(txtboxSecondaryPhoneNumber, Constants.SHORT_TIME_OUT_WAIT)
				.sendKeys(alternatePhoneNumber);

		elementUtils.waitForElementVisible(txtboxEmergencyName, Constants.SHORT_TIME_OUT_WAIT).sendKeys(emergencyName);

		WebElement emergencyPhoneNumberCountryCodElement = elementUtils
				.waitForElementToBeClickable(dropdownEmergencyNumberCountryCode, Constants.SHORT_TIME_OUT_WAIT);
		elementUtils.doClickWithActions(emergencyPhoneNumberCountryCodElement);
		elementUtils.selectElementThroughLocator(countrycodeList, countryCode, Constants.SHORT_TIME_OUT_WAIT);
		elementUtils.waitForElementVisible(txtboxEmergencyNumber, Constants.SHORT_TIME_OUT_WAIT)
				.sendKeys(alternatePhoneNumber);

		elementUtils.waitForElementVisible(txtboxEmergencyRelationship, Constants.SHORT_TIME_OUT_WAIT)
				.sendKeys(emergencyRelationship);
		elementUtils.waitForElementVisible(txtboxPassword, Constants.SHORT_TIME_OUT_WAIT).sendKeys(password);
		elementUtils.waitForElementVisible(txtboxConfirmPassword, Constants.SHORT_TIME_OUT_WAIT)
				.sendKeys(confirmPassword);

//		WebElement branchesElement = elementUtils.waitForElementToBeClickable(dropdownBranches,
//				Constants.SHORT_TIME_OUT_WAIT);
//		elementUtils.doClickWithActions(branchesElement);
//		String branchesText = StringUtils.convertToCamelCase(branchName);
//		By branchxpath = elementUtils.getOptionByText(branchesText);
//		elementUtils.clickElementWithScroll(branchxpath, Constants.DEFAULT_WAIT);

		WebElement blacklistedSiteElement = elementUtils.waitForElementToBeClickable(dropdownBlacklistedSite,
				Constants.SHORT_TIME_OUT_WAIT);
		elementUtils.doClickWithActions(blacklistedSiteElement);
		By blacklistedSiteNamexpath = elementUtils.getOptionByText(blacklistedSiteName);
		elementUtils.clickElementWithScroll(blacklistedSiteNamexpath, Constants.DEFAULT_WAIT);
		elementUtils.pressEscapeKey();
	}

	public void fillResidenceAddress(String streetName, String streetId, String streetNumber, String City, String state,
			String zipcode, String country) throws InterruptedException {

		elementUtils.waitForElementVisible(txtboxStreetName, Constants.SHORT_TIME_OUT_WAIT).sendKeys(streetName);
		elementUtils.waitForElementVisible(txtboxStreetId, Constants.SHORT_TIME_OUT_WAIT).sendKeys(streetId);
		elementUtils.waitForElementVisible(txtboxStreetNumber, Constants.SHORT_TIME_OUT_WAIT).sendKeys(streetNumber);
		elementUtils.waitForElementVisible(txtboxCity, Constants.SHORT_TIME_OUT_WAIT).sendKeys(City);

		WebElement stateElement = elementUtils.waitForElementToBeClickable(dropdownState,
				Constants.SHORT_TIME_OUT_WAIT);
		elementUtils.doClickWithActions(stateElement);
		By statexpath = elementUtils.getOptionByText(state);
		elementUtils.clickElementWithScroll(statexpath, Constants.DEFAULT_WAIT);

		elementUtils.waitForElementVisible(txtboxZipCode, Constants.SHORT_TIME_OUT_WAIT).sendKeys(zipcode);

		WebElement genderElement = elementUtils.waitForElementToBeClickable(dropdownCountry,
				Constants.SHORT_TIME_OUT_WAIT);
		elementUtils.doClickWithActions(genderElement);
		elementUtils.waitForElementVisible(countrySearch, Constants.SHORT_TIME_OUT_WAIT).sendKeys(country);
		elementUtils.pressEnterKey();
//		elementUtils.waitForElementVisible(dropdownCountryValues, Constants.DEFAULT_WAIT);
//		elementUtils.selectElementThroughLocatorWithRetry(dropdownCountryValues, country, Constants.SHORT_TIME_OUT_WAIT);
	}

	public void doClickSameAsAbove() {
		elementUtils.waitForElementToBeClickable(checkboxSameAsAbove, Constants.DEFAULT_WAIT).click();
	}

	public void personalInformationNotes(String notes) {
		elementUtils.waitForElementVisible(txtboxNote, Constants.SHORT_TIME_OUT_WAIT).sendKeys(notes);
	}

	public void doClickSaveButton() {
		elementUtils.waitForElementVisible(btnSave, Constants.DEFAULT_WAIT).click();
	}

	public String getPersonalInfoSuccessMessageText() {
		return elementUtils.waitForElementVisible(txtSucessMessage, Constants.DEFAULT_WAIT).getText();
	}

// 2. Employment Information
	public void doClickEmploymentInformationTab() {
		elementUtils.waitForElementVisible(tabEmploymentInformation, Constants.DEFAULT_WAIT).click();
	}

	public String getEmployeeID() {
		elementUtils.waitForInvisibilityOfElementLocated(txtSucessMessage, Constants.MEDIUM_TIME_OUT_WAIT);
		return elementUtils.waitForElementVisible(employeeId, Constants.DEFAULT_WAIT).getAttribute("value");
	}

	public void fillEmploymentInformation(String employmentStatus, String month, String year, String date,
			String notes) {
		elementUtils.waitForInvisibilityOfElementLocated(txtSucessMessage, Constants.MEDIUM_TIME_OUT_WAIT);
		WebElement employmentStatusElement = elementUtils.waitForElementToBeClickable(dropdownEmploymentStatus,
				Constants.SHORT_TIME_OUT_WAIT);
		elementUtils.doClickWithActions(employmentStatusElement);
		elementUtils.selectElementThroughLocator(dropdownEmploymentStatusValues, employmentStatus,
				Constants.SHORT_TIME_OUT_WAIT);

		elementUtils.waitForElementToBeVisibleAndEnabled(calenderHireDate, Constants.DEFAULT_WAIT);
		elementUtils.waitForElementToBeClickable(calenderHireDate, Constants.SHORT_TIME_OUT_WAIT).click();
		Calendar.selectDatePrevious(driver, month, year, date);

		elementUtils.waitForElementVisible(txtboxEmploymentInformationNotes, Constants.SHORT_TIME_OUT_WAIT)
				.sendKeys(notes);
	}

	public void fillClassCode(String classCode) {

		WebElement WCClassCodeElement = elementUtils.waitForElementToBeClickable(dropdownWCClassCode,
				Constants.SHORT_TIME_OUT_WAIT);
		elementUtils.doClickWithActions(WCClassCodeElement);
		elementUtils.waitForElementVisible(classCodeSearch, Constants.SHORT_TIME_OUT_WAIT).sendKeys(classCode);
		elementUtils.selectElementThroughLocator(dropdownWCClassCodeValues, classCode, Constants.SHORT_TIME_OUT_WAIT);

	}

	public void fillEmploymentType(String employmentType) {

		WebElement employmentTypeElement = elementUtils.waitForElementToBeClickable(dropdownEmploymentType,
				Constants.DEFAULT_WAIT);
		elementUtils.doClickWithActions(employmentTypeElement);

		elementUtils.waitForElementVisible(employmentTypeSearch, Constants.SHORT_TIME_OUT_WAIT)
				.sendKeys(employmentType);
		elementUtils.waitForElementVisible(dropdownEmploymentTypeValues, Constants.DEFAULT_WAIT);
		elementUtils.selectElementThroughLocator(dropdownEmploymentTypeValues, employmentType,
				Constants.SHORT_TIME_OUT_WAIT);
	}

	public void fillDepartmentType(String department) {

		WebElement departmentTypeElement = elementUtils.waitForElementToBeClickable(dropdownDepartmentType,
				Constants.SHORT_TIME_OUT_WAIT);
		elementUtils.doClickWithActions(departmentTypeElement);
		elementUtils.waitForElementVisible(departmentTypeSearch, Constants.SHORT_TIME_OUT_WAIT).sendKeys(department);

		elementUtils.waitForElementVisible(dropdownDepartmentTypeValues, Constants.DEFAULT_WAIT);
		elementUtils.selectElementThroughLocator(dropdownDepartmentTypeValues, department,
				Constants.SHORT_TIME_OUT_WAIT);
	}

	public String getEmployeeInformationSuccessMessageText() {
		return elementUtils.waitForElementVisible(txtSucessMessage, Constants.DEFAULT_WAIT).getText();
	}

	// Permits
	public void doClickPermits() {
		elementUtils.waitForElementToBeClickable(tabPermits, Constants.DEFAULT_WAIT).click();
	}

	public void doClickAddLicenseDetailsButton() {
		elementUtils.waitForInvisibilityOfElementLocated(txtSucessMessage, Constants.DEFAULT_WAIT);
		elementUtils.waitForElementToBeClickable(btnAddLicenseDetails, Constants.DEFAULT_WAIT).click();
	}

	public boolean isDriverLicenseTextDisplayed() {
		return elementUtils.doIsEnabled(txtDriverLicense, Constants.DEFAULT_WAIT);
	}

	// Driver License
	public void fillDriverLicenseForm(String state, String licenseNumber, String issueDate, String expirationDate)
			throws InterruptedException {

		isDriverLicenseTextDisplayed();
		WebElement stateElement = elementUtils.waitForElementToBeClickable(dropdownLicenseState,
				Constants.SHORT_TIME_OUT_WAIT);
		elementUtils.doClickWithActions(stateElement);
		String stateName = state;
		By statexpath = By.xpath("//div[contains(text(),'" + stateName + "')]");
		elementUtils.safeClick(statexpath);

		elementUtils.waitForElementVisible(txtboxDriverLicenseNumber, Constants.SHORT_TIME_OUT_WAIT)
				.sendKeys(licenseNumber);

		WebElement issueElement = elementUtils.waitForElementToBeClickable(calenderDateOfIssue, Constants.DEFAULT_WAIT);
		elementUtils.doClickWithActions(issueElement);
		elementUtils.waitForElementVisible(calenderDateOfIssueSearch, Constants.DEFAULT_WAIT).sendKeys(issueDate);

		WebElement expirationElement = elementUtils.waitForElementToBeClickable(calenderDateOfExpiration,
				Constants.DEFAULT_WAIT);
		elementUtils.doClickWithActions(expirationElement);
		elementUtils.waitForElementVisible(calenderDateOfExpirationSearch, Constants.DEFAULT_WAIT)
				.sendKeys(expirationDate);

		elementUtils.clickByLocator(txtDriverLicense);
		WebElement fileInput = elementUtils.getElement(uploadDriverLicense);
		String absolutePath = new File("./src/test/resource/testdata/image.jpeg").getAbsolutePath();
		System.out.println("Uploading file from path: " + absolutePath);
		fileInput.sendKeys(absolutePath);
		elementUtils.waitForElementToBeClickable(btnAddLicense, Constants.DEFAULT_WAIT).click();
	}

	public String getPermitAddedSuccessMessageText() {
		return elementUtils.waitForElementVisible(txtSucessMessage, Constants.DEFAULT_WAIT).getText();
	}

	public String getDriverLicenseNumberData() {
		return elementUtils.waitForElementVisible(dataDriverLicenseNumber, Constants.DEFAULT_WAIT).getText();
	}

	public String getDateOfIssueData() {
		return elementUtils.waitForElementVisible(dataDateOfIssue, Constants.DEFAULT_WAIT).getText();
	}

	public String getDateOfExpirationData() {
		return elementUtils.waitForElementVisible(dataDateOfExpiration, Constants.DEFAULT_WAIT).getText();
	}

	public String getDriverLicenseStateData() {
		return elementUtils.waitForElementVisible(dataState, Constants.DEFAULT_WAIT).getText();
	}

	// Guard Card
	public void doClickAddGuardCard() {
		elementUtils.waitForInvisibilityOfElementLocated(txtSucessMessage, Constants.DEFAULT_WAIT);
		elementUtils.waitForElementToBeClickable(btnAddGuardCard, Constants.DEFAULT_WAIT).click();
	}

	public boolean isGuardCardTextDisplayed() {
		return elementUtils.doIsEnabled(txtGuardCard, Constants.DEFAULT_WAIT);
	}

	public void fillGuardCardForm(String permitNumber, String issueDate, String expirationDate) {
		isGuardCardTextDisplayed();
		elementUtils.waitForElementVisible(txtboxGuardCardPermitNumber, Constants.SHORT_TIME_OUT_WAIT)
				.sendKeys(permitNumber);
		WebElement issueElement = elementUtils.waitForElementToBeClickable(calenderDateOfIssueGuardCard,
				Constants.DEFAULT_WAIT);
		elementUtils.doClickWithActions(issueElement);
		elementUtils.waitForElementVisible(calenderDateOfIssueSearchGuardCard, Constants.DEFAULT_WAIT)
				.sendKeys(issueDate);

		WebElement expirationElement = elementUtils.waitForElementToBeClickable(calenderDateOfExpirationGuardCard,
				Constants.DEFAULT_WAIT);
		elementUtils.doClickWithActions(expirationElement);
		elementUtils.waitForElementVisible(calenderDateOfExpirationSearchGuardCard, Constants.DEFAULT_WAIT)
				.sendKeys(expirationDate);

		elementUtils.clickByLocator(txtGuardCard);
		WebElement fileInput = elementUtils.getElement(uploadFile);
		String absolutePath = new File("./src/test/resource/testdata/image.jpeg").getAbsolutePath();
		System.out.println("Uploading file from path: " + absolutePath);
		fileInput.sendKeys(absolutePath);

		elementUtils.waitForElementToBeClickable(btnSaveGuardCard, Constants.DEFAULT_WAIT).click();
	}

	public String getGuardCardSuccessMessageText() {
		return elementUtils.waitForElementVisible(txtSucessMessage, Constants.DEFAULT_WAIT).getText();
	}

	public String getGuardCardPermitNumberData() {
		return elementUtils.waitForElementVisible(dataGaurdCardPermitNumber, Constants.DEFAULT_WAIT).getText();
	}

	public String getGuardCardDateOfIssueData() {
		return elementUtils.waitForElementVisible(dataGaurdCardDateOfIssue, Constants.DEFAULT_WAIT).getText();
	}

	public String getGuardCardDateOfExpirationData() {
		return elementUtils.waitForElementVisible(dataGaurdCardDateOfExpiration, Constants.DEFAULT_WAIT).getText();
	}

	// Firearms Qualification

	public void doClickAddFirearmsQualification() {
		elementUtils.waitForInvisibilityOfElementLocated(txtSucessMessage, Constants.DEFAULT_WAIT);
		elementUtils.waitForElementToBeClickable(btnAddFirearmsQualification, Constants.DEFAULT_WAIT).click();
	}

	public boolean isFirearmsQualificationTextDisplayed() {
		return elementUtils.doIsEnabled(txtFirearmsQualification, Constants.DEFAULT_WAIT);
	}

	public void fillFirearmsQualification(String firearmsPermitNumber, String issueDate, String expirationDate,
			String firearmsCaliber, String firearmsSerial, String firearmsMake, String firearmsModel) {

		isFirearmsQualificationTextDisplayed();
		elementUtils.waitForElementVisible(txtboxFirearmsPermitNumber, Constants.SHORT_TIME_OUT_WAIT)
				.sendKeys(firearmsPermitNumber);

		WebElement issueElement = elementUtils.waitForElementToBeClickable(calenderDateOfIssueFirearms,
				Constants.DEFAULT_WAIT);
		elementUtils.doClickWithActions(issueElement);
		elementUtils.waitForElementVisible(calenderDateOfIssueSearchFirearms, Constants.DEFAULT_WAIT)
				.sendKeys(issueDate);

		WebElement expirationElement = elementUtils.waitForElementToBeClickable(calenderDateOfExpirationFirearms,
				Constants.DEFAULT_WAIT);
		elementUtils.doClickWithActions(expirationElement);
		elementUtils.waitForElementVisible(calenderDateOfExpirationSearchFirearms, Constants.DEFAULT_WAIT)
				.sendKeys(expirationDate);

		elementUtils.clickByLocator(txtFirearmsQualification);
		WebElement fileInput = elementUtils.getElement(uploadFile);
		String absolutePath = new File("./src/test/resource/testdata/image.jpeg").getAbsolutePath();
		System.out.println("Uploading file from path: " + absolutePath);
		fileInput.sendKeys(absolutePath);

		elementUtils.waitForElementVisible(txtboxFirearmsCaliber, Constants.SHORT_TIME_OUT_WAIT)
				.sendKeys(firearmsCaliber);
		elementUtils.waitForElementVisible(txtboxFirearmsSerial, Constants.SHORT_TIME_OUT_WAIT)
				.sendKeys(firearmsSerial);
		elementUtils.waitForElementVisible(txtboxFirearmsMake, Constants.SHORT_TIME_OUT_WAIT).sendKeys(firearmsMake);
		elementUtils.waitForElementVisible(txtboxFirearmsModel, Constants.SHORT_TIME_OUT_WAIT).sendKeys(firearmsModel);

		elementUtils.waitForElementToBeClickable(btnSaveFirearms, Constants.DEFAULT_WAIT).click();
	}

	public String getFirearmsPermitNumberData() {
		return elementUtils.waitForElementVisible(dataFirearmsPermitNumber, Constants.DEFAULT_WAIT).getText();
	}

	public String getFirearmsDateOfIssueData() {
		return elementUtils.waitForElementVisible(dataFirearmsDateOfIssue, Constants.DEFAULT_WAIT).getText();
	}

	public String getFirearmsDateOfExpirationData() {
		return elementUtils.waitForElementVisible(dataFirearmsDateOfExpiration, Constants.DEFAULT_WAIT).getText();
	}

	// Baton
	public void doClickAddBaton() {
		elementUtils.waitForInvisibilityOfElementLocated(txtSucessMessage, Constants.DEFAULT_WAIT);
		elementUtils.waitForElementToBeClickable(btnAddBaton, Constants.DEFAULT_WAIT).click();
	}

	public boolean isBatonTextDisplayed() {
		return elementUtils.doIsEnabled(txtBaton, Constants.DEFAULT_WAIT);
	}

	public void fillBatonForm(String batonPermitNumber, String issueDate, String expirationDate) {
		isBatonTextDisplayed();
		elementUtils.waitForElementVisible(txtboxBatonPermitNumber, Constants.SHORT_TIME_OUT_WAIT)
				.sendKeys(batonPermitNumber);

		WebElement issueElement = elementUtils.waitForElementToBeClickable(calenderDateOfIssueBaton,
				Constants.DEFAULT_WAIT);
		elementUtils.doClickWithActions(issueElement);
		elementUtils.waitForElementVisible(calenderDateOfIssueSearchBaton, Constants.DEFAULT_WAIT).sendKeys(issueDate);

		WebElement expirationElement = elementUtils.waitForElementToBeClickable(calenderDateOfExpirationBaton,
				Constants.DEFAULT_WAIT);
		elementUtils.doClickWithActions(expirationElement);
		elementUtils.waitForElementVisible(calenderDateOfExpirationSearchBaton, Constants.DEFAULT_WAIT)
				.sendKeys(expirationDate);

		elementUtils.clickByLocator(txtFirearmsQualification);
		WebElement fileInput = elementUtils.getElement(uploadFile);
		String absolutePath = new File("./src/test/resource/testdata/image.jpeg").getAbsolutePath();
		System.out.println("Uploading file from path: " + absolutePath);
		fileInput.sendKeys(absolutePath);

		elementUtils.waitForElementToBeClickable(btnSaveBaton, Constants.DEFAULT_WAIT).click();
	}

	public String getBatonPermitNumberData() {
		return elementUtils.waitForElementVisible(dataBatonPermitNumber, Constants.DEFAULT_WAIT).getText();
	}

	public String getBatonDateOfIssueData() {
		return elementUtils.waitForElementVisible(dataBatonDateOfIssue, Constants.DEFAULT_WAIT).getText();
	}

	public String getBatonDateOfExpirationData() {
		return elementUtils.waitForElementVisible(databatonDateOfExpiration, Constants.DEFAULT_WAIT).getText();
	}

	// ECD
	public void doClickAddECD() {
		elementUtils.waitForInvisibilityOfElementLocated(txtSucessMessage, Constants.DEFAULT_WAIT);
		elementUtils.waitForElementToBeClickable(btnAddECD, Constants.DEFAULT_WAIT).click();
	}

	public boolean isECDTextDisplayed() {
		return elementUtils.doIsEnabled(txtECD, Constants.DEFAULT_WAIT);
	}

	public void fillECDForm(String permitNumberECD, String issueDate, String expirationDate) {
		isECDTextDisplayed();

		elementUtils.waitForElementVisible(txtboxPermitNumberECD, Constants.SHORT_TIME_OUT_WAIT)
				.sendKeys(permitNumberECD);

		WebElement issueElement = elementUtils.waitForElementToBeClickable(calenderDateOfIssueECD,
				Constants.DEFAULT_WAIT);
		elementUtils.doClickWithActions(issueElement);
		elementUtils.waitForElementVisible(calenderDateOfIssueSearchECD, Constants.DEFAULT_WAIT).sendKeys(issueDate);

		WebElement expirationElement = elementUtils.waitForElementToBeClickable(calenderDateOfExpirationECD,
				Constants.DEFAULT_WAIT);
		elementUtils.doClickWithActions(expirationElement);
		elementUtils.waitForElementVisible(calenderDateOfExpirationSearchECD, Constants.DEFAULT_WAIT)
				.sendKeys(expirationDate);

		elementUtils.clickByLocator(txtECD);
		WebElement fileInput = elementUtils.getElement(uploadFile);
		String absolutePath = new File("./src/test/resource/testdata/image.jpeg").getAbsolutePath();
		System.out.println("Uploading file from path: " + absolutePath);
		fileInput.sendKeys(absolutePath);

		elementUtils.waitForElementVisible(btnSaveECD, Constants.DEFAULT_WAIT);
		elementUtils.waitForElementToBeClickable(btnSaveECD, Constants.DEFAULT_WAIT).click();
	}

	public String getECDPermitNumberData() {
		return elementUtils.waitForElementVisible(dataECDPermitNumber, Constants.DEFAULT_WAIT).getText();
	}

	public String getECDDateOfIssueData() {
		return elementUtils.waitForElementVisible(dataECDDateOfIssue, Constants.DEFAULT_WAIT).getText();
	}

	public String getECDDateOfExpirationData() {
		return elementUtils.waitForElementVisible(dataECDDateOfExpiration, Constants.DEFAULT_WAIT).getText();
	}

	// OC Spray
	public void doClickAddOCSpray() {
		elementUtils.waitForInvisibilityOfElementLocated(txtSucessMessage, Constants.DEFAULT_WAIT);
		elementUtils.waitForElementVisible(btnAddOCSpray, Constants.DEFAULT_WAIT);
		// elementUtils.waitForElementToBeClickable(btnAddOCSpray,
		// Constants.DEFAULT_WAIT).click();
		elementUtils.clickElementWithScroll(btnAddOCSpray, Constants.DEFAULT_WAIT);
	}

	public boolean isOCSprayTextDisplayed() {
		return elementUtils.doIsEnabled(txtOCSpray, Constants.DEFAULT_WAIT);
	}

	public void fillOCSprayForm(String permitNumberOCSpray, String issueDate, String expirationDate) {
		isOCSprayTextDisplayed();
		elementUtils.waitForElementVisible(txtboxPermitNumberOCSpray, Constants.SHORT_TIME_OUT_WAIT)
				.sendKeys(permitNumberOCSpray);

		WebElement issueElement = elementUtils.waitForElementToBeClickable(calenderDateOfIssueOCSpray,
				Constants.DEFAULT_WAIT);
		elementUtils.doClickWithActions(issueElement);
		elementUtils.waitForElementVisible(calenderDateOfIssueSearchOCSpray, Constants.DEFAULT_WAIT)
				.sendKeys(issueDate);

		WebElement expirationElement = elementUtils.waitForElementToBeClickable(calenderDateOfExpirationOCSpray,
				Constants.DEFAULT_WAIT);
		elementUtils.doClickWithActions(expirationElement);
		elementUtils.waitForElementVisible(calenderDateOfExpirationSearchOCSpray, Constants.DEFAULT_WAIT)
				.sendKeys(expirationDate);

		elementUtils.clickByLocator(txtOCSpray);
		WebElement fileInput = elementUtils.getElement(uploadFile);
		String absolutePath = new File("./src/test/resource/testdata/image.jpeg").getAbsolutePath();
		System.out.println("Uploading file from path: " + absolutePath);
		fileInput.sendKeys(absolutePath);

		elementUtils.waitForElementToBeClickable(btnSaveOCSpray, Constants.DEFAULT_WAIT).click();
	}

	public String getOCSprayPermitNumberData() {
		return elementUtils.waitForElementVisible(dataOCSprayPermitNumber, Constants.DEFAULT_WAIT).getText();
	}

	public String getOCSprayDateOfIssueData() {
		return elementUtils.waitForElementVisible(dataOCSprayDateOfIssue, Constants.DEFAULT_WAIT).getText();
	}

	public String getOCSprayDateOfExpirationData() {
		return elementUtils.waitForElementVisible(dataOCSprayDateOfExpiration, Constants.DEFAULT_WAIT).getText();
	}

	// Other Permit

	public void doClickAddOtherPermit() {
		elementUtils.waitForInvisibilityOfElementLocated(txtSucessMessage, Constants.DEFAULT_WAIT);
		elementUtils.waitForElementToBeClickable(btnAddOtherPermit, Constants.DEFAULT_WAIT).click();
	}

	public boolean isOtherPermitTextDisplayed() {
		return elementUtils.doIsEnabled(txtOtherPermit, Constants.DEFAULT_WAIT);
	}

	public void fillOtherPermitForm(String permitNumberOtherPermit, String issueDate, String expirationDate) {
		isOtherPermitTextDisplayed();
		elementUtils.waitForElementVisible(txtboxPermitNumberOtherPermit, Constants.SHORT_TIME_OUT_WAIT)
				.sendKeys(permitNumberOtherPermit);

		WebElement issueElement = elementUtils.waitForElementToBeClickable(calenderDateOfIssueOtherPermit,
				Constants.DEFAULT_WAIT);
		elementUtils.doClickWithActions(issueElement);
		elementUtils.waitForElementVisible(calenderDateOfIssueSearchOtherPermit, Constants.DEFAULT_WAIT)
				.sendKeys(issueDate);

		WebElement expirationElement = elementUtils.waitForElementToBeClickable(calenderDateOfExpirationOtherPermit,
				Constants.DEFAULT_WAIT);
		elementUtils.doClickWithActions(expirationElement);
		elementUtils.waitForElementVisible(calenderDateOfExpirationSearchOtherPermit, Constants.DEFAULT_WAIT)
				.sendKeys(expirationDate);

		elementUtils.clickByLocator(txtOtherPermit);
		WebElement fileInput = elementUtils.getElement(uploadFile);
		String absolutePath = new File("./src/test/resource/testdata/image.jpeg").getAbsolutePath();
		System.out.println("Uploading file from path: " + absolutePath);
		fileInput.sendKeys(absolutePath);

		elementUtils.waitForElementToBeClickable(btnSaveOtherPermit, Constants.DEFAULT_WAIT).click();
	}

	public String getOtherPermitSuccessMessageText() {
		return elementUtils.waitForElementVisible(txtSucessMessage, Constants.DEFAULT_WAIT).getText();
	}

	public String getOtherPermitPermitNumberData() {
		return elementUtils.waitForElementVisible(dataOtherPermitPermitNumber, Constants.DEFAULT_WAIT).getText();
	}

	public String getOtherPermitDateOfIssueData() {
		return elementUtils.waitForElementVisible(dataOtherPermitDateOfIssue, Constants.DEFAULT_WAIT).getText();
	}

	public String getOtherPermitDateOfExpirationData() {
		return elementUtils.waitForElementVisible(dataOtherPermitDateOfExpiration, Constants.DEFAULT_WAIT).getText();
	}

// Pay Information
	public void doClickPayInformationTab() {
		elementUtils.waitForInvisibilityOfElementLocated(txtSucessMessage, Constants.DEFAULT_WAIT);
		elementUtils.waitForElementVisible(tabPayInformation, Constants.DEFAULT_WAIT).click();
	}

	public void fillPayInformation(String employeePayRate, String payCycle, String allowanceRate,
			String allowanceType) {

		elementUtils.waitForElementVisible(txtboxEmployeePayRate, Constants.SHORT_TIME_OUT_WAIT)
				.sendKeys(employeePayRate);

		WebElement payCycleElement = elementUtils.waitForElementToBeClickable(dropdownPayCycle,
				Constants.SHORT_TIME_OUT_WAIT);
		elementUtils.doClickWithActions(payCycleElement);
		WebElement dynamicPayCycle = elementUtils.waitForElementVisible(
				By.xpath("//div[@class='ant-select-item-option-content'][normalize-space()='" + payCycle + "']"),
				Constants.SHORT_TIME_OUT_WAIT);
		dynamicPayCycle.click();

//		elementUtils.waitForElementToBeClickable(checkboxAdditionalPay, Constants.DEFAULT_WAIT).click();
//
//		elementUtils.waitForElementVisible(txtboxAllowanceRate, Constants.SHORT_TIME_OUT_WAIT).sendKeys(allowanceRate);
//
//		WebElement allowanceTypeElement = elementUtils.waitForElementToBeClickable(dropdownAllowanceType,
//				Constants.SHORT_TIME_OUT_WAIT);
//		elementUtils.doClickWithActions(allowanceTypeElement);
////		elementUtils.waitForElementVisible(dropdownSearchAllowanceType, Constants.SHORT_TIME_OUT_WAIT)
////				.sendKeys(allowanceType);
//		elementUtils.doActionsSendKeys(dropdownSearchAllowanceType, allowanceType);
//		elementUtils.pressEnterKey();
	}

	public void fillCommissionInfo(String commissionName, String commissionType, String commissionRate,
			String CommissionCycle, String effectiveDate) {

		elementUtils.waitForElementVisible(txtboxCommissionName, Constants.SHORT_TIME_OUT_WAIT)
				.sendKeys(commissionName);

		WebElement payCycleElement = elementUtils.waitForElementToBeClickable(dropdownCommissionType,
				Constants.SHORT_TIME_OUT_WAIT);
		elementUtils.doClickWithActions(payCycleElement);
		elementUtils.clickByLocator(dropdownSearchCommissionType);
		WebElement commissiontype = elementUtils.waitForElementVisible(
				By.xpath("//div[@class='ant-select-item-option-content'][normalize-space()='" + commissionType + "']"),
				Constants.SHORT_TIME_OUT_WAIT);
		commissiontype.click();

		elementUtils.waitForElementVisible(txtboxCommissionRate, Constants.SHORT_TIME_OUT_WAIT)
				.sendKeys(commissionRate);

		WebElement commissionCycleElement = elementUtils.waitForElementToBeClickable(dropdownCommissionCycle,
				Constants.SHORT_TIME_OUT_WAIT);
		elementUtils.doClickWithActions(commissionCycleElement);
		elementUtils.clickByLocator(dropdownSearchCommissionCycle);
		WebElement comissioncycle = elementUtils.waitForElementVisible(By.xpath(
				"(//div[@class='ant-select-item-option-content'][normalize-space()='" + CommissionCycle + "'])[2]"),
				Constants.SHORT_TIME_OUT_WAIT);
		comissioncycle.click();

		WebElement effectiveDateElement = elementUtils.waitForElementToBeClickable(calenderEffectiveDate,
				Constants.DEFAULT_WAIT);
		elementUtils.doClickWithActions(effectiveDateElement);
		elementUtils.waitForElementVisible(calenderSearchEffectiveDate, Constants.DEFAULT_WAIT).clear();
		elementUtils.waitForElementVisible(calenderSearchEffectiveDate, Constants.DEFAULT_WAIT).sendKeys(effectiveDate);
		elementUtils.pressEnterKey();
		elementUtils.waitForElementToBeClickable(btnSave, Constants.DEFAULT_WAIT).click();
	}

	public String getPayInformationSuccessMessageText() {
		return elementUtils.waitForElementVisible(txtSucessMessage, Constants.DEFAULT_WAIT).getText();
	}

	// Upload Document

	public void doClickAdditionalDocumentsTab() {
		elementUtils.clickElementWithScroll(tabAdditionalDocuments, Constants.DEFAULT_WAIT);
	}

	public void doClickAddAdditionalDocument() {
		elementUtils.waitForInvisibilityOfElementLocated(txtSucessMessage, Constants.MEDIUM_TIME_OUT_WAIT);
		elementUtils.waitForElementToBeClickable(btnAddAdditionalDocument, Constants.DEFAULT_WAIT).click();
	}

	public boolean isAdditionalDocumentTextDisplayed() {
		return elementUtils.doIsEnabled(txtAdditionalDocument, Constants.DEFAULT_WAIT);
	}

	public void fillAdditionalDocuments(String additionalDocumentName, String additionalDocumentDescription) {
		isAdditionalDocumentTextDisplayed();
		WebElement fileInput = elementUtils.getElement(uploadFile);
		String absolutePath = new File("./src/test/resource/testdata/image.jpeg").getAbsolutePath();
		System.out.println("Uploading file from path: " + absolutePath);
		fileInput.sendKeys(absolutePath);

		elementUtils.waitForElementVisible(txtboxName, Constants.DEFAULT_WAIT).sendKeys(additionalDocumentName);
		elementUtils.waitForElementVisible(txtboxDescription, Constants.DEFAULT_WAIT)
				.sendKeys(additionalDocumentDescription);

		elementUtils.waitForElementToBeClickable(btnSaveAdditionalDocument, Constants.DEFAULT_WAIT).click();
	}

	public String getFileNameData() {
		return elementUtils.waitForElementVisible(dataFileName, Constants.DEFAULT_WAIT).getText();
	}

	public String getDescriptionData() {
		return elementUtils.waitForElementVisible(dataDecrption, Constants.DEFAULT_WAIT).getText();
	}

	public boolean isThumbnailDisplayed() {
		return elementUtils.doIsDisplayed(dataThumbnail, Constants.DEFAULT_WAIT);
	}

	// Available Times
	public void doClickAvailableTimesTab() {
		elementUtils.waitForInvisibilityOfElementLocated(txtSucessMessage, Constants.MEDIUM_TIME_OUT_WAIT);
		elementUtils.waitForElementToBeClickable(tabAvailableTimes, Constants.DEFAULT_WAIT).click();
	}

	public boolean isDaysTextDisplayed() {
		return elementUtils.doIsDisplayed(txtDays, Constants.DEFAULT_WAIT);
	}

	public boolean isDayShiftTimeTextDisplayed() {
		return elementUtils.doIsDisplayed(txtDayShiftTime, Constants.DEFAULT_WAIT);
	}

	public void fillAvailableTimes(String startTime, String endTime) throws InterruptedException {
		elementUtils.waitForElementVisible(txtboxStartTimeMonday, Constants.DEFAULT_WAIT).sendKeys(startTime);
		elementUtils.waitForElementVisible(txtboxEndTimeMonday, Constants.DEFAULT_WAIT).sendKeys(endTime);
		elementUtils.waitForElementToBeClickable(btnSelectAll, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementToBeClickable(btnSave, Constants.DEFAULT_WAIT).click();
	}

	public String getAvailableTimesSuccessMessageText() {
		return elementUtils.waitForElementVisible(txtSucessMessage, Constants.DEFAULT_WAIT).getText();
	}

	// Access
	public void doClickAccessTab() {
		elementUtils.waitForInvisibilityOfElementLocated(txtSucessMessage, Constants.MEDIUM_TIME_OUT_WAIT);
		elementUtils.waitForElementToBeClickable(tabAccess, Constants.DEFAULT_WAIT).click();
	}

	public void fillModuleAccess() {
		elementUtils.waitForInvisibilityOfElementLocated(txtSucessMessage, Constants.MEDIUM_TIME_OUT_WAIT);
		elementUtils.waitForElementVisible(checkboxView, Constants.DEFAULT_WAIT);
		elementUtils.waitForElementToBeClickable(checkboxView, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementToBeClickable(checkboxAdd, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementToBeClickable(checkboxEdit, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementToBeClickable(checkboxDelete, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementToBeClickable(btnSavePermissions, Constants.DEFAULT_WAIT).click();
	}

	public String getAccessSuccessMessageText() {
		return elementUtils.waitForElementVisible(txtSucessMessage, Constants.DEFAULT_WAIT).getText();
	}

	// References
	public void doClickReferencesTab() {
		elementUtils.waitForInvisibilityOfElementLocated(txtSucessMessage, Constants.MEDIUM_TIME_OUT_WAIT);
		elementUtils.waitForElementToBeClickable(tabReferences, Constants.DEFAULT_WAIT).click();
	}

	public void doClickAddUserReferenceButton() {
		elementUtils.waitForElementToBeClickable(btnAddUserReference, Constants.DEFAULT_WAIT).click();
	}

	public boolean isUserReferencesTextDisplayed() {
		return elementUtils.doIsEnabled(txtUserReferences, Constants.DEFAULT_WAIT);
	}

	public void fillUserReferences(String userRefName, String userRefRelationship, String userRefTitle,
			String userRefPhone, String userRefEmail) {
		isUserReferencesTextDisplayed();
		elementUtils.waitForElementVisible(userReferencesName, Constants.DEFAULT_WAIT).sendKeys(userRefName);
		elementUtils.waitForElementVisible(userReferencesRelationship, Constants.DEFAULT_WAIT)
				.sendKeys(userRefRelationship);
		elementUtils.waitForElementVisible(userReferencesTitle, Constants.DEFAULT_WAIT).sendKeys(userRefTitle);
		elementUtils.waitForElementVisible(userReferencesPhone, Constants.DEFAULT_WAIT).sendKeys(userRefPhone);
		elementUtils.waitForElementVisible(userReferencesEmail, Constants.DEFAULT_WAIT).sendKeys(userRefEmail);
		elementUtils.waitForElementToBeClickable(btnSubmitAddUserReference, Constants.DEFAULT_WAIT).click();
	}

	public String getUserReferenceNameData() {
		return elementUtils.waitForElementVisible(dataUserReferencesName, Constants.DEFAULT_WAIT).getText();
	}

	public String getUserReferenceRelationshipData() {
		return elementUtils.waitForElementVisible(dataUserReferencesRelationship, Constants.DEFAULT_WAIT).getText();
	}

	public String getUserReferenceTitleData() {
		return elementUtils.waitForElementVisible(dataUserReferencesTitle, Constants.DEFAULT_WAIT).getText();
	}

	public String getUserReferencePhoneData() {
		return elementUtils.waitForElementVisible(dataUserReferencesPhone, Constants.DEFAULT_WAIT).getText();
	}

	public String getUserReferenceEmailData() {
		return elementUtils.waitForElementVisible(dataUserReferencesEmail, Constants.DEFAULT_WAIT).getText();
	}

}
