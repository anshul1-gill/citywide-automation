package com.dits.citywide.tests.admin.hrmanagement;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.HRManagementConstants;

public class AttendanceTest extends BaseTest {

	@BeforeMethod
	public void performLogin() {
		dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test
	public void attendanceTest() throws InterruptedException {
		dashboardPage.doClickHRManagement();
		Thread.sleep(5000);
		attendancePage = dashboardPage.doClickAttendance();

		attendancePage.selectDate(HRManagementConstants.ATTENDANCE_DATE);

		attendancePage.selectEmployee(HRManagementConstants.EMPLOYEE_ID);

		softAssert.assertEquals(attendancePage.getDataBranchName(HRManagementConstants.EMPLOYEE_ID),
				HRManagementConstants.BRANCHES, "Branch name does not match");
		softAssert.assertTrue(
				attendancePage.getDataSiteOrBit(HRManagementConstants.EMPLOYEE_ID).contains(HRManagementConstants.SITE),
				"Site or BIT does not match");
		softAssert.assertTrue(attendancePage.getDataEmployeeName(HRManagementConstants.EMPLOYEE_ID)
				.contains(HRManagementConstants.FIRST_NAME), "Employee name does not match");

		softAssert.assertEquals(attendancePage.getDataEmployeeShiftStart(HRManagementConstants.EMPLOYEE_ID),
				HRManagementConstants.SHIFT_START, "Shift start time does not match");
		softAssert.assertEquals(attendancePage.getDataEmployeeCheckIn(HRManagementConstants.EMPLOYEE_ID),
				HRManagementConstants.CHECK_IN, "Check-in time does not match");
		softAssert.assertEquals(attendancePage.getDataEmployeeShiftEnd(HRManagementConstants.EMPLOYEE_ID),
				HRManagementConstants.SHIFT_END, "Shift end time does not match");
		softAssert.assertEquals(attendancePage.getDataEmployeeCheckOut(HRManagementConstants.EMPLOYEE_ID),
				HRManagementConstants.CHECK_OUT, "Check-out time does not match");
		softAssert.assertEquals(attendancePage.getDataEmployeeShiftHours(HRManagementConstants.EMPLOYEE_ID),
				HRManagementConstants.SHIFT_HOURS, "Shift hours do not match");
		softAssert.assertEquals(attendancePage.getDataEmployeeTotalHours(HRManagementConstants.EMPLOYEE_ID),
				HRManagementConstants.TOTAL_HOURS, "Total hours do not match");
		softAssert.assertEquals(attendancePage.getDataEmployeeStatus(HRManagementConstants.EMPLOYEE_ID),
				HRManagementConstants.STATUS, "Employee status does not match");

		softAssert.assertAll();
	}

}