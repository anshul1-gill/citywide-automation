package com.dits.citywide.tests.scheduling;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.HRManagementConstants;
import com.dits.citywide.constants.SchedulingConstant;

public class CopyPasteSchedulingTest extends BaseTest {

        @BeforeMethod
        public void performLogin() throws InterruptedException {
                dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        }

        @Test
        public void copyPasteShiftTest() throws InterruptedException {
                System.out.println("🚀 Starting Copy Paste Shift Test...");
                System.out.println("📅 Source Date: " + SchedulingConstant.COPY_SOURCE_DATE +
                                ", Target Date: " + SchedulingConstant.COPY_TARGET_DATE);
                System.out.println("👤 Employee: " + SchedulingConstant.COPY_PASTE_EMPLOYEE_ID + " (Patrol Agent)");

                // ========== PART 1: CREATE AND PUBLISH SHIFT ON DATE 16 ==========
                Thread.sleep(4000);
                schedulingPage = dashboardPage.doClickScheduling();
                Thread.sleep(2000);

                // Select filters and site
                schedulingPage.clickOnFilters();
                schedulingPage.clickOnServiceTypeCheckbox();
                schedulingPage.selectSiteAndApply(HRManagementConstants.SITE);

                // Create shift on date 16 for patrol agent 1147
                schedulingPage.addShift(SchedulingConstant.COPY_SOURCE_DATE);
                schedulingPage.selectAssignShift(SchedulingConstant.ASSIGN_SHIFT);
                Thread.sleep(1000);
                schedulingPage.fillShiftForm(
                                SchedulingConstant.ASSIGN_SHIFT,
                                SchedulingConstant.COPY_PASTE_EMPLOYEE_ID, // Static ID: 1147
                                SchedulingConstant.START_TIME,
                                SchedulingConstant.END_TIME,
                                SchedulingConstant.SCHEDULED_BREAK,
                                SchedulingConstant.ADD_NOTES);

                // Verify shift created
                softAssert.assertEquals(schedulingPage.getSuccessMessageShiftAdded(),
                                SchedulingConstant.SUCCESS_MESSAGE_ADD_SHIFT);
                System.out.println("✅ Shift created successfully on date " + SchedulingConstant.COPY_SOURCE_DATE);

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

                // ========== PART 2: COPY SHIFT FROM DATE 16 ==========

                // Build shift time string
                String originalTime = SchedulingConstant.START_TIME + " - " + SchedulingConstant.END_TIME;

                System.out.println("🔍 Searching for shift: " + originalTime +
                                " for employee " + SchedulingConstant.COPY_PASTE_EMPLOYEE_ID);

                // Right-click on shift to open context menu
                schedulingPage.rightClickOnShift(originalTime, SchedulingConstant.COPY_PASTE_EMPLOYEE_ID);

                // Click "Copy" from context menu
                schedulingPage.clickCopyFromContextMenu();
                System.out.println("✅ Copied shift from date " + SchedulingConstant.COPY_SOURCE_DATE);

                Thread.sleep(1000);

                // ========== PART 3: PASTE SHIFT TO DATE 18 ==========

                // PART 3: PASTE TO TARGET DATE (DYNAMIC)

                // Right-click on target date to open context menu
                schedulingPage.rightClickOnDateForPaste(SchedulingConstant.COPY_TARGET_DATE);

                // Click "Paste" from context menu
                schedulingPage.clickPasteFromContextMenu();
                System.out.println("✅ Pasted shift to date " + SchedulingConstant.COPY_TARGET_DATE);

                Thread.sleep(2000); // Wait for shift to appear

                // ========== PART 4: VERIFY SHIFT ON NEW DATE ==========

                // Verify shift exists on target date
                boolean shiftExists = schedulingPage.verifyShiftExistsOnDate(
                                SchedulingConstant.COPY_TARGET_DATE,
                                originalTime,
                                SchedulingConstant.COPY_PASTE_EMPLOYEE_ID);

                softAssert.assertTrue(shiftExists,
                                "Shift should exist on date " + SchedulingConstant.COPY_TARGET_DATE);

                System.out.println("🎉 Copy Paste Shift Test COMPLETED");
                softAssert.assertAll();
        }

}
