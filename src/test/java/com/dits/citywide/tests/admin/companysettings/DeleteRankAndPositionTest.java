package com.dits.citywide.tests.admin.companysettings;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.CompanySettingsConstant;

/**
 * Test Case: Delete an existing Rank from Company Settings
 * Description: Verify that an existing Rank can be deleted successfully.
 */
public class DeleteRankAndPositionTest extends BaseTest {

    @BeforeMethod
    public void performLogin() throws InterruptedException {
        dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
    }

    @Test(priority = 3, description = "Verify that an existing Rank can be deleted successfully")
    public void deleteRankAndPositionTest() throws InterruptedException {

        // Step 1: Navigate to Company Settings → Rank & Position
        companySettingsPage = dashboardPage.doClickCompanySettingsTab();
        rankAndPositionPage = companySettingsPage.clickRankAndPositionLink();

        // Step 2: Search for the updated rank (to be deleted)
        rankAndPositionPage.searchRank(CompanySettingsConstant.UPDATED_RANK_NAME);

        // Step 3: Click Delete button for the searched rank
        rankAndPositionPage.clickDeleteRankButton(CompanySettingsConstant.UPDATED_RANK_NAME);

        // Step 4: Confirm the delete action
        rankAndPositionPage.clickConfirmDeleteButton();

//        // Step 5: Verify Rank page is visible after deletion
//        softAssert.assertTrue(rankAndPositionPage.isRankPageVisible(), "Rank/Position page is not visible after delete.");
//        softAssert.assertTrue(rankAndPositionPage.isAddNewRankButtonVisible(), "Add New Rank button is not visible after delete.");
//
//        // Step 6: Verify success message after deletion
        String actualMessage = rankAndPositionPage.getDeleteSuccessMessage()
                .replace(".", "")
                .trim()
                .toLowerCase();

softAssert.assertEquals(
actualMessage,
"rank deleted successfully",
"Delete success message not displayed correctly. Actual: " + actualMessage
);


//        // Step 7: Log confirmation
//        System.out.println("🗑️ Rank Deleted Successfully: " + CompanySettingsConstant.UPDATED_RANK_NAME);
//
//        // Step 8: Assert all
        softAssert.assertAll();
    }
}
