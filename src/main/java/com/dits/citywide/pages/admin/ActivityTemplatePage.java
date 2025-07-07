package com.dits.citywide.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.dits.citywide.constants.Constants;
import com.dits.citywide.utilities.ElementUtils;

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

	private By txtboxAddNewTemplate = By.xpath("//div[@class='questionEditor rdw-editor-main']");

	private By btnSaveQuestion = By.xpath("//span[normalize-space()='Save questions']");

	private By btnAddNewQuestion = By.xpath("//span[normalize-space()='Add New Question']");

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

	public void fillAddActivityTemplateForm(String activityTemplateName, String activityCode) {
		elementUtils.waitForElementToBeClickable(txtboxActivityTemplateName, Constants.DEFAULT_WAIT)
				.sendKeys(activityTemplateName);
		elementUtils.waitForElementToBeClickable(dropdownActivityCode, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementVisible(searchActivityType, Constants.DEFAULT_WAIT);
		elementUtils.doActionsSendKeys(searchActivityType, activityCode);
		elementUtils.pressEnterKey();
	}

	public void fillSurveyQuestionnaire(String questionType, String question) {
		elementUtils.waitForElementToBeClickable(dropdownQuestionType, Constants.DEFAULT_WAIT).click();
		elementUtils.selectElementThroughLocatorWithExactMatch(dropdownvalueQuestionValue, questionType,
				Constants.DEFAULT_WAIT);
		elementUtils.waitForElementToBeClickable(txtboxQuestion, Constants.DEFAULT_WAIT).sendKeys(question);
	}

	public void clickSaveQuestionButton() {
		elementUtils.waitForElementToBeClickable(btnSaveQuestion, Constants.DEFAULT_WAIT).click();
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

	public void clickEditViolationButton(String templateName) {
		String templatename = templateName;
		String editxpath = "//td[normalize-space()='" + templatename
				+ "']/following-sibling::td//a[@class='cursor-pointer']";
		elementUtils.waitForElementToBeClickable(By.xpath(editxpath), Constants.SHORT_TIME_OUT_WAIT).click();
	}

	public void updateSurveyQuestionnaire(String questionType, String question) {

		elementUtils.waitForElementToBeClickable(dropdownQuestionType, Constants.DEFAULT_WAIT).click();
		elementUtils.selectElementThroughLocatorWithExactMatch(dropdownvalueQuestionValue, questionType,
				Constants.DEFAULT_WAIT);

		elementUtils.waitForElementVisible(txtboxQuestion, Constants.DEFAULT_WAIT);
		elementUtils.clearTextBoxWithActions(txtboxQuestion);
		elementUtils.doActionsSendKeys(txtboxQuestion, question);
	}
	
	

}
