package com.dits.citywide.tests.patrol;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;

public class PatrolAgentDeleteIncidentReportsTest extends BaseTest {

    @BeforeMethod
    public void performLogin() throws InterruptedException {
        patrolStartShiftPage = loginPage.doLoginPatrol(prop.getProperty("patrolID"),
                prop.getProperty("employeePassword"));
    }

    @Test
    public void deleteIncidentReportTest() throws InterruptedException {
        // Navigate to Incident Reports page
        Thread.sleep(1000);
        patrolStartShiftPage.handleMessageOfTheWeek();
        fieldAgentIncidentReportsPage = patrolStartShiftPage.clickOnIncidentReportFormLink();

        fieldAgentIncidentReportsPage.searchIncidentReport(prop.getProperty("patrolID"));
        fieldAgentIncidentReportsPage.deleteIncidentReport(prop.getProperty("incidentReportID"));
        softAssert.assertEquals(fieldAgentIncidentReportsPage.isSuccessMessageDisplayed(),
                "Incident deleted successfully.");
        // Optionally, verify no record found after deletion
        // fieldAgentIncidentReportsPage.searchIncidentReport(prop.getProperty("incidentReportID"));
        // softAssert.assertEquals(fieldAgentIncidentReportsPage.getNoRecordFoundMessage(), "Records found");
        softAssert.assertAll();
    }
}
