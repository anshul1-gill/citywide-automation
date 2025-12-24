package com.dits.citywide.tests.scheduling;

import java.util.Arrays;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.HRManagementConstants;
import com.dits.citywide.constants.SchedulingConstant;
import com.dits.citywide.pages.fieldagent.FieldAgentMySchedulePage;

public class SendShiftAcceptTest extends BaseTest {

        private FieldAgentMySchedulePage fieldAgentMySchedulePage;

        @BeforeMethod
        public void performLogin() throws InterruptedException {
                dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        }

        @Test(priority = 1, description = "Send Shift Accept Test - Complete flow from send to accept and assign")
        public void sendShiftAcceptTest() throws InterruptedException {
                SoftAssert softAssert = new SoftAssert();

                try {
                        System.out.println("\n🚀 Starting Send Shift Accept Test...");

                        // ========== PHASE 1: Admin Creates Open Shift ==========
                        System.out.println("\n📋 PHASE 1: Admin Creates Open Shift");
                        Thread.sleep(4000);

                        schedulingPage = dashboardPage.doClickScheduling();
                        System.out.println("✅ Scheduling page opened");

                        // Select Richmond site with Service Type filter
                        schedulingPage.selectAgentTypeFilter(SchedulingConstant.AGENT_TYPE_STATIONARY);
                        schedulingPage.clickOnFilters();
                        schedulingPage.clickOnServiceTypeCheckbox();
                        schedulingPage.selectSiteAndApply(HRManagementConstants.SITE);
                        System.out.println("✅ Site selected: " + HRManagementConstants.SITE);

                        // Create open shift
                        String shiftDate = SchedulingConstant.ADD_SHIFT_DATE; // 19
                        String startTime = "01:00";
                        String endTime = "02:30";

                        // Delete existing shift if it exists to prevent overlap
                        // TEMPORARILY DISABLED: Delete manually before running test
                        // schedulingPage.deleteExistingOpenShiftIfExists(startTime + " - " + endTime);

                        schedulingPage.addShift(shiftDate);
                        schedulingPage.selectAssignShiftForPetrol(SchedulingConstant.ASSIGN_SHIFT);
                        schedulingPage.fillOpenShiftForm(startTime, endTime, SchedulingConstant.SCHEDULED_BREAK,
                                        "Test open shift for send shift accept");

                        String addSuccess = schedulingPage.getSuccessMessageShiftAdded();
                        softAssert.assertEquals(addSuccess, SchedulingConstant.SUCCESS_MESSAGE_ADD_SHIFT);
                        System.out.println("✅ Open shift created: " + startTime + " - " + endTime);

                        Thread.sleep(3000); // Wait for toast to disappear

                        // Refresh page to ensure calendar shows the newly created shift
                        driver.navigate().refresh();
                        Thread.sleep(3000); // Wait for page to reload
                        System.out.println("✅ Page refreshed to show new shift");

                        // Reapply filters after refresh
                        schedulingPage.selectAgentTypeFilter(SchedulingConstant.AGENT_TYPE_STATIONARY);
                        schedulingPage.clickOnFilters();
                        schedulingPage.clickOnServiceTypeCheckbox();
                        schedulingPage.selectSiteAndApply(HRManagementConstants.SITE);
                        Thread.sleep(2000); // Wait for filters to apply
                        System.out.println("✅ Filters reapplied after refresh");

                        // ========== PHASE 2: Admin Sends Shift ==========
                        System.out.println("\n📤 PHASE 2: Admin Sends Shift to Employee 1107");

                        // Right-click on open shift - use findOpenShiftByDetails for open shifts
                        WebElement openShift = schedulingPage.findOpenShiftByDetails(startTime + " - " + endTime);
                        Actions actions = new Actions(driver);
                        // First hover over the shift, then right-click
                        actions.moveToElement(openShift).pause(500).contextClick(openShift).perform();
                        System.out.println("✅ Right-clicked on open shift");

                        // Click Send Shift from context menu
                        schedulingPage.clickSendShiftFromContextMenu();

                        // Select departments: Patrol, Field, Dispatch
                        schedulingPage.selectDepartments(Arrays.asList("Patrol", "Field", "Dispatch", "Admin"));

                        // Enable Assign Shift Automatically toggle
                        schedulingPage.enableAssignShiftAutomatically();

                        // Search and select employee 1107
                        schedulingPage.searchAndSelectEmployee("1107");

                        // Click Send Shift button
                        schedulingPage.clickSendShiftButton();

                        // Verify success message
                        String sendSuccess = schedulingPage.getSendShiftSuccessMessage();
                        softAssert.assertNotNull(sendSuccess, "Send shift success message should be displayed");
                        System.out.println("✅ Send Shift Success: " + sendSuccess);

                        // ========== PHASE 3: Verify History Tab ==========
                        System.out.println("\n📜 PHASE 3: Verify History Tab");

                        schedulingPage.clickHistoryTab();
                        String status = schedulingPage.verifyEmployeeStatus("1107");
                        softAssert.assertNotNull(status, "Employee status should not be null");
                        softAssert.assertEquals(status, "Pending", "Employee status should be Pending");
                        System.out.println("✅ Verified employee 1107 status: " + status);

                        driver.navigate().refresh();
                        Thread.sleep(3000);

                        // Logout admin
                        org.openqa.selenium.By profileIcon = org.openqa.selenium.By
                                        .xpath("//button[@class='flex items-center gap-2 text-sm']");
                        org.openqa.selenium.By logoutButton = org.openqa.selenium.By
                                        .xpath("//a[normalize-space()='Log out']");
                        org.openqa.selenium.support.ui.WebDriverWait wait = new org.openqa.selenium.support.ui.WebDriverWait(
                                        driver, java.time.Duration.ofSeconds(45));
                        wait.until(org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable(profileIcon))
                                        .click();
                        System.out.println("✅ Clicked profile icon");
                        Thread.sleep(1000);
                        wait.until(org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable(logoutButton))
                                        .click();
                        System.out.println("✅ Clicked logout button");
                        Thread.sleep(1000);
                        org.openqa.selenium.By okButton = org.openqa.selenium.By
                                        .xpath("//button[normalize-space()='OK']");
                        wait.until(org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable(okButton))
                                        .click();
                        System.out.println("✅ Clicked OK button to confirm logout");
                        Thread.sleep(3000);

                        // ========== PHASE 4: Employee Accepts Shift ==========
                        System.out.println("\n👤 PHASE 4: Employee 1107 Accepts Shift");

                        // Login as employee 1107
                        dashboardPage = loginPage.doLogin("1107",
                                        "123@Gill#");
                        System.out.println("✅ Employee 1107 logged in");
                        Thread.sleep(3000);

                        // Initialize Field Agent My Schedule Page
                        fieldAgentMySchedulePage = new FieldAgentMySchedulePage(driver);

                        // Navigate to My Schedule
                        fieldAgentMySchedulePage.navigateToMySchedule();

                        // Click on open shift
                        fieldAgentMySchedulePage.clickOnOpenShift();

                        // Click Accept button
                        fieldAgentMySchedulePage.clickAcceptButton();

                        // Click OK on confirmation
                        fieldAgentMySchedulePage.clickOkConfirmation();
                        System.out.println("✅ Employee accepted the shift");

                        // Wait for toast notification to disappear
                        Thread.sleep(3000);

                        // Logout employee
                        org.openqa.selenium.By profileIconEmployee = org.openqa.selenium.By
                                        .xpath("//button[@class='flex items-center gap-2 text-sm']");
                        org.openqa.selenium.By logoutButtonEmployee = org.openqa.selenium.By
                                        .xpath("//a[normalize-space()='Log out']");
                        org.openqa.selenium.support.ui.WebDriverWait wait2 = new org.openqa.selenium.support.ui.WebDriverWait(
                                        driver, java.time.Duration.ofSeconds(45));
                        wait2.until(org.openqa.selenium.support.ui.ExpectedConditions
                                        .elementToBeClickable(profileIconEmployee))
                                        .click();
                        System.out.println("✅ Clicked profile icon for employee");
                        Thread.sleep(1000);
                        wait2.until(org.openqa.selenium.support.ui.ExpectedConditions
                                        .elementToBeClickable(logoutButtonEmployee))
                                        .click();
                        System.out.println("✅ Clicked logout button for employee");
                        Thread.sleep(1000);
                        org.openqa.selenium.By okButtonEmployee = org.openqa.selenium.By
                                        .xpath("//button[normalize-space()='OK']");
                        wait2.until(org.openqa.selenium.support.ui.ExpectedConditions
                                        .elementToBeClickable(okButtonEmployee))
                                        .click();
                        System.out.println("✅ Clicked OK button to confirm employee logout");
                        Thread.sleep(3000);

                        // ========== PHASE 5: Admin Assigns Shift ==========
                        System.out.println("\n✅ PHASE 5: Admin Assigns Shift");

                        // Login as admin again
                        dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
                        System.out.println("✅ Admin logged in again");
                        Thread.sleep(3000);

                        // Navigate to scheduling
                        schedulingPage = dashboardPage.doClickScheduling();
                        schedulingPage.selectAgentTypeFilter(SchedulingConstant.AGENT_TYPE_STATIONARY);
                        schedulingPage.clickOnFilters();
                        schedulingPage.clickOnServiceTypeCheckbox();
                        schedulingPage.selectSiteAndApply(HRManagementConstants.SITE);
                        System.out.println("✅ Navigated to scheduling page");

                        // Right-click on open shift - use findOpenShiftByDetails
                        openShift = schedulingPage.findOpenShiftByDetails(startTime + " - " + endTime);
                        Actions actions2 = new Actions(driver);
                        // First hover over the shift, then right-click
                        actions2.moveToElement(openShift).pause(500).contextClick(openShift).perform();
                        System.out.println("✅ Right-clicked on open shift in Phase 5");
                        // Click Send Shift
                        schedulingPage.clickSendShiftFromContextMenu();

                        // Go to History tab
                        schedulingPage.clickHistoryTab();

                        // Verify status is Accepted
                        String acceptedStatus = schedulingPage.verifyEmployeeStatus("1107");
                        softAssert.assertEquals(acceptedStatus, "Accepted", "Employee status should be 'Accepted'");
                        System.out.println("✅ Verified employee 1107 status changed to: " + acceptedStatus);

                        // Click Assign Shift button
                        schedulingPage.clickAssignShiftInHistory();

                        // Click Update Shift button
                        schedulingPage.clickUpdateShiftButton();
                        System.out.println("✅ Shift assigned successfully");

                        System.out.println("\n🎉 Send Shift Accept Test Completed Successfully!");
                        softAssert.assertAll();

                } catch (Exception e) {
                        System.out.println("❌ Test failed with error: " + e.getMessage());
                        e.printStackTrace();
                        throw e;
                }
        }
}
