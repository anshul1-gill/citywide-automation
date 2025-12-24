package com.dits.citywide.tests.patrol;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.OperationsHubConstant;
import com.dits.citywide.pages.patrol.PatrolStartShiftPage;

public class PatrolAgentAddPatrolLogsForCallTest extends BaseTest {
    private PatrolStartShiftPage patrolAgentStartShiftPage;

    @BeforeMethod
    public void performLogin() throws InterruptedException {
        patrolAgentStartShiftPage = loginPage.doLoginPatrol(prop.getProperty("patrolID"),
                prop.getProperty("employeePassword"));
    }

    @Test
    public void addPatrolLogsForCallTest() throws InterruptedException {
        patrolStartShiftPage.handleMessageOfTheWeek();
        patrolStartShiftPage.handlePassdownOfTheDay();
        Thread.sleep(2000);
        fieldAgentCallsPage = patrolAgentStartShiftPage.doClickCallsTab();
        fieldAgentCallsPage.doClickAddPatrolLogsForCall(prop.getProperty("callid"));
        fieldAgentCallsPage.fillNewOfficerReportEntry(
                OperationsHubConstant.STREET_NUMBER,
                OperationsHubConstant.STREET_NAME,
                OperationsHubConstant.APARTMENT_NUMBER,
                OperationsHubConstant.CITY,
                OperationsHubConstant.STATE,
                OperationsHubConstant.ZIP_CODE,
                OperationsHubConstant.DESCRIPTION,
                OperationsHubConstant.REPORT_PHOTO_VIDEO_LINK,
                OperationsHubConstant.FILE_NAME,
                OperationsHubConstant.FILE_DESCRIPTION
        );
//        softAssert.assertTrue(fieldAgentCallsPage.isAreYouSureTextVisible());
//        softAssert.assertEquals(fieldAgentCallsPage.getConfirmationText(),
//                OperationsHubConstant.REPORT_CONFRIMATION_MESSAGE);
//        fieldAgentCallsPage.doClickOk();

        softAssert.assertAll();
    }

}