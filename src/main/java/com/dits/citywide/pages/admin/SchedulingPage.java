package com.dits.citywide.pages.admin;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dits.citywide.constants.Constants;
import com.dits.citywide.utilities.ElementUtils;

public class SchedulingPage {

	private WebDriver driver;
	private ElementUtils elementUtils;

	private By dropdownSiteType = By.cssSelector("#rc_select_0");
	private By dropdownSelectSite = By.cssSelector("#rc_select_2");
	private By filters = By.xpath("//button[contains(@class,'ant-btn-primary') and contains(@class,'basicButton')]");
	private By checkboxServiceType = By.xpath("//span[@class='ant-checkbox-label']");
	private By btnApply = By.xpath("//span[contains(text(),'Apply')]");
	private By dataDate = By.xpath("//th[@class='week-day site-head-column']");
	private By loader = By.xpath("//span[@class='ant-spin-dot ant-spin-dot-spin']");
	private By txtNoData = By.xpath("//div[contains(text(),'No data')]");
	private By dropdownShift = By.xpath("//span[@title='Empty Shift']");
	private By dropdownShiftValue = By.xpath("(//div[@class='rc-virtual-list-holder-inner'])[2]/div/div");
	private By txtEmployee = By.xpath("//label[contains(text(),' Employee')]");
	private By searchEmployee = By.xpath("//label[contains(text(),' Employee')]/following-sibling::div//input[@type='search']");
	private By txtboxEmployee = By.xpath("(//span[@class='ant-select-selection-item'])[5]");
	private By employeeList = By.xpath("//div[@class='ant-select-dropdown css-yw7p3q ant-select-dropdown-placement-bottomLeft']");
	private By dataSiteId = By.xpath("//label[contains(text(),'Site Id')]/following-sibling::span");
	private By dataServiceType = By.xpath("//label[contains(text(),'Service Type')]/following-sibling::span");
	private By dataStartTime = By.xpath("(//label[contains(text(),'Scheduled Shift Time')]/..//div/input)[1]");
	private By dataEndTime = By.xpath("(//label[contains(text(),'Scheduled Shift Time')]/..//div/input)[2]");
	private By schedulestartshifttime = By.xpath("(//input[@placeholder='HH:MM'])[1]");
	private By scheduleEndshifttime = By.xpath("(//input[@placeholder='HH:MM'])[2]");
	private By dropdownScheduledBreak = By.xpath("//label[contains(text(),'Scheduled break')]/..//div[@class='ant-select-selector']");
	private By dropdownScheduledBreakValues = By.xpath("(//div[@class='rc-virtual-list-holder-inner'])[4]/div/div");
	private By txtboxAddNotes = By.xpath("//textarea[@placeholder='Add Notes']");
	private By btnCreateShift = By.xpath("//span[contains(text(),'Create Shift')]");
	private By successMsgShiftAdd = By.xpath("//div[contains(text(),'Shift added successfully')]");
	private By btnPublish = By.xpath("//span[contains(text(),'Publish')]");
	private By txtAreYouSure = By.xpath("//h2[@id='swal2-title']");
	private By txtThisActionWillPublishShifts = By.xpath("//h2[@id='swal2-title']");
	private By btnOk = By.xpath("//button[contains(text(),'OK')]");
	private By btnCancel = By.xpath("//button[contains(text(),'Cancel')]");
	private By successMsgPublish = By.xpath("//div[contains(text(),'Shifts published successfully!')]");

	// Beat Selection for patrol
	private By dropdwonBeat = By.xpath("//span[normalize-space()='Select Beat']");
	private By dropdownSiteOrBeatSelection = By.xpath("(//span[@class='ant-select-selection-item'])[1]");
	private By dropdownSelectBeatValue = By.xpath("//div[@class='rc-virtual-list-holder-inner']/div/div");
	private By dropdownSelectBeat = By.cssSelector("#rc_select_5");
	private By scheduledStartShiftTime = By.xpath("(//input[@placeholder='HH:MM'])[1]");
	private By scheduledEndShiftTime = By.xpath("(//input[@placeholder='HH:MM'])[2]");
	private By dropdownSelectAssignShiftValue = By.xpath("(//div[@class='rc-virtual-list-holder-inner'])[3]/div/div");
	private By dropdownScheduledBreakValuesPatrol = By.xpath("(//div[@class='rc-virtual-list-holder-inner'])[5]/div/div");

	// Helper locators
	private By employeeDropdownOptions = By.xpath("//div[contains(@class,'ant-select-item-option')]");
	private By optionBeatGeneric = By.xpath("//div[contains(@class,'ant-select-item-option')][contains(.,'Beat')]");
	private By getBeatValueOption(String beatName) { 
		return By.xpath("//div[contains(@class,'ant-select-item-option')][contains(.,'" + beatName + "')]"); 
	}
	private By employeeSelectContainer = By.xpath("//label[contains(text(),' Employee')]/following-sibling::div[contains(@class,'ant-select')]");
	private By activeSelectSearchInput = By.xpath("//div[contains(@class,'ant-select-open')]//input[@type='search' and not(@disabled)]");
	private By dropdownPanelVisible = By.xpath("//div[contains(@class,'ant-select-dropdown') and not(contains(@class,'hidden'))]");
	private By employeeOptionById(String employeeID) {
		return By.xpath("//div[contains(@class,'ant-select-item-option-content')]" +
			"[contains(translate(.,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'), '" + employeeID.toLowerCase() + "')]");
	}

	public SchedulingPage(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(driver);
	}

	public void clickOnFilters() {
		try {
			elementUtils.waitForElementToBeClickable(filters, Constants.DEFAULT_WAIT).click();
		} catch (NoSuchElementException | TimeoutException e) {
			System.out.println("Filters button not found or not clickable: " + e.getMessage());
		}
	}

	public void clickOnServiceTypeCheckbox() {
		elementUtils.waitForInvisibilityOfElementLocated(loader, Constants.DEFAULT_WAIT);
		elementUtils.waitForElementToBeClickable(checkboxServiceType, Constants.DEFAULT_WAIT).click();
	}

	// ✅ Fixed duplicate message
	public void selectSiteType(String siteType) throws InterruptedException {
		elementUtils.waitForInvisibilityOfElementLocated(loader, Constants.DEFAULT_WAIT);

		try {
			elementUtils.waitForElementToBeClickable(dropdownSiteType, Constants.DEFAULT_WAIT).click();
		} catch (Exception e) {
			elementUtils.jsClick(dropdownSiteType);
		}

		try {
			elementUtils.doActionsSendKeys(dropdownSiteType, siteType);
		} catch (Exception e) {
			elementUtils.sendKeysUsingJavaScript(dropdownSiteType, siteType, Constants.DEFAULT_WAIT);
		}

		By siteTypeOption = By.xpath("//div[contains(@class,'ant-select-item-option-content')][contains(.,'" + siteType + "')]");
		try {
			WebElement val = elementUtils.waitForElementVisible(siteTypeOption, Constants.DEFAULT_WAIT);
			elementUtils.waitElementToBeClickableThroughElement(val, Constants.SHORT_TIME_OUT_WAIT);
			elementUtils.doClickWeBElement(val);
		} catch (Exception e) {
			elementUtils.pressEnterKey();
		}
	}

	public void selectSiteAndApply(String siteName) throws InterruptedException {
		elementUtils.waitForInvisibilityOfElementLocated(loader, Constants.DEFAULT_WAIT);
		elementUtils.waitForElementToBeClickable(dropdownSelectSite, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForInvisibilityOfElementLocated(txtNoData, Constants.DEFAULT_WAIT);
		elementUtils.doActionsSendKeys(dropdownSelectSite, siteName);
		Thread.sleep(3000);
		elementUtils.pressEnterKey();
		elementUtils.waitForElementToBeClickable(btnApply, Constants.DEFAULT_WAIT).click();
	}

	public void selectBeatAndApply(String beatName) throws InterruptedException {
	    // Wait for any loader to disappear
	    elementUtils.waitForInvisibilityOfElementLocated(loader, Constants.DEFAULT_WAIT);

	    // Proactively close any previously open select that might steal focus
	    try { elementUtils.pressEscapeKey(); } catch (Exception ignored) {}

	    // Open the Beat dropdown ("Select Beat")
	    try {
	        elementUtils.waitForElementToBeClickable(dropdwonBeat, Constants.DEFAULT_WAIT).click();
	    } catch (Exception e) {
	        elementUtils.jsClick(dropdwonBeat);
	    }

	    // The searchable input for Beat (reuse existing locator dropdownSelectBeat)
	    WebElement beatInput;
	    try {
	        beatInput = elementUtils.waitForElementVisible(dropdownSelectBeat, Constants.DEFAULT_WAIT);
	    } catch (Exception e) {
	        // Fallback: try to locate any active ant select search input inside an open dropdown
	        By anyActiveSearch = By.xpath("//div[contains(@class,'ant-select-open')]//input[@type='search' and not(@disabled)]");
	        beatInput = elementUtils.waitForElementVisible(anyActiveSearch, Constants.DEFAULT_WAIT);
	    }

	    // Clear and type Beat name
	    try {
	        beatInput.clear();
	    } catch (Exception ignored) {}
	    try {
	        beatInput.sendKeys(beatName);
	    } catch (Exception e) {
	        // Fallback strategies
	        try { elementUtils.doActionsSendKeys(dropdownSelectBeat, beatName); } catch (Exception ex2) {
	            elementUtils.sendKeysUsingJavaScript(dropdownSelectBeat, beatName, Constants.DEFAULT_WAIT);
	        }
	    }

	    // Build case-insensitive option locator
	    By beatValue = By.xpath("//div[contains(@class,'ant-select-item-option-content')][contains(translate(., 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" 
	            + beatName.toLowerCase() + "')]");

	    boolean selected = false;
	    try {
	        WebElement val = elementUtils.waitForElementVisible(beatValue, Constants.DEFAULT_WAIT);
	        elementUtils.waitElementToBeClickableThroughElement(val, Constants.SHORT_TIME_OUT_WAIT);
	        try {
	            val.click();
	        } catch (Exception clickEx) {
	            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", val);
	        }
	        System.out.println("✅ Selected Beat option: " + val.getText());
	        selected = true;
	    } catch (Exception e) {
	        System.out.println("⚠️ Beat option not directly clickable, attempting ENTER key.");
	        try { elementUtils.pressEnterKey(); selected = true; } catch (Exception ignored) {}
	    }

	    if (!selected) {
	        System.out.println("❌ Unable to select Beat option for: " + beatName);
	        throw new RuntimeException("Beat option not found: " + beatName);
	    }

	    // Click Apply after successful Beat selection
	    elementUtils.waitForElementToBeClickable(btnApply, Constants.DEFAULT_WAIT).click();
	    System.out.println("✅ Apply button clicked after selecting Beat");
	}

	public void addShift(String date) {
		elementUtils.waitForInvisibilityOfElementLocated(txtNoData, Constants.DEFAULT_WAIT);
		elementUtils.waitForInvisibilityOfElementLocated(btnApply, Constants.DEFAULT_WAIT);

		int i = getDatePosition(date);
		System.out.println(i);
		String datexpath = "(//th[normalize-space()='Service Type']/ancestor::thead/following-sibling::tbody//div[@class='add-shift'])[" + i + "]";
		elementUtils.waitForElementVisible(By.xpath(datexpath), Constants.DEFAULT_WAIT);
		elementUtils.waitForElementToBeClickable(By.xpath(datexpath), Constants.DEFAULT_WAIT).click();
	}

	public void selectAssignShiftForPetrol(String shift) throws InterruptedException {
		elementUtils.waitForElementToBeClickable(dropdownShift, Constants.DEFAULT_WAIT).click();
		elementUtils.selectElementThroughLocator(dropdownSelectAssignShiftValue, shift, Constants.DEFAULT_WAIT);
	}

	public void selectAssignShift(String shift) throws InterruptedException {
		elementUtils.waitForElementToBeClickable(dropdownShift, Constants.DEFAULT_WAIT).click();
		elementUtils.selectElementThroughLocator(dropdownShiftValue, shift, Constants.DEFAULT_WAIT);
	}

	private void selectEmployeeById(String employeeID) {
	    int attempts = 0;
	    boolean selected = false;

	    while (attempts < 3 && !selected) {
	        attempts++;
	        try {
	            // Open employee select reliably
	            WebElement container = elementUtils.waitForElementToBeClickable(employeeSelectContainer, Constants.DEFAULT_WAIT);
	            try { container.click(); } catch (Exception e) { elementUtils.jsClick(employeeSelectContainer); }

	            // Wait for dropdown panel and active search input
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.DEFAULT_WAIT));
	            wait.until(ExpectedConditions.visibilityOfElementLocated(dropdownPanelVisible));
	            WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(activeSelectSearchInput));

	            // Clear & type employee ID
	            try { search.clear(); } catch (Exception ignored) {}
	            search.sendKeys(employeeID);

	            // Wait for matching option
	            By optLocator = employeeOptionById(employeeID);
	            WebElement option = wait.until(ExpectedConditions.elementToBeClickable(optLocator));
	            try { option.click(); } catch (Exception e) { ((JavascriptExecutor) driver).executeScript("arguments[0].click();", option); }
	            System.out.println("✅ Selected employee: " + option.getText().trim());
	            selected = true;

	        } catch (Exception e) {
	            System.out.println("⚠️ Attempt " + attempts + " failed while selecting employee: " + e.getMessage());
	            try { elementUtils.pressEscapeKey(); } catch (Exception ignored) {}
	            try { Thread.sleep(1000); } catch (InterruptedException ignored) {}
	        }
	    }

	    if (!selected) {
	        throw new RuntimeException("❌ Unable to select employee ID: " + employeeID);
	    }
	}


	// ✅ Fixed: use jsClick for employee box to avoid intercepted clicks
	public void fillShiftForm(String shift, String employeeID, String startTime, String endTime, String scheduledBreak, String notes)
			throws InterruptedException {

		// Open and select employee
		selectEmployeeById(employeeID);

		// Times
		elementUtils.waitForElementVisible(schedulestartshifttime, Constants.SHORT_TIME_OUT_WAIT).sendKeys(startTime);
		elementUtils.waitForElementVisible(scheduleEndshifttime, Constants.SHORT_TIME_OUT_WAIT).sendKeys(endTime);

		// Scheduled break
		elementUtils.waitForElementToBeClickable(dropdownScheduledBreak, Constants.DEFAULT_WAIT).click();
		elementUtils.selectElementThroughLocator(dropdownScheduledBreakValues, scheduledBreak, Constants.DEFAULT_WAIT);
		elementUtils.waitForElementVisible(txtboxAddNotes, Constants.SHORT_TIME_OUT_WAIT).sendKeys(notes);
		elementUtils.waitForElementToBeClickable(btnCreateShift, Constants.DEFAULT_WAIT).click();
	}

	// ✅ Fixed: use jsClick for employee box
	public void fillShiftFormPatrol(String employeeID, String startTime, String endTime, String scheduledBreak, String notes)
			throws InterruptedException {

		// Open and select employee
		selectEmployeeById(employeeID);

		// Start & End time
		elementUtils.waitForElementVisible(scheduledStartShiftTime, Constants.DEFAULT_WAIT).sendKeys(startTime);
		WebElement endTimeInput = elementUtils.waitForElementVisible(scheduledEndShiftTime, Constants.DEFAULT_WAIT);
		try { endTimeInput.clear(); } catch (Exception ignored) {}
		endTimeInput.sendKeys(endTime);

		// Scheduled break
		elementUtils.waitForElementToBeClickable(dropdownScheduledBreak, Constants.DEFAULT_WAIT).click();
		elementUtils.selectElementThroughLocator(dropdownScheduledBreakValuesPatrol, scheduledBreak, Constants.DEFAULT_WAIT);
		String xpathScheduledBreak = "//span[contains(text(),'" + scheduledBreak + "')]";
		elementUtils.waitForElementVisible(By.xpath(xpathScheduledBreak), Constants.DEFAULT_WAIT);
	
		elementUtils.waitForElementVisible(txtboxAddNotes, Constants.SHORT_TIME_OUT_WAIT).sendKeys(notes);
		elementUtils.waitForElementToBeClickable(btnCreateShift, Constants.DEFAULT_WAIT).click();
	}

	private int getDatePosition(String targetDay) {
		List<WebElement> dateElements = elementUtils.getElements(dataDate);
		for (int i = 0; i < dateElements.size(); i++) {
			String dateText = dateElements.get(i).getText().trim();
			String[] parts = dateText.split(" ");
			if (parts.length == 3) {
				String dayNumber = parts[2];
				if (dayNumber.equals(targetDay)) {
					return i + 1;
				}
			}
		}
		return -1;
	}

	public String getSuccessMessageShiftAdded() {
		return elementUtils.waitForElementVisible(successMsgShiftAdd, Constants.DEFAULT_WAIT).getText().trim();
	}

	public void clickPublishButton() {
		elementUtils.waitForInvisibilityOfElementLocated(successMsgShiftAdd, Constants.DEFAULT_WAIT);
		elementUtils.waitForElementToBeClickable(btnPublish, Constants.DEFAULT_WAIT).click();
	}

	public String getAreYouSureText() {
		return elementUtils.waitForElementVisible(txtAreYouSure, Constants.DEFAULT_WAIT).getText();
	}

	public String getPublishShiftsConfirmationText() {
		return elementUtils.waitForElementVisible(txtThisActionWillPublishShifts, Constants.DEFAULT_WAIT).getText();
	}

	public void clickOkButton() {
		elementUtils.waitForElementToBeClickable(btnOk, Constants.DEFAULT_WAIT).click();
	}

	public void clickCancelButton() {
		elementUtils.waitForElementToBeClickable(btnCancel, Constants.DEFAULT_WAIT).click();
	}

	public String getSuccessMessageAfterPublish() {
		return elementUtils.waitForElementVisible(successMsgPublish, Constants.DEFAULT_WAIT).getText();
	}
}
