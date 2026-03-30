package com.dits.citywide.tests.formconversion;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.FormConversion.ReactParkingCitaton;
import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.FieldAgentConstants;
import com.dits.citywide.utilities.ElementUtils;

/**
 * Test class for React Parking Citation form
 * Tests include: Adding Citations, Filtering, and Verification
 */
public class ReactParkingCitationform extends BaseTest {

    private ReactParkingCitaton parkingCitationPage;
    private ElementUtils elementUtils;

    @BeforeClass
    public void setUpClass() {
        // Login once (BaseTest already initialized driver in @BeforeClass)
        dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));

        // Initialize page objects once
        elementUtils = new ElementUtils(driver);
        parkingCitationPage = new ReactParkingCitaton(driver, elementUtils);

        System.out.println("Login successful and page objects initialized");
    }

    @BeforeMethod
    public void setUp() {
        // Navigate to Parking Citation page before each test
        parkingCitationPage.navigateToParkingCitation();
    }

    /**
     * Test 1: Add a new parking citation with all required fields
     */
    @Test(priority = 1, description = "Add a new parking citation with complete details")
    public void testAddNewParkingCitation() {
        System.out.println("🧪 TEST: Add New Parking Citation");

        // Click Add New Citation button
        parkingCitationPage.clickAddNewCitation();

        // Read Call ID and Incident Report ID from config
        String callId = prop.getProperty("callid");
        String incidentReportId = prop.getProperty("incidentReportID");

        // Fill citation form with data from FieldAgentConstants
        parkingCitationPage.fillCitationForm(
                FieldAgentConstants.SITE, // site
                callId, // call - read from config
                incidentReportId, // incidentReportValue - read from config
                FieldAgentConstants.DATE_TIME, // noticeDate
                FieldAgentConstants.ACTIVITY_CODE, // activityCode
                FieldAgentConstants.VIN_NUMBER, // vin
                FieldAgentConstants.LICENSE_NO, // licensePlate
                FieldAgentConstants.SELECT_STATE, // state
                FieldAgentConstants.EXPIRE_DATE, // expDate
                FieldAgentConstants.VEHICLE_COLOR, // vehicleColor
                FieldAgentConstants.YEAR, // vehicleYear
                FieldAgentConstants.VEHICLE_MAKE, // vehicleMake
                FieldAgentConstants.VEHICLE_MODEL, // vehicleModel
                FieldAgentConstants.VIOLATION, // violation
                FieldAgentConstants.ADDITIONAL_DETAILS // additionalDetails
        );

        // Upload image
        String absoluteImagePath = new java.io.File(FieldAgentConstants.FILE_PATH).getAbsolutePath();
        parkingCitationPage.uploadImage(absoluteImagePath);

        // Save citation
        parkingCitationPage.clickSaveCitation();

        // Verify success message
        Assert.assertTrue(parkingCitationPage.isSuccessMessageDisplayed(),
                "Success message should be displayed after saving citation");

        System.out.println("✅ TEST PASSED: Parking citation created successfully");
    }

    /**
     * Test 2: Add parking citation with impounded vehicle details
     */
    @Test(priority = 2, description = "Add parking citation with impounded vehicle information")
    public void testAddParkingCitationWithImpound() {
        System.out.println("🧪 TEST: Add Parking Citation with Impound Details");

        // Click Add New Citation button
        parkingCitationPage.clickAddNewCitation();

        // Read Call ID and Incident Report ID from config
        String callId = prop.getProperty("callid");
        String incidentReportId = prop.getProperty("incidentReportID");

        // Fill basic citation form
        parkingCitationPage.fillCitationForm(
                FieldAgentConstants.UPDATED_SITE, // site
                callId, // call - read from config
                incidentReportId, // incidentReportValue - read from config
                FieldAgentConstants.UPDATE_DATE_TIME, // noticeDate
                FieldAgentConstants.UPDATE_ACTIVITY_CODE, // activityCode
                FieldAgentConstants.UPDATE_VIN_NUMBER, // vin
                FieldAgentConstants.UPDATE_LICENSE_NO, // licensePlate
                FieldAgentConstants.UPDATE_STATE, // state
                FieldAgentConstants.UPDATE_EXPIRE_DATE, // expDate
                FieldAgentConstants.UPDATE_VEHICLE_COLOR, // vehicleColor
                FieldAgentConstants.UPDATE_YEAR, // vehicleYear
                FieldAgentConstants.UPDATE_VEHICLE_MAKE, // vehicleMake
                FieldAgentConstants.UPDATE_VEHICLE_MODEL, // vehicleModel
                FieldAgentConstants.UPDATE_VIOLATION, // violation
                FieldAgentConstants.UPDATE_ADDITIONAL_DETAILS // additionalDetails
        );

        // Fill impounded details
        parkingCitationPage.fillImpoundedDetails(
                FieldAgentConstants.IMPOUNDED_DATE_TIME, // impoundDateTime
                FieldAgentConstants.TOWING_COMPANY // towingCompany
        );

        // Save citation
        parkingCitationPage.clickSaveCitation();

        // Verify success
        Assert.assertTrue(parkingCitationPage.isSuccessMessageDisplayed(),
                "Success message should be displayed after saving citation with impound details");

        System.out.println("✅ TEST PASSED: Parking citation with impound details created successfully");
    }

    /**
     * Test 3: Apply filters to search for parking citations
     */
    @Test(priority = 3, description = "Filter parking citations by various criteria", enabled = false)
    public void testFilterParkingCitations() {
        System.out.println("🧪 TEST: Filter Parking Citations");

        // Apply filters
        parkingCitationPage.applyFilters(
                "123", // siteNumber - UPDATE WITH ACTUAL VALUE
                FieldAgentConstants.LICENSE_NO, // licensePlate
                FieldAgentConstants.SELECT_STATE, // state
                "John", // firstName - UPDATE WITH ACTUAL VALUE
                "Doe" // lastName - UPDATE WITH ACTUAL VALUE
        );

        // Wait a moment for results to load
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("✅ TEST PASSED: Filters applied successfully");
    }

    /**
     * Test 4: Test global search functionality
     */
    @Test(priority = 4, description = "Search parking citations using global search", enabled = false)
    public void testGlobalSearch() {
        System.out.println("🧪 TEST: Global Search for Parking Citations");

        // Perform global search
        parkingCitationPage.globalSearch(FieldAgentConstants.LICENSE_NO);

        // Wait for search results
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("✅ TEST PASSED: Global search executed successfully");
    }

    /**
     * Test 5: Add citation with image upload
     */
    @Test(priority = 5, description = "Add parking citation with image attachment", enabled = false)
    public void testAddCitationWithImage() {
        System.out.println("🧪 TEST: Add Parking Citation with Image");

        // Click Add New Citation button
        parkingCitationPage.clickAddNewCitation();

        // Read Call ID and Incident Report ID from config
        String callId = prop.getProperty("callid");
        String incidentReportId = prop.getProperty("incidentReportID");

        // Fill basic citation form
        parkingCitationPage.fillCitationForm(
                FieldAgentConstants.SITE,
                callId, // call - read from config
                incidentReportId, // incidentReportValue - read from config
                FieldAgentConstants.DATE_TIME,
                FieldAgentConstants.ACTIVITY_CODE,
                FieldAgentConstants.VIN_NUMBER,
                FieldAgentConstants.LICENSE_NO,
                FieldAgentConstants.SELECT_STATE,
                FieldAgentConstants.EXPIRE_DATE,
                FieldAgentConstants.VEHICLE_COLOR,
                FieldAgentConstants.YEAR,
                FieldAgentConstants.VEHICLE_MAKE,
                FieldAgentConstants.VEHICLE_MODEL,
                FieldAgentConstants.VIOLATION,
                FieldAgentConstants.ADDITIONAL_DETAILS);

        // Upload image
        parkingCitationPage.uploadImage(FieldAgentConstants.FILE_PATH);

        // Save citation
        parkingCitationPage.clickSaveCitation();

        // Verify success
        Assert.assertTrue(parkingCitationPage.isSuccessMessageDisplayed(),
                "Success message should be displayed after saving citation with image");

        System.out.println("✅ TEST PASSED: Parking citation with image created successfully");
    }

    /**
     * Test 6: Verify minimum required fields for citation
     */
    @Test(priority = 6, description = "Add parking citation with only required fields", enabled = false)
    public void testAddCitationMinimumFields() {
        System.out.println("🧪 TEST: Add Parking Citation with Minimum Required Fields");

        // Click Add New Citation button
        parkingCitationPage.clickAddNewCitation();

        // Read Call ID and Incident Report ID from config
        String callId = prop.getProperty("callid");
        String incidentReportId = prop.getProperty("incidentReportID");

        // Fill only required fields
        parkingCitationPage.fillCitationForm(
                FieldAgentConstants.SITE, // site (required)
                callId, // call - read from config
                incidentReportId, // incidentReportValue - read from config
                FieldAgentConstants.DATE_TIME, // noticeDate (required)
                null, // activityCode (optional)
                null, // vin (optional)
                FieldAgentConstants.LICENSE_NO, // licensePlate (required)
                FieldAgentConstants.SELECT_STATE, // state (required)
                null, // expDate (optional)
                null, // vehicleColor (optional)
                null, // vehicleYear (optional)
                null, // vehicleMake (optional)
                null, // vehicleModel (optional)
                FieldAgentConstants.VIOLATION, // violation (required)
                null // additionalDetails (optional)
        );

        // Save citation
        parkingCitationPage.clickSaveCitation();

        // Verify success
        Assert.assertTrue(parkingCitationPage.isSuccessMessageDisplayed(),
                "Success message should be displayed after saving citation with minimum fields");

        System.out.println("✅ TEST PASSED: Parking citation with minimum fields created successfully");
    }
}
