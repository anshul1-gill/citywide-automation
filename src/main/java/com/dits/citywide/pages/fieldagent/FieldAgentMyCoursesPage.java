package com.dits.citywide.pages.fieldagent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.dits.citywide.constants.Constants;
import com.dits.citywide.utilities.ElementUtils;

public class FieldAgentMyCoursesPage {

	private WebDriver driver;
	private ElementUtils elementUtils;

	private By headingMyCourses = By.xpath("(//li[normalize-space()='My Courses'])[2]");
	private By txtHeadingAboutTheCourse = By.xpath("//div[@class='primary-heading']");
	private By btnStartReading = By.xpath("//span[normalize-space()='Start Reading']");
	private By btnMarkAsComplete = By.xpath("//span[normalize-space()='Mark as Complete']");
	private By btnOk = By.xpath("//button[normalize-space()='OK']");

	private By btnAssessment = By
			.xpath("//div[@class='inner-heading c-w-full']/following-sibling::div//div[@class='ant-card-body']");
	private By btnIAgree = By.xpath("//span[normalize-space()='I Agree']");

	// Common
	private By txtSuccessMessage = By.xpath("//div[contains(@class,'Toastify__toast-icon')]/following-sibling::div");

	// New Open Window
	private By txtInstructionForOnlineAssessment = By
			.xpath("//h4[normalize-space()='Instruction for Online Assessment']");
	private By btnStartAssessment = By.xpath("//span[normalize-space()='Start Assessment']");
	private By txtboxQuestion = By.xpath("//textarea[contains(@id,'question-TEXT')]");
	private By btnSubmit = By.xpath("//span[normalize-space()='Submit']");
	private By txtAssessmentSubmittedSuccessMessage = By
			.xpath("//h3[normalize-space()='Your assessment has been submitted successfully.']");
	private By btnViewYourSubmittedAssessment = By.xpath("//span[normalize-space()='View your Submitted Assessment']");
	private By btnBackToModule = By.xpath("//span[normalize-space()='Back to modules']");
	private By btnBackToCourse = By.xpath("//span[normalize-space()='Back to course']");
	private By txtHeadingAssessmentDetails = By.xpath("//h1[@class='heading-text']");

	private By tabModule_1 = By.xpath("(//div[@class='chapter-info'])[1]");

	// Data
	private By txtYourProgress = By.xpath("//div[normalize-space()='Your Progress']/following-sibling::p");
	private By tabAssessment = By.xpath("//div[@id='rc-tabs-0-tab-2']");
	private By txtAssessmentStatus = By.xpath("(//div[@class='status-badge status-completed'])[2]");

	public By getCourseByName(String courseName) {
		return By.xpath("//td[normalize-space()='" + courseName + "']");
	}

	public FieldAgentMyCoursesPage(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(driver);
	}

	public void clickViewCourseByName(String courseName) {
		String xpath = "//td[normalize-space()='" + courseName
				+ "']/following-sibling::td[@data-label='Actions']//a[contains(@class,'actionicons editPencil')]";
		By viewCourseBtn = By.xpath(xpath);
		elementUtils.waitForElementToBeClickable(viewCourseBtn, Constants.DEFAULT_WAIT).click();
	}

	public String getHeadingMyCourses() {
		return elementUtils.getText(headingMyCourses, Constants.DEFAULT_WAIT).trim();
	}

	public String getHeadingAboutTheCourse() {
		return elementUtils.getText(txtHeadingAboutTheCourse, Constants.DEFAULT_WAIT).trim();
	}

	public boolean isStartReadingButtonDisplayed() {
		return elementUtils.doIsDisplayed(btnStartReading, Constants.DEFAULT_WAIT);
	}

	public void clickStartReading() {
		elementUtils.waitForElementToBeClickable(btnStartReading, Constants.DEFAULT_WAIT).click();
	}

	public void clickMarkAsComplete() {
		elementUtils.waitForElementToBeClickable(btnMarkAsComplete, Constants.DEFAULT_WAIT).click();
	}

	public void clickOk() {
		elementUtils.waitForElementToBeClickable(btnOk, Constants.DEFAULT_WAIT).click();
	}

	public void clickAssessment() {
		elementUtils.waitForElementToBeClickable(btnAssessment, Constants.DEFAULT_WAIT).click();
	}

	public boolean isIAgreeButtonDisplayed() {
		return elementUtils.doIsDisplayed(btnIAgree, Constants.DEFAULT_WAIT);
	}

	public void clickButtonThatOpensNewTab() {
		elementUtils.waitForElementToBeClickable(btnIAgree, Constants.DEFAULT_WAIT).click();
		elementUtils.switchToNewTab(Constants.DEFAULT_WAIT);
	}

	// New Open Window Methods
	public String getInstructionForOnlineAssessment() {
		return elementUtils.getText(txtInstructionForOnlineAssessment, Constants.DEFAULT_WAIT).trim();
	}

	public void doClickModule1() {
		elementUtils.waitForElementToBeClickable(tabModule_1, Constants.DEFAULT_WAIT).click();
	}

	public boolean isStartAssessmentButtonDisplayed() {
		return elementUtils.doIsDisplayed(btnStartAssessment, Constants.DEFAULT_WAIT);
	}

	public void clickStartAssessment() {
		elementUtils.waitForElementToBeClickable(btnStartAssessment, Constants.DEFAULT_WAIT).click();
	}

	public String getAssessmentStartedSuccessMessage() {
		return elementUtils.getText(txtSuccessMessage, Constants.DEFAULT_WAIT).trim();
	}

	public void enterQuestion(String question) {
		elementUtils.waitForElementVisible(txtboxQuestion, Constants.DEFAULT_WAIT).sendKeys(question);
	}

	public void clickSubmit() {
		elementUtils.waitForElementToBeClickable(btnSubmit, Constants.DEFAULT_WAIT).click();
	}

	public String getAssessmentSubmittedSuccessMessage() {
		return elementUtils.getText(txtAssessmentSubmittedSuccessMessage, Constants.DEFAULT_WAIT).trim();
	}

	public void clickViewYourSubmittedAssessment() {
		elementUtils.waitForElementToBeClickable(btnViewYourSubmittedAssessment, Constants.DEFAULT_WAIT).click();
		elementUtils.pressEnterKey();
	}

	public void clickBackToModule() {
		elementUtils.waitForElementToBeClickable(btnBackToModule, Constants.DEFAULT_WAIT).click();
	}

	public String getHeadingAssessmentDetails() {
		return elementUtils.getText(txtHeadingAssessmentDetails, Constants.DEFAULT_WAIT).trim();
	}

	public void clickBackToCourse() {
		elementUtils.waitForElementToBeClickable(btnBackToCourse, Constants.DEFAULT_WAIT).click();
	}

	public String getCourseStatusByName(String courseName) {
		String xpath = "//td[normalize-space()='" + courseName + "']/following-sibling::td[@data-label='Status']/div";
		By statusLocator = By.xpath(xpath);
		return elementUtils.getText(statusLocator, Constants.DEFAULT_WAIT).trim();
	}

	// Data

	public String getYourProgress() {
		return elementUtils.getText(txtYourProgress, Constants.DEFAULT_WAIT).trim();
	}

	public String getAssessmentStatus() {
		return elementUtils.getText(txtAssessmentStatus, Constants.DEFAULT_WAIT).trim();
	}

	public String getAssessmentTabText() {
		return elementUtils.getText(tabAssessment, Constants.DEFAULT_WAIT).trim();
	}

	public String getCourseNameData(String courseName) {
		return elementUtils.waitForElementVisible(getCourseByName(courseName), Constants.DEFAULT_WAIT).getText();
	}

}
