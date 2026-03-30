package com.dits.citywide.tests.formconversion;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.dits.citywide.FormConversion.ReactParkingCitaton;
import com.dits.citywide.base.BaseTest;
import com.dits.citywide.utilities.ElementUtils;

/**
 * Test class for deleting React Parking Citation
 */
public class ReactParkingCitationDeleteTest extends BaseTest {

    private ReactParkingCitaton parkingCitationPage;
    private ElementUtils elementUtils;

    @BeforeClass
    public void setUpClass() {
        // Login once
        dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));

        // Initialize page objects
        elementUtils = new ElementUtils(driver);
        parkingCitationPage = new ReactParkingCitaton(driver, elementUtils);

        System.out.println("✅ Login successful and page objects initialized");
    }

    @Test(priority = 1, description = "Delete parking citation from listing page", enabled = true)
    public void testDeleteParkingCitation() {
        System.out.println("🧪 TEST: Delete Parking Citation");

        // Navigate to Parking Citation page
        parkingCitationPage.navigateToParkingCitation();

        // Delete first citation
        parkingCitationPage.deleteCitation();

        System.out.println("✅ TEST PASSED: Parking citation deleted successfully");
    }
}
