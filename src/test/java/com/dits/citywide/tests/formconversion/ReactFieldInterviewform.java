package com.dits.citywide.tests.formconversion;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.FormConversion.ReactFieldInterview;
import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.FieldAgentConstants;
import com.dits.citywide.utilities.ElementUtils;

/**
 * Test class for React Field Interview form
 * Tests include: Adding Field Interviews and Verification
 */
public class ReactFieldInterviewform extends BaseTest {

        private ReactFieldInterview fieldInterviewPage;
        private ElementUtils elementUtils;

        @BeforeClass
        public void setUpClass() {
                // Login once (BaseTest already initialized driver in @BeforeClass)
                dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));

                // Initialize page objects once
                elementUtils = new ElementUtils(driver);
                fieldInterviewPage = new ReactFieldInterview(driver, elementUtils);

                System.out.println("✅ Login successful and page objects initialized");
        }

        @BeforeMethod
        public void setUp() {
                // Navigate to Field Interview page before each test
                fieldInterviewPage.navigateToFieldInterview();
        }

        /**
         * Test 1: Add a new field interview with all required fields
         */
        @Test(priority = 1, description = "Add a new field interview with complete details")
        public void testAddNewFieldInterview() {
                System.out.println("🧪 TEST: Add New Field Interview");

                // Click Add New Field Interview button
                fieldInterviewPage.clickAddNewFieldInterview();

                // Fill incident details
                fieldInterviewPage.fillIncidentDetails(
                                FieldAgentConstants.FIELD_INTERVIEW_SITE_NUMBER, // site
                                null, // call (optional)
                                null, // incidentReport (optional)
                                FieldAgentConstants.FIELD_INTERVIEW_INTERVIEW_DATE_TIME // interviewDateTime
                );

                // Fill person information
                fieldInterviewPage.fillPersonInfo(
                                FieldAgentConstants.FIELD_INTERVIEW_LAST_NAME, // lastName
                                FieldAgentConstants.FIELD_INTERVIEW_MIDDLE_NAME, // middleName
                                FieldAgentConstants.FIELD_INTERVIEW_FIRST_NAME, // firstName
                                null, // nickname (field doesn't exist on form)
                                FieldAgentConstants.FIELD_INTERVIEW_PHONE_NUMBER, // phone
                                FieldAgentConstants.FIELD_INTERVIEW_DL_ID_NUMBER, // dlNumber
                                FieldAgentConstants.FIELD_INTERVIEW_DL_ID_STATE // dlState
                );

                // Fill interview address
                fieldInterviewPage.fillInterviewAddress(
                                FieldAgentConstants.FIELD_INTERVIEW_ADDRESS_STREET_NUM, // streetNum
                                FieldAgentConstants.FIELD_INTERVIEW_ADDRESS_STREET_NAME, // streetName
                                FieldAgentConstants.FIELD_INTERVIEW_ADDRESS_UNIT, // unitNumber
                                FieldAgentConstants.FIELD_INTERVIEW_ADDRESS_CITY, // city
                                FieldAgentConstants.FIELD_INTERVIEW_ADDRESS_STATE, // state
                                FieldAgentConstants.FIELD_INTERVIEW_ADDRESS_ZIP // zipcode
                );

                // Fill residence address
                fieldInterviewPage.fillResidenceAddress(
                                FieldAgentConstants.FIELD_INTERVIEW_RESIDENCE_STREET_NUM, // streetNum
                                FieldAgentConstants.FIELD_INTERVIEW_RESIDENCE_STREET_NAME, // streetName
                                FieldAgentConstants.FIELD_INTERVIEW_RESIDENCE_UNIT, // unitNumber
                                FieldAgentConstants.FIELD_INTERVIEW_RESIDENCE_CITY, // city
                                FieldAgentConstants.FIELD_INTERVIEW_RESIDENCE_STATE, // state
                                FieldAgentConstants.FIELD_INTERVIEW_RESIDENCE_ZIP // zipcode
                );

                // Fill person description
                fieldInterviewPage.fillPersonDescription(
                                FieldAgentConstants.FIELD_INTERVIEW_PRSON_DESCRIPTION_PERSON_RACE, // race
                                FieldAgentConstants.FIELD_INTERVIEW_PRSON_DESCRIPTION_PERSON_GENDER, // gender
                                FieldAgentConstants.FIELD_INTERVIEW_PRSON_DESCRIPTION_PERSON_HAIR_TYPE, // hairType
                                FieldAgentConstants.FIELD_INTERVIEW_PRSON_DESCRIPTION_PERSON_HAIR, // hairColor
                                FieldAgentConstants.FIELD_INTERVIEW_PRSON_DESCRIPTION_PERSON_EYES, // eyes
                                FieldAgentConstants.FIELD_INTERVIEW_PRSON_DESCRIPTION_PERSON_HEIGHT, // height
                                FieldAgentConstants.FIELD_INTERVIEW_PRSON_DESCRIPTION_PERSON_BUILD, // build
                                FieldAgentConstants.FIELD_INTERVIEW_PRSON_DESCRIPTION_PERSON_WEIGHT, // weight
                                FieldAgentConstants.FIELD_INTERVIEW_PRSON_DESCRIPTION_PERSON_DOB, // dob
                                FieldAgentConstants.FIELD_INTERVIEW_PRSON_DESCRIPTION_PERSON_ODDITIES, // physicalDesc
                                FieldAgentConstants.FIELD_INTERVIEW_PRSON_DESCRIPTION_PERSON_CLOTHING // clothing
                );

                // Fill vehicle details
                fieldInterviewPage.fillVehicleDetails(
                                FieldAgentConstants.FIELD_INTERVIEW_VEHICLE_DETAILS_VEHICLE_LICENSE_PLATE, // licensePlate
                                FieldAgentConstants.FIELD_INTERVIEW_VEHICLE_DETAILS_VEHICLE_LICENSE_STATE, // state
                                FieldAgentConstants.FIELD_INTERVIEW_VEHICLE_DETAILS_VEHICLE_YEAR, // year
                                FieldAgentConstants.FIELD_INTERVIEW_VEHICLE_DETAILS_VEHICLE_MAKE, // make
                                FieldAgentConstants.FIELD_INTERVIEW_VEHICLE_DETAILS_VEHICLE_MODEL, // model
                                FieldAgentConstants.FIELD_INTERVIEW_VEHICLE_DETAILS_VEHICLE_COLOR, // color1
                                null, // color2 (optional)
                                FieldAgentConstants.FIELD_INTERVIEW_VEHICLE_DETAILS_VEHICLE_TYPE // type
                );

                // Fill companion details - COMMENTED OUT: Some fields don't exist on form
                // fieldInterviewPage.fillCompanionDetails(
                // FieldAgentConstants.FIELD_INTERVIEW_COMPANION_NAME, // name
                // FieldAgentConstants.FIELD_INTERVIEW_COMPANION_ADDRESS, // address
                // FieldAgentConstants.FIELD_INTERVIEW_COMPANION_PHONE, // phone
                // FieldAgentConstants.FIELD_INTERVIEW_COMPANION_WORK_PHONE, // workPhone
                // FieldAgentConstants.FIELD_INTERVIEW_COMPANION_GENDER, // gender
                // FieldAgentConstants.FIELD_INTERVIEW_COMPANION_RACE, // race
                // FieldAgentConstants.FIELD_INTERVIEW_COMPANION_HAIR_TYPE, // hairType
                // FieldAgentConstants.FIELD_INTERVIEW_COMPANION_HAIR, // hairColor
                // FieldAgentConstants.FIELD_INTERVIEW_COMPANION_EYES, // eyes
                // FieldAgentConstants.FIELD_INTERVIEW_COMPANION_HEIGHT, // height
                // FieldAgentConstants.FIELD_INTERVIEW_COMPANION_BUILD, // build
                // FieldAgentConstants.FIELD_INTERVIEW_COMPANION_WEIGHT // weight
                // );

                // Fill report and crime potentials
                fieldInterviewPage.fillReportAndCrimePotentials(
                                FieldAgentConstants.FIELD_INTERVIEW_REPORT_DESCRIPTION, // reportNotes
                                FieldAgentConstants.FIELD_INTERVIEW_CRIME_POTENTIALS_CRIME_POTENTIAL_1, // crimePotential1
                                FieldAgentConstants.FIELD_INTERVIEW_CRIME_POTENTIALS_CRIME_POTENTIAL_2 // crimePotential2
                );

                // Upload image
                String absoluteImagePath = new java.io.File(FieldAgentConstants.FIELD_INTERVIEW_INTERVIEW_IMAGE_PATH)
                                .getAbsolutePath();
                fieldInterviewPage.uploadImage(absoluteImagePath);

                // Save field interview
                fieldInterviewPage.clickSaveFieldInterview();

                // Verify success message
                Assert.assertTrue(fieldInterviewPage.isSuccessMessageDisplayed(),
                                "Success message should be displayed after saving field interview");

                System.out.println("✅ TEST PASSED: Field interview created successfully");
        }

        /**
         * Test 2: Add field interview with minimum required fields
         */
        @Test(priority = 2, description = "Add field interview with only required fields", enabled = false)
        public void testAddFieldInterviewMinimumFields() {
                System.out.println("🧪 TEST: Add Field Interview with Minimum Required Fields");

                // Click Add New Field Interview button
                fieldInterviewPage.clickAddNewFieldInterview();

                // Fill only required incident details
                fieldInterviewPage.fillIncidentDetails(
                                FieldAgentConstants.FIELD_INTERVIEW_SITE_NUMBER, // site (required)
                                null, // call (optional)
                                null, // incidentReport (optional)
                                FieldAgentConstants.FIELD_INTERVIEW_INTERVIEW_DATE_TIME // interviewDateTime (required)
                );

                // Fill only required person information
                fieldInterviewPage.fillPersonInfo(
                                FieldAgentConstants.FIELD_INTERVIEW_LAST_NAME, // lastName (required)
                                null, // middleName (optional)
                                FieldAgentConstants.FIELD_INTERVIEW_FIRST_NAME, // firstName (required)
                                null, // nickname (optional)
                                null, // phone (optional)
                                null, // dlNumber (optional)
                                null // dlState (optional)
                );

                // Fill report notes
                fieldInterviewPage.fillReportAndCrimePotentials(
                                FieldAgentConstants.FIELD_INTERVIEW_REPORT_DESCRIPTION, // reportNotes (required)
                                null, // crimePotential1 (optional)
                                null // crimePotential2 (optional)
                );

                // Save field interview
                fieldInterviewPage.clickSaveFieldInterview();

                // Verify success
                Assert.assertTrue(fieldInterviewPage.isSuccessMessageDisplayed(),
                                "Success message should be displayed after saving field interview with minimum fields");

                System.out.println("✅ TEST PASSED: Field interview with minimum fields created successfully");
        }

        /**
         * Test 3: Add field interview with image upload
         */
        @Test(priority = 3, description = "Add field interview with image attachment", enabled = false)
        public void testAddFieldInterviewWithImage() {
                System.out.println("🧪 TEST: Add Field Interview with Image");

                // Click Add New Field Interview button
                fieldInterviewPage.clickAddNewFieldInterview();

                // Fill basic details
                fieldInterviewPage.fillIncidentDetails(
                                FieldAgentConstants.FIELD_INTERVIEW_SITE_NUMBER,
                                null,
                                null,
                                FieldAgentConstants.FIELD_INTERVIEW_INTERVIEW_DATE_TIME);

                fieldInterviewPage.fillPersonInfo(
                                FieldAgentConstants.FIELD_INTERVIEW_LAST_NAME,
                                FieldAgentConstants.FIELD_INTERVIEW_MIDDLE_NAME,
                                FieldAgentConstants.FIELD_INTERVIEW_FIRST_NAME,
                                null, null, null, null);

                fieldInterviewPage.fillReportAndCrimePotentials(
                                FieldAgentConstants.FIELD_INTERVIEW_REPORT_DESCRIPTION,
                                null, null);

                // Upload image
                fieldInterviewPage.uploadImage(FieldAgentConstants.FIELD_INTERVIEW_INTERVIEW_IMAGE_PATH);

                // Save field interview
                fieldInterviewPage.clickSaveFieldInterview();

                // Verify success
                Assert.assertTrue(fieldInterviewPage.isSuccessMessageDisplayed(),
                                "Success message should be displayed after saving field interview with image");

                System.out.println("✅ TEST PASSED: Field interview with image created successfully");
        }
}
