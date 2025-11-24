package com.dits.citywide.tests.admin.companysettings;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.CompanySettingsConstant;
import com.dits.citywide.pages.admin.AssignmentTemplatePage;

public class AddAssignmentTemplateTest extends BaseTest {

    private AssignmentTemplatePage assignmentTemplatePage;

    @BeforeMethod
    public void performLogin() throws InterruptedException {
        dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
    }

    @Test
    public void addAssignmentTemplateTest() throws InterruptedException {
        // Step 1: Navigate to Company Settings → Assignment Templates
        companySettingsPage = dashboardPage.doClickCompanySettingsTab();
        assignmentTemplatePage = companySettingsPage.clickAssignmentTemplateLink();

        // Step 2: Create new assignment template using constants
        assignmentTemplatePage.createNewAssignmentTemplate(
        		CompanySettingsConstant.ASSIGNMENT_TEMPLATE_NAME,
        		CompanySettingsConstant.ASSIGNMENT_ACTIVITY_CODE,
//        		CompanySettingsConstant.BRANCH_NAME,
        		CompanySettingsConstant.ASSIGNMENT_QUESTION_TYPE,
        		CompanySettingsConstant.ASSIGNMENT_QUESTION_TEXT,
        		CompanySettingsConstant.DESCRIPTION_TEXT
        );

        // Step 3: Verify page elements and success conditions (basic checks)
        softAssert.assertTrue(assignmentTemplatePage.isAssignmentTemplateHeaderVisible(),
                "Assignment Templates header is not visible.");

 
        softAssert.assertAll();
    }
}
