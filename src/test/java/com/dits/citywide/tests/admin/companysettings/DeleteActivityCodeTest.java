package com.dits.citywide.tests.admin.companysettings;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.CompanySettingsConstant;
import com.dits.citywide.pages.admin.ActivityCodePage;
import com.dits.citywide.pages.admin.CompanySettingsPage;

public class DeleteActivityCodeTest extends BaseTest {

    private CompanySettingsPage companySettingsPage;
    private ActivityCodePage activityCodePage;

    @BeforeMethod
    public void performLogin() throws InterruptedException {
        // Step 1: Login
        dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
    }

    @Test
    public void deleteActivityCodeTest() throws InterruptedException {
        // Step 2: Navigate to Company Settings
        companySettingsPage = dashboardPage.doClickCompanySettingsTab();

        // Step 3: Click on Activity Code link
        companySettingsPage.clickActivityCodeLink();

        // Step 4: Initialize the ActivityCodePage object
        activityCodePage = new ActivityCodePage(driver);

        // Step 5: Search and delete the Activity Code
        activityCodePage.clickDeleteActivityCodeButton(CompanySettingsConstant.ACTIVITY_CODE_EDIT_NAME);
        activityCodePage.clickConfirmDeleteButton();

        // Step 6: Validate deletion success message
        softAssert.assertEquals(
                activityCodePage.getDeleteSuccessMessage(),
                CompanySettingsConstant.DELETED_ACTIVITY_CODE_SUCCESS_MESSAGE,
                "Delete success message mismatch."
        );

        // Step 7: Validate Activity Code page visibility
        softAssert.assertTrue(activityCodePage.isActivityCodeHeaderVisible(), "Activity Code header is not visible.");
        softAssert.assertTrue(activityCodePage.isAddActivityCodeButtonVisible(), "Add New Code button is not visible.");

        softAssert.assertAll();
    }
}
