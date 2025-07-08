package com.dits.citywide.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.dits.citywide.constants.Constants;
import com.dits.citywide.utilities.ElementUtils;

public class CourseCategoriesPage {

	private WebDriver driver;
	private ElementUtils elementUtils;

	private By txtHeadingCategories = By.xpath("//h1[normalize-space()='Categories']");
	private By btnAddNewCategory = By.xpath("//span[normalize-space()='Add New Category']");
	private By txtboxCategoryName = By.xpath("//input[@id='name']");
	private By btnSaveCategory = By.xpath("//button[@type='submit']");

	private By getCategoryName = By.xpath("(//td[@data-label='Category Name'])[1]");

	private By btnUpdateCategory = By.xpath("//span[normalize-space()='Update']");

	private By successMessage = By.xpath("//div[@class='Toastify__toast-body']/div/following-sibling::div");
	private By btnOkDelete = By.xpath("//button[normalize-space()='OK']");

	public CourseCategoriesPage(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(driver);
	}

	public String getHeadingCategories() {
		return elementUtils.getText(txtHeadingCategories, Constants.DEFAULT_WAIT);
	}

	// Add Category
	public void clickOnAddNewCategory() {
		elementUtils.waitForElementToBeClickable(btnAddNewCategory, Constants.DEFAULT_WAIT).click();
	}

	public void fillCategoryName(String categoryName) {
		elementUtils.waitForElementVisible(txtboxCategoryName, Constants.DEFAULT_WAIT).sendKeys(categoryName);
	}

	public void clickOnSaveCategory() {
		elementUtils.waitForElementToBeClickable(btnSaveCategory, Constants.DEFAULT_WAIT).click();
	}

	public String getSuccessMessage() {
		return elementUtils.getText(successMessage, Constants.DEFAULT_WAIT);
	}

	public String getCategoryName() {
		return elementUtils.getText(getCategoryName, Constants.DEFAULT_WAIT);
	}

	// Edit Category

	public void clickEditCategoryButton(String categoryName) {
		String editXpath = "//td[@data-label='Category Name' and normalize-space()='" + categoryName
				+ "']/following-sibling::td//a[@class='actionicons editPencil ']";
		elementUtils.waitForElementToBeClickable(By.xpath(editXpath), Constants.DEFAULT_WAIT).click();
	}

	public void updateCategory(String categoryName) {
		elementUtils.waitForElementVisible(txtboxCategoryName, Constants.DEFAULT_WAIT);
		elementUtils.clearTextBoxWithActions(txtboxCategoryName);
		elementUtils.doActionsSendKeys(txtboxCategoryName, categoryName);
	}

	public void clickUpdateCategoryButton() {
		elementUtils.waitForElementToBeClickable(btnUpdateCategory, Constants.DEFAULT_WAIT).click();
	}

	// Delete Category

	public void clickDeleteCategoryButton(String categoryName) {
		String deletexpath = "//td[@data-label='Category Name' and normalize-space()='" + categoryName
				+ "']/following-sibling::td//div[@class='actionicons editPencil ']";
		elementUtils.waitForElementToBeClickable(By.xpath(deletexpath), Constants.SHORT_TIME_OUT_WAIT).click();
	}

	public void clickOnOkDelete() {
		elementUtils.waitForElementToBeClickable(btnOkDelete, Constants.DEFAULT_WAIT).click();
	}
}
