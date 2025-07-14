package com.dits.citywide.tests.admin.training;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.TrainingConstants;

public class AddNewCourseTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test
	public void addNewCourseTest() throws InterruptedException {
		trainingPage = dashboardPage.clickOnTrainingTab();
		totalCoursesPage = trainingPage.clickOnTotalCourses();
		softAssert.assertEquals(totalCoursesPage.getHeadingCourses(), "Courses", "Heading Courses is not visible");
		totalCoursesPage.clickOnAddNewCourse();
		totalCoursesPage.fillBasicInfo(TrainingConstants.COURSE_NAME, TrainingConstants.CERTIFICATE_NAME,
				TrainingConstants.CATEGORY_NAME, TrainingConstants.PAYMENT_TYPE, TrainingConstants.COURSE_DURATION,
				TrainingConstants.COURSE_DURATION_VALUE, TrainingConstants.COURSE_COMPLETION_TIME,
				TrainingConstants.COURSE_COMPLETION_TIME_VALUE, TrainingConstants.COURSE_EXPIRATION_DATE,
				TrainingConstants.COURSE_DESCRIPTION, TrainingConstants.ASSESSMENT, TrainingConstants.INSTRUCTOR,
				TrainingConstants.INSTRUCTOR_NAME, TrainingConstants.COURSE_EVALUATOR,
				TrainingConstants.REQUIRES_COURSE_COMPLETION_TO_SCHEDULE);
		// totalCoursesPage.clickOnSaveCourse();

		softAssert.assertAll();
	}

}
