package com.dits.citywide.tests.scheduling;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.HRManagementConstants;
import com.dits.citywide.constants.SchedulingConstant;

public class DragDropSchedulingTest extends BaseTest {

        @BeforeMethod
        public void performLogin() throws InterruptedException {
                dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        }

        @Test(priority = 1, description = "Drag and drop shift from one date to another")
        public void dragDropShiftTest() throws InterruptedException {
                System.out.println("🚀 Starting Drag and Drop Shift Test...");
                System.out.println("📅 Source Date: " + SchedulingConstant.DRAG_SOURCE_DATE + ", Target Date: "
                                + SchedulingConstant.DRAG_TARGET_DATE);
                System.out.println("👤 Employee: " + SchedulingConstant.DRAG_DROP_EMPLOYEE_ID + " (Field Agent)");

                // ========== PART 1: NAVIGATE TO SCHEDULING ==========

                Thread.sleep(4000);
                schedulingPage = dashboardPage.doClickScheduling();
                Thread.sleep(2000);

                // Select filters and site
                schedulingPage.clickOnFilters();
                schedulingPage.clickOnServiceTypeCheckbox();
                schedulingPage.selectSiteAndApply(HRManagementConstants.SITE);

                // ========== PART 2: CREATE SHIFT ON SOURCE DATE ==========

                // Create shift on date 16 for field agent 1172
                schedulingPage.addShift(SchedulingConstant.DRAG_SOURCE_DATE);
                schedulingPage.selectAssignShift(SchedulingConstant.ASSIGN_SHIFT);
                Thread.sleep(1000);
                schedulingPage.fillShiftForm(
                                SchedulingConstant.ASSIGN_SHIFT,
                                SchedulingConstant.DRAG_DROP_EMPLOYEE_ID, // Static ID: 1172
                                SchedulingConstant.START_TIME,
                                SchedulingConstant.END_TIME,
                                SchedulingConstant.SCHEDULED_BREAK,
                                SchedulingConstant.ADD_NOTES);

                Thread.sleep(5000); // Wait for modal to close
                System.out.println("✅ Shift created successfully on date " + SchedulingConstant.DRAG_SOURCE_DATE);

                // ========== PART 3: PUBLISH SHIFT ==========

                schedulingPage.clickPublishButton();
                schedulingPage.clickOkButton();
                System.out.println("✅ Shift published successfully");
                Thread.sleep(2000); // Keep this sleep for the next step
                // The instruction had a duplicate print statement here, removed for clarity.

                // ========== PART 4: DRAG SHIFT TO TARGET DATE ==========

                Thread.sleep(3000); // Wait before drag-drop to make it visible
                String shiftTime = SchedulingConstant.START_TIME + " - " + SchedulingConstant.END_TIME;
                schedulingPage.dragShiftToDate(SchedulingConstant.DRAG_SOURCE_DATE, SchedulingConstant.DRAG_TARGET_DATE,
                                shiftTime, SchedulingConstant.DRAG_DROP_EMPLOYEE_ID);

                Thread.sleep(2000); // Wait for shift to move

                // ========== PART 5: VERIFY SHIFT MOVED ==========

                // Verify shift exists on target date
                boolean shiftExistsOnTargetDate = schedulingPage.verifyShiftExistsOnDate(
                                SchedulingConstant.DRAG_TARGET_DATE, shiftTime,
                                SchedulingConstant.DRAG_DROP_EMPLOYEE_ID);
                Assert.assertTrue(shiftExistsOnTargetDate,
                                "Shift should exist on target date " + SchedulingConstant.DRAG_TARGET_DATE);

                System.out.println("🎉 Drag and Drop Shift Test COMPLETED");
        }
}
