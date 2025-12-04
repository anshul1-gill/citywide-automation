package com.dits.citywide.tests.admin.hrmanagement;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.pages.admin.AddMessageOfWeekPage;
import com.dits.citywide.constants.OperationsHubConstant;

public class AddMessageOfWeekTest extends BaseTest {

    private AddMessageOfWeekPage addMessagePage;

    @BeforeMethod
    public void performLogin() {
        // Login and initialize page object
        dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        addMessagePage = new AddMessageOfWeekPage(driver);
    }

    @Test
    public void addAdminMessageOfWeekTest() throws InterruptedException {
        // Navigate to Message of the Week page
        addMessagePage.navigateToMessageOfWeek();

        // Use fixed constants for Admin message
        String subject = OperationsHubConstant.MESSAGE_SUBJECT;
        String message = OperationsHubConstant.MESSAGE_TEXT;

        // Save subject for later verification if needed
        driverFactory.updatePropertyValue("messageOfWeekSubject", subject);

        // Add new message using "Select all" type
        addMessagePage.addNewMessage(OperationsHubConstant.MESSAGE_TYPE_All, subject, message);

    }

    @Test
    public void addManagerMessageOfWeekTest() throws InterruptedException {
        // Navigate to Message of the Week page
        addMessagePage.navigateToMessageOfWeek();

        // Use fixed constants for Manager message
        String subject = OperationsHubConstant.MESSAGE_SUBJECT_2;
        String message = OperationsHubConstant.MESSAGE_TEXT_2;

        driverFactory.updatePropertyValue("messageOfWeekSubject", subject);

        // Add new message using "Manager" type
        addMessagePage.addNewMessage(OperationsHubConstant.MESSAGE_TYPE_MANAGER, subject, message);
}
}
