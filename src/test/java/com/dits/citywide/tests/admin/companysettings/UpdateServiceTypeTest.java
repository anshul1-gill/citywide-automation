package com.dits.citywide.tests.admin.companysettings;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.CompanySettingsConstant;
import com.dits.citywide.pages.admin.CompanySettingsPage;
import com.dits.citywide.pages.admin.ServiceTypePage;

public class UpdateServiceTypeTest extends BaseTest {

    private CompanySettingsPage companySettingsPage;
    private ServiceTypePage serviceTypePage;

    @BeforeMethod
    public void performLogin() throws InterruptedException {
        // Step 1: Login into the system
        dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
    }

    @Test
    public void updateServiceTypeTest() throws InterruptedException {
        // Step 2: Navigate to Company Settings
        companySettingsPage = dashboardPage.doClickCompanySettingsTab();

        // Step 3: Click on Service Type link
        companySettingsPage.clickServiceTypeLink();

        // Step 4: Initialize ServiceTypePage
        serviceTypePage = new ServiceTypePage(driver);

        // Step 5: Click Edit button for a specific Service Type
        serviceTypePage.clickEditServiceTypeButton(CompanySettingsConstant.SERVICE_TYPE_NAME);

        // Step 6: Update form fields
        serviceTypePage.updateServiceType(
                CompanySettingsConstant.SERVICE_TYPE_EDIT_NAME,
                CompanySettingsConstant.SERVICE_TYPE_EDIT_DESCRIPTION
        );

        // Step 6a: Update dropdowns if applicable
        serviceTypePage.selectServiceStatus(CompanySettingsConstant.STATUS_YES);
        serviceTypePage.selectMainService(CompanySettingsConstant.SERVICE_MOBILE_MULTIPLE_SITES);
        serviceTypePage.selectDepartment(CompanySettingsConstant.DEPT_ADMIN);

        // Step 7: Click Update button
        serviceTypePage.clickUpdateServiceTypeButton();

        // Step 8: Validate success message
        softAssert.assertEquals(
                serviceTypePage.getUpdateSuccessMessage().trim(),
                "Information Updated Successfully.",
                "Update success message does not match expected text."
        );

        // Step 9: Validate updated values on UI table (optional)

        softAssert.assertAll();
    }
}
