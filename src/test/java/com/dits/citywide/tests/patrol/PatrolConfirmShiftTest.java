package com.dits.citywide.tests.patrol;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.PatrolConstants;
// import com.dits.citywide.constants.SchedulingConstant; // Uncomment if date navigation needed

public class PatrolConfirmShiftTest extends BaseTest {

    @BeforeMethod
    public void performLogin() throws InterruptedException {
        patrolStartShiftPage = loginPage.doLoginPatrol(prop.getProperty("patrolID"),
                prop.getProperty("employeePassword"));
    }

    @Test
    public void confirmPatrolShiftTest() throws InterruptedException {
        Thread.sleep(500); // small stabilization wait
        patrolStartShiftPage.handleMessageOfTheWeek();
        patrolStartShiftPage.handlePassdownOfTheDay();
        // patrolStartShiftPage.viewShiftDetails(SchedulingConstant.ADD_SHIFT_DATE); // If required to expose Confirm button

        softAssert.assertTrue(patrolStartShiftPage.isConfirmShiftButtonVisible(), "Confirm Shift button should be visible");
        patrolStartShiftPage.doClickConfirmShift();
        patrolStartShiftPage.doSelectCheckbox();
        patrolStartShiftPage.doClickConfirmShiftbutton();
        patrolStartShiftPage.doClickOkButton();

        softAssert.assertEquals(patrolStartShiftPage.getSuccessMessage().trim(),
                PatrolConstants.SUCCESS_MESSAGE_CONFIRM_SHIFT,
                "Success message does not match after confirming patrol shift.");

        softAssert.assertAll();
    }
}
