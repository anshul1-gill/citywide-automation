package com.dits.citywide.tests.patrol;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.FieldAgentConstants;

public class PatrolAgentAddFieldInterviewTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		patrolStartShiftPage = loginPage.doLoginPatrol(prop.getProperty("patrolID"), prop.getProperty("employeePassword"));
	}

	@Test
	public void AddFieldInterviewTest() throws InterruptedException {
		Thread.sleep(1000);
		patrolStartShiftPage.handleMessageOfTheWeek();
        patrolStartShiftPage.handlePassdownOfTheDay();
		fieldAgentFieldInterviewPage = patrolStartShiftPage.clickOnFieldInterviewFormLink();

		fieldAgentFieldInterviewPage.clickOnAddNew();
		softAssert.assertTrue(fieldAgentFieldInterviewPage.isClearButtonDisplayed(), "Clear Button is not visible");

		fieldAgentFieldInterviewPage.fillBasicDetails(
				FieldAgentConstants.FIELD_INTERVIEW_SITE_NUMBER,
				FieldAgentConstants.FIELD_INTERVIEW_INTERVIEW_DATE_TIME,
				FieldAgentConstants.FIELD_INTERVIEW_ACTIVITY_CODE,
				FieldAgentConstants.FIELD_INTERVIEW_LAST_NAME,
				FieldAgentConstants.FIELD_INTERVIEW_MIDDLE_NAME,
				FieldAgentConstants.FIELD_INTERVIEW_FIRST_NAME,
				FieldAgentConstants.FIELD_INTERVIEW_NICKNAME,
				FieldAgentConstants.FIELD_INTERVIEW_PHONE_NUMBER,
				FieldAgentConstants.FIELD_INTERVIEW_DL_ID_NUMBER,
				FieldAgentConstants.FIELD_INTERVIEW_DL_ID_STATE);

		fieldAgentFieldInterviewPage.fillAddressDetails(
				FieldAgentConstants.FIELD_INTERVIEW_ADDRESS_STREET_NUM,
				FieldAgentConstants.FIELD_INTERVIEW_ADDRESS_STREET_NAME,
				FieldAgentConstants.FIELD_INTERVIEW_ADDRESS_UNIT,
				FieldAgentConstants.FIELD_INTERVIEW_ADDRESS_CITY,
				FieldAgentConstants.FIELD_INTERVIEW_ADDRESS_STATE,
				FieldAgentConstants.FIELD_INTERVIEW_ADDRESS_ZIP);

		fieldAgentFieldInterviewPage.fillResidenceAddressDetails(
				FieldAgentConstants.FIELD_INTERVIEW_RESIDENCE_STREET_NUM,
				FieldAgentConstants.FIELD_INTERVIEW_RESIDENCE_STREET_NAME,
				FieldAgentConstants.FIELD_INTERVIEW_RESIDENCE_UNIT,
				FieldAgentConstants.FIELD_INTERVIEW_RESIDENCE_CITY,
				FieldAgentConstants.FIELD_INTERVIEW_RESIDENCE_STATE,
				FieldAgentConstants.FIELD_INTERVIEW_RESIDENCE_ZIP);

		fieldAgentFieldInterviewPage.fillPersonDetails(
				FieldAgentConstants.FIELD_INTERVIEW_PRSON_DESCRIPTION_PERSON_RACE,
				FieldAgentConstants.FIELD_INTERVIEW_PRSON_DESCRIPTION_PERSON_GENDER,
				FieldAgentConstants.FIELD_INTERVIEW_PRSON_DESCRIPTION_PERSON_HAIR_TYPE,
				FieldAgentConstants.FIELD_INTERVIEW_PRSON_DESCRIPTION_PERSON_HAIR,
				FieldAgentConstants.FIELD_INTERVIEW_PRSON_DESCRIPTION_PERSON_EYES,
				FieldAgentConstants.FIELD_INTERVIEW_PRSON_DESCRIPTION_PERSON_HEIGHT,
				FieldAgentConstants.FIELD_INTERVIEW_PRSON_DESCRIPTION_PERSON_BUILD,
				FieldAgentConstants.FIELD_INTERVIEW_PRSON_DESCRIPTION_PERSON_WEIGHT,
				FieldAgentConstants.FIELD_INTERVIEW_PRSON_DESCRIPTION_PERSON_DOB,
				FieldAgentConstants.FIELD_INTERVIEW_PRSON_DESCRIPTION_PERSON_ODDITIES,
				FieldAgentConstants.FIELD_INTERVIEW_PRSON_DESCRIPTION_PERSON_CLOTHING);

		fieldAgentFieldInterviewPage.fillVehicleDetails(
				FieldAgentConstants.FIELD_INTERVIEW_VEHICLE_DETAILS_VEHICLE_LICENSE_PLATE,
				FieldAgentConstants.FIELD_INTERVIEW_VEHICLE_DETAILS_VEHICLE_LICENSE_STATE,
				FieldAgentConstants.FIELD_INTERVIEW_VEHICLE_DETAILS_VEHICLE_YEAR,
				FieldAgentConstants.FIELD_INTERVIEW_VEHICLE_DETAILS_VEHICLE_MAKE,
				FieldAgentConstants.FIELD_INTERVIEW_VEHICLE_DETAILS_VEHICLE_MODEL,
				FieldAgentConstants.FIELD_INTERVIEW_VEHICLE_DETAILS_VEHICLE_COLOR,
				FieldAgentConstants.FIELD_INTERVIEW_VEHICLE_DETAILS_VEHICLE_COLOR,
				FieldAgentConstants.FIELD_INTERVIEW_VEHICLE_DETAILS_VEHICLE_TYPE);

		fieldAgentFieldInterviewPage.fillCompanionDetails(
				FieldAgentConstants.FIELD_INTERVIEW_COMPANION_NAME,
				FieldAgentConstants.FIELD_INTERVIEW_COMPANION_ADDRESS,
				FieldAgentConstants.FIELD_INTERVIEW_COMPANION_PHONE,
				FieldAgentConstants.FIELD_INTERVIEW_COMPANION_WORK_PHONE,
				FieldAgentConstants.FIELD_INTERVIEW_COMPANION_GENDER,
				FieldAgentConstants.FIELD_INTERVIEW_COMPANION_RACE,
				FieldAgentConstants.FIELD_INTERVIEW_COMPANION_HAIR_TYPE,
				FieldAgentConstants.FIELD_INTERVIEW_COMPANION_HAIR,
				FieldAgentConstants.FIELD_INTERVIEW_COMPANION_EYES,
				FieldAgentConstants.FIELD_INTERVIEW_COMPANION_HEIGHT,
				FieldAgentConstants.FIELD_INTERVIEW_COMPANION_BUILD,
				FieldAgentConstants.FIELD_INTERVIEW_COMPANION_WEIGHT);

		fieldAgentFieldInterviewPage.fillReportDescription(FieldAgentConstants.FIELD_INTERVIEW_REPORT_DESCRIPTION);

		fieldAgentFieldInterviewPage.fillCrimePotentials(
				FieldAgentConstants.FIELD_INTERVIEW_CRIME_POTENTIALS_CRIME_POTENTIAL_1,
				FieldAgentConstants.FIELD_INTERVIEW_CRIME_POTENTIALS_CRIME_POTENTIAL_2);

		fieldAgentFieldInterviewPage.fillTrespassAdvisalImages(FieldAgentConstants.FIELD_INTERVIEW_INTERVIEW_IMAGE_PATH);

		fieldAgentFieldInterviewPage.saveFieldInterview();

		softAssert.assertTrue(fieldAgentFieldInterviewPage.getOfficerName().contains(prop.getProperty("patrolID")), "Officer name should contain patrolID");
		softAssert.assertTrue(fieldAgentFieldInterviewPage.getSiteName().contains(FieldAgentConstants.FIELD_INTERVIEW_SITE_NUMBER), "Site name mismatch");

		String incidentId = fieldAgentFieldInterviewPage.getIncidentNumber();
		System.out.println(incidentId);
		driverFactory.updatePropertyValue("fieldInterviewID", incidentId);

		softAssert.assertAll();
	}
}
