package com.dits.citywide.tests.patrol;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;

public class PatrolAgentDeleteFieldInterviewTest extends BaseTest {

    @BeforeMethod
    public void performLogin() throws InterruptedException {
        patrolStartShiftPage = loginPage.doLoginPatrol(prop.getProperty("patrolID"),
                prop.getProperty("employeePassword"));
    }

    @Test
    public void deleteFieldInterviewTest() throws InterruptedException {
        Thread.sleep(1000);
        patrolStartShiftPage.handleMessageOfTheWeek();
        fieldAgentFieldInterviewPage = patrolStartShiftPage.clickOnFieldInterviewFormLink();

        // Delete the Field Interview by ID
        fieldAgentFieldInterviewPage.deleteFieldInterview(prop.getProperty("fieldInterviewID"));
        softAssert.assertEquals(fieldAgentFieldInterviewPage.getSucessMessage(),
                ("Field Interview deleted successfully."));
        softAssert.assertTrue(fieldAgentFieldInterviewPage.isSearchBoxDisplayed(), "Searchbox Not displayed");
        softAssert.assertAll();
    }
}
