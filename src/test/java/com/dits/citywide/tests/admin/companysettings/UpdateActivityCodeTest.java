package com.dits.citywide.tests.admin.companysettings;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.CompanySettingsConstant;
import com.dits.citywide.pages.admin.ActivityCodePage;
import com.dits.citywide.pages.admin.CompanySettingsPage;

public class UpdateActivityCodeTest extends BaseTest {

    private CompanySettingsPage companySettingsPage;
    private ActivityCodePage activityCodePage;

    @BeforeMethod
    public void performLogin() throws InterruptedException {
        // Step 1: Login into the system
        dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
    }

    @Test
    public void updateActivityCodeTest() throws InterruptedException {
        // Step 2: Navigate to Company Settings
        companySettingsPage = dashboardPage.doClickCompanySettingsTab();

        // Step 3: Click on Activity Code link
        companySettingsPage.clickActivityCodeLink();

        // Step 4: Initialize the ActivityCodePage
        activityCodePage = new ActivityCodePage(driver);

        // Step 5: Click Edit button for a specific Activity Code
        activityCodePage.clickEditActivityCodeButton(CompanySettingsConstant.ACTIVITY_CODE_NAMES);

        // Step 6: Update the Activity Code form
        activityCodePage.updateActivityCode(
                CompanySettingsConstant.ACTIVITY_CODE_EDIT_NAME,
                CompanySettingsConstant.ACTIVITY_CODE_EDIT_DESCRIPTION,
                CompanySettingsConstant.ACTIVITY_CODE_EDIT_PRIORITY
        );

        // Step 7: Click the Update button
        activityCodePage.clickUpdateActivityCodeButton();


        softAssert.assertEquals(
                activityCodePage.getAddedCodeName(),
                CompanySettingsConstant.ACTIVITY_CODE_EDIT_NAME,
                "Updated Activity Code Name does not match."
        );

        softAssert.assertEquals(
                activityCodePage.getAddedDescription(),
                CompanySettingsConstant.ACTIVITY_CODE_EDIT_DESCRIPTION,
                "Updated Activity Code Description does not match."
        );

        softAssert.assertEquals(
                activityCodePage.getAddedPriority(),
                CompanySettingsConstant.ACTIVITY_CODE_EDIT_PRIORITY,
                "Updated Activity Code Priority does not match."
        );

        // Updated success message assertion
        softAssert.assertEquals(
                activityCodePage.getUpdateSuccessMessage().trim(),
                "Information Updated Successfully.",
                "Update success message does not match expected text."
        );

        softAssert.assertAll();
    }
}
