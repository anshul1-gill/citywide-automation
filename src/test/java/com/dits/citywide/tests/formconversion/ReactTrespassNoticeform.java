package com.dits.citywide.tests.formconversion;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.FormConversion.ReactTrespassNotice;
import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.FieldAgentConstants;
import com.dits.citywide.utilities.ElementUtils;

/**
 * Test class for React Trespass Notice form
 * Tests include: Adding Trespass Notices and Verification
 */
public class ReactTrespassNoticeform extends BaseTest {

        private ReactTrespassNotice trespassNoticePage;
        private ElementUtils elementUtils;

        @BeforeClass
        public void setUpClass() {
                // Login once (BaseTest already initialized driver in @BeforeClass)
                dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));

                // Initialize page objects once
                elementUtils = new ElementUtils(driver);
                trespassNoticePage = new ReactTrespassNotice(driver, elementUtils);

                System.out.println(" Login successful and page objects initialized");
        }

        @BeforeMethod
        public void setUp() {
                // Navigate to Trespass Notice page before each test
                trespassNoticePage.navigateToTrespassNotice();
        }

        /**
         * Test 1: Add a new trespass notice with all required fields
         */
        @Test(priority = 1, description = "Add a new trespass notice with complete details")
        public void testAddNewTrespassNotice() {
                System.out.println("🧪 TEST: Add New Trespass Notice");

                // Click Add New Trespass Notice button
                trespassNoticePage.clickAddNewTrespassNotice();

                // Fill location details
                trespassNoticePage.fillLocationDetails(
                                FieldAgentConstants.TRESPASS_SITE, // site
                                null, // call (optional)
                                null, // incidentReport (optional)
                                FieldAgentConstants.TRESPASS_DATE_TIME, // noticeDateTime
                                FieldAgentConstants.TRESPASS_ACTIVITY_CODE, // activityCode
                                FieldAgentConstants.TRESPASS_STREET_NUMBER, // streetNum
                                FieldAgentConstants.TRESPASS_STREET_NAME, // streetName
                                FieldAgentConstants.TRESPASS_UNIT_NUMBER, // unitNumber
                                FieldAgentConstants.TRESPASS_CITY, // city
                                FieldAgentConstants.TRESPASS_STATE, // state
                                FieldAgentConstants.TRESPASS_ZIP // zipcode
                );

                // Fill trespasser details
                trespassNoticePage.fillTrespasserDetails(
                                FieldAgentConstants.TRESPASS_LAST_NAME, // lastName
                                FieldAgentConstants.TRESPASS_MIDDLE_NAME, // middleName
                                FieldAgentConstants.TRESSPASS_FIRST_NAME, // firstName
                                FieldAgentConstants.TRESSPASSER_DL_NUMBER, // dlNumber
                                FieldAgentConstants.TRESSPASSER_DL_STATE, // dlState
                                FieldAgentConstants.TRESSPASSER_DL_EXPIRE_DATE // dlExpire
                );

                // Fill trespasser address
                trespassNoticePage.fillTrespasserAddress(
                                FieldAgentConstants.TRESSPASSER_STREET_NUMBER, // streetNum
                                FieldAgentConstants.TRESSPASSER_STREET_NAME, // streetName
                                FieldAgentConstants.TRESSPASSER_UNIT_NUMBER, // unitNumber
                                FieldAgentConstants.TRESSPASSER_CITY, // city
                                FieldAgentConstants.TRESSPASSER_STATE, // state
                                FieldAgentConstants.TRESSPASSER_ZIP // zipcode
                );

                // Fill vehicle details
                trespassNoticePage.fillVehicleDetails(
                                FieldAgentConstants.TRESSPASSER_VEHICLE_YEAR, // vehicleYear
                                FieldAgentConstants.TRESSPASSER_VEHICLE_MAKE, // vehicleMake
                                FieldAgentConstants.TRESSPASSER_VEHICLE_MODEL, // vehicleModel
                                FieldAgentConstants.TRESSPASSER_VEHICLE_COLOR, // vehicleColor
                                FieldAgentConstants.TRESSPASSER_VEHICLE_PLATE, // vehiclePlate
                                FieldAgentConstants.TRESSPASSER_VEHICLE_STATE // vehicleState
                );

                // Fill description
                trespassNoticePage.fillDescription(
                                FieldAgentConstants.TRESSPASSER_GENDER, // gender
                                FieldAgentConstants.TRESSPASS_RACE, // race
                                FieldAgentConstants.TRESSPASS_HAIR_TYPE, // hairType
                                FieldAgentConstants.TRESSPASS_HAIR_COLOR, // hairColor
                                FieldAgentConstants.TRESSPASS_EYE_COLOR, // eyes
                                FieldAgentConstants.TRESSPASS_HEIGHT, // height
                                FieldAgentConstants.TRESSPASS_BUILD, // buildType
                                FieldAgentConstants.TRESSPASS_WEIGHT // weight
                );

                // Fill narrative and PD contact
                trespassNoticePage.fillNarrativeAndPDContact(
                                FieldAgentConstants.TRESPASS_NARRATIVE, // narrative
                                FieldAgentConstants.TRESPASS_WAS_PD_CONTACTED, // pdContacted
                                FieldAgentConstants.TRESPASS_RESPONDING_AGENCY, // respondingAgency
                                FieldAgentConstants.TRESPASS_TIME_OF_CONTACT, // timeOfContact
                                FieldAgentConstants.TRESPASS_DID_THEY_SHOW, // didTheyShow
                                FieldAgentConstants.TRESPASS_OFFICER_NAME, // officerName
                                FieldAgentConstants.TRESPASS_OFFICER_BADGE, // badgeNumber
                                FieldAgentConstants.TRESPASS_INCIDENT_NUMBER_PD, // incidentNumber
                                FieldAgentConstants.TRESPASS_WAS_ARRESTED, // wasArrested
                                FieldAgentConstants.TRESPASS_CHARGE // charge
                );

                // Upload image
                String absoluteImagePath = new java.io.File(FieldAgentConstants.TRESPASS_FILE_PATH).getAbsolutePath();
                trespassNoticePage.uploadImage(absoluteImagePath);

                // Save trespass notice
                trespassNoticePage.clickSaveTrespassNotice();

                // Verify success message
                Assert.assertTrue(trespassNoticePage.isSuccessMessageDisplayed(),
                                "Success message should be displayed after saving trespass notice");

                System.out.println("✅ TEST PASSED: Trespass notice created successfully");
        }

        /**
         * Test 2: Add trespass notice with minimum required fields
         */
        @Test(priority = 2, description = "Add trespass notice with only required fields", enabled = false)
        public void testAddTrespassNoticeMinimumFields() {
                System.out.println("🧪 TEST: Add Trespass Notice with Minimum Required Fields");

                // Click Add New Trespass Notice button
                trespassNoticePage.clickAddNewTrespassNotice();

                // Fill only required location details
                trespassNoticePage.fillLocationDetails(
                                FieldAgentConstants.TRESPASS_SITE, // site (required)
                                null, // call (optional)
                                null, // incidentReport (optional)
                                FieldAgentConstants.TRESPASS_DATE_TIME, // noticeDateTime (required)
                                FieldAgentConstants.TRESPASS_ACTIVITY_CODE, // activityCode
                                FieldAgentConstants.TRESPASS_STREET_NUMBER, // streetNum (required)
                                FieldAgentConstants.TRESPASS_STREET_NAME, // streetName (required)
                                null, // unitNumber (optional)
                                FieldAgentConstants.TRESPASS_CITY, // city (required)
                                FieldAgentConstants.TRESPASS_STATE, // state (required)
                                FieldAgentConstants.TRESPASS_ZIP // zipcode
                );

                // Fill only required trespasser details
                trespassNoticePage.fillTrespasserDetails(
                                FieldAgentConstants.TRESPASS_LAST_NAME, // lastName (required)
                                null, // middleName (optional)
                                FieldAgentConstants.TRESSPASS_FIRST_NAME, // firstName (required)
                                null, // dlNumber (optional)
                                null, // dlState (optional)
                                null // dlExpire (optional)
                );

                // Fill narrative
                trespassNoticePage.fillNarrativeAndPDContact(
                                FieldAgentConstants.TRESPASS_NARRATIVE, // narrative (required)
                                null, // pdContacted (optional)
                                null, // respondingAgency (optional)
                                null, // timeOfContact (optional)
                                null, // didTheyShow (optional)
                                null, // officerName (optional)
                                null, // badgeNumber (optional)
                                null, // incidentNumber (optional)
                                null, // wasArrested (optional)
                                null // charge (optional)
                );

                // Save trespass notice
                trespassNoticePage.clickSaveTrespassNotice();

                // Verify success
                Assert.assertTrue(trespassNoticePage.isSuccessMessageDisplayed(),
                                "Success message should be displayed after saving trespass notice with minimum fields");

                System.out.println("✅ TEST PASSED: Trespass notice with minimum fields created successfully");
        }

        /**
         * Test 3: Add trespass notice with image upload
         */
        @Test(priority = 3, description = "Add trespass notice with image attachment", enabled = false)
        public void testAddTrespassNoticeWithImage() {
                System.out.println("🧪 TEST: Add Trespass Notice with Image");

                // Click Add New Trespass Notice button
                trespassNoticePage.clickAddNewTrespassNotice();

                // Fill basic details
                trespassNoticePage.fillLocationDetails(
                                FieldAgentConstants.TRESPASS_SITE,
                                null,
                                null,
                                FieldAgentConstants.TRESPASS_DATE_TIME,
                                FieldAgentConstants.TRESPASS_ACTIVITY_CODE,
                                FieldAgentConstants.TRESPASS_STREET_NUMBER,
                                FieldAgentConstants.TRESPASS_STREET_NAME,
                                FieldAgentConstants.TRESPASS_UNIT_NUMBER,
                                FieldAgentConstants.TRESPASS_CITY,
                                FieldAgentConstants.TRESPASS_STATE,
                                FieldAgentConstants.TRESPASS_ZIP);

                trespassNoticePage.fillTrespasserDetails(
                                FieldAgentConstants.TRESPASS_LAST_NAME,
                                FieldAgentConstants.TRESPASS_MIDDLE_NAME,
                                FieldAgentConstants.TRESSPASS_FIRST_NAME,
                                FieldAgentConstants.TRESSPASSER_DL_NUMBER,
                                FieldAgentConstants.TRESSPASSER_DL_STATE,
                                FieldAgentConstants.TRESSPASSER_DL_EXPIRE_DATE);

                trespassNoticePage.fillNarrativeAndPDContact(
                                FieldAgentConstants.TRESPASS_NARRATIVE,
                                null, null, null, null, null, null, null, null, null);

                // Upload image
                trespassNoticePage.uploadImage(FieldAgentConstants.TRESPASS_FILE_PATH);

                // Save trespass notice
                trespassNoticePage.clickSaveTrespassNotice();

                // Verify success
                Assert.assertTrue(trespassNoticePage.isSuccessMessageDisplayed(),
                                "Success message should be displayed after saving trespass notice with image");

                System.out.println("✅ TEST PASSED: Trespass notice with image created successfully");
        }
}
