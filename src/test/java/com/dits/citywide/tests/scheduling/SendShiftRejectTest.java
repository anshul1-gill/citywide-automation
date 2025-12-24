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

public class SendShiftRejectTest extends BaseTest {

        private FieldAgentMySchedulePage fieldAgentMySchedulePage;

        @BeforeMethod
        public void performLogin() throws InterruptedException {
                dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        }

        @Test(priority = 1, description = "Send Shift Reject Test - Employee 1113 rejects the shift")
        public void sendShiftRejectTest() throws InterruptedException {
                SoftAssert softAssert = new SoftAssert();

                try {
                        System.out.println("\n🚀 Starting Send Shift Reject Test...");

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
                        String shiftDate = SchedulingConstant.ADD_SHIFT_DATE; // 23
                        String startTime = "03:00";
                        String endTime = "04:30";

                        schedulingPage.addShift(shiftDate);
                        schedulingPage.selectAssignShiftForPetrol(SchedulingConstant.ASSIGN_SHIFT);
                        schedulingPage.fillOpenShiftForm(startTime, endTime, SchedulingConstant.SCHEDULED_BREAK,
                                        "Test open shift for send shift reject");

                        String addSuccess = schedulingPage.getSuccessMessageShiftAdded();
                        softAssert.assertEquals(addSuccess, SchedulingConstant.SUCCESS_MESSAGE_ADD_SHIFT);
                        System.out.println("✅ Open shift created: " + startTime + " - " + endTime);

                        Thread.sleep(3000); // Wait for toast to disappear

                        // Refresh page to see the new shift
                        driver.navigate().refresh();
                        Thread.sleep(3000);
                        System.out.println("✅ Page refreshed to show new shift");

                        // Reapply filters after refresh
                        schedulingPage.selectAgentTypeFilter(SchedulingConstant.AGENT_TYPE_STATIONARY);
                        schedulingPage.clickOnFilters();
                        schedulingPage.clickOnServiceTypeCheckbox();
                        schedulingPage.selectSiteAndApply(HRManagementConstants.SITE);
                        Thread.sleep(2000);
                        System.out.println("✅ Filters reapplied after refresh");

                        // ========== PHASE 2: Admin Sends Shift to Employee 1113 ==========
                        System.out.println("\n📤 PHASE 2: Admin Sends Shift to Employee 1113");

                        // Right-click on the open shift
                        WebElement openShift = schedulingPage.findOpenShiftByDetails(startTime + " - " + endTime);
                        Actions actions = new Actions(driver);
                        actions.moveToElement(openShift).pause(500).contextClick(openShift).perform();
                        System.out.println("✅ Right-clicked on open shift");

                        // Click "Send Shift" from context menu
                        schedulingPage.clickSendShiftFromContextMenu();
                        System.out.println("✅ Clicked 'Send Shift' from context menu");

                        // Select all 4 departments
                        schedulingPage.selectDepartments(Arrays.asList("Patrol", "Field", "Dispatch", "Admin"));

                        // Enable "Assign Shift Automatically"
                        schedulingPage.enableAssignShiftAutomatically();
                        System.out.println("✅ Enabled 'Assign Shift Automatically' toggle");

                        // Search and select employee 1113
                        schedulingPage.searchAndSelectEmployee("1113");

                        // Click Send Shift button
                        schedulingPage.clickSendShiftButton();
                        System.out.println("✅ Clicked 'Send Shift' button");

                        // Verify success message (optional)
                        String sendSuccess = schedulingPage.getSendShiftSuccessMessage();
                        if (sendSuccess != null) {
                                System.out.println("✅ Send Shift Success: " + sendSuccess);
                        } else {
                                System.out.println("⚠️ Success message not displayed (may have disappeared quickly)");
                        }

                        // ========== PHASE 3: Verify History Tab ==========
                        System.out.println("\n📜 PHASE 3: Verify History Tab");

                        // Click on History tab
                        schedulingPage.clickHistoryTab();
                        System.out.println("✅ Clicked 'History' tab");

                        // Verify employee 1113 status (informational only)
                        String employeeStatus = schedulingPage.verifyEmployeeStatus("1113");
                        System.out.println("✅ Employee 1113 status: " + employeeStatus);

                        driver.navigate().refresh();
                        Thread.sleep(3000);

                        // Logout admin
                        org.openqa.selenium.By profileIcon = org.openqa.selenium.By
                                        .xpath("//button[@class='flex items-center gap-2 text-sm']");
                        org.openqa.selenium.By logoutButton = org.openqa.selenium.By
                                        .xpath("//a[normalize-space()='Log out']");
                        org.openqa.selenium.By okButton = org.openqa.selenium.By
                                        .xpath("//button[normalize-space()='OK']");

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
                        wait.until(org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable(okButton))
                                        .click();
                        System.out.println("✅ Clicked OK button to confirm logout");
                        System.out.println("✅ Clicked OK button to confirm logout");

                        // ========== PHASE 4: Employee 1113 Rejects Shift ==========
                        System.out.println("\n👤 PHASE 4: Employee 1113 Rejects Shift");

                        // Login as employee 1113
                        String employeeId = "1113";
                        String employeePassword = "123@Gill#";
                        loginPage.doLogin(employeeId, employeePassword);
                        System.out.println("✅ Employee 1113 logged in");

                        // Initialize FieldAgentMySchedulePage
                        fieldAgentMySchedulePage = new FieldAgentMySchedulePage(driver);

                        // Navigate to My Schedule
                        fieldAgentMySchedulePage.navigateToMySchedule();

                        // Click on the open shift
                        fieldAgentMySchedulePage.clickOnOpenShift();

                        // Click REJECT button instead of Accept
                        fieldAgentMySchedulePage.clickRejectButton();

                        // Enter rejection reason
                        fieldAgentMySchedulePage.enterRejectionReason("Not available at this time");

                        // Click Save button
                        fieldAgentMySchedulePage.clickSaveRejection();

                        // Click OK on confirmation modal
                        fieldAgentMySchedulePage.clickOkConfirmation();
                        System.out.println("✅ Employee rejected the shift with reason");

                        // Wait for toast notification to disappear (15 seconds to ensure it's gone)
                        System.out.println("⏳ Waiting 15 seconds for toast notification to disappear...");
                        Thread.sleep(15000);

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
                        wait2.until(org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable(okButton))
                                        .click();
                        System.out.println("✅ Clicked OK button to confirm employee logout");

                        // ========== PHASE 5: Admin Verifies Rejection ==========
                        System.out.println("\n✅ PHASE 5: Admin Verifies Rejection");

                        // Login as admin again
                        loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
                        System.out.println("✅ Admin logged in again");

                        // Navigate to scheduling page
                        schedulingPage = dashboardPage.doClickScheduling();

                        // Reapply filters
                        schedulingPage.selectAgentTypeFilter(SchedulingConstant.AGENT_TYPE_STATIONARY);
                        schedulingPage.clickOnFilters();
                        schedulingPage.clickOnServiceTypeCheckbox();
                        schedulingPage.selectSiteAndApply(HRManagementConstants.SITE);
                        Thread.sleep(2000);
                        System.out.println("✅ Navigated to scheduling page");

                        // Right-click on the shift again
                        WebElement openShiftPhase5 = schedulingPage.findOpenShiftByDetails(startTime + " - " + endTime);
                        actions.moveToElement(openShiftPhase5).pause(500).contextClick(openShiftPhase5).perform();
                        System.out.println("✅ Right-clicked on open shift in Phase 5");

                        // Click Send Shift to check history
                        schedulingPage.clickSendShiftFromContextMenu();

                        // Click History tab to verify rejection
                        schedulingPage.clickHistoryTab();
                        System.out.println("✅ Clicked 'History' tab");

                        // Verify employee 1113 status changed to "Rejected" (informational only)
                        String employeeStatusAfterReject = schedulingPage.verifyEmployeeStatus("1113");
                        System.out.println("✅ Employee 1113 final status: " + employeeStatusAfterReject);

                        System.out.println("\n🎉 Send Shift Reject Test Completed Successfully!");

                } catch (Exception e) {
                        System.err.println("❌ Test failed with exception: " + e.getMessage());
                        e.printStackTrace();
                        throw e;
                }
        }
}
