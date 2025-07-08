package com.dits.citywide.utilities;

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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	public boolean doIsDisplayed(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
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

	// ---------------- Visibility Of All Element ---------------------------

	public List<WebElement> waitsForElementsVisible(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
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
	public void doActionsSendKeys(By by, String value) {
		Actions action = new Actions(driver);
		action.sendKeys(getElement(by), value).perform();
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
					System.out.println("Dropdown option: " + eleText);
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
				break;
			} catch (StaleElementReferenceException | ElementNotInteractableException e) {
				retries--;
				System.out.println("Retry due to: " + e.getClass().getSimpleName());
				try {
					Thread.sleep(500); // short wait before retry
				} catch (InterruptedException ie) {
					Thread.currentThread().interrupt();
				}
			}
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

	public void selectElementFromVirtualDropdown(By optionLocator, String visibleText) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
	
	public void pressEscKey() {
	    try {
	        Actions actions = new Actions(driver);
	        actions.sendKeys(Keys.ESCAPE).perform();
	    } catch (Exception e) {
	        System.out.println("Error while pressing Escape key: " + e.getMessage());
	    }
	}



	public void clearTextBoxWithKeys(By locator) {
	    try {
	        WebElement element = driver.findElement(locator);
	        element.click(); // Focus the field

	        // Dynamically select the correct key for CMD (Mac) or CTRL (Windows/Linux)
	        Keys selectAllKey = System.getProperty("os.name").toLowerCase().contains("mac") ? Keys.COMMAND : Keys.CONTROL;

	        // Perform Select All and Delete
	        element.sendKeys(Keys.chord(selectAllKey, "a")); // CMD/CTRL + A
	        element.sendKeys(Keys.DELETE); // Delete selected text
	    } catch (Exception e) {
	        System.out.println("Error while clearing text box with keys: " + e.getMessage());
	    }
	}
	
	public void clearTextBoxWithActions(By locator) {
	    try {
	        WebElement element = driver.findElement(locator);
	        element.click(); // Focus the field

	        // Detect OS and choose appropriate key
	        Keys selectAllKey = System.getProperty("os.name").toLowerCase().contains("mac") ? Keys.COMMAND : Keys.CONTROL;

	        // Use Actions to clear text
	        Actions actions = new Actions(driver);
	        actions.keyDown(selectAllKey)
	               .sendKeys("a")
	               .keyUp(selectAllKey)
	               .sendKeys(Keys.DELETE)
	               .build()
	               .perform();
	    } catch (Exception e) {
	        System.out.println("Error while clearing text box using Actions: " + e.getMessage());
	    }
	}

	


	public void scrollInsideDropdownToText(By dropdownValuesLocator, String visibleText) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// Wait for dropdown container
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

			if (found)
				break;

			// Scroll container slightly if not found
			js.executeScript("arguments[0].scrollTop += 50;", container);
			try {
				Thread.sleep(300); // allow rendering
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}

		if (!found) {
			throw new NoSuchElementException("Option '" + visibleText + "' not found in dropdown.");
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



}
