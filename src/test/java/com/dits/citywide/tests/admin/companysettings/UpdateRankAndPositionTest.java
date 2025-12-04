package com.dits.citywide.tests.admin.companysettings;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.CompanySettingsConstant;

/**
 * Test Case: Update existing Rank in Company Settings
 * Description: Verify that an existing Rank can be updated successfully.
 */
public class UpdateRankAndPositionTest extends BaseTest {

    @BeforeMethod
    public void performLogin() throws InterruptedException {
        dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
    }

    @Test(priority = 2, description = "Verify that an existing Rank can be updated successfully")
    public void updateRankAndPositionTest() throws InterruptedException {

        // Step 1: Navigate to Company Settings → Rank & Position
        companySettingsPage = dashboardPage.doClickCompanySettingsTab();
        rankAndPositionPage = companySettingsPage.clickRankAndPositionLink();

        // Step 2: Click Edit button for the existing Rank
        rankAndPositionPage.clickEditRankButton(CompanySettingsConstant.RANK_NAME);

        // Step 3: Update form fields using constants
        rankAndPositionPage.updateRank(
            CompanySettingsConstant.UPDATED_RANK_NAME,
            CompanySettingsConstant.UPDATED_RANK_ORDER
        );
        
        Thread.sleep(5000); 

        // Step 5: Click on Update button
        rankAndPositionPage.clickUpdateRankButton();

        // Step 6: Verify page visibility after update
//        softAssert.assertTrue(rankAndPositionPage.isRankPageVisible(), "Rank/Position page is not visible after update.");
//        softAssert.assertTrue(rankAndPositionPage.isAddNewRankButtonVisible(), "Add New Rank button is not visible after update.");
//
//        // Step 7: Verify success message after update
        String actualMessage = rankAndPositionPage.getUpdateSuccessMessage()
                .replace(".", "")
                .trim()
                .toLowerCase();

softAssert.assertEquals(
actualMessage,
"rank updated successfully",
"Update success message not displayed correctly. Actual: " + actualMessage
);

//
        // Log confirmation
        System.out.println("✅ Rank Updated Successfully: " + CompanySettingsConstant.UPDATED_RANK_NAME);
//
//        // Step 8: Assert all verifications
        softAssert.assertAll();
    }
}
