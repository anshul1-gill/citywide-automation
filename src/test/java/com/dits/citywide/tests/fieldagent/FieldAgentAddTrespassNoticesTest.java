package com.dits.citywide.tests.fieldagent;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.FieldAgentConstants;

public class FieldAgentAddTrespassNoticesTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		fieldAgentStartShiftPage = loginPage.doLoginFieldAgent(prop.getProperty("employeeID"),
				prop.getProperty("employeePassword"));
	}

	@Test
	public void AddTrespassNoticesTest() throws InterruptedException {
		Thread.sleep(1000);
		fieldAgentStartShiftPage.handleMessageOfTheWeek();
		fieldAgentTrespassNoticesPage = fieldAgentStartShiftPage.clickOnTrespassNoticesFormLink();

		fieldAgentTrespassNoticesPage.clickCreateNewTrespassNotice();
		softAssert.assertTrue(fieldAgentTrespassNoticesPage.isClearButtonDisplayed(), "Clear Button is not visisble");
		fieldAgentTrespassNoticesPage.fillLocationDetails(FieldAgentConstants.TRESPASS_SITE,
				FieldAgentConstants.TRESPASS_DATE_TIME, FieldAgentConstants.TRESPASS_ACTIVITY_CODE,
				FieldAgentConstants.TRESPASS_STREET_NUMBER, FieldAgentConstants.TRESPASS_STREET_NAME,
				FieldAgentConstants.TRESPASS_UNIT_NUMBER, FieldAgentConstants.TRESPASS_CITY,
				FieldAgentConstants.TRESPASS_STATE, FieldAgentConstants.TRESPASS_ZIP);

		fieldAgentTrespassNoticesPage.fillTrespasserDetails(FieldAgentConstants.TRESSPASS_FIRST_NAME,
				FieldAgentConstants.TRESPASS_MIDDLE_NAME, FieldAgentConstants.TRESPASS_LAST_NAME,
				FieldAgentConstants.TRESSPASSER_DL_NUMBER, FieldAgentConstants.TRESSPASSER_DL_STATE,
				FieldAgentConstants.TRESSPASSER_DL_EXPIRE_DATE, FieldAgentConstants.TRESSPASSER_STREET_NUMBER,
				FieldAgentConstants.TRESSPASSER_STREET_NAME, FieldAgentConstants.TRESSPASSER_UNIT_NUMBER,
				FieldAgentConstants.TRESSPASSER_CITY, FieldAgentConstants.TRESSPASSER_STATE,
				FieldAgentConstants.TRESSPASSER_ZIP, FieldAgentConstants.TRESSPASSER_VEHICLE_YEAR,
				FieldAgentConstants.TRESSPASSER_VEHICLE_MAKE, FieldAgentConstants.TRESSPASSER_VEHICLE_MODEL,
				FieldAgentConstants.TRESSPASSER_VEHICLE_COLOR, FieldAgentConstants.TRESSPASSER_VEHICLE_PLATE,
				FieldAgentConstants.TRESSPASSER_VEHICLE_STATE, FieldAgentConstants.TRESSPASSER_GENDER,
				FieldAgentConstants.TRESSPASS_RACE, FieldAgentConstants.TRESSPASS_HAIR_TYPE,
				FieldAgentConstants.TRESSPASS_HAIR_COLOR, FieldAgentConstants.TRESSPASS_EYE_COLOR,
				FieldAgentConstants.TRESSPASS_HEIGHT, FieldAgentConstants.TRESSPASS_BUILD,
				FieldAgentConstants.TRESSPASS_WEIGHT);

		fieldAgentTrespassNoticesPage.fillTrespassNarrative(FieldAgentConstants.TRESPASS_NARRATIVE,
				FieldAgentConstants.TRESPASS_WAS_PD_CONTACTED);

		// Upload Image
		fieldAgentTrespassNoticesPage.fillTrespassAdvisalImages(FieldAgentConstants.TRESPASS_FILE_PATH);

		fieldAgentTrespassNoticesPage.saveTrespassNotice();
		Thread.sleep(10000);
		softAssert.assertTrue(fieldAgentTrespassNoticesPage.isSearchBoxDisplayed(), "Searchbox Not displayed");

		fieldAgentTrespassNoticesPage.searchTrespassNotice(prop.getProperty("employeeID"));

		softAssert.assertTrue(fieldAgentTrespassNoticesPage.getOfficerName().contains(prop.getProperty("employeeID")));
		softAssert.assertTrue(fieldAgentTrespassNoticesPage.getSiteName().contains(prop.getProperty("site")));

		String incidentId = fieldAgentTrespassNoticesPage.getIncidentNumber();
		System.out.println(incidentId);
		driverFactory.updatePropertyValue("trespassNoticesID", incidentId);

		softAssert.assertAll();

	}

}