package com.dits.citywide.tests.patrol;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.PatrolAgentConstants;
import com.dits.citywide.constants.HRManagementConstants;
import com.dits.citywide.constants.OperationsHubConstant;
import com.dits.citywide.pages.patrol.PatrolStartShiftPage;
import com.dits.citywide.pages.patrol.PatrolAgentReportsPage;

public class PatrolAgentMyReportsTest extends BaseTest {
    private PatrolStartShiftPage patrolAgentStartShiftPage;
    private PatrolAgentReportsPage patrolAgentReportsPage;

    @BeforeMethod
    public void performLogin() throws InterruptedException {
        patrolAgentStartShiftPage = loginPage.doLoginPatrol(prop.getProperty("patrolID"),
                prop.getProperty("employeePassword"));
    }

    @Test
    public void myReportsPatrolAgentTest() throws InterruptedException {
        Thread.sleep(1000);
        patrolAgentStartShiftPage.handleMessageOfTheWeek();
        patrolAgentReportsPage = patrolAgentStartShiftPage.clickOnReportsTab();
        
//        softAssert.assertEquals(patrolAgentReportsPage.getArriveDateTime(), prop.getProperty("startShiftDateTime"));
//        softAssert.assertTrue(patrolAgentReportsPage.getSiteName().contains(HRManagementConstants.SITE));
//        String startShift = prop.getProperty("startShiftDateTime");
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");
//        LocalDateTime shiftDateTime = LocalDateTime.parse(startShift, formatter);
//        String expectedDeparture = shiftDateTime.plusMinutes(15).format(formatter);
//        softAssert.assertEquals(patrolAgentReportsPage.getDepartDateTime(), expectedDeparture,
//                "Departure DateTime mismatch!");

        // Add three reports
        patrolAgentReportsPage.clickEditReport2();
        Thread.sleep(2000);
        patrolAgentReportsPage.addOfficerReportEntry(prop.getProperty("url"), HRManagementConstants.SITE,
                OperationsHubConstant.ACTIVITY_CODE, prop.getProperty("callid"), OperationsHubConstant.STREET_NUMBER,
                OperationsHubConstant.STREET_NAME, OperationsHubConstant.APARTMENT_NUMBER, OperationsHubConstant.CITY,
                OperationsHubConstant.STATE, OperationsHubConstant.ZIP_CODE, OperationsHubConstant.DESCRIPTION,
                OperationsHubConstant.REPORT_PHOTO_VIDEO_LINK, OperationsHubConstant.FILE_NAME,
                OperationsHubConstant.FILE_DESCRIPTION);
        patrolAgentReportsPage.clickUpdateLogEntry();
        softAssert.assertTrue(patrolAgentReportsPage.isAllReportsButtonVisible());

        patrolAgentReportsPage.clickEditReport3();
        Thread.sleep(2000);
        patrolAgentReportsPage.addOfficerReportEntry(prop.getProperty("url"), HRManagementConstants.SITE,
                OperationsHubConstant.ACTIVITY_CODE, prop.getProperty("callid"), OperationsHubConstant.STREET_NUMBER,
                OperationsHubConstant.STREET_NAME, OperationsHubConstant.APARTMENT_NUMBER, OperationsHubConstant.CITY,
                OperationsHubConstant.STATE, OperationsHubConstant.ZIP_CODE, OperationsHubConstant.DESCRIPTION,
                OperationsHubConstant.REPORT_PHOTO_VIDEO_LINK, OperationsHubConstant.FILE_NAME,
                OperationsHubConstant.FILE_DESCRIPTION);
        patrolAgentReportsPage.clickUpdateLogEntry();
        softAssert.assertTrue(patrolAgentReportsPage.isAllReportsButtonVisible());

        patrolAgentReportsPage.clickEditReport4();
        Thread.sleep(2000);
        patrolAgentReportsPage.addOfficerReportEntry(prop.getProperty("url"), HRManagementConstants.SITE,
                OperationsHubConstant.ACTIVITY_CODE, prop.getProperty("callid"), OperationsHubConstant.STREET_NUMBER,
                OperationsHubConstant.STREET_NAME, OperationsHubConstant.APARTMENT_NUMBER, OperationsHubConstant.CITY,
                OperationsHubConstant.STATE, OperationsHubConstant.ZIP_CODE, OperationsHubConstant.DESCRIPTION,
                OperationsHubConstant.REPORT_PHOTO_VIDEO_LINK, OperationsHubConstant.FILE_NAME,
                OperationsHubConstant.FILE_DESCRIPTION);
        patrolAgentReportsPage.clickUpdateLogEntry();
        softAssert.assertTrue(patrolAgentReportsPage.isAllReportsButtonVisible());
        
//        patrolAgentReportsPage.clickEditReport5();
//        Thread.sleep(2000);
//        patrolAgentReportsPage.addOfficerReportEntry(prop.getProperty("url"), HRManagementConstants.SITE,
//				OperationsHubConstant.ACTIVITY_CODE, prop.getProperty("callid"), OperationsHubConstant.STREET_NUMBER,
//				OperationsHubConstant.STREET_NAME, OperationsHubConstant.APARTMENT_NUMBER, OperationsHubConstant.CITY,
//				OperationsHubConstant.STATE, OperationsHubConstant.ZIP_CODE, OperationsHubConstant.DESCRIPTION,
//				OperationsHubConstant.REPORT_PHOTO_VIDEO_LINK, OperationsHubConstant.FILE_NAME,
//				OperationsHubConstant.FILE_DESCRIPTION);
//        
//        patrolAgentReportsPage.clickEditReport6();
//        Thread.sleep(2000);
//        patrolAgentReportsPage.addOfficerReportEntry(prop.getProperty("url"), HRManagementConstants.SITE,
//        						OperationsHubConstant.ACTIVITY_CODE, prop.getProperty("callid"), OperationsHubConstant.STREET_NUMBER,
//        						OperationsHubConstant.STREET_NAME, OperationsHubConstant.APARTMENT_NUMBER, OperationsHubConstant.CITY,
//        						OperationsHubConstant.STATE, OperationsHubConstant.ZIP_CODE, OperationsHubConstant.DESCRIPTION,
//								OperationsHubConstant.REPORT_PHOTO_VIDEO_LINK, OperationsHubConstant.FILE_NAME,
//									OperationsHubConstant.FILE_DESCRIPTION);

        patrolAgentReportsPage.clickSubmitReports();
        softAssert.assertEquals(patrolAgentReportsPage.getNoDataFoundText(), PatrolAgentConstants.NO_DATA_FOUND_TEXT,
                "No Data Found text mismatch!");

        softAssert.assertAll();
    }
}