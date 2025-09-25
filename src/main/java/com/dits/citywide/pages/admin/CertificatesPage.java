package com.dits.citywide.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.dits.citywide.constants.Constants;
import com.dits.citywide.utilities.ElementUtils;

public class CertificatesPage {

	private WebDriver driver;
	private ElementUtils elementUtils;

	private By txtHeadingCertificates = By.xpath("//h1[@class='heading-text']");
	private By btnAddNewCertificate = By.xpath("//span[normalize-space()='Add New Certificate']");
	private By txtboxCertificateName = By.xpath("//input[@id='name']");
	private By txtboxSerialNumber = By.xpath("//input[@id='serial_number']");
	private By uploadCertificate = By.xpath("//input[@type='file']");
	private By confirmationMessageFileUpload = By.xpath("//div[contains(text(),'File uploaded successfully')]");
	private By btnAddText = By.xpath("//span[normalize-space()='Add Text']");
	private By txtboxAddText = By.xpath("//div[@aria-label='rdw-editor']");
	private By btnSubmitPDF = By.xpath("//span[normalize-space()='Submit Pdf']");
	private By btnOK = By.xpath("//span[normalize-space()='Ok']");
	private By txtboxCertificateDescription = By.xpath("//textarea[@id='notes']");
	private By btnSaveCertificate = By.cssSelector("button[type='submit']");

	private By dataCertificateName = By.xpath("(//td[@data-label='Certificate Name'])[1]");
	private By dataAdddedBy = By.xpath("(//td[@data-label='Added By'])[1]");
	private By dataDescription = By.xpath("(//td[@data-label='Description'])[1]");
	private By dataCreatedAt = By.xpath("(//td[@data-label='Created At'])[1]/span");

	private By sucessMessage = By.xpath("//div[contains(@class,'Toastify__toast-icon')]/following-sibling::div");
	private By btnOkDelete = By.xpath("//button[normalize-space()='OK']");

	public CertificatesPage(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(driver);
	}

	public String getHeadingCertificates() {
		return elementUtils.getText(txtHeadingCertificates, Constants.DEFAULT_WAIT);
	}

	public void clickOnAddNewCertificate() {
		elementUtils.waitForElementToBeClickable(btnAddNewCertificate, Constants.DEFAULT_WAIT).click();
	}

	public boolean isAddNewCertificateButtonDisplayed() {
		return elementUtils.doIsDisplayed(btnAddNewCertificate, Constants.DEFAULT_WAIT);
	}

	public boolean isConfirmationMessageFileUploadDisplayed() {
		return elementUtils.doIsDisplayed(confirmationMessageFileUpload, Constants.DEFAULT_WAIT);
	}

	public void fillCertificateName(String certificateName, String serialNumber, String filePath,
			String certificateDescription) throws InterruptedException {
		elementUtils.waitForElementVisible(txtboxCertificateName, Constants.DEFAULT_WAIT).sendKeys(certificateName);
		elementUtils.waitForElementVisible(txtboxSerialNumber, Constants.DEFAULT_WAIT).sendKeys(serialNumber);
		elementUtils.uploadFile(uploadCertificate, filePath);
		isConfirmationMessageFileUploadDisplayed();
		elementUtils.waitForElementToBeClickable(btnAddText, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementVisible(txtboxAddText, Constants.DEFAULT_WAIT)
				.sendKeys("This is a test certificate text.");
		elementUtils.waitForElementToBeClickable(btnOK, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForInvisibilityOfElementLocated(confirmationMessageFileUpload, Constants.DEFAULT_WAIT);
		//Thread.sleep(3000);
		elementUtils.waitForElementVisible(btnSubmitPDF, Constants.MEDIUM_TIME_OUT_WAIT);
		elementUtils.waitForElementToBeClickable(btnSubmitPDF, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementVisible(txtboxCertificateDescription, Constants.DEFAULT_WAIT)
				.sendKeys(certificateDescription);
	}

	public void clickOnSaveCertificate() {
		elementUtils.waitForElementToBeClickable(btnSaveCertificate, Constants.DEFAULT_WAIT).click();
	}

	public String getCertificateName() {
		return elementUtils.getText(dataCertificateName, Constants.DEFAULT_WAIT);
	}

	public String getAddedBy() {
		return elementUtils.getText(dataAdddedBy, Constants.DEFAULT_WAIT);
	}

	public String getDescription() {
		return elementUtils.getText(dataDescription, Constants.DEFAULT_WAIT);
	}

	public String getCreatedDate() {
		return elementUtils.getText(dataCreatedAt, Constants.DEFAULT_WAIT);
	}

	public String getSuccessMessage() {
		return elementUtils.getText(sucessMessage, Constants.DEFAULT_WAIT);
	}

	// Update Certificate
	public void clickEditCertificateButton(String certificateName) {
		String editXpath = "(//td[@data-label='Certificate Name' and normalize-space()='" + certificateName
				+ "']/following-sibling::td//div[@class='actionicons editPencil'])[1]";
		elementUtils.waitForElementToBeClickable(By.xpath(editXpath), Constants.DEFAULT_WAIT).click();
	}

	public void updateCertificateName(String updatedCertificateName, String updatedSerialNumber,
			String updatedDescription) {
		elementUtils.waitForElementVisible(txtboxCertificateName, Constants.DEFAULT_WAIT);
		elementUtils.clearTextBoxWithActions(txtboxCertificateName);
		elementUtils.doActionsSendKeys(txtboxCertificateName, updatedCertificateName);

		elementUtils.waitForElementVisible(txtboxSerialNumber, Constants.DEFAULT_WAIT);
		elementUtils.clearTextBoxWithActions(txtboxSerialNumber);
		elementUtils.doActionsSendKeys(txtboxSerialNumber, updatedSerialNumber);

		elementUtils.waitForElementVisible(txtboxCertificateDescription, Constants.DEFAULT_WAIT);
		elementUtils.clearTextBoxWithActions(txtboxCertificateDescription);
		elementUtils.doActionsSendKeys(txtboxCertificateDescription, updatedDescription);

		elementUtils.waitForElementToBeClickable(btnSaveCertificate, Constants.DEFAULT_WAIT).click();
	}

	public void clickOnSaveUpdatedCertificate() {
		elementUtils.waitForElementToBeClickable(btnSaveCertificate, Constants.DEFAULT_WAIT).click();
	}

	// Delete Certificate
	public void clickDeleteCertificateButton(String certificateName) {
		String editXpath = "//td[@data-label='Certificate Name' and normalize-space()='" + certificateName
				+ "']/following-sibling::td//div[@class='actionicons deleteIcon']";
		elementUtils.waitForElementToBeClickable(By.xpath(editXpath), Constants.DEFAULT_WAIT).click();
	}

	public void clickOnDeleteButton() {
		elementUtils.waitForElementToBeClickable(btnOkDelete, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForInvisibilityOfElementLocated(btnOkDelete, Constants.DEFAULT_WAIT);
	}

}
