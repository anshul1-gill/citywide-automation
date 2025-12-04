package com.dits.citywide.tests.patrol;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.FieldAgentConstants;
import com.dits.citywide.constants.HRManagementConstants;
import com.dits.citywide.constants.PatrolAgentConstants;

public class PatrolAgentTeamSupportTest extends BaseTest {

    @BeforeMethod
    public void performLogin() throws InterruptedException {
        patrolStartShiftPage = loginPage.doLoginPatrol(prop.getProperty("patrolID"), prop.getProperty("employeePassword"));
    }

    @Test
    public void teamSupportPatrolAgentTest() throws InterruptedException {
        Thread.sleep(1000);
        patrolStartShiftPage.handleMessageOfTheWeek();
        patrolStartShiftPage.handlePassdownOfTheDay();
        fieldAgentTeamSupportPage = patrolStartShiftPage.clickOnTeamSupportTab();
        fieldAgentTeamSupportPage.clickOnAddNewRequestButton();
        fieldAgentTeamSupportPage.fillOutAndSubmitAbuseRequestForm(HRManagementConstants.SITE,
                FieldAgentConstants.SUBJECT_NAME, FieldAgentConstants.MESSAGE);
        fieldAgentTeamSupportPage.selectAssignedTo(PatrolAgentConstants.ASSIGNED_TO);
        fieldAgentTeamSupportPage.clickOnSaveButton();
    }
}
