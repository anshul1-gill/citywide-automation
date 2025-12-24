package com.dits.citywide.tests.scheduling;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.SchedulingConstant;

public class CreateShiftFor1180Test extends BaseTest {

    @BeforeMethod
    public void performLogin() throws InterruptedException {
        dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
    }

    @Test
    public void createShiftFor1180Test() throws InterruptedException {
        System.out.println(" Starting Create Shift for 1180 Test...");

        // Navigate to scheduling
        Thread.sleep(4000);
        schedulingPage = dashboardPage.doClickScheduling();
        System.out.println(" Scheduling page opened");
        Thread.sleep(2000);

        // Select site
        schedulingPage.clickOnFilters();
        schedulingPage.clickOnServiceTypeCheckbox(); // Click Service Type checkbox
        schedulingPage.selectSiteAndApply("Richmond");
        System.out.println(" Site selected: Richmond with Service Type filter");

        // Add shift for employee 1180
        schedulingPage.addShift(SchedulingConstant.ADD_SHIFT_DATE);
        System.out.println(" Clicked add shift for date: " + SchedulingConstant.ADD_SHIFT_DATE);

        schedulingPage.selectAssignShift(SchedulingConstant.ASSIGN_SHIFT);
        System.out.println(" Selected 'Assign to Employee'");

        schedulingPage.fillShiftForm(
                SchedulingConstant.ASSIGN_SHIFT,
                "1180", // Employee ID
                "09:00",
                "17:00",
                SchedulingConstant.SCHEDULED_BREAK,
                "Shift for callout test");
        System.out.println(" Filled shift form for employee 1180");

        softAssert.assertEquals(schedulingPage.getSuccessMessageShiftAdded(),
                SchedulingConstant.SUCCESS_MESSAGE_ADD_SHIFT);
        System.out.println(" Shift created successfully for employee 1180");

        // Publish the shift
        schedulingPage.clickPublishButton();
        schedulingPage.clickOkButton();
        softAssert.assertEquals(schedulingPage.getSuccessMessageAfterPublish(),
                SchedulingConstant.SUCCESS_PUBLISH_MESSAGE);
        System.out.println(" Shift published successfully");

        System.out.println("Phase 1 Test Completed Successfully");
        softAssert.assertAll();
    }

}
