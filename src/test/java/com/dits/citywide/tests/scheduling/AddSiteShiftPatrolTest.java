package com.dits.citywide.tests.scheduling;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.HRManagementConstants;
import com.dits.citywide.constants.SchedulingConstant;

public class AddSiteShiftPatrolTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test
	public void addShiftTest() throws InterruptedException {
		Thread.sleep(4000);
		schedulingPage = dashboardPage.doClickScheduling();
		Thread.sleep(2000);
		schedulingPage.clickOnFilters();
		schedulingPage.clickOnServiceTypeCheckbox();
		schedulingPage.selectSiteAndApply(HRManagementConstants.SITE);
		schedulingPage.addShift(SchedulingConstant.ADD_SHIFT_DATE);
		schedulingPage.selectAssignShift(SchedulingConstant.ASSIGN_SHIFT);
		schedulingPage.fillShiftForm(SchedulingConstant.ASSIGN_SHIFT, prop.getProperty("patrolID"),
				
				SchedulingConstant.START_TIME, SchedulingConstant.END_TIME,
				SchedulingConstant.SCHEDULED_BREAK, SchedulingConstant.ADD_NOTES);

		softAssert.assertEquals(schedulingPage.getSuccessMessageShiftAdded(),
				SchedulingConstant.SUCCESS_MESSAGE_ADD_SHIFT);

		schedulingPage.clickPublishButton();
		softAssert.assertEquals(schedulingPage.getAreYouSureText(), SchedulingConstant.ARE_YOU_SURE);
		softAssert.assertEquals(schedulingPage.getPublishShiftsConfirmationText(),
				SchedulingConstant.ACTION_WILL_PUBLISH_SHIFTS);
		schedulingPage.clickOkButton();
		softAssert.assertEquals(schedulingPage.getSuccessMessageAfterPublish(),
				SchedulingConstant.SUCCESS_PUBLISH_MESSAGE);
	}

}
