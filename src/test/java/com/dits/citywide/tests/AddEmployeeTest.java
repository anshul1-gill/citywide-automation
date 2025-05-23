package com.dits.citywide.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.HRManagementConstants;
import com.dits.citywide.utilities.NormalizePhoneNumber;
import com.dits.citywide.utilities.RandomEmailGenerator;

public class AddEmployeeTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test
	public void addNewEmployeeTest() throws InterruptedException {

		dashboardPage.doClickHRManagement();
		Thread.sleep(6000);
		employeesPage = dashboardPage.doClickEmployees();

		addEmployeePage = employeesPage.doClickAddNewEmployee();

		// Image Upload
		softAssert.assertTrue(addEmployeePage.isUploadUserProfilePictureTextDisplayed());
		addEmployeePage.uploadProfileImage();
		softAssert.assertTrue(addEmployeePage.isImageUploadSuccessMessageDisplayed());

		softAssert.assertTrue(addEmployeePage.isPersonalInformationTextDisplayed());

		String primaryEmail = RandomEmailGenerator.generateRandomEmailForUser();
		driverFactory.updatePropertyValue("employeePrimaryEmail", primaryEmail);

		String secondaryEmail = RandomEmailGenerator.generateRandomEmailForUser();
		driverFactory.updatePropertyValue("employeeSecondaryEmail", secondaryEmail);

		// Personal Information
		addEmployeePage.fillPersonalInformation(HRManagementConstants.FIRST_NAME, HRManagementConstants.MIDDLE_NAME,
				HRManagementConstants.LAST_NAME, HRManagementConstants.GENDER, HRManagementConstants.BIRTH_MONTH,
				HRManagementConstants.BIRTH_YEAR, HRManagementConstants.BIRTH_DATE,
				HRManagementConstants.SOCIAL_SECURITY_NUMBER, HRManagementConstants.ROLE, HRManagementConstants.RANK,
				HRManagementConstants.ETHNIC_CODE, primaryEmail, secondaryEmail, HRManagementConstants.COUNTRY_CODE,
				HRManagementConstants.PRIMARY_PHONE_NUMBER, HRManagementConstants.ALTERNATE_PHONE_NUMBER,
				HRManagementConstants.EMERGENCY_NAME, HRManagementConstants.EMERGENCY_PHONE_NUMBER,
				HRManagementConstants.EMERGENCY_RELATIONSHIP, HRManagementConstants.PASSWORD,
				HRManagementConstants.CONFIRM_PASSWORD, HRManagementConstants.BRANCHES, HRManagementConstants.SITE);

		addEmployeePage.fillResidenceAddress(HRManagementConstants.RESIDENCE_ADDRESS_STREET_NAME,
				HRManagementConstants.RESIDENCE_ADDRESS_STREET, HRManagementConstants.RESIDENCE_ADDRESS_STE_NUMBER,
				HRManagementConstants.RESIDENCE_ADDRESS_CITY, HRManagementConstants.RESIDENCE_ADDRESS_STATE,
				HRManagementConstants.RESIDENCE_ADDRESS_ZIPCODE, HRManagementConstants.RESIDENCE_ADDRESS_COUNTRY);

		addEmployeePage.doClickSameAsAbove();
		addEmployeePage.personalInformationNotes(HRManagementConstants.PERSONAL_INFO_NOTES);
		addEmployeePage.doClickSaveButton();

		softAssert.assertEquals(addEmployeePage.getPersonalInfoSuccessMessageText(),
				HRManagementConstants.PERSONAL_INFO_ADDED_SUCCESS_MESSAGE);

		// Employment Information
		addEmployeePage.doClickEmploymentInformationTab();

		String employeeId = addEmployeePage.getEmployeeID();
		System.out.println(employeeId);
		driverFactory.updatePropertyValue("employeeID", employeeId);

		addEmployeePage.fillEmploymentInformation(HRManagementConstants.EMPLOYMENT_STATUS,
				HRManagementConstants.EMPLOYMENT_HIRE_MONTH, HRManagementConstants.EMPLOYMENT_HIRE_YEAR,
				HRManagementConstants.EMPLOYMENT_HIRE_DATE, HRManagementConstants.EMPLOYMENT_NOTES);

		addEmployeePage.fillClassCode(HRManagementConstants.CLASS_CODE);

		addEmployeePage.fillEmploymentType(HRManagementConstants.EMPLOYMENT_TYPE);

		addEmployeePage.fillDepartmentType(HRManagementConstants.DEPARTMENT_TYPE);
		addEmployeePage.doClickSaveButton();

		softAssert.assertEquals(addEmployeePage.getEmployeeInformationSuccessMessageText(),
				HRManagementConstants.EMPLOYEE_INFO_ADDED_SUCCESS_MESSAGE);

		// Permits
		addEmployeePage.doClickPermits();
		addEmployeePage.doClickAddLicenseDetailsButton();
		softAssert.assertTrue(addEmployeePage.isDriverLicenseTextDisplayed());
		addEmployeePage.fillDriverLicenseForm(HRManagementConstants.DRIVER_LICENSE_STATE,
				HRManagementConstants.DRIVER_LICENSE_NUMBER, HRManagementConstants.DRIVER_LICENSE_ISSUE_DATE,
				HRManagementConstants.DRIVER_LICENSE_EXPIRATION_DATE);

		softAssert.assertEquals(addEmployeePage.getPermitAddedSuccessMessageText(),
				HRManagementConstants.PERMIT_ADDED_SUCCESS_MESSAGE);

		softAssert.assertEquals(addEmployeePage.getDriverLicenseNumberData(),
				HRManagementConstants.DRIVER_LICENSE_NUMBER);
		softAssert.assertEquals(addEmployeePage.getDateOfIssueData(), HRManagementConstants.DRIVER_LICENSE_ISSUE_DATE);
		softAssert.assertEquals(addEmployeePage.getDateOfExpirationData(),
				HRManagementConstants.DRIVER_LICENSE_EXPIRATION_DATE);
		softAssert.assertEquals(addEmployeePage.getDriverLicenseStateData(),
				HRManagementConstants.DRIVER_LICENSE_STATE);

		addEmployeePage.doClickAddGuardCard();
		softAssert.assertTrue(addEmployeePage.isGuardCardTextDisplayed());
		addEmployeePage.fillGuardCardForm(HRManagementConstants.PERMIT_NUMBER,
				HRManagementConstants.GUARD_CARD_ISSUE_DATE, HRManagementConstants.GAURD_CARD_EXPIRATION_DATE);

		softAssert.assertEquals(addEmployeePage.getGuardCardSuccessMessageText(),
				HRManagementConstants.PERMIT_ADDED_SUCCESS_MESSAGE);

		addEmployeePage.doClickAddFirearmsQualification();
		softAssert.assertTrue(addEmployeePage.isFirearmsQualificationTextDisplayed());
		softAssert.assertEquals(addEmployeePage.getGuardCardPermitNumberData(), HRManagementConstants.PERMIT_NUMBER);
		softAssert.assertEquals(addEmployeePage.getGuardCardDateOfIssueData(),
				HRManagementConstants.GUARD_CARD_ISSUE_DATE);
		softAssert.assertEquals(addEmployeePage.getGuardCardDateOfExpirationData(),
				HRManagementConstants.GAURD_CARD_EXPIRATION_DATE);

		addEmployeePage.fillFirearmsQualification(HRManagementConstants.FIREARMS_PERMIT_NUMBER,
				HRManagementConstants.FIREARMS_ISSUE_DATE, HRManagementConstants.FIREARMS_EXPIRATION_DATE,
				HRManagementConstants.FIREARMS_CALIBER, HRManagementConstants.FIREARMS_SERIAL,
				HRManagementConstants.FIREARMS_MAKE, HRManagementConstants.FIREARMS_MODEL);

		softAssert.assertEquals(addEmployeePage.getFirearmsPermitNumberData(),
				HRManagementConstants.FIREARMS_PERMIT_NUMBER);
		softAssert.assertEquals(addEmployeePage.getFirearmsDateOfIssueData(),
				HRManagementConstants.FIREARMS_ISSUE_DATE);
		softAssert.assertEquals(addEmployeePage.getFirearmsDateOfExpirationData(),
				HRManagementConstants.FIREARMS_EXPIRATION_DATE);

		//
		addEmployeePage.doClickAddBaton();
		softAssert.assertTrue(addEmployeePage.isBatonTextDisplayed());
		addEmployeePage.fillBatonForm(HRManagementConstants.BATON_PERMIT_NUMBER, HRManagementConstants.BATON_ISSUE_DATE,
				HRManagementConstants.BATON_EXPIRATION_DATE);

		softAssert.assertEquals(addEmployeePage.getBatonPermitNumberData(), HRManagementConstants.BATON_PERMIT_NUMBER);
		softAssert.assertEquals(addEmployeePage.getBatonDateOfIssueData(), HRManagementConstants.BATON_ISSUE_DATE);
		softAssert.assertEquals(addEmployeePage.getBatonDateOfExpirationData(),
				HRManagementConstants.BATON_EXPIRATION_DATE);
		//
		addEmployeePage.doClickAddECD();
		softAssert.assertTrue(addEmployeePage.isECDTextDisplayed());
		addEmployeePage.fillECDForm(HRManagementConstants.ECD_PERMIT_NUMBER, HRManagementConstants.ECD_ISSUE_DATE,
				HRManagementConstants.ECD_EXPIRATION_DATE);

		softAssert.assertEquals(addEmployeePage.getBatonPermitNumberData(), HRManagementConstants.ECD_PERMIT_NUMBER);
		softAssert.assertEquals(addEmployeePage.getECDDateOfIssueData(), HRManagementConstants.ECD_ISSUE_DATE);
		softAssert.assertEquals(addEmployeePage.getECDDateOfExpirationData(),
				HRManagementConstants.ECD_EXPIRATION_DATE);

		Thread.sleep(2000);
		addEmployeePage.doClickAddOCSpray();
		softAssert.assertTrue(addEmployeePage.isOCSprayTextDisplayed());
		addEmployeePage.fillOCSprayForm(HRManagementConstants.OC_SPRAY_PERMIT_NUMBER,
				HRManagementConstants.OC_SPRAY_ISSUE_DATE, HRManagementConstants.OC_SPRAY_EXPIRATION_DATE);

		softAssert.assertEquals(addEmployeePage.getOCSprayPermitNumberData(),
				HRManagementConstants.OC_SPRAY_PERMIT_NUMBER);
		softAssert.assertEquals(addEmployeePage.getOCSprayDateOfIssueData(), HRManagementConstants.OC_SPRAY_ISSUE_DATE);
		softAssert.assertEquals(addEmployeePage.getOCSprayDateOfExpirationData(),
				HRManagementConstants.OC_SPRAY_EXPIRATION_DATE);

		
		addEmployeePage.doClickAddOtherPermit();
		softAssert.assertTrue(addEmployeePage.isOtherPermitTextDisplayed());
		addEmployeePage.fillOtherPermitForm(HRManagementConstants.OTHER_PERMIT_NUMBER,
				HRManagementConstants.OTHER_PERMIT_ISSUE_DATE, HRManagementConstants.OTHER_PERMIT_EXPIRATION_DATE);

		softAssert.assertEquals(addEmployeePage.getOtherPermitPermitNumberData(),
				HRManagementConstants.OTHER_PERMIT_NUMBER);
		softAssert.assertEquals(addEmployeePage.getOtherPermitDateOfIssueData(),
				HRManagementConstants.OTHER_PERMIT_ISSUE_DATE);
		softAssert.assertEquals(addEmployeePage.getOtherPermitDateOfExpirationData(),
				HRManagementConstants.OTHER_PERMIT_EXPIRATION_DATE);
		softAssert.assertEquals(addEmployeePage.getOtherPermitSuccessMessageText(),
				HRManagementConstants.PERMIT_ADDED_SUCCESS_MESSAGE);

		// Pay Information
		addEmployeePage.doClickPayInformationTab();
		addEmployeePage.fillPayInformation(HRManagementConstants.EMPLOYEE_PAY_RATE, HRManagementConstants.PAY_CYCYLE,
				HRManagementConstants.ALLOWANCE_RATE, HRManagementConstants.ALLOWANCE_TYPE);
		addEmployeePage.fillCommissionInfo(HRManagementConstants.COMMISSION_NAME, HRManagementConstants.COMMISSION_TYPE,
				HRManagementConstants.COMMISSION_RATE, HRManagementConstants.COMMISSION_CYCLE,
				HRManagementConstants.EFFECTIVE_DATE);

		softAssert.assertEquals(addEmployeePage.getPayInformationSuccessMessageText(),
				HRManagementConstants.PAY_INFO_ADDED_SUCCESS_MESSAGE);

		// Upload Document
		Thread.sleep(2000);
		addEmployeePage.doClickAdditionalDocumentsTab();
		addEmployeePage.doClickAddAdditionalDocument();
		addEmployeePage.fillAdditionalDocuments(HRManagementConstants.ADDITIONAL_DOCUMENT_NAME,
				HRManagementConstants.ADDITIONAL_DOCUMENT_DESCRIPTION);

		softAssert.assertEquals(addEmployeePage.getFileNameData(), HRManagementConstants.ADDITIONAL_DOCUMENT_NAME);
		softAssert.assertEquals(addEmployeePage.getDescriptionData(),
				HRManagementConstants.ADDITIONAL_DOCUMENT_DESCRIPTION);
		softAssert.assertTrue(addEmployeePage.isThumbnailDisplayed());

		// Available Times
		addEmployeePage.doClickAvailableTimesTab();
		softAssert.assertTrue(addEmployeePage.isDaysTextDisplayed());
		softAssert.assertTrue(addEmployeePage.isDayShiftTimeTextDisplayed());
		addEmployeePage.fillAvailableTimes(HRManagementConstants.DAY_SHIFT_START_TIME,
				HRManagementConstants.DAY_SHIFT_END_TIME);
		softAssert.assertEquals(addEmployeePage.getAvailableTimesSuccessMessageText(),
				HRManagementConstants.AVAILABLE_TIMES_SUCCESS_MESSAGE);

		// Access
//		addEmployeePage.doClickAccessTab();
//		addEmployeePage.fillModuleAccess();
//		softAssert.assertEquals(addEmployeePage.getAccessSuccessMessageText(),
//				HRManagementConstants.ACCESS_SUCCESS_MESSAGE);

		// References
		addEmployeePage.doClickReferencesTab();
		addEmployeePage.doClickAddUserReferenceButton();
		addEmployeePage.fillUserReferences(HRManagementConstants.USER_REFERENCES_NAME,
				HRManagementConstants.USER_REFERENCES_RELATIONSHIP, HRManagementConstants.USER_REFERENCES_TITLE,
				HRManagementConstants.USER_REFERENCES_PHONE, HRManagementConstants.USER_REFERENCES_EMAIL);

		softAssert.assertEquals(addEmployeePage.getUserReferenceNameData(), HRManagementConstants.USER_REFERENCES_NAME);
		softAssert.assertEquals(addEmployeePage.getUserReferenceRelationshipData(),
				HRManagementConstants.USER_REFERENCES_RELATIONSHIP);
		softAssert.assertEquals(addEmployeePage.getUserReferenceTitleData(),
				HRManagementConstants.USER_REFERENCES_TITLE);
		softAssert.assertEquals(NormalizePhoneNumber.normalizePhoneNumber(addEmployeePage.getUserReferencePhoneData()),
				"+1" + HRManagementConstants.USER_REFERENCES_PHONE);
		softAssert.assertEquals(addEmployeePage.getUserReferenceEmailData(),
				HRManagementConstants.USER_REFERENCES_EMAIL);

		softAssert.assertAll();
	}

}
