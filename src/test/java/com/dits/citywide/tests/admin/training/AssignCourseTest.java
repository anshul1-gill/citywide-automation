package com.dits.citywide.tests.admin.training;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.HRManagementConstants;
import com.dits.citywide.constants.TrainingConstants;

public class AssignCourseTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test
	public void assignCourseTest() throws InterruptedException {
		trainingPage = dashboardPage.clickOnTrainingTab();
		totalCoursesPage = trainingPage.clickOnTotalCourses();
		softAssert.assertEquals(totalCoursesPage.getHeadingCourses(), "Courses", "Heading Courses is not visible");

		totalCoursesPage.doClickAssignCourses(TrainingConstants.COURSE_NAME);
		softAssert.assertEquals(totalCoursesPage.getHeadingAssignCourses(), "Course Assign",
				"Heading Assign Course is not visible");
		totalCoursesPage.fillCouseAssignForm(HRManagementConstants.ROLE_FIELD, prop.getProperty("employeeID")+" ",
				TrainingConstants.SELECTED_COURSE_PURPOSE);
		totalCoursesPage.doClickSaveAssignCourse();
		softAssert.assertEquals(totalCoursesPage.getSuccessMessage(), TrainingConstants.ASSIGN_COURSE_SUCCESS_MESSAGE,
				"Assign Course success message is not displayed");
		softAssert.assertTrue(totalCoursesPage.getEmployeeIdForAssignedTo().contains(prop.getProperty("employeeID")),
				"Assigned course is not displayed in the Assigned Courses table");

		softAssert.assertAll();
	}

}
