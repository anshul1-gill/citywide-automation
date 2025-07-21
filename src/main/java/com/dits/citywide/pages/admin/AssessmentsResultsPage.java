package com.dits.citywide.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.dits.citywide.constants.Constants;
import com.dits.citywide.utilities.ElementUtils;

public class AssessmentsResultsPage {

	private WebDriver driver;
	private ElementUtils elementUtils;

	private By txtAssessmentResults = By.xpath("//h1[normalize-space()='Assessment Results']");
	private By dropdownSelectStatus = By.xpath("(//div[@class='ant-select-selector'])[2]");
	private By valueSelectStatus = By.xpath("//div[@class='rc-virtual-list-holder-inner']/div/div");

	public By dataAssignedTo(String courseName) {
		String xpath = "(//td[normalize-space()='" + courseName + "']/following-sibling::td)[1]";
		return By.xpath(xpath);
	}

	public By dataAssignedBy(String courseName) {
		String xpath = "(//td[normalize-space()='" + courseName + "']/following-sibling::td)[2]";
		return By.xpath(xpath);
	}

	public By dataCategory(String courseName) {
		String xpath = "(//td[normalize-space()='" + courseName + "']/following-sibling::td)[3]/span";
		return By.xpath(xpath);
	}

	public By dataStatus(String courseName) {
		String xpath = "(//td[normalize-space()='" + courseName + "']/following-sibling::td)[5]/div";
		return By.xpath(xpath);
	}

	public By getRefNumber(String courseName) {
		String xpath = "//td[normalize-space()='" + courseName + "']/preceding-sibling::td[1]";
		return By.xpath(xpath);
	}

	public By btnViewDetails(String courseName) {
		String xpath = "//td[normalize-space()='" + courseName + "']/preceding-sibling::td[2]";
		return By.xpath(xpath);
	}

	public By getMinPoint(String assessmentName) {
		String xpath = "(//td[div[normalize-space()='" + assessmentName + "']]/following-sibling::td)[1]";
		return By.xpath(xpath);
	}

	public By getTotalPoint(String assessmentName) {
		String xpath = "(//td[div[normalize-space()='" + assessmentName + "']]/following-sibling::td)[2]";
		return By.xpath(xpath);
	}

	public By getObtainedPoint(String assessmentName) {
		String xpath = "(//td[div[normalize-space()='" + assessmentName + "']]/following-sibling::td)[3]";
		return By.xpath(xpath);
	}

	public By getStatus(String assessmentName) {
		String xpath = "(//td[div[normalize-space()='" + assessmentName + "']]/following-sibling::td)[4]/div";
		return By.xpath(xpath);
	}

	public By viewAction(String assessmentName) {
		String xpath = "(//td[div[normalize-space()='" + assessmentName
				+ "']]/following-sibling::td)[5]//div[@class='actionicons viewIcon']";
		return By.xpath(xpath);
	}

	private By txtHeadingAssessmentResults = By.xpath("//h1[normalize-space()='Assessment Result']");
	private By dataQuestion1 = By.xpath("//label[@for='text']/span");
	private By dataAnswer1 = By.xpath("//textarea[@id='text']");

	public By getRadioLabelByText(String labelText) {
		String xpath = "//span[@class='ant-radio-label' and normalize-space()='" + labelText + "']";
		return By.xpath(xpath);
	}

	private By btnSaveAssessmentResult = By.xpath("//button[@type='submit']");

	private By txtCandidateSuccessfullyCompletedCourse = By.xpath("(//div[@class='inner-content']/h3)[1]");
	private By txtCertificateSuccessfullyIssuedToCandidate = By.xpath("(//div[@class='inner-content']/h3)[2]");

	private By btnBackToAssessmentResults = By.xpath("//span[normalize-space()='Back to assessment']");

	public AssessmentsResultsPage(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(driver);
	}

	public String getHeadingAssessmentResults() {
		return elementUtils.getText(txtAssessmentResults, Constants.DEFAULT_WAIT).trim();
	}

//	public void clickOnSelectStatus() {
//		elementUtils.waitForElementToBeClickable(dropdownSelectStatus, Constants.DEFAULT_WAIT).click();
//	}

	public void selectStatus(String statusName) {
		elementUtils.waitForElementToBeClickable(dropdownSelectStatus, Constants.DEFAULT_WAIT).click();
		elementUtils.selectElementThroughLocator(valueSelectStatus, statusName, Constants.DEFAULT_WAIT);
	}

	public void clickViewDetailsByCourseName(String courseName) {
		elementUtils.waitForElementToBeClickable(btnViewDetails(courseName), Constants.DEFAULT_WAIT).click();
	}

	public void clickOnViewActionByAssessmentName(String assessmentName) {
		elementUtils.waitForElementToBeClickable(viewAction(assessmentName), Constants.DEFAULT_WAIT).click();
	}

	public void clickPreductedAnswer(String answer) {
		By radioButton = getRadioLabelByText(answer);
		elementUtils.waitForElementToBeClickable(radioButton, Constants.DEFAULT_WAIT).click();
	}

	public void clickSaveAssessmentResult() {
		elementUtils.waitForElementToBeClickable(btnSaveAssessmentResult, Constants.DEFAULT_WAIT).click();
	}

	public String getCandidateSuccessfullyCompletedCourseText() {
		return elementUtils.getText(txtCandidateSuccessfullyCompletedCourse, Constants.DEFAULT_WAIT).trim();
	}

	public String getCertificateSuccessfullyIssuedToCandidateText() {
		return elementUtils.getText(txtCertificateSuccessfullyIssuedToCandidate, Constants.DEFAULT_WAIT).trim();
	}

	public void clickBackToAssessmentResults() {
		elementUtils.waitForElementToBeClickable(btnBackToAssessmentResults, Constants.DEFAULT_WAIT).click();
	}

}
