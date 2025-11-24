package com.dits.citywide.utilities;

import java.io.File;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dits.citywide.constants.Constants;

public class ElementUtils {

	private WebDriver driver;

	public ElementUtils(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getElement(By by) {
		WebElement element = driver.findElement(by);
		return element;
	}

	public List<WebElement> getElements(By by) {
		return driver.findElements(by);
	}

	public void waitForElementToBeVisibleAndEnabled(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.and(ExpectedConditions.visibilityOfElementLocated(locator),
				ExpectedConditions.elementToBeClickable(locator)));
	}

	public void uploadFile(By fileUploadLocator, String relativeFilePath) {
		try {
			WebElement fileInput = driver.findElement(fileUploadLocator);
			String absolutePath = new File(relativeFilePath).getAbsolutePath();
			System.out.println("Uploading file from path: " + absolutePath);
			fileInput.sendKeys(absolutePath);
		} catch (Exception e) {
			System.err.println("File upload failed: " + e.getMessage());
			throw e;
		}
	}

	// ----------------- Click on Button -------------------------
	public void doClick(By by) {
		getElement(by).click();
	}

	// ------------------------- Send values in TextBox ----------------------------
	public void doSendKeys(By by, String value) {
		getElement(by).sendKeys(value);
	}

	public void doSendKeysWithClear(By by, String value) {
		WebElement element = getElement(by);
		element.clear();
		element.sendKeys(value);
	}

	// ---------------------------Element Enabled-------------------------
	public boolean doIsEnabled(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isEnabled();
	}

	// --------------------------- Element Displayed -----------------------------
//	public boolean doIsDisplayed(By locator, int timeOut) {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
//		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
//	}
	public boolean doIsDisplayed(By locator, int timeOut) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
			return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
		} catch (TimeoutException | NoSuchElementException e) {
			return false;
		}
	}

	// ---------------------------Element Selected----------------------
	public boolean doIsSelected(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isSelected();
	}

	//
	public boolean doIsClickable(By locator, long timeout) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
			wait.until(ExpectedConditions.elementToBeClickable(locator));
			return true;
		} catch (TimeoutException e) {
			return false;
		}
	}

	// ---------------- Select values from dropdown --------------------
	public void doSelectByIndex(By by, int index) {
		Select select = new Select(getElement(by));
		select.selectByIndex(index);
	}

	public void doSelectByValue(By by, String value) {
		Select select = new Select(getElement(by));
		select.selectByValue(value);
	}

	public void doSelectBy(By by, String visibleText) {
		Select select = new Select(getElement(by));
		select.selectByVisibleText(visibleText);
	}

	// ---------- Get Text ------------------------------

	public String getTextWithoutWait(By by) {
		return getElement(by).getText();
	}

	public String getText(By by, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(by)).getText();
	}

	// ---------- Get Attribute ------------------------------

	public String getAttribute(By by, String attributeName) {
		return getElement(by).getAttribute(attributeName);
	}

	// ---------------- Visibility Of Element ---------------------------

	public WebElement waitForElementVisible(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public boolean isElementVisible(By locator, int timeoutInSeconds) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
			return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)) != null;
		} catch (TimeoutException | NoSuchElementException e) {
			return false;
		}
	}

	// ---------------- Visibility Of All Element ---------------------------

	public List<WebElement> waitsForElementsVisible(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	public void waitForElementToBeVisible(By locator, int timeout) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}


	public WebElement waitElementToBeClickableThroughElement(WebElement element, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	// -------------------------- PresenceOfElementLocated ---------------------

	public WebElement waitForPresenceOfElementLocated(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public Boolean waitForStalenessOf(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.stalenessOf(getElement(locator)));
	}

	// -------------------- Actions Class -------------------------
//	public void doActionsSendKeys(By by, String value) {
//		Actions action = new Actions(driver);
//		action.sendKeys(getElement(by), value).perform();
//	}

	public void doActionsSendKeys(By by, String value) {
		if (value == null) {
			throw new IllegalArgumentException("Cannot send null value using sendKeys.");
		}

		WebElement element = getElement(by);

		Actions action = new Actions(driver);
		action.moveToElement(element).click().sendKeys(value).perform();
	}
	
	public void doSendKeysAction(By by, String value) {
	    if (value == null) {
	        throw new IllegalArgumentException("Cannot send null value using sendKeys.");
	    }

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    
	    // Wait until element is visible and enabled (interactable)
	    WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	    wait.until(ExpectedConditions.elementToBeClickable(element));
	    
	    // Clear the existing text (optional)
	    element.clear();
	    
	    // Send the provided text
	    element.sendKeys(value);
	}


	public void doActionsClick(By by) {
		Actions action = new Actions(driver);
		action.click(getElement(by)).build().perform();
	}

	public void doClickWithActionsAndWait(By by, int timeOut) {
		WebElement element = waitForElementToBeClickable(by, timeOut);
		Actions action = new Actions(driver);
		action.click(element).perform();
	}


	public void moveToElementWithActions(By by, int timeOut) {
		WebElement element = waitForElementVisible(by, timeOut);
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}

	public void doClickWithActions(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).click(element).build().perform();
	}

	public void doScollWithActions(WebElement element) {
		Actions action = new Actions(driver);
		action.scrollToElement(element).perform();

	}

	public void doScollWithActionsThroughBy(By by) {
		Actions action = new Actions(driver);
		action.scrollToElement(getElement(by)).perform();

	}

	// WIndow Handling

	public void switchToNewTab(int timeOut) {
		String originalWindow = driver.getWindowHandle();

		// Wait until a new window/tab is opened
		new WebDriverWait(driver, Duration.ofSeconds(timeOut)).until(driver -> driver.getWindowHandles().size() > 1);

		// Switch to new window/tab
		for (String windowHandle : driver.getWindowHandles()) {
			if (!windowHandle.equals(originalWindow)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}
	}

	public void switchToWindow(String windowHandle) {
		driver.switchTo().window(windowHandle);
	}

	public String getCurrentWindowHandle() {
		return driver.getWindowHandle();
	}

	// --------------- Element To Be Clickable ---------------
	public WebElement waitForElementToBeClickable(By by, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.elementToBeClickable(by));
	}

	public Boolean waitForInvisibilityOfElementLocated(By by, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
	}

	public void selectElementThroughLocator(By locator, String fieldName, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));

		boolean elementClicked = false;
		int attempts = 0;

		while (!elementClicked && attempts < 3) {
			try {
				// Wait for all elements matching the locator to be visible
				List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
				for (WebElement e : elements) {
					String eleText = e.getText();
					// System.out.println("Dropdown option: " + eleText);
					if (eleText.contains(fieldName)) {
						e.click();
						elementClicked = true;
						break;
					}
				}
			} catch (StaleElementReferenceException e) {
				System.out.println("StaleElementReferenceException caught. Retrying...");
				attempts++;
			}
		}
		if (!elementClicked) {
			throw new RuntimeException("Failed to click the element after multiple attempts.");
		}
	}

	public List<WebElement> waitForVisibilityOfAllElements(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}

	public void selectElementThroughLocatorWithExactMatch(By locator, String fieldName, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));

		boolean elementClicked = false;
		int attempts = 0;

		while (!elementClicked && attempts < 3) {
			try {
				// Wait for all elements matching the locator to be visible
				List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));

				for (WebElement e : elements) {
					String eleText = e.getText();

					if (eleText.equalsIgnoreCase(fieldName)) {
						e.click();
						elementClicked = true;
						break;
					}
				}
			} catch (StaleElementReferenceException e) {
				System.out.println("StaleElementReferenceException caught. Retrying...");
				attempts++;
			}
		}
		if (!elementClicked) {
			throw new RuntimeException("Failed to click the element after multiple attempts.");
		}
	}

	public void selectElementThroughLocatorWithRetry(By locator, String fieldName, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));

		boolean elementClicked = false;
		int attempts = 0;

		while (!elementClicked && attempts < 3) {
			try {
				// First wait for presence
				wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));

				// Then wait for visibility
				List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));

				for (WebElement e : elements) {
					String eleText = e.getText().trim();
					System.out.println("Dropdown option: " + eleText);
					if (eleText.equalsIgnoreCase(fieldName.trim())) {
						try {
							e.click(); // Try normal click first
						} catch (Exception clickException) {
							System.out.println("Normal click failed, trying JavaScript click...");
							JavascriptExecutor js = (JavascriptExecutor) driver;
							js.executeScript("arguments[0].scrollIntoView(true);", e); // scroll into view
							js.executeScript("arguments[0].click();", e); // js click
						}
						elementClicked = true;
						break;
					}
				}
			} catch (StaleElementReferenceException e) {
				System.out.println("StaleElementReferenceException caught. Retrying...");
				attempts++;
			} catch (TimeoutException e) {
				System.out.println("TimeoutException caught. Retrying...");
				attempts++;
			}
		}

		if (!elementClicked) {
			throw new RuntimeException("Failed to click the element after multiple attempts for: " + fieldName);
		}
	}

	public void doClickWeBElement(WebElement element) {
		try {
			element.click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Click intercepted, using JavaScript executor.");
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		}
	}

	public void clickByLocator(By locator) {
		try {
			WebElement element = driver.findElement(locator);
			element.click();
		} catch (ElementClickInterceptedException e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(locator));
		}
	}

	public void clickWithRetry(By locator, int maxAttempts, int waitTimeInSeconds) throws InterruptedException {
		for (int attempt = 0; attempt < maxAttempts; attempt++) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTimeInSeconds));
				WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
				element.click();
				return; // Exit if click is successful
			} catch (ElementClickInterceptedException | StaleElementReferenceException e) {
				if (attempt == maxAttempts - 1)
					throw e;
				Thread.sleep(waitTimeInSeconds * 1000);
			}
		}
	}

	public void clickElementWithScroll(By locator, int waitTimeInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTimeInSeconds));

		// Wait for the element to be present and scroll into view
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

		try {
			// Attempt a standard click
			wait.until(ExpectedConditions.elementToBeClickable(element)).click();
		} catch (ElementClickInterceptedException e) {
			// Fallback to JavaScript click if the standard click is intercepted
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		}
	}

	public void safeClick(By locator) {
	    int retries = 3;
	    while (retries > 0) {
	        try {
	            WebElement element = new WebDriverWait(driver, Duration.ofSeconds(5))
	                    .until(ExpectedConditions.elementToBeClickable(locator));
	            element.click();
	            break; // success
	        } catch (StaleElementReferenceException e) {
	            retries--;
	            System.out.println("Retry due to: " + e.getClass().getSimpleName());
	        } catch (WebDriverException e) { // catches click intercepted & not interactable
	            System.out.println("Click failed, trying JS click");
	            try {
	                WebElement element = driver.findElement(locator);
	                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	                break; // success with JS click
	            } catch (Exception jsEx) {
	                retries--;
	            }
	        }

	        try { Thread.sleep(500); } catch (InterruptedException ie) { Thread.currentThread().interrupt(); }
	    }
	}



	public void retryClickWithJS(By locator, int maxRetries) {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		for (int attempt = 0; attempt < maxRetries; attempt++) {
			try {
				WebElement element = new WebDriverWait(driver, Duration.ofSeconds(2))
						.until(ExpectedConditions.presenceOfElementLocated(locator));
				js.executeScript("arguments[0].click();", element);
				return;
			} catch (Exception e) {
				System.out.println("Retrying click attempt #" + (attempt + 1));
			}
		}
		throw new RuntimeException("Unable to click on element after " + maxRetries + " attempts");
	}

	public void waitForPageLoad(int waitTimeInSeconds) {
		new WebDriverWait(driver, Duration.ofSeconds(waitTimeInSeconds))
				.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState")
						.equals("complete"));
	}

	public void jsClick(By locator) {
		WebElement element = driver.findElement(locator);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", element);
	}

	public void jsClickWithWait(By locator, int timeoutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}

	public void safariClick(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));

		// Scroll to element
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

		// Safari sometimes needs a slight pause
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}

		// Force focus, then click
		((JavascriptExecutor) driver).executeScript("arguments[0].focus(); arguments[0].click();", element);
	}

	public void doubleClickElement(By locator) {
		WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(locator));
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}

	public void selectElementFromVirtualDropdown(By optionLocator, String visibleText, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		boolean elementClicked = false;
		int attempts = 0;

		while (!elementClicked && attempts < 3) {
			try {
				List<WebElement> options = wait
						.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(optionLocator));
				for (WebElement option : options) {
					String text = option.getText().trim();
					if (text.equalsIgnoreCase(visibleText)) {
						js.executeScript("arguments[0].scrollIntoView(true);", option);
						option.click();
						elementClicked = true;
						break;
					}
				}

				// Optional: Scroll in case value is not visible initially
				if (!elementClicked) {
					WebElement scrollContainer = driver.findElement(By.className("rc-virtual-list"));
					js.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight", scrollContainer);
				}

			} catch (StaleElementReferenceException e) {
				System.out.println("StaleElementReferenceException caught. Retrying...");
				attempts++;
			}
		}

		if (!elementClicked) {
			throw new RuntimeException("Failed to select option: " + visibleText);
		}
	}

	// Get Option By Text
	public By getOptionByText(String text) {
		return By.xpath("//div[contains(text(),'" + text + "')]");
	}

	public void doScrollAndClickWithWait(By by) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));

		Actions action = new Actions(driver);
		action.scrollToElement(element).click(element).perform();
	}

	public void scrollAndClickUsingJS(By by) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
		element.click();
	}

	public void pressEscapeKey() {
		try {
			Actions actions = new Actions(driver);
			actions.sendKeys(Keys.ESCAPE).perform();
		} catch (Exception e) {
			System.out.println("Error while pressing Escape key: " + e.getMessage());
		}
	}

	public void pressEnterKey() {
		try {
			Actions actions = new Actions(driver);
			actions.sendKeys(Keys.ENTER).perform();
		} catch (Exception e) {
			System.out.println("Error while pressing Escape key: " + e.getMessage());
		}
	}

	public void pressDeleteKey() {
		try {
			Actions actions = new Actions(driver);
			actions.sendKeys(Keys.DELETE).perform();
		} catch (Exception e) {
			System.out.println("Error while pressing Delete key: " + e.getMessage());
		}
	}

	public void pressBrowserBack() {
		try {
			driver.navigate().back();
		} catch (Exception e) {
			System.out.println("Error while navigating back: " + e.getMessage());
		}
	}

	public void clearTextBoxWithKeys(By locator) {
		try {
			WebElement element = driver.findElement(locator);
			element.click(); // Focus the field

			// Dynamically select the correct key for CMD (Mac) or CTRL (Windows/Linux)
			Keys selectAllKey = System.getProperty("os.name").toLowerCase().contains("mac") ? Keys.COMMAND
					: Keys.CONTROL;

			// Perform Select All and Delete
			element.sendKeys(Keys.chord(selectAllKey, "a")); // CMD/CTRL + A
			element.sendKeys(Keys.DELETE); // Delete selected text
		} catch (Exception e) {
			System.out.println("Error while clearing text box with keys: " + e.getMessage());
		}
	}

	public void clearTextBoxWithActions(By locator) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));

			element.click(); // focus the field

			// Detect OS and choose appropriate key
			Keys selectAllKey = System.getProperty("os.name").toLowerCase().contains("mac") ? Keys.COMMAND
					: Keys.CONTROL;

			// Use Actions to clear text
			Actions actions = new Actions(driver);
			actions.keyDown(selectAllKey).sendKeys("a").keyUp(selectAllKey).sendKeys(Keys.DELETE).build().perform();
		} catch (Exception e) {
			System.out.println("Error while clearing text box using Actions: " + e.getMessage());
		}
	}
	public void scrollInsideDropdownToText(By dropdownValuesLocator, String visibleText) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	    // Wait for dropdown container (first visible element)
	    WebElement container = wait.until(ExpectedConditions.visibilityOfElementLocated(dropdownValuesLocator));

	    JavascriptExecutor js = (JavascriptExecutor) driver;

	    boolean found = false;
	    int maxScrolls = 20;

	    for (int i = 0; i < maxScrolls; i++) {

	        List<WebElement> options = driver.findElements(dropdownValuesLocator);

	        for (WebElement option : options) {
	            String text = option.getText().trim();

	            if (text.equalsIgnoreCase(visibleText)) {
	                js.executeScript("arguments[0].scrollIntoView(true);", option);
	                wait.until(ExpectedConditions.elementToBeClickable(option)).click();
	                found = true;
	                break;
	            }
	        }

	        if (found) break;

	        // Scroll dropdown container if item not found yet
	        js.executeScript("arguments[0].scrollTop += 80;", container);

	        try {
	            Thread.sleep(250); // allow UI to update
	        } catch (InterruptedException e) {
	            Thread.currentThread().interrupt();
	        }
	    }

	    if (!found) {
	        throw new RuntimeException("Option '" + visibleText + "' not found in dropdown after scrolling.");
	    }
	}


	public void scrollAndClick(By locator, int timeout) {
		WebElement element = waitForElementVisible(locator, timeout);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		new Actions(driver).moveToElement(element).pause(Duration.ofMillis(500)).click().perform();
	}

	public void moveToElementAndClick(By locator, int timeoutInSeconds) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

			// Scroll into view using JS (especially important for virtualized elements)
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(300); // Optional small pause

			// Move and click using Actions
			Actions actions = new Actions(driver);
			actions.moveToElement(element).pause(Duration.ofMillis(300)).click().perform();
		} catch (Exception e) {
			System.out.println("Failed to move and click on element located by: " + locator);
			e.printStackTrace();
		}
	}

	public void sendKeysUsingJavaScript(By locator, String value, int timeout) {
		WebElement element = waitForElementVisible(locator, timeout);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Clear any existing value
		js.executeScript("arguments[0].value = '';", element);

		// Set new value
		js.executeScript("arguments[0].value = arguments[1];", element, value);

		// Trigger events so frameworks (React/Angular/Vue) detect the change
		js.executeScript("arguments[0].dispatchEvent(new Event('input', { bubbles: true }));"
				+ "arguments[0].dispatchEvent(new Event('change', { bubbles: true }));", element);
	}

	public void clearTextBoxWithJS(By locator, int timeout) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

			// Clear value using JavaScript
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].value = '';", element);

			// Wait until the value is actually empty
			wait.until(driver -> element.getAttribute("value").isEmpty());

		} catch (Exception e) {
			System.out.println("Error while clearing text box using JavaScript: " + e.getMessage());
		}
	}

	public void clickFirstVisibleLocator(List<By> locators, int waitTime) {
		for (By locator : locators) {
			if (doIsDisplayed(locator, waitTime)) {
				waitForElementToBeClickable(locator, waitTime).click();
				break;
			}
		}
	}

	public boolean isAnyLocatorVisible(List<By> locators, int waitTime) {
		for (By locator : locators) {
			if (doIsDisplayed(locator, waitTime)) {
				return true;
			}
		}
		return false;
	}
	
	// Sends keys to an input field and then presses ENTER
	public void sendKeysWithEnter(By locator, String value) {
	    WebElement element = waitForElementVisible(locator, 10); // wait for element
	    element.clear(); // optional, clear existing text
	    element.sendKeys(value);
	    element.sendKeys(Keys.ENTER);
	}

	// Overloaded version using Actions
	public void sendKeysWithEnterAction(By locator, String value) {
	    WebElement element = waitForElementVisible(locator, 10);
	    element.clear();
	    Actions actions = new Actions(driver);
	    actions.moveToElement(element).click().sendKeys(value).sendKeys(Keys.ENTER).perform();
	}
	
	public void selectFromReactDropdown(By dropdownLocator, String optionText) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    Actions actions = new Actions(driver);

	    try {
	        // 1️⃣ Find base element
	        WebElement baseElement = wait.until(ExpectedConditions.presenceOfElementLocated(dropdownLocator));

	        // 2️⃣ Scroll into view
	        js.executeScript("arguments[0].scrollIntoView({block:'center'});", baseElement);

	        // 3️⃣ If AntD input is hidden (opacity 0 or readonly), click its parent .ant-select-selector
	        String opacity = baseElement.getCssValue("opacity");
	        boolean isReadOnly = Boolean.parseBoolean(baseElement.getAttribute("readonly"));
	        if ("0".equals(opacity) || isReadOnly) {
	            try {
	                WebElement clickableParent = baseElement.findElement(
	                        By.xpath("./ancestor::div[contains(@class,'ant-select')][1]//div[contains(@class,'ant-select-selector')]")
	                );
	                wait.until(ExpectedConditions.elementToBeClickable(clickableParent)).click();
	            } catch (NoSuchElementException e) {
	                // fallback to normal click if no parent found
	                wait.until(ExpectedConditions.elementToBeClickable(baseElement)).click();
	            }
	        } else {
	            wait.until(ExpectedConditions.elementToBeClickable(baseElement)).click();
	        }

	        // 4️⃣ Build option XPath
	        By optionLocator = By.xpath(
	                "//div[contains(@class,'ant-select-item-option-content') and normalize-space(text())='" + optionText + "']"
	        );

	        // 5️⃣ Wait for dropdown to render & find matching option
	        wait.until(ExpectedConditions.visibilityOfElementLocated(optionLocator));
	        List<WebElement> options = driver.findElements(optionLocator);

	        boolean found = false;
	        for (WebElement opt : options) {
	            try {
	                js.executeScript("arguments[0].scrollIntoView({block:'center'});", opt);
	                wait.until(ExpectedConditions.elementToBeClickable(opt)).click();
	                System.out.println("✅ Selected option: " + optionText);
	                found = true;
	                break;
	            } catch (Exception inner) {
	                // try next
	            }
	        }

	        // 6️⃣ Fallback – if no clickable option found, try sending keys
	        if (!found) {
	            try {
	                WebElement input = driver.findElement(By.xpath("//input[@role='combobox']"));
	                input.clear();
	                input.sendKeys(optionText);
	                input.sendKeys(Keys.ENTER);
	                System.out.println("⌨️ Selected via typing: " + optionText);
	                found = true;
	            } catch (Exception ignored) {}
	        }

	        if (!found) {
	            throw new RuntimeException("Option '" + optionText + "' not found or clickable.");
	        }

	        // 7️⃣ Close dropdown cleanly
	        actions.sendKeys(Keys.TAB).perform();

	    } catch (Exception e) {
	        System.out.println("❌ Dropdown selection failed for: " + optionText);
	        throw new RuntimeException("Failed to select option via click: " + optionText, e);
	    }
	}

	public void selectReqSkillOption(By dropdownLocator, String optionText) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    Actions actions = new Actions(driver);

	    // 1️⃣ Click the dropdown
	    WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(dropdownLocator));
	    dropdown.click();

	    // 2️⃣ Locate the input inside the dropdown
	    WebElement searchInput = dropdown.findElement(By.cssSelector("input"));

	    // 3️⃣ Type the option text using Actions and press Enter
	    actions.moveToElement(searchInput)
	           .click()
	           .sendKeys(optionText)
	           .sendKeys(Keys.ENTER)
	           .perform();

	    // 4️⃣ Optional: TAB out to close dropdown
	    actions.sendKeys(Keys.TAB).perform();
	}
	
	public void selectDropdownValue(String labelText, String valueToSelect) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    Actions actions = new Actions(driver);

	    try {
	        // 1️⃣ Locate and click the dropdown input by its label
	        WebElement dropdownInput = wait.until(ExpectedConditions.elementToBeClickable(
	            By.xpath("//label[normalize-space(text())='" + labelText + "']/following::input[@data-te-select-input-ref][1]")
	        ));
	        js.executeScript("arguments[0].scrollIntoView(true);", dropdownInput);
	        js.executeScript("arguments[0].click();", dropdownInput);

	        // 2️⃣ Wait for dropdown options to render
	        wait.until(ExpectedConditions.visibilityOfElementLocated(
	            By.xpath("//div[@data-te-select-option-ref]"))
	        );
	        Thread.sleep(800);

	        // 3️⃣ Dismiss focus from the search box (click somewhere safe)
	        actions.moveByOffset(0, 50).click().perform();
	        Thread.sleep(400);

	        // 4️⃣ Now click your desired option
	        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(
	            By.xpath("//div[@data-te-select-option-ref]//span[normalize-space(text())='" + valueToSelect + "']")
	        ));
	        js.executeScript("arguments[0].scrollIntoView(true);", option);
	        js.executeScript("arguments[0].click();", option);

	        Thread.sleep(500);
	        System.out.println("✅ Selected '" + valueToSelect + "' from '" + labelText + "' dropdown.");

	    } catch (Exception e) {
	        System.out.println("❌ Failed to select '" + valueToSelect + "' from dropdown '" + labelText + "'");
	        e.printStackTrace();
	    }
	}
	public void selectDropdownOption(WebDriver driver, String labelName, String optionText) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	    WebElement dropdownInput = wait.until(ExpectedConditions.elementToBeClickable(
	        By.xpath("//label[normalize-space()='" + labelName + "']/following::input[@data-te-select-input-ref][1]")
	    ));
	    dropdownInput.click();

	    wait.until(ExpectedConditions.visibilityOfElementLocated(
	        By.xpath("//div[@data-te-select-option-ref]")
	    ));

	    WebElement desiredOption = wait.until(ExpectedConditions.elementToBeClickable(
	        By.xpath("//div[@data-te-select-option-ref]//span[normalize-space(text())='" + optionText + "']")
	    ));
	    desiredOption.click();
	}

	public void selectFromDropdown(String labelName, String optionToSelect) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT));
	    JavascriptExecutor js = (JavascriptExecutor) driver;

	    try {
	        // 1️⃣ Handle MDB (custom TE) dropdowns
	        String customDropdownXpath = "//label[normalize-space(text())='" + labelName +
	                "']/ancestor::div[contains(@class,'relative')]//input[@data-te-select-input-ref]";
	        List<WebElement> customDropdowns = driver.findElements(By.xpath(customDropdownXpath));

	        if (!customDropdowns.isEmpty()) {
	            WebElement dropdownToUse;

	            // ⚙️ Special case for "Question Type" — pick the 3rd dropdown (index 2)
	            if (labelName.equalsIgnoreCase("Question Type") && customDropdowns.size() >= 3) {
	                dropdownToUse = customDropdowns.get(2);
	            } else {
	                dropdownToUse = customDropdowns.get(0);
	            }

	            js.executeScript("arguments[0].scrollIntoView(true);", dropdownToUse);
	            js.executeScript("arguments[0].click();", dropdownToUse);
	            Thread.sleep(700); // Let dropdown fully render outside the DOM hierarchy

	            // 🔍 Try both possible option containers
	            String globalOptionXpath = "//ul[contains(@class,'data-[te-select-dropdown-ref]') or contains(@id,'select')]//li[normalize-space()='" + optionToSelect + "']";
	            String inlineOptionXpath = "//div[@data-te-select-option-ref]//span[normalize-space(text())='" + optionToSelect + "']";

	            List<WebElement> options = driver.findElements(By.xpath(globalOptionXpath));
	            if (options.isEmpty()) {
	                options = driver.findElements(By.xpath(inlineOptionXpath));
	            }

	            if (!options.isEmpty()) {
	                WebElement option = wait.until(ExpectedConditions.elementToBeClickable(options.get(0)));
	                js.executeScript("arguments[0].scrollIntoView(true);", option);
	                js.executeScript("arguments[0].click();", option);

	                System.out.println("✅ Selected '" + optionToSelect + "' from *custom* dropdown '" + labelName + "'");
	                return;
	            } else {
	                System.out.println("⚠️ No matching option found for '" + optionToSelect + "' in dropdown '" + labelName + "'");
	            }
	        }

	        // 2️⃣ Handle native <select> dropdowns
	        String selectXpath = "//label[normalize-space(text())='" + labelName + "']/following::select[1]";
	        List<WebElement> nativeSelects = driver.findElements(By.xpath(selectXpath));

	        if (!nativeSelects.isEmpty()) {
	            WebElement nativeSelect = wait.until(ExpectedConditions.elementToBeClickable(nativeSelects.get(0)));
	            Select select = new Select(nativeSelect);
	            select.selectByVisibleText(optionToSelect);

	            System.out.println("✅ Selected '" + optionToSelect + "' from *native* dropdown '" + labelName + "'");
	            return;
	        }

	        // 3️⃣ If neither found
	        System.out.println("⚠️ No dropdown found for label: " + labelName);

	    } catch (Exception e) {
	        System.out.println("❌ Failed to select '" + optionToSelect + "' from dropdown '" + labelName + "'");
	        e.printStackTrace();
	    }
	}
	
	public void selectCustomDropdownByVisibleText(By dropdownLocator, String visibleText, int timeout) {
	    waitForElementToBeVisibleAndEnabled(dropdownLocator, timeout);
	    doClick(dropdownLocator);
	    By optionLocator = By.xpath("//div[contains(@class,'ant-select-item-option-content') and normalize-space(text())='" + visibleText + "']");
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
	    WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(optionLocator));
	    wait.until(ExpectedConditions.elementToBeClickable(optionLocator));
	    option.click();
	}
	// Add this method to ElementUtils
	// Add this inside your ElementUtils class
	public void selectMultiSelectOption(By dropdownLocator, String optionText) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    try {
	        // Click the dropdown to open options
	        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(dropdownLocator));
	        js.executeScript("arguments[0].scrollIntoView(true);", dropdown);
	        dropdown.click();
	        Thread.sleep(200); // Let options render

	        // Find the option by visible text (update the XPath if your UI is different)
	        By optionLocator = By.xpath("//div[contains(@class,'ant-select-item-option-content') and normalize-space(text())='" + optionText + "']");
	        WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(optionLocator));
	        js.executeScript("arguments[0].scrollIntoView(true);", option);
	        wait.until(ExpectedConditions.elementToBeClickable(option)).click();
	        Thread.sleep(200); // Let the selection register

	        // Optionally, press ESC to close dropdown if it remains open
	        dropdown.sendKeys(org.openqa.selenium.Keys.ESCAPE);
	    } catch (Exception e) {
	        throw new RuntimeException("Failed to select multi-select option: " + optionText, e);
	    }
	}
	
	public void selectOptionsInHiddenMultiSelect(By selectLocator, List<String> optionTexts, int timeout) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
	    WebElement selectEl = wait.until(ExpectedConditions.presenceOfElementLocated(selectLocator));
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    List<WebElement> options = selectEl.findElements(By.tagName("option"));
	    int matched = 0;

	    for (String desiredRaw : optionTexts) {
	        if (desiredRaw == null || desiredRaw.isBlank()) continue;
	        String desired = desiredRaw.replaceAll("\\s+", " ").trim().toLowerCase();
	        boolean found = false;
	        for (WebElement opt : options) {
	            String optNorm = (opt.getText() == null ? "" : opt.getText()).replaceAll("\\s+", " ").trim().toLowerCase();
	            if (optNorm.equals(desired) || optNorm.startsWith(desired) || optNorm.contains(desired)) {
	                js.executeScript("arguments[0].selected = true;", opt);
	                found = true;
	                matched++;
	                break;
	            }
	        }
	        if (!found) {
	            System.out.println("[SiteSelect][WARN] No match for: " + desiredRaw);
	        }
	    }

	    if (matched == 0 && !optionTexts.isEmpty()) {
	        System.out.println("[SiteSelect][DEBUG] First 10 options:");
	        for (int i = 0; i < Math.min(10, options.size()); i++) {
	            System.out.println("  " + i + ": '" + options.get(i).getText().trim() + "'");
	        }
	        throw new RuntimeException("No site options matched: " + optionTexts);
	    }
	    js.executeScript(
	        "arguments[0].dispatchEvent(new Event('input',{bubbles:true})); arguments[0].dispatchEvent(new Event('change',{bubbles:true}));",
	        selectEl
	    );
	    System.out.println("[SiteSelect] Matched " + matched + " sites");
	}
	
	public void selectVirtualDropdownOption(WebDriver driver, String optionText) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    JavascriptExecutor js = (JavascriptExecutor) driver;

	    try {
	        // Wait for dropdown options to become visible
	        List<WebElement> options = wait.until(ExpectedConditions
	                .presenceOfAllElementsLocatedBy(By.xpath("//div[@role='option']//span[@data-te-select-option-text-ref]")));

	        boolean found = false;
	        for (WebElement option : options) {
	            String visibleText = option.getText().trim();
	            if (visibleText.equalsIgnoreCase(optionText) || visibleText.contains(optionText)) {
	                js.executeScript("arguments[0].scrollIntoView({block:'center'});", option);
	                WebElement checkbox = option.findElement(By.xpath(".//input[@type='checkbox']"));
	                js.executeScript("arguments[0].click();", checkbox);

	                js.executeScript(
	                    "var el=document.querySelector('select[id*=assign_site],input[name*=assign_site]');" +
	                    "if(el){el.dispatchEvent(new Event('input',{bubbles:true}));" +
	                    "el.dispatchEvent(new Event('change',{bubbles:true}));}"
	                );

	                System.out.println("[SiteSelect][INFO] Selected: " + visibleText);
	                found = true;
	                break;
	            }
	        }

	        if (!found) {
	            System.out.println("[SiteSelect][WARN] Option not found in dropdown: " + optionText);
	            throw new RuntimeException("Option not found: " + optionText);
	        }

	    } catch (Exception e) {
	        throw new RuntimeException("Failed to select dropdown option: " + optionText, e);
	    }
	}

	public static void handleUnexpectedAlert(WebDriver driver) {
        try {
            org.openqa.selenium.Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (org.openqa.selenium.NoAlertPresentException e) {
            // No alert to handle
        }
    }





	



}
