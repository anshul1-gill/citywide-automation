package com.dits.citywide.tests.admin.companysettings;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.CompanySettingsConstant;
import com.dits.citywide.pages.admin.ActivityCodePage;
import com.dits.citywide.pages.admin.CompanySettingsPage;

public class AddActivityCodeTest extends BaseTest {

    private CompanySettingsPage companySettingsPage;
    private ActivityCodePage activityCodePage;

    @BeforeMethod
    public void performLogin() throws InterruptedException {
        // Step 1: Login into the system
        dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
    }

    @Test
    public void addActivityCodeTest() throws InterruptedException {
        // Step 2: Navigate to Company Settings
        companySettingsPage = dashboardPage.doClickCompanySettingsTab();

        // Step 3: Click on Activity Code link
        companySettingsPage.clickActivityCodeLink();

        // Step 4: Initialize ActivityCodePage
        activityCodePage = new ActivityCodePage(driver);

        // Step 5: Click Add New Code button
        activityCodePage.clickAddActivityCodeButton();

        // Step 6: Fill Add Activity Code form
        activityCodePage.fillAddActivityCodeForm(
                CompanySettingsConstant.ACTIVITY_CODE_NAMES,
                CompanySettingsConstant.ACTIVITY_CODE_DESCRIPTION,
                CompanySettingsConstant.ACTIVITY_CODE_PRIORITY
        );

        // Step 7: Submit the form
        activityCodePage.clickSubmitActivityCodeButton();
        
        activityCodePage.searchActivityCode(CompanySettingsConstant.ACTIVITY_CODE_NAMES);

        softAssert.assertEquals(
                activityCodePage.getAddSuccessMessage().trim(),
                "Information Saved Successfully.",
                "Success message does not match expected text."
        );

        softAssert.assertAll();
    }
}