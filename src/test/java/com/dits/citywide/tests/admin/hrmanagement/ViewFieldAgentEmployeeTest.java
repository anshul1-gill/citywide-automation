package com.dits.citywide.tests.admin.hrmanagement;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.HRManagementConstants;
import com.dits.citywide.utilities.DateFormatterUtils;
import com.dits.citywide.utilities.NormalizePhoneNumber;

public class ViewFieldAgentEmployeeTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test
	public void viewEmployeeFieldAgentTest() throws InterruptedException {
		dashboardPage.doClickHRManagement();
		Thread.sleep(6000);
		employeesPage = dashboardPage.doClickEmployees();

		employeesPage.selectStatus();
		employeesPage.searchInTextbox(prop.getProperty("employeeID"));
		Thread.sleep(4000);
		softAssert.assertEquals(employeesPage.getEmployeeIdData(), prop.getProperty("employeeID"),
				"Employee ID does not match");
		softAssert.assertEquals(employeesPage.getFirstNameData(), HRManagementConstants.FIRST_NAME,
				"First Name does not match");
		softAssert.assertEquals(employeesPage.getLastNameData(), HRManagementConstants.LAST_NAME,
				"Last Name does not match");
		softAssert.assertEquals(employeesPage.getBranchNameData(), HRManagementConstants.BRANCHES,
				"Branch does not match");

		softAssert.assertEquals(NormalizePhoneNumber.normalizePhoneNumber(employeesPage.getPrimaryPhoneNumberData()),
				HRManagementConstants.COUNTRY_CODE + HRManagementConstants.PRIMARY_PHONE_NUMBER,
				"Primary Phone Number does not match");

		softAssert.assertEquals(employeesPage.getRolesData().trim(), HRManagementConstants.ROLE_FIELD,
				"Role does not match");

		viewEmployeePage = employeesPage.doClickViewEmployee();

		// Profile Details
		Thread.sleep(1000);
		softAssert.assertEquals(
				viewEmployeePage.getProfileName(), HRManagementConstants.FIRST_NAME + " "
						+ HRManagementConstants.MIDDLE_NAME + " " + HRManagementConstants.LAST_NAME,
				"Profile name does not match");
		softAssert.assertEquals(viewEmployeePage.getProfileStatus(), HRManagementConstants.EMPLOYMENT_STATUS,
				"Profile status does not match");
		softAssert.assertEquals(viewEmployeePage.getProfileRole().trim(),
				(HRManagementConstants.ROLE_FIELD).toUpperCase(), "Profile role does not match");
		softAssert.assertEquals(viewEmployeePage.getProfileRank().trim(), HRManagementConstants.RANK,
				"Profile rank does not match");

//		softAssert.assertEquals(viewEmployeePage.getProfileLocation().trim(),
//				HRManagementConstants.RESIDENCE_ADDRESS_STREET + " "
//						+ HRManagementConstants.RESIDENCE_ADDRESS_STREET_NAME + " "
//						+ HRManagementConstants.RESIDENCE_ADDRESS_STE_NUMBER + " "
//						+ HRManagementConstants.RESIDENCE_ADDRESS_CITY + ", "
//						+ HRManagementConstants.RESIDENCE_ADDRESS_STATE + " "
//						+ HRManagementConstants.RESIDENCE_ADDRESS_ZIPCODE);

//		softAssert.assertEquals(
//				NormalizePhoneNumber.normalizePhoneNumber(viewEmployeePage.getProfileEmailPhone().trim()),
//				prop.getProperty("employeePrimaryEmail") + HRManagementConstants.COUNTRY_CODE
//						+ HRManagementConstants.PRIMARY_PHONE_NUMBER);

		// Personal Information
		softAssert.assertEquals(viewEmployeePage.getOfficerIdName(),
				prop.getProperty("employeeID") + " - " + HRManagementConstants.FIRST_NAME + " "
						+ HRManagementConstants.MIDDLE_NAME + " " + HRManagementConstants.LAST_NAME,
				"Officer ID name mismatch");
//		softAssert.assertEquals(viewEmployeePage.getOfficerName(),
//				HRManagementConstants.FIRST_NAME + " " + HRManagementConstants.LAST_NAME);
		softAssert.assertEquals(viewEmployeePage.getOfficerEmailAddress(), prop.getProperty("employeePrimaryEmail"),
				"Officer email address mismatch");
		softAssert.assertEquals(viewEmployeePage.getOfficerGender(), HRManagementConstants.GENDER, "Gender mismatch");
		softAssert.assertEquals(viewEmployeePage.getOfficerBranches(), HRManagementConstants.BRANCHES,
				"Branch mismatch");
		softAssert.assertEquals(viewEmployeePage.getOfficerPrimaryEmail(), prop.getProperty("employeePrimaryEmail"),
				"Officer primary email mismatch");
		softAssert.assertEquals(viewEmployeePage.getOfficerAlternateEmail(), prop.getProperty("employeeSecondaryEmail"),
				"Officer alternate email mismatch");

		softAssert.assertEquals(NormalizePhoneNumber.normalizePhoneNumber(viewEmployeePage.getOfficerPrimaryPhone()),
				HRManagementConstants.COUNTRY_CODE + HRManagementConstants.PRIMARY_PHONE_NUMBER,
				"Officer primary phone mismatch");

		softAssert.assertEquals(NormalizePhoneNumber.normalizePhoneNumber(viewEmployeePage.getOfficerAlternatePhone()),
				HRManagementConstants.COUNTRY_CODE + HRManagementConstants.ALTERNATE_PHONE_NUMBER,
				"Officer alternate phone mismatch");

		softAssert.assertEquals(viewEmployeePage.getOfficerEmergencyContactName(), HRManagementConstants.EMERGENCY_NAME,
				"Officer emergency contact name mismatch");

		softAssert.assertEquals(NormalizePhoneNumber.normalizePhoneNumber(viewEmployeePage.getOfficerEmergencyPhone()),
				HRManagementConstants.COUNTRY_CODE + HRManagementConstants.ALTERNATE_PHONE_NUMBER,
				"Officer emergency contact phone mismatch");
		softAssert.assertEquals(viewEmployeePage.getOfficerNotes(), HRManagementConstants.PERSONAL_INFO_NOTES,
				"Officer notes mismatch");

		// Employment Information
		viewEmployeePage.clickEmploymentInformationTab();
		softAssert.assertEquals(viewEmployeePage.getHireDate(),
				DateFormatterUtils.getMonthNumber(HRManagementConstants.EMPLOYMENT_HIRE_MONTH) + "/"
						+ HRManagementConstants.EMPLOYMENT_HIRE_DATE + "/" + HRManagementConstants.EMPLOYMENT_HIRE_YEAR,
				"Hire date mismatch");

//		softAssert.assertEquals(viewEmployeePage.getClassCodeData(),
//				HRManagementConstants.CLASS_CODE + " / "
//						+ DateFormatterUtils.getMonthNumber(HRManagementConstants.EMPLOYMENT_HIRE_MONTH) + "/"
//						+ HRManagementConstants.EMPLOYMENT_HIRE_DATE + "/" + HRManagementConstants.EMPLOYMENT_HIRE_YEAR,
//				"Class code mismatch");

//		softAssert.assertEquals(viewEmployeePage.getEmploymentTypeData(),
//				HRManagementConstants.EMPLOYMENT_TYPE + " / "
//						+ DateFormatterUtils.getMonthNumber(HRManagementConstants.EMPLOYMENT_HIRE_MONTH) + "/"
//						+ HRManagementConstants.EMPLOYMENT_HIRE_DATE + "/" + HRManagementConstants.EMPLOYMENT_HIRE_YEAR,
//				"Employment type mismatch");

//		softAssert.assertEquals(viewEmployeePage.getDepartmentTypeData(),
//				HRManagementConstants.DEPARTMENT_TYPE + " / "
//						+ DateFormatterUtils.getMonthNumber(HRManagementConstants.EMPLOYMENT_HIRE_MONTH) + "/"
//						+ HRManagementConstants.EMPLOYMENT_HIRE_DATE + "/" + HRManagementConstants.EMPLOYMENT_HIRE_YEAR,
//				"Department type mismatch");

		// Permit
		viewEmployeePage.clickPermitTab();
		softAssert.assertEquals(viewEmployeePage.getDriverLicenseNumber(), HRManagementConstants.DRIVER_LICENSE_NUMBER,
				"Driver license number mismatch");
		softAssert.assertEquals(viewEmployeePage.getDateOfIssue(), HRManagementConstants.DRIVER_LICENSE_ISSUE_DATE,
				"Driver license date of issue mismatch");
		softAssert.assertEquals(viewEmployeePage.getDateOfExpiration(),
				HRManagementConstants.DRIVER_LICENSE_EXPIRATION_DATE, "Driver license date of expiration mismatch");
		softAssert.assertTrue(viewEmployeePage.isFilesVisible(), "Driver license files are not visible");

		Thread.sleep(3000);
		viewEmployeePage.clickGuardCardTab();
		softAssert.assertEquals(viewEmployeePage.getPermitNumberText(), HRManagementConstants.PERMIT_NUMBER,
				"Guard card permit number mismatch");
		softAssert.assertEquals(viewEmployeePage.getGuardCardDateOfIssueText(),
				HRManagementConstants.GUARD_CARD_ISSUE_DATE, "Guard card date of issue mismatch");
		softAssert.assertEquals(viewEmployeePage.getGuardCardDateOfExpirationText(),
				HRManagementConstants.GAURD_CARD_EXPIRATION_DATE, "Guard card date of expiration mismatch");
		softAssert.assertTrue(viewEmployeePage.isGuardCardFilesVisible(), "Guard card files are not visible");

		Thread.sleep(2000);
		viewEmployeePage.clickFirearmsQualificationTab();
		softAssert.assertEquals(viewEmployeePage.getFirearmsQualificationPermitNumberText(),
				HRManagementConstants.FIREARMS_PERMIT_NUMBER, "Firearms qualification permit number mismatch");
		softAssert.assertEquals(viewEmployeePage.getFirearmsQualificationDateOfIssueText(),
				HRManagementConstants.FIREARMS_ISSUE_DATE, "Firearms qualification date of issue mismatch");
		softAssert.assertEquals(viewEmployeePage.getFirearmsQualificationDateOfExpirationText(),
				HRManagementConstants.FIREARMS_EXPIRATION_DATE, "Firearms qualification date of expiration mismatch");
		softAssert.assertTrue(viewEmployeePage.isFirearmsQualificationFilesVisible(),
				"Firearms qualification files are not visible");

		Thread.sleep(2000);
		viewEmployeePage.clickBatonTab();
		softAssert.assertEquals(viewEmployeePage.getBatonPermitNumberText(), HRManagementConstants.BATON_PERMIT_NUMBER,
				"Baton permit number mismatch");
		softAssert.assertEquals(viewEmployeePage.getBatonDateOfIssueText(), HRManagementConstants.BATON_ISSUE_DATE,
				"Baton date of issue mismatch");
		softAssert.assertEquals(viewEmployeePage.getBatonDateOfExpirationText(),
				HRManagementConstants.BATON_EXPIRATION_DATE, "Baton date of expiration mismatch");
		softAssert.assertTrue(viewEmployeePage.isBatonFilesVisible(), "Baton files are not visible");

		Thread.sleep(2000);
		viewEmployeePage.clickECDTab();
		softAssert.assertEquals(viewEmployeePage.getECDPermitNumberText(), HRManagementConstants.ECD_PERMIT_NUMBER,
				"ECD permit number mismatch");
		softAssert.assertEquals(viewEmployeePage.getECDDateOfIssueText(), HRManagementConstants.ECD_ISSUE_DATE,
				"ECD date of issue mismatch");
		softAssert.assertEquals(viewEmployeePage.getECDDateOfExpirationText(),
				HRManagementConstants.ECD_EXPIRATION_DATE, "ECD date of expiration mismatch");
		softAssert.assertTrue(viewEmployeePage.isECDFilesVisible(), "ECD files are not visible");

		Thread.sleep(2000);
		viewEmployeePage.clickOCSprayTab();
		softAssert.assertEquals(viewEmployeePage.getOCSprayPermitNumberText(),
				HRManagementConstants.OC_SPRAY_PERMIT_NUMBER, "OC Spray permit number mismatch");
		softAssert.assertEquals(viewEmployeePage.getOCSprayDateOfIssueText(), HRManagementConstants.OC_SPRAY_ISSUE_DATE,
				"OC Spray date of issue mismatch");
		softAssert.assertEquals(viewEmployeePage.getOCSprayDateOfExpirationText(),
				HRManagementConstants.OC_SPRAY_EXPIRATION_DATE, "OC Spray date of expiration mismatch");
		softAssert.assertTrue(viewEmployeePage.isOCSprayFilesVisible(), "OC Spray files are not visible");

		Thread.sleep(2000);
		viewEmployeePage.clickOtherTab();
		softAssert.assertEquals(viewEmployeePage.getOtherPermitNumberText(), HRManagementConstants.OTHER_PERMIT_NUMBER);
		softAssert.assertEquals(viewEmployeePage.getOtherPermitDateOfIssueText(),
				HRManagementConstants.OTHER_PERMIT_ISSUE_DATE, "Other permit date of issue mismatch");
		softAssert.assertEquals(viewEmployeePage.getOtherPermitDateOfExpirationText(),
				HRManagementConstants.OTHER_PERMIT_EXPIRATION_DATE, "Other permit date of expiration mismatch");
		softAssert.assertTrue(viewEmployeePage.isOtherVisible(), "Other permit files are not visible");

		// Pay Info
		viewEmployeePage.clickPayInfoTab();
		Thread.sleep(2000);
		softAssert.assertEquals(viewEmployeePage.getPayCycleData(), HRManagementConstants.PAY_CYCYLE,
				"Pay cycle mismatch");

//		softAssert.assertEquals("0" + viewEmployeePage.getPayEffectiveDateData(),
//				DateFormatterUtils.getMonthNumber(HRManagementConstants.EMPLOYMENT_HIRE_MONTH) + "/"
//						+ HRManagementConstants.EMPLOYMENT_HIRE_DATE + "/"
//						+ HRManagementConstants.EMPLOYMENT_HIRE_YEAR);
		softAssert.assertEquals(viewEmployeePage.getPayRateData(), "$ " + HRManagementConstants.EMPLOYEE_PAY_RATE,
				"Pay rate mismatch");

		softAssert.assertEquals(viewEmployeePage.getCommissionCycleData(), HRManagementConstants.COMMISSION_CYCLE,
				"Commission cycle mismatch");
		softAssert.assertEquals(viewEmployeePage.getCommissionNameData(), HRManagementConstants.COMMISSION_NAME,
				"Commission name mismatch");
		softAssert.assertEquals(viewEmployeePage.getCommissionEffectiveDateData(), HRManagementConstants.EFFECTIVE_DATE,
				"Commission effective date mismatch");
		softAssert.assertEquals(viewEmployeePage.getCommissionRateData(), "$" + HRManagementConstants.COMMISSION_RATE,
				"Commission rate mismatch");

		// Additional Documents
		viewEmployeePage.clickAdditionalDocumentsTab();
		softAssert.assertTrue(viewEmployeePage.isDocumentTypeVisible(), "Document Type is not visible");
		softAssert.assertEquals(viewEmployeePage.getDescriptionText(),
				HRManagementConstants.ADDITIONAL_DOCUMENT_DESCRIPTION);
		softAssert.assertTrue(viewEmployeePage.isFileVisible(), "File is not visible");

		// References
		viewEmployeePage.clickReferencesTab();
		softAssert.assertEquals(viewEmployeePage.getReferenceTitle(), HRManagementConstants.USER_REFERENCES_TITLE,
				"Reference title does not match");
		softAssert.assertEquals(viewEmployeePage.getReferenceName(), HRManagementConstants.USER_REFERENCES_NAME,
				"Reference name does not match");
		softAssert.assertEquals(viewEmployeePage.getReferenceEmail(), HRManagementConstants.USER_REFERENCES_EMAIL,
				"Reference email does not match");
		softAssert.assertEquals(NormalizePhoneNumber.normalizePhoneNumber(viewEmployeePage.getReferencePhone()),
				"+1" + HRManagementConstants.USER_REFERENCES_PHONE, "Reference phone number does not match");
		softAssert.assertEquals(viewEmployeePage.getReferenceRelationship(),
				HRManagementConstants.USER_REFERENCES_RELATIONSHIP, "Reference relationship does not match");

		softAssert.assertAll();
	}
}
