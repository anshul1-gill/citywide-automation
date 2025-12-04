package com.dits.citywide.tests.patrol;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.FieldAgentConstants;

public class PatrolAgentAddIncidentReportsTest extends BaseTest {

    @BeforeMethod
    public void performLogin() throws InterruptedException {
        patrolStartShiftPage = loginPage.doLoginPatrol(prop.getProperty("patrolID"), prop.getProperty("employeePassword"));
    }

    @Test
    public void AddIncidentReportTest() throws InterruptedException {
        Thread.sleep(1000);
        patrolStartShiftPage.handleMessageOfTheWeek();
        patrolStartShiftPage.handlePassdownOfTheDay();
        fieldAgentIncidentReportsPage = patrolStartShiftPage.clickOnIncidentReportFormLink();
        fieldAgentIncidentReportsPage.clickOnAddNewIncident();

        fieldAgentIncidentReportsPage.fillBasicIncidentDetails(
                FieldAgentConstants.SITE_NUMBER,
                FieldAgentConstants.INCIDENT_DATE_TIME,
                FieldAgentConstants.INCIDENT_ACTIVITY_CODE,
                FieldAgentConstants.DISCOVER_DATE_TIME,
                FieldAgentConstants.REPORTED_DATE_TIME);

        fieldAgentIncidentReportsPage.fillPoliceDepartmentDetails(
                FieldAgentConstants.POLICE_UNIT,
                FieldAgentConstants.POLICE_OFFICER_NAME,
                FieldAgentConstants.POLICE_OFFICER_BADGE,
                FieldAgentConstants.POLICE_ARRIVAL_TIME,
                FieldAgentConstants.POLICE_DEPARTURE_TIME,
                FieldAgentConstants.POLICE_INCIDENT_NUMBER);

        fieldAgentIncidentReportsPage.fillFireDepartmentDetails(
                FieldAgentConstants.FIRE_DEPARTMENT_NAME,
                FieldAgentConstants.FIRE_ENGINE,
                FieldAgentConstants.FIRE_ARRIVAL_TIME,
                FieldAgentConstants.FIRE_DEPARTURE_TIME,
                FieldAgentConstants.FIRE_INCIDENT_NUMBER);

        fieldAgentIncidentReportsPage.fillAmbulanceDepartmentDetails(
                FieldAgentConstants.MEDIC_TEAM_NAME,
                FieldAgentConstants.MEDIC_UNIT,
                FieldAgentConstants.MEDIC_ARRIVAL_TIME,
                FieldAgentConstants.MEDIC_DEPARTURE_TIME,
                FieldAgentConstants.MEDIC_INCIDENT_NUMBER);

        fieldAgentIncidentReportsPage.fillOtherDepartmentDetails(
                FieldAgentConstants.OTHER_AGENCY_NAME,
                FieldAgentConstants.OTHER_CONTACT_PHONE,
                FieldAgentConstants.OTHER_VEHICLE,
                FieldAgentConstants.OTHER_ARRIVAL_TIME,
                FieldAgentConstants.OTHER_DEPARTURE_TIME,
                FieldAgentConstants.OTHER_INCIDENT_NUMBER);

        fieldAgentIncidentReportsPage.fillCommanderNotifyDetails("123456", "Supervisor John");

        fieldAgentIncidentReportsPage.fillReportingPersonDetails(
                FieldAgentConstants.REPORTING_PERSON_NAME,
                FieldAgentConstants.REPORTING_PERSON_DOB,
                FieldAgentConstants.REPORTING_PERSON_PHONE,
                FieldAgentConstants.REPORTING_PERSON_WORK_PHONE);

        fieldAgentIncidentReportsPage.fillReportingPersonAddress(
                FieldAgentConstants.REPORTING_PERSON_STREET_NUM,
                FieldAgentConstants.REPORTING_PERSON_STREET_NAME,
                FieldAgentConstants.REPORTING_PERSON_UNIT,
                FieldAgentConstants.REPORTING_PERSON_CITY,
                FieldAgentConstants.REPORTING_PERSON_STATE,
                FieldAgentConstants.REPORTING_PERSON_ZIP);

        fieldAgentIncidentReportsPage.fillVictim1Details(
                FieldAgentConstants.VICTIM_NAME,
                FieldAgentConstants.VICTIM_DOB,
                FieldAgentConstants.VICTIM_PHONE,
                FieldAgentConstants.VICTIM_WORK_PHONE,
                FieldAgentConstants.VICTIM_GENDER,
                FieldAgentConstants.VICTIM_RACE,
                FieldAgentConstants.VICTIM_HAIR_TYPE,
                FieldAgentConstants.VICTIM_HAIR_COLOR,
                FieldAgentConstants.VICTIM_EYES,
                FieldAgentConstants.VICTIM_HEIGHT,
                FieldAgentConstants.VICTIM_BUILD,
                FieldAgentConstants.VICTIM_WEIGHT);

        fieldAgentIncidentReportsPage.fillVictim1Address(
                FieldAgentConstants.VICTIM_STREET_NUM,
                FieldAgentConstants.VICTIM_STREET_NAME,
                FieldAgentConstants.VICTIM_UNIT,
                FieldAgentConstants.VICTIM_CITY,
                FieldAgentConstants.VICTIM_STATE,
                FieldAgentConstants.VICTIM_ZIP);

        fieldAgentIncidentReportsPage.fillVictim1VehicleDetails(
                FieldAgentConstants.VICTIM_VEHICLE_YEAR,
                FieldAgentConstants.VICTIM_VEHICLE_MAKE,
                FieldAgentConstants.VICTIM_VEHICLE_MODEL,
                FieldAgentConstants.VICTIM_VEHICLE_COLOR,
                FieldAgentConstants.VICTIM_VEHICLE_LICENSE,
                FieldAgentConstants.VICTIM_VEHICLE_STATE);

        fieldAgentIncidentReportsPage.fillWitness1Details(
                FieldAgentConstants.WITNESS_NAME,
                FieldAgentConstants.WITNESS_DOB,
                FieldAgentConstants.WITNESS_PHONE,
                FieldAgentConstants.WITNESS_WORK_PHONE,
                FieldAgentConstants.WITNESS_GENDER,
                FieldAgentConstants.WITNESS_RACE,
                FieldAgentConstants.WITNESS_HAIR_TYPE,
                FieldAgentConstants.WITNESS_HAIR_COLOR,
                FieldAgentConstants.WITNESS_EYES,
                FieldAgentConstants.WITNESS_HEIGHT,
                FieldAgentConstants.WITNESS_BUILD,
                FieldAgentConstants.WITNESS_WEIGHT);

        fieldAgentIncidentReportsPage.fillWitness1Address(
                FieldAgentConstants.WITNESS_STREET_NUM,
                FieldAgentConstants.WITNESS_STREET_NAME,
                FieldAgentConstants.WITNESS_UNIT,
                FieldAgentConstants.WITNESS_CITY,
                FieldAgentConstants.WITNESS_STATE,
                FieldAgentConstants.WITNESS_ZIP);

        fieldAgentIncidentReportsPage.fillWitness1VehicleDetails(
                FieldAgentConstants.WITNESS_VEHICLE_YEAR,
                FieldAgentConstants.WITNESS_VEHICLE_MAKE,
                FieldAgentConstants.WITNESS_VEHICLE_MODEL,
                FieldAgentConstants.WITNESS_VEHICLE_COLOR,
                FieldAgentConstants.WITNESS_VEHICLE_LICENSE,
                FieldAgentConstants.WITNESS_VEHICLE_STATE);

        fieldAgentIncidentReportsPage.fillSuspect1Details(
                FieldAgentConstants.SUSPECT_NAME,
                FieldAgentConstants.SUSPECT_DOB,
                FieldAgentConstants.SUSPECT_PHONE,
                FieldAgentConstants.SUSPECT_WORK_PHONE,
                FieldAgentConstants.SUSPECT_GENDER,
                FieldAgentConstants.SUSPECT_RACE,
                FieldAgentConstants.SUSPECT_HAIR_TYPE,
                FieldAgentConstants.SUSPECT_HAIR_COLOR,
                FieldAgentConstants.SUSPECT_EYES,
                FieldAgentConstants.SUSPECT_HEIGHT,
                FieldAgentConstants.SUSPECT_BUILD,
                FieldAgentConstants.SUSPECT_WEIGHT);

        fieldAgentIncidentReportsPage.fillSuspect1Address(
                FieldAgentConstants.SUSPECT_STREET_NUM,
                FieldAgentConstants.SUSPECT_STREET_NAME,
                FieldAgentConstants.SUSPECT_UNIT,
                FieldAgentConstants.SUSPECT_CITY,
                FieldAgentConstants.SUSPECT_STATE,
                FieldAgentConstants.SUSPECT_ZIP);

        fieldAgentIncidentReportsPage.fillSuspect1VehicleDetails(
                FieldAgentConstants.SUSPECT_VEHICLE_YEAR,
                FieldAgentConstants.SUSPECT_VEHICLE_MAKE,
                FieldAgentConstants.SUSPECT_VEHICLE_MODEL,
                FieldAgentConstants.SUSPECT_VEHICLE_COLOR,
                FieldAgentConstants.SUSPECT_VEHICLE_LICENSE,
                FieldAgentConstants.SUSPECT_VEHICLE_STATE);

        fieldAgentIncidentReportsPage.fillClassificationAndDisposition(
                FieldAgentConstants.EQUIPMENT_FAILURE,
                FieldAgentConstants.SAFETY_HAZARD,
                FieldAgentConstants.PROPERTY_DAMAGE,
                FieldAgentConstants.PERSONAL_INJURY,
                FieldAgentConstants.CONDUCT,
                FieldAgentConstants.CRIMINAL_ACT,
                FieldAgentConstants.MISSING_PERSON,
                FieldAgentConstants.DEATH,
                FieldAgentConstants.MAINTENANCE_ISSUE,
                FieldAgentConstants.ALARM,
                FieldAgentConstants.FLOOD,
                FieldAgentConstants.TRAINING);

        fieldAgentIncidentReportsPage.fillClientNotifiedDetails(
                FieldAgentConstants.CLIENT_NOTIFIED_DATE,
                FieldAgentConstants.CLIENT_NOTIFIED_NAME);

        fieldAgentIncidentReportsPage.fillIncidentDescription(FieldAgentConstants.INCIDENT_DESCRIPTION);
        fieldAgentIncidentReportsPage.uploadIncidentReportImage(FieldAgentConstants.INCIDENT_IMAGE_PATH);
        fieldAgentIncidentReportsPage.clickOnSaveIncidentReport();

        softAssert.assertTrue(fieldAgentIncidentReportsPage.isAddNewIncidentButtonDisplayed(), "Add New Incident button should be displayed after save");
        softAssert.assertTrue(fieldAgentIncidentReportsPage.getSiteData().contains(FieldAgentConstants.SITE_NUMBER), "Site name mismatch in saved incident report");

        String incidentId = fieldAgentIncidentReportsPage.getIncidentID();
        System.out.println(incidentId);
        driverFactory.updatePropertyValue("incidentReportID", incidentId);

        softAssert.assertAll();
    }
}
