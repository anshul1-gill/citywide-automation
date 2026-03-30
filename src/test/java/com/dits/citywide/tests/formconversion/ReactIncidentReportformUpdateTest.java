package com.dits.citywide.tests.formconversion;

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
 * Test class for updating React Incident Report.
 * Priority 1: Edit Description only, click Scan And Update.
 * Priority 2: Edit and click Update Incident Report button.
 */
public class ReactIncidentReportformUpdateTest extends BaseTest {

        private ReactIncidentForm incidentReportPage;

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

        @Test(priority = 1, description = "Update incident report — edit Description only, keep rest as-is")
        public void testUpdateIncidentReportWithConstants() {

                System.out.println("🧪 TEST: Update Incident Report — Description Only");

                // Step 1 — Click Edit on the first incident report in the listing
                incidentReportPage.clickEditIncidentReport();

                // Step 2 — Update only the Incident Description (all other fields stay as-is)
                incidentReportPage.fillIncidentDescription(
                                FieldAgentConstants.UPDATE_INCIDENT_DESCRIPTION);

                // Step 3 — Click Scan And Update
                incidentReportPage.clickUpdateIncidentReport();

                // Step 4 — Assert success
                Assert.assertTrue(
                                incidentReportPage.isSuccessMessageDisplayed(),
                                "Success message should appear after updating the incident report");
                System.out.println("✅ PASSED: testUpdateIncidentReportWithConstants");
        }

        @Test(priority = 2, description = "Edit incident report and click Update Incident Report button")
        public void testClickUpdateIncidentReport() {

                System.out.println("🧪 TEST: Edit and Click Update Incident Report");

                // Step 1 — Click Edit on the first incident report in the listing
                incidentReportPage.clickEditIncidentReport();

                // Step 2 — Click Update Incident Report button (no changes, just re-submit)
                incidentReportPage.clickUpdateIncidentReportButton();

                // Step 3 — Assert success
                Assert.assertTrue(
                                incidentReportPage.isSuccessMessageDisplayed(),
                                "Success message should appear after clicking Update Incident Report");
                System.out.println("✅ PASSED: testClickUpdateIncidentReport");
        }
}
