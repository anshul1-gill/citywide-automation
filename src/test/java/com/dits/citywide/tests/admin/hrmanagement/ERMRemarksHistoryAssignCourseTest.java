package com.dits.citywide.tests.admin.hrmanagement;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.HRManagementConstants;

public class ERMRemarksHistoryAssignCourseTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test
	public void assignCourseERMTest() throws InterruptedException {
		dashboardPage.doClickHRManagement();
		Thread.sleep(6000);
		ermPage = dashboardPage.doClickERM();
		ermRemarksHistoryPage = ermPage.clickRemarksHistory();
		ermRemarksHistoryPage.searchRemarks(prop.getProperty("employeeID"));
		ermRemarksHistoryPage.clickAssignCourse();
		softAssert.assertEquals(ermRemarksHistoryPage.getHeadingCourse(), "Courses");
		ermRemarksHistoryPage.searchCourse(HRManagementConstants.COURSE_NAME);
		ermRemarksHistoryPage.clickAssignCourses();
		softAssert.assertEquals(ermRemarksHistoryPage.getConfirmationMessage(),
				HRManagementConstants.ASSIGNED_COURSE_CONFIRMATION_MESSAGE);
		ermRemarksHistoryPage.clickAssign();
		softAssert.assertEquals(ermRemarksHistoryPage.getSuccessMessage(),
				HRManagementConstants.ASSIGNED_COURSE_SUCCESS_MESSAGE);
		ermRemarksHistoryPage.closePopup();
		softAssert.assertEquals(ermRemarksHistoryPage.getHeadingRemarksHistory(), "Remarks History");
		softAssert.assertAll();
	}

}
