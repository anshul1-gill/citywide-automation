package com.dits.citywide.tests.formconversion;

import java.nio.file.Paths;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.FormConversion.ReactIncidentForm;
import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.FieldAgentConstants;
import com.dits.citywide.utilities.ElementUtils;

/**
 * ReactIncidentReportform — single comprehensive test.
 *
 * Flow:
 * 
 * @BeforeClass → login
 * @BeforeMethod → navigate to Incident Report list
 *               @Test(priority=1) → click Add New, fill ENTIRE form in one
 *               pass, save once
 * @AfterMethod → dismiss any open dialog (Escape)
 */
public class ReactIncidentReportform extends BaseTest {

        private ReactIncidentForm incidentReportPage;

        private static final String IMAGE_PATH = Paths.get(
                        System.getProperty("user.dir"),
                        FieldAgentConstants.INCIDENT_IMAGE_PATH.replace("./", ""))
                        .toAbsolutePath().toString();

        // ==================== SETUP ====================

        @BeforeClass
        public void setUpClass() {
                dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
                ElementUtils elementUtils = new ElementUtils(driver);
                incidentReportPage = new ReactIncidentForm(driver, elementUtils);
        }

        @BeforeMethod
        public void navigateBefore() {
                incidentReportPage.navigateToIncidentReport();
        }

        @AfterMethod
        public void dismissAnyOpenDialog() {
                try {
                        driver.findElement(By.tagName("body")).sendKeys(Keys.ESCAPE);
                } catch (Exception ignored) {
                }
        }

        // ==================== SINGLE TEST ====================

        @Test(priority = 1, description = "Add full incident report: police + fire + medic + victim + witness + suspect")
        public void testAddNewIncidentReport() {

                // Step 1 — Open the form
                incidentReportPage.clickAddNewIncidentReport();

                // Step 2 — Basic details
                incidentReportPage.fillBasicDetails(
                                FieldAgentConstants.SITE_NUMBER,
                                FieldAgentConstants.INCIDENT_DATE_TIME,
                                FieldAgentConstants.INCIDENT_ACTIVITY_CODE,
                                FieldAgentConstants.DISCOVER_DATE_TIME,
                                FieldAgentConstants.REPORTED_DATE_TIME);

                // Step 3 — Police response
                incidentReportPage.fillPoliceDetails(
                                FieldAgentConstants.POLICE_OFFICER_NAME,
                                FieldAgentConstants.POLICE_OFFICER_BADGE,
                                FieldAgentConstants.POLICE_UNIT,
                                FieldAgentConstants.POLICE_INCIDENT_NUMBER,
                                FieldAgentConstants.POLICE_ARRIVAL_TIME,
                                FieldAgentConstants.POLICE_DEPARTURE_TIME);

                // Step 4 — Fire response
                incidentReportPage.fillFireDetails(
                                FieldAgentConstants.FIRE_DEPARTMENT_NAME,
                                FieldAgentConstants.FIRE_ENGINE,
                                FieldAgentConstants.FIRE_INCIDENT_NUMBER,
                                FieldAgentConstants.FIRE_ARRIVAL_TIME,
                                FieldAgentConstants.FIRE_DEPARTURE_TIME);

                // Step 5 — Medic response
                incidentReportPage.fillMedicDetails(
                                FieldAgentConstants.MEDIC_TEAM_NAME,
                                FieldAgentConstants.MEDIC_UNIT,
                                FieldAgentConstants.MEDIC_INCIDENT_NUMBER,
                                FieldAgentConstants.MEDIC_ARRIVAL_TIME,
                                FieldAgentConstants.MEDIC_DEPARTURE_TIME);

                // Other Agency
                incidentReportPage.fillOtherAgencyDetails(
                                FieldAgentConstants.OTHER_AGENCY_NAME,
                                FieldAgentConstants.OTHER_CONTACT_PHONE,
                                FieldAgentConstants.OTHER_VEHICLE,
                                FieldAgentConstants.OTHER_ARRIVAL_TIME,
                                FieldAgentConstants.OTHER_DEPARTURE_TIME,
                                FieldAgentConstants.OTHER_INCIDENT_NUMBER);

                incidentReportPage.fillCommanderNotification(
                                FieldAgentConstants.COMMANDER_NOTIFIED,
                                FieldAgentConstants.Dispatcer,
                                FieldAgentConstants.OnSceneSupervisor);

                // Step 6 — Reporting person
                incidentReportPage.fillReportingPerson(
                                FieldAgentConstants.REPORTING_PERSON_NAME,
                                FieldAgentConstants.REPORTING_PERSON_DOB,
                                FieldAgentConstants.REPORTING_PERSON_PHONE,
                                FieldAgentConstants.REPORTING_PERSON_WORK_PHONE,
                                FieldAgentConstants.REPORTING_PERSON_STREET_NUM,
                                FieldAgentConstants.REPORTING_PERSON_STREET_NAME,
                                FieldAgentConstants.REPORTING_PERSON_UNIT,
                                FieldAgentConstants.REPORTING_PERSON_CITY,
                                FieldAgentConstants.REPORTING_PERSON_STATE,
                                FieldAgentConstants.REPORTING_PERSON_ZIP);

                // Step 7 — Victim
                incidentReportPage.addVictim(
                                FieldAgentConstants.VICTIM_NAME,
                                FieldAgentConstants.VICTIM_DOB,
                                FieldAgentConstants.VICTIM_PHONE

                );

                // Step 8 — Witness
                incidentReportPage.addWitness(
                                FieldAgentConstants.WITNESS_NAME,
                                FieldAgentConstants.WITNESS_DOB,
                                FieldAgentConstants.WITNESS_PHONE);

                // Step 9 — Suspect
                incidentReportPage.addSuspect(
                                FieldAgentConstants.SUSPECT_NAME,
                                FieldAgentConstants.SUSPECT_DOB,
                                FieldAgentConstants.SUSPECT_PHONE);

                // Step 10 — Classification
                incidentReportPage.fillClassification(
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

                // Step 11 — Client notification
                incidentReportPage.fillClientNotification(
                                FieldAgentConstants.CLIENT_NOTIFIED_DATE,
                                FieldAgentConstants.CLIENT_NOTIFIED_NAME);

                // Step 12 — Incident description
                incidentReportPage.fillIncidentDescription(
                                FieldAgentConstants.INCIDENT_DESCRIPTION);

                // Step 13 — Upload image
                incidentReportPage.uploadImage(IMAGE_PATH);

                // Step 14 — Save (single click)
                incidentReportPage.clickSave();

                // Step 15 — Assert success
                Assert.assertTrue(
                                incidentReportPage.isSuccessMessageDisplayed(),
                                "Success message should appear after saving the incident report");
                System.out.println("✅ PASSED: testAddNewIncidentReport");
        }
}
