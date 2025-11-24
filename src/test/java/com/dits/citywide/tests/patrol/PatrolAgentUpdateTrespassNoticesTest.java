package com.dits.citywide.tests.patrol;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.FieldAgentConstants;
import com.dits.citywide.pages.fieldagent.FieldAgentTrespassNoticesPage;

public class PatrolAgentUpdateTrespassNoticesTest extends BaseTest {

    private FieldAgentTrespassNoticesPage fieldAgentTrespassNoticesPage;

    @BeforeMethod
    public void performLogin() throws InterruptedException {
        patrolStartShiftPage = loginPage.doLoginPatrol(prop.getProperty("patrolID"),
                prop.getProperty("employeePassword"));
    }

    @Test
    public void updateTrespassNoticesTest() throws InterruptedException {
        Thread.sleep(1000);
        patrolStartShiftPage.handleMessageOfTheWeek();
        fieldAgentTrespassNoticesPage = patrolStartShiftPage.clickOnTrespassNoticesFormLink();
        fieldAgentTrespassNoticesPage.searchTrespassNotice(prop.getProperty("patrolID"));
        fieldAgentTrespassNoticesPage.clickOnEditButton(prop.getProperty("trespassNoticesID"));
        fieldAgentTrespassNoticesPage.updateLocationDetails(FieldAgentConstants.UPDATED_TRESPASS_SITE,
                FieldAgentConstants.UPDATED_TRESPASS_DATE_TIME, FieldAgentConstants.UPDATED_TRESPASS_ACTIVITY_CODE,
                FieldAgentConstants.UPDATED_TRESPASS_STREET_NUMBER, FieldAgentConstants.UPDATED_TRESPASS_STREET_NAME,
                FieldAgentConstants.UPDATED_TRESPASS_UNIT_NUMBER, FieldAgentConstants.UPDATED_TRESPASS_CITY,
                FieldAgentConstants.UPDATED_TRESPASS_STATE, FieldAgentConstants.UPDATED_TRESPASS_ZIP);
        softAssert.assertAll();
    }
}
