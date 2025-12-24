package com.dits.citywide.tests.scheduling;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.HRManagementConstants;
import com.dits.citywide.constants.SchedulingConstant;

public class AddOpenShiftTest extends BaseTest {

    @BeforeMethod
    public void performLogin() throws InterruptedException {
        dashboardPage = loginPage.doLogin(
                prop.getProperty("email"),
                prop.getProperty("password"));
    }

    @Test
    public void addOpenShiftTest() throws InterruptedException {

        System.out.println(" Starting Add Open Shift Test...");
        Thread.sleep(4000);

        // ===============================
        // 1️⃣ Scheduling Page Load & Filter
        // ===============================
        schedulingPage = dashboardPage.doClickScheduling();
        System.out.println(" Scheduling page opened");

        schedulingPage.selectAgentTypeFilter(SchedulingConstant.AGENT_TYPE_STATIONARY);
        schedulingPage.clickOnFilters();
        schedulingPage.clickOnServiceTypeCheckbox();
        schedulingPage.selectSiteAndApply(HRManagementConstants.SITE);
        System.out.println(" Site selected: " + HRManagementConstants.SITE);

        // ===============================
        // 2️⃣ Create Open Shift
        // ===============================
        String shiftDate = SchedulingConstant.ADD_SHIFT_DATE; // 17
        String startTime = SchedulingConstant.START_TIME;
        String endTime = SchedulingConstant.END_TIME;

        schedulingPage.addShift(shiftDate);
        schedulingPage.selectAssignShiftForPetrol(SchedulingConstant.ASSIGN_SHIFT);

        System.out.println(" Filling open shift form...");
        schedulingPage.fillOpenShiftForm(
                startTime,
                endTime,
                SchedulingConstant.SCHEDULED_BREAK,
                "Test open shift (unassigned) - Stationay Agent");

        String addSuccess = schedulingPage.getSuccessMessageShiftAdded();
        System.out.println(" Shift added successfully: " + addSuccess);
        softAssert.assertEquals(addSuccess, SchedulingConstant.SUCCESS_MESSAGE_ADD_SHIFT);

        System.out.println("Test Completed Successfully");
        softAssert.assertAll();
    }
}
