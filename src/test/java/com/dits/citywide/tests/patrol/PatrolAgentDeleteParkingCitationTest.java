package com.dits.citywide.tests.patrol;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;

public class PatrolAgentDeleteParkingCitationTest extends BaseTest {

    @BeforeMethod
    public void performLogin() throws InterruptedException {
        patrolStartShiftPage = loginPage.doLoginPatrol(prop.getProperty("patrolID"),
                prop.getProperty("employeePassword"));
    }

    @Test
    public void deleteParkingCitationTest() throws InterruptedException {
        Thread.sleep(1000);
        patrolStartShiftPage.handleMessageOfTheWeek();
        fieldAgentParkingCitationPage = patrolStartShiftPage.clickOnParkingCitationFormLink();
        fieldAgentParkingCitationPage.searchParkingCitation(prop.getProperty("patrolID"));
        fieldAgentParkingCitationPage.deleteParkingCitation(prop.getProperty("parkingcitationID"));
        softAssert.assertTrue(fieldAgentParkingCitationPage.isDeleteSuccessMessageDisplayed(),
                "Citation deleted successfully.");
        softAssert.assertAll();
    }
}
