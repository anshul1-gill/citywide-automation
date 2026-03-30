package com.dits.citywide.tests.formconversion;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.dits.citywide.FormConversion.ReactTrespassNotice;
import com.dits.citywide.base.BaseTest;
import com.dits.citywide.utilities.ElementUtils;

/**
 * Test class for deleting React Trespass Notice
 */
public class ReactTrespassNoticeformDeleteTest extends BaseTest {

    private ReactTrespassNotice trespassNoticePage;
    private ElementUtils elementUtils;

    @BeforeClass
    public void setUpClass() {
        // Login once
        dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));

        // Initialize page objects
        elementUtils = new ElementUtils(driver);
        trespassNoticePage = new ReactTrespassNotice(driver, elementUtils);

        System.out.println("✅ Login successful and page objects initialized");
    }

    @Test(priority = 1, description = "Delete trespass notice from listing page", enabled = true)
    public void testDeleteTrespassNotice() {
        System.out.println("🧪 TEST: Delete Trespass Notice");

        // Navigate to Trespass Notice page
        trespassNoticePage.navigateToTrespassNotice();

        // Delete first trespass notice
        trespassNoticePage.deleteTrespassNotice();

        System.out.println("TEST PASSED: Trespass notice deleted successfully");
    }
}
