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
	private By valuesPaymentType = By.xpath("(//div[@class='rc-virtual-list-holder-inner'])[1]/div/div");
	private By dropdownCouseDuration = By.xpath("(//span[@class='ant-select-selection-wrap'])[5]");
	private By valuesCourseDuration = By.xpath("(//div[@class='rc-virtual-list-holder-inner'])[1]/div/div");
	private By txtboxCourseDurationValue = By.xpath("//input[@id='duration_value']");
	private By dropdownCourseCompletionTime = By.xpath("(//span[@class='ant-select-selection-wrap'])[6]");
	private By valuesCourseCompletionTime = By.xpath("(//div[@class='rc-virtual-list-holder-inner'])[2]/div/div");
	private By txtboxCourseCompletionTimeValue = By.xpath("//input[@id='time_period_value']");
	private By txtboxCourseExpirationDate = By.xpath("//input[@id='course_expiration_date']");
	private By txtboxCourseDescription = By.xpath("//div[@aria-label='rdw-editor']");

	private By getAssessmentLocator(String dynamicText) {
		String xpath = "(//span[normalize-space()='" + dynamicText + "'])[1]";
		return By.xpath(xpath);
	}

	private By dropdownInstructor = By.xpath("(//span[@class='ant-select-selection-wrap'])[7]");
	private By txtboxInstructorName = By.xpath("//input[@id='instructor_name']");
	private By valuesInstructor = By.xpath("(//div[@class='rc-virtual-list-holder-inner'])[4]/div/div");
	private By dropdownCourseEvaluator = By.xpath("//input[@id='course_evaluator']");

	private By getRequiresCourseCompletionToScheduleLocator(String dynamicText) {
		String xpath = "(//span[normalize-space()='" + dynamicText + "'])[2]";
		return By.xpath(xpath);
	}

	private By btnSaveCourse = By.xpath("//button[@type='submit']");

	// Module tab
	private By tabModule = By.xpath("//div[@id='rc-tabs-1-tab-chapters']");
	private By btnAddNewModule = By.xpath("//span[normalize-space()='Add New Module']");
	private By txtModuleName = By.xpath("//input[@placeholder='Module Name']");
	private By txtModuleDuration = By.xpath("//input[@id='chapter_duration']");
	private By txtboxModuleContent = By.xpath("//div[@aria-label='rdw-editor']");
	private By btnUploadFiles = By.xpath("//input[@class='ant-input css-1l4zwsq']");
	private By uploadFile = By.xpath("//input[@type='file']");
	private By txtboxFiles = By.xpath("//input[@id='file_url']");
	private By btnModuleSave = By
			.xpath("//div[contains(@class,'ant-spin-container')]//button[contains(@type,'submit')]");

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
			String courseDuration, String courseDurationValue, String courseCompletionTime,
			String courseCompletionTimeValue, String courseExpirationDate, String courseDescription, String assessment,
			String instructor, String instructorName, String courseEvaluator, String requiresCourseCompletionToSchedule)
			throws InterruptedException {
		elementUtils.waitForElementVisible(txtboxCourseName, Constants.DEFAULT_WAIT).sendKeys(courseName);
		elementUtils.waitForElementToBeClickable(dropdownSelectCertificate, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementVisible(searchCertificate, Constants.DEFAULT_WAIT).sendKeys(certificateName);
		elementUtils.pressEnterKey();
		elementUtils.waitForElementToBeClickable(dropdownSelectCategory, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementVisible(searchCategory, Constants.DEFAULT_WAIT).sendKeys(categoryName);
		elementUtils.pressEnterKey();
		elementUtils.waitForElementToBeClickable(dropdownPaymentType, Constants.DEFAULT_WAIT).click();
		elementUtils.selectElementThroughLocator(valuesPaymentType, paymentType, Constants.DEFAULT_WAIT);

		elementUtils.waitForElementToBeClickable(dropdownCouseDuration, Constants.DEFAULT_WAIT).click();
		elementUtils.selectElementThroughLocator(valuesCourseDuration, courseDuration, Constants.DEFAULT_WAIT);
		elementUtils.waitForElementVisible(txtboxCourseDurationValue, Constants.DEFAULT_WAIT)
				.sendKeys(courseDurationValue);

		elementUtils.waitForElementToBeClickable(dropdownCourseCompletionTime, Constants.DEFAULT_WAIT).click();
		elementUtils.selectElementThroughLocator(valuesCourseCompletionTime, courseCompletionTime,
				Constants.DEFAULT_WAIT);
		elementUtils.waitForElementVisible(txtboxCourseCompletionTimeValue, Constants.DEFAULT_WAIT)
				.sendKeys(courseExpirationDate);

		elementUtils.waitForElementVisible(txtboxCourseExpirationDate, Constants.DEFAULT_WAIT)
				.sendKeys(courseExpirationDate);

		elementUtils.waitForElementVisible(txtboxCourseDescription, Constants.DEFAULT_WAIT).sendKeys(courseDescription);

		elementUtils.waitForElementToBeClickable(getAssessmentLocator(assessment), Constants.DEFAULT_WAIT).click();

		elementUtils.waitForElementToBeClickable(dropdownInstructor, Constants.DEFAULT_WAIT).click();
		elementUtils.selectElementThroughLocator(valuesInstructor, instructor, Constants.DEFAULT_WAIT);
		elementUtils.waitForElementVisible(txtboxInstructorName, Constants.DEFAULT_WAIT).sendKeys(instructorName);

		elementUtils.waitForElementToBeClickable(dropdownCourseEvaluator, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementVisible(dropdownCourseEvaluator, Constants.DEFAULT_WAIT).sendKeys(courseEvaluator);
		elementUtils.pressEnterKey();

		elementUtils.waitForElementToBeClickable(
				getRequiresCourseCompletionToScheduleLocator(requiresCourseCompletionToSchedule),
				Constants.DEFAULT_WAIT).click();
		Thread.sleep(12000);
	}

	public void clickOnSaveCourse() {
		elementUtils.waitForElementToBeClickable(btnSaveCourse, Constants.DEFAULT_WAIT).click();
	}

	public boolean isModuleTabDisplayed() {
		return elementUtils.doIsDisplayed(tabModule, Constants.DEFAULT_WAIT);
	}

	public void clickOnAddNewModule() {
		elementUtils.waitForElementToBeClickable(btnAddNewModule, Constants.DEFAULT_WAIT).click();
	}

	public void fillModuleDetails(String moduleName, String moduleDuration, String moduleContent, String filePath,
			String fileURL) {
		elementUtils.waitForElementVisible(txtModuleName, Constants.DEFAULT_WAIT).sendKeys(moduleName);
		elementUtils.waitForElementVisible(txtModuleDuration, Constants.DEFAULT_WAIT).sendKeys(moduleDuration);
		elementUtils.waitForElementVisible(txtboxModuleContent, Constants.DEFAULT_WAIT).sendKeys(moduleContent);
		elementUtils.waitForElementToBeClickable(btnUploadFiles, Constants.DEFAULT_WAIT).click();
		elementUtils.uploadFile(uploadFile, filePath);
		elementUtils.waitForElementVisible(txtboxFiles, Constants.DEFAULT_WAIT).sendKeys(filePath);
	}

}
