package com.dits.citywide.tests.patrol;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.FieldAgentConstants;
import com.dits.citywide.pages.fieldagent.FieldAgentParkingCitationPage;

public class PatrolAgentUpdateParkingCitationTest extends BaseTest {

    // Use the FieldAgentParkingCitationPage as returned by the patrolStartShiftPage
    private FieldAgentParkingCitationPage fieldAgentParkingCitationPage;

    @BeforeMethod
    public void performLogin() throws InterruptedException {
        patrolStartShiftPage = loginPage.doLoginPatrol(prop.getProperty("patrolID"),
                prop.getProperty("employeePassword"));
    }

    @Test
    public void updateParkingCitationTest() throws InterruptedException {
        Thread.sleep(1000);
        patrolStartShiftPage.handleMessageOfTheWeek();
        patrolStartShiftPage.handlePassdownOfTheDay();
        fieldAgentParkingCitationPage = patrolStartShiftPage.clickOnParkingCitationFormLink();
        fieldAgentParkingCitationPage.searchParkingCitation(prop.getProperty("patrolID"));
        fieldAgentParkingCitationPage.clickOnEditButton(prop.getProperty("parkingcitationID"));
        softAssert.assertTrue(fieldAgentParkingCitationPage.isEditParkingCitationHeaderDisplayed(),
                "Edit Parking Citation text is not visible");
        fieldAgentParkingCitationPage.updateParkingCitation(FieldAgentConstants.UPDATED_SITE,
                FieldAgentConstants.UPDATE_DATE_TIME, FieldAgentConstants.UPDATE_ACTIVITY_CODE,
                FieldAgentConstants.UPDATE_VIN_NUMBER, FieldAgentConstants.UPDATE_LICENSE_NO,
                FieldAgentConstants.UPDATE_STATE, FieldAgentConstants.UPDATE_EXPIRE_DATE,
                FieldAgentConstants.UPDATE_VEHICLE_COLOR, FieldAgentConstants.UPDATE_YEAR,
                FieldAgentConstants.UPDATE_VEHICLE_MAKE, FieldAgentConstants.UPDATE_VEHICLE_MODEL,
                FieldAgentConstants.UPDATE_VIOLATION, FieldAgentConstants.UPDATE_ADDITIONAL_DETAILS,
                FieldAgentConstants.FILE_PATH);
        softAssert.assertAll();
    }
}