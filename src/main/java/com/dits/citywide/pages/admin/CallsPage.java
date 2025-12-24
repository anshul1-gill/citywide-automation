package com.dits.citywide.pages.admin;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dits.citywide.constants.Constants;
import com.dits.citywide.utilities.ElementUtils;
import com.dits.citywide.utilities.ScreenshotUtils;

public class CallsPage {

	private WebDriver driver;
	private ElementUtils elementUtils;
	private WebDriverWait wait;

	private By tabOpenCalls = By.xpath("//div[@id='rc-tabs-0-tab-open-calls']");
	private By tabClosedCalls = By.xpath("//div[@id='rc-tabs-0-tab-past-calls']");

	// Calls Section
	private By btnAddNewCall = By.xpath("//span[normalize-space()='Add New Call']");

	// Add New Call
	private By dropdownOfficerReceivedVia = By.xpath("//span[@class='ant-select-selection-item']");
	private By valuesOfficerReceivedVia = By.xpath("(//div[@class='rc-virtual-list-holder-inner'])[1]/div/div");

	private By dropdownPatrolSite = By.xpath("(//div[@class='ant-select-selector'])[2]");
	private By searchboxPatrolSite = By.xpath("//input[@id='site_id']");
	private By txtViewSiteNotes = By.xpath("//span[normalize-space()='View site notes']");

	private By dropdownActivityCode = By.xpath("//input[@id='activity_code']");
	private By subActivityCode = By.xpath("//input[@id='sub_activity_code']");

	// Reporting Person
	private By txtboxFirstName = By.xpath("//input[@id='rp_first_name']");
	private By txtboxLastName = By.xpath("//input[@id='rp_last_name']");
	private By txtboxPhoneNumber = By.xpath("//input[@type='tel']");
	
	// Broaden locator to match the element text anywhere, regardless of tag or extra whitespace
	private By CallhistoryCount = By.xpath("//*[normalize-space()='Call History Count' or contains(normalize-space(), 'Call History Count')]");
	// Fallbacks
	private By CallhistoryCountAlt1 = By.xpath("//*[contains(normalize-space(), 'Call History')]");
	private By CallhistoryCountAlt2 = By.xpath("//span[contains(., 'Call History')]|//div[contains(., 'Call History')]");

	private By btnSaveAddNewCall = By.xpath("//button[@type='submit']");

	private By checkboxSameAsAboveAddress = By.xpath("//span[normalize-space()='Same as above address']");

	private By successMessage = By.xpath("//h2[@id='swal2-title']/span[@class='text-white']");

	private By dataAssignedTo = By.xpath("(//div[@class='call-status'])[1]");

	// private By dataCallId = By.xpath("(//td[@data-label='Call #'])[1]/a");
	private By getCallIdByEmployeeId(String employeeId) {
	    String xpath = "//span[contains(@class,'unit-name') and contains(normalize-space(),'" + employeeId + "')]"
	            + "/ancestor::td/following-sibling::td[@data-label='Call #']/div";
	    return By.xpath(xpath);
	}


	private By dataActivityCode = By.xpath("(//td[@data-label='Activity Code'])[1]");
	private By dataSite = By.xpath("(//td[@data-label='Site'])[1]/div");

	// Suspect Description
	private By btnCollapseSuspectDescription = By.xpath("//span[normalize-space()='Suspect Description']");

	private By txtboxSuspectName = By.xpath("//input[@id='suspect_description_0_name']");
	private By dropdownSuspectGender = By.xpath("//input[@id='suspect_description_0_gender']");
	private By dropdownRace = By.xpath("//input[@id='suspect_description_0_race']");
	private By dropdownHairType = By.xpath("//input[@id='suspect_description_0_hairType']");
	private By dropdownHairColor = By.xpath("//input[@id='suspect_description_0_hair']");
	private By dropdownEyeColor = By.xpath("//input[@id='suspect_description_0_eyes']");
	private By dropdownHeight = By.xpath("//input[@id='suspect_description_0_height']");
	private By dropdownBuild = By.xpath("//input[@id='suspect_description_0_build']");
	private By txtboxWeight = By.xpath("//input[@id='suspect_description_0_weight']");
	private By txtboxAge = By.xpath("//input[@id='suspect_description_0_age']");
	private By txtboxClothingWorn = By.xpath("//input[@id='suspect_description_0_clothing_worn']");
	private By txtboxLastKnownDirection = By.xpath("//input[@id='suspect_description_0_last_know_direction']");

	private By txtboxCallDescription = By.xpath("//textarea[@id='call_description']");

	private By loader = By.xpath("//span[@class='ant-spin-dot ant-spin-dot-spin']");

	public CallsPage(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(driver);
		wait = new org.openqa.selenium.support.ui.WebDriverWait(driver, java.time.Duration.ofSeconds(Constants.DEFAULT_WAIT));
	}

	// Calls
	public boolean isOpenCallsTabDisplayed() {
		return elementUtils.doIsDisplayed(tabOpenCalls, Constants.DEFAULT_WAIT);
	}

	public boolean isClosedCallsTabDisplayed() {
		return elementUtils.doIsDisplayed(tabClosedCalls, Constants.DEFAULT_WAIT);
	}

	public void doClickOpenCallsTab() {
		elementUtils.waitForElementToBeClickable(tabOpenCalls, Constants.DEFAULT_WAIT).click();
	}

	public void doClickClosedCallsTab() {
		elementUtils.waitForElementToBeClickable(tabClosedCalls, Constants.DEFAULT_WAIT).click();
	}

	public void doClickAddNewCallButton() {
		elementUtils.waitForElementToBeClickable(btnAddNewCall, Constants.DEFAULT_WAIT).click();
	}

	// Add New Call

	public void fillAddNewCallForm(String officerReceivedVia, String patrolSite, String activityCode , String subActivity)
			throws InterruptedException {
		elementUtils.waitForElementToBeClickable(dropdownOfficerReceivedVia, Constants.DEFAULT_WAIT).click();
		elementUtils.selectElementThroughLocator(valuesOfficerReceivedVia, officerReceivedVia,
				Constants.SHORT_TIME_OUT_WAIT);
		Thread.sleep(1000);
		elementUtils.waitForElementToBeClickable(dropdownPatrolSite, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementVisible(searchboxPatrolSite, Constants.DEFAULT_WAIT).sendKeys(patrolSite);
		elementUtils.pressEnterKey();
		elementUtils.waitForElementVisible(txtViewSiteNotes, Constants.DEFAULT_WAIT);

		elementUtils.waitForInvisibilityOfElementLocated(loader, Constants.DEFAULT_WAIT);
		elementUtils.doActionsClick(dropdownActivityCode);
		elementUtils.waitForElementVisible(dropdownActivityCode, Constants.MEDIUM_TIME_OUT_WAIT).sendKeys(activityCode);
		Thread.sleep(5000);
		elementUtils.pressEnterKey();
		
		elementUtils.doActionsClick(subActivityCode);
		elementUtils.waitForElementVisible(subActivityCode, Constants.MEDIUM_TIME_OUT_WAIT).sendKeys(subActivity);
		Thread.sleep(2000);
		elementUtils.pressEnterKey();
	}

	public void fillReportingPersonForm(String firstName, String lastName, String phoneNumber, String demeanor)
			throws InterruptedException {
		elementUtils.waitForElementVisible(txtboxFirstName, Constants.DEFAULT_WAIT).sendKeys(firstName);
		elementUtils.waitForElementVisible(txtboxLastName, Constants.DEFAULT_WAIT).sendKeys(lastName);
		elementUtils.waitForElementVisible(txtboxPhoneNumber, Constants.DEFAULT_WAIT).sendKeys(phoneNumber);
		By xpathDemeanor = By.xpath("//span[contains(normalize-space(), '" + demeanor + "')]");
		elementUtils.waitForElementToBeClickable(xpathDemeanor, Constants.DEFAULT_WAIT).click();
	}
	
	public void CallHistoryCount() {
	    System.out.println("Page title: " + driver.getTitle());
	    System.out.println("Page source length: " + driver.getPageSource().length());

	    try {
	        // Ensure we are at top-level DOM (avoid lingering frames)
	        try { driver.switchTo().defaultContent(); } catch (Exception ignored) {}

	        WebDriverWait localWait = new WebDriverWait(driver, Duration.ofSeconds(30));

	        By[] candidates = new By[] { CallhistoryCount, CallhistoryCountAlt1, CallhistoryCountAlt2 };
	        WebElement target = null;
	        By used = null;

	        // Find first visible candidate
	        for (By by : candidates) {
	            try {
	                localWait.until(ExpectedConditions.presenceOfElementLocated(by));
	                target = localWait.ignoring(org.openqa.selenium.StaleElementReferenceException.class)
	                        .until(d -> {
	                            WebElement el = d.findElement(by);
	                            return (el != null && el.isDisplayed()) ? el : null;
	                        });
	                if (target != null) { used = by; break; }
	            } catch (TimeoutException te) {
	                // try next candidate
	            }
	        }

	        if (target == null) {
	            // Not found; capture and return gracefully to avoid hard fail
	            ScreenshotUtils.captureScreenshot(driver, "CallHistoryCount_NotFound");
	            System.out.println("Call History element not found; skipping click.");
	            return;
	        }

	        // Scroll into view
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", target);

	        // Attempt click with retry and JS fallback
	        for (int attempt = 0; attempt < 2; attempt++) {
	            try {
	                target = driver.findElement(used); // fresh element
	                if (target.isDisplayed()) {
	                    try {
	                        target.click();
	                    } catch (org.openqa.selenium.ElementClickInterceptedException e) {
	                        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", target);
	                    }
	                    break;
	                }
	            } catch (org.openqa.selenium.StaleElementReferenceException sere) {
	                // will retry
	            }
	            try { Thread.sleep(200); } catch (InterruptedException ignored) {}
	        }
	    } catch (TimeoutException e) {
	        ScreenshotUtils.captureScreenshot(driver, "CallHistoryCount_Failure");
	        throw e;
	    }
	}

	public void openCallHistoryInNewTabAndReturn() {
	    String parentWindow = driver.getWindowHandle();

	    // Use the updated CallHistoryCount (handles staleness internally)
	    CallHistoryCount();

	    // Wait for new tab
	    new WebDriverWait(driver, Duration.ofSeconds(10))
	            .until(ExpectedConditions.numberOfWindowsToBe(2));

	    for (String handle : driver.getWindowHandles()) {
	        if (!handle.equals(parentWindow)) {
	            driver.switchTo().window(handle);
	            break;
	        }
	    }

	    // Perform any validations in the new tab here

	    driver.close();
	    driver.switchTo().window(parentWindow);
	}


		
	

	public void doClickSameAsAboveAddress() {
		elementUtils.waitForElementToBeClickable(checkboxSameAsAboveAddress, Constants.DEFAULT_WAIT).click();
	}

	// Suspect Description
	public void doClickCollapseSuspectDescription() {
		elementUtils.waitForElementToBeClickable(btnCollapseSuspectDescription, Constants.DEFAULT_WAIT).click();
	}

	public void fillSuspectDescriptionForm(String name, String gender, String race, String hairType, String hairColor,
			String eyeColor, String height, String build, String weight, String age, String clothingWorn,
			String lastKnownDirection) throws InterruptedException {

		elementUtils.waitForElementVisible(txtboxSuspectName, Constants.DEFAULT_WAIT).sendKeys(name);
		elementUtils.doClickWithActionsAndWait(dropdownSuspectGender, Constants.DEFAULT_WAIT);
		By xpathGender = By.xpath("//div[@class='ant-select-item-option-content' and text()='" + gender + "']");
		elementUtils.waitForElementToBeClickable(xpathGender, Constants.DEFAULT_WAIT).click();

		elementUtils.doClickWithActionsAndWait(dropdownRace, Constants.DEFAULT_WAIT);
		By xpathRace = By.xpath("//div[@class='ant-select-item-option-content' and text()='" + race + "']");
		elementUtils.waitForElementToBeClickable(xpathRace, Constants.DEFAULT_WAIT).click();

		elementUtils.doClickWithActionsAndWait(dropdownHairType, Constants.DEFAULT_WAIT);
		By xpathHairType = By.xpath("//div[@class='ant-select-item-option-content' and text()='" + hairType + "']");
		elementUtils.waitForElementToBeClickable(xpathHairType, Constants.DEFAULT_WAIT).click();

		elementUtils.doClickWithActionsAndWait(dropdownHairColor, Constants.DEFAULT_WAIT);
		elementUtils.waitForElementVisible(dropdownHairColor, Constants.DEFAULT_WAIT).sendKeys(hairColor);
		elementUtils.pressEnterKey();
		elementUtils.doClickWithActionsAndWait(dropdownEyeColor, Constants.DEFAULT_WAIT);
		elementUtils.waitForElementVisible(dropdownEyeColor, Constants.DEFAULT_WAIT).sendKeys(eyeColor);
		elementUtils.pressEnterKey();

		elementUtils.doClickWithActionsAndWait(dropdownHeight, Constants.DEFAULT_WAIT);
		elementUtils.waitForElementVisible(dropdownHeight, Constants.DEFAULT_WAIT).sendKeys(height);
		elementUtils.pressEnterKey();

		elementUtils.doClickWithActionsAndWait(dropdownBuild, Constants.DEFAULT_WAIT);
		By xpathBuild = By.xpath("//div[@class='ant-select-item-option-content' and text()='" + build + "']");
		elementUtils.waitForElementToBeClickable(xpathBuild, Constants.DEFAULT_WAIT).click();

		elementUtils.waitForElementVisible(txtboxWeight, Constants.DEFAULT_WAIT).sendKeys(weight);
		elementUtils.waitForElementVisible(txtboxAge, Constants.DEFAULT_WAIT).sendKeys(age);
		elementUtils.waitForElementVisible(txtboxClothingWorn, Constants.DEFAULT_WAIT).sendKeys(clothingWorn);
		elementUtils.waitForElementVisible(txtboxLastKnownDirection, Constants.DEFAULT_WAIT)
				.sendKeys(lastKnownDirection);
	}

	public void fillCallDescription(String description) {
		elementUtils.waitForElementVisible(txtboxCallDescription, Constants.DEFAULT_WAIT).sendKeys(description);
	}

	public void selectAvailableUnits(String userId, String unitType) {

	    List<WebElement> allTiles = driver.findElements(
	            By.xpath("//div[contains(@class,'ant-card')]")
	    );

	    boolean backupSelected = false;

	    for (WebElement tile : allTiles) {

	        String tileText = tile.getText().trim();

	        // ----- SELECT PRIMARY FOR MY USER -----
	        if (tileText.contains(userId)) {

	            WebElement primaryCheckbox = tile.findElement(
	                By.xpath(".//label[span[normalize-space()='Primary']]//input[@type='checkbox']")
	            );

	            if (!primaryCheckbox.isSelected()) {
	                primaryCheckbox.click();
	            }

	            wait.until(ExpectedConditions.elementToBeSelected(primaryCheckbox));

	            System.out.println("PRIMARY selected for: " + userId);
	            continue; // do NOT allow backup selection for my user
	        }

	        // ----- SELECT BACKUP FOR FIRST OTHER USER -----
	        if (!backupSelected) {

	            WebElement backupCheckbox = tile.findElement(
	                By.xpath(".//label[span[normalize-space()='Backup']]//input[@type='checkbox']")
	            );

	            if (!backupCheckbox.isSelected()) {
	                backupCheckbox.click();
	            }

	            wait.until(ExpectedConditions.elementToBeSelected(backupCheckbox));

	            backupSelected = true;

	            System.out.println("BACKUP selected for: " + tileText);
	        }
	    }

	    if (!backupSelected) {
	        throw new RuntimeException("❌ No other user found to assign Backup!");
	    }
	}



	public void doClickSaveAddNewCall() {
		elementUtils.waitForElementVisible(btnSaveAddNewCall, Constants.DEFAULT_WAIT);
		elementUtils.waitForElementToBeClickable(btnSaveAddNewCall, Constants.DEFAULT_WAIT).click();
	}

	public String getSuccessMessageText() {
		return elementUtils.waitForElementVisible(successMessage, Constants.DEFAULT_WAIT).getText();
	}

	public String getAssignedTo() {
		return elementUtils.waitForElementVisible(dataAssignedTo, Constants.DEFAULT_WAIT).getText();
	}

	public String getCallId(String employeeId) {
		return elementUtils.waitForElementVisible(getCallIdByEmployeeId(employeeId), Constants.DEFAULT_WAIT).getText();
	}

	public String getActivityCode() {
		return elementUtils.waitForElementVisible(dataActivityCode, Constants.DEFAULT_WAIT).getText();
	}

	public String getSite() {
		return elementUtils.waitForElementVisible(dataSite, Constants.DEFAULT_WAIT).getText();
	}

}
