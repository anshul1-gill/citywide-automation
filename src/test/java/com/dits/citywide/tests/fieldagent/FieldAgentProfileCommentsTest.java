package com.dits.citywide.tests.fieldagent;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.FieldAgentConstants;
import com.dits.citywide.constants.HRManagementConstants;

public class FieldAgentProfileCommentsTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		fieldAgentStartShiftPage = loginPage.doLoginFieldAgent(prop.getProperty("employeeID"),
				prop.getProperty("employeePassword"));
	}

	@Test
	public void fieldAgentCommentsAgreeOrDisagreeTest() throws InterruptedException {
		fieldAgentStartShiftPage.clickOnHRManagementMenu();
		fieldAgentProfileDetailsPage = fieldAgentStartShiftPage.clickOnProfile();
		fieldAgentProfileDetailsPage.clickCommentsTab();
		// Optionally validate the Comments tab is loaded
		fieldAgentProfileDetailsPage.validateCommentsTab();

		// Common Assertions
		softAssert.assertEquals(fieldAgentProfileDetailsPage.getHeadingText(), "Comments",
				"Heading of Comments page is not as expected");
		softAssert.assertEquals(
				fieldAgentProfileDetailsPage.getRemarkCategoryText(HRManagementConstants.REMARKS_CATEGORY),
				HRManagementConstants.REMARKS_CATEGORY);
		softAssert.assertEquals(fieldAgentProfileDetailsPage.getReasonText(HRManagementConstants.REMARKS_CATEGORY),
				HRManagementConstants.REMARKS_REASON);
		softAssert.assertEquals(
				fieldAgentProfileDetailsPage.getCommentByCategoryText(HRManagementConstants.REMARKS_CATEGORY),
				HRManagementConstants.REMARKS_DESCRIPTION);
		softAssert.assertTrue(fieldAgentProfileDetailsPage.getPostedByText(HRManagementConstants.REMARKS_CATEGORY)
				.contains(prop.getProperty("email")), "Posted by does not contain 'Field Agent'");

		// Check which response to perform
		String selectedResponse = FieldAgentConstants.SELECT_RESPONSE;

		if ("Agree".equalsIgnoreCase(selectedResponse)) {
			// AGREE FLOW
			fieldAgentProfileDetailsPage.selectResponse(HRManagementConstants.REMARKS_CATEGORY, selectedResponse);
			softAssert.assertEquals(fieldAgentProfileDetailsPage.getConfirmationMessage(),
					"This action will update the comment status to Agree");
			fieldAgentProfileDetailsPage.clickOk();
			softAssert.assertEquals(fieldAgentProfileDetailsPage.getSuccessMessage(),
					FieldAgentConstants.SUCCESS_MESSAGE_COMMENT_AGREE,
					"Success message after agreeing to comment is not as expected");

		} else if ("Disagree".equalsIgnoreCase(selectedResponse)) {
			// DISAGREE FLOW
			fieldAgentProfileDetailsPage.selectResponse(HRManagementConstants.REMARKS_CATEGORY, selectedResponse);
			softAssert.assertEquals(fieldAgentProfileDetailsPage.getConfirmationMessage(),
					"This action will update the comment status to Disagree");
			fieldAgentProfileDetailsPage.clickOk();
			softAssert.assertEquals(fieldAgentProfileDetailsPage.getHeadingTextBox(), "Add reason to disagree");
			fieldAgentProfileDetailsPage.fillReasonTextBox(FieldAgentConstants.REASON_TEXT);
			fieldAgentProfileDetailsPage.clickSubmit();
			softAssert.assertEquals(fieldAgentProfileDetailsPage.getSuccessMessage(),
					FieldAgentConstants.SUCCESS_MESSAGE_COMMENT_AGREE,
					"Success message after disagreeing to comment is not as expected");
		} else {
			throw new IllegalArgumentException("Invalid response: " + selectedResponse);
		}

		softAssert.assertAll();
	}

//	@Test
//	public void fieldAgentCommentsAgreeTest() throws InterruptedException {
//		fieldAgentStartShiftPage.clickOnHRManagementMenu();
//		fieldAgentProfileDetailsPage = fieldAgentStartShiftPage.clickOnProfile();
//		fieldAgentProfileDetailsPage.clickCommentsTab();
//		softAssert.assertEquals(fieldAgentProfileDetailsPage.getHeadingText(), "Comments",
//				"Heading of Comments page is not as expected");
//		softAssert.assertEquals(
//				fieldAgentProfileDetailsPage.getRemarkCategoryText(HRManagementConstants.REMARKS_CATEGORY),
//				HRManagementConstants.REMARKS_CATEGORY);
//		softAssert.assertEquals(fieldAgentProfileDetailsPage.getReasonText(HRManagementConstants.REMARKS_CATEGORY),
//				HRManagementConstants.REMARKS_REASON);
//		softAssert.assertEquals(
//				fieldAgentProfileDetailsPage.getCommentByCategoryText(HRManagementConstants.REMARKS_CATEGORY),
//				HRManagementConstants.REMARKS_DESCRIPTION);
//		softAssert.assertTrue(fieldAgentProfileDetailsPage.getPostedByText(HRManagementConstants.REMARKS_CATEGORY)
//				.contains(prop.getProperty("email")), "Posted by does not contain 'Field Agent'");
//		fieldAgentProfileDetailsPage.selectResponse(HRManagementConstants.REMARKS_CATEGORY,
//				FieldAgentConstants.SELECT_RESPONSE);
//		softAssert.assertEquals(fieldAgentProfileDetailsPage.getConfirmationMessage(),
//				"This action will update the comment status to Agree");
//		fieldAgentProfileDetailsPage.clickOk();
//		softAssert.assertEquals(fieldAgentProfileDetailsPage.getSuccessMessage(),
//				FieldAgentConstants.SUCCESS_MESSAGE_COMMENT_AGREE,
//				"Success message after agreeing to comment is not as expected");
//		softAssert.assertAll();
//	}
//
//	@Test
//	public void fieldAgentCommentsDisagreeTest() throws InterruptedException {
//		fieldAgentStartShiftPage.clickOnHRManagementMenu();
//		fieldAgentProfileDetailsPage = fieldAgentStartShiftPage.clickOnProfile();
//		fieldAgentProfileDetailsPage.clickCommentsTab();
//		softAssert.assertEquals(fieldAgentProfileDetailsPage.getHeadingText(), "Comments",
//				"Heading of Comments page is not as expected");
//		softAssert.assertEquals(
//				fieldAgentProfileDetailsPage.getRemarkCategoryText(HRManagementConstants.REMARKS_CATEGORY),
//				HRManagementConstants.REMARKS_CATEGORY);
//		softAssert.assertEquals(fieldAgentProfileDetailsPage.getReasonText(HRManagementConstants.REMARKS_CATEGORY),
//				HRManagementConstants.REMARKS_REASON);
//		softAssert.assertEquals(
//				fieldAgentProfileDetailsPage.getCommentByCategoryText(HRManagementConstants.REMARKS_CATEGORY),
//				HRManagementConstants.REMARKS_DESCRIPTION);
//		softAssert.assertTrue(fieldAgentProfileDetailsPage.getPostedByText(HRManagementConstants.REMARKS_CATEGORY)
//				.contains(prop.getProperty("email")), "Posted by does not contain 'Field Agent'");
//		fieldAgentProfileDetailsPage.selectResponse(HRManagementConstants.REMARKS_CATEGORY,
//				FieldAgentConstants.SELECT_RESPONSE);
//		softAssert.assertEquals(fieldAgentProfileDetailsPage.getConfirmationMessage(),
//				"This action will update the comment status to Disagree");
//		fieldAgentProfileDetailsPage.clickOk();
//		softAssert.assertEquals(fieldAgentProfileDetailsPage.getHeadingTextBox(), "Add reason to disagree");
//		fieldAgentProfileDetailsPage.fillReasonTextBox(FieldAgentConstants.REASON_TEXT);
//		fieldAgentProfileDetailsPage.clickSubmit();
//		softAssert.assertEquals(fieldAgentProfileDetailsPage.getSuccessMessage(),
//				FieldAgentConstants.SUCCESS_MESSAGE_COMMENT_AGREE,
//				"Success message after agreeing to comment is not as expected");
//		softAssert.assertAll();
//	}

}