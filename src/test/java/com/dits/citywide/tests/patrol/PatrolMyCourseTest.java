package com.dits.citywide.tests.patrol;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.HRManagementConstants;

public class PatrolMyCourseTest extends BaseTest {

    @BeforeMethod
    public void performLogin() throws InterruptedException {
        patrolStartShiftPage = loginPage.doLoginPatrol(prop.getProperty("patrolID"),
                prop.getProperty("employeePassword"));
    }

    @Test
    public void verifyMyCoursesPatrolTest() throws InterruptedException {
        patrolStartShiftPage.handleMessageOfTheWeek();
        Thread.sleep(5000);
        patrolStartShiftPage.clickOnHRManagementMenu();
        fieldAgentMyCoursesPage = patrolStartShiftPage.clickOnMyCoursesTab();
        softAssert.assertEquals(fieldAgentMyCoursesPage.getHeadingMyCourses(), "My Courses",
                "Heading of My Courses page is not as expected for Patrol agent");
        softAssert.assertEquals(fieldAgentMyCoursesPage.getCourseNameData(HRManagementConstants.COURSE_NAME),
                HRManagementConstants.COURSE_NAME, "Course name does not match for Patrol agent");
        softAssert.assertAll();
    }
}
