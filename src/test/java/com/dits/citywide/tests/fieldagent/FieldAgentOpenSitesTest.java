package com.dits.citywide.tests.fieldagent;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.FieldAgentConstants;
import com.dits.citywide.pages.fieldagent.FieldAgentOpenSitesPage;

public class FieldAgentOpenSitesTest extends BaseTest {

	private FieldAgentOpenSitesPage fieldAgentOpenSitesPage;

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		fieldAgentStartShiftPage = loginPage.doLoginFieldAgent(
				prop.getProperty("employeeID"),
				prop.getProperty("employeePassword"));
	}

	@Test
	public void testAddKuddosCommentToSite() throws InterruptedException {
		Thread.sleep(1000);
		fieldAgentStartShiftPage.handleMessageOfTheWeek();
		fieldAgentOpenSitesPage = fieldAgentStartShiftPage.navigateToOpenSitesTab();

		// Core action (as per your preferred call)
		fieldAgentOpenSitesPage.addCommentToSite(
				FieldAgentConstants.ADD_COMMENT_KUDDOS,
				FieldAgentConstants.ADD_COMMENT_FEEDBACK);
		
		fieldAgentOpenSitesPage.viewCommentOfSite(FieldAgentConstants.SELECT_RESPONSE_AGREE);
		fieldAgentStartShiftPage.doClickOkButton();

		// Optional verification (kept same as your comment)
		// Assert.assertTrue(openSitesPage.isCommentPresent(FieldAgentConstants.ADD_COMMENT_FEEDBACK));
	}
}