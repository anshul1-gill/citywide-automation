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
		// Basic Info
		totalCoursesPage.fillBasicInfo(TrainingConstants.COURSE_NAME, TrainingConstants.CERTIFICATE,
				TrainingConstants.CATEGORY, TrainingConstants.PAYMENT_TYPE, TrainingConstants.ASSIGNMENT_DURATION,
				TrainingConstants.DEADLINE_TYPE, TrainingConstants.COMPLITION_DEADLINE,
				TrainingConstants.COURSE_DESCRIPTION, TrainingConstants.ASSESSMENT, TrainingConstants.INSTRUCTOR,
				TrainingConstants.INSTRUCTOR_NAME, TrainingConstants.COURSE_EVALUATOR,
				TrainingConstants.REQUIRES_COURSE_COMPLETION_TO_SCHEDULE);
		totalCoursesPage.clickOnSaveCourse();
		softAssert.assertTrue(totalCoursesPage.isUpdateCourseHeadingDisplayed(),
				"Update Course heading is not displayed after saving the course");
		// Module
		totalCoursesPage.clickOnModuleTab();
		totalCoursesPage.clickOnAddNewModule();
		totalCoursesPage.fillModuleDetails(TrainingConstants.MODULE_NAME, TrainingConstants.MODULE_DURATION,
				TrainingConstants.MODULE_CONTENT, TrainingConstants.MODULE_FILE_PATH,
				TrainingConstants.MODULE_FILE_NAME);
		totalCoursesPage.clickOnSaveModule();
		softAssert.assertEquals(totalCoursesPage.getSuccessMessage(), TrainingConstants.MODULE_ADDED_SUCCESS_MESSAGE,
				"Module added success message is not displayed");

		// Assessment
		totalCoursesPage.clickOnTabAssessments();
		totalCoursesPage.clickOnAddNewAssessment();
		totalCoursesPage.fillAssessmentDetails(TrainingConstants.ASSESSMENT_NAME, TrainingConstants.ASSESSMENT_DURATION,
				TrainingConstants.ASSESSMENT_MODULE, TrainingConstants.ASSESSMENT_REMARKS,
				TrainingConstants.ASSESSMENT_TOTAL_POINTS, TrainingConstants.ASSESSMENT_MINIMUM_POINTS,
				TrainingConstants.METHOD_OF_ASSESSMENT);
		totalCoursesPage.clickOnSaveAssessment();
		softAssert.assertEquals(totalCoursesPage.getSuccessMessage(),
				TrainingConstants.ASSESSMENT_CREATED_SUCCESS_MESSAGE,
				"Assessment created success message is not displayed");

		softAssert.assertTrue(totalCoursesPage.isAddQuestionButtonDisplayed(),
				"Add Question button is not displayed in the Assessments tab");
		totalCoursesPage.clickOnAddQuestion();
		softAssert.assertTrue(totalCoursesPage.isQuestionnaireTypeHeadingDisplayed(),
				"Questionnaire Type heading is not displayed after clicking on Add Question");
		Thread.sleep(1000);
		totalCoursesPage.fillQuestionDetails(TrainingConstants.QUESTIONNAIRE_TYPE, TrainingConstants.QUESTION_SCORE,
				TrainingConstants.ENTER_QUESTION_1, TrainingConstants.ENTER_PREDEFINED_ANSWER_1);
		totalCoursesPage.clickOnNext();
		totalCoursesPage.clickOnSubmitQuestion();
		softAssert.assertEquals(totalCoursesPage.getSuccessMessage(), TrainingConstants.QUESTION_ADDED_SUCCESS_MESSAGE,
				"Question added success message is not displayed");

//		softAssert.assertTrue(totalCoursesPage.isQuestionnaireTypeHeadingDisplayed(),
//				"Questionnaire Type heading is not displayed after clicking on Add Question");
//		totalCoursesPage.fillQuestionDetails(TrainingConstants.QUESTIONNAIRE_TYPE, TrainingConstants.QUESTION_SCORE,
//				TrainingConstants.ENTER_QUESTION_2, TrainingConstants.ENTER_PREDEFINED_ANSWER_2);
//		totalCoursesPage.clickOnNext();
//		totalCoursesPage.clickOnSubmitQuestion();
//		softAssert.assertEquals(totalCoursesPage.getSuccessMessage(), TrainingConstants.QUESTION_ADDED_SUCCESS_MESSAGE,
//				"Question added success message is not displayed");
//		totalCoursesPage.clickOnAllAssessments();

		softAssert.assertTrue(totalCoursesPage.isCourseOverviewTabDisplayed(),
				"Course Overview tab is not displayed after adding the assessment");
		// Course Overview
		totalCoursesPage.clickOnTabCourseOverview();
		totalCoursesPage.clickOnPublishCourse();
		totalCoursesPage.clickOnOk();
		softAssert.assertEquals(totalCoursesPage.getSuccessMessage(),
				TrainingConstants.COURSE_PUBLISHED_SUCCESS_MESSAGE,
				"Course published success message is not displayed");

		softAssert.assertAll();
	}

}
