package com.dits.citywide.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.dits.citywide.constants.Constants;
import com.dits.citywide.utilities.ElementUtils;

public class TotalCoursesPage {

	private WebDriver driver;
	private ElementUtils elementUtils;

	private By txtHeadingCourses = By.xpath("//h1[@class='heading-text']");
	// Add New Course
	private By btnAddNewCourse = By.xpath("//span[normalize-space()='Add New Course']");
	private By tabasicInfo = By.xpath("//div[@id='rc-tabs-1-tab-basic_information']");
	private By txtboxCourseName = By.xpath("//input[@id='name']");
	private By dropdownSelectCertificate = By.xpath("(//span[@class='ant-select-selection-wrap'])[2]");
	private By searchCertificate = By.xpath("//input[@id='certificate_id']");
	private By dropdownSelectCategory = By.xpath("(//span[@class='ant-select-selection-wrap'])[3]");
	private By searchCategory = By.xpath("//input[@id='type']");
	private By dropdownPaymentType = By.xpath("(//span[@class='ant-select-selection-wrap'])[4]");

	public By getPaymentTypeOption(String paymentType) {
		String xpath = "//div[@class='ant-select-item-option-content'][normalize-space()='" + paymentType + "']";
		return By.xpath(xpath);
	}

	private By txtboxAssignmentDuration = By.xpath("//input[@id='duration_value']");

	private By dropdownDeadlineType = By.xpath("(//span[@class='ant-select-selection-wrap'])[5]");

	public By getDeadlineTypeOption(String hoursValue) {
		String xpath = "//div[contains(@class,'ant-select-item-option-content')][normalize-space()='" + hoursValue
				+ "']";
		return By.xpath(xpath);
	}

	private By txtboxCompletionDeadline = By.xpath("//input[@id='time_period_value']");

	private By txtboxCourseDescription = By.xpath("//div[@aria-label='rdw-editor']");

	private By getAssessmentLocator(String dynamicText) {
		String xpath = "(//span[normalize-space()='" + dynamicText + "'])[1]";
		return By.xpath(xpath);
	}

	private By dropdownInstructor = By.xpath("(//span[@class='ant-select-selection-wrap'])[6]");

	public By getInstructorTypeOption(String instructorType) {
		String xpath = "//div[@class='ant-select-item-option-content'][normalize-space()='" + instructorType + "']";
		return By.xpath(xpath);
	}

	private By txtboxInstructorName = By.xpath("//input[@id='instructor_name']");

	private By dropdownCourseEvaluator = By.xpath("(//span[@class='ant-select-selection-wrap'])[7]");
	private By searchCourseEvaluator = By.xpath("//input[@id='course_evaluator']");

	private By getRequiresCourseCompletionToScheduleLocator(String dynamicText) {
		String xpath = "(//span[normalize-space()='" + dynamicText + "'])[2]";
		return By.xpath(xpath);
	}

	private By btnSaveCourse = By.xpath("//button[@type='submit']");

	private By txtHeadingUpdateCourse = By.xpath("//h1[normalize-space()='Update Course']");

	// Module tab
	private By tabModule = By.xpath("//div[@id='rc-tabs-1-tab-chapters']");
	private By btnAddNewModule = By.xpath("//span[normalize-space()='Add New Module']");
	private By txtModuleName = By.xpath("//input[@placeholder='Module Name']");
	private By txtModuleDuration = By.xpath("//input[@id='chapter_duration']");
	private By txtboxModuleContent = By.xpath("//div[@aria-label='rdw-editor']");
	private By btnUploadFiles = By
			.xpath("//span[contains(@class,'ant-input-affix-wrapper ant-input-affix-wrapper-readonly')]");
	private By txtUploadFiles = By.xpath("//span[@class='baseTitle']");
	private By uploadFile = By.xpath("//input[@type='file']");
	private By uploadefileSucessMessage = By.xpath("//div[contains(text(),'File uploaded successfully')]");
	private By txtboxFiles = By.xpath("//input[@id='file_url']");
	private By btnModuleSave = By
			.xpath("//div[contains(@class,'ant-spin-container')]//button[contains(@type,'submit')]");

	// Assessments tab
	private By tabAssessments = By.xpath("//div[@id='rc-tabs-1-tab-assessment']");
	private By btnAddNewAssessment = By.xpath("//span[normalize-space()='Add Assessment']");
	private By assessmentName = By.xpath("(//input[@id='name'])[2]");
	private By txtboxDuration = By.xpath("//input[@id='duration']");
	private By dropdownSelectModule = By.xpath("(//div[@class='ant-select-selection-overflow'])[2]");
	private By searchModuleValues = By.xpath("//div[@class='ant-select-item-option-content']");
//	private By searchModule = By
//			.xpath("//div[contains(@class,'css-iirhfw ant-form-item-has-success')]//input[@id='chapter_ids']");

	private By getRemarksLocator(String dynamicText) {
		String xpath = "(//span[normalize-space()='" + dynamicText + "'])[2]";
		return By.xpath(xpath);
	}

	private By txtboxTotalPoints = By.xpath("(//input[@id='total_value'])[2]");
	private By txtboxMinimumPoints = By.xpath("(//input[@id='remarks_value'])[2]");

	private By getMethodOfAssessmentLocator(String dynamicText) {
		String xpath = "(//span[normalize-space()='" + dynamicText + "'])[2]";
		return By.xpath(xpath);
	}

	private By btnSaveAssessment = By.xpath("//span[normalize-space()='Save']");

	// Add Question
	private By btnAddQuestion = By.xpath("//span[normalize-space()='Add Question']");
	private By txtHeadingQuestionnaireType = By.xpath("//span[contains(@class,'baseTitle')]");
	private By dropdownQuestionnaireType = By.xpath("//span[@title='Input Text Field']");
	private By valuesQuestionnaireType = By.xpath("//div[@class='ant-select-item-option-content']");
	private By txtboxQuestionScore = By.xpath("//input[@placeholder='Type Score']");
	private By txtboxQuestion = By.xpath("//textarea[@placeholder='Input Your Question Here...']");
	private By btnEnterPredictedQuestiuon = By.xpath("//textarea[@placeholder='Enter Predicted Answer']");
	private By btnNext = By.xpath("(//span[contains(text(),'Next')])[2]");
	private By btnSubmitQuestion = By.xpath("//span[normalize-space()='Submit Question']");
	private By btnAllAssessments = By.xpath("//span[normalize-space()='All Assessments']");

	// Course Overview
	private By tabCourseOverview = By.xpath("//div[@data-node-key='publish']");
	private By txtHeadingAboutTheCourse = By.xpath(
			"//div[@class='primary-heading with-actions about-course-heading ant-flex css-1l4zwsq ant-flex-justify-space-between']");

	private By dataCourseType = By.xpath("//p[normalize-space()='Course Type']/following-sibling::p");
	private By dataCourseDuration = By.xpath("//p[normalize-space()='Course Duration']/following-sibling::p");
	private By dataCourseCompletionTime = By.xpath("//p[normalize-space()='Completion Time']/following-sibling::p");
	private By dataCourseCategory = By.xpath("//p[normalize-space()='Course Category']/following-sibling::p");

	private By btnPublishCourse = By.xpath("//span[normalize-space()='Publish Course']");

	// Actions on Course Overview

	public void doClickDuplicateCourse(String courseName) {
		String xpath = "//td[normalize-space()='" + courseName
				+ "']/following-sibling::td[@data-label='Actions']//span[normalize-space()='Duplicate Course']";
		elementUtils.waitForElementToBeClickable(By.xpath(xpath), Constants.DEFAULT_WAIT).click();
	}

	public void doClickTransferToBranch(String courseName) {
		String xpath = "//td[normalize-space()='" + courseName
				+ "']/following-sibling::td[@data-label='Actions']//span[normalize-space()='Transfer to Branch']";
		elementUtils.waitForElementToBeClickable(By.xpath(xpath), Constants.DEFAULT_WAIT).click();
	}

	public void doClickPublishDraftToggle(String courseName) {
		String xpath = "//td[normalize-space()='" + courseName
				+ "']/following-sibling::td[@data-label='Actions']//button[contains(@class,'ant-switch')]";
		elementUtils.waitForElementToBeClickable(By.xpath(xpath), Constants.DEFAULT_WAIT).click();
	}

	// Assign Courses
	public void doClickAssignCourses(String courseName) {
		String xpath = "(//td[normalize-space()='" + courseName
				+ "']/following-sibling::td[@data-label='Actions']//div[@class='actionicons editPencil '])[3]";
		elementUtils.waitForElementToBeClickable(By.xpath(xpath), Constants.DEFAULT_WAIT).click();
	}

	private By txtHeadingAssignCourses = By.xpath("//span[contains(@class,'baseTitle')]");
	private By dropdownRole = By.xpath("(//div[@class='ant-select-selector'])[3]");
	private By searchRole = By.xpath("//input[@id='type']");
	private By dropdownSelectAgent = By.xpath("(//div[@class='ant-select-selector'])[4]");
	private By searchAgent = By.xpath("//input[@id='user_ids']");
	private By dataEmployeeIdForAssignedTo = By.xpath("//div[@class='assigned-agent']");
	private By dropdownSelectPurpose = By.xpath("(//div[@class='ant-select-selector'])[5]");

	public By getSelectOptionByText(String visibleText) {
		String xpath = "//div[@class='ant-select-item-option-content'][normalize-space()='" + visibleText + "']";
		return By.xpath(xpath);
	}

	private By btnSaveAssignCourse = By.xpath("//button[contains(@type,'submit')]");

	public void doClickEditCourses(String courseName) {
		String xpath = "//td[normalize-space()='" + courseName
				+ "']/following-sibling::td[@data-label='Actions']//div[@class='actionicons editPencil']";
		elementUtils.waitForElementToBeClickable(By.xpath(xpath), Constants.DEFAULT_WAIT).click();
	}

	public void doClickDeleteCourse(String courseName) {
		String xpath = "//td[normalize-space()='" + courseName
				+ "']/following-sibling::td[@data-label='Actions']//div[@class='actionicons deleteIcon']";
		elementUtils.waitForElementToBeClickable(By.xpath(xpath), Constants.DEFAULT_WAIT).click();
	}

	// Data Course Overview
	private By dataBranchName = By.xpath("(//td[@data-label='Branch Name'])[1]");
	private By dataReferenceNumber = By.xpath("(//td[@data-label='Ref Number'])[1]");
	private By dataCourseName = By.xpath("(//td[@data-label='Course Name'])[1]");
	private By dataCategory = By.xpath("(//td[@data-label='Category'])[1]");
	private By dataPaidOrUnpaid = By.xpath("(//td[@data-label='Paid/Unpaid'])[1]");
	private By dataModules = By.xpath("(//td[@data-label='Modules'])[1]");
	private By dataCourseCompletionTimeValue = By.xpath("(//td[@data-label='Course Completion Time'])[1]");
	private By dataCourseDurationValue = By.xpath("(//td[@data-label='Course Duration'])[1]");
	private By dataCreatedAt = By.xpath("(//td[@data-label='Created At'])[1]");
	private By dataStatus = By.xpath("(//td[@data-label='Status'])[1]/div");

	// Common locators
	private By txtSuccessMessage = By.xpath("//div[contains(@class,'Toastify__toast-icon')]/following-sibling::div");
	private By btnOk = By.xpath("//button[normalize-space()='OK']");

	public TotalCoursesPage(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(driver);
	}

	public String getHeadingCourses() {
		return elementUtils.getText(txtHeadingCourses, Constants.DEFAULT_WAIT);
	}

	public void clickOnAddNewCourse() {
		elementUtils.waitForElementToBeClickable(btnAddNewCourse, Constants.DEFAULT_WAIT).click();
	}

	public boolean isAddNewCourseButtonDisplayed() {
		return elementUtils.doIsDisplayed(btnAddNewCourse, Constants.DEFAULT_WAIT);
	}

	public boolean isTabBasicInfoDisplayed() {
		return elementUtils.doIsDisplayed(tabasicInfo, Constants.DEFAULT_WAIT);
	}

	public void fillBasicInfo(String courseName, String certificateName, String categoryName, String paymentType,
			String assignmentDuration, String deadlineType, String completionDeadline, String courseDescription,
			String assessment, String instructorType, String instructorName, String courseEvaluator,
			String requiresCourseCompletionToSchedule) throws InterruptedException {
		elementUtils.waitForElementVisible(txtboxCourseName, Constants.DEFAULT_WAIT).sendKeys(courseName);
		elementUtils.waitForElementToBeClickable(dropdownSelectCertificate, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementVisible(searchCertificate, Constants.DEFAULT_WAIT).sendKeys(certificateName);
		Thread.sleep(1000);
		elementUtils.pressEnterKey();

		elementUtils.waitForElementToBeClickable(dropdownSelectCategory, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementVisible(searchCategory, Constants.DEFAULT_WAIT).sendKeys(categoryName);
		Thread.sleep(1000);
		elementUtils.pressEnterKey();

		elementUtils.waitForElementToBeClickable(dropdownPaymentType, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementToBeClickable(getPaymentTypeOption(paymentType), Constants.DEFAULT_WAIT).click();

		elementUtils.waitForElementVisible(txtboxAssignmentDuration, Constants.DEFAULT_WAIT)
				.sendKeys(assignmentDuration);

		elementUtils.waitForElementToBeClickable(dropdownDeadlineType, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementVisible(getDeadlineTypeOption(deadlineType), Constants.DEFAULT_WAIT).click();

		elementUtils.waitForElementVisible(txtboxCompletionDeadline, Constants.DEFAULT_WAIT)
				.sendKeys(completionDeadline);

		elementUtils.waitForElementVisible(txtboxCourseDescription, Constants.DEFAULT_WAIT).sendKeys(courseDescription);

		elementUtils.waitForElementToBeClickable(getAssessmentLocator(assessment), Constants.DEFAULT_WAIT).click();

		elementUtils.waitForElementToBeClickable(dropdownInstructor, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementToBeClickable(getInstructorTypeOption(instructorType), Constants.DEFAULT_WAIT)
				.click();

		elementUtils.waitForElementVisible(txtboxInstructorName, Constants.DEFAULT_WAIT).sendKeys(instructorName);

		elementUtils.waitForElementToBeClickable(dropdownCourseEvaluator, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementVisible(searchCourseEvaluator, Constants.DEFAULT_WAIT).sendKeys(courseEvaluator);
		elementUtils.pressEnterKey();

		elementUtils.waitForElementToBeClickable(
				getRequiresCourseCompletionToScheduleLocator(requiresCourseCompletionToSchedule),
				Constants.DEFAULT_WAIT).click();
	}

	public void clickOnSaveCourse() {
		elementUtils.waitForElementToBeClickable(btnSaveCourse, Constants.DEFAULT_WAIT).click();
	}

	public boolean isUpdateCourseHeadingDisplayed() {
		return elementUtils.doIsDisplayed(txtHeadingUpdateCourse, Constants.DEFAULT_WAIT);
	}

	// Module tab
	public boolean isModuleTabDisplayed() {
		elementUtils.waitForInvisibilityOfElementLocated(txtSuccessMessage, Constants.DEFAULT_WAIT);
		return elementUtils.doIsDisplayed(tabModule, Constants.DEFAULT_WAIT);
	}

	public void clickOnModuleTab() {
		elementUtils.waitForElementVisible(tabModule, Constants.DEFAULT_WAIT);
		elementUtils.waitForElementToBeClickable(tabModule, Constants.DEFAULT_WAIT).click();
	}

	public void clickOnAddNewModule() {
		elementUtils.waitForElementToBeClickable(btnAddNewModule, Constants.DEFAULT_WAIT).click();
	}

	public boolean uploadFileSuccessMessageIsDisplayed() {
		return elementUtils.doIsDisplayed(uploadefileSucessMessage, Constants.DEFAULT_WAIT);
	}

	public boolean isUploadHeadingTextDisplayed() {
		return elementUtils.doIsDisplayed(txtUploadFiles, Constants.DEFAULT_WAIT);
	}

	public void fillModuleDetails(String moduleName, String moduleDuration, String moduleContent, String filePath,
			String fileURL) throws InterruptedException {
		elementUtils.waitForElementVisible(txtModuleName, Constants.DEFAULT_WAIT).sendKeys(moduleName);
		elementUtils.waitForElementVisible(txtModuleDuration, Constants.DEFAULT_WAIT).sendKeys(moduleDuration);
		elementUtils.waitForElementVisible(txtboxModuleContent, Constants.DEFAULT_WAIT).sendKeys(moduleContent);
		Thread.sleep(1000);
		elementUtils.waitForElementToBeClickable(btnUploadFiles, Constants.DEFAULT_WAIT).click();
		isUploadHeadingTextDisplayed();
		elementUtils.uploadFile(uploadFile, filePath);
		uploadFileSuccessMessageIsDisplayed();
		elementUtils.waitForInvisibilityOfElementLocated(uploadefileSucessMessage, Constants.DEFAULT_WAIT);
		elementUtils.waitForElementVisible(txtboxFiles, Constants.DEFAULT_WAIT).sendKeys(fileURL);
	}

	public void clickOnSaveModule() {
		elementUtils.waitForElementToBeClickable(btnModuleSave, Constants.DEFAULT_WAIT).click();
	}

	// Assessments tab
	public boolean isAssessmentsTabDisplayed() {
		return elementUtils.doIsDisplayed(tabAssessments, Constants.DEFAULT_WAIT);
	}

	public void clickOnTabAssessments() {
		elementUtils.waitForInvisibilityOfElementLocated(txtSuccessMessage, Constants.DEFAULT_WAIT);
		elementUtils.waitForElementToBeClickable(tabAssessments, Constants.DEFAULT_WAIT).click();
	}

	public void clickOnAddNewAssessment() {
		elementUtils.waitForElementToBeClickable(btnAddNewAssessment, Constants.DEFAULT_WAIT).click();
	}

	public void fillAssessmentDetails(String assessmentNameText, String duration, String moduleName, String remarks,
			String totalPoints, String minimumPoints, String methodOfAssessment) throws InterruptedException {
		elementUtils.waitForElementVisible(assessmentName, Constants.DEFAULT_WAIT).sendKeys(assessmentNameText);
		elementUtils.waitForElementVisible(txtboxDuration, Constants.DEFAULT_WAIT).sendKeys(duration);
		Thread.sleep(1000);
		elementUtils.waitForElementToBeClickable(dropdownSelectModule, Constants.DEFAULT_WAIT).click();
		elementUtils.selectElementThroughLocator(searchModuleValues, moduleName, Constants.DEFAULT_WAIT);
		elementUtils.pressEscapeKey();
		elementUtils.waitForElementToBeClickable(getRemarksLocator(remarks), Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementVisible(txtboxTotalPoints, Constants.DEFAULT_WAIT).sendKeys(totalPoints);
		elementUtils.waitForElementVisible(txtboxMinimumPoints, Constants.DEFAULT_WAIT).sendKeys(minimumPoints);
		elementUtils
				.waitForElementToBeClickable(getMethodOfAssessmentLocator(methodOfAssessment), Constants.DEFAULT_WAIT)
				.click();
	}

	public void clickOnSaveAssessment() {
		elementUtils.waitForElementToBeClickable(btnSaveAssessment, Constants.DEFAULT_WAIT).click();
	}

	// Add Question
	public boolean isAddQuestionButtonDisplayed() {
		elementUtils.waitForInvisibilityOfElementLocated(txtSuccessMessage, Constants.DEFAULT_WAIT);
		return elementUtils.doIsDisplayed(btnAddQuestion, Constants.DEFAULT_WAIT);
	}

	public void clickOnAddQuestion() {
		elementUtils.waitForInvisibilityOfElementLocated(txtSuccessMessage, Constants.DEFAULT_WAIT);
		elementUtils.waitForElementToBeClickable(btnAddQuestion, Constants.DEFAULT_WAIT).click();
	}

	public boolean isQuestionnaireTypeHeadingDisplayed() {
		elementUtils.waitForInvisibilityOfElementLocated(txtSuccessMessage, Constants.DEFAULT_WAIT);
		return elementUtils.doIsDisplayed(txtHeadingQuestionnaireType, Constants.DEFAULT_WAIT);
	}

	public void fillQuestionDetails(String questionnaireType, String questionScore, String question,
			String predictedAnswer) throws InterruptedException {
		elementUtils.waitForInvisibilityOfElementLocated(txtSuccessMessage, Constants.DEFAULT_WAIT);
		elementUtils.waitForElementToBeClickable(dropdownQuestionnaireType, Constants.DEFAULT_WAIT).click();
		elementUtils.selectElementThroughLocator(valuesQuestionnaireType, questionnaireType, Constants.DEFAULT_WAIT);
		Thread.sleep(1000);
		elementUtils.waitForElementVisible(txtboxQuestionScore, Constants.DEFAULT_WAIT).sendKeys(questionScore);
		elementUtils.waitForElementVisible(txtboxQuestion, Constants.DEFAULT_WAIT).sendKeys(question);
		elementUtils.waitForElementVisible(btnEnterPredictedQuestiuon, Constants.DEFAULT_WAIT)
				.sendKeys(predictedAnswer);
	}

	public void clickOnNext() {
		elementUtils.waitForElementToBeClickable(btnNext, Constants.DEFAULT_WAIT).click();
	}

	public void clickOnSubmitQuestion() {
		elementUtils.waitForElementToBeClickable(btnSubmitQuestion, Constants.DEFAULT_WAIT).click();
	}

	public void clickOnAllAssessments() {
		elementUtils.waitForElementToBeClickable(btnAllAssessments, Constants.DEFAULT_WAIT).click();
	}

	// Course Overview

	public boolean isCourseOverviewTabDisplayed() {
		elementUtils.waitForInvisibilityOfElementLocated(txtSuccessMessage, Constants.DEFAULT_WAIT);
		return elementUtils.doIsDisplayed(tabCourseOverview, Constants.DEFAULT_WAIT);
	}

	public void clickOnTabCourseOverview() {
		elementUtils.waitForInvisibilityOfElementLocated(txtSuccessMessage, Constants.DEFAULT_WAIT);
		elementUtils.waitForElementToBeClickable(tabCourseOverview, Constants.DEFAULT_WAIT).click();
	}

	public String getHeadingAboutTheCourse() {
		return elementUtils.getText(txtHeadingAboutTheCourse, Constants.DEFAULT_WAIT);
	}

	public String getCourseType() {
		return elementUtils.getText(dataCourseType, Constants.DEFAULT_WAIT);
	}

	public String getCourseDuration() {
		return elementUtils.getText(dataCourseDuration, Constants.DEFAULT_WAIT);
	}

	public String getCourseCompletionTime() {
		return elementUtils.getText(dataCourseCompletionTime, Constants.DEFAULT_WAIT);
	}

	public String getCourseCategory() {
		return elementUtils.getText(dataCourseCategory, Constants.DEFAULT_WAIT);
	}

	public void clickOnPublishCourse() {
		elementUtils.waitForElementToBeClickable(btnPublishCourse, Constants.DEFAULT_WAIT).click();
	}

	public String getSuccessMessage() {
		return elementUtils.getText(txtSuccessMessage, Constants.DEFAULT_WAIT);
	}

	public void clickOnOk() {
		elementUtils.waitForElementToBeClickable(btnOk, Constants.DEFAULT_WAIT).click();
	}

	// Data Course Overview
	public String getBranchName() {
		return elementUtils.getText(dataBranchName, Constants.DEFAULT_WAIT);
	}

	public String getReferenceNumber() {
		return elementUtils.getText(dataReferenceNumber, Constants.DEFAULT_WAIT);
	}

	public String getCourseName() {
		return elementUtils.getText(dataCourseName, Constants.DEFAULT_WAIT);
	}

	public String getCategory() {
		return elementUtils.getText(dataCategory, Constants.DEFAULT_WAIT);
	}

	public String getPaidOrUnpaid() {
		return elementUtils.getText(dataPaidOrUnpaid, Constants.DEFAULT_WAIT);
	}

	public String getModules() {
		return elementUtils.getText(dataModules, Constants.DEFAULT_WAIT);
	}

	public String getCourseCompletionTimeValue() {
		return elementUtils.getText(dataCourseCompletionTimeValue, Constants.DEFAULT_WAIT);
	}

	public String getCourseDurationValue() {
		return elementUtils.getText(dataCourseDurationValue, Constants.DEFAULT_WAIT);
	}

	public String getCreatedAt() {
		return elementUtils.getText(dataCreatedAt, Constants.DEFAULT_WAIT);
	}

	public String getStatus() {
		return elementUtils.getText(dataStatus, Constants.DEFAULT_WAIT);
	}

	// Assign Courses
	public String getHeadingAssignCourses() {
		return elementUtils.getText(txtHeadingAssignCourses, Constants.DEFAULT_WAIT);
	}

	public void fillCouseAssignForm(String role, String agentID, String purpose) throws InterruptedException {
		elementUtils.waitForElementToBeClickable(dropdownRole, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementVisible(searchRole, Constants.DEFAULT_WAIT);
		elementUtils.doActionsSendKeys(searchRole, role);
		Thread.sleep(2000);
		elementUtils.pressEnterKey();
		elementUtils.pressEscapeKey();

		elementUtils.waitForElementToBeClickable(dropdownSelectAgent, Constants.DEFAULT_WAIT).click();
		elementUtils.doActionsSendKeys(searchAgent, agentID);
		Thread.sleep(5000);
		elementUtils.pressEnterKey();
		elementUtils.pressEscapeKey();

		elementUtils.waitForElementToBeClickable(dropdownSelectPurpose, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementToBeClickable(getSelectOptionByText(purpose), Constants.DEFAULT_WAIT).click();
	}

	public void doClickSaveAssignCourse() throws InterruptedException {
		elementUtils.waitForElementToBeClickable(btnSaveAssignCourse, Constants.DEFAULT_WAIT).click();
	}

	public String getEmployeeIdForAssignedTo() {
		return elementUtils.waitForElementVisible(dataEmployeeIdForAssignedTo, Constants.DEFAULT_WAIT).getText();
	}

}
