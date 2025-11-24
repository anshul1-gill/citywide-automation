package com.dits.citywide.tests.patrol;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.HRManagementConstants;

public class PatrolAgentMyAttendanceTest extends BaseTest {

    @BeforeMethod
    public void performLogin() throws InterruptedException {
        patrolStartShiftPage = loginPage.doLoginPatrol(prop.getProperty("patrolID"),
                prop.getProperty("employeePassword"));
    }

    @Test
    public void myAttendancePatrolAgentTest_dynamic() throws InterruptedException {
        patrolStartShiftPage.clickOnHRManagementMenu();
        fieldAgentMyAttendancePage = patrolStartShiftPage.clickOnMyAttendanceTab();
        String shiftStart = fieldAgentMyAttendancePage.getDataShiftStart();
        String checkIn = fieldAgentMyAttendancePage.getDataCheckIn();
        String shiftEnd = fieldAgentMyAttendancePage.getDataShiftEnd();
        String checkOut = fieldAgentMyAttendancePage.getDataCheckOut();
        String shiftHours = fieldAgentMyAttendancePage.getDataShiftHours();
        String breakDuration = fieldAgentMyAttendancePage.getDataBreakDuration();
        String actualBreak = fieldAgentMyAttendancePage.getDataActualBreak();
        String totalHours = fieldAgentMyAttendancePage.getDataTotalHours();
        String status = fieldAgentMyAttendancePage.getDataStatus();
        String branchName = fieldAgentMyAttendancePage.getDataBranchName();
        String siteOrBeat = fieldAgentMyAttendancePage.getDataSiteOrBeat();

        // Print what is being checked
        System.out.println("--- PatrolAgent Attendance Module Checks ---");
        System.out.println("Branch Name: " + branchName);
        System.out.println("Site/Beat: " + siteOrBeat);
        System.out.println("Shift Start: " + shiftStart);
        System.out.println("Check In: " + checkIn);
        System.out.println("Shift End: " + shiftEnd);
        System.out.println("Check Out: " + checkOut);
        System.out.println("Shift Hours: " + shiftHours);
        System.out.println("Break Duration: " + breakDuration);
        System.out.println("Actual Break: " + actualBreak);
        System.out.println("Total Hours: " + totalHours);
        System.out.println("Status: " + status);
        System.out.println("-------------------------------------------");

        // Assertions for patrol agent attendance data (dynamic)
        softAssert.assertTrue(branchName.contains(HRManagementConstants.BRANCHES), "Branch name does not match");
        softAssert.assertTrue(siteOrBeat.contains(HRManagementConstants.PATROL_SITE) || siteOrBeat.contains(HRManagementConstants.BEAT), "Site/Beat does not match patrol expected values");
        softAssert.assertFalse(shiftStart.isEmpty(), "Shift start time should not be empty");
        softAssert.assertFalse(checkIn.isEmpty(), "Check-in time should not be empty");
        softAssert.assertFalse(shiftEnd.isEmpty(), "Shift end time should not be empty");
        softAssert.assertFalse(checkOut.isEmpty(), "Check-out time should not be empty");
        softAssert.assertFalse(shiftHours.isEmpty(), "Shift hours should not be empty");
        softAssert.assertFalse(breakDuration.isEmpty(), "Break duration should not be empty");
        softAssert.assertFalse(actualBreak.isEmpty(), "Actual break should not be empty");
        softAssert.assertFalse(totalHours.isEmpty(), "Total hours should not be empty");
        softAssert.assertFalse(status.isEmpty(), "Status should not be empty");
        softAssert.assertAll();
    }
}