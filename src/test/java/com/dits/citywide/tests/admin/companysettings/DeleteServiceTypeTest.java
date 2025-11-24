package com.dits.citywide.tests.admin.companysettings;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.CompanySettingsConstant;
import com.dits.citywide.pages.admin.CompanySettingsPage;
import com.dits.citywide.pages.admin.ServiceTypePage;

public class DeleteServiceTypeTest extends BaseTest {

    private CompanySettingsPage companySettingsPage;
    private ServiceTypePage serviceTypePage;

    @BeforeMethod
    public void performLogin() throws InterruptedException {
        // Step 1: Login into the system
        dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
    }

    @Test
    public void deleteServiceTypeTest() throws InterruptedException {
        // Step 2: Navigate to Company Settings
        companySettingsPage = dashboardPage.doClickCompanySettingsTab();

        // Step 3: Click on Service Type link
        companySettingsPage.clickServiceTypeLink();

        // Step 4: Initialize ServiceTypePage
        serviceTypePage = new ServiceTypePage(driver);

        // Step 5: Search and delete the Service Type
        serviceTypePage.clickDeleteServiceTypeButton(CompanySettingsConstant.SERVICE_TYPE_EDIT_NAME);
        serviceTypePage.clickConfirmDeleteButton();

        // Step 6: Validate deletion success message
        softAssert.assertEquals(
                serviceTypePage.getDeleteSuccessMessage().trim(),
                "Information Deleted Successfully.",
                "Delete success message mismatch."
        );

        // Step 7: Validate Service Type page elements are visible
        softAssert.assertTrue(serviceTypePage.isServiceTypeHeaderVisible(), "Service Type header not visible.");
        softAssert.assertTrue(serviceTypePage.isAddServiceTypeButtonVisible(), "Add New Service Type button not visible.");

        // Step 8: Finalize
        softAssert.assertAll();
    }
}