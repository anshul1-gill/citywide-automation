package com.dits.citywide.tests.patrol;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.FieldAgentConstants;

public class PatrolAgentUpdateIncidentReportsTest extends BaseTest {

    // Declare the page object as in the AddIncidentReportsTest
    private com.dits.citywide.pages.fieldagent.FieldAgentIncidentReportsPage fieldAgentIncidentReportsPage;

    @BeforeMethod
    public void performLogin() throws InterruptedException {
        patrolStartShiftPage = loginPage.doLoginPatrol(prop.getProperty("patrolID"),
                prop.getProperty("employeePassword"));
    }

    @Test
    public void UpdateIncidentReportTest() throws InterruptedException {
        // Navigate to Incident Reports page
        Thread.sleep(1000);
        patrolStartShiftPage.handleMessageOfTheWeek();
        fieldAgentIncidentReportsPage = patrolStartShiftPage.clickOnIncidentReportFormLink();

        fieldAgentIncidentReportsPage.clickOnEditIncidentReport(prop.getProperty("incidentReportID"));

        fieldAgentIncidentReportsPage.updateBasicIncidentDetails(FieldAgentConstants.UPDATE_SITE_NUMBER,
                FieldAgentConstants.UPDATE_INCIDENT_DATE_TIME, FieldAgentConstants.UPDATE_INCIDENT_ACTIVITY_CODE,
                FieldAgentConstants.UPDATE_DISCOVER_DATE_TIME, FieldAgentConstants.UPDATE_REPORTED_DATE_TIME);

        fieldAgentIncidentReportsPage.updatePoliceDepartmentDetails(FieldAgentConstants.UPDATE_POLICE_UNIT,
                FieldAgentConstants.UPDATE_POLICE_OFFICER_NAME, FieldAgentConstants.UPDATE_POLICE_OFFICER_BADGE,
                FieldAgentConstants.UPDATE_POLICE_ARRIVAL_TIME, FieldAgentConstants.UPDATE_POLICE_DEPARTURE_TIME,
                FieldAgentConstants.UPDATE_POLICE_INCIDENT_NUMBER);

        fieldAgentIncidentReportsPage.updateFireDepartmentDetails(FieldAgentConstants.UPDATE_FIRE_DEPARTMENT_NAME,
                FieldAgentConstants.UPDATE_FIRE_ENGINE, FieldAgentConstants.UPDATE_FIRE_ARRIVAL_TIME,
                FieldAgentConstants.UPDATE_FIRE_DEPARTURE_TIME, FieldAgentConstants.UPDATE_FIRE_INCIDENT_NUMBER);

        fieldAgentIncidentReportsPage.updateAmbulanceDepartmentDetails(FieldAgentConstants.UPDATE_MEDIC_TEAM_NAME,
                FieldAgentConstants.UPDATE_MEDIC_UNIT, FieldAgentConstants.UPDATE_MEDIC_ARRIVAL_TIME,
                FieldAgentConstants.UPDATE_MEDIC_DEPARTURE_TIME, FieldAgentConstants.UPDATE_MEDIC_INCIDENT_NUMBER);

        fieldAgentIncidentReportsPage.updateOtherDepartmentDetails(FieldAgentConstants.UPDATE_OTHER_AGENCY_NAME,
                FieldAgentConstants.UPDATE_OTHER_CONTACT_PHONE, FieldAgentConstants.UPDATE_OTHER_VEHICLE,
                FieldAgentConstants.UPDATE_OTHER_ARRIVAL_TIME, FieldAgentConstants.UPDATE_OTHER_DEPARTURE_TIME,
                FieldAgentConstants.UPDATE_OTHER_INCIDENT_NUMBER);

        fieldAgentIncidentReportsPage.updateReportingPersonDetails(FieldAgentConstants.UPDATE_REPORTING_PERSON_NAME,
                FieldAgentConstants.UPDATE_REPORTING_PERSON_DOB, FieldAgentConstants.UPDATE_REPORTING_PERSON_PHONE,
                FieldAgentConstants.UPDATE_REPORTING_PERSON_WORK_PHONE);

        fieldAgentIncidentReportsPage.updateReportingPersonAddress(
                FieldAgentConstants.UPDATE_REPORTING_PERSON_STREET_NUM,
                FieldAgentConstants.UPDATE_REPORTING_PERSON_STREET_NAME,
                FieldAgentConstants.UPDATE_REPORTING_PERSON_UNIT, FieldAgentConstants.UPDATE_REPORTING_PERSON_CITY,
                FieldAgentConstants.UPDATE_REPORTING_PERSON_STATE, FieldAgentConstants.UPDATE_REPORTING_PERSON_ZIP);

        fieldAgentIncidentReportsPage.updateVictim1Details(FieldAgentConstants.UPDATE_VICTIM_NAME,
                FieldAgentConstants.UPDATE_VICTIM_DOB, FieldAgentConstants.UPDATE_VICTIM_PHONE,
                FieldAgentConstants.UPDATE_VICTIM_WORK_PHONE, FieldAgentConstants.UPDATE_VICTIM_GENDER,
                FieldAgentConstants.UPDATE_VICTIM_RACE, FieldAgentConstants.UPDATE_VICTIM_HAIR_TYPE,
                FieldAgentConstants.UPDATE_VICTIM_HAIR_COLOR, FieldAgentConstants.UPDATE_VICTIM_EYES,
                FieldAgentConstants.UPDATE_VICTIM_HEIGHT, FieldAgentConstants.UPDATE_VICTIM_BUILD,
                FieldAgentConstants.UPDATE_VICTIM_WEIGHT);

        fieldAgentIncidentReportsPage.updateVictim1Address(FieldAgentConstants.UPDATE_VICTIM_STREET_NUM,
                FieldAgentConstants.UPDATE_VICTIM_STREET_NAME, FieldAgentConstants.UPDATE_VICTIM_UNIT,
                FieldAgentConstants.UPDATE_VICTIM_CITY, FieldAgentConstants.UPDATE_VICTIM_STATE,
                FieldAgentConstants.UPDATE_VICTIM_ZIP);

        fieldAgentIncidentReportsPage.updateVictim1VehicleDetails(FieldAgentConstants.UPDATE_VICTIM_VEHICLE_YEAR,
                FieldAgentConstants.UPDATE_VICTIM_VEHICLE_MAKE, FieldAgentConstants.UPDATE_VICTIM_VEHICLE_MODEL,
                FieldAgentConstants.UPDATE_VICTIM_VEHICLE_COLOR, FieldAgentConstants.UPDATE_VICTIM_VEHICLE_LICENSE,
                FieldAgentConstants.UPDATE_VICTIM_VEHICLE_STATE);

        fieldAgentIncidentReportsPage.updateWitness1Details(FieldAgentConstants.UPDATE_WITNESS_NAME,
                FieldAgentConstants.UPDATE_WITNESS_DOB, FieldAgentConstants.UPDATE_WITNESS_PHONE,
                FieldAgentConstants.UPDATE_WITNESS_WORK_PHONE, FieldAgentConstants.UPDATE_WITNESS_GENDER,
                FieldAgentConstants.UPDATE_WITNESS_RACE, FieldAgentConstants.UPDATE_WITNESS_HAIR_TYPE,
                FieldAgentConstants.UPDATE_WITNESS_HAIR_COLOR, FieldAgentConstants.UPDATE_WITNESS_EYES,
                FieldAgentConstants.UPDATE_WITNESS_HEIGHT, FieldAgentConstants.UPDATE_WITNESS_BUILD,
                FieldAgentConstants.UPDATE_WITNESS_WEIGHT);

        fieldAgentIncidentReportsPage.updateWitness1Address(FieldAgentConstants.UPDATE_WITNESS_STREET_NUM,
                FieldAgentConstants.UPDATE_WITNESS_STREET_NAME, FieldAgentConstants.UPDATE_WITNESS_UNIT,
                FieldAgentConstants.UPDATE_WITNESS_CITY, FieldAgentConstants.UPDATE_WITNESS_STATE,
                FieldAgentConstants.UPDATE_WITNESS_ZIP);

        fieldAgentIncidentReportsPage.updateWitness1VehicleDetails(FieldAgentConstants.UPDATE_WITNESS_VEHICLE_YEAR,
                FieldAgentConstants.UPDATE_WITNESS_VEHICLE_MAKE, FieldAgentConstants.UPDATE_WITNESS_VEHICLE_MODEL,
                FieldAgentConstants.UPDATE_WITNESS_VEHICLE_COLOR, FieldAgentConstants.UPDATE_WITNESS_VEHICLE_LICENSE,
                FieldAgentConstants.UPDATE_WITNESS_VEHICLE_STATE);

        fieldAgentIncidentReportsPage.updateSuspect1Details(FieldAgentConstants.UPDATE_SUSPECT_NAME,
                FieldAgentConstants.UPDATE_SUSPECT_DOB, FieldAgentConstants.UPDATE_SUSPECT_PHONE,
                FieldAgentConstants.UPDATE_SUSPECT_WORK_PHONE, FieldAgentConstants.UPDATE_SUSPECT_GENDER,
                FieldAgentConstants.UPDATE_SUSPECT_RACE, FieldAgentConstants.UPDATE_SUSPECT_HAIR_TYPE,
                FieldAgentConstants.UPDATE_SUSPECT_HAIR_COLOR, FieldAgentConstants.UPDATE_SUSPECT_EYES,
                FieldAgentConstants.UPDATE_SUSPECT_HEIGHT, FieldAgentConstants.UPDATE_SUSPECT_BUILD,
                FieldAgentConstants.UPDATE_SUSPECT_WEIGHT);

        fieldAgentIncidentReportsPage.updateSuspect1Address(FieldAgentConstants.UPDATE_SUSPECT_STREET_NUM,
                FieldAgentConstants.UPDATE_SUSPECT_STREET_NAME, FieldAgentConstants.UPDATE_SUSPECT_UNIT,
                FieldAgentConstants.UPDATE_SUSPECT_CITY, FieldAgentConstants.UPDATE_SUSPECT_STATE,
                FieldAgentConstants.UPDATE_SUSPECT_ZIP);

        fieldAgentIncidentReportsPage.updateSuspect1VehicleDetails(FieldAgentConstants.UPDATE_SUSPECT_VEHICLE_YEAR,
                FieldAgentConstants.UPDATE_SUSPECT_VEHICLE_MAKE, FieldAgentConstants.UPDATE_SUSPECT_VEHICLE_MODEL,
                FieldAgentConstants.UPDATE_SUSPECT_VEHICLE_COLOR, FieldAgentConstants.UPDATE_SUSPECT_VEHICLE_LICENSE,
                FieldAgentConstants.UPDATE_SUSPECT_VEHICLE_STATE);

        fieldAgentIncidentReportsPage.updateClassificationAndDisposition(FieldAgentConstants.UPDATE_EQUIPMENT_FAILURE,
                FieldAgentConstants.UPDATE_SAFETY_HAZARD, FieldAgentConstants.UPDATE_PROPERTY_DAMAGE,
                FieldAgentConstants.UPDATE_PERSONAL_INJURY, FieldAgentConstants.UPDATE_CONDUCT,
                FieldAgentConstants.UPDATE_CRIMINAL_ACT, FieldAgentConstants.UPDATE_MISSING_PERSON,
                FieldAgentConstants.UPDATE_DEATH, FieldAgentConstants.UPDATE_MAINTENANCE_ISSUE,
                FieldAgentConstants.UPDATE_ALARM, FieldAgentConstants.UPDATE_FLOOD,
                FieldAgentConstants.UPDATE_TRAINING);

        fieldAgentIncidentReportsPage.updateClientNotifiedDetails(FieldAgentConstants.UPDATE_CLIENT_NOTIFIED_DATE,
                FieldAgentConstants.UPDATE_CLIENT_NOTIFIED_NAME);

        fieldAgentIncidentReportsPage.updateIncidentDescription(FieldAgentConstants.UPDATE_INCIDENT_DESCRIPTION);

        fieldAgentIncidentReportsPage.deleteImageIfExists();
        softAssert.assertEquals(fieldAgentIncidentReportsPage.isSuccessMessageDisplayed(),
                "Record deleted successfully.", "Existing image was not deleted.");
        fieldAgentIncidentReportsPage.updateIncidentReportImage(FieldAgentConstants.UPDATE_INCIDENT_IMAGE_PATH);

        fieldAgentIncidentReportsPage.clickOnUpdateIncidentReport();

        softAssert.assertTrue(fieldAgentIncidentReportsPage.isAddNewIncidentButtonDisplayed(),
                "Add New Incident button is not displayed after saving the incident report.");
        softAssert.assertTrue(fieldAgentIncidentReportsPage.getSiteData().contains(FieldAgentConstants.SITE_NUMBER),
                "Saved incident report not found in the incident reports list.");

        softAssert.assertAll();
    }
}