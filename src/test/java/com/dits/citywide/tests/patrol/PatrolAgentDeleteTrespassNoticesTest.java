package com.dits.citywide.tests.patrol;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;

public class PatrolAgentDeleteTrespassNoticesTest extends BaseTest {

    @BeforeMethod
    public void performLogin() throws InterruptedException {
        patrolStartShiftPage = loginPage.doLoginPatrol(prop.getProperty("patrolID"),
                prop.getProperty("employeePassword"));
    }

    @Test
    public void deleteTrespassNoticesPatrolAgentTest() throws InterruptedException {
        Thread.sleep(1000);
        patrolStartShiftPage.handleMessageOfTheWeek();
        fieldAgentTrespassNoticesPage = patrolStartShiftPage.clickOnTrespassNoticesFormLink();

        fieldAgentTrespassNoticesPage.searchTrespassNotice(prop.getProperty("patrolID"));
        fieldAgentTrespassNoticesPage.deleteParkingCitation(prop.getProperty("trespassNoticesID"));
        softAssert.assertEquals(fieldAgentTrespassNoticesPage.isSuccessMessageDisplayed(),
                "Notice deleted successfully.");

        fieldAgentTrespassNoticesPage.searchTrespassNoticeID(prop.getProperty("parkingcitationID"));
        softAssert.assertEquals(fieldAgentTrespassNoticesPage.getNoRecordFoundMessage(), "Records found");

        softAssert.assertAll();
    }
}
