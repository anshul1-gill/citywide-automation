package com.dits.citywide.tests.scheduling;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.HRManagementConstants;
import com.dits.citywide.constants.SchedulingConstant;

public class AddShiftAdminTest extends BaseTest {

    @BeforeMethod
    public void performLogin() throws InterruptedException {
        dashboardPage = loginPage.doLogin(
                prop.getProperty("email"),
                prop.getProperty("password"));
    }

    @Test
    public void addShiftAdminTest() throws InterruptedException {

        System.out.println(" Starting Add Shift Admin Test...");
        Thread.sleep(4000);

        // ===============================
        // 1️⃣ Scheduling Page Load
        // ===============================
        schedulingPage = dashboardPage.doClickScheduling();
        System.out.println(" Scheduling page opened");

        captureAndLogPagePerformance("Scheduling Page");

        schedulingPage.selectAgentTypeFilter(SchedulingConstant.AGENT_TYPE_ADMIN);
        System.out.println("Agent type filter selected: " + SchedulingConstant.AGENT_TYPE_ADMIN);

        schedulingPage.clickOnFilters();
        System.out.println(" Filters clicked");

        schedulingPage.clickOnServiceTypeCheckbox();
        System.out.println(" Service type checkbox clicked");

        schedulingPage.selectSiteAndApply(HRManagementConstants.SITE);
        System.out.println(" Site selected: " + HRManagementConstants.SITE);

        // ===============================
        // 2️⃣ Add Shift Modal Load
        // ===============================
        schedulingPage.addShift(SchedulingConstant.ADD_SHIFT_DATE);
        System.out.println(" Add Shift clicked for date: " + SchedulingConstant.ADD_SHIFT_DATE);

        captureAndLogPagePerformance("Add Shift Modal");

        schedulingPage.selectAssignShiftForPetrol(SchedulingConstant.ASSIGN_SHIFT_ADMIN);
        System.out.println("Assign shift selected: " + SchedulingConstant.ASSIGN_SHIFT_ADMIN);

        schedulingPage.fillShiftFormAdmin(
                prop.getProperty("adminID"),
                SchedulingConstant.START_TIME_ADMIN,
                SchedulingConstant.END_TIME_ADMIN,
                SchedulingConstant.SCHEDULED_BREAK_ADMIN,
                SchedulingConstant.ADD_NOTES_ADMIN);
        System.out.println("Admin shift form filled");

        String successMessage = schedulingPage.getSuccessMessageShiftAdded();
        System.out.println(" Success message after add: " + successMessage);

        softAssert.assertEquals(
                successMessage,
                SchedulingConstant.SUCCESS_MESSAGE_ADD_SHIFT);

        // ===============================
        // 3️⃣ Publish Flow Performance
        // ===============================
        schedulingPage.clickPublishButton();
        System.out.println(" Publish button clicked");

        String areYouSure = schedulingPage.getAreYouSureText();
        String confirmText = schedulingPage.getPublishShiftsConfirmationText();

        softAssert.assertEquals(areYouSure, SchedulingConstant.ARE_YOU_SURE);
        softAssert.assertEquals(confirmText, SchedulingConstant.ACTION_WILL_PUBLISH_SHIFTS);

        schedulingPage.clickOkButton();
        System.out.println(" OK clicked");

        captureAndLogPagePerformance("Publish Shift");

        String publishSuccess = schedulingPage.getSuccessMessageAfterPublish();
        System.out.println("Publish success message: " + publishSuccess);

        softAssert.assertEquals(
                publishSuccess,
                SchedulingConstant.SUCCESS_PUBLISH_MESSAGE);

        System.out.println("Test Completed");
        softAssert.assertAll();
    }
}
