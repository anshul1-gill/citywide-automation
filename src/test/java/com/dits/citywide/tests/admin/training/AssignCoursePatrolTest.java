package com.dits.citywide.tests.admin.training;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.HRManagementConstants;
import com.dits.citywide.constants.TrainingConstants;

public class AssignCoursePatrolTest extends BaseTest {

    @BeforeMethod
    public void performLogin() throws InterruptedException {
        dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
    }

    @Test
    public void assignCoursePatrolTest() throws InterruptedException {
        trainingPage = dashboardPage.clickOnTrainingTab();
        totalCoursesPage = trainingPage.clickOnTotalCourses();
        softAssert.assertEquals(totalCoursesPage.getHeadingCourses(), "Courses", "Heading Courses is not visible");

        totalCoursesPage.doClickAssignCourses(TrainingConstants.COURSE_NAME);
        softAssert.assertEquals(totalCoursesPage.getHeadingAssignCourses(), "Course Assign", "Heading Assign Course is not visible");

        totalCoursesPage.fillCouseAssignForm(HRManagementConstants.ROLE_PATROL, prop.getProperty("patrolID") + " ", TrainingConstants.SELECTED_COURSE_PURPOSE);
        totalCoursesPage.doClickSaveAssignCourse();

        softAssert.assertEquals(totalCoursesPage.getSuccessMessage(), TrainingConstants.ASSIGN_COURSE_SUCCESS_MESSAGE, "Assign Course success message is not displayed");
        // Use robust wait helper for dynamic assignment rendering
        softAssert.assertTrue(totalCoursesPage.waitForAgentAssignment(prop.getProperty("patrolID"), 15), "Assigned course is not displayed for Patrol ID in the Assigned Courses table");

        softAssert.assertAll();
    }
}