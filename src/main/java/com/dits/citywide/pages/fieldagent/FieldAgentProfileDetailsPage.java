package com.dits.citywide.pages.fieldagent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.dits.citywide.constants.Constants;
import com.dits.citywide.utilities.ElementUtils;

public class FieldAgentProfileDetailsPage {

	private WebDriver driver;
	private ElementUtils elementUtils;

//	private By tabPersonalInformation = By.cssSelector("#rc-tabs-0-tab-1");
//	private By tabEmploymentInformation = By.cssSelector("#rc-tabs-0-tab-2");
//	private By tabPermits = By.cssSelector("#rc-tabs-0-tab-3");
//	private By tabPayInfo = By.cssSelector("#rc-tabs-0-tab-4");
//	private By tabAdditionalDocuments = By.cssSelector("#rc-tabs-0-tab-5");
//	private By tabReferences = By.cssSelector("#rc-tabs-0-tab-6");
//	private By tabAvailableTimes = By.cssSelector("#rc-tabs-0-tab-7");
//	private By tabTraining = By.cssSelector("#rc-tabs-0-tab-8");
	private By tabComments = By.cssSelector("#rc-tabs-0-tab-9");

//	// Permits
//	// Driver's License
//	private By dataDriverLicenseNumber = By.xpath("//td[@data-label=\"Driver's License Number\"]");
//	private By dataDateOfIssue = By.xpath("//td[@data-label='Date of Issue']");
//	private By dataDateOfExpiration = By.xpath("//td[@data-label='Date of Expiration']");
//
//	// Guard Card
//	private By tabGuardCard = By.cssSelector("#rc-tabs-3-tab-2");
//	private By dataGaurdCardPermitNumber = By.xpath("//td[@data-label='Permit Number']");
//	private By dataGaurdCardDateOfIssue = By.xpath("//td[@data-label='Date of Issue']");
//	private By dataGaurdCardDateOfExpiration = By.xpath("//td[@data-label='Date of Expiration']");
//	private By dataFile = By.xpath("(//div[@class='ant-image-mask'])[2]");
//
//	// Firearms Qualification
//	private By tabFirearmsQualification = By.cssSelector("#rc-tabs-3-tab-3");
//	private By dataFirearmsPermitNumber = By.xpath("//td[@data-label='Permit Number']");
//	private By dataFirearmsDateOfIssue = By.xpath("//td[@data-label='Date of Issue']");
//	private By dataFirearmsDateOfExpiration = By.xpath("//td[@data-label='Date of Expiration']");
//
//	// Baton
//	private By tabBaton = By.cssSelector("#rc-tabs-3-tab-4");
//	private By dataBatonPermitNumber = By.xpath("//td[@data-label='Permit Number']");
//	private By dataBatonDateOfIssue = By.xpath("//td[@data-label='Date of Issue']");
//	private By databatonDateOfExpiration = By.xpath("//td[@data-label='Date of Expiration']");
//
//	// ECD
//	private By tabECD = By.cssSelector("#rc-tabs-3-tab-5");
//	private By dataECDPermitNumber = By.xpath("//td[@data-label='Permit Number']");
//	private By dataECDDateOfIssue = By.xpath("//td[@data-label='Date of Issue']");
//	private By dataECDDateOfExpiration = By.xpath("//td[@data-label='Date of Expiration']");
//
//	// OC Spray
//	private By tabOCSpray = By.cssSelector("#rc-tabs-3-tab-6");
//	private By dataOCSprayPermitNumber = By.xpath("//td[@data-label='Permit Number']");
//	private By dataOCSprayDateOfIssue = By.xpath("//td[@data-label='Date of Issue']");
//	private By dataOCSprayDateOfExpiration = By.xpath("//td[@data-label='Date of Expiration']");
//
//	// Other Permits
//	private By tabOtherPermits = By.cssSelector("#rc-tabs-3-tab-7");
//	private By dataOtherPermitPermitNumber = By.xpath("//td[@data-label='Permit Number']");
//	private By dataOtherPermitDateOfIssue = By.xpath("//td[@data-label='Date of Issue']");
//	private By dataOtherPermitDateOfExpiration = By.xpath("//td[@data-label='Date of Expiration']");

// Comments
	private By txtHeadingComments = By.xpath(
			"//div[contains(@class,'primary-heading configuration-setting-header')]/span[contains(text(),'Comments')]");

	private By getRemarkCategoryCell(String remarkCategory) {
		String xpath = String.format("//td[normalize-space()='%s']", remarkCategory);
		return By.xpath(xpath);
	}

	private By getReasonByCategory(String remarkCategory) {
		String xpath = String.format("//td[normalize-space()='%s']/following-sibling::td/span", remarkCategory);
		return By.xpath(xpath);
	}

	private By getCommentByCategory(String remarkCategory) {
		String xpath = String.format("//td[normalize-space()='%s']/following-sibling::td[@data-label='Comment']",
				remarkCategory);
		return By.xpath(xpath);
	}

	private By getPostedByByCategory(String remarkCategory) {
		String xpath = String.format("//td[normalize-space()='%s']/following-sibling::td[@data-label='Posted By']",
				remarkCategory);
		return By.xpath(xpath);
	}

	private By getCreatedByCategory(String remarkCategory) {
		String xpath = String.format("//td[normalize-space()='%s']/following-sibling::td[@data-label='Created']",
				remarkCategory);
		return By.xpath(xpath);
	}

	private By getResponseDropdownByCategory(String remarkCategory) {
		String xpath = String.format("//td[normalize-space()='%s']" + "/following-sibling::td[@data-label='Response']"
				+ "//span[@class='ant-select-selection-search']", remarkCategory);
		return By.xpath(xpath);
	}

	private By getResponseByValue(String responseValue) {
		String xpath = String.format("//div[contains(text(),'%s')]", responseValue);
		return By.xpath(xpath);
	}

	private By confimationMessage = By.cssSelector("#swal2-html-container");
	private By btnOk = By.cssSelector("button[class='swal2-confirm swal2-styled']");

	private By txtboxHeading = By.xpath("//span[@class='baseTitle']");
	private By txtboxReason = By.cssSelector("#reason");
	private By btnSubmit = By.xpath("//span[normalize-space()='Submit']");
	
	private By sucessMessage = By.xpath("//div[contains(@class,'Toastify__toast-icon')]/following-sibling::div");

	public FieldAgentProfileDetailsPage(WebDriver driver) {
		this.driver = driver;
		this.elementUtils = new ElementUtils(driver);
	}

	public void clickCommentsTab() {
		elementUtils.waitForElementToBeClickable(tabComments, Constants.DEFAULT_WAIT).click();
	}

	public String getHeadingText() {
		return elementUtils.waitForElementVisible(txtHeadingComments, Constants.DEFAULT_WAIT).getText();
	}

	public String getRemarkCategoryText(String remarkCategory) {
		return elementUtils.waitForElementVisible(getRemarkCategoryCell(remarkCategory), Constants.DEFAULT_WAIT)
				.getText();
	}

	public String getReasonText(String remarkCategory) {
		return elementUtils.waitForElementVisible(getReasonByCategory(remarkCategory), Constants.DEFAULT_WAIT)
				.getText();
	}

	public String getCommentByCategoryText(String remarkCategory) {
		return elementUtils.waitForElementVisible(getCommentByCategory(remarkCategory), Constants.DEFAULT_WAIT)
				.getText();
	}

	public String getPostedByText(String remarkCategory) {
		return elementUtils.waitForElementVisible(getPostedByByCategory(remarkCategory), Constants.DEFAULT_WAIT)
				.getText();
	}

	public String getCreatedByText(String remarkCategory) {
		return elementUtils.waitForElementVisible(getCreatedByCategory(remarkCategory), Constants.DEFAULT_WAIT)
				.getText();
	}

	public String getResponseText(String remarkCategory) {
		return elementUtils.waitForElementVisible(getResponseDropdownByCategory(remarkCategory), Constants.DEFAULT_WAIT)
				.getText();
	}

	public void selectResponse(String remarkCategory, String responseValue) throws InterruptedException {
		elementUtils.waitForElementVisible(getResponseDropdownByCategory(remarkCategory), Constants.DEFAULT_WAIT)
				.click();
		elementUtils.waitForElementVisible(getResponseByValue(responseValue), Constants.DEFAULT_WAIT).click();
	}

	public String getConfirmationMessage() {
		return elementUtils.waitForElementVisible(confimationMessage, Constants.DEFAULT_WAIT).getText();
	}

	public void clickOk() {
		elementUtils.waitForElementToBeClickable(btnOk, Constants.DEFAULT_WAIT).click();
	}

	public String getHeadingTextBox() {
		return elementUtils.waitForElementVisible(txtboxHeading, Constants.DEFAULT_WAIT).getText();
	}

	public void fillReasonTextBox(String reason) {
		elementUtils.waitForElementToBeClickable(txtboxReason, Constants.DEFAULT_WAIT).sendKeys(reason);
	}

	public void clickSubmit() {
		elementUtils.waitForElementToBeClickable(btnSubmit, Constants.DEFAULT_WAIT).click();
	}
	
	public String getSuccessMessage() {
		return elementUtils.waitForElementVisible(sucessMessage, Constants.DEFAULT_WAIT).getText();
	}

}
