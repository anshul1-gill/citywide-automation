package com.dits.citywide.tests.Client;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.Client.ClientModulePage;
import com.dits.citywide.Client.ClientloginPage;
import com.dits.citywide.base.BaseTest;
import com.dits.citywide.pages.admin.DashboardPage;

public class ClientModuleTest extends BaseTest {
    private ClientloginPage clientloginPage;
    private DashboardPage dashboardPage;
    private ClientModulePage clientSettingsPage;

    @BeforeMethod
    public void loginAndOpenClientSettings() {
        clientloginPage = new ClientloginPage(driver);
        dashboardPage = clientloginPage.doLogin(prop.getProperty("clientlogin"), prop.getProperty("clientpass"));
        // Placeholder: Add navigation to Client Settings page after login
        clientSettingsPage = new ClientModulePage(driver);
    }

    @Test
    public void openAllClientSettingsSubModules() {
        // Profile
        clientSettingsPage.clickReportsLink();
        // Placeholder: Add assertion or back navigation
        // Preferences
        clientSettingsPage.clickPastCallsLink();
        // Placeholder: Add assertion or back navigation
        // Notifications
        clientSettingsPage.clickPassdownLink();
        // Placeholder: Add assertion or back navigation
        // Security
        clientSettingsPage.clickFormsLink();
        // Placeholder: Add assertion or back navigation
        clientSettingsPage.clickRequestResponseLink();
        // Placeholder: Add assertion or back navigation
        clientSettingsPage.clickMypropertiesLink();
        // Placeholder: Add assertion or back navigation
        clientSettingsPage.clickInvoicesLink();
        // Placeholder: Add assertion or back navigation
        clientSettingsPage.clickClientSupportLink();
        // Placeholder: Add assertion or back navigation
        clientSettingsPage.clickActivityTrackingLink();
    }
}