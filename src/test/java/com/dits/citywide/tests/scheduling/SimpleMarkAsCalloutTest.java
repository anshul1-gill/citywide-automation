package com.dits.citywide.tests.scheduling;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.SchedulingConstant;

public class SimpleMarkAsCalloutTest extends BaseTest {

    @BeforeMethod
    public void performLogin() throws InterruptedException {
        dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
    }

    @Test(priority = 1, description = "Simple Mark as Callout Test - Create, Publish, and Mark as Callout")
    public void simpleMarkAsCalloutTest() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();

        try {
            try {
                System.out.println("\n🚀 Starting Simple Mark As Callout Test...");

                // Navigate to scheduling page
                Thread.sleep(4000);
                schedulingPage = dashboardPage.doClickScheduling();
                System.out.println("📅 Navigated to Scheduling page");
                Thread.sleep(2000);

                // Select Richmond site with Service Type filter
                schedulingPage.clickOnFilters();
                schedulingPage.clickOnServiceTypeCheckbox();
                schedulingPage.selectSiteAndApply("Richmond");
                System.out.println("🏢 Selected Richmond site with Service Type filter");

                // Create shift for employee 1105
                schedulingPage.addShift(SchedulingConstant.ADD_SHIFT_DATE);
                schedulingPage.selectAssignShift(SchedulingConstant.ASSIGN_SHIFT);
                schedulingPage.fillShiftForm(
                        SchedulingConstant.ASSIGN_SHIFT,
                        "1105",
                        "09:00",
                        "17:00",
                        SchedulingConstant.SCHEDULED_BREAK,
                        "Test shift for callout");
                softAssert.assertEquals(schedulingPage.getSuccessMessageShiftAdded(),
                        SchedulingConstant.SUCCESS_MESSAGE_ADD_SHIFT);
                System.out.println("✅ Shift created for employee 1105");

                // Publish shift
                schedulingPage.clickPublishButton();
                schedulingPage.clickOkButton();
                softAssert.assertEquals(schedulingPage.getSuccessMessageAfterPublish(),
                        SchedulingConstant.SUCCESS_PUBLISH_MESSAGE);
                System.out.println("📢 Shift published successfully");

                // Wait for toast message to disappear
                Thread.sleep(3000);
                System.out.println("⏳ Waited for toast message to disappear");

                // Left-click on the shift to open modal
                WebElement shiftElement = schedulingPage.findShiftByDetails("09:00 - 17:00", "1105");
                shiftElement.click();
                System.out.println("🖱️ Clicked on shift: 09:00 - 17:00 for employee 1105");
                Thread.sleep(2000); // Wait for modal to open

                // Click Mark as Callout button
                schedulingPage.clickMarkAsCallout();
                System.out.println("✅ Clicked 'Mark as Callout' button");
                Thread.sleep(2000); // Wait for modal to appear

                // Fill the Mark as Callout modal
                schedulingPage.fillMarkAsCalloutReason("Employee called out - unable to work");
                schedulingPage.submitMarkAsCallout();
                System.out.println("📝 Submitted Mark as Callout form");

                // Verify success message
                String successMessage = schedulingPage.getMarkAsCalloutSuccessMessage();
                softAssert.assertNotNull(successMessage, "Success message should be displayed");
                System.out.println("✅ Mark as Callout Success: " + successMessage);

                System.out.println("\n🎉 Test Completed Successfully!");
                softAssert.assertAll();

            } catch (Exception e) {
                System.out.println("❌ Test failed with error: " + e.getMessage());
                e.printStackTrace();
                throw e;
            }
        } catch (Exception e) {
            System.out.println("❌ Test failed with error: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }
}
