package com.dits.citywide.tests.scheduling;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.HRManagementConstants;
import com.dits.citywide.constants.SchedulingConstant;

public class AddShiftPatrolTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test
	public void addShiftTest() throws InterruptedException {
	    System.out.println("🟢 Starting Add Shift Patrol Test...");
	    Thread.sleep(4000);

	    schedulingPage = dashboardPage.doClickScheduling();
	    System.out.println("✅ Scheduling page opened");
	    Thread.sleep(2000);

	    schedulingPage.clickOnFilters();
	    System.out.println("✅ Filters clicked");

	    schedulingPage.clickOnServiceTypeCheckbox();
	    System.out.println("✅ Service type checkbox clicked");

	    schedulingPage.selectSiteType(HRManagementConstants.SITE_TYPE);
	    System.out.println("✅ Site type selected: " + HRManagementConstants.SITE_TYPE);

	    schedulingPage.selectBeatAndApply(HRManagementConstants.BEAT);
	    System.out.println("✅ Beat selected: " + HRManagementConstants.BEAT);

	    schedulingPage.addShift(SchedulingConstant.ADD_SHIFT_DATE);
	    System.out.println("✅ Add Shift clicked for date: " + SchedulingConstant.ADD_SHIFT_DATE);

	    schedulingPage.selectAssignShiftForPetrol(SchedulingConstant.ASSIGN_SHIFT_PATROL);
	    System.out.println("✅ Assign shift for patrol: " + SchedulingConstant.ASSIGN_SHIFT_PATROL);

	    schedulingPage.fillShiftFormPatrol(
	            prop.getProperty("patrolID"),
	            SchedulingConstant.START_TIME_PATROL,
	            SchedulingConstant.END_TIME_PATROL,
	            SchedulingConstant.SCHEDULED_BREAK_PATROL,
	        
	            SchedulingConstant.ADD_NOTES_PATROL
	    );
	    System.out.println("✅ Patrol shift form filled");

	    String successMessage = schedulingPage.getSuccessMessageShiftAdded();
	    System.out.println("🟢 Success message after add: " + successMessage);

	    softAssert.assertEquals(successMessage, SchedulingConstant.SUCCESS_MESSAGE_ADD_SHIFT);

	    schedulingPage.clickPublishButton();
	    System.out.println("✅ Publish button clicked");

	    String areYouSure = schedulingPage.getAreYouSureText();
	    String confirmText = schedulingPage.getPublishShiftsConfirmationText();
	    System.out.println("ℹ️ Confirmation texts: " + areYouSure + " | " + confirmText);

	    softAssert.assertEquals(areYouSure, SchedulingConstant.ARE_YOU_SURE);
	    softAssert.assertEquals(confirmText, SchedulingConstant.ACTION_WILL_PUBLISH_SHIFTS);

	    schedulingPage.clickOkButton();
	    System.out.println("✅ OK clicked");

	    String publishSuccess = schedulingPage.getSuccessMessageAfterPublish();
	    System.out.println("🟢 Publish success message: " + publishSuccess);

	    softAssert.assertEquals(publishSuccess, SchedulingConstant.SUCCESS_PUBLISH_MESSAGE);

	    System.out.println("🏁 Test Completed");
	}
}