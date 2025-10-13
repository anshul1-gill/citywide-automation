package com.dits.citywide.tests.admin.hrmanagement;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.HRManagementConstants;
import com.dits.citywide.utilities.NormalizePhoneNumber;
import com.dits.citywide.utilities.RandomEmailGenerator;

public class UpdateFieldAgentEmployeeTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test
	public void addNewEmployeeFieldAgentTest() throws InterruptedException {

		dashboardPage.doClickHRManagement();
		Thread.sleep(6000);
		employeesPage = dashboardPage.doClickEmployees();

		employeesPage.selectStatus();
		employeesPage.searchInTextbox(prop.getProperty("employeeID"));
		Thread.sleep(4000);
		softAssert.assertEquals(employeesPage.getEmployeeIdData(), prop.getProperty("employeeID"));
		softAssert.assertEquals(employeesPage.getFirstNameData(), HRManagementConstants.FIRST_NAME);
		softAssert.assertEquals(employeesPage.getLastNameData(), HRManagementConstants.LAST_NAME);
		softAssert.assertEquals(employeesPage.getBranchNameData(), HRManagementConstants.BRANCHES);
		softAssert.assertEquals(NormalizePhoneNumber.normalizePhoneNumber(employeesPage.getPrimaryPhoneNumberData()),
				HRManagementConstants.COUNTRY_CODE + HRManagementConstants.PRIMARY_PHONE_NUMBER);

		softAssert.assertEquals(employeesPage.getRolesData().trim(), HRManagementConstants.ROLE_FIELD);

		updateEmployeePage = employeesPage.doClickEditEmployee();

		updateEmployeePage.clickDeleteUserProfilePicture();
		// Image Upload
		softAssert.assertTrue(updateEmployeePage.isUploadUserProfilePictureTextDisplayed());
		updateEmployeePage.uploadProfileImage();
		softAssert.assertTrue(updateEmployeePage.isImageUploadSuccessMessageDisplayed());

		softAssert.assertTrue(updateEmployeePage.isPersonalInformationTextDisplayed());

		String primaryEmail = RandomEmailGenerator.generateRandomEmailForUser();
		driverFactory.updatePropertyValue("employeePrimaryEmail", primaryEmail);

		String secondaryEmail = RandomEmailGenerator.generateRandomEmailForUser();
		driverFactory.updatePropertyValue("employeeSecondaryEmail", secondaryEmail);

		// Personal Information
		updateEmployeePage.fillPersonalInformation(HRManagementConstants.UPDATED_FIRST_NAME, HRManagementConstants.UPDATED_MIDDLE_NAME,
				HRManagementConstants.UPDATED_LAST_NAME, HRManagementConstants.UPDATED_GENDER, HRManagementConstants.UPDATED_BIRTH_MONTH,
				HRManagementConstants.UPDATED_BIRTH_YEAR, HRManagementConstants.UPDATED_BIRTH_DATE,
				HRManagementConstants.UPDATED_SOCIAL_SECURITY_NUMBER, HRManagementConstants.ROLE_FIELD,
				HRManagementConstants.UPDATED_RANK, HRManagementConstants.UPDATED_ETHNIC_CODE, primaryEmail, secondaryEmail,
				HRManagementConstants.UPDATED_COUNTRY_CODE, HRManagementConstants.UPDATED_PRIMARY_PHONE_NUMBER,
				HRManagementConstants.UPDATED_ALTERNATE_PHONE_NUMBER, HRManagementConstants.UPDATED_EMERGENCY_NAME,
				HRManagementConstants.UPDATED_EMERGENCY_PHONE_NUMBER, HRManagementConstants.UPDATED_EMERGENCY_RELATIONSHIP,
				HRManagementConstants.UPDATED_PASSWORD, HRManagementConstants.UPDATED_CONFIRM_PASSWORD, HRManagementConstants.BRANCHES);

		updateEmployeePage.fillSiteName(HRManagementConstants.SITE);

		updateEmployeePage.fillResidenceAddress(HRManagementConstants.RESIDENCE_ADDRESS_STREET_NAME,
				HRManagementConstants.RESIDENCE_ADDRESS_STREET, HRManagementConstants.RESIDENCE_ADDRESS_STE_NUMBER,
				HRManagementConstants.RESIDENCE_ADDRESS_CITY, HRManagementConstants.RESIDENCE_ADDRESS_STATE,
				HRManagementConstants.RESIDENCE_ADDRESS_ZIPCODE, HRManagementConstants.RESIDENCE_ADDRESS_COUNTRY);

		updateEmployeePage.doClickSameAsAbove();
		updateEmployeePage.personalInformationNotes(HRManagementConstants.PERSONAL_INFO_NOTES);
		updateEmployeePage.doClickSaveButton();
		softAssert.assertEquals(updateEmployeePage.getPersonalInfoSuccessMessageText(),
				HRManagementConstants.PERSONAL_INFO_ADDED_SUCCESS_MESSAGE);

		// Employment Information
		updateEmployeePage.doClickEmploymentInformationTab();

		String employeeId = updateEmployeePage.getEmployeeID();
		System.out.println(employeeId); // Print ID
		driverFactory.updatePropertyValue("employeeID", employeeId);

		updateEmployeePage.fillEmploymentInformation(HRManagementConstants.EMPLOYMENT_STATUS,
				HRManagementConstants.EMPLOYMENT_HIRE_MONTH, HRManagementConstants.EMPLOYMENT_HIRE_YEAR,
				HRManagementConstants.EMPLOYMENT_HIRE_DATE, HRManagementConstants.EMPLOYMENT_NOTES);

		updateEmployeePage.fillClassCode(HRManagementConstants.CLASS_CODE);

		updateEmployeePage.fillEmploymentType(HRManagementConstants.EMPLOYMENT_TYPE);

		updateEmployeePage.fillDepartmentType(HRManagementConstants.DEPARTMENT_TYPE);
		updateEmployeePage.doClickSaveButton();

		softAssert.assertEquals(updateEmployeePage.getEmployeeInformationSuccessMessageText(),
				HRManagementConstants.EMPLOYEE_INFO_ADDED_SUCCESS_MESSAGE);

		// Permits
		updateEmployeePage.doClickPermits();
		updateEmployeePage.doClickAddLicenseDetailsButton();
		softAssert.assertTrue(updateEmployeePage.isDriverLicenseTextDisplayed());
		updateEmployeePage.fillDriverLicenseForm(HRManagementConstants.DRIVER_LICENSE_STATE,
				HRManagementConstants.DRIVER_LICENSE_NUMBER, HRManagementConstants.DRIVER_LICENSE_ISSUE_DATE,
				HRManagementConstants.DRIVER_LICENSE_EXPIRATION_DATE);

		softAssert.assertEquals(updateEmployeePage.getPermitAddedSuccessMessageText(),
				HRManagementConstants.PERMIT_ADDED_SUCCESS_MESSAGE);

		softAssert.assertEquals(updateEmployeePage.getDriverLicenseNumberData(),
				HRManagementConstants.DRIVER_LICENSE_NUMBER);
		softAssert.assertEquals(updateEmployeePage.getDateOfIssueData(),
				HRManagementConstants.DRIVER_LICENSE_ISSUE_DATE);
		softAssert.assertEquals(updateEmployeePage.getDateOfExpirationData(),
				HRManagementConstants.DRIVER_LICENSE_EXPIRATION_DATE);
		softAssert.assertEquals(updateEmployeePage.getDriverLicenseStateData(),
				HRManagementConstants.DRIVER_LICENSE_STATE);

		updateEmployeePage.doClickAddGuardCard();
		softAssert.assertTrue(updateEmployeePage.isGuardCardTextDisplayed());
		updateEmployeePage.fillGuardCardForm(HRManagementConstants.PERMIT_NUMBER,
				HRManagementConstants.GUARD_CARD_ISSUE_DATE, HRManagementConstants.GAURD_CARD_EXPIRATION_DATE);

		softAssert.assertEquals(updateEmployeePage.getGuardCardSuccessMessageText(),
				HRManagementConstants.PERMIT_ADDED_SUCCESS_MESSAGE);

		updateEmployeePage.doClickAddFirearmsQualification();
		softAssert.assertTrue(updateEmployeePage.isFirearmsQualificationTextDisplayed());
		softAssert.assertEquals(updateEmployeePage.getGuardCardPermitNumberData(), HRManagementConstants.PERMIT_NUMBER);
		softAssert.assertEquals(updateEmployeePage.getGuardCardDateOfIssueData(),
				HRManagementConstants.GUARD_CARD_ISSUE_DATE);
		softAssert.assertEquals(updateEmployeePage.getGuardCardDateOfExpirationData(),
				HRManagementConstants.GAURD_CARD_EXPIRATION_DATE);

		updateEmployeePage.fillFirearmsQualification(HRManagementConstants.FIREARMS_PERMIT_NUMBER,
				HRManagementConstants.FIREARMS_ISSUE_DATE, HRManagementConstants.FIREARMS_EXPIRATION_DATE,
				HRManagementConstants.FIREARMS_CALIBER, HRManagementConstants.FIREARMS_SERIAL,
				HRManagementConstants.FIREARMS_MAKE, HRManagementConstants.FIREARMS_MODEL);

		softAssert.assertEquals(updateEmployeePage.getFirearmsPermitNumberData(),
				HRManagementConstants.FIREARMS_PERMIT_NUMBER);
		softAssert.assertEquals(updateEmployeePage.getFirearmsDateOfIssueData(),
				HRManagementConstants.FIREARMS_ISSUE_DATE);
		softAssert.assertEquals(updateEmployeePage.getFirearmsDateOfExpirationData(),
				HRManagementConstants.FIREARMS_EXPIRATION_DATE);

		//
		updateEmployeePage.doClickAddBaton();
		softAssert.assertTrue(updateEmployeePage.isBatonTextDisplayed());
		updateEmployeePage.fillBatonForm(HRManagementConstants.BATON_PERMIT_NUMBER,
				HRManagementConstants.BATON_ISSUE_DATE, HRManagementConstants.BATON_EXPIRATION_DATE);

		softAssert.assertEquals(updateEmployeePage.getBatonPermitNumberData(),
				HRManagementConstants.BATON_PERMIT_NUMBER);
		softAssert.assertEquals(updateEmployeePage.getBatonDateOfIssueData(), HRManagementConstants.BATON_ISSUE_DATE);
		softAssert.assertEquals(updateEmployeePage.getBatonDateOfExpirationData(),
				HRManagementConstants.BATON_EXPIRATION_DATE);
		//
		updateEmployeePage.doClickAddECD();
		softAssert.assertTrue(updateEmployeePage.isECDTextDisplayed());
		updateEmployeePage.fillECDForm(HRManagementConstants.ECD_PERMIT_NUMBER, HRManagementConstants.ECD_ISSUE_DATE,
				HRManagementConstants.ECD_EXPIRATION_DATE);

		softAssert.assertEquals(updateEmployeePage.getBatonPermitNumberData(), HRManagementConstants.ECD_PERMIT_NUMBER);
		softAssert.assertEquals(updateEmployeePage.getECDDateOfIssueData(), HRManagementConstants.ECD_ISSUE_DATE);
		softAssert.assertEquals(updateEmployeePage.getECDDateOfExpirationData(),
				HRManagementConstants.ECD_EXPIRATION_DATE);

		Thread.sleep(2000);
		updateEmployeePage.doClickAddOCSpray();
		softAssert.assertTrue(updateEmployeePage.isOCSprayTextDisplayed());
		updateEmployeePage.fillOCSprayForm(HRManagementConstants.OC_SPRAY_PERMIT_NUMBER,
				HRManagementConstants.OC_SPRAY_ISSUE_DATE, HRManagementConstants.OC_SPRAY_EXPIRATION_DATE);

		softAssert.assertEquals(updateEmployeePage.getOCSprayPermitNumberData(),
				HRManagementConstants.OC_SPRAY_PERMIT_NUMBER);
		softAssert.assertEquals(updateEmployeePage.getOCSprayDateOfIssueData(),
				HRManagementConstants.OC_SPRAY_ISSUE_DATE);
		softAssert.assertEquals(updateEmployeePage.getOCSprayDateOfExpirationData(),
				HRManagementConstants.OC_SPRAY_EXPIRATION_DATE);

		updateEmployeePage.doClickAddOtherPermit();
		softAssert.assertTrue(updateEmployeePage.isOtherPermitTextDisplayed());
		updateEmployeePage.fillOtherPermitForm(HRManagementConstants.OTHER_PERMIT_NUMBER,
				HRManagementConstants.OTHER_PERMIT_ISSUE_DATE, HRManagementConstants.OTHER_PERMIT_EXPIRATION_DATE);

		softAssert.assertEquals(updateEmployeePage.getOtherPermitPermitNumberData(),
				HRManagementConstants.OTHER_PERMIT_NUMBER);
		softAssert.assertEquals(updateEmployeePage.getOtherPermitDateOfIssueData(),
				HRManagementConstants.OTHER_PERMIT_ISSUE_DATE);
		softAssert.assertEquals(updateEmployeePage.getOtherPermitDateOfExpirationData(),
				HRManagementConstants.OTHER_PERMIT_EXPIRATION_DATE);
		softAssert.assertEquals(updateEmployeePage.getOtherPermitSuccessMessageText(),
				HRManagementConstants.PERMIT_ADDED_SUCCESS_MESSAGE);

		// Pay Information
		updateEmployeePage.doClickPayInformationTab();
		updateEmployeePage.fillPayInformation(HRManagementConstants.EMPLOYEE_PAY_RATE, HRManagementConstants.PAY_CYCYLE,
				HRManagementConstants.ALLOWANCE_RATE, HRManagementConstants.ALLOWANCE_TYPE);
		updateEmployeePage.fillCommissionInfo(HRManagementConstants.COMMISSION_NAME,
				HRManagementConstants.COMMISSION_TYPE, HRManagementConstants.COMMISSION_RATE,
				HRManagementConstants.COMMISSION_CYCLE, HRManagementConstants.EFFECTIVE_DATE);

		softAssert.assertEquals(updateEmployeePage.getPayInformationSuccessMessageText(),
				HRManagementConstants.PAY_INFO_ADDED_SUCCESS_MESSAGE);

		// Upload Document
		Thread.sleep(2000);
		updateEmployeePage.doClickAdditionalDocumentsTab();
		updateEmployeePage.doClickAddAdditionalDocument();
		updateEmployeePage.fillAdditionalDocuments(HRManagementConstants.ADDITIONAL_DOCUMENT_NAME,
				HRManagementConstants.ADDITIONAL_DOCUMENT_DESCRIPTION);

		softAssert.assertEquals(updateEmployeePage.getFileNameData(), HRManagementConstants.ADDITIONAL_DOCUMENT_NAME);
		softAssert.assertEquals(updateEmployeePage.getDescriptionData(),
				HRManagementConstants.ADDITIONAL_DOCUMENT_DESCRIPTION);
		softAssert.assertTrue(updateEmployeePage.isThumbnailDisplayed());

		// Available Times
		updateEmployeePage.doClickAvailableTimesTab();
		softAssert.assertTrue(updateEmployeePage.isDaysTextDisplayed());
		softAssert.assertTrue(updateEmployeePage.isDayShiftTimeTextDisplayed());
		updateEmployeePage.fillAvailableTimes(HRManagementConstants.DAY_SHIFT_START_TIME,
				HRManagementConstants.DAY_SHIFT_END_TIME);
		softAssert.assertEquals(updateEmployeePage.getAvailableTimesSuccessMessageText(),
				HRManagementConstants.AVAILABLE_TIMES_SUCCESS_MESSAGE);

		// Access
//		editEmployeePage.doClickAccessTab();
//		editEmployeePage.fillModuleAccess();
//		softAssert.assertEquals(editEmployeePage.getAccessSuccessMessageText(),
//				HRManagementConstants.ACCESS_SUCCESS_MESSAGE);

		// References
		updateEmployeePage.doClickReferencesTab();
		updateEmployeePage.doClickAddUserReferenceButton();
		updateEmployeePage.fillUserReferences(HRManagementConstants.USER_REFERENCES_NAME,
				HRManagementConstants.USER_REFERENCES_RELATIONSHIP, HRManagementConstants.USER_REFERENCES_TITLE,
				HRManagementConstants.USER_REFERENCES_PHONE, HRManagementConstants.USER_REFERENCES_EMAIL);

		softAssert.assertEquals(updateEmployeePage.getUserReferenceNameData(),
				HRManagementConstants.USER_REFERENCES_NAME);
		softAssert.assertEquals(updateEmployeePage.getUserReferenceRelationshipData(),
				HRManagementConstants.USER_REFERENCES_RELATIONSHIP);
		softAssert.assertEquals(updateEmployeePage.getUserReferenceTitleData(),
				HRManagementConstants.USER_REFERENCES_TITLE);
		softAssert.assertEquals(
				NormalizePhoneNumber.normalizePhoneNumber(updateEmployeePage.getUserReferencePhoneData()),
				"+1" + HRManagementConstants.USER_REFERENCES_PHONE);
		softAssert.assertEquals(updateEmployeePage.getUserReferenceEmailData(),
				HRManagementConstants.USER_REFERENCES_EMAIL);

		softAssert.assertAll();
	}

}
