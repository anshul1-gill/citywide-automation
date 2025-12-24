package com.dits.citywide.tests.scheduling;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.HRManagementConstants;
import com.dits.citywide.constants.SchedulingConstant;

public class DeleteShiftTest extends BaseTest {

    @BeforeMethod
    public void performLogin() throws InterruptedException {
        dashboardPage = loginPage.doLogin(
                prop.getProperty("email"),
                prop.getProperty("password"));
    }

    @Test
    public void deleteShiftTest() throws InterruptedException {

        System.out.println(" Starting Delete Shift Test...");
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
        // 2️⃣ Create Shift
        // ===============================
        String employeeID = "1116";
        String shiftDate = SchedulingConstant.ADD_SHIFT_DATE; // 17
        String startTime = SchedulingConstant.START_TIME;
        String endTime = SchedulingConstant.END_TIME;
        String shiftTime = startTime + " - " + endTime;

        schedulingPage.addShift(shiftDate);
        schedulingPage.selectAssignShiftForPetrol(SchedulingConstant.ASSIGN_SHIFT);
        schedulingPage.fillShiftFormAdmin(
                employeeID,
                startTime,
                endTime,
                SchedulingConstant.SCHEDULED_BREAK,
                "Test shift for deletion - Employee 1116");

        String addSuccess = schedulingPage.getSuccessMessageShiftAdded();
        System.out.println(" Shift added successfully: " + addSuccess);
        softAssert.assertEquals(addSuccess, SchedulingConstant.SUCCESS_MESSAGE_ADD_SHIFT);

        // ===============================
        // 3️⃣ Publish Shift
        // ===============================
        schedulingPage.clickPublishButton();
        schedulingPage.clickOkButton();

        String publishSuccess = schedulingPage.getSuccessMessageAfterPublish();
        System.out.println(" Shift published successfully: " + publishSuccess);
        softAssert.assertEquals(publishSuccess, SchedulingConstant.SUCCESS_PUBLISH_MESSAGE);

        // ===============================
        // 4️⃣ Delete Shift
        // ===============================
        System.out.println(" Deleting shift for " + employeeID + " at " + shiftTime);
        schedulingPage.deleteShift(shiftTime, employeeID);

        String deleteSuccess = schedulingPage.getDeleteSuccessMessage();
        System.out.println(" Shift deleted successfully message: " + deleteSuccess);
        softAssert.assertEquals(deleteSuccess, SchedulingConstant.SUCCESS_MESSAGE_DELETE_SHIFT);

        // Wait for shift to disappear from UI after deletion
        schedulingPage.waitForShiftInvisibility(shiftTime, employeeID);

        // Final verification that shift is gone
        boolean exists = schedulingPage.verifyShiftExistsOnDate(shiftDate, shiftTime, employeeID);
        softAssert.assertFalse(exists, "Shift should not exist after deletion");

        System.out.println("Test Completed Successfully");
        softAssert.assertAll();
    }
}
