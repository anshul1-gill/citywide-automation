package com.dits.citywide.tests.admin.hrmanagement;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.HRManagementConstants;
import com.dits.citywide.utilities.DateFormatterUtils;
import com.dits.citywide.utilities.NormalizePhoneNumber;

public class ViewPatrolEmployeeTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test
	public void viewPatrolEmployeeTest() throws InterruptedException {
		dashboardPage.doClickHRManagement();
		Thread.sleep(6000);
		employeesPage = dashboardPage.doClickEmployees();

		employeesPage.selectStatus();
		employeesPage.searchInTextbox(prop.getProperty("patrolID"));
		Thread.sleep(4000);
		softAssert.assertEquals(employeesPage.getEmployeeIdData(), prop.getProperty("patrolID"));
		softAssert.assertEquals(employeesPage.getFirstNameData(), HRManagementConstants.FIRST_NAME_PATROL);
		softAssert.assertEquals(employeesPage.getLastNameData(), HRManagementConstants.LAST_NAME_PATROL);
		softAssert.assertEquals(employeesPage.getBranchNameData(), HRManagementConstants.BRANCHES);

		softAssert.assertEquals(NormalizePhoneNumber.normalizePhoneNumber(employeesPage.getPrimaryPhoneNumberData()),
				HRManagementConstants.COUNTRY_CODE + HRManagementConstants.PRIMARY_PHONE_NUMBER);

		softAssert.assertEquals(employeesPage.getRolesData().trim(), HRManagementConstants.ROLE_PATROL);

		viewEmployeePage = employeesPage.doClickViewEmployee();

		// Profile Details
		Thread.sleep(1000);
		softAssert.assertEquals(viewEmployeePage.getProfileName(), HRManagementConstants.FIRST_NAME_PATROL + " "
				+ HRManagementConstants.MIDDLE_NAME_PATROL + " " + HRManagementConstants.LAST_NAME_PATROL);
		softAssert.assertEquals(viewEmployeePage.getProfileStatus(), HRManagementConstants.EMPLOYMENT_STATUS);
		softAssert.assertEquals(viewEmployeePage.getProfileRole().trim(),
				(HRManagementConstants.ROLE_PATROL).toUpperCase());
		softAssert.assertEquals(viewEmployeePage.getProfileRank().trim(), HRManagementConstants.RANK_PATROL);

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
				prop.getProperty("patrolID") + " - " + HRManagementConstants.FIRST_NAME_PATROL + " "
						+ HRManagementConstants.MIDDLE_NAME_PATROL + " " + HRManagementConstants.LAST_NAME_PATROL);
//		softAssert.assertEquals(viewEmployeePage.getOfficerName(),
//				HRManagementConstants.FIRST_NAME + " " + HRManagementConstants.LAST_NAME);
		softAssert.assertEquals(viewEmployeePage.getOfficerEmailAddress(), prop.getProperty("employeePrimaryEmail"));
		softAssert.assertEquals(viewEmployeePage.getOfficerGender(), HRManagementConstants.GENDER_PATROL);
		softAssert.assertEquals(viewEmployeePage.getOfficerBranches(), HRManagementConstants.BRANCHES);
		softAssert.assertEquals(viewEmployeePage.getOfficerPrimaryEmail(), prop.getProperty("employeePrimaryEmail"));
		softAssert.assertEquals(viewEmployeePage.getOfficerAlternateEmail(),
				prop.getProperty("employeeSecondaryEmail"));

		softAssert.assertEquals(NormalizePhoneNumber.normalizePhoneNumber(viewEmployeePage.getOfficerPrimaryPhone()),
				HRManagementConstants.COUNTRY_CODE + HRManagementConstants.PRIMARY_PHONE_NUMBER);

		softAssert.assertEquals(NormalizePhoneNumber.normalizePhoneNumber(viewEmployeePage.getOfficerAlternatePhone()),
				HRManagementConstants.COUNTRY_CODE + HRManagementConstants.ALTERNATE_PHONE_NUMBER);

		softAssert.assertEquals(viewEmployeePage.getOfficerEmergencyContactName(),
				HRManagementConstants.EMERGENCY_NAME);

		softAssert.assertEquals(NormalizePhoneNumber.normalizePhoneNumber(viewEmployeePage.getOfficerEmergencyPhone()),
				HRManagementConstants.COUNTRY_CODE + HRManagementConstants.ALTERNATE_PHONE_NUMBER);
		softAssert.assertEquals(viewEmployeePage.getOfficerNotes(), HRManagementConstants.PERSONAL_INFO_NOTES);

		// Employment Information
		viewEmployeePage.clickEmploymentInformationTab();
		softAssert.assertEquals(viewEmployeePage.getHireDate(),
				DateFormatterUtils.getMonthNumber(HRManagementConstants.EMPLOYMENT_HIRE_MONTH) + "/"
						+ HRManagementConstants.EMPLOYMENT_HIRE_DATE + "/"
						+ HRManagementConstants.EMPLOYMENT_HIRE_YEAR);

		softAssert.assertEquals(viewEmployeePage.getClassCodeData(), HRManagementConstants.CLASS_CODE + " / "
				+ DateFormatterUtils.getMonthNumber(HRManagementConstants.EMPLOYMENT_HIRE_MONTH) + "/"
				+ HRManagementConstants.EMPLOYMENT_HIRE_DATE + "/" + HRManagementConstants.EMPLOYMENT_HIRE_YEAR);

		softAssert.assertEquals(viewEmployeePage.getEmploymentTypeData(), HRManagementConstants.EMPLOYMENT_TYPE + " / "
				+ DateFormatterUtils.getMonthNumber(HRManagementConstants.EMPLOYMENT_HIRE_MONTH) + "/"
				+ HRManagementConstants.EMPLOYMENT_HIRE_DATE + "/" + HRManagementConstants.EMPLOYMENT_HIRE_YEAR);

		softAssert.assertEquals(viewEmployeePage.getDepartmentTypeData(), HRManagementConstants.DEPARTMENT_TYPE + " / "
				+ DateFormatterUtils.getMonthNumber(HRManagementConstants.EMPLOYMENT_HIRE_MONTH) + "/"
				+ HRManagementConstants.EMPLOYMENT_HIRE_DATE + "/" + HRManagementConstants.EMPLOYMENT_HIRE_YEAR);

		// Permit
		viewEmployeePage.clickPermitTab();
		softAssert.assertEquals(viewEmployeePage.getDriverLicenseNumber(), HRManagementConstants.DRIVER_LICENSE_NUMBER);
		softAssert.assertEquals(viewEmployeePage.getDateOfIssue(), HRManagementConstants.DRIVER_LICENSE_ISSUE_DATE);
		softAssert.assertEquals(viewEmployeePage.getDateOfExpiration(),
				HRManagementConstants.DRIVER_LICENSE_EXPIRATION_DATE);
		softAssert.assertTrue(viewEmployeePage.isFilesVisible());

		Thread.sleep(3000);
		viewEmployeePage.clickGuardCardTab();
		softAssert.assertEquals(viewEmployeePage.getPermitNumberText(), HRManagementConstants.PERMIT_NUMBER);
		softAssert.assertEquals(viewEmployeePage.getGuardCardDateOfIssueText(),
				HRManagementConstants.GUARD_CARD_ISSUE_DATE);
		softAssert.assertEquals(viewEmployeePage.getGuardCardDateOfExpirationText(),
				HRManagementConstants.GAURD_CARD_EXPIRATION_DATE);
		softAssert.assertTrue(viewEmployeePage.isGuardCardFilesVisible());

		Thread.sleep(2000);
		viewEmployeePage.clickFirearmsQualificationTab();
		softAssert.assertEquals(viewEmployeePage.getFirearmsQualificationPermitNumberText(),
				HRManagementConstants.FIREARMS_PERMIT_NUMBER);
		softAssert.assertEquals(viewEmployeePage.getFirearmsQualificationDateOfIssueText(),
				HRManagementConstants.FIREARMS_ISSUE_DATE);
		softAssert.assertEquals(viewEmployeePage.getFirearmsQualificationDateOfExpirationText(),
				HRManagementConstants.FIREARMS_EXPIRATION_DATE);
		softAssert.assertTrue(viewEmployeePage.isFirearmsQualificationFilesVisible());

		Thread.sleep(2000);
		viewEmployeePage.clickBatonTab();
		softAssert.assertEquals(viewEmployeePage.getBatonPermitNumberText(), HRManagementConstants.BATON_PERMIT_NUMBER);
		softAssert.assertEquals(viewEmployeePage.getBatonDateOfIssueText(), HRManagementConstants.BATON_ISSUE_DATE);
		softAssert.assertEquals(viewEmployeePage.getBatonDateOfExpirationText(),
				HRManagementConstants.BATON_EXPIRATION_DATE);
		softAssert.assertTrue(viewEmployeePage.isBatonFilesVisible());

		Thread.sleep(2000);
		viewEmployeePage.clickECDTab();
		softAssert.assertEquals(viewEmployeePage.getECDPermitNumberText(), HRManagementConstants.ECD_PERMIT_NUMBER);
		softAssert.assertEquals(viewEmployeePage.getECDDateOfIssueText(), HRManagementConstants.ECD_ISSUE_DATE);
		softAssert.assertEquals(viewEmployeePage.getECDDateOfExpirationText(),
				HRManagementConstants.ECD_EXPIRATION_DATE);
		softAssert.assertTrue(viewEmployeePage.isECDFilesVisible());

		Thread.sleep(2000);
		viewEmployeePage.clickOCSprayTab();
		softAssert.assertEquals(viewEmployeePage.getOCSprayPermitNumberText(),
				HRManagementConstants.OC_SPRAY_PERMIT_NUMBER);
		softAssert.assertEquals(viewEmployeePage.getOCSprayDateOfIssueText(),
				HRManagementConstants.OC_SPRAY_ISSUE_DATE);
		softAssert.assertEquals(viewEmployeePage.getOCSprayDateOfExpirationText(),
				HRManagementConstants.OC_SPRAY_EXPIRATION_DATE);
		softAssert.assertTrue(viewEmployeePage.isOCSprayFilesVisible());

		Thread.sleep(2000);
		viewEmployeePage.clickOtherTab();
		softAssert.assertEquals(viewEmployeePage.getOtherPermitNumberText(), HRManagementConstants.OTHER_PERMIT_NUMBER);
		softAssert.assertEquals(viewEmployeePage.getOtherPermitDateOfIssueText(),
				HRManagementConstants.OTHER_PERMIT_ISSUE_DATE);
		softAssert.assertEquals(viewEmployeePage.getOtherPermitDateOfExpirationText(),
				HRManagementConstants.OTHER_PERMIT_EXPIRATION_DATE);
		softAssert.assertTrue(viewEmployeePage.isOtherVisible());

		// Pay Info
		viewEmployeePage.clickPayInfoTab();
		Thread.sleep(2000);
		softAssert.assertEquals(viewEmployeePage.getPayCycleData(), HRManagementConstants.PAY_CYCYLE);

//		softAssert.assertEquals("0" + viewEmployeePage.getPayEffectiveDateData(),
//				DateFormatterUtils.getMonthNumber(HRManagementConstants.EMPLOYMENT_HIRE_MONTH) + "/"
//						+ HRManagementConstants.EMPLOYMENT_HIRE_DATE + "/"
//						+ HRManagementConstants.EMPLOYMENT_HIRE_YEAR);
		softAssert.assertEquals(viewEmployeePage.getPayRateData(), "$ " + HRManagementConstants.EMPLOYEE_PAY_RATE);

		softAssert.assertEquals(viewEmployeePage.getCommissionCycleData(), HRManagementConstants.COMMISSION_CYCLE);
		softAssert.assertEquals(viewEmployeePage.getCommissionNameData(), HRManagementConstants.COMMISSION_NAME);
		softAssert.assertEquals(viewEmployeePage.getCommissionEffectiveDateData(),
				HRManagementConstants.EFFECTIVE_DATE);
		softAssert.assertEquals(viewEmployeePage.getCommissionRateData(), "$" + HRManagementConstants.COMMISSION_RATE);

		// Additional Documents
		viewEmployeePage.clickAdditionalDocumentsTab();
		softAssert.assertTrue(viewEmployeePage.isDocumentTypeVisible(), "Document Type is not visible");
		softAssert.assertEquals(viewEmployeePage.getDescriptionText(),
				HRManagementConstants.ADDITIONAL_DOCUMENT_DESCRIPTION);
		softAssert.assertTrue(viewEmployeePage.isFileVisible(), "File is not visible");

		// References
		viewEmployeePage.clickReferencesTab();
		softAssert.assertEquals(viewEmployeePage.getReferenceTitle(), HRManagementConstants.USER_REFERENCES_TITLE);
		softAssert.assertEquals(viewEmployeePage.getReferenceName(), HRManagementConstants.USER_REFERENCES_NAME);
		softAssert.assertEquals(viewEmployeePage.getReferenceEmail(), HRManagementConstants.USER_REFERENCES_EMAIL);
		softAssert.assertEquals(NormalizePhoneNumber.normalizePhoneNumber(viewEmployeePage.getReferencePhone()),
				"+1" + HRManagementConstants.USER_REFERENCES_PHONE);
		softAssert.assertEquals(viewEmployeePage.getReferenceRelationship(),
				HRManagementConstants.USER_REFERENCES_RELATIONSHIP);

		softAssert.assertAll();
	}
}
