package com.dits.citywide.tests.admin.training;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.TrainingConstants;

public class UpdateCategoryTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test
	public void updateCategoryTest() throws InterruptedException {
		trainingPage = dashboardPage.clickOnTrainingTab();
		courseCategoriesPage = trainingPage.clickOnCourseCategories();
		softAssert.assertEquals(courseCategoriesPage.getHeadingCategories(), "Categories",
				"Heading Categories is not visible");
		courseCategoriesPage.clickEditCategoryButton(TrainingConstants.CATEGORY_NAME);
		courseCategoriesPage.updateCategory(TrainingConstants.CATEGORY_NAME_UPDATED);
		courseCategoriesPage.clickUpdateCategoryButton();

		softAssert.assertEquals(courseCategoriesPage.getCategoryName(), TrainingConstants.CATEGORY_NAME_UPDATED,
				"Updated category name is not displayed correctly");

		softAssert.assertAll();
	}

}
