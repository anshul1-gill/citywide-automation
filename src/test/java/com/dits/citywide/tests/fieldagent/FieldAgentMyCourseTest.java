package com.dits.citywide.tests.fieldagent;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.HRManagementConstants;

public class FieldAgentMyCourseTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		fieldAgentStartShiftPage = loginPage.doLoginFieldAgent(prop.getProperty("employeeID"),
				prop.getProperty("employeePassword"));
	}

	@Test
	public void VerifyMyCoursesFieldAgentTest() throws InterruptedException {
		fieldAgentStartShiftPage.handleMessageOfTheWeek();
		Thread.sleep(5000);
		fieldAgentStartShiftPage.clickOnHRManagementMenu();
		fieldAgentMyCoursesPage = fieldAgentStartShiftPage.clickOnMyCoursesTab();
		softAssert.assertEquals(fieldAgentMyCoursesPage.getHeadingMyCourses(), "My Courses",
				"Heading of My Courses page is not as expected");
		fieldAgentMyCoursesPage.getCourseNameData(HRManagementConstants.COURSE_NAME);
		softAssert.assertEquals(fieldAgentMyCoursesPage.getCourseNameData(HRManagementConstants.COURSE_NAME),
				HRManagementConstants.COURSE_NAME, "Course name does not match");
		softAssert.assertAll();
	}

}
