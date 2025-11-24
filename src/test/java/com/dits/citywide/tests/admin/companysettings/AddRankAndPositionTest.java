package com.dits.citywide.tests.admin.companysettings;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.CompanySettingsConstant;

public class AddRankAndPositionTest extends BaseTest {

    @BeforeMethod
    public void performLogin() throws InterruptedException {
        dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
    }

    @Test
    public void addRankAndPositionTest() throws InterruptedException {
        // Step 1: Navigate to Company Settings → Rank & Position
        companySettingsPage = dashboardPage.doClickCompanySettingsTab();
        rankAndPositionPage = companySettingsPage.clickRankAndPositionLink();

        // Step 2: Click on “Add New Rank”
        rankAndPositionPage.clickAddNewRankButton();

        // Step 3: Fill the Add Rank form using constants
        rankAndPositionPage.fillAddNewRankForm(
            CompanySettingsConstant.RANK_NAME,
            CompanySettingsConstant.RANK_ORDER,
            CompanySettingsConstant.RANK_BRANCH_RIVERSIDE
        );
        rankAndPositionPage.clickBlankArea();

        // Step 4: Submit the Add Rank form
        rankAndPositionPage.clickSubmitAddRankButton();

        // Step 5: Verify success and page elements
        softAssert.assertTrue(rankAndPositionPage.isRankPageVisible(), "Rank/Position page is not visible.");
        softAssert.assertTrue(rankAndPositionPage.isAddNewRankButtonVisible(), "Add New Rank button is not visible.");
        softAssert.assertEquals(rankAndPositionPage.getAddSuccessMessage(), 
                "Information Saved Successfully", 
                "Add Rank success message not displayed correctly.");

        System.out.println("✅ Rank Added Successfully: " + CompanySettingsConstant.RANK_NAME);

        // Final Assertion
        softAssert.assertAll();
    }
}
