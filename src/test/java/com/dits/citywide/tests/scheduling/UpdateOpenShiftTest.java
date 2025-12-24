package com.dits.citywide.tests.scheduling;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.HRManagementConstants;
import com.dits.citywide.constants.SchedulingConstant;

public class UpdateOpenShiftTest extends BaseTest {

    @BeforeMethod
    public void performLogin() throws InterruptedException {
        dashboardPage = loginPage.doLogin(
                prop.getProperty("email"),
                prop.getProperty("password"));
    }

    @Test
    public void updateOpenShiftTest() throws InterruptedException {

        System.out.println(" Starting Update Open Shift Test...");
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
        String shiftTime = startTime + " - " + endTime;

        schedulingPage.addShift(shiftDate);
        schedulingPage.selectAssignShiftForPetrol(SchedulingConstant.ASSIGN_SHIFT);

        System.out.println(" Creating initial open shift...");
        schedulingPage.fillOpenShiftForm(
                startTime,
                endTime,
                SchedulingConstant.SCHEDULED_BREAK,
                "Initial open shift for update test");

        String addSuccess = schedulingPage.getSuccessMessageShiftAdded();
        System.out.println(" Open shift created: " + addSuccess);
        softAssert.assertEquals(addSuccess, SchedulingConstant.SUCCESS_MESSAGE_ADD_SHIFT);

        // ===============================
        // 3️⃣ Update Open Shift -> Assign Employee
        // ===============================
        String employeeID = "1147";
        System.out.println(" Updating open shift to assign employee: " + employeeID);

        schedulingPage.rightClickOnOpenShift(shiftTime);
        schedulingPage.clickUpdateFromContextMenu();

        schedulingPage.selectEmployeeById(employeeID);
        schedulingPage.clickSaveUpdateButton();

        String updateSuccess = schedulingPage.getUpdateSuccessMessage();
        System.out.println(" Shift updated successfully: " + updateSuccess);
        softAssert.assertEquals(updateSuccess, SchedulingConstant.SUCCESS_MESSAGE_UPDATE_SHIFT);

        // ===============================
        // 4️⃣ Publish Shift
        // ===============================
        System.out.println(" Publishing the assigned shift...");
        schedulingPage.clickPublishButton();
        schedulingPage.clickOkButton();

        String publishSuccess = schedulingPage.getSuccessMessageAfterPublish();
        System.out.println(" Shift published successfully: " + publishSuccess);
        softAssert.assertEquals(publishSuccess, SchedulingConstant.SUCCESS_PUBLISH_MESSAGE);

        System.out.println("Test Completed Successfully");
        softAssert.assertAll();
    }
}
