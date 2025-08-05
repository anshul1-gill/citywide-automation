package com.dits.citywide.pages.fieldagent;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.dits.citywide.constants.Constants;
import com.dits.citywide.utilities.ElementUtils;

public class PassdownLogsPage {

	private WebDriver driver;
	private ElementUtils elementUtils;

	private By tabPassdownLogs = By.xpath("//span[normalize-space()='Passdown Logs']");
	private By btnAddPassdownLog = By.xpath("//span[normalize-space()='Add New Passdown']");

	// Add New Passdown Log
	private By siteNameDropdownValue = By.xpath("//span[@class='ant-select-selection-search']");
	private By searchSiteName = By.xpath("//input[@id='patrol_site_id']");
	private By txtboxMessage = By.xpath("//textarea[@id='passdown_message']");
	private By uploadImage = By.xpath("//input[@type='file']");
	private By txtHeadingEditImage = By.xpath("//span[@class='baseTitle']");
	private By btnUploadImage = By.xpath("//span[normalize-space()='Upload']");
	private By txtboxImageName = By.xpath("//input[@id='Name0']");
	private By txtboxImageDescription = By.xpath("//input[@id='Description0']");
	private By btnSavePassdown = By.xpath("//span[normalize-space()='Save Passdown']");
	private By btnSaveAndScanQRCode = By.xpath("//span[normalize-space()='Save and Scan QR Code']");

	// Data
	private By dataSiteName = By.xpath("(//td[@data-label='Site'])[1]");
	private By dataMessage = By.xpath("(//td[@data-label='Message'])[1]");

	// View Passdown Log
	private By btnView(String message) {
		String xpath = "//pre[normalize-space()='" + message
				+ "']/../following-sibling::td//a[@class='cursor-pointer']";
		return By.xpath(xpath);
	}

	private By txtHeadingViewPassdownDetails = By.xpath("//h1[normalize-space()='Passdown Details']");
	private By dataReferenceNumber = By.xpath("//th[normalize-space()='Refrence Number']/following-sibling::td");
	private By dataSiteType = By.xpath("//th[normalize-space()='Site Type:']/following-sibling::td");
	private By dataSiteBeats = By.xpath("//th[normalize-space()='Site Beats:']/following-sibling::td/span");
	private By dataMessageDetailsPage = By.xpath("//th[normalize-space()='Message:']/following-sibling::td");
	private By dataCreatedBy = By.xpath("//th[normalize-space()='CreatedBy:']/following-sibling::td");
	private By dataTitle = By
			.xpath("(//th[normalize-space()='Title']/ancestor::thead/following-sibling::tbody//td)[1]");
	private By dataDescription = By
			.xpath("(//th[normalize-space()='Title']/ancestor::thead/following-sibling::tbody//td)[2]");
	private By dataImage = By
			.xpath("(//th[normalize-space()='Title']/ancestor::thead/following-sibling::tbody//td)[3]//img");

	// Scan Images Passdown Log
	public By btnScanImage(String message) {
		String xpath = "//pre[normalize-space()='" + message
				+ "']/../following-sibling::td//a[@class='c-cursor-pointer']";
		return By.xpath(xpath);
	}

	private By dataSiteNameScan = By.xpath("//p[normalize-space()='Site']/following-sibling::p");
	private By dataSiteBeatsScan = By.xpath("//p[normalize-space()='Site Beats']/following-sibling::p/span");
	private By dataCreatedByScan = By.xpath("//p[normalize-space()='Created By']/following-sibling::p");
	private By dataActivityCodeScan = By.xpath("//p[normalize-space()='Activity Code']/following-sibling::p");
	private By dataPassdownTextScan = By.xpath("//p[normalize-space()='Passdown Text']/following-sibling::pre");
	private By dataImageScan = By.xpath("//img[@alt='Testing']");
	private By dataImageFileNameScan = By
			.xpath("//div[@class='image-details']//strong[normalize-space()='File Name:']/following-sibling::span");
	private By dataImageDescriptionScan = By.xpath(
			"//div[@class='image-details']//strong[normalize-space()='File Description:']/following-sibling::span");
	private By dataQRCodeScan = By.xpath("//div[@class='qr-code-container']");

	// Common
	private By sucessMessage = By.xpath("//div[contains(@class,'Toastify__toast-icon')]/following-sibling::div");

	public PassdownLogsPage(WebDriver driver) {
		this.driver = driver;
		this.elementUtils = new ElementUtils(driver);
	}

	public void clickTabPassdownLogs() {
		elementUtils.waitForElementToBeClickable(tabPassdownLogs, Constants.DEFAULT_WAIT).click();
	}

	public boolean isAddPassdownLogButtonDisplayed() {
		return elementUtils.doIsDisplayed(btnAddPassdownLog, Constants.DEFAULT_WAIT);
	}

	// Add New Passdown Log
	public void clickAddPassdownLog() {
		elementUtils.waitForElementToBeClickable(btnAddPassdownLog, Constants.DEFAULT_WAIT).click();
	}

	public String getSiteNameDropdownValue() {
		return elementUtils.getText(siteNameDropdownValue, Constants.DEFAULT_WAIT);
	}

	public void searchSiteName(String siteName) throws InterruptedException {
		elementUtils.waitForElementToBeClickable(siteNameDropdownValue, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementVisible(searchSiteName, Constants.DEFAULT_WAIT).sendKeys(siteName);
		Thread.sleep(2000);
		elementUtils.pressEnterKey();
	}

	public void enterMessage(String message) {
		elementUtils.waitForElementVisible(txtboxMessage, Constants.DEFAULT_WAIT).sendKeys(message);
	}

	public void uploadImage(String imagePath) {
		WebElement fileInput = elementUtils.getElement(uploadImage);
		String absolutePath = new File(imagePath).getAbsolutePath();
		System.out.println("Uploading file from path: " + absolutePath);
		fileInput.sendKeys(absolutePath);
	}

	public String getHeadingEditImage() {
		return elementUtils.getText(txtHeadingEditImage, Constants.DEFAULT_WAIT);
	}

	public void clickUploadImage() {
		elementUtils.waitForElementToBeClickable(btnUploadImage, Constants.DEFAULT_WAIT).click();
	}

	public String imageUploadSuccessMessage() {
		return elementUtils.getText(sucessMessage, Constants.DEFAULT_WAIT);
	}

	public void enterImageName(String imageName) {
		elementUtils.waitForInvisibilityOfElementLocated(sucessMessage, Constants.DEFAULT_WAIT);
		elementUtils.waitForElementVisible(txtboxImageName, Constants.DEFAULT_WAIT).sendKeys(imageName);
	}

	public void enterImageDescription(String imageDescription) {
		elementUtils.waitForElementVisible(txtboxImageDescription, Constants.DEFAULT_WAIT).sendKeys(imageDescription);
	}

	public void clickSavePassdown() {
		elementUtils.waitForElementToBeClickable(btnSavePassdown, Constants.DEFAULT_WAIT).click();
	}

	public void clickSaveAndScanQRCode() {
		elementUtils.waitForElementToBeClickable(btnSaveAndScanQRCode, Constants.DEFAULT_WAIT).click();
	}

	// Data
	public String getDataSiteName() {
		return elementUtils.getText(dataSiteName, Constants.DEFAULT_WAIT);
	}

	public String getDataMessage() {
		return elementUtils.getText(dataMessage, Constants.DEFAULT_WAIT);
	}

	// View Passdown Log

	public void clickViewPassdownLog(String message) {
		elementUtils.waitForElementToBeClickable(btnView(message), Constants.DEFAULT_WAIT).click();
	}

	public String getHeadingViewPassdownDetails() {
		return elementUtils.getText(txtHeadingViewPassdownDetails, Constants.DEFAULT_WAIT);
	}

	public String getDataReferenceNumber() {
		return elementUtils.getText(dataReferenceNumber, Constants.DEFAULT_WAIT);
	}

	public String getDataSiteType() {
		return elementUtils.getText(dataSiteType, Constants.DEFAULT_WAIT);
	}

	public String getDataSiteBeats() {
		return elementUtils.getText(dataSiteBeats, Constants.DEFAULT_WAIT);
	}

	public String getDataMessageDetailsPage() {
		return elementUtils.getText(dataMessageDetailsPage, Constants.DEFAULT_WAIT);
	}

	public String getDataCreatedBy() {
		return elementUtils.getText(dataCreatedBy, Constants.DEFAULT_WAIT);
	}

	public String getDataTitle() {
		return elementUtils.getText(dataTitle, Constants.DEFAULT_WAIT);
	}

	public String getDataDescription() {
		return elementUtils.getText(dataDescription, Constants.DEFAULT_WAIT);
	}

	public boolean isImageDisplayed() {
		return elementUtils.doIsDisplayed(dataImage, Constants.DEFAULT_WAIT);
	}

	// Sacan Images Passdown Log
	public void clickScanImage(String message) {
		elementUtils.doClickWithActionsAndWait(btnScanImage(message), Constants.DEFAULT_WAIT);
	}

	public String getDataSiteNameScan() {
		return elementUtils.getText(dataSiteNameScan, Constants.DEFAULT_WAIT);
	}

	public String getDataSiteBeatsScan() {
		return elementUtils.getText(dataSiteBeatsScan, Constants.DEFAULT_WAIT);
	}

	public String getDataCreatedByScan() {
		return elementUtils.getText(dataCreatedByScan, Constants.DEFAULT_WAIT);
	}

	public String getDataActivityCodeScan() {
		return elementUtils.getText(dataActivityCodeScan, Constants.DEFAULT_WAIT);
	}

	public String getDataPassdownTextScan() {
		return elementUtils.getText(dataPassdownTextScan, Constants.DEFAULT_WAIT);
	}

	public boolean isDataImageScanDisplayed() {
		return elementUtils.doIsDisplayed(dataImageScan, Constants.DEFAULT_WAIT);
	}

	public String getDataImageFileNameScan() {
		return elementUtils.getText(dataImageFileNameScan, Constants.DEFAULT_WAIT);
	}

	public String getDataImageDescriptionScan() {
		return elementUtils.getText(dataImageDescriptionScan, Constants.DEFAULT_WAIT);
	}

	public boolean isDataQRCodeScanDisplayed() {
		return elementUtils.doIsDisplayed(dataQRCodeScan, Constants.DEFAULT_WAIT);
	}

	public String getSuccessMessage() {
		return elementUtils.getText(sucessMessage, Constants.DEFAULT_WAIT);
	}

}
