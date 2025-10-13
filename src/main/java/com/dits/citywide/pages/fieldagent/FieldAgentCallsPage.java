package com.dits.citywide.pages.fieldagent;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.dits.citywide.constants.Constants;
import com.dits.citywide.utilities.ElementUtils;

public class FieldAgentCallsPage {

	private WebDriver driver;
	private ElementUtils elementUtils;

//	private By btnAddPatrolLogsForCall = By.xpath(
//			"//button[contains(text(),'843')]/ancestor::td/following-sibling::td//button[@title='Add Patrol Logs For Call']");

//	private By btnCallAction = By
//			.xpath("//button[contains(text(),'843')]/ancestor::td/following-sibling::td//button[@title='Call Action']");

	private By txtCallActions = By.xpath("//h2[contains(text(),'Call Actions')]");
	private By txtAssignedUnits = By.xpath("//h2[contains(text(),'Assigned Units')]");
	private By btnEnroute = By.xpath("//div[@class='c-cursor-pointer']");
	private By btnArrive = By.xpath("//div[@class='c-cursor-pointer']");
	private By btnCleared = By.xpath("//div[@class='c-cursor-pointer']");
	private By txtCallNotes = By.xpath("//h2[contains(text(),'Call Notes')]");
	private By txtboxNotes = By.xpath("//textarea[@id='info_message']");
	private By btnSaveNote = By.xpath("//button[@type='submit']");
	private By btnCloseCallAction = By.xpath("//span[@aria-label='close']");

	private By successMessage = By.xpath("//div[contains(@class,'Toastify__toast-icon')]/following-sibling::div");

	private By loader = By.xpath("//span[@class='ant-spin-dot ant-spin-dot-spin']");

	// New Officer Report Entry
	private By calenderArriveDate = By.xpath("//input[@id='arrive_date']");
	private By calenderArriveTime = By.xpath("//input[@id='arrive_time']");
	private By calenderDepartDate = By.xpath("//input[@id='depart_date']");
	private By calenderDepartTime = By.xpath("//input[@id='depart_time']");
	private By dropdownActivityCode = By.cssSelector("label[for='search_code']");
	private By searchActivityCode = By.cssSelector("input[placeholder='Search...']");
	private By activityCodeValue = By.xpath("//div[@class='list-none m-0 p-0']/div");

	// Report Address
	private By txtboxStreetNumber = By.xpath("//input[@id='street_num']");
	private By txtboxStreetName = By.xpath("//input[@id='street_name']");
	private By txtboxApartmentNumber = By.xpath("//input[@id='apartment']");
	private By txtboxCity = By.xpath("//input[@id='city']");
	private By txtboxState = By.xpath("//input[@id='state']");
	private By txtboxZipcode = By.xpath("//input[@id='zipcode']");
	private By txtboxDescription = By.xpath("//textarea[@id='activity_text']");

	// Report photo/video upload
	private By imgUpload = By.xpath("//input[@type='file']");

	private By btnSaveNewLogEntry = By.xpath("//button[normalize-space()='Save New Log Entry']");

	private By txtAreYouSure = By.xpath("//h2[@id='swal2-title']");
	private By txtConfirmation = By.xpath("//div[@id='swal2-html-container']");
	private By btnOk = By.xpath("//button[normalize-space()='OK']");

	public FieldAgentCallsPage(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(driver);
	}

	public void doClickAddPatrolLogsForCall(String callId) {
		String callid = callId;
		String callidxpath = "//a[contains(text(),'" + callid
				+ "')]/ancestor::td/following-sibling::td//button[@title='Add Patrol Logs For Call']";
		elementUtils.waitForElementVisible(By.xpath(callidxpath), Constants.DEFAULT_WAIT).click();
	}

	public void doClickCallAction(String callId) {
		String callid = callId;
		String callidxpath = "(//a[contains(text(),'" + callid
				+ "')]/ancestor::td/following-sibling::td[7]//div[@class='actionicons editPencil'])[2]";
		elementUtils.waitForElementVisible(By.xpath(callidxpath), Constants.DEFAULT_WAIT).click();
	}

	public boolean isCallActionsVisible() {
		return elementUtils.doIsDisplayed(txtCallActions, Constants.DEFAULT_WAIT);
	}

	public boolean isAssignedUnitsVisible() {
		return elementUtils.doIsDisplayed(txtAssignedUnits, Constants.DEFAULT_WAIT);
	}

	public void doClickEnroute() {
		elementUtils.waitForElementToBeClickable(btnEnroute, Constants.DEFAULT_WAIT).click();
	}

	public void doClickArrive() {
		elementUtils.waitForInvisibilityOfElementLocated(successMessage, Constants.DEFAULT_WAIT);
		elementUtils.waitForElementToBeClickable(btnArrive, Constants.DEFAULT_WAIT).click();
	}

	public void doClickCleared() {
		elementUtils.waitForInvisibilityOfElementLocated(successMessage, Constants.DEFAULT_WAIT);
		elementUtils.waitForElementToBeClickable(btnCleared, Constants.DEFAULT_WAIT).click();
	}

	public String getSuccessMessageText() {
		return elementUtils.waitForElementVisible(successMessage, Constants.DEFAULT_WAIT).getText();
	}

	public boolean isCallNotesVisible() {
		return elementUtils.doIsDisplayed(txtCallNotes, Constants.DEFAULT_WAIT);
	}

	public void addNotesAndSave(String notes) {
		elementUtils.waitForElementVisible(txtboxNotes, Constants.DEFAULT_WAIT).sendKeys(notes);
		elementUtils.doClickWithActionsAndWait(btnSaveNote, Constants.DEFAULT_WAIT);
	}

	public void closeCallActionPopup() {
		elementUtils.waitForInvisibilityOfElementLocated(loader, Constants.DEFAULT_WAIT);
		// elementUtils.waitForElementToBeClickable(btnCloseCallAction,
		// Constants.DEFAULT_WAIT).click();
		elementUtils.doClickWithActionsAndWait(btnCloseCallAction, Constants.DEFAULT_WAIT);
	}

	// New Officer Report Entry
	public void fillNewOfficerReportEntry(String arriveDate, String arriveTime, String departDate, String departTime,
			String activityCode, String streetNumber, String streetName, String apartmentNumber, String city,
			String state, String Zipcode, String description, String imagePath) {
		elementUtils.waitForElementVisible(calenderArriveDate, Constants.DEFAULT_WAIT).sendKeys(arriveDate);
		elementUtils.waitForElementVisible(calenderArriveTime, Constants.DEFAULT_WAIT).sendKeys(arriveTime);
		elementUtils.waitForElementVisible(calenderDepartDate, Constants.DEFAULT_WAIT).sendKeys(departDate);
		elementUtils.waitForElementVisible(calenderDepartTime, Constants.DEFAULT_WAIT).sendKeys(departTime);
		elementUtils.waitForElementToBeClickable(dropdownActivityCode, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementVisible(searchActivityCode, Constants.DEFAULT_WAIT).sendKeys(activityCode);
		elementUtils.selectElementThroughLocator(activityCodeValue, activityCode, Constants.SHORT_TIME_OUT_WAIT);

		elementUtils.waitForElementVisible(txtboxStreetNumber, Constants.DEFAULT_WAIT).sendKeys(streetNumber);
		elementUtils.waitForElementVisible(txtboxStreetName, Constants.DEFAULT_WAIT).sendKeys(streetName);
		elementUtils.waitForElementVisible(txtboxApartmentNumber, Constants.DEFAULT_WAIT).sendKeys(apartmentNumber);
		elementUtils.waitForElementVisible(txtboxCity, Constants.DEFAULT_WAIT).sendKeys(city);
		elementUtils.waitForElementVisible(txtboxState, Constants.DEFAULT_WAIT).sendKeys(state);
		elementUtils.waitForElementVisible(txtboxZipcode, Constants.DEFAULT_WAIT).sendKeys(Zipcode);
		elementUtils.waitForElementVisible(txtboxDescription, Constants.DEFAULT_WAIT).sendKeys(description);

		WebElement fileInput = elementUtils.getElement(imgUpload);
		String absolutePath = new File(imagePath).getAbsolutePath();
		System.out.println("Uploading file from path: " + absolutePath);
		fileInput.sendKeys(absolutePath);

		elementUtils.waitForElementToBeClickable(btnSaveNewLogEntry, Constants.DEFAULT_WAIT).click();
	}

	public boolean isAreYouSureTextVisible() {
		return elementUtils.doIsDisplayed(txtAreYouSure, Constants.DEFAULT_WAIT);
	}

	public String getConfirmationText() {
		return elementUtils.waitForElementVisible(txtConfirmation, Constants.DEFAULT_WAIT).getText();
	}

	public void doClickOk() {
		elementUtils.waitForElementToBeClickable(btnOk, Constants.DEFAULT_WAIT).click();
	}

}
