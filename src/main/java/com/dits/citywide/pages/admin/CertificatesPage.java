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
	private By btnSaveCertificate = By.xpath("//button[@type='submit']");

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

	public boolean isConfirmationMessageFileUploadDisplayed() {
		return elementUtils.doIsDisplayed(confirmationMessageFileUpload, Constants.DEFAULT_WAIT);
	}

	public void fillCertificateName(String certificateName, String serialNumber, String filePath,
			String certificateDescription) {
		elementUtils.waitForElementVisible(txtboxCertificateName, Constants.DEFAULT_WAIT).sendKeys(certificateName);
		elementUtils.waitForElementVisible(txtboxSerialNumber, Constants.DEFAULT_WAIT).sendKeys(serialNumber);
		elementUtils.uploadFile(uploadCertificate, filePath);
		isConfirmationMessageFileUploadDisplayed();
		elementUtils.waitForElementToBeClickable(btnAddText, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementVisible(txtboxAddText, Constants.DEFAULT_WAIT)
				.sendKeys("This is a test certificate text.");
		elementUtils.waitForElementToBeClickable(btnOK, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForInvisibilityOfElementLocated(confirmationMessageFileUpload, Constants.DEFAULT_WAIT);
		elementUtils.waitForElementToBeClickable(btnSubmitPDF, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementVisible(txtboxCertificateDescription, Constants.DEFAULT_WAIT)
				.sendKeys(certificateDescription);
	}

	public void clickOnSaveCertificate() {
		elementUtils.waitForElementToBeClickable(btnSaveCertificate, Constants.DEFAULT_WAIT).click();
	}

}
