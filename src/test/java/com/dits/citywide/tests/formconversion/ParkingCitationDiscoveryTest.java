package com.dits.citywide.tests.formconversion;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.FormConversion.ReactParkingCitaton;
import com.dits.citywide.base.BaseTest;
import com.dits.citywide.utilities.ElementUtils;

/**
 * Discovery test to inspect dropdown values
 */
public class ParkingCitationDiscoveryTest extends BaseTest {

    private ReactParkingCitaton parkingCitationPage;
    private ElementUtils elementUtils;

    @BeforeClass
    public void setUpClass() {
        // Login once
        dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));

        // Initialize page objects
        elementUtils = new ElementUtils(driver);
        parkingCitationPage = new ReactParkingCitaton(driver, elementUtils);

        System.out.println("✅ Login successful");
    }

    @BeforeMethod
    public void setUp() {
        // Navigate to Parking Citation page
        parkingCitationPage.navigateToParkingCitation();
    }

    /**
     * Discovery Test: Opens the form and pauses for 60 seconds
     * Use this time to manually inspect the dropdown values
     */
    @Test(priority = 1, description = "Discovery test - inspect dropdown values")
    public void testDiscoverDropdownValues() throws InterruptedException {
        System.out.println("🔍 DISCOVERY TEST: Inspect Dropdown Values");
        System.out.println("==========================================");

        // Click Add New Citation
        parkingCitationPage.clickAddNewCitation();
        System.out.println("✅ Form opened");

        // Pause for 60 seconds
        System.out.println("");
        System.out.println("⏸️  PAUSED FOR 60 SECONDS");
        System.out.println("📋 Please manually check these dropdowns and note the EXACT values:");
        System.out.println("   1. Site # dropdown");
        System.out.println("   2. Activity Code dropdown");
        System.out.println("   3. State dropdown");
        System.out.println("   4. Select Color dropdown");
        System.out.println("   5. Year dropdown");
        System.out.println("   6. Select Make dropdown");
        System.out.println("   7. Select Model dropdown");
        System.out.println("   8. Select Violation dropdown");
        System.out.println("");
        System.out.println("⏰ Waiting...");

        // Wait 60 seconds
        Thread.sleep(60000);

        System.out.println("✅ Discovery test complete!");
    }
}
