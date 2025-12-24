package com.dits.citywide.tests.scheduling;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.HRManagementConstants;
import com.dits.citywide.constants.SchedulingConstant;

public class UpdatePublishedShiftTest extends BaseTest {

        @BeforeMethod
        public void performLogin() throws InterruptedException {
                dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        }

        @Test
        public void updatePublishedShiftTest() throws InterruptedException {
                System.out.println("🚀 Starting Update Published Shift Test...");

                // ========== PART 1: CREATE AND PUBLISH SHIFT (Reuse AddShiftTest logic)
                // ==========
                Thread.sleep(4000);
                schedulingPage = dashboardPage.doClickScheduling();
                Thread.sleep(2000);

                // Select filters and site
                schedulingPage.clickOnFilters();
                schedulingPage.clickOnServiceTypeCheckbox();
                schedulingPage.selectSiteAndApply(HRManagementConstants.SITE);

                // Create shift
                schedulingPage.addShift(SchedulingConstant.ADD_SHIFT_DATE);
                schedulingPage.selectAssignShift(SchedulingConstant.ASSIGN_SHIFT);
                Thread.sleep(1000); // Wait for form to load
                schedulingPage.fillShiftForm(
                                SchedulingConstant.ASSIGN_SHIFT,
                                prop.getProperty("employeeID"),
                                SchedulingConstant.START_TIME,
                                SchedulingConstant.END_TIME,
                                SchedulingConstant.SCHEDULED_BREAK,
                                SchedulingConstant.ADD_NOTES);

                // Verify shift created
                softAssert.assertEquals(schedulingPage.getSuccessMessageShiftAdded(),
                                SchedulingConstant.SUCCESS_MESSAGE_ADD_SHIFT);
                System.out.println("✅ Shift created successfully");

                // Publish shift
                schedulingPage.clickPublishButton();
                softAssert.assertEquals(schedulingPage.getAreYouSureText(), SchedulingConstant.ARE_YOU_SURE);
                softAssert.assertEquals(schedulingPage.getPublishShiftsConfirmationText(),
                                SchedulingConstant.ACTION_WILL_PUBLISH_SHIFTS);
                schedulingPage.clickOkButton();
                softAssert.assertEquals(schedulingPage.getSuccessMessageAfterPublish(),
                                SchedulingConstant.SUCCESS_PUBLISH_MESSAGE);
                System.out.println("✅ Shift published successfully");

                Thread.sleep(2000); // Wait for calendar to refresh

                // ========== PART 2: UPDATE PUBLISHED SHIFT (NEW LOGIC) ==========

                // Build shift time string to locate it (e.g., "09:00 - 17:00")
                String originalTime = SchedulingConstant.START_TIME + " - " + SchedulingConstant.END_TIME;
                String employeeID = prop.getProperty("employeeID");

                System.out.println("🔍 Searching for shift: " + originalTime + " for employee " + employeeID);

                // Right-click on published shift to open context menu
                schedulingPage.rightClickOnShift(originalTime, employeeID);

                // Click "Update" from context menu
                schedulingPage.clickUpdateFromContextMenu();

                // Update shift details
                schedulingPage.updateShiftDetails(
                                SchedulingConstant.UPDATED_START_TIME,
                                SchedulingConstant.UPDATED_END_TIME,
                                SchedulingConstant.UPDATED_BREAK,
                                SchedulingConstant.UPDATED_NOTES);

                // Verify update success
                softAssert.assertEquals(schedulingPage.getUpdateSuccessMessage(),
                                SchedulingConstant.SUCCESS_MESSAGE_UPDATE_SHIFT);
                System.out.println("✅ Shift updated successfully!");

                System.out.println("🎉 Update Published Shift Test COMPLETED");
                softAssert.assertAll();
        }

}
