package com.dits.citywide.tests.admin.training;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.TrainingConstants;

public class AddCategoryTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test
	public void addCategoryTest() throws InterruptedException {
		trainingPage = dashboardPage.clickOnTrainingTab();
		courseCategoriesPage = trainingPage.clickOnCourseCategories();
		softAssert.assertEquals(courseCategoriesPage.getHeadingCategories(), "Categories",
				"Heading Categories is not visible");
		courseCategoriesPage.clickOnAddNewCategory();
		courseCategoriesPage.fillCategoryName(TrainingConstants.CATEGORY_NAME);
		courseCategoriesPage.clickOnSaveCategory();
//		softAssert.assertEquals(courseCategoriesPage.getSuccessMessage(),
//				TrainingConstants.ADDED_CATEGORY_SUCCESS_MESSAGE, "Success message is not displayed");
		softAssert.assertEquals(courseCategoriesPage.getCategoryName(), TrainingConstants.CATEGORY_NAME,
				"Category name is not displayed correctly");

		softAssert.assertAll();
	}

}
