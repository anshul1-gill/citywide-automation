package com.dits.citywide.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.Client.ClientloginPage;
import com.dits.citywide.pages.admin.DashboardPage;

public class ClientLoginTest extends BaseTest {
    private ClientloginPage clientloginPage;
    private DashboardPage dashboardPage;

    @BeforeMethod
    public void setUp() {
        clientloginPage = new ClientloginPage(driver);
    }

    @Test
    public void verifyClientLogin() {
        String clientLogin = prop.getProperty("clientlogin");
        String clientPass = prop.getProperty("clientpass");
        dashboardPage = clientloginPage.doLogin(clientLogin, clientPass);
        Assert.assertNotNull(dashboardPage, "DashboardPage should not be null after successful login");
        // Optionally, add more assertions to verify successful login
    }
}