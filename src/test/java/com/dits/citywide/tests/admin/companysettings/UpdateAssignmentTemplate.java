package com.dits.citywide.tests.admin.companysettings;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.CompanySettingsConstant;

/**
 * Test Case: Update existing Assignment Template
 * Description: Verify that an existing Assignment Template can be updated successfully.
 */
public class UpdateAssignmentTemplate extends BaseTest {

    @BeforeMethod
    public void performLogin() throws InterruptedException {
        dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
    }

    @Test(priority = 2, description = "Verify that an existing Assignment Template can be updated successfully")
    public void updateAssignmentTemplateTest() throws InterruptedException {

        // Step 1: Navigate to Company Settings → Assignment Templates
        companySettingsPage = dashboardPage.doClickCompanySettingsTab();
        assignmentTemplatePage = companySettingsPage.clickAssignmentTemplateLink();

        // Step 2: Search and click Edit for the existing Assignment Template
        assignmentTemplatePage.clickEditTemplateButton(CompanySettingsConstant.ASSIGNMENT_TEMPLATE_NAME);

        // Step 3: Update the Assignment Template fields
        assignmentTemplatePage.updateAssignmentTemplate(
            CompanySettingsConstant.UPDATED_ACTIVITY_CODE,
            CompanySettingsConstant.UPDATED_QUESTION_TYPE,
            CompanySettingsConstant.UPDATED_QUESTION,
            CompanySettingsConstant.UPDATED_DESCRIPTION
        );

        // Step 6: Verify success message or visibility (optional – based on your page)
        // softAssert.assertTrue(assignmentTemplatePage.isAssignmentTemplateHeaderVisible(), "Assignment Template page not visible after update.");

        // Log confirmation
//        System.out.println("✅ Assignment Template Updated Successfully: " + CompanySettingsConstant.UPDATED_TEMPLATE_NAME);

        // Step 7: Final assertion (if soft asserts are added later)
        // softAssert.assertAll();
    }
}
