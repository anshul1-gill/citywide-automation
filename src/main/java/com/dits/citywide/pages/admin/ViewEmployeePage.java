package com.dits.citywide.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.dits.citywide.constants.Constants;
import com.dits.citywide.utilities.ElementUtils;

public class ViewEmployeePage {

	private WebDriver driver;
	private ElementUtils elementUtils;

	// Profile Details

	private By dataProfileName = By.xpath("//div[@class='name-section']/h2");
	private By dataProfileStatus = By.xpath("//div[@class='name-section']/span");
	private By dataProfileRole = By.xpath("(//div[@class='role-rank']//span)[1]"); // (//div[@class='role-rank']/span/span)[1]
	private By dataProfileRank = By.xpath("(//div[@class='role-rank']//span)[2]");
	private By dataProfileLocation = By.xpath("(//div[@class='contact-info']/p)[1]");
	private By dataProfileEmailPhone = By.xpath("(//div[@class='contact-info']/p)[2]");

	// Personal Information
//	private By dataOfficerId = By.xpath("(//strong[text()='Officer']/following-sibling::span)[1]");
//	private By dataOfficerName = By.xpath("(//strong[text()='Officer']/following-sibling::span)[2]");
	private By dataOfficerIdName = By.xpath("//strong[text()='Officer']/following-sibling::span");
	private By dataOfficerEmailAddress = By.xpath("//strong[text()='Email Address']/following-sibling::span");
	private By dataOfficerGender = By.xpath("//strong[text()='Gender']/following-sibling::span");
	private By dataOfficerBranches = By.xpath("//strong[text()='Branches']/following-sibling::span");
	private By dataOfficerPriamryEmail = By.xpath("//strong[text()='Email (Primary)']/following-sibling::span");
	private By dataOfficerAlternateEmail = By.xpath("//strong[text()='Email (Alternate)']/following-sibling::span");
	private By dataOfficerPriamryPhone = By.xpath("//strong[text()='Phone (Primary)']/following-sibling::span");
	private By dataOfficerAlternatePhone = By.xpath("//strong[text()='Phone (Alternate)']/following-sibling::span");
	private By dataOfficerEmergencyContactName = By
			.xpath("//strong[text()='Emergency contact name']/following-sibling::span");
	private By dataOfficerEmergencyPhone = By.xpath("//strong[text()='Phone (Emergency)']/following-sibling::span");
	private By dataOfficerNotes = By.xpath("//strong[text()='Notes']/following-sibling::span");

	// Employment Information
	private By tabEmploymentInformation = By.cssSelector("#rc-tabs-0-tab-2");
	private By dataHireDate = By.xpath("//strong[contains(text(),'Hire date')]/following-sibling::span");
	private By dataClassCode = By.xpath("//strong[contains(text(),'Class Code')]/following-sibling::span");
	private By dataEmploymentType = By.xpath("//strong[contains(text(),'Employment Type')]/following-sibling::span");
	private By dataDepartmentType = By.xpath("//strong[contains(text(),'Department Type')]/following-sibling::span");

	// Permit
	private By tabPermit = By.cssSelector("#rc-tabs-0-tab-3");
	private By dataDriverLicenseNumber = By
			.xpath("//th[contains(text(),'Date of Issue')]/ancestor::thead/following-sibling::tbody//td[1]");
	private By dataDateOfIssue = By
			.xpath("//th[contains(text(),'Date of Issue')]/ancestor::thead/following-sibling::tbody//td[2]");
	private By dataDateOfExpiration = By
			.xpath("//th[contains(text(),'Date of Issue')]/ancestor::thead/following-sibling::tbody//td[3]");
	private By dataFiles = By
			.xpath("//th[contains(text(),'Date of Issue')]/ancestor::thead/following-sibling::tbody//td[4]");

	private By tabGuardCard = By.xpath("//div[contains(text(),'Guard Card')]");
	private By dataPermitNumber = By
			.xpath("//th[contains(text(),'Date of Issue')]/ancestor::thead/following-sibling::tbody//td[1]");
	private By dataGuardCardDateOfIssue = By
			.xpath("//th[contains(text(),'Date of Issue')]/ancestor::thead/following-sibling::tbody//td[2]");
	private By dataGuardCardDateOfExpiration = By
			.xpath("//th[contains(text(),'Date of Issue')]/ancestor::thead/following-sibling::tbody//td[3]");
	private By dataGuardCardFiles = By
			.xpath("//th[contains(text(),'Date of Issue')]/ancestor::thead/following-sibling::tbody//td[4]");

	private By tabFirearmsQualification = By.xpath("//div[contains(text(),'Firearms Qualification')]");
	private By dataFirearmsQualificationPermitNumber = By
			.xpath("//th[contains(text(),'Date of Issue')]/ancestor::thead/following-sibling::tbody//td[1]");
	private By dataFirearmsQualificationDateOfIssue = By
			.xpath("//th[contains(text(),'Date of Issue')]/ancestor::thead/following-sibling::tbody//td[2]");
	private By dataFirearmsQualificationDateOfExpiration = By
			.xpath("//th[contains(text(),'Date of Issue')]/ancestor::thead/following-sibling::tbody//td[3]");
	private By dataFirearmsQualificationFiles = By
			.xpath("//th[contains(text(),'Date of Issue')]/ancestor::thead/following-sibling::tbody//td[4]");

	private By tabBaton = By.xpath("//div[contains(text(),'Baton')]");
	private By dataBatonPermitNumber = By
			.xpath("//th[contains(text(),'Date of Issue')]/ancestor::thead/following-sibling::tbody//td[1]");
	private By dataBatonDateOfIssue = By
			.xpath("//th[contains(text(),'Date of Issue')]/ancestor::thead/following-sibling::tbody//td[2]");
	private By dataBatonDateOfExpiration = By
			.xpath("//th[contains(text(),'Date of Issue')]/ancestor::thead/following-sibling::tbody//td[3]");
	private By dataBatonFiles = By
			.xpath("//th[contains(text(),'Date of Issue')]/ancestor::thead/following-sibling::tbody//td[4]");

	private By tabECD = By.xpath("//div[contains(text(),'ECD')]");
	private By dataECDPermitNumber = By
			.xpath("//th[contains(text(),'Date of Issue')]/ancestor::thead/following-sibling::tbody//td[1]");
	private By dataECDDateOfIssue = By
			.xpath("//th[contains(text(),'Date of Issue')]/ancestor::thead/following-sibling::tbody//td[2]");
	private By dataECDDateOfExpiration = By
			.xpath("//th[contains(text(),'Date of Issue')]/ancestor::thead/following-sibling::tbody//td[3]");
	private By dataECDFiles = By
			.xpath("//th[contains(text(),'Date of Issue')]/ancestor::thead/following-sibling::tbody//td[4]");

	private By tabOCSpray = By.xpath("//div[contains(text(),'OC Spray')]");
	private By dataOCSprayPermitNumber = By
			.xpath("//th[contains(text(),'Date of Issue')]/ancestor::thead/following-sibling::tbody//td[1]");
	private By dataOCSprayDateOfIssue = By
			.xpath("//th[contains(text(),'Date of Issue')]/ancestor::thead/following-sibling::tbody//td[2]");
	private By dataOCSprayDateOfExpiration = By
			.xpath("//th[contains(text(),'Date of Issue')]/ancestor::thead/following-sibling::tbody//td[3]");
	private By dataOCSprayFiles = By
			.xpath("//th[contains(text(),'Date of Issue')]/ancestor::thead/following-sibling::tbody//td[4]");

	private By tabOther = By.xpath("//div[contains(text(),'Other')]");
	private By dataOtherPermitNumber = By
			.xpath("//th[contains(text(),'Date of Issue')]/ancestor::thead/following-sibling::tbody//td[1]");
	private By dataOtherDateOfIssue = By
			.xpath("//th[contains(text(),'Date of Issue')]/ancestor::thead/following-sibling::tbody//td[2]");
	private By dataOtherDateOfExpiration = By
			.xpath("//th[contains(text(),'Date of Issue')]/ancestor::thead/following-sibling::tbody//td[3]");
	private By dataOtherFiles = By
			.xpath("//th[contains(text(),'Date of Issue')]/ancestor::thead/following-sibling::tbody//td[4]");

	// Pay Info
	private By tabPayInfo = By.cssSelector("#rc-tabs-0-tab-4");
	private By dataPayCycle = By
			.xpath("//th[contains(text(),'Pay Cycle')]/ancestor::thead/following-sibling::tbody//td[1]");
//	private By dataPayEffectiveDate = By
//			.xpath("//th[contains(text(),'Pay Cycle')]/ancestor::thead/following-sibling::tbody//td[2]");
	private By dataPayRate = By
			.xpath("//th[contains(text(),'Pay Cycle')]/ancestor::thead/following-sibling::tbody//td[2]");

	private By dataCommissionCycle = By
			.xpath("//th[contains(text(),'Commission Cycle')]/ancestor::thead/following-sibling::tbody//td[1]");
	private By dataCommissionName = By
			.xpath("//th[contains(text(),'Commission Cycle')]/ancestor::thead/following-sibling::tbody//td[2]");
	private By dataCommissionEffectiveDate = By
			.xpath("//th[contains(text(),'Commission Cycle')]/ancestor::thead/following-sibling::tbody//td[3]");
	private By dataCommissionRate = By
			.xpath("//th[contains(text(),'Commission Cycle')]/ancestor::thead/following-sibling::tbody//td[4]");

	// Additional Documents
	private By tabAdditionalDocuments = By.cssSelector("#rc-tabs-0-tab-5");
	private By dataDocumentType = By
			.xpath("//th[contains(text(),'Document Type')]/ancestor::thead/following-sibling::tbody//td[1]");
	private By dataDescription = By
			.xpath("//th[contains(text(),'Document Type')]/ancestor::thead/following-sibling::tbody//td[2]");
	private By dataFile = By
			.xpath("//th[contains(text(),'Document Type')]/ancestor::thead/following-sibling::tbody//td[3]");

	// References
	private By tabReferences = By.cssSelector("#rc-tabs-0-tab-7");

	private By dataReferenceName = By
			.xpath("//th[contains(text(),'Reference Title')]/ancestor::thead/following-sibling::tbody//td[1]");
	private By dataReferenceRelationship = By
			.xpath("//th[contains(text(),'Reference Title')]/ancestor::thead/following-sibling::tbody//td[2]");
	private By dataReferenceTitle = By
			.xpath("//th[contains(text(),'Reference Title')]/ancestor::thead/following-sibling::tbody//td[3]");
	private By dataReferencePhone = By
			.xpath("//th[contains(text(),'Reference Title')]/ancestor::thead/following-sibling::tbody//td[4]");
	private By dataReferenceEmail = By
			.xpath("//th[contains(text(),'Reference Title')]/ancestor::thead/following-sibling::tbody//td[5]");



	// Available Times
	private By tabAvailableTimes = By.cssSelector("#rc-tabs-0-tab-8");

	// Comments
	private By tabComments = By.cssSelector("#rc-tabs-0-tab-9");

	// Common
	private By loader = By.xpath("//span[@class='ant-spin-dot ant-spin-dot-spin']");

	public ViewEmployeePage(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(driver);
	}

	// Profile Details

	public String getProfileName() {
		elementUtils.waitForInvisibilityOfElementLocated(loader, Constants.DEFAULT_WAIT);
		return elementUtils.waitForElementVisible(dataProfileName, Constants.DEFAULT_WAIT).getText();
	}

	public String getProfileStatus() {
		return elementUtils.waitForElementVisible(dataProfileStatus, Constants.DEFAULT_WAIT).getText();
	}

	public String getProfileRole() {
		return elementUtils.waitForElementVisible(dataProfileRole, Constants.DEFAULT_WAIT).getText();
	}

	public String getProfileRank() {
		return elementUtils.waitForElementVisible(dataProfileRank, Constants.DEFAULT_WAIT).getText();
	}

	public String getProfileLocation() {
		return elementUtils.waitForElementVisible(dataProfileLocation, Constants.DEFAULT_WAIT).getText();
	}

	public String getProfileEmailPhone() {
		return elementUtils.waitForElementVisible(dataProfileEmailPhone, Constants.DEFAULT_WAIT).getText();
	}

	// Personal Information

	public String getOfficerIdName() {
		elementUtils.waitForInvisibilityOfElementLocated(loader, Constants.DEFAULT_WAIT);
		String officerIdName = elementUtils.waitForElementVisible(dataOfficerIdName, Constants.DEFAULT_WAIT).getText();
		System.out.println(officerIdName);
		return officerIdName;
	}

//	public String getOfficerId() {
//		elementUtils.waitForInvisibilityOfElementLocated(loader, Constants.DEFAULT_WAIT);
//		String officerId = elementUtils.waitForElementVisible(dataOfficerId, Constants.DEFAULT_WAIT).getText();
//		System.out.println(officerId);
//		return officerId;
//	}
//
//	public String getOfficerName() {
//		return elementUtils.waitForElementVisible(dataOfficerName, Constants.DEFAULT_WAIT).getText();
//	}

	public String getOfficerEmailAddress() {
		return elementUtils.waitForElementVisible(dataOfficerEmailAddress, Constants.DEFAULT_WAIT).getText();
	}

	public String getOfficerGender() {
		return elementUtils.waitForElementVisible(dataOfficerGender, Constants.DEFAULT_WAIT).getText();
	}

	public String getOfficerBranches() {
		return elementUtils.waitForElementVisible(dataOfficerBranches, Constants.DEFAULT_WAIT).getText();
	}

	public String getOfficerPrimaryEmail() {
		return elementUtils.waitForElementVisible(dataOfficerPriamryEmail, Constants.DEFAULT_WAIT).getText();
	}

	public String getOfficerAlternateEmail() {
		WebElement alternateEmail = elementUtils.waitForElementVisible(dataOfficerAlternateEmail,
				Constants.DEFAULT_WAIT);
		return alternateEmail.getText();
	}

	public String getOfficerPrimaryPhone() {
		return elementUtils.waitForElementVisible(dataOfficerPriamryPhone, Constants.DEFAULT_WAIT).getText();
	}

	public String getOfficerAlternatePhone() {
		return elementUtils.waitForElementVisible(dataOfficerAlternatePhone, Constants.DEFAULT_WAIT).getText();
	}

	public String getOfficerEmergencyContactName() {
		return elementUtils.waitForElementVisible(dataOfficerEmergencyContactName, Constants.DEFAULT_WAIT).getText();
	}

	public String getOfficerEmergencyPhone() {
		return elementUtils.waitForElementVisible(dataOfficerEmergencyPhone, Constants.DEFAULT_WAIT).getText();
	}

	public String getOfficerNotes() {
		return elementUtils.waitForElementVisible(dataOfficerNotes, Constants.DEFAULT_WAIT).getText();
	}

	// Employment Information
	public void clickEmploymentInformationTab() {
		elementUtils.waitForElementToBeClickable(tabEmploymentInformation, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForInvisibilityOfElementLocated(loader, Constants.DEFAULT_WAIT);
	}

	public String getHireDate() {
		return elementUtils.waitForElementVisible(dataHireDate, Constants.DEFAULT_WAIT).getText();
	}

	public String getClassCodeData() {
		return elementUtils.waitForElementVisible(dataClassCode, Constants.DEFAULT_WAIT).getText();
	}

	public String getEmploymentTypeData() {
		return elementUtils.waitForElementVisible(dataEmploymentType, Constants.DEFAULT_WAIT).getText();
	}

	public String getDepartmentTypeData() {
		return elementUtils.waitForElementVisible(dataDepartmentType, Constants.DEFAULT_WAIT).getText();
	}

	// Permit
	public void clickPermitTab() {
		elementUtils.waitForElementToBeClickable(tabPermit, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForInvisibilityOfElementLocated(loader, Constants.DEFAULT_WAIT);
	}

	public String getDriverLicenseNumber() {
		elementUtils.waitForInvisibilityOfElementLocated(loader, Constants.DEFAULT_WAIT);
		return elementUtils.waitForElementVisible(dataDriverLicenseNumber, Constants.DEFAULT_WAIT).getText();
	}

	public String getDateOfIssue() {
		return elementUtils.waitForElementVisible(dataDateOfIssue, Constants.DEFAULT_WAIT).getText();
	}

	public String getDateOfExpiration() {
		return elementUtils.waitForElementVisible(dataDateOfExpiration, Constants.DEFAULT_WAIT).getText();
	}

	public boolean isFilesVisible() {
		return elementUtils.doIsDisplayed(dataFiles, Constants.SHORT_TIME_OUT_WAIT);
	}

	public void clickGuardCardTab() {
		elementUtils.waitForInvisibilityOfElementLocated(loader, Constants.DEFAULT_WAIT);
		elementUtils.clickElementWithScroll(tabGuardCard, Constants.DEFAULT_WAIT);
		elementUtils.waitForInvisibilityOfElementLocated(loader, Constants.DEFAULT_WAIT);
	}

	public String getPermitNumberText() {
		elementUtils.waitForInvisibilityOfElementLocated(loader, Constants.DEFAULT_WAIT);
		return elementUtils.waitForElementVisible(dataPermitNumber, Constants.DEFAULT_WAIT).getText();
	}

	public String getGuardCardDateOfIssueText() {
		return elementUtils.waitForElementVisible(dataGuardCardDateOfIssue, Constants.DEFAULT_WAIT).getText();
	}

	public String getGuardCardDateOfExpirationText() {
		return elementUtils.waitForElementVisible(dataGuardCardDateOfExpiration, Constants.DEFAULT_WAIT).getText();
	}

	public boolean isGuardCardFilesVisible() {
		return elementUtils.doIsDisplayed(dataGuardCardFiles, Constants.SHORT_TIME_OUT_WAIT);
	}

	public void clickFirearmsQualificationTab() {
		elementUtils.clickElementWithScroll(tabFirearmsQualification, Constants.DEFAULT_WAIT);
		elementUtils.waitForInvisibilityOfElementLocated(loader, Constants.DEFAULT_WAIT);
	}

	public String getFirearmsQualificationPermitNumberText() {
		elementUtils.waitForInvisibilityOfElementLocated(loader, Constants.DEFAULT_WAIT);
		return elementUtils.waitForElementVisible(dataFirearmsQualificationPermitNumber, Constants.DEFAULT_WAIT)
				.getText();
	}

	public String getFirearmsQualificationDateOfIssueText() {
		return elementUtils.waitForElementVisible(dataFirearmsQualificationDateOfIssue, Constants.DEFAULT_WAIT)
				.getText();
	}

	public String getFirearmsQualificationDateOfExpirationText() {
		return elementUtils.waitForElementVisible(dataFirearmsQualificationDateOfExpiration, Constants.DEFAULT_WAIT)
				.getText();
	}

	public boolean isFirearmsQualificationFilesVisible() {
		return elementUtils.doIsDisplayed(dataFirearmsQualificationFiles, Constants.SHORT_TIME_OUT_WAIT);
	}

	public void clickBatonTab() {
		elementUtils.clickElementWithScroll(tabBaton, Constants.DEFAULT_WAIT);
		elementUtils.waitForInvisibilityOfElementLocated(loader, Constants.DEFAULT_WAIT);
	}

	public String getBatonPermitNumberText() {
		elementUtils.waitForInvisibilityOfElementLocated(loader, Constants.DEFAULT_WAIT);
		return elementUtils.waitForElementVisible(dataBatonPermitNumber, Constants.DEFAULT_WAIT).getText();
	}

	public String getBatonDateOfIssueText() {
		return elementUtils.waitForElementVisible(dataBatonDateOfIssue, Constants.DEFAULT_WAIT).getText();
	}

	public String getBatonDateOfExpirationText() {
		return elementUtils.waitForElementVisible(dataBatonDateOfExpiration, Constants.DEFAULT_WAIT).getText();
	}

	public boolean isBatonFilesVisible() {
		return elementUtils.doIsDisplayed(dataBatonFiles, Constants.SHORT_TIME_OUT_WAIT);
	}

	public void clickECDTab() {
		elementUtils.clickElementWithScroll(tabECD, Constants.DEFAULT_WAIT);
		elementUtils.waitForInvisibilityOfElementLocated(loader, Constants.DEFAULT_WAIT);
	}

	public String getECDPermitNumberText() {
		elementUtils.waitForInvisibilityOfElementLocated(loader, Constants.DEFAULT_WAIT);
		return elementUtils.waitForElementVisible(dataECDPermitNumber, Constants.DEFAULT_WAIT).getText();
	}

	public String getECDDateOfIssueText() {
		return elementUtils.waitForElementVisible(dataECDDateOfIssue, Constants.DEFAULT_WAIT).getText();
	}

	public String getECDDateOfExpirationText() {
		return elementUtils.waitForElementVisible(dataECDDateOfExpiration, Constants.DEFAULT_WAIT).getText();
	}

	public boolean isECDFilesVisible() {
		return elementUtils.doIsDisplayed(dataECDFiles, Constants.SHORT_TIME_OUT_WAIT);
	}

	//
	public void clickOCSprayTab() {
		elementUtils.clickElementWithScroll(tabOCSpray, Constants.DEFAULT_WAIT);
		elementUtils.waitForInvisibilityOfElementLocated(loader, Constants.DEFAULT_WAIT);
	}

	public String getOCSprayPermitNumberText() {
		elementUtils.waitForInvisibilityOfElementLocated(loader, Constants.DEFAULT_WAIT);
		return elementUtils.waitForElementVisible(dataOCSprayPermitNumber, Constants.DEFAULT_WAIT).getText();
	}

	public String getOCSprayDateOfIssueText() {
		return elementUtils.waitForElementVisible(dataOCSprayDateOfIssue, Constants.DEFAULT_WAIT).getText();
	}

	public String getOCSprayDateOfExpirationText() {
		return elementUtils.waitForElementVisible(dataOCSprayDateOfExpiration, Constants.DEFAULT_WAIT).getText();
	}

	public boolean isOCSprayFilesVisible() {
		return elementUtils.doIsDisplayed(dataOCSprayFiles, Constants.SHORT_TIME_OUT_WAIT);
	}

	public void clickOtherTab() {
		elementUtils.clickElementWithScroll(tabOther, Constants.DEFAULT_WAIT);
		elementUtils.waitForInvisibilityOfElementLocated(loader, Constants.DEFAULT_WAIT);
	}

	public String getOtherPermitNumberText() {
		elementUtils.waitForInvisibilityOfElementLocated(loader, Constants.DEFAULT_WAIT);
		return elementUtils.waitForElementVisible(dataOtherPermitNumber, Constants.DEFAULT_WAIT).getText();
	}

	public String getOtherPermitDateOfIssueText() {
		return elementUtils.waitForElementVisible(dataOtherDateOfIssue, Constants.DEFAULT_WAIT).getText();
	}

	public String getOtherPermitDateOfExpirationText() {
		return elementUtils.waitForElementVisible(dataOtherDateOfExpiration, Constants.DEFAULT_WAIT).getText();
	}

	public boolean isOtherVisible() {
		return elementUtils.doIsDisplayed(dataOtherFiles, Constants.SHORT_TIME_OUT_WAIT);
	}

	// Pay Info
	public void clickPayInfoTab() {
		elementUtils.clickElementWithScroll(tabPayInfo, Constants.DEFAULT_WAIT);
		elementUtils.waitForInvisibilityOfElementLocated(loader, Constants.DEFAULT_WAIT);
	}

	public String getPayCycleData() {
		elementUtils.waitForInvisibilityOfElementLocated(loader, Constants.DEFAULT_WAIT);
		return elementUtils.waitForElementVisible(dataPayCycle, Constants.DEFAULT_WAIT).getText();
	}

//	public String getPayEffectiveDateData() {
//		return elementUtils.waitForElementVisible(dataPayEffectiveDate, Constants.DEFAULT_WAIT).getText();
//	}

	public String getPayRateData() {
		return elementUtils.waitForElementVisible(dataPayRate, Constants.DEFAULT_WAIT).getText();
	}

	//
	public String getCommissionCycleData() {
		return elementUtils.waitForElementVisible(dataCommissionCycle, Constants.DEFAULT_WAIT).getText();
	}

	public String getCommissionNameData() {
		return elementUtils.waitForElementVisible(dataCommissionName, Constants.DEFAULT_WAIT).getText();
	}

	public String getCommissionEffectiveDateData() {
		return elementUtils.waitForElementVisible(dataCommissionEffectiveDate, Constants.DEFAULT_WAIT).getText();
	}

	public String getCommissionRateData() {
		return elementUtils.waitForElementVisible(dataCommissionRate, Constants.DEFAULT_WAIT).getText();
	}

	// Additional Documents
	public void clickAdditionalDocumentsTab() {
		elementUtils.clickElementWithScroll(tabAdditionalDocuments, Constants.DEFAULT_WAIT);
		elementUtils.waitForInvisibilityOfElementLocated(loader, Constants.DEFAULT_WAIT);
	}

	public boolean isDocumentTypeVisible() {
		elementUtils.waitForInvisibilityOfElementLocated(loader, Constants.DEFAULT_WAIT);
		return elementUtils.doIsDisplayed(dataDocumentType, Constants.DEFAULT_WAIT);
	}

	public String getDescriptionText() {
		return elementUtils.waitForElementVisible(dataDescription, Constants.DEFAULT_WAIT).getText();
	}

	public boolean isFileVisible() {
		return elementUtils.doIsDisplayed(dataFile, Constants.DEFAULT_WAIT);
	}

	// References
	public void clickReferencesTab() {
		elementUtils.clickElementWithScroll(tabReferences, Constants.DEFAULT_WAIT);
		elementUtils.waitForInvisibilityOfElementLocated(loader, Constants.DEFAULT_WAIT);
	}

	public String getReferenceTitle() {
		elementUtils.clickElementWithScroll(tabReferences, Constants.DEFAULT_WAIT);
		return elementUtils.waitForElementVisible(dataReferenceTitle, Constants.DEFAULT_WAIT).getText();
	}

	public String getReferenceName() {
		return elementUtils.waitForElementVisible(dataReferenceName, Constants.DEFAULT_WAIT).getText();
	}

	public String getReferenceEmail() {
		return elementUtils.waitForElementVisible(dataReferenceEmail, Constants.DEFAULT_WAIT).getText();
	}

	public String getReferencePhone() {
		return elementUtils.waitForElementVisible(dataReferencePhone, Constants.DEFAULT_WAIT).getText();
	}

	public String getReferenceRelationship() {
		return elementUtils.waitForElementVisible(dataReferenceRelationship, Constants.DEFAULT_WAIT).getText();
	}

}
