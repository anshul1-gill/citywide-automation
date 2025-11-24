package com.dits.citywide.tests.admin.companysettings;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.CompanySettingsConstant;

public class DeleteAssignmentTemplateTest extends BaseTest {

    @BeforeMethod
    public void performLogin() throws InterruptedException {
        dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
    }

    @Test
    public void deleteAssignmentTemplateTest() throws InterruptedException {
        // Step 1: Navigate to Company Settings
        companySettingsPage = dashboardPage.doClickCompanySettingsTab();

        // Step 2: Open Assignment Template page
        assignmentTemplatePage = companySettingsPage.clickAssignmentTemplateLink();

        // Step 3: Delete the specific Assignment Template
        assignmentTemplatePage.deleteAssignmentTemplate(CompanySettingsConstant.ASSIGNMENT_TEMPLATE_NAME);

        // Step 4: Assertions for verification
//        softAssert.assertTrue(
//                assignmentTemplatePage.isAssignmentTemplateHeaderVisible(),
//                "Assignment Template page header is not visible after deletion."
//        );
//        softAssert.assertAll();
    }
}
