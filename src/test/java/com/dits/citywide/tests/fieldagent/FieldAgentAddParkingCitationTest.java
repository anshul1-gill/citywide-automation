package com.dits.citywide.tests.fieldagent;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.FieldAgentConstants;
import com.dits.citywide.constants.HRManagementConstants;

public class FieldAgentAddParkingCitationTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		fieldAgentStartShiftPage = loginPage.doLoginFieldAgent(prop.getProperty("employeeID"),
				prop.getProperty("employeePassword"));
	}

	@Test
	public void AddParkingCitationTestFieldAgentTest() throws InterruptedException {
		Thread.sleep(1000);
		fieldAgentStartShiftPage.handleMessageOfTheWeek();
		fieldAgentParkingCitationPage = fieldAgentStartShiftPage.clickOnParkingCitationFormLink();

		// parkingCitationPage.clickCreateNewParkingCitation();
		softAssert.assertTrue(fieldAgentParkingCitationPage.isClearButtonDisplayed(), "Clear Button is not visisble");
		fieldAgentParkingCitationPage.fillParkingCitationForm(FieldAgentConstants.SITE, FieldAgentConstants.DATE_TIME,
				FieldAgentConstants.ACTIVITY_CODE, FieldAgentConstants.VIN_NUMBER, FieldAgentConstants.LICENSE_NO,
				FieldAgentConstants.SELECT_STATE, FieldAgentConstants.EXPIRE_DATE, FieldAgentConstants.VEHICLE_COLOR,
				FieldAgentConstants.YEAR, FieldAgentConstants.VEHICLE_MAKE, FieldAgentConstants.VEHICLE_MODEL,
				FieldAgentConstants.VIOLATION, FieldAgentConstants.ADDITIONAL_DETAILS);
		softAssert.assertTrue(fieldAgentParkingCitationPage.isClearButtonDisplayed(), "Clear Button is not visisble");
		fieldAgentParkingCitationPage.clickOnImpoundedFields();
		softAssert.assertTrue(fieldAgentParkingCitationPage.isImpoundedFieldsDisplayed(),
				"Impounded Fields is not visisble");
		fieldAgentParkingCitationPage.fillImpoundedFields(FieldAgentConstants.IMPOUNDED_DATE_TIME,
				FieldAgentConstants.TOWING_COMPANY);
		fieldAgentParkingCitationPage.parkingCitationImagesUpload(FieldAgentConstants.FILE_PATH);
		fieldAgentParkingCitationPage.saveParkingCitation();
		Thread.sleep(10000);
		softAssert.assertTrue(fieldAgentParkingCitationPage.isSearchBoxDisplayed(), "Searchbox Not displayed");

		fieldAgentParkingCitationPage.searchParkingCitation(prop.getProperty("employeeID"));

		softAssert.assertTrue(fieldAgentParkingCitationPage.getOfficerName().contains(prop.getProperty("employeeID")));
		softAssert.assertTrue(fieldAgentParkingCitationPage.getSiteName().contains(HRManagementConstants.SITE));

		String incidentId = fieldAgentParkingCitationPage.getIncidentNumber();
		System.out.println(incidentId);
		driverFactory.updatePropertyValue("parkingcitationID", incidentId);

		softAssert.assertAll();
	}

}
