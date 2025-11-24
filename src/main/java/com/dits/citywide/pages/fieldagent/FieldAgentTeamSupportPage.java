package com.dits.citywide.pages.fieldagent;

import java.util.List;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;

import com.dits.citywide.constants.Constants;
import com.dits.citywide.utilities.ElementUtils;

public class FieldAgentTeamSupportPage {

	private WebDriver driver;
	private ElementUtils elementUtils;

	private By btnAddnewRequest = By.xpath("//button[@type='button']/span[text()='Add New Request']");
	private By dropdownboxSite = By.xpath("//input[@id='request_site']");
	private By dropdownboxSubject = By.xpath("//input[@id='form_id']");
	private By dropdownAssignedto = By.xpath("//div[@class='ant-select-selection-overflow']");

	private By getSubjectDiv(String subject) {
	    return By.xpath("//div[contains(@class,'ant-select-item-option-content') and normalize-space()='" + subject + "']");
	}

	private By txtboxMessage = By.xpath("//textarea[@id='request_message_text']");
	private By txtboxexplain = By.xpath("//input[@placeholder='Explain the incidence ']");
	private By txtboxbage = By.xpath("//input[@id='text_input_3F179234-6D87-4EEF-A4CF-A09BD76598F0']");
	private By datetimepicker = By.xpath("//input[@id='date_picker_3928A8F7-029B-4F73-BDC1-29BFDF7F93C2']");
	private By btnSave = By.xpath("//button[normalize-space()='Save']");

	public FieldAgentTeamSupportPage(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(driver);
	}

	public void clickOnAddNewRequestButton() {
		elementUtils.waitForElementToBeClickable(btnAddnewRequest, Constants.DEFAULT_WAIT).click();
	}

	public void fillOutAndSubmitAbuseRequestForm(String site, String subject, String message)
			throws InterruptedException {
		elementUtils.waitForElementToBeClickable(dropdownboxSite, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementToBeClickable(dropdownboxSite, Constants.DEFAULT_WAIT).sendKeys(site);
		Thread.sleep(2000);
		elementUtils.pressEnterKey();
		elementUtils.waitForElementToBeClickable(dropdownboxSubject, Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementToBeClickable(getSubjectDiv(subject), Constants.DEFAULT_WAIT).click();
		elementUtils.waitForElementVisible(txtboxMessage, Constants.DEFAULT_WAIT).sendKeys(message);
	}

	public void fillAbuseRequestForm(String explain, String bage, String date) throws InterruptedException {
		elementUtils.waitForElementVisible(txtboxexplain, Constants.DEFAULT_WAIT).sendKeys(explain);
		elementUtils.waitForElementVisible(txtboxbage, Constants.DEFAULT_WAIT).sendKeys(bage);
		elementUtils.waitForElementVisible(datetimepicker, Constants.DEFAULT_WAIT).sendKeys(date);
	}

	private WebElement safeFind(By locator, int seconds) {
		try {
			return new WebDriverWait(driver, Duration.ofSeconds(seconds))
					.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (Exception e) {
			return null;
		}
	}

	private boolean openAntSelect(WebElement selectRoot, int timeoutSeconds) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
		WebElement selector;
		try {
			selector = selectRoot.findElement(By.cssSelector(".ant-select-selector"));
		} catch (Exception e) {
			selector = selectRoot; // fallback
		}

		// already open?
		if (selectRoot.getAttribute("class").contains("ant-select-open")) return true;

		// attempt sequences
		for (int i = 0; i < 5; i++) {
			try { selector.click(); } catch (Exception ignore) {}
			if (selectRoot.getAttribute("class").contains("ant-select-open")) return true;
			try { js.executeScript("arguments[0].click();", selector); } catch (Exception ignore) {}
			if (selectRoot.getAttribute("class").contains("ant-select-open")) return true;
			try { new Actions(driver).moveToElement(selector).click().perform(); } catch (Exception ignore) {}
			if (selectRoot.getAttribute("class").contains("ant-select-open")) return true;
			try { new Actions(driver).moveToElement(selector).sendKeys(Keys.SPACE).perform(); } catch (Exception ignore) {}
			if (selectRoot.getAttribute("class").contains("ant-select-open")) return true;
			try { new Actions(driver).moveToElement(selector).sendKeys(Keys.ARROW_DOWN).perform(); } catch (Exception ignore) {}
			if (selectRoot.getAttribute("class").contains("ant-select-open")) return true;
			try { Thread.sleep(150); } catch (InterruptedException ie) { Thread.currentThread().interrupt(); }
		}

		// final wait for dropdown presence
		try {
			wait.until(d -> d.findElements(By.cssSelector(".ant-select-dropdown"))
					.stream().anyMatch(WebElement::isDisplayed));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void selectAssignedTo(String assignedTo) throws InterruptedException {
		String target = assignedTo.trim();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Multiple locator fallbacks for select root
		By[] rootLocators = new By[] {
			By.xpath("(//label[@title='Assigned To']/following::div[contains(@class,'ant-select')])[1]"),
			By.xpath("(//label[contains(.,'Assigned To')]/ancestor::*[contains(@class,'ant-form-item')])[1]//div[contains(@class,'ant-select') and contains(@class,'ant-select-single')]") ,
			By.xpath("//div[contains(@class,'ant-form-item')][.//label[contains(normalize-space(),'Assigned To')]]//div[contains(@class,'ant-select')]"),
			By.cssSelector("div.ant-select.ant-select-single:not(.ant-select-disabled)")
		};

		WebElement selectRoot = null;
		for (By rl : rootLocators) {
			selectRoot = safeFind(rl, 5);
			if (selectRoot != null) break;
		}

		if (selectRoot == null) {
			System.out.println("[WARN] Could not locate Assigned To select root.");
			return;
		}

		// ensure in view
		try { js.executeScript("arguments[0].scrollIntoView({block:'center'});", selectRoot); } catch (Exception ignore) {}

		boolean opened = openAntSelect(selectRoot, 5);
		if (!opened) {
			System.out.println("[WARN] Failed to open Assigned To select.");
			return;
		}

		// Wait for any visible dropdown
		By dropdownAny = By.cssSelector(".ant-select-dropdown");
		WebElement dropdown = null;
		long dropdownDeadline = System.currentTimeMillis() + 8000;
		while (System.currentTimeMillis() < dropdownDeadline) {
			List<WebElement> panels = driver.findElements(dropdownAny);
			dropdown = panels.stream().filter(WebElement::isDisplayed).findFirst().orElse(null);
			if (dropdown != null) break;
			Thread.sleep(150);
		}
		if (dropdown == null) {
			System.out.println("[WARN] No visible dropdown for Assigned To.");
			return;
		}

		By exactOption = By.xpath("//div[contains(@class,'ant-select-item-option-content') and normalize-space()='" + target + "']");
		By partialOption = By.xpath("//div[contains(@class,'ant-select-item-option-content')][contains(normalize-space(), '" + target.replace("'","\"") + "')]");

		// Discover scroll container
		WebElement scrollContainer;
		try { scrollContainer = dropdown.findElement(By.cssSelector(".rc-virtual-list-holder")); }
		catch (Exception e) { scrollContainer = dropdown; }

		// Keyboard assisted initial scroll to populate list
		for (int k = 0; k < 5; k++) {
			try { new Actions(driver).sendKeys(Keys.ARROW_DOWN).perform(); Thread.sleep(80); } catch (Exception ignore) {}
		}

		// Progressive scrolling
		int maxScroll = 100; // higher to guarantee bottom
		long lastTop = -1;
		for (int i = 0; i < maxScroll; i++) {
			// Try locate option
			List<WebElement> exacts = driver.findElements(exactOption);
			if (!exacts.isEmpty()) { clickOption(wait, js, exacts.get(0)); return; }
			List<WebElement> partials = driver.findElements(partialOption);
			if (!partials.isEmpty()) { clickOption(wait, js, partials.get(0)); return; }

			// Scroll metrics
			Object topObj = js.executeScript("return arguments[0].scrollTop;", scrollContainer);
			long top = topObj instanceof Long ? (Long) topObj : ((Number) topObj).longValue();
			Object hObj = js.executeScript("return arguments[0].scrollHeight;", scrollContainer);
			long height = hObj instanceof Long ? (Long) hObj : ((Number) hObj).longValue();
			Object chObj = js.executeScript("return arguments[0].clientHeight;", scrollContainer);
			long cHeight = chObj instanceof Long ? (Long) chObj : ((Number) chObj).longValue();

			if (top + cHeight >= height || top == lastTop) break;
			js.executeScript("arguments[0].scrollTop = Math.min(arguments[0].scrollTop + arguments[0].clientHeight, arguments[0].scrollHeight);", scrollContainer);
			lastTop = top;
			Thread.sleep(90);
		}

		// Fallback filter
		try {
			WebElement filter = dropdown.findElement(By.xpath(".//input"));
			filter.clear();
			filter.sendKeys(target);
			WebElement filtered = wait.until(ExpectedConditions.elementToBeClickable(exactOption));
			clickOption(wait, js, filtered);
			return;
		} catch (Exception e) {
			System.out.println("[WARN] Assigned To option not found after exhaustive scroll: " + target);
		}
	}

	private void clickOption(WebDriverWait wait, JavascriptExecutor js, WebElement option) {
		try {
			js.executeScript("arguments[0].scrollIntoView({block:'center'});", option);
			wait.until(ExpectedConditions.elementToBeClickable(option)).click();
		} catch (Exception e) {
			try { js.executeScript("arguments[0].click();", option); } catch (Exception ignored) {}
		}
	}

	public void clickOnSaveButton() throws InterruptedException {
		elementUtils.waitForElementToBeClickable(btnSave, Constants.DEFAULT_WAIT).click();
		System.out.println("Save button clicked.");
		Thread.sleep(8000);
	}

}