package com.dits.citywide.tests.patrol;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.SchedulingConstant;
import com.dits.citywide.pages.patrol.PatrolStartShiftPage;  
import com.dits.citywide.pages.fieldagent.FieldAgentReportsPage; 

public class PatrolAgentEndShiftTest extends BaseTest {

    private PatrolStartShiftPage patrolStartShiftPage;
    private FieldAgentReportsPage fieldAgentReportsPage;

    @BeforeMethod
    public void performLogin() throws InterruptedException {
        patrolStartShiftPage = loginPage.doLoginPatrol(prop.getProperty("patrolID"),
                prop.getProperty("employeePassword"));
    }

    @Test
    public void endShiftTest() throws InterruptedException {
        Thread.sleep(1000);
//        patrolStartShiftPage.handleMessageOfTheWeek();
//        softAssert.assertTrue(patrolStartShiftPage.isStartBreakButtonVisible(),
//                "Start Break button should be visible");
//        patrolStartShiftPage.doClickStartBreak();
//        Thread.sleep(2000);
//        patrolStartShiftPage.doSelectBreak();
//        Thread.sleep(2000);
//        patrolStartShiftPage.doClickEndBreak();
        patrolStartShiftPage.doClickTabStartShift();
        Thread.sleep(3000);
        patrolStartShiftPage.viewShiftDetails(SchedulingConstant.ADD_SHIFT_DATE);
        softAssert.assertTrue(patrolStartShiftPage.isEndShiftButtonVisible(), "End Shift button should be visible");
        fieldAgentReportsPage = patrolStartShiftPage.doClickEndShift();
        patrolStartShiftPage.doClickOkButton();
        fieldAgentReportsPage.clickEndShift();
        patrolStartShiftPage.doClickOkButton();
        softAssert.assertTrue(fieldAgentReportsPage.isReOpenPatrolLogVisible(),
                "Re-Open Patrol Log button should be visible");
        softAssert.assertAll();
    }
}