package com.dits.citywide.tests.patrol;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.TrainingConstants;

public class PatrolAgentMyCoursesViewAndAssessmentTest extends BaseTest {

    @BeforeMethod
    public void performLogin() throws InterruptedException {
        patrolStartShiftPage = loginPage.doLoginPatrol(prop.getProperty("patrolID"),
                prop.getProperty("employeePassword"));
    }

    @Test
    public void viewAndAssessmentMyCoursesPatrolTest() throws InterruptedException {
        patrolStartShiftPage.clickOnHRManagementMenu();
        fieldAgentMyCoursesPage = patrolStartShiftPage.clickOnMyCoursesTab();
        softAssert.assertEquals(fieldAgentMyCoursesPage.getHeadingMyCourses(), "My Courses",
                "Heading of My Courses page is not as expected");

        fieldAgentMyCoursesPage.clickViewCourseByName(TrainingConstants.COURSE_NAME);
        fieldAgentMyCoursesPage.clickStartReading();
        fieldAgentMyCoursesPage.clickMarkAsComplete();
        fieldAgentMyCoursesPage.clickOk();
        fieldAgentMyCoursesPage.clickAssessment();
        fieldAgentMyCoursesPage.clickButtonThatOpensNewTab();

        String instructionText = fieldAgentMyCoursesPage.getInstructionForOnlineAssessment();
        softAssert.assertEquals(instructionText, "Instruction for Online Assessment",
                "Instruction text is not as expected");
        softAssert.assertTrue(fieldAgentMyCoursesPage.isStartAssessmentButtonDisplayed(),
                "Start Assessment button is not displayed");
        fieldAgentMyCoursesPage.clickStartAssessment();
        fieldAgentMyCoursesPage.clickOk();
        softAssert.assertEquals(fieldAgentMyCoursesPage.getAssessmentStartedSuccessMessage(),
                TrainingConstants.YOUR_ASSESSMENT_IS_STARTED,
                "Assessment started success message is not as expected");
        fieldAgentMyCoursesPage.enterQuestion(TrainingConstants.ENTER_PREDEFINED_ANSWER_1);
        fieldAgentMyCoursesPage.clickSubmit();
        fieldAgentMyCoursesPage.clickOk();
        softAssert.assertEquals(fieldAgentMyCoursesPage.getAssessmentSubmittedSuccessMessage(),
                TrainingConstants.YOUR_ASSESSMENT_IS_SUBMITTED,
                "Assessment submitted success message is not as expected");
        fieldAgentMyCoursesPage.clickViewYourSubmittedAssessment();
        softAssert.assertEquals(fieldAgentMyCoursesPage.getHeadingAssessmentDetails(), "Assessment Details",
                "Heading of Assessment Details page is not as expected");
        fieldAgentMyCoursesPage.clickBackToCourse();
        softAssert.assertEquals(fieldAgentMyCoursesPage.getCourseStatusByName(TrainingConstants.COURSE_NAME),
                TrainingConstants.COURSE_STATUS_ATTEMPTED, "Course status is not as expected");

        softAssert.assertAll();
    }
}
