package com.dits.citywide.pages;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.dits.citywide.constants.Constants;
import com.dits.citywide.utilities.ElementUtils;
import com.dits.citywide.utilities.ServerTimeUtil;

public class FieldAgentReportsPage {

	private WebDriver driver;
	private ElementUtils elementUtils;

	private By btnReportsTab = By.xpath("//span[normalize-space()='Reports']");
	private By btnPreFlightReports = By.xpath("//a[normalize-space()='Pre-Flight Reports']");
	private By btnSubmitReports = By.xpath("//button[normalize-space()='Submit Reports']");
	private By txtNoItemsFound = By
			.xpath("//span[@class='px-2 py-8 text-base font-medium text-center text-gray-400 dark:text-white']");
	private By btnEndShift = By.xpath("//button[normalize-space()='End Shift']");
	private By endShiftConfirmationMessage = By.xpath("//div[@id='swal2-html-container']");
	private By btnOk = By.xpath("//button[normalize-space()='OK']");

	private By txtCloseOutFieldAgentLog = By.xpath("//h2[normalize-space()='Close Out Field Agent Log']");
	private By checkboxShiftIsEnd = By.xpath("//label[normalize-space()='Shift is end']");
	private By btnEndShiftFinal = By.xpath("(//button[text()='End Shift'])[1]");

	// My Reports
	private By txtUpdateOfficerReportEntry = By.xpath("//h1[normalize-space()='Update Officer Report Entry']");
	private By btnEditReport2 = By.xpath("(//button[@title='Edit Entry'])[2]");
	private By btnEditReport3 = By.xpath("(//button[@title='Edit Entry'])[3]");
	private By btnEditReport4 = By.xpath("(//button[@title='Edit Entry'])[4]");
	private By btnEditReport5 = By.xpath("(//button[@title='Edit Entry'])[5]");
	private By btnEditReport6 = By.xpath("(//button[@title='Edit Entry'])[6]");
	private By btnEditReport7 = By.xpath("(//button[@title='Edit Entry'])[7]");
	private By btnEditReport8 = By.xpath("(//button[@title='Edit Entry'])[8]");
	private By btnEditReport9 = By.xpath("(//button[@title='Edit Entry'])[9]");

	private By btnNow = By
			.xpath("(//div[contains(@class,'p-2 text-gray-600 border rounded-lg cursor-pointer now-icon')])[1]");
	private By dropdownActivityCode = By.xpath("//label[@for='search_code']");
	private By searchboxActivityCode = By.xpath("//input[@placeholder='Search...']");
	private By valueActivityCode = By.xpath("//div[@class='list-none m-0 p-0']/div/span");
	private By dropdownCall = By.xpath("//select[@id='callid_incident_number']");

	private By txtboxStreetNumber = By.xpath("//input[@id='street_num']");
	private By txtboxStreetName = By.xpath("//input[@id='street_name']");
	private By txtboxApartmentNumber = By.xpath("//input[@id='apartment']");
	private By txtboxCity = By.xpath("//input[@id='city']");
	private By txtboxStreetSate = By.xpath("//input[@id='state']");
	private By txtboxzipcode = By.xpath("//input[@id='zipcode']");
	private By txtboxDescription = By.xpath("//textarea[@id='activity_text']");

	private By uploadFile = By.xpath("//input[@type='file']");
	private By btnUpdateLogEntry = By.xpath("(//button[@id='submitButton'])[2]");
	private By txtboxImageName = By.xpath("//input[@id='image_name_0']");
	private By txtboxImageDescription = By.xpath("//textarea[@id='image_description_0']");

	// All reports
	private By btnAllReports = By.xpath("//a[@class='tabs-button'][contains(text(),'All')]");
	private By txtboxSearch = By.xpath("//input[@placeholder='Search']");

	private By getOfficerNameDataStartOfShift = By.xpath("(//td[@data-label='Officer'])[10]");
	private By getSiteDataStartOfShift = By.xpath("(//td[@data-label='Site'])[10]/a");
	private By getArriveDataStartOfShift = By.xpath("(//td[@data-label='Arrive'])[10]");
	private By getDepartDataStartOfShift = By.xpath("(//td[@data-label='Depart'])[10]");
	private By getActivityCodeDataStartOfShift = By.xpath("(//td[@data-label='Activity Code'])[10]");

	private By getOfficerNameDataEndOfShift = By.xpath("(//td[@data-label='Officer'])[1]");
	private By getSiteDataEndOfShift = By.xpath("(//td[@data-label='Site'])[1]/a");
	private By getArriveDataEndOfShift = By.xpath("(//td[@data-label='Arrive'])[1]");
	private By getDepartDataEndOfShift = By.xpath("(//td[@data-label='Depart'])[1]");
	private By getActivityCodeDataEndOfShift = By.xpath("(//td[@data-label='Activity Code'])[1]");

	private By loader = By.xpath("//span[@class='ant-spin-dot ant-spin-dot-spin']");

	public FieldAgentReportsPage(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(driver);
	}

	public boolean isPreFlightReportsButtonVisible() {
		return elementUtils.doIsDisplayed(btnPreFlightReports, Constants.DEFAULT_WAIT);
	}

	public void clickPreFlightReports() {
		elementUtils.waitForElementToBeClickable(btnPreFlightReports, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementToBeClickable(btnOk, Constants.SHORT_TIME_OUT_WAIT).click();
	}

	public void clickSubmitReports() {
		elementUtils.waitForInvisibilityOfElementLocated(btnPreFlightReports, Constants.DEFAULT_WAIT);
		elementUtils.waitForElementToBeClickable(btnSubmitReports, Constants.DEFAULT_WAIT).click();
	}

	public boolean isNoItemsFoundVisible() {
		return elementUtils.doIsDisplayed(txtNoItemsFound, Constants.DEFAULT_WAIT);
	}

	public void clickEndShift() {
		isNoItemsFoundVisible();
		elementUtils.waitForElementToBeClickable(btnEndShift, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementToBeClickable(btnOk, Constants.SHORT_TIME_OUT_WAIT).click();
		isCloseOutFieldAgentLogVisible();
		elementUtils.waitForElementToBeClickable(checkboxShiftIsEnd, Constants.SHORT_TIME_OUT_WAIT).click();
		elementUtils.waitForElementToBeClickable(btnEndShiftFinal, Constants.SHORT_TIME_OUT_WAIT).click();
		elementUtils.waitForElementToBeClickable(btnOk, Constants.SHORT_TIME_OUT_WAIT).click();
	}

	public void clickOkButton() {
		elementUtils.waitForElementToBeClickable(btnOk, Constants.DEFAULT_WAIT).click();
	}

	public String getEndShiftConfirmationMessage() {
		return elementUtils.waitForElementVisible(endShiftConfirmationMessage, Constants.DEFAULT_WAIT).getText();
	}

	public boolean isCloseOutFieldAgentLogVisible() {
		return elementUtils.doIsDisplayed(txtCloseOutFieldAgentLog, Constants.DEFAULT_WAIT);
	}

	// My Reports
	public boolean isUpdateOfficerReportEntryVisible() {
		return elementUtils.doIsDisplayed(txtUpdateOfficerReportEntry, Constants.DEFAULT_WAIT);
	}

	public void clickEditReport2() {
		elementUtils.waitForInvisibilityOfElementLocated(btnPreFlightReports, Constants.DEFAULT_WAIT);
		elementUtils.waitForElementToBeClickable(btnEditReport2, Constants.SHORT_TIME_OUT_WAIT).click();
	}

	public void clickEditReport3() {
		elementUtils.doClick(btnEditReport3);
	}

	public void clickEditReport4() {
		elementUtils.doClick(btnEditReport4);
	}

	public void clickEditReport5() {
		elementUtils.doClick(btnEditReport5);
	}

	public void clickEditReport6() {
		elementUtils.doClick(btnEditReport6);
	}

	public void clickEditReport7() {
		elementUtils.doClick(btnEditReport7);
	}

	public void clickEditReport8() {
		elementUtils.doClick(btnEditReport8);
	}

	public void clickEditReport9() {
		elementUtils.doClick(btnEditReport9);
	}

	public void addOfficerReportEntry(String url, String activityCode, String streetNumber, String streetName,
			String apartmentNumber, String city, String state, String zipcode, String description, String imagePath,
			String fileName, String fileDescription) {

		isUpdateOfficerReportEntryVisible();

		elementUtils.waitForElementToBeClickable(btnNow, Constants.DEFAULT_WAIT).click();
		String currenttime = ServerTimeUtil.getServerTimeInPST(url);
		System.out.println(currenttime);
		elementUtils.waitForElementToBeClickable(dropdownActivityCode, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementVisible(searchboxActivityCode, Constants.SHORT_TIME_OUT_WAIT).sendKeys(activityCode);
		elementUtils.waitForElementVisible(valueActivityCode, Constants.SHORT_TIME_OUT_WAIT);
		elementUtils.selectElementThroughLocator(valueActivityCode, activityCode, Constants.SHORT_TIME_OUT_WAIT);

		elementUtils.waitForElementVisible(txtboxStreetNumber, Constants.SHORT_TIME_OUT_WAIT).sendKeys(streetNumber);
		elementUtils.waitForElementVisible(txtboxStreetName, Constants.SHORT_TIME_OUT_WAIT).sendKeys(streetName);
		elementUtils.waitForElementVisible(txtboxApartmentNumber, Constants.SHORT_TIME_OUT_WAIT)
				.sendKeys(apartmentNumber);
		elementUtils.waitForElementVisible(txtboxCity, Constants.SHORT_TIME_OUT_WAIT).sendKeys(city);
		elementUtils.waitForElementVisible(txtboxStreetSate, Constants.SHORT_TIME_OUT_WAIT).sendKeys(state);
		elementUtils.waitForElementVisible(txtboxzipcode, Constants.SHORT_TIME_OUT_WAIT).sendKeys(zipcode);
		elementUtils.waitForElementVisible(txtboxDescription, Constants.SHORT_TIME_OUT_WAIT).sendKeys(description);

		WebElement fileInput = elementUtils.getElement(uploadFile);
		String absolutePath = new File(imagePath).getAbsolutePath();
		fileInput.sendKeys(absolutePath);

		elementUtils.waitForElementVisible(txtboxImageName, Constants.DEFAULT_WAIT).sendKeys(fileName);
		elementUtils.waitForElementVisible(txtboxImageDescription, Constants.DEFAULT_WAIT).sendKeys(fileDescription);

		elementUtils.waitForElementToBeClickable(btnUpdateLogEntry, Constants.DEFAULT_WAIT).click();
	}

	// All Reports Module
	public void clickOnReportsTab() {
		elementUtils.waitForElementToBeClickable(btnReportsTab, Constants.DEFAULT_WAIT).click();
	}

	public boolean isAllReportsButtonVisible() {
		return elementUtils.doIsDisplayed(btnAllReports, Constants.DEFAULT_WAIT);
	}

	public void clickAllReports() {
		elementUtils.waitForElementToBeClickable(btnAllReports, Constants.DEFAULT_WAIT).click();
	}

	public void enterTextInSearchBox(String searchText) {
		elementUtils.waitForElementVisible(txtboxSearch, Constants.DEFAULT_WAIT).sendKeys(searchText);
		elementUtils.waitForInvisibilityOfElementLocated(loader, Constants.DEFAULT_WAIT);
	}

	// Start of Shift
	public String getOfficerNameDataStartOfShift() {
		return elementUtils.waitForElementVisible(getOfficerNameDataStartOfShift, Constants.DEFAULT_WAIT).getText();
	}

	public String getSiteDataStartOfShift() {
		return elementUtils.waitForElementVisible(getSiteDataStartOfShift, Constants.DEFAULT_WAIT).getText();
	}

	public String getArriveDataStartOfShift() {
		return elementUtils.waitForElementVisible(getArriveDataStartOfShift, Constants.DEFAULT_WAIT).getText();
	}

	public String getDepartDataStartOfShift() {
		return elementUtils.waitForElementVisible(getDepartDataStartOfShift, Constants.DEFAULT_WAIT).getText();
	}

	public String getActivityCodeDataStartOfShift() {
		return elementUtils.waitForElementVisible(getActivityCodeDataStartOfShift, Constants.DEFAULT_WAIT).getText();
	}

	// End Of Shift
	public String getOfficerNameDataEndOfShift() {
		return elementUtils.waitForElementVisible(getOfficerNameDataEndOfShift, Constants.DEFAULT_WAIT).getText();
	}

	public String getSiteDataEndOfShift() {
		return elementUtils.waitForElementVisible(getSiteDataEndOfShift, Constants.DEFAULT_WAIT).getText();
	}

	public String getArriveDataEndOfShift() {
		return elementUtils.waitForElementVisible(getArriveDataEndOfShift, Constants.DEFAULT_WAIT).getText();
	}

	public String getDepartDataEndOfShift() {
		return elementUtils.waitForElementVisible(getDepartDataEndOfShift, Constants.DEFAULT_WAIT).getText();
	}

	public String getActivityCodeDataEndOfShift() {
		return elementUtils.waitForElementVisible(getActivityCodeDataEndOfShift, Constants.DEFAULT_WAIT).getText();
	}

}
