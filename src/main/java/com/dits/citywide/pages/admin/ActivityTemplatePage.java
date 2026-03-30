package com.dits.citywide.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.dits.citywide.constants.Constants;
import com.dits.citywide.utilities.ElementUtils;

import java.util.List;

public class ActivityTemplatePage {

	private WebDriver driver;
	private ElementUtils elementUtils;

	private By txtActivityTemplateHeader = By.xpath("//h1[normalize-space()='Activity Templates']");
	private By btnAddActivityTemplate = By.xpath("//span[normalize-space()='Add New Template']");

	// Add Activity Template
	private By txtboxActivityTemplateName = By.xpath("//input[@id='template_name']");
	private By dropdownActivityCode = By.xpath("(//div[@class='ant-select-selector'])[1]");
	private By searchActivityType = By.xpath("//input[@id='code']");

	private By dropdownQuestionType = By.xpath("(//div[@class='ant-select-selector'])[3]");
	private By dropdownvalueQuestionValue = By.xpath("(//div[@class='rc-virtual-list-holder-inner'])[1]/div/div");
	private By txtboxQuestion = By.xpath("//textarea[@id='question']");

	public By getSurveyQuestionLocator(String questionText) {
		String dynamicXPath = String.format("//div[contains(text(), '%s')]", questionText);
		return By.xpath(dynamicXPath);
	}

	private By txtboxAddNewTemplate = By.xpath("//div[@class='questionEditor rdw-editor-main']");

	private By btnSaveQuestion = By.xpath("//button[normalize-space()='Save questions']");

	private By btnAddNewQuestion = By.xpath("//span[normalize-space()='Add New Question']");
	private By inputSearchActivityTemplate = By.xpath("//input[@placeholder='Search']");
	private By txtSuccessMessage = By
			.xpath("//div[contains(@role,'alert') and contains(.,'Template question created successfully')]");

	public ActivityTemplatePage(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(driver);
	}

	public boolean isActivityTemplateHeaderVisible() {
		return elementUtils.doIsDisplayed(txtActivityTemplateHeader, Constants.DEFAULT_WAIT);
	}

	public boolean isAddActivityTemplateButtonVisible() {
		return elementUtils.doIsDisplayed(btnAddActivityTemplate, Constants.DEFAULT_WAIT);
	}

	public void clickAddActivityTemplateButton() {
		elementUtils.waitForElementToBeClickable(btnAddActivityTemplate, Constants.DEFAULT_WAIT).click();
	}

	public String getSuccessMessage() {
		String rawMessage = elementUtils
				.waitForElementVisible(txtSuccessMessage, Constants.DEFAULT_WAIT)
				.getText();

		// Remove the close icon and whitespace/newline characters
		String cleanedMessage = rawMessage.replace("×", "").trim().replace("\n", "").trim();

		return cleanedMessage;
	}

	public void fillAddActivityTemplateForm(String activityTemplateName, String activityCode) {
		elementUtils.waitForElementToBeClickable(txtboxActivityTemplateName, Constants.DEFAULT_WAIT)
				.sendKeys(activityTemplateName);
		elementUtils.waitForElementToBeClickable(dropdownActivityCode, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementVisible(searchActivityType, Constants.DEFAULT_WAIT);
		elementUtils.doActionsSendKeys(searchActivityType, activityCode);

		// Wait for dropdown options to appear and click the matching one
		try {
			Thread.sleep(1000); // Wait for search results
			// Click on the option that matches the activity code
			By activityCodeOption = By
					.xpath("//div[contains(@class, 'ant-select-item') and contains(., '" + activityCode + "')]");
			elementUtils.waitForElementToBeClickable(activityCodeOption, Constants.SHORT_TIME_OUT_WAIT).click();
			System.out.println("Activity code selected: " + activityCode);
		} catch (Exception e) {
			System.out.println("Failed to select activity code from dropdown, trying Enter key...");
			elementUtils.pressEnterKey();
		}
	}

	public void fillSurveyQuestionnaire(String questionType, String question) {
		elementUtils.selectCustomDropdownByVisibleText(dropdownQuestionType, questionType, Constants.DEFAULT_WAIT);
		// Enter question text in the input field
		elementUtils.waitForElementToBeClickable(txtboxQuestion, Constants.DEFAULT_WAIT).sendKeys(question);
	}

	public void clickSaveQuestionButton() {
		try {
			// Wait longer for the button to be ready
			Thread.sleep(2000);
			elementUtils.waitForElementToBeClickable(btnSaveQuestion, Constants.DEFAULT_WAIT).click();
			System.out.println("Save questions button clicked successfully using normal click");
		} catch (Exception e) {
			System.out.println("Normal click failed, trying JavaScript click...");
			// Fallback to JavaScript click
			elementUtils.doActionsClick(btnSaveQuestion);
		}
	}

	public void updateActivityTemplate(String activityTemplateName, String activityCode) {
		elementUtils.waitForElementToBeClickable(txtboxActivityTemplateName, Constants.DEFAULT_WAIT).clear();
		elementUtils.waitForElementToBeClickable(txtboxActivityTemplateName, Constants.DEFAULT_WAIT)
				.sendKeys(activityTemplateName);
		elementUtils.waitForElementToBeClickable(dropdownActivityCode, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementVisible(searchActivityType, Constants.DEFAULT_WAIT);
		elementUtils.doActionsSendKeys(searchActivityType, activityCode);
		elementUtils.pressEnterKey();
	}

	public void searchActivityTemplate(String templateName) {
		elementUtils.waitForElementVisible(inputSearchActivityTemplate, Constants.DEFAULT_WAIT).clear();
		elementUtils.doActionsSendKeys(inputSearchActivityTemplate, templateName);
		elementUtils.pressEnterKey();
		// Wait for table to refresh with search results
		elementUtils.waitForElementVisible(By.xpath("//td[normalize-space()='" + templateName + "']"),
				Constants.SHORT_TIME_OUT_WAIT);
	}

	public void clickEditViolationButton(String templateName) {
		// Search first to ensure the template is visible
		searchActivityTemplate(templateName);
		String editxpath = "//td[normalize-space()='" + templateName
				+ "']/following-sibling::td//a[@class='cursor-pointer']";
		elementUtils.waitForElementToBeClickable(By.xpath(editxpath), Constants.SHORT_TIME_OUT_WAIT).click();
	}

	public void updateSurveyQuestionnaire(String questionType, String question) {
		elementUtils.selectCustomDropdownByVisibleText(dropdownQuestionType, questionType, Constants.DEFAULT_WAIT);
		// If entering question text is required, uncomment and use the following:
		// elementUtils.waitForElementToBeClickable(txtboxQuestion,
		// Constants.DEFAULT_WAIT).sendKeys(question);
	}

}