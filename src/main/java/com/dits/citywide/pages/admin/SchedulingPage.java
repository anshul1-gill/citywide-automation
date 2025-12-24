package com.dits.citywide.pages.admin;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

import com.dits.citywide.constants.Constants;
import com.dits.citywide.driverfactory.DriverFactory;
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
	private By searchEmployee = By
			.xpath("//label[contains(text(),' Employee')]/following-sibling::div//input[@type='search']");
	private By txtboxEmployee = By.xpath("(//span[@class='ant-select-selection-item'])[5]");
	private By employeeList = By
			.xpath("//div[@class='ant-select-dropdown css-yw7p3q ant-select-dropdown-placement-bottomLeft']");
	private By dataSiteId = By.xpath("//label[contains(text(),'Site Id')]/following-sibling::span");
	private By dataServiceType = By.xpath("//label[contains(text(),'Service Type')]/following-sibling::span");
	private By dataStartTime = By.xpath("(//label[contains(text(),'Scheduled Shift Time')]/..//div/input)[1]");
	private By dataEndTime = By.xpath("(//label[contains(text(),'Scheduled Shift Time')]/..//div/input)[2]");
	private By closeIconStartTime = By.xpath(
			"(//label[contains(text(),'Scheduled Shift Time')]/..//span[contains(@class,'anticon-close-circle')])[1]");
	private By closeIconEndTime = By.xpath(
			"(//label[contains(text(),'Scheduled Shift Time')]/..//span[contains(@class,'anticon-close-circle')])[2]");
	private By schedulestartshifttime = By.xpath("(//input[@placeholder='HH:MM'])[1]");
	private By scheduleEndshifttime = By.xpath("(//input[@placeholder='HH:MM'])[2]");
	private By dropdownScheduledBreak = By
			.xpath("//label[contains(text(),'Scheduled break')]/..//div[@class='ant-select-selector']");
	private By scheduleBreakforAdmin = By.xpath(
			"(//div[contains(@class,'ant-select') and contains(@class,'selectBox')]//div[@class='ant-select-selector'])[2]");
	private By dropdownScheduledBreakValues = By.xpath(
			"//div[contains(@class,'ant-select-item-option-content')]//span[normalize-space()='Training Break - 45min (Unpaid)']");
	private By txtboxAddNotes = By.xpath("//textarea[@placeholder='Add Notes']");
	private By btnCreateShift = By.xpath("//span[contains(text(),'Create Shift')]");
	private By successMsgShiftAdd = By.xpath("//div[contains(text(),'Shift added successfully')]");
	private By btnPublish = By.xpath("//span[contains(text(),'Publish')]");
	private By txtAreYouSure = By.xpath("//h2[@id='swal2-title']");
	private By txtThisActionWillPublishShifts = By.xpath("//div[@id='swal2-html-container']");
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
	private By dropdownScheduledBreakValuesPatrol = By
			.xpath("(//div[@class='rc-virtual-list-holder-inner'])[5]/div/div");
	private By dropdownScheduledBreakValuesAdmin = By.xpath(
			"//div[contains(@class,'ant-select-dropdown') and not(contains(@class,'hidden'))]//div[contains(@class,'ant-select-item-option-content')]");
	private By visibleDropdownOptions = By.xpath(
			"//div[contains(@class,'ant-select-dropdown') and not(contains(@class,'hidden'))]//div[contains(@class,'ant-select-item-option-content')]");

	// Mark As Callout locators
	private By btnMarkAsCallout = By.xpath("//button[contains(text(),'Mark as Callout')]");
	private By txtMarkAsCalloutReason = By.xpath("//textarea[@placeholder='Enter reason']");
	private By btnSubmitMarkAsCallout = By
			.xpath("//button[contains(@class,'ant-btn-primary')]//span[contains(text(),'Submit')]");
	private By successMsgMarkAsCallout = By
			.xpath("//div[contains(text(),'marked as callout') or contains(text(),'Callout marked successfully')]");

	// Update Shift locators
	private By contextMenuUpdate = By
			.xpath("//span[@class='ant-dropdown-menu-title-content'][contains(text(),'Update')]");
	private By contextMenuCopy = By.xpath("//span[@class='ant-dropdown-menu-title-content'][contains(text(),'Copy')]");
	private By contextMenuPaste = By
			.xpath("(//span[@class='ant-dropdown-menu-title-content' and normalize-space(text())='Paste'])[2]");
	// Floating Paste button that appears after copying a shift
	private By btnFloatingPaste = By.xpath("//button[contains(text(),'Paste')]");
	private By btnSaveUpdate = By.xpath("//button[contains(@class,'ant-btn')]//span[contains(text(),'Update Shift')]");
	private By successMsgShiftUpdate = By
			.xpath("//div[contains(text(),'Shift updated successfully') or contains(text(),'updated successfully')]");
	private By successMsgShiftDelete = By.xpath("//div[contains(text(),'Shift deleted successfully')]");

	// Helper locators
	private By employeeDropdownOptions = By.xpath("//div[contains(@class,'ant-select-item-option')]");
	private By optionBeatGeneric = By.xpath("//div[contains(@class,'ant-select-item-option')][contains(.,'Beat')]");

	// Send Shift locators
	private By contextMenuSendShift = By
			.xpath("//span[@class='ant-dropdown-menu-title-content'][contains(text(),'Send Shift')]");
	private By sendShiftModalTitle = By
			.xpath("//div[contains(@class,'ant-modal-title')][contains(text(),'Send Shift')]");
	private By departmentCheckbox = By.xpath("//span[contains(@class,'ant-checkbox')]");
	private By toggleAssignAutomatically = By
			.xpath("//button[contains(@class,'ant-switch') and @role='switch']");
	private By searchEmployeeInSendShift = By
			.xpath("//input[@placeholder='Search employees' or @placeholder='Search']");
	private By employeeCheckboxInSendShift = By.xpath("//input[@type='checkbox']/parent::span");
	private By btnSendShift = By
			.xpath("//button[contains(@class,'ant-btn-primary')]//span[contains(text(),'Send Shift')]");
	private By successMsgSendShift = By
			.xpath("//div[contains(text(),'Shift sent successfully') or contains(text(),'sent successfully')]");
	private By tabHistory = By.xpath("//div[@role='tab'][contains(text(),'History')]");
	private By btnAssignShiftInHistory = By
			.xpath("//button[contains(@class,'ant-btn')]//span[contains(text(),'Assign Shift')]");
	private By btnUpdateShiftInModal = By
			.xpath("//button[contains(@class,'ant-btn-primary')]//span[contains(text(),'Update Shift')]");

	private By getBeatValueOption(String beatName) {
		return By.xpath("//div[contains(@class,'ant-select-item-option')][contains(.,'" + beatName + "')]");
	}

	private By employeeSelectContainer = By
			.xpath("//div[contains(@class,'officer-modal')]//div[@class='ant-select-selector']");
	private By activeSelectSearchInput = By.xpath(
			"//div[contains(@class,'ant-select-dropdown') and not(contains(@style,'display: none'))]//input[@type='search']");
	private By dropdownPanelVisible = By
			.xpath("//div[contains(@class,'ant-select-dropdown') and not(contains(@class,'hidden'))]");

	private By employeeOptionById(String employeeID) {
		return By.xpath("//div[contains(@class,'ant-select-item-option-content')]" +
				"[contains(translate(.,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'), '"
				+ employeeID.toLowerCase() + "')]");
	}

	public SchedulingPage(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(driver);
	}

	public void selectAgentTypeFilter(String agentType) throws InterruptedException {
		// This selects the agent type from the top dropdown (Admin/Dispatch,
		// Stationary, Mobile)
		// This is done BEFORE clicking filters
		Thread.sleep(1000);

		By agentTypeDropdown = By
				.xpath("//div[contains(@class,'ant-select-selector')]//span[@title='" + agentType + "']/..");

		// Try to find and click the dropdown if not already showing the desired value
		try {
			WebElement currentValue = driver.findElement(By
					.xpath("//div[contains(@class,'ant-select-selector')]//span[@class='ant-select-selection-item']"));
			if (!currentValue.getText().trim().equals(agentType)) {
				// Click to open dropdown
				currentValue.click();
				Thread.sleep(500);

				// Select the option
				By optionLocator = By
						.xpath("//div[contains(@class,'ant-select-item-option-content')][normalize-space()='"
								+ agentType + "']");
				WebElement option = elementUtils.waitForElementVisible(optionLocator, Constants.DEFAULT_WAIT);
				try {
					option.click();
				} catch (Exception e) {
					((JavascriptExecutor) driver).executeScript("arguments[0].click();", option);
				}
				System.out.println("✅ Selected agent type filter: " + agentType);
				Thread.sleep(1000); // Wait for page to update
			} else {
				System.out.println("✅ Agent type already set to: " + agentType);
			}
		} catch (Exception e) {
			System.out.println("⚠️ Could not verify/change agent type: " + e.getMessage());
		}
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

		By siteTypeOption = By
				.xpath("//div[contains(@class,'ant-select-item-option-content')][contains(.,'" + siteType + "')]");
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
		elementUtils.waitForInvisibilityOfElementLocated(loader, Constants.DEFAULT_WAIT);
		try {
			elementUtils.pressEscapeKey();
		} catch (Exception ignored) {
		}
		try {
			elementUtils.waitForElementToBeClickable(dropdwonBeat, Constants.DEFAULT_WAIT).click();
		} catch (Exception e) {
			elementUtils.jsClick(dropdwonBeat);
		}
		WebElement beatInput;
		try {
			beatInput = elementUtils.waitForElementVisible(dropdownSelectBeat, Constants.DEFAULT_WAIT);
		} catch (Exception e) {
			beatInput = elementUtils.waitForElementVisible(activeSelectSearchInput, Constants.DEFAULT_WAIT);
		}
		try {
			beatInput.clear();
		} catch (Exception ignored) {
		}
		try {
			beatInput.sendKeys(beatName);
		} catch (Exception e) {
			try {
				elementUtils.doActionsSendKeys(dropdownSelectBeat, beatName);
			} catch (Exception ex2) {
				elementUtils.sendKeysUsingJavaScript(dropdownSelectBeat, beatName, Constants.DEFAULT_WAIT);
			}
		}
		By beatValue = By.xpath(
				"//div[contains(@class,'ant-select-item-option-content')][contains(translate(., 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '"
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
			selected = true;
		} catch (Exception e) {
			try {
				elementUtils.pressEnterKey();
				selected = true;
			} catch (Exception ignored) {
			}
		}
		if (!selected) {
			throw new RuntimeException("Beat option not found: " + beatName);
		}
		elementUtils.waitForElementToBeClickable(btnApply, Constants.DEFAULT_WAIT).click();
	}

	public void addShift(String date) throws InterruptedException {
		elementUtils.waitForInvisibilityOfElementLocated(txtNoData, Constants.DEFAULT_WAIT);
		elementUtils.waitForInvisibilityOfElementLocated(btnApply, Constants.DEFAULT_WAIT);
		int i = getDatePosition(date);
		String datexpath = "(//th[normalize-space()='Service Type']/ancestor::thead/following-sibling::tbody//div[@class='add-shift'])["
				+ i + "]";
		By addShiftLocator = By.xpath(datexpath);
		WebDriver driver = DriverFactory.getDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement addShiftEl = elementUtils.waitForElementVisible(addShiftLocator, Constants.DEFAULT_WAIT);
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", addShiftEl);
		Thread.sleep(400);
		try {
			elementUtils.waitForElementToBeClickable(addShiftLocator, Constants.DEFAULT_WAIT).click();
		} catch (ElementClickInterceptedException e) {
			js.executeScript("arguments[0].click();", addShiftEl);
		}
	}

	public void selectAssignShiftForPetrol(String shift) throws InterruptedException {
		elementUtils.waitForElementToBeClickable(dropdownShift, Constants.DEFAULT_WAIT).click();
		elementUtils.selectElementThroughLocator(visibleDropdownOptions, shift, Constants.DEFAULT_WAIT);
	}

	public void selectAssignShift(String shift) throws InterruptedException {
		elementUtils.waitForElementToBeClickable(dropdownShift, Constants.DEFAULT_WAIT).click();
		elementUtils.selectElementThroughLocator(dropdownShiftValue, shift, Constants.DEFAULT_WAIT);
		elementUtils.waitForInvisibilityOfElementLocated(dropdownPanelVisible, Constants.DEFAULT_WAIT);
	}

	public void selectAgentType(String agentType) throws InterruptedException {
		// Wait for the agent type dropdown to be visible in the modal
		Thread.sleep(1000); // Wait for modal to fully load

		// Build dynamic xpath for the agent type option
		By agentTypeOption = By.xpath(
				"//div[contains(@class,'ant-select-item-option-content')][normalize-space()='" + agentType + "']");

		try {
			WebElement option = elementUtils.waitForElementVisible(agentTypeOption, Constants.DEFAULT_WAIT);
			elementUtils.waitElementToBeClickableThroughElement(option, Constants.SHORT_TIME_OUT_WAIT);
			try {
				option.click();
			} catch (Exception e) {
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", option);
			}
			System.out.println("✅ Selected agent type: " + agentType);
		} catch (Exception e) {
			System.out.println("⚠️ Failed to select agent type: " + agentType + " - " + e.getMessage());
			throw e;
		}
	}

	public void selectEmployeeById(String employeeID) throws InterruptedException {
		elementUtils.waitForInvisibilityOfElementLocated(loader, Constants.DEFAULT_WAIT);

		// Use the specific search input locator defined in the class
		By searchInputLocator = By
				.xpath("//label[contains(text(),'Employee')]/..//input[@class='ant-select-selection-search-input']");

		try {
			WebElement searchInput = elementUtils.waitForElementToBeClickable(searchInputLocator, 10);
			try {
				searchInput.click();
			} catch (Exception e) {
				elementUtils.jsClick(searchInputLocator);
			}

			// More robust clearing: select all and delete
			searchInput.sendKeys(Keys.chord(Keys.CONTROL, "a"));
			searchInput.sendKeys(Keys.DELETE);
			Thread.sleep(300);

			// CORRECT APPROACH: Type full ID → backspace last char → wait → retype last
			// char only
			// Example: For "1183" → type "1183" → backspace → becomes "118" → type "3" →
			// "1183"
			// This ensures stable search results without concatenation

			if (employeeID.length() > 1) {
				// Step 1: Type the complete ID first
				System.out.println("🔍 Step 1: Typing full ID: " + employeeID);
				searchInput.sendKeys(employeeID);
				Thread.sleep(2000); // Wait for dropdown to fully load

				// Step 2: Backspace to remove last character
				System.out.println("🔍 Step 2: Backspacing last character");
				searchInput.sendKeys(Keys.BACK_SPACE);
				Thread.sleep(500); // Wait for search to update

				// Step 3: Type only the last character again
				String lastChar = employeeID.substring(employeeID.length() - 1);
				System.out.println("🔍 Step 3: Typing last character: " + lastChar);
				searchInput.sendKeys(lastChar);
				Thread.sleep(1500); // Wait for final filter results to stabilize
				System.out.println("🔍 Final search value should be: " + employeeID);
			} else {
				// For single character IDs, just type normally
				System.out.println("🔍 Typing single character ID: " + employeeID);
				searchInput.sendKeys(employeeID);
				Thread.sleep(1500);
			}

			// Don't press ENTER - let dropdown stay open for selection

		} catch (Exception e) {
			// Fallback approach if direct input fails
			By dropdownSelector = By.cssSelector("div.ant-select.officer-modal.selectBox .ant-select-selector");
			elementUtils.clickWithRetry(dropdownSelector, 3, 2);
			Thread.sleep(500);
			try {
				WebElement activeElement = driver.switchTo().activeElement();

				if (employeeID.length() > 1) {
					// Type full ID, backspace, then retype last char
					activeElement.sendKeys(employeeID);
					Thread.sleep(2000); // Wait for dropdown to fully load
					activeElement.sendKeys(Keys.BACK_SPACE);
					Thread.sleep(500);
					String lastChar = employeeID.substring(employeeID.length() - 1);
					activeElement.sendKeys(lastChar);
					Thread.sleep(1500);
				} else {
					activeElement.sendKeys(employeeID);
					Thread.sleep(1500);
				}
			} catch (Exception ex) {
				System.out.println("⚠️ Active element fallback failed: " + ex.getMessage());
			}
		}

		// Wait and Click Option
		try {
			// Target specific visible dropdown options
			By visibleOption = By.xpath(
					"//div[contains(@class,'ant-select-dropdown') and not(contains(@class,'hidden'))]//div[contains(@class,'ant-select-item-option-content')]");

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(visibleOption));

			boolean found = false;
			for (WebElement op : options) {
				String text = op.getText();
				if (text.isEmpty()) {
					text = op.getAttribute("textContent");
				}

				// Use startsWith for exact ID match (format: "855 - John Doe")
				if (text != null && text.trim().startsWith(employeeID.trim())) {
					try {
						op.click();
					} catch (Exception e) {
						((JavascriptExecutor) driver).executeScript("arguments[0].click();", op);
					}
					found = true;
					System.out.println("✅ Selected employee: " + text.trim());
					break;
				}
			}

			if (!found) {
				throw new RuntimeException("Employee with ID '" + employeeID + "' not found in filtered list.");
			}

		} catch (

		TimeoutException e) {
			System.out.println("⚠️ No visible options appeared after search (Timeout).");
			throw e;
		}

		Thread.sleep(500);
	}

	public void fillShiftForm(String shift, String employeeID, String startTime, String endTime, String scheduledBreak,
			String notes)
			throws InterruptedException {

		selectEmployeeById(employeeID); // ✅ updated, robust

		// Start time - hover to show close icon, click to clear, then type
		WebElement startTimeInput = elementUtils.waitForElementVisible(dataStartTime, Constants.SHORT_TIME_OUT_WAIT);
		try {
			Actions actions = new Actions(driver);
			actions.moveToElement(startTimeInput).perform();
			Thread.sleep(500);
			// Look for close icon and click it
			By closeIconStart = By.xpath(
					"(//label[contains(text(),'Scheduled Shift Time')]/..//div/input)[1]/..//span[contains(@class,'anticon-close-circle')]");
			WebElement clearIcon = elementUtils.waitForElementToBeClickable(closeIconStart, 3);
			clearIcon.click();
			Thread.sleep(500);
		} catch (Exception e) {
			// No close icon, just clear normally
		}
		startTimeInput.click();
		startTimeInput.sendKeys(startTime);
		Thread.sleep(500);

		// End time - hover to show close icon, click to clear, then type
		WebElement endTimeInput = elementUtils.waitForElementVisible(dataEndTime, Constants.SHORT_TIME_OUT_WAIT);
		try {
			Actions actions = new Actions(driver);
			actions.moveToElement(endTimeInput).perform();
			Thread.sleep(500);
			// Look for close icon and click it
			By closeIconEnd = By.xpath(
					"(//label[contains(text(),'Scheduled Shift Time')]/..//div/input)[2]/..//span[contains(@class,'anticon-close-circle')]");
			WebElement clearIcon = elementUtils.waitForElementToBeClickable(closeIconEnd, 3);
			clearIcon.click();
			Thread.sleep(500);
		} catch (Exception e) {
			// No close icon, just clear normally
		}
		endTimeInput.click();
		endTimeInput.sendKeys(endTime);
		Thread.sleep(500);

		// Close time picker
		endTimeInput.sendKeys(Keys.ENTER);
		Thread.sleep(1000);

		elementUtils.waitForElementToBeClickable(dropdownScheduledBreak, Constants.DEFAULT_WAIT).click();
		Thread.sleep(500); // Wait for dropdown animation

		// Use robust text-based selection with fallback
		By breakOption = By.xpath(
				"//div[contains(@class,'ant-select-item-option-content')][contains(.,'" + scheduledBreak + "')]");
		try {
			WebElement option = elementUtils.waitForElementVisible(breakOption, 5);
			option.click();
		} catch (Exception e) {
			// System.out.println("Standard break selection failed, trying JS click: " +
			// e.getMessage());
			elementUtils.jsClick(breakOption);
		}

		elementUtils.waitForElementVisible(txtboxAddNotes, Constants.SHORT_TIME_OUT_WAIT).sendKeys(notes);
		Thread.sleep(1000); // Ensure form validation/UI state is ready
		elementUtils.waitForElementToBeClickable(btnCreateShift, Constants.DEFAULT_WAIT).click();
	}

	public void fillShiftFormPatrol(String employeeID, String startTime, String endTime, String scheduledBreak,
			String notes)
			throws InterruptedException {

		selectEmployeeById(employeeID);

		// Start time - hover to show close icon, click to clear, then type
		WebElement startTimeInput = elementUtils.waitForElementVisible(dataStartTime, Constants.DEFAULT_WAIT);
		try {
			Actions actions = new Actions(driver);
			actions.moveToElement(startTimeInput).perform();
			Thread.sleep(500);
			// Look for close icon and click it
			By closeIconStart = By.xpath(
					"(//label[contains(text(),'Scheduled Shift Time')]/..//div/input)[1]/..//span[contains(@class,'anticon-close-circle')]");
			WebElement clearIcon = elementUtils.waitForElementToBeClickable(closeIconStart, 3);
			clearIcon.click();
			Thread.sleep(500);
		} catch (Exception e) {
			// No close icon, just clear normally
		}
		startTimeInput.click();
		startTimeInput.sendKeys(startTime);
		Thread.sleep(500);

		// End time - hover to show close icon, click to clear, then type
		WebElement endTimeInput = elementUtils.waitForElementVisible(dataEndTime, Constants.DEFAULT_WAIT);
		try {
			Actions actions = new Actions(driver);
			actions.moveToElement(endTimeInput).perform();
			Thread.sleep(500);
			// Look for close icon and click it
			By closeIconEnd = By.xpath(
					"(//label[contains(text(),'Scheduled Shift Time')]/..//div/input)[2]/..//span[contains(@class,'anticon-close-circle')]");
			WebElement clearIcon = elementUtils.waitForElementToBeClickable(closeIconEnd, 3);
			clearIcon.click();
			Thread.sleep(500);
		} catch (Exception e) {
			// No close icon, just clear normally
		}
		endTimeInput.click();
		endTimeInput.sendKeys(endTime);
		Thread.sleep(500);

		// Close time picker
		endTimeInput.sendKeys(Keys.ENTER);
		Thread.sleep(1000);

		elementUtils.waitForElementToBeClickable(dropdownScheduledBreak, Constants.DEFAULT_WAIT).click();
		elementUtils.selectElementThroughLocator(dropdownScheduledBreakValuesPatrol, scheduledBreak,
				Constants.DEFAULT_WAIT);
		String xpathScheduledBreak = "//span[contains(text(),'" + scheduledBreak + "')]";
		elementUtils.waitForElementVisible(By.xpath(xpathScheduledBreak), Constants.DEFAULT_WAIT);
		elementUtils.waitForElementVisible(txtboxAddNotes, Constants.SHORT_TIME_OUT_WAIT).sendKeys(notes);
		elementUtils.waitForElementToBeClickable(btnCreateShift, Constants.DEFAULT_WAIT).click();
	}

	public void fillShiftFormAdmin(String employeeID, String startTime, String endTime,
			String scheduledBreak, String notes) throws InterruptedException {

		// Open and select employee
		selectEmployeeById(employeeID);

		fillOpenShiftForm(startTime, endTime, scheduledBreak, notes);
	}

	public void fillOpenShiftForm(String startTime, String endTime, String scheduledBreak, String notes)
			throws InterruptedException {

		// Clear and enter start time
		WebElement startTimeInput = elementUtils.waitForElementVisible(dataStartTime, Constants.DEFAULT_WAIT);

		// Hover over input to show close icon, then click it
		try {
			Actions actions = new Actions(driver);
			actions.moveToElement(startTimeInput).perform();
			Thread.sleep(500); // Wait for close icon to appear on hover

			WebElement clearStartIcon = elementUtils.waitForElementToBeClickable(closeIconStartTime, 3);
			clearStartIcon.click();
			Thread.sleep(500);
		} catch (Exception e) {
			// If no close icon, select all and clear
			startTimeInput.click();
			startTimeInput.sendKeys(Keys.chord(Keys.CONTROL, "a"));
			startTimeInput.sendKeys(Keys.DELETE);
		}

		// Enter start time
		startTimeInput.click();
		startTimeInput.sendKeys(startTime);
		Thread.sleep(500);

		// Clear and enter end time
		WebElement endTimeInput = elementUtils.waitForElementVisible(dataEndTime, Constants.DEFAULT_WAIT);

		// Hover over input to show close icon, then click it
		try {
			Actions actions = new Actions(driver);
			actions.moveToElement(endTimeInput).perform();
			Thread.sleep(500); // Wait for close icon to appear on hover

			WebElement clearEndIcon = elementUtils.waitForElementToBeClickable(closeIconEndTime, 3);
			clearEndIcon.click();
			Thread.sleep(500);
		} catch (Exception e) {
			// If no close icon, select all and clear
			endTimeInput.click();
			endTimeInput.sendKeys(Keys.chord(Keys.CONTROL, "a"));
			endTimeInput.sendKeys(Keys.DELETE);
		}

		// Enter end time
		endTimeInput.click();
		endTimeInput.sendKeys(endTime);
		Thread.sleep(500);

		// Close time picker
		endTimeInput.sendKeys(Keys.ENTER);
		Thread.sleep(2000); // Longer wait for form to stabilize after time input

		// Scheduled break
		elementUtils.waitForElementToBeClickable(dropdownScheduledBreak, Constants.DEFAULT_WAIT).click();
		Thread.sleep(500); // Wait for dropdown to open

		// Click the specific break option
		By breakOption = By.xpath(
				"//div[contains(@class,'ant-select-item-option-content')]//span[contains(text(),'" + scheduledBreak
						+ "')]");
		elementUtils.waitForElementToBeClickable(breakOption, Constants.DEFAULT_WAIT).click();

		// Add notes
		elementUtils.waitForElementVisible(txtboxAddNotes, Constants.SHORT_TIME_OUT_WAIT).sendKeys(notes);

		// Create shift
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

	// ========== UPDATE SHIFT METHODS ==========

	/**
	 * Find shift on calendar by time and employee ID
	 * 
	 * @param time       - Shift time (e.g., "09:00 - 17:00")
	 * @param employeeID - Employee ID (e.g., "1172")
	 * @return WebElement representing the shift
	 */
	public WebElement findShiftByDetails(String time, String employeeID) throws InterruptedException {
		By shiftLocator = By.xpath("//div[contains(@class,'shift') and .//div[contains(text(),'" + time
				+ "')] and .//div[contains(text(),'" + employeeID + "')]]");
		return elementUtils.waitForElementVisible(shiftLocator, Constants.DEFAULT_WAIT);
	}

	/**
	 * Right-click on shift to open context menu
	 * 
	 * @param time       - Shift time
	 * @param employeeID - Employee ID
	 */
	public void rightClickOnShift(String time, String employeeID) throws InterruptedException {
		WebElement shift = findShiftByDetails(time, employeeID);
		Actions actions = new Actions(driver);
		actions.contextClick(shift).perform(); // Right-click / secondary click
		Thread.sleep(500); // Wait for context menu to appear
		System.out.println("✅ Right-clicked on shift: " + time + " for employee " + employeeID);
	}

	/**
	 * Find an open (unassigned) shift on calendar by time
	 * 
	 * @param time - Shift time (e.g., "09:00 - 17:00")
	 * @return WebElement representing the shift
	 */
	public WebElement findOpenShiftByDetails(String time) throws InterruptedException {
		// An open shift has class 'shift-type' with text 'Open'
		By shiftLocator = By.xpath(
				"//div[contains(@class,'shift')]//div[contains(@class,'shift-type') and contains(text(),'Open')]/ancestor-or-self::div[contains(@class,'shift') and .//div[contains(text(),'"
						+ time + "')]]");
		return elementUtils.waitForElementVisible(shiftLocator, Constants.DEFAULT_WAIT);
	}

	/**
	 * Right-click on an open shift to open context menu
	 * 
	 * @param time - Shift time
	 */
	public void rightClickOnOpenShift(String time) throws InterruptedException {
		WebElement shift = findOpenShiftByDetails(time);
		Actions actions = new Actions(driver);
		actions.contextClick(shift).perform(); // Right-click
		Thread.sleep(500); // Wait for context menu to appear
		System.out.println("✅ Right-clicked on open shift: " + time);
	}

	/**
	 * Click "Update" option from context menu
	 */
	public void clickUpdateFromContextMenu() throws InterruptedException {
		elementUtils.waitForElementToBeClickable(contextMenuUpdate, Constants.DEFAULT_WAIT).click();
		Thread.sleep(1000); // Wait for update form to load
		System.out.println("✅ Clicked 'Update' from context menu");
	}

	/**
	 * Update shift details in the update form
	 * 
	 * @param newStartTime - New start time
	 * @param newEndTime   - New end time
	 * @param newBreak     - New break option
	 * @param newNotes     - New notes
	 */
	public void updateShiftDetails(String newStartTime, String newEndTime, String newBreak, String newNotes)
			throws InterruptedException {
		// Update start time using hover approach
		WebElement startTimeInput = elementUtils.waitForElementVisible(dataStartTime, Constants.DEFAULT_WAIT);
		try {
			Actions actions = new Actions(driver);
			actions.moveToElement(startTimeInput).perform();
			Thread.sleep(500);
			By closeIconStart = By.xpath(
					"(//label[contains(text(),'Scheduled Shift Time')]/..//div/input)[1]/..//span[contains(@class,'anticon-close-circle')]");
			WebElement clearIcon = elementUtils.waitForElementToBeClickable(closeIconStart, 3);
			clearIcon.click();
			Thread.sleep(500);
		} catch (Exception e) {
			// No close icon, continue
		}
		startTimeInput.click();
		startTimeInput.sendKeys(newStartTime);
		Thread.sleep(500);

		// Update end time using hover approach
		WebElement endTimeInput = elementUtils.waitForElementVisible(dataEndTime, Constants.DEFAULT_WAIT);
		try {
			Actions actions = new Actions(driver);
			actions.moveToElement(endTimeInput).perform();
			Thread.sleep(500);
			By closeIconEnd = By.xpath(
					"(//label[contains(text(),'Scheduled Shift Time')]/..//div/input)[2]/..//span[contains(@class,'anticon-close-circle')]");
			WebElement clearIcon = elementUtils.waitForElementToBeClickable(closeIconEnd, 3);
			clearIcon.click();
			Thread.sleep(500);
		} catch (Exception e) {
			// No close icon, continue
		}
		endTimeInput.click();
		endTimeInput.sendKeys(newEndTime);
		Thread.sleep(500);
		endTimeInput.sendKeys(Keys.ENTER);
		Thread.sleep(2000); // Increased wait to ensure time picker fully closes

		// Update break
		elementUtils.waitForElementToBeClickable(dropdownScheduledBreak, Constants.DEFAULT_WAIT).click();
		Thread.sleep(500);
		By breakOption = By
				.xpath("//div[@class='ant-select-item-option-content']//span[contains(text(),'" + newBreak + "')]");
		elementUtils.waitForElementToBeClickable(breakOption, Constants.DEFAULT_WAIT).click();
		Thread.sleep(500);

		// Update notes
		WebElement notesInput = elementUtils.waitForElementVisible(txtboxAddNotes, Constants.DEFAULT_WAIT);
		notesInput.clear();
		notesInput.sendKeys(newNotes);
		Thread.sleep(500);

		// Click Save/Update button
		elementUtils.waitForElementToBeClickable(btnSaveUpdate, Constants.DEFAULT_WAIT).click();
		System.out
				.println("✅ Updated shift details - Time: " + newStartTime + "-" + newEndTime + ", Break: " + newBreak);
	}

	/**
	 * Click the Save/Update button in the shift update form
	 */
	public void clickSaveUpdateButton() throws InterruptedException {
		elementUtils.waitForElementToBeClickable(btnSaveUpdate, Constants.DEFAULT_WAIT).click();
		Thread.sleep(1000); // Wait for save operation to complete
		System.out.println("✅ Clicked Save/Update button");
	}

	/**
	 * Get success message after updating shift
	 * 
	 * @return Success message text
	 */
	public String getUpdateSuccessMessage() {
		return elementUtils.waitForElementVisible(successMsgShiftUpdate, Constants.DEFAULT_WAIT).getText();
	}

	// ========== COPY PASTE SHIFT METHODS ==========

	/**
	 * Click "Copy" option from context menu
	 */
	public void clickCopyFromContextMenu() throws InterruptedException {
		elementUtils.waitForElementToBeClickable(contextMenuCopy, Constants.DEFAULT_WAIT).click();
		Thread.sleep(500);
		System.out.println("✅ Clicked 'Copy' from context menu");
	}

	/**
	 * Right-click on a specific date cell to open context menu for paste
	 * 
	 * @param date - Date to right-click (e.g., "18", "19")
	 */
	public void rightClickOnDateForPaste(String date) throws InterruptedException {
		// Find the column header with the date
		By dateHeaderLocator = By.xpath("//th[contains(@class,'week-day') and contains(text(),', Dec " + date + "')]");

		// Find the date header
		WebElement dateHeader = elementUtils.waitForElementVisible(dateHeaderLocator, Constants.DEFAULT_WAIT);
		System.out.println("✅ Found date header for: Dec " + date);

		// Get the column index
		String script = "var th = arguments[0]; var index = Array.from(th.parentNode.children).indexOf(th); return index;";
		Long columnIndex = (Long) ((org.openqa.selenium.JavascriptExecutor) driver).executeScript(script, dateHeader);

		// Find the td cell in that column
		By tdCellLocator = By.xpath("//tr//td[" + (columnIndex + 1) + "][contains(@class,'detail-box')]");
		WebElement tdCell = elementUtils.waitForElementVisible(tdCellLocator, Constants.DEFAULT_WAIT);

		// Right-click on the cell
		Actions actions = new Actions(driver);
		actions.contextClick(tdCell).perform();
		Thread.sleep(500);
		System.out.println("✅ Right-clicked on date cell: Dec " + date);
	}

	public void clickPasteFromContextMenu() throws InterruptedException {
		elementUtils.waitForElementToBeClickable(contextMenuPaste, Constants.DEFAULT_WAIT).click();
		Thread.sleep(1000);
		System.out.println("✅ Clicked 'Paste' from context menu");
	}

	public boolean verifyShiftExistsOnDate(String date, String time, String employeeID) {
		try {
			By shiftLocator = By.xpath("//div[contains(@class,'shift') and .//div[contains(text(),'" + time
					+ "')] and .//div[contains(text(),'" + employeeID + "')]]");
			WebElement shift = elementUtils.waitForElementVisible(shiftLocator, 5);
			boolean exists = shift.isDisplayed();
			if (exists) {
				System.out.println("✅ Shift found on date " + date + ": " + time + " for employee " + employeeID);
			}
			return exists;
		} catch (Exception e) {
			System.out.println("❌ Shift NOT found on date " + date);
			return false;
		}
	}

	/**
	 * Drag a shift from one date to another
	 * 
	 * @param sourceDate - Source date (e.g., "16")
	 * @param targetDate - Target date (e.g., "17")
	 * @param time       - Shift time (e.g., "09:00 - 17:00")
	 * @param employeeID - Employee ID
	 */
	public void dragShiftToDate(String sourceDate, String targetDate, String time, String employeeID)
			throws InterruptedException {
		try {
			// Find the shift element to drag
			WebElement sourceShift = findShiftByDetails(time, employeeID);
			System.out.println("✅ Found source shift: " + time + " for employee " + employeeID);

			// Find the target date column header
			By targetDateHeaderLocator = By
					.xpath("//th[contains(@class,'week-day') and contains(text(),', Dec " + targetDate + "')]");
			WebElement targetDateHeader = elementUtils.waitForElementVisible(targetDateHeaderLocator,
					Constants.DEFAULT_WAIT);
			System.out.println("✅ Found target date header for: Dec " + targetDate);

			// Get the column index of target date
			String script = "var th = arguments[0]; var index = Array.from(th.parentNode.children).indexOf(th); return index;";
			Long columnIndex = (Long) ((org.openqa.selenium.JavascriptExecutor) driver).executeScript(script,
					targetDateHeader);

			// Find the target td cell in that column
			By targetCellLocator = By.xpath("//tr//td[" + (columnIndex + 1) + "][contains(@class,'detail-box')]");
			WebElement targetCell = elementUtils.waitForElementVisible(targetCellLocator, Constants.DEFAULT_WAIT);
			System.out.println("✅ Found target cell for date: " + targetDate);

			// Perform drag and drop using Actions
			Actions actions = new Actions(driver);
			actions.dragAndDrop(sourceShift, targetCell).perform();
			Thread.sleep(1000); // Wait for drag-drop animation
			System.out.println("✅ Dragged shift from date " + sourceDate + " to date " + targetDate);
		} catch (Exception e) {
			System.out.println("❌ Failed to drag shift from date " + sourceDate + " to date " + targetDate);
			System.out.println("Error: " + e.getMessage());
			throw e;
		}
	}

	/**
	 * Delete a shift from the calendar
	 * 
	 * @param time       - Shift time (e.g., "09:00 - 17:00")
	 * @param employeeID - Employee ID
	 */
	public void deleteShift(String time, String employeeID) throws InterruptedException {
		try {
			WebElement shift = findShiftByDetails(time, employeeID);
			System.out.println("✅ Found shift to delete: " + time + " for employee " + employeeID);

			// Hover over the shift tile to make icons visible
			Actions actions = new Actions(driver);
			actions.moveToElement(shift).perform();
			Thread.sleep(1000);

			// Find delete icon within the shift tile - using simpler xpath
			By deleteIconLocator = By.xpath(".//span[@aria-label='delete']");
			WebElement deleteIcon = shift.findElement(deleteIconLocator);

			// Click delete icon
			elementUtils.scrollIntoView(deleteIcon);
			deleteIcon.click();
			Thread.sleep(1000);

			// Usually there's a confirmation dialog for delete
			try {
				if (elementUtils.doIsDisplayed(btnOk, 3)) {
					clickOkButton();
					System.out.println("✅ Confirmed shift deletion");
				}
			} catch (Exception e) {
				// No confirmation dialog or already handled
			}

			Thread.sleep(1000);
			System.out.println("✅ Clicked delete for shift: " + time + " for employee " + employeeID);
		} catch (Exception e) {
			System.out.println("❌ Failed to delete shift: " + time + " for employee " + employeeID);
			throw e;
		}
	}

	public void waitForShiftInvisibility(String time, String employeeID) {
		By shiftLocator = By.xpath("//div[contains(@class,'shift') and .//div[contains(text(),'" + time
				+ "')] and .//div[contains(text(),'" + employeeID + "')]]");
		elementUtils.waitForInvisibilityOfElementLocated(shiftLocator, Constants.DEFAULT_WAIT);
		System.out.println("✅ Shift element is now invisible");
	}

	/**
	 * Get success message after deleting shift
	 * 
	 * @return Success message text
	 */
	public String getDeleteSuccessMessage() {
		return elementUtils.waitForElementVisible(successMsgShiftDelete, Constants.DEFAULT_WAIT).getText();
	}

	// ========== MARK AS CALLOUT METHODS ==========

	/**
	 * Click "Mark as Callout" button in the shift modal
	 */
	public void clickMarkAsCallout() throws InterruptedException {
		elementUtils.waitForElementToBeClickable(btnMarkAsCallout, Constants.DEFAULT_WAIT).click();
		Thread.sleep(500);
		System.out.println("✅ Clicked 'Mark as Callout' button");
	}

	/**
	 * Fill the reason in the Mark as Callout modal
	 * 
	 * @param reason - Reason for marking as callout
	 */
	public void fillMarkAsCalloutReason(String reason) throws InterruptedException {
		WebElement reasonInput = elementUtils.waitForElementVisible(txtMarkAsCalloutReason, Constants.DEFAULT_WAIT);
		reasonInput.clear();
		reasonInput.sendKeys(reason);
		Thread.sleep(500);
		System.out.println("✅ Filled callout reason: " + reason);
	}

	/**
	 * Submit the Mark as Callout form
	 */
	public void submitMarkAsCallout() throws InterruptedException {
		elementUtils.waitForElementToBeClickable(btnSubmitMarkAsCallout, Constants.DEFAULT_WAIT).click();
		Thread.sleep(1000);
		System.out.println("✅ Submitted Mark as Callout form");
	}

	/**
	 * Get success message after marking shift as callout
	 * 
	 * @return Success message text
	 */
	public String getMarkAsCalloutSuccessMessage() {
		return elementUtils.waitForElementVisible(successMsgMarkAsCallout, Constants.DEFAULT_WAIT).getText();
	}

	// ========== SEND SHIFT METHODS ==========

	/**
	 * Click "Send Shift" option from context menu
	 */
	public void clickSendShiftFromContextMenu() throws InterruptedException {
		Thread.sleep(1000); // Wait for context menu to fully appear

		// Based on actual HTML inspection:
		// <li class="ant-dropdown-menu-item"><span
		// class="ant-dropdown-menu-title-content">Send Shift</span></li>
		By sendShiftLocator = By.xpath("//span[@class='ant-dropdown-menu-title-content' and text()='Send Shift']");

		try {
			WebElement sendShiftOption = elementUtils.waitForElementToBeClickable(sendShiftLocator,
					Constants.DEFAULT_WAIT);
			sendShiftOption.click();
			Thread.sleep(1000); // Wait for Send Shift modal to load
			System.out.println("✅ Clicked 'Send Shift' from context menu");
		} catch (Exception e) {
			System.out.println("❌ Failed to click 'Send Shift': " + e.getMessage());
			throw new RuntimeException("❌ Failed to click 'Send Shift' from context menu", e);
		}
	}

	/**
	 * Select multiple departments in the Send Shift modal
	 * 
	 * @param departments - List of department names (e.g., "Patrol", "Field",
	 *                    "Dispatch")
	 */
	public void selectDepartments(List<String> departments) throws InterruptedException {
		System.out.println("🔍 Selecting departments: " + departments);

		try {
			// Use the exact XPath to find the clickable dropdown selector
			By dropdownSelector = By
					.xpath("//input[@id='department']/ancestor::div[contains(@class,'ant-select-selector')]");
			WebElement dropdown = elementUtils.waitForElementVisible(dropdownSelector, 10);

			// Use JavaScript to click (more reliable for Ant Design components)
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView({block:'center'});", dropdown);
			Thread.sleep(300);
			js.executeScript("arguments[0].click();", dropdown);
			Thread.sleep(1000); // Wait for dropdown to open and cursor to appear
			System.out.println("✅ Opened department dropdown");

			// Select each department by typing its name
			Actions actions = new Actions(driver);
			for (String department : departments) {
				try {
					actions.sendKeys(department).perform(); // Type department name
					Thread.sleep(500);
					actions.sendKeys(Keys.ENTER).perform(); // Confirm selection
					Thread.sleep(500);
					System.out.println("✅ Selected department: " + department);
				} catch (Exception e) {
					System.out.println("⚠️ Failed to select department: " + department + " - " + e.getMessage());
				}
			}

			// Close dropdown by pressing Escape
			actions.sendKeys(Keys.ESCAPE).perform();
			Thread.sleep(500);
			System.out.println("✅ Closed department dropdown");

			// Click "Apply Filter" button
			By applyFilterButton = By.xpath("//button[normalize-space()='Apply Filter']");
			WebElement applyBtn = elementUtils.waitForElementToBeClickable(applyFilterButton, 10);
			applyBtn.click();
			Thread.sleep(2000); // Wait for filter to be applied and employee list to load
			System.out.println("✅ Clicked 'Apply Filter' button");

		} catch (Exception e) {
			System.out.println("⚠️ Failed to handle department dropdown: " + e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * Enable "Assign Shift Automatically" toggle in Send Shift modal
	 */
	public void enableAssignShiftAutomatically() throws InterruptedException {
		try {
			WebElement toggle = elementUtils.waitForElementToBeClickable(toggleAssignAutomatically,
					Constants.DEFAULT_WAIT);
			// Check if toggle is already enabled (aria-checked="true")
			String ariaChecked = toggle.getAttribute("aria-checked");
			if (!"true".equals(ariaChecked)) {
				toggle.click();
				Thread.sleep(500);
				System.out.println("✅ Enabled 'Assign Shift Automatically' toggle");
			} else {
				System.out.println("✅ 'Assign Shift Automatically' toggle already enabled");
			}
		} catch (Exception e) {
			System.out.println("⚠️ Failed to enable 'Assign Shift Automatically': " + e.getMessage());
			throw e;
		}
	}

	/**
	 * Select all employees in Send Shift modal by clicking the header checkbox
	 */
	public void selectAllEmployees() throws InterruptedException {
		try {
			// Click the "Select All" checkbox in the table header
			By selectAllCheckbox = By.xpath("//th//input[@type='checkbox']");
			WebElement checkbox = elementUtils.waitForElementToBeClickable(selectAllCheckbox, 10);
			checkbox.click();
			Thread.sleep(500);
			System.out.println("✅ Selected all employees");
		} catch (Exception e) {
			System.out.println("⚠️ Failed to select all employees: " + e.getMessage());
			throw e;
		}
	}

	/**
	 * Search and select employee in Send Shift modal
	 * 
	 * @param employeeId - Employee ID to search and select
	 */
	public void searchAndSelectEmployee(String employeeId) throws InterruptedException {
		try {
			// Wait for employee table to load after Apply Filter
			Thread.sleep(2000);

			// Search for the employee
			WebElement searchInput = elementUtils.waitForElementVisible(searchEmployeeInSendShift, 10);
			searchInput.click();
			Thread.sleep(300);

			// Clear field multiple times to ensure it's empty
			searchInput.clear();
			Thread.sleep(300);
			searchInput.sendKeys(Keys.CONTROL + "a");
			searchInput.sendKeys(Keys.DELETE);
			Thread.sleep(300);

			// Type employee ID character by character to ensure all characters are entered
			for (char c : employeeId.toCharArray()) {
				searchInput.sendKeys(String.valueOf(c));
				Thread.sleep(100); // Small delay between characters
			}

			// Backspace technique: backspace then type last character again to trigger
			// search
			Thread.sleep(300);
			searchInput.sendKeys(Keys.BACK_SPACE);
			Thread.sleep(300);
			searchInput.sendKeys(String.valueOf(employeeId.charAt(employeeId.length() - 1)));

			Thread.sleep(2000); // Wait for search results to filter
			System.out.println("🔍 Searched for employee: " + employeeId);

			// After search, only the target employee is visible, so click "Select all"
			// checkbox
			JavascriptExecutor js = (JavascriptExecutor) driver;

			// Try to find and click the checkbox using JavaScript
			// First try the exact XPath from user
			String script = "var checkbox = document.evaluate(\"//th[contains(@class,'ant-table-selection-column')]//input[@aria-label='Select all']\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue; "
					+
					"if (checkbox) { checkbox.click(); return true; } else { return false; }";
			Boolean clicked = (Boolean) js.executeScript(script);

			if (clicked) {
				System.out.println("✅ Selected employee using JavaScript: " + employeeId);
			} else {
				// If that didn't work, try finding any checkbox in the table header
				System.out.println("⚠️ First XPath didn't find checkbox, trying alternative...");
				String altScript = "var checkbox = document.querySelector('th.ant-table-selection-column input[type=\"checkbox\"]'); "
						+
						"if (checkbox) { checkbox.click(); return true; } else { return false; }";
				Boolean altClicked = (Boolean) js.executeScript(altScript);

				if (altClicked) {
					System.out.println("✅ Selected employee using alternative selector: " + employeeId);
				} else {
					throw new RuntimeException("Could not find Select all checkbox using any method");
				}
			}
			Thread.sleep(500);
		} catch (Exception e) {
			System.out.println("⚠️ Failed to select employee: " + employeeId + " - " + e.getMessage());
			throw e;
		}
	}

	/**
	 * Click "Send Shift" button in the modal
	 */
	public void clickSendShiftButton() throws InterruptedException {
		elementUtils.waitForElementToBeClickable(btnSendShift, Constants.DEFAULT_WAIT).click();
		Thread.sleep(1000); // Wait for action to complete
		System.out.println("✅ Clicked 'Send Shift' button");
	}

	/**
	 * Get success message after sending shift
	 * 
	 * @return Success message text
	 */
	public String getSendShiftSuccessMessage() {
		try {
			return elementUtils.waitForElementVisible(successMsgSendShift, Constants.DEFAULT_WAIT).getText();
		} catch (Exception e) {
			System.out.println("⚠️ Success message not found: " + e.getMessage());
			return null;
		}
	}

	/**
	 * Click History tab in Send Shift modal
	 */
	public void clickHistoryTab() throws InterruptedException {
		elementUtils.waitForElementToBeClickable(tabHistory, Constants.DEFAULT_WAIT).click();
		Thread.sleep(1000); // Wait for history to load
		System.out.println("✅ Clicked 'History' tab");
	}

	/**
	 * Verify employee status in History tab
	 * 
	 * @param employeeId - Employee ID to check
	 * @return Status text (e.g., "Pending", "Accepted", "Rejected")
	 */
	public String verifyEmployeeStatus(String employeeId) throws InterruptedException {
		try {
			// Find status cell for the employee
			By statusLocator = By.xpath(
					"//td[contains(text(),'" + employeeId
							+ "')]/following-sibling::td[contains(@class,'status') or position()=last()]");
			WebElement statusElement = elementUtils.waitForElementVisible(statusLocator, Constants.DEFAULT_WAIT);
			String status = statusElement.getText().trim();
			System.out.println("✅ Employee " + employeeId + " status: " + status);
			return status;
		} catch (Exception e) {
			System.out.println("⚠️ Failed to get employee status: " + e.getMessage());
			throw e;
		}
	}

	/**
	 * Click "Assign Shift" button in History tab
	 */
	public void clickAssignShiftInHistory() throws InterruptedException {
		elementUtils.waitForElementToBeClickable(btnAssignShiftInHistory, Constants.DEFAULT_WAIT).click();
		Thread.sleep(1000); // Wait for confirmation or next step
		System.out.println("✅ Clicked 'Assign Shift' button in History");
	}

	/**
	 * Click "Update Shift" button in modal
	 */
	public void clickUpdateShiftButton() throws InterruptedException {
		elementUtils.waitForElementToBeClickable(btnUpdateShiftInModal, Constants.DEFAULT_WAIT).click();
		Thread.sleep(1000); // Wait for action to complete
		System.out.println("✅ Clicked 'Update Shift' button");
	}

	/**
	 * Delete existing shift if it exists for the given time to prevent overlap
	 * errors
	 * 
	 * @param time       - Shift time (e.g., "01:00 - 02:30")
	 * @param employeeID - Employee ID or "Open" for open shifts
	 */
	public void deleteExistingShiftIfExists(String time, String employeeID) throws InterruptedException {
		try {
			System.out.println("🔍 Checking if shift exists: " + time + " for " + employeeID);
			WebElement shift = findShiftByDetails(time, employeeID);
			if (shift != null) {
				System.out.println("⚠️ Shift already exists, deleting it first...");
				deleteShift(time, employeeID);
				Thread.sleep(2000); // Wait for deletion to complete
				System.out.println("✅ Existing shift deleted successfully");
			}
		} catch (Exception e) {
			// Shift doesn't exist, which is fine
			System.out.println("✅ No existing shift found, safe to create new one");
		}
	}

	/**
	 * Delete existing open shift if it exists for the given time
	 * 
	 * @param time - Shift time (e.g., "01:00 - 02:30")
	 */
	public void deleteExistingOpenShiftIfExists(String time) throws InterruptedException {
		try {
			System.out.println("🔍 Checking if open shift exists: " + time);
			WebElement shift = findOpenShiftByDetails(time);
			if (shift != null) {
				System.out.println("⚠️ Open shift already exists, deleting it first...");
				// Right-click and delete
				Actions actions = new Actions(driver);
				actions.contextClick(shift).perform();
				Thread.sleep(500);

				// Click Delete from context menu
				By deleteOption = By
						.xpath("//span[@class='ant-dropdown-menu-title-content'][contains(text(),'Delete')]");
				elementUtils.waitForElementToBeClickable(deleteOption, Constants.DEFAULT_WAIT).click();
				Thread.sleep(500);

				// Confirm deletion
				By confirmDelete = By.xpath(
						"//button[contains(@class,'ant-btn-primary')]//span[contains(text(),'OK') or contains(text(),'Delete') or contains(text(),'Yes')]");
				try {
					elementUtils.waitForElementToBeClickable(confirmDelete, 5).click();
					Thread.sleep(2000);
					System.out.println("✅ Existing open shift deleted successfully");
				} catch (Exception e) {
					// No confirmation needed
					System.out.println("✅ Open shift deleted (no confirmation needed)");
				}
			}
		} catch (Exception e) {
			// Shift doesn't exist, which is fine
			System.out.println("✅ No existing open shift found, safe to create new one");
		}
	}
}
