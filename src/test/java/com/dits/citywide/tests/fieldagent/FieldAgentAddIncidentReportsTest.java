package com.dits.citywide.tests.fieldagent;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.FieldAgentConstants;

public class FieldAgentAddIncidentReportsTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		fieldAgentStartShiftPage = loginPage.doLoginFieldAgent(prop.getProperty("employeeID"),
				prop.getProperty("employeePassword"));
	}

	@Test
	public void AddIncidentReportTest() throws InterruptedException {
		// Navigate to Add Incident Report form
		Thread.sleep(1000);
		fieldAgentStartShiftPage.handleMessageOfTheWeek();
		fieldAgentIncidentReportsPage = fieldAgentStartShiftPage.clickOnIncidentReportFormLink();
		fieldAgentIncidentReportsPage.clickOnAddNewIncident();

		// Basic Info (Removed REPORT_NUMBER because method signature expects 5 params)
		fieldAgentIncidentReportsPage.fillBasicIncidentDetails(FieldAgentConstants.SITE_NUMBER,
				FieldAgentConstants.INCIDENT_DATE_TIME, FieldAgentConstants.INCIDENT_ACTIVITY_CODE,
				FieldAgentConstants.DISCOVER_DATE_TIME, FieldAgentConstants.REPORTED_DATE_TIME);

		// Police Department
		fieldAgentIncidentReportsPage.fillPoliceDepartmentDetails(FieldAgentConstants.POLICE_UNIT,
				FieldAgentConstants.POLICE_OFFICER_NAME, FieldAgentConstants.POLICE_OFFICER_BADGE,
				FieldAgentConstants.POLICE_ARRIVAL_TIME, FieldAgentConstants.POLICE_DEPARTURE_TIME,
				FieldAgentConstants.POLICE_INCIDENT_NUMBER);

		// Fire Department
		fieldAgentIncidentReportsPage.fillFireDepartmentDetails(FieldAgentConstants.FIRE_DEPARTMENT_NAME,
				FieldAgentConstants.FIRE_ENGINE, FieldAgentConstants.FIRE_ARRIVAL_TIME,
				FieldAgentConstants.FIRE_DEPARTURE_TIME, FieldAgentConstants.FIRE_INCIDENT_NUMBER);

		// Medic / Ambulance Department
		fieldAgentIncidentReportsPage.fillAmbulanceDepartmentDetails(FieldAgentConstants.MEDIC_TEAM_NAME,
				FieldAgentConstants.MEDIC_UNIT, FieldAgentConstants.MEDIC_ARRIVAL_TIME,
				FieldAgentConstants.MEDIC_DEPARTURE_TIME, FieldAgentConstants.MEDIC_INCIDENT_NUMBER);

		// Other Department
		fieldAgentIncidentReportsPage.fillOtherDepartmentDetails(FieldAgentConstants.OTHER_AGENCY_NAME,
				FieldAgentConstants.OTHER_CONTACT_PHONE, FieldAgentConstants.OTHER_VEHICLE,
				FieldAgentConstants.OTHER_ARRIVAL_TIME, FieldAgentConstants.OTHER_DEPARTURE_TIME,
				FieldAgentConstants.OTHER_INCIDENT_NUMBER);

		// Commander Notify (static fallback values – not provided in constants)
		fieldAgentIncidentReportsPage.fillCommanderNotifyDetails("123456", "Supervisor John");

		// Reporting Person
		fieldAgentIncidentReportsPage.fillReportingPersonDetails(FieldAgentConstants.REPORTING_PERSON_NAME,
				FieldAgentConstants.REPORTING_PERSON_DOB, FieldAgentConstants.REPORTING_PERSON_PHONE,
				FieldAgentConstants.REPORTING_PERSON_WORK_PHONE);

		// Reporting Person Address (split provided address into components)
		fieldAgentIncidentReportsPage.fillReportingPersonAddress("500", "Elm St",
				FieldAgentConstants.REPORTING_PERSON_UNIT, FieldAgentConstants.REPORTING_PERSON_CITY,
				FieldAgentConstants.REPORTING_PERSON_STATE, FieldAgentConstants.REPORTING_PERSON_ZIP);

		// Victim - 1 (no address/vehicle constants provided -> using static fallback
		// data)
		fieldAgentIncidentReportsPage.fillVictim1Details(FieldAgentConstants.VICTIM_NAME,
				FieldAgentConstants.VICTIM_DOB, FieldAgentConstants.VICTIM_PHONE, FieldAgentConstants.VICTIM_WORK_PHONE,
				FieldAgentConstants.VICTIM_GENDER, FieldAgentConstants.VICTIM_RACE,
				FieldAgentConstants.VICTIM_HAIR_TYPE, FieldAgentConstants.VICTIM_HAIR_COLOR,
				FieldAgentConstants.VICTIM_EYES, FieldAgentConstants.VICTIM_HEIGHT, FieldAgentConstants.VICTIM_BUILD,
				FieldAgentConstants.VICTIM_WEIGHT);
		fieldAgentIncidentReportsPage.fillVictim1Address("100", "U5", "Riverside", "CA", "92507");
		fieldAgentIncidentReportsPage.fillVictim1VehicleDetails("2022", "Toyota", "Camry", "Blue", "ABC123", "CA");

		// Witness - 1 (no address/vehicle constants provided -> using static fallback
		// data)
		fieldAgentIncidentReportsPage.fillWitness1Details(FieldAgentConstants.WITNESS_NAME,
				FieldAgentConstants.WITNESS_DOB, FieldAgentConstants.WITNESS_PHONE,
				FieldAgentConstants.WITNESS_WORK_PHONE, FieldAgentConstants.WITNESS_GENDER,
				FieldAgentConstants.WITNESS_RACE, FieldAgentConstants.WITNESS_HAIR_TYPE,
				FieldAgentConstants.WITNESS_HAIR_COLOR, FieldAgentConstants.WITNESS_EYES,
				FieldAgentConstants.WITNESS_HEIGHT, FieldAgentConstants.WITNESS_BUILD,
				FieldAgentConstants.WITNESS_WEIGHT);
		fieldAgentIncidentReportsPage.fillWitness1Address("200", "Pine St", "Unit 3", "Riverside", "CA", "92507");
		fieldAgentIncidentReportsPage.fillWitness1VehicleDetails("2021", "Honda", "Civic", "Gray", "XYZ789", "CA");

		// Suspect - 1 (no oddities constant -> passing empty string, address/vehicle
		// static fallback)
		fieldAgentIncidentReportsPage.fillSuspect1Details(FieldAgentConstants.SUSPECT_NAME,
				FieldAgentConstants.SUSPECT_DOB, FieldAgentConstants.SUSPECT_PHONE,
				FieldAgentConstants.SUSPECT_WORK_PHONE, FieldAgentConstants.SUSPECT_GENDER,
				FieldAgentConstants.SUSPECT_RACE, FieldAgentConstants.SUSPECT_HAIR_TYPE,
				FieldAgentConstants.SUSPECT_HAIR_COLOR, FieldAgentConstants.SUSPECT_EYES,
				FieldAgentConstants.SUSPECT_HEIGHT, FieldAgentConstants.SUSPECT_BUILD,
				FieldAgentConstants.SUSPECT_WEIGHT, "");
		fieldAgentIncidentReportsPage.fillSuspect1Address("300", "Maple Ave", "Apt 10", "Riverside", "CA", "92507");
		fieldAgentIncidentReportsPage.fillSuspect1VehicleDetails("2020", "Ford", "Focus", "Black", "LMN456", "CA");

		// Classification - only Property Damage (based on provided CLASSIFICATION
		// constant)
		fieldAgentIncidentReportsPage.fillClassificationAndDisposition(false, false, true, false, false, false, false,
				false, false, false, false, false);

		// Client Notified
		fieldAgentIncidentReportsPage.fillClientNotifiedDetails(FieldAgentConstants.CLIENT_NOTIFIED_DATE,
				FieldAgentConstants.CLIENT_NOTIFIED_NAME);

		// Incident Description
		fieldAgentIncidentReportsPage.fillIncidentDescription(FieldAgentConstants.INCIDENT_DESCRIPTION);

		// Upload Image
		fieldAgentIncidentReportsPage.uploadIncidentReportImage(FieldAgentConstants.INCIDENT_IMAGE_PATH);

		// Save
		fieldAgentIncidentReportsPage.clickOnSaveIncidentReport();

		softAssert.assertAll();
	}

}