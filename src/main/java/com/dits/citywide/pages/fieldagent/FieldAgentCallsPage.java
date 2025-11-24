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

	// Locator for the calls search input (adjust if a more specific attribute is known)
	private By searchCallById = By.xpath("//input[contains(@placeholder,'Search')]");

	private By txtCallActions = By.xpath("//h2[contains(text(),'Call Actions')]");
	private By txtAssignedUnits = By.xpath("//h2[contains(text(),'Assigned Units')]");
	private By btnExpandCollapseAssignedUnits = By.xpath("//span[normalize-space()='Assigned Units']");
	private By btnEnroute = By.xpath("//div[@class='c-cursor-pointer']");
	private By btnArrive = By.xpath("//div[@class='c-cursor-pointer']");
	private By btnCleared = By.xpath("//div[@class='c-cursor-pointer']");
	private By btnExpandCollapseCallNotes = By.xpath("//span[normalize-space()='Call Notes']");
	private By txtCallNotes = By.xpath("//h2[contains(text(),'Call Notes')]");
	private By txtboxNotes = By.xpath("//textarea[@id='info_message']");
	private By btnSaveNote = By.xpath("//button[@type='submit']");
	private By btnCloseCallAction = By.xpath("//span[@aria-label='close']");

	private By successMessage = By.xpath("//div[contains(@class,'Toastify__toast-icon')]/following-sibling::div");

	private By loader = By.xpath("//span[@class='anticon anticon-close']");

	// New Officer Report Entry
	private By clockArriveNow = By.xpath("(//span[@aria-label='clock-circle'])[1]");
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
	private By txtboxFileName = By.xpath("//input[@id='Name0']");
	private By txtboxFileDescription = By.xpath("//input[@id='Description0']");

	private By btnSaveNewLogEntry = By.xpath("//button[normalize-space()='Save New Log Entry']");

	private By txtAreYouSure = By.xpath("//h2[@id='swal2-title']");
	private By txtConfirmation = By.xpath("//div[@id='swal2-html-container']");
	private By btnOk = By.xpath("//button[normalize-space()='OK']");
	
	private By CloseCallbtn = By.xpath("//button[@type='button' and normalize-space()='Close Call']");

	// Replace incorrect loader locator (was pointing to close icon) with a real spinner locator
	private By spinner = By.xpath("//span[contains(@class,'ant-spin-dot')]");
	private By closeIcon = By.xpath("//span[@aria-label='close']"); // retained for fallback

	public FieldAgentCallsPage(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(driver);
	}

	public void doClickAddPatrolLogsForCall(String callId) {
		String callid = callId;
		String callidxpath = "(.//div[@class='actionicons editPencil'])[2]";
		elementUtils.waitForElementVisible(By.xpath(callidxpath), Constants.DEFAULT_WAIT).click();
	}

	// Search for a call by its Call ID in the Calls listing
	public void searchCall(String callId) throws InterruptedException {
		// Wait for search input, clear it, enter the call id and press Enter
		elementUtils.waitForElementVisible(searchCallById, Constants.DEFAULT_WAIT).clear();
		elementUtils.waitForElementVisible(searchCallById, Constants.DEFAULT_WAIT).sendKeys(callId);
		elementUtils.pressEnterKey();
		// Wait explicitly for the call id to appear in the results instead of sleeping
		By callIdLocator = By.xpath("//div[normalize-space()='" + callId + "']");
		elementUtils.waitForElementVisible(callIdLocator, Constants.MEDIUM_TIME_OUT_WAIT);
	}

	public void doClickCallAction(String callId) {
		String callid = callId;
		// More robust locator: find the cell/div that exactly matches the call id, go up to the row
		// and find the Call Action icon/button inside that same row.
		String callidxpath = "(//div[normalize-space()='" + callid + "']/ancestor::tr//div[@class='actionicons editPencil'])[3]";
		elementUtils.waitForElementVisible(By.xpath(callidxpath), Constants.DEFAULT_WAIT).click();
	}

	public boolean isCallActionsVisible() {
		return elementUtils.doIsDisplayed(txtCallActions, Constants.DEFAULT_WAIT);
	}

	public boolean isAssignedUnitsVisible() {
		return elementUtils.doIsDisplayed(txtAssignedUnits, Constants.DEFAULT_WAIT);
	}

	public void doClickExpandCollapseAssignedUnits() {
		elementUtils.waitForElementToBeClickable(btnExpandCollapseAssignedUnits, Constants.DEFAULT_WAIT).click();
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

	public void doClickClose() {
		elementUtils.waitForInvisibilityOfElementLocated(successMessage, Constants.DEFAULT_WAIT);
		elementUtils.waitForElementToBeClickable(CloseCallbtn, Constants.DEFAULT_WAIT).click();
	}

	public String getSuccessMessageText() {
		return elementUtils.waitForElementVisible(successMessage, Constants.DEFAULT_WAIT).getText();
	}

	public void doClickExpandCollapseCallNotes() {
		elementUtils.waitForElementToBeClickable(btnExpandCollapseCallNotes, Constants.DEFAULT_WAIT).click();
	}

	public boolean isCallNotesVisible() {
		return elementUtils.doIsDisplayed(txtCallNotes, Constants.DEFAULT_WAIT);
	}

	public void addNotesAndSave(String notes) {
		elementUtils.waitForElementVisible(txtboxNotes, Constants.DEFAULT_WAIT).sendKeys(notes);
		elementUtils.doClickWithActionsAndWait(btnSaveNote, Constants.DEFAULT_WAIT);
	}

	public void closeCallActionPopup() {
		// Wait for any spinner to disappear if present (short timeout to avoid long block)
		try {
			if (elementUtils.isElementVisible(spinner, Constants.SHORT_TIME_OUT_WAIT)) {
				elementUtils.waitForInvisibilityOfElementLocated(spinner, Constants.DEFAULT_WAIT);
			}
		} catch (Exception e) {
			System.out.println("Spinner wait skipped: " + e.getMessage());
		}

		// Attempt primary close via dedicated close button
		try {
			if (elementUtils.isElementVisible(btnCloseCallAction, Constants.SHORT_TIME_OUT_WAIT)) {
				elementUtils.waitForElementToBeClickable(btnCloseCallAction, Constants.DEFAULT_WAIT).click();
			} else if (elementUtils.isElementVisible(closeIcon, Constants.SHORT_TIME_OUT_WAIT)) { // fallback
				elementUtils.waitForElementToBeClickable(closeIcon, Constants.DEFAULT_WAIT).click();
			} else {
				System.out.println("No close element visible, attempting ESC key.");
				elementUtils.pressEscapeKey();
			}
		} catch (Exception clickEx) {
			System.out.println("Close action failed, trying Actions click: " + clickEx.getMessage());
			try {
				elementUtils.doClickWithActionsAndWait(btnCloseCallAction, Constants.SHORT_TIME_OUT_WAIT);
			} catch (Exception ignored) {
				System.out.println("Actions fallback also failed.");
			}
		}
	}

	// New Officer Report Entry
	public void fillNewOfficerReportEntry(String streetNumber, String streetName, String apartmentNumber,
            String city, String state, String zipcode, String description,
            String imagePath, String fileName, String fileDescription) throws InterruptedException {

// Wait for loader to disappear
elementUtils.waitForInvisibilityOfElementLocated(loader, Constants.DEFAULT_WAIT);

// Click "Arrive Now" button (auto-fills Arrive Date & Time)
elementUtils.waitForElementToBeClickable(clockArriveNow, Constants.DEFAULT_WAIT).click();

// Optional: Click "Depart Now" if needed
// elementUtils.waitForElementToBeClickable(clockDepartNow, Constants.DEFAULT_WAIT).click();

Thread.sleep(2000); // Wait for site & activity fields to auto-populate

// Fill address fields using method parameters
elementUtils.waitForElementVisible(txtboxStreetNumber, Constants.DEFAULT_WAIT).sendKeys(streetNumber);
elementUtils.waitForElementVisible(txtboxStreetName, Constants.DEFAULT_WAIT).sendKeys(streetName);
elementUtils.waitForElementVisible(txtboxApartmentNumber, Constants.DEFAULT_WAIT).sendKeys(apartmentNumber);
elementUtils.waitForElementVisible(txtboxCity, Constants.DEFAULT_WAIT).sendKeys(city);
elementUtils.waitForElementVisible(txtboxState, Constants.DEFAULT_WAIT).sendKeys(state);
elementUtils.waitForElementVisible(txtboxZipcode, Constants.DEFAULT_WAIT).sendKeys(zipcode);
elementUtils.waitForElementVisible(txtboxDescription, Constants.DEFAULT_WAIT).sendKeys(description);

// Upload photo/video file
WebElement fileInput = elementUtils.getElement(imgUpload);
String absolutePath = new File(imagePath).getAbsolutePath();
System.out.println("Uploading file from path: " + absolutePath);
fileInput.sendKeys(absolutePath);

// File details
elementUtils.waitForElementVisible(txtboxFileName, Constants.DEFAULT_WAIT).sendKeys(fileName);
elementUtils.waitForElementVisible(txtboxFileDescription, Constants.DEFAULT_WAIT).sendKeys(fileDescription);

// Save entry
elementUtils.waitForElementToBeClickable(btnSaveNewLogEntry, Constants.DEFAULT_WAIT).click();
}


//	public boolean isAreYouSureTextVisible() {
//		return elementUtils.doIsDisplayed(txtAreYouSure, Constants.DEFAULT_WAIT);
//	}
//
//	public String getConfirmationText() {
//		return elementUtils.waitForElementVisible(txtConfirmation, Constants.DEFAULT_WAIT).getText();
//	}

	public void doClickOk() {
		elementUtils.waitForElementToBeClickable(btnOk, Constants.DEFAULT_WAIT).click();
	}

}
