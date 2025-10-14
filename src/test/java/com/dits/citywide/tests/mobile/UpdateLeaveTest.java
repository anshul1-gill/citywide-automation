package com.dits.citywide.tests.mobile;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.basetest.BaseMobileTest;
import com.dits.citywide.constants.MobileConstants;
import com.dits.citywide.mobile.HomeScreen;
import com.dits.citywide.mobile.LeaveRequestScreen;
import com.dits.citywide.mobile.LoginScreen;
import com.dits.citywide.mobile.MenuScreen;
import com.dits.citywide.mobile.ReportsScreen;

public class UpdateLeaveTest extends BaseMobileTest {

	HomeScreen homeScreen;
	ReportsScreen reportsScreen;
	MenuScreen menuScreen;
	LeaveRequestScreen leaveRequestScreen;

	@BeforeMethod
	public void login() throws InterruptedException {
		LoginScreen loginScreen = new LoginScreen(driver);
		reportsScreen = new ReportsScreen(driver);
		loginScreen.searchAndProceed(MobileConstants.ORG_NAME);
		homeScreen = loginScreen.login(prop.getProperty("employeeID"), prop.getProperty("employeePassword"));
	}

	@Test
	public void updateLeaveTest() throws InterruptedException {
		homeScreen.handleMessageOfTheWeek();
		menuScreen = homeScreen.clickOnMoreTab();
		leaveRequestScreen = menuScreen.tapLeaveRequest();
		
		softAssert.assertTrue(leaveRequestScreen.isLeaveRequestHeadingDisplayed(),
				"Leave Request heading not displayed");
		softAssert.assertTrue(leaveRequestScreen.isApplyLeaveButtonDisplayed(), "Apply Leave button not displayed");
		softAssert.assertTrue(leaveRequestScreen.isBellIconDisplayed(), "Bell icon not displayed");
		softAssert.assertTrue(leaveRequestScreen.isSearchLeaveDisplayed(), "Search Leave not displayed");
		softAssert.assertTrue(leaveRequestScreen.isBackArrowDisplayed(), "Back arrow not displayed");

		leaveRequestScreen.clickOnEditLeaveButton();
		leaveRequestScreen.clickOnLeaveTypeDropdownInEdit();
		leaveRequestScreen.selectLeaveTypeInEdit(MobileConstants.LEAVE_TYPE);
		leaveRequestScreen.clickOnFromDateButtonInEdit();
		leaveRequestScreen.clickOnToDateButtonInEdit();
		leaveRequestScreen.enterDescriptionInEdit("Updated leave request description");
		leaveRequestScreen.clickOnUpdateLeaveSubmitButton();
		softAssert.assertTrue(leaveRequestScreen.isSuccessMessageDisplayed(),
				"Leave update success message not displayed");

		softAssert.assertAll();

	}

}
