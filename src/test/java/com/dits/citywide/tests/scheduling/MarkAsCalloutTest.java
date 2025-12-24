package com.dits.citywide.tests.scheduling;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.SchedulingConstant;

public class MarkAsCalloutTest extends BaseTest {

        @BeforeMethod
        public void performLogin() throws InterruptedException {
                dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        }

        @Test
        public void markAsCalloutTest() throws InterruptedException {
                System.out.println(" Starting Mark As Callout Test...");

                // ========== PHASE 1: Create and Publish Shift (as Admin) ==========
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
                schedulingPage.selectAssignShift(SchedulingConstant.ASSIGN_SHIFT);
                schedulingPage.fillShiftForm(
                                SchedulingConstant.ASSIGN_SHIFT,
                                "1180", // Employee ID
                                "09:00",
                                "17:00",
                                SchedulingConstant.SCHEDULED_BREAK,
                                "Shift for callout test");

                softAssert.assertEquals(schedulingPage.getSuccessMessageShiftAdded(),
                                SchedulingConstant.SUCCESS_MESSAGE_ADD_SHIFT);
                System.out.println(" Shift created for employee 1180");

                // Publish the shift
                schedulingPage.clickPublishButton();
                schedulingPage.clickOkButton();
                softAssert.assertEquals(schedulingPage.getSuccessMessageAfterPublish(),
                                SchedulingConstant.SUCCESS_PUBLISH_MESSAGE);
                System.out.println(" Shift published successfully");

                // ========== PHASE 2: Start Shift (as Officer 1180) ==========
                // Wait for toast message to disappear
                Thread.sleep(3000);
                System.out.println(" Waited for toast message to disappear");

                // Logout from admin using profile icon and logout button
                org.openqa.selenium.By profileIcon = org.openqa.selenium.By
                                .xpath("//button[@class='flex items-center gap-2 text-sm']");
                org.openqa.selenium.By logoutButton = org.openqa.selenium.By.xpath("//a[normalize-space()='Log out']");

                org.openqa.selenium.support.ui.WebDriverWait wait = new org.openqa.selenium.support.ui.WebDriverWait(
                                driver, java.time.Duration.ofSeconds(45));
                wait.until(org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable(profileIcon)).click();
                System.out.println(" Clicked profile icon");
                Thread.sleep(1000);

                wait.until(org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable(logoutButton))
                                .click();
                System.out.println(" Clicked logout button");
                Thread.sleep(1000);

                // Click OK button on logout confirmation dialog
                org.openqa.selenium.By okButton = org.openqa.selenium.By.xpath("//button[normalize-space()='OK']");
                wait.until(org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable(okButton)).click();
                System.out.println(" Clicked OK button to confirm logout");
                Thread.sleep(3000); // Wait for logout to complete and redirect to login page

                // Login as employee 1180
                fieldAgentStartShiftPage = loginPage.doLoginFieldAgent("1180", prop.getProperty("employeePassword"));
                System.out.println(" Logged in as employee 1180");
                Thread.sleep(2000);

                // Handle popups that appear after login
                fieldAgentStartShiftPage.handleMessageOfTheWeek();
                fieldAgentStartShiftPage.handlePassdownOfTheDay(); // Handle "Passdown of the day" modal - click "Mark
                                                                   // As Read"

                // Navigate to Start Shift tab
                fieldAgentStartShiftPage.doClickTabStartShift();
                System.out.println(" Navigated to Start Shift tab");

                // View shift details and start shift
                fieldAgentStartShiftPage.viewShiftDetails(SchedulingConstant.ADD_SHIFT_DATE);
                softAssert.assertTrue(fieldAgentStartShiftPage.isStartShiftButtonVisible(),
                                "Start Shift button should be visible");
                fieldAgentStartShiftPage.doClickStartShift();
                System.out.println(" Clicked Start Shift button");

                // Handle previous shift logout if needed
                fieldAgentStartShiftPage.logoutFromPreviousShift();

                // Click Start Shift Begin
                fieldAgentReportsPage = fieldAgentStartShiftPage.doClickStartShiftBegin();
                System.out.println(" Shift started successfully");

                // Handle passdown
                fieldAgentStartShiftPage.handlePassdownOfTheDay();

                // ========== PHASE 3: Mark as Callout (as Admin) ==========
                // Logout from officer account using profile icon, logout button, and OK
                // confirmation
                WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(15));

                // Click profile icon
                org.openqa.selenium.By profileIconFieldAgent = org.openqa.selenium.By
                                .xpath("//button[@class='flex items-center gap-2 text-sm']");
                wait3.until(ExpectedConditions.elementToBeClickable(profileIconFieldAgent)).click();
                System.out.println(" Clicked profile icon for field agent");
                Thread.sleep(1000);

                // Click logout button
                org.openqa.selenium.By logoutButtonFieldAgent = org.openqa.selenium.By
                                .xpath("//a[normalize-space()='Log out']");
                wait3.until(ExpectedConditions.elementToBeClickable(logoutButtonFieldAgent)).click();
                System.out.println(" Clicked logout button for field agent");
                Thread.sleep(1000);

                // Click OK button on confirmation dialog
                org.openqa.selenium.By okButtonFieldAgent = org.openqa.selenium.By
                                .xpath("//button[normalize-space()='OK']");
                wait3.until(ExpectedConditions.elementToBeClickable(okButtonFieldAgent)).click();
                System.out.println(" Clicked OK button to confirm field agent logout");
                Thread.sleep(3000); // Wait for logout to complete and redirect to login page

                // Login as admin again
                dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
                System.out.println(" Logged in as admin again");
                Thread.sleep(4000);

                // Navigate to scheduling
                schedulingPage = dashboardPage.doClickScheduling();
                Thread.sleep(2000);

                // Select site
                schedulingPage.clickOnFilters();
                schedulingPage.clickOnServiceTypeCheckbox(); // Click Service Type checkbox
                schedulingPage.selectSiteAndApply("Richmond");
                System.out.println(" Navigated to scheduling and selected Richmond site with Service Type filter");

                // Left-click on the started shift to open the modal
                WebElement shiftElement = schedulingPage.findShiftByDetails("09:00 - 17:00", "1180");
                shiftElement.click();
                System.out.println(" Clicked on shift: 09:00 - 17:00 for employee 1180");
                Thread.sleep(2000); // Wait for modal to open

                schedulingPage.clickMarkAsCallout();
                System.out.println(" Clicked 'Mark as Callout'");
                Thread.sleep(2000); // Wait for modal to appear

                // Fill the Mark as Callout modal
                schedulingPage.fillMarkAsCalloutReason("Employee called out");
                schedulingPage.submitMarkAsCallout();
                System.out.println(" Submitted Mark as Callout form");

                // Verify success message
                String successMessage = schedulingPage.getMarkAsCalloutSuccessMessage();
                softAssert.assertNotNull(successMessage, "Success message should be displayed");
                System.out.println(" Mark as Callout Success: " + successMessage);

                System.out.println("Test Completed Successfully");
                softAssert.assertAll();
        }

}
