package com.dits.citywide.tests.admin.companysettings;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.CompanySettingsConstant;
import com.dits.citywide.pages.admin.CompanySettingsPage;
import com.dits.citywide.pages.admin.ServiceTypePage;

public class AddServiceTypeTest extends BaseTest {

    private CompanySettingsPage companySettingsPage;
    private ServiceTypePage serviceTypePage;

    @BeforeMethod
    public void performLogin() throws InterruptedException {
        // Step 1: Login into the system
        dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
    }

    @Test
    public void addServiceTypeTest() throws InterruptedException {
        // Step 2: Navigate to Company Settings
        companySettingsPage = dashboardPage.doClickCompanySettingsTab();

        // Step 3: Click on Service Type link
        companySettingsPage.clickServiceTypeLink();

        // Step 4: Initialize ServiceTypePage
        serviceTypePage = new ServiceTypePage(driver);

        // Step 5: Click Add New Service button
        serviceTypePage.clickAddServiceTypeButton();

        // Step 6: Fill Add Service Type form
        serviceTypePage.fillAddServiceTypeForm(
                CompanySettingsConstant.SERVICE_TYPE_NAME,
                CompanySettingsConstant.SERVICE_TYPE_CODE,
                CompanySettingsConstant.SERVICE_TYPE_DESCRIPTION
        );

        // Step 6a: Select dropdown values
        serviceTypePage.selectServiceStatus(CompanySettingsConstant.STATUS_YES);
        serviceTypePage.selectMainService(CompanySettingsConstant.SERVICE_MOBILE_MULTIPLE_SITES);
        serviceTypePage.selectDepartment(CompanySettingsConstant.DEPT_ADMIN);

        // Step 7: Submit the form
        serviceTypePage.clickSubmitServiceTypeButton();

        // Step 8: Verify success message
        softAssert.assertEquals(
                serviceTypePage.getAddSuccessMessage().trim(),
                "Information Saved Successfully.",
                "Success message does not match expected text."
        );

        softAssert.assertAll();
    }
}