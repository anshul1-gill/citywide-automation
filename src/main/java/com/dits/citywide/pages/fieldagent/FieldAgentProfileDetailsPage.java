package com.dits.citywide.pages.fieldagent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.dits.citywide.constants.Constants;
import com.dits.citywide.constants.HRManagementConstants;
import com.dits.citywide.utilities.ElementUtils;

public class FieldAgentProfileDetailsPage {

	private WebDriver driver;
	private ElementUtils elementUtils;

	private By tabPersonalInformation = By.cssSelector("#rc-tabs-0-tab-1");
	private By tabEmploymentInformation = By.cssSelector("#rc-tabs-0-tab-2");
	private By tabPermits = By.cssSelector("#rc-tabs-0-tab-3");
	private By tabPayInfo = By.cssSelector("#rc-tabs-0-tab-4");
	private By tabAdditionalDocuments = By.cssSelector("#rc-tabs-0-tab-5");
	private By tabReferences = By.cssSelector("#rc-tabs-0-tab-6");
	private By tabAvailableTimes = By.cssSelector("#rc-tabs-0-tab-7");
	private By tabTraining = By.cssSelector("#rc-tabs-0-tab-8");
	private By tabComments = By.cssSelector("#rc-tabs-0-tab-9");

	// Permits
	// Driver's License
	private By dataDriverLicenseNumber = By.xpath("//td[@data-label=\"Driver's License Number\"]");
	private By dataDateOfIssue = By.xpath("//td[@data-label='Date of Issue']");
	private By dataDateOfExpiration = By.xpath("//td[@data-label='Date of Expiration']");

	// Guard Card
	private By tabGuardCard = By.cssSelector("#rc-tabs-3-tab-2");
	private By dataGaurdCardPermitNumber = By.xpath("//td[@data-label='Permit Number']");
	private By dataGaurdCardDateOfIssue = By.xpath("//td[@data-label='Date of Issue']");
	private By dataGaurdCardDateOfExpiration = By.xpath("//td[@data-label='Date of Expiration']");
	private By dataFile = By.xpath("(//div[@class='ant-image-mask'])[2]");

	// Firearms Qualification
	private By tabFirearmsQualification = By.cssSelector("#rc-tabs-3-tab-3");
	private By dataFirearmsPermitNumber = By.xpath("//td[@data-label='Permit Number']");
	private By dataFirearmsDateOfIssue = By.xpath("//td[@data-label='Date of Issue']");
	private By dataFirearmsDateOfExpiration = By.xpath("//td[@data-label='Date of Expiration']");

	// Baton
	private By tabBaton = By.cssSelector("#rc-tabs-3-tab-4");
	private By dataBatonPermitNumber = By.xpath("//td[@data-label='Permit Number']");
	private By dataBatonDateOfIssue = By.xpath("//td[@data-label='Date of Issue']");
	private By databatonDateOfExpiration = By.xpath("//td[@data-label='Date of Expiration']");

	// ECD
	private By tabECD = By.cssSelector("#rc-tabs-3-tab-5");
	private By dataECDPermitNumber = By.xpath("//td[@data-label='Permit Number']");
	private By dataECDDateOfIssue = By.xpath("//td[@data-label='Date of Issue']");
	private By dataECDDateOfExpiration = By.xpath("//td[@data-label='Date of Expiration']");

	// OC Spray
	private By tabOCSpray = By.cssSelector("#rc-tabs-3-tab-6");
	private By dataOCSprayPermitNumber = By.xpath("//td[@data-label='Permit Number']");
	private By dataOCSprayDateOfIssue = By.xpath("//td[@data-label='Date of Issue']");
	private By dataOCSprayDateOfExpiration = By.xpath("//td[@data-label='Date of Expiration']");

	// Other Permits
	private By tabOtherPermits = By.cssSelector("#rc-tabs-3-tab-7");
	private By dataOtherPermitPermitNumber = By.xpath("//td[@data-label='Permit Number']");
	private By dataOtherPermitDateOfIssue = By.xpath("//td[@data-label='Date of Issue']");
	private By dataOtherPermitDateOfExpiration = By.xpath("//td[@data-label='Date of Expiration']");

	// Comments
	private By txtHeadingComments = By.xpath(
			"//div[contains(@class,'primary-heading configuration-setting-header')]/span[contains(text(),'Comments')]");

	private By getRemarkCategoryCell(String remarkCategory) {
		String xpath = String.format("//td[normalize-space()='%s']", remarkCategory);
		return By.xpath(xpath);
	}

	private By getReasonByCategory(String remarkCategory) {
		String xpath = String.format("//td[normalize-space()='%s']/following-sibling::td/span", remarkCategory);
		return By.xpath(xpath);
	}

	private By getCommentByCategory(String remarkCategory) {
		String xpath = String.format("//td[normalize-space()='%s']/following-sibling::td[@data-label='Comment']",
				remarkCategory);
		return By.xpath(xpath);
	}

	private By getPostedByByCategory(String remarkCategory) {
		String xpath = String.format("//td[normalize-space()='%s']/following-sibling::td[@data-label='Posted By']",
				remarkCategory);
		return By.xpath(xpath);
	}

	private By getCreatedByCategory(String remarkCategory) {
		String xpath = String.format("//td[normalize-space()='%s']/following-sibling::td[@data-label='Created']",
				remarkCategory);
		return By.xpath(xpath);
	}

	private By getResponseDropdownByCategory(String remarkCategory) {
		String xpath = String.format("//td[normalize-space()='%s']" + "/following-sibling::td[@data-label='Response']"
				+ "//span[@class='ant-select-selection-search']", remarkCategory);
		return By.xpath(xpath);
	}

	private By getResponseByValue(String responseValue) {
		String xpath = String.format("//div[contains(text(),'%s')]", responseValue);
		return By.xpath(xpath);
	}

	private By confimationMessage = By.cssSelector("#swal2-html-container");
	private By btnOk = By.cssSelector("button[class='swal2-confirm swal2-styled']");

	private By txtboxHeading = By.xpath("//span[@class='baseTitle']");
	private By txtboxReason = By.cssSelector("#reason");
	private By btnSubmit = By.xpath("//span[normalize-space()='Submit']");

	private By sucessMessage = By.xpath("//div[contains(@class,'Toastify__toast-icon')]/following-sibling::div");

	public FieldAgentProfileDetailsPage(WebDriver driver) {
		this.driver = driver;
		this.elementUtils = new ElementUtils(driver);
	}

	public void clickCommentsTab() {
		elementUtils.waitForElementToBeClickable(tabComments, Constants.DEFAULT_WAIT).click();
	}

	public String getHeadingText() {
		return elementUtils.waitForElementVisible(txtHeadingComments, Constants.DEFAULT_WAIT).getText();
	}

	public String getRemarkCategoryText(String remarkCategory) {
		return elementUtils.waitForElementVisible(getRemarkCategoryCell(remarkCategory), Constants.DEFAULT_WAIT)
				.getText();
	}

	public String getReasonText(String remarkCategory) {
		return elementUtils.waitForElementVisible(getReasonByCategory(remarkCategory), Constants.DEFAULT_WAIT)
				.getText();
	}

	public String getCommentByCategoryText(String remarkCategory) {
		return elementUtils.waitForElementVisible(getCommentByCategory(remarkCategory), Constants.DEFAULT_WAIT)
				.getText();
	}

	public String getPostedByText(String remarkCategory) {
		return elementUtils.waitForElementVisible(getPostedByByCategory(remarkCategory), Constants.DEFAULT_WAIT)
				.getText();
	}

	public String getCreatedByText(String remarkCategory) {
		return elementUtils.waitForElementVisible(getCreatedByCategory(remarkCategory), Constants.DEFAULT_WAIT)
				.getText();
	}

	public String getResponseText(String remarkCategory) {
		return elementUtils.waitForElementVisible(getResponseDropdownByCategory(remarkCategory), Constants.DEFAULT_WAIT)
				.getText();
	}

	public void selectResponse(String remarkCategory, String responseValue) throws InterruptedException {
		elementUtils.waitForElementVisible(getResponseDropdownByCategory(remarkCategory), Constants.DEFAULT_WAIT)
				.click();
		elementUtils.waitForElementVisible(getResponseByValue(responseValue), Constants.DEFAULT_WAIT).click();
	}

	public String getConfirmationMessage() {
		return elementUtils.waitForElementVisible(confimationMessage, Constants.DEFAULT_WAIT).getText();
	}

	public void clickOk() {
		elementUtils.waitForElementToBeClickable(btnOk, Constants.DEFAULT_WAIT).click();
	}

	public String getHeadingTextBox() {
		return elementUtils.waitForElementVisible(txtboxHeading, Constants.DEFAULT_WAIT).getText();
	}

	public void fillReasonTextBox(String reason) {
		elementUtils.waitForElementToBeClickable(txtboxReason, Constants.DEFAULT_WAIT).sendKeys(reason);
	}

	public void clickSubmit() {
		elementUtils.waitForElementToBeClickable(btnSubmit, Constants.DEFAULT_WAIT).click();
	}

	public String getSuccessMessage() {
		return elementUtils.waitForElementVisible(sucessMessage, Constants.DEFAULT_WAIT).getText();
	}

	// --- Tab Validation Methods ---
	public void validatePersonalInformationTab(java.util.Map<String, String> expectedFields) {
		try {
			elementUtils.waitForElementToBeClickable(tabPersonalInformation, Constants.DEFAULT_WAIT).click();
			boolean allFieldsFilled = true;
			for (java.util.Map.Entry<String, String> entry : expectedFields.entrySet()) {
				String field = entry.getKey();
				String expected = entry.getValue();
				String xpath;
				if (field.equals("Branches")) {
					xpath = "//div[contains(@class,'label-box')]//strong[normalize-space()='" + field + "']/following-sibling::span[contains(@class,'tag')]";
				} else {
					xpath = "//div[contains(@class,'label-box')]//strong[normalize-space()='" + field + "']/following-sibling::span";
				}
				String actual = null;
				try {
					actual = elementUtils.getText(By.xpath(xpath), Constants.DEFAULT_WAIT);
				} catch (Exception ex) {
					// ignore, will handle below
				}
				if (actual == null || actual.isEmpty()) {
					System.out.println(field + " is not filled");
					allFieldsFilled = false;
				} else {
					System.out.println(field + " is shown. Expected: '" + expected + "', Actual: '" + actual + "'");
					if (!expected.equals(actual)) {
						allFieldsFilled = false;
					}
				}
			}
			if (allFieldsFilled) {
				System.out.println("All personal information fields are filled and shown as expected.");
			}
		} catch (Exception e) {
			System.out.println("This tab data is not filled");
		}
	}

	/**
     * Generic validation for table-based tabs (Employment, Permits, Pay Info, etc.)
     */
    public void validateTableTab(By tabLocator, java.util.Map<String, String> expectedFields, String fieldXpathTemplate) {
        try {
            elementUtils.waitForElementToBeClickable(tabLocator, Constants.DEFAULT_WAIT).click();
            boolean allFieldsFilled = true;
            for (java.util.Map.Entry<String, String> entry : expectedFields.entrySet()) {
                String field = entry.getKey();
                String expected = entry.getValue();
                String xpath = String.format(fieldXpathTemplate, field);
                String actual = null;
                try {
                    actual = elementUtils.getText(By.xpath(xpath), Constants.DEFAULT_WAIT);
                } catch (Exception ex) {
                    // ignore, will handle below
                }
                if (actual == null || actual.isEmpty()) {
                    System.out.println(field + " is not filled");
                    allFieldsFilled = false;
                } else {
                    System.out.println(field + " is shown. Expected: '" + expected + "', Actual: '" + actual + "'");
                    if (!expected.equals(actual)) {
                        allFieldsFilled = false;
                    }
                }
            }
            if (allFieldsFilled) {
                System.out.println("All tab fields are filled and shown as expected.");
            }
        } catch (Exception e) {
            System.out.println("This tab data is not filled");
        }
    }

    public void validateEmploymentInformationTab(java.util.Map<String, String> expectedFields) {
        // Table: //td[normalize-space()='%s']/following-sibling::td[1]
        validateTableTab(tabEmploymentInformation, expectedFields, "//td[normalize-space()='%s']/following-sibling::td[1]");
    }

    public void validatePermitsTab(java.util.Map<String, String> expectedFields) {
        // Table: //td[@data-label='%s']
        validateTableTab(tabPermits, expectedFields, "//td[@data-label='%s']");
    }

    public void validatePayInfoTab(java.util.Map<String, String> expectedFields) {
        // Table: //td[@data-label='%s']
        validateTableTab(tabPayInfo, expectedFields, "//td[@data-label='%s']");
    }

    public void validateAdditionalDocumentsTab(java.util.Map<String, String> expectedFields) {
        validateTableTab(tabAdditionalDocuments, expectedFields, "//td[@data-label='%s']");
    }

    public void validateReferencesTab(java.util.Map<String, String> expectedFields) {
        validateTableTab(tabReferences, expectedFields, "//td[@data-label='%s']");
    }

    public void validateAvailableTimesTab(java.util.Map<String, String> expectedFields) {
        validateTableTab(tabAvailableTimes, expectedFields, "//td[@data-label='%s']");
    }

    public void validateTrainingTab(java.util.Map<String, String> expectedFields) {
        validateTableTab(tabTraining, expectedFields, "//td[@data-label='%s']");
    }

	public void validateEmploymentInformationTab() {
		try {
			elementUtils.waitForElementToBeClickable(tabEmploymentInformation, Constants.DEFAULT_WAIT).click();
			String role = elementUtils.getText(By.xpath("//td[@data-label='Role']"), Constants.DEFAULT_WAIT);
			if (!HRManagementConstants.ROLE_FIELD.equals(role)) {
				System.out.println("This tab data is not filled");
			}
		} catch (Exception e) {
			System.out.println("This tab data is not filled");
		}
	}

	public void validatePermitsTab() {
		try {
			elementUtils.waitForElementToBeClickable(tabPermits, Constants.DEFAULT_WAIT).click();
			String dlNumber = elementUtils.getText(dataDriverLicenseNumber, Constants.DEFAULT_WAIT);
			if (dlNumber == null || dlNumber.isEmpty()) {
				System.out.println("This tab data is not filled");
			}
		} catch (Exception e) {
			System.out.println("This tab data is not filled");
		}
	}

	public void validatePayInfoTab() {
		try {
			elementUtils.waitForElementToBeClickable(tabPayInfo, Constants.DEFAULT_WAIT).click();
			String payInfo = elementUtils.getText(By.xpath("//td[@data-label='Pay Rate']"), Constants.DEFAULT_WAIT);
			if (payInfo == null || payInfo.isEmpty()) {
				System.out.println("This tab data is not filled");
			}
		} catch (Exception e) {
			System.out.println("This tab data is not filled");
		}
	}

	public void validateAdditionalDocumentsTab() {
		try {
			elementUtils.waitForElementToBeClickable(tabAdditionalDocuments, Constants.DEFAULT_WAIT).click();
			String doc = elementUtils.getText(By.xpath("//td[@data-label='Document Name']"), Constants.DEFAULT_WAIT);
			if (doc == null || doc.isEmpty()) {
				System.out.println("This tab data is not filled");
			}
		} catch (Exception e) {
			System.out.println("This tab data is not filled");
		}
	}

	public void validateReferencesTab() {
		try {
			elementUtils.waitForElementToBeClickable(tabReferences, Constants.DEFAULT_WAIT).click();
			String ref = elementUtils.getText(By.xpath("//td[@data-label='Reference Name']"), Constants.DEFAULT_WAIT);
			if (ref == null || ref.isEmpty()) {
				System.out.println("This tab data is not filled");
			}
		} catch (Exception e) {
			System.out.println("This tab data is not filled");
		}
	}

	public void validateAvailableTimesTab() {
		try {
			elementUtils.waitForElementToBeClickable(tabAvailableTimes, Constants.DEFAULT_WAIT).click();
			String available = elementUtils.getText(By.xpath("//td[@data-label='Available Time']"), Constants.DEFAULT_WAIT);
			if (available == null || available.isEmpty()) {
				System.out.println("This tab data is not filled");
			}
		} catch (Exception e) {
			System.out.println("This tab data is not filled");
		}
	}

	public void validateTrainingTab() {
		try {
			elementUtils.waitForElementToBeClickable(tabTraining, Constants.DEFAULT_WAIT).click();
			String training = elementUtils.getText(By.xpath("//td[@data-label='Training Name']"), Constants.DEFAULT_WAIT);
			if (training == null || training.isEmpty()) {
				System.out.println("This tab data is not filled");
			}
		} catch (Exception e) {
			System.out.println("This tab data is not filled");
		}
	}

	public void validateCommentsTab() {
		try {
			elementUtils.waitForElementToBeClickable(tabComments, Constants.DEFAULT_WAIT).click();
			String heading = getHeadingText();
			if (heading == null || heading.isEmpty()) {
				System.out.println("This tab data is not filled");
			}
		} catch (Exception e) {
			System.out.println("This tab data is not filled");
		}
	}

	public String getTextFromProfileTab(String dataLabel) {
        // This method will get the text from a <span> with the given text in the currently open tab
        try {
            return elementUtils.getText(By.xpath("//span[normalize-space()='" + dataLabel + "']"), Constants.DEFAULT_WAIT);
        } catch (Exception e) {
            return null;
        }
    }

    public boolean isFieldVisible(String dataLabel) {
        try {
            By locator = By.xpath("//span[normalize-space()='" + dataLabel + "']");
            return elementUtils.isElementVisible(locator, 5);
        } catch (Exception e) {
            return false;
        }
    }

    public String getFieldValue(String fieldName) {
        // Map field names to locators. Add more as needed for your test fields.
        By locator = null;
        switch (fieldName) {
            case "Permit Number":
                locator = dataGaurdCardPermitNumber;
                break;
            case "Guard Card Issue Date":
                locator = dataGaurdCardDateOfIssue;
                break;
            case "Guard Card Expiration Date":
                locator = dataGaurdCardDateOfExpiration;
                break;
            case "Firearms Permit Number":
                locator = dataFirearmsPermitNumber;
                break;
            case "Firearms Issue Date":
                locator = dataFirearmsDateOfIssue;
                break;
            case "Firearms Expiration Date":
                locator = dataFirearmsDateOfExpiration;
                break;
            case "Baton Permit Number":
                locator = dataBatonPermitNumber;
                break;
            case "Baton Issue Date":
                locator = dataBatonDateOfIssue;
                break;
            case "Baton Expiration Date":
                locator = databatonDateOfExpiration;
                break;
            case "ECD Permit Number":
                locator = dataECDPermitNumber;
                break;
            case "ECD Issue Date":
                locator = dataECDDateOfIssue;
                break;
            case "ECD Expiration Date":
                locator = dataECDDateOfExpiration;
                break;
            case "OC Spray Permit Number":
                locator = dataOCSprayPermitNumber;
                break;
            case "OC Spray Issue Date":
                locator = dataOCSprayDateOfIssue;
                break;
            case "OC Spray Expiration Date":
                locator = dataOCSprayDateOfExpiration;
                break;
            case "Other Permit Number":
                locator = dataOtherPermitPermitNumber;
                break;
            case "Other Permit Issue Date":
                locator = dataOtherPermitDateOfIssue;
                break;
            case "Other Permit Expiration Date":
                locator = dataOtherPermitDateOfExpiration;
                break;
            case "Officer":
                // Officer label in Personal Information tab
                return elementUtils.waitForElementVisible(By.xpath("//strong[normalize-space()='Officer']/following-sibling::span"), Constants.DEFAULT_WAIT).getText();
            case "Branches":
                // Branches may use a tag class
                return elementUtils.waitForElementVisible(By.xpath("//strong[normalize-space()='Branches']/following-sibling::span[contains(@class,'tag')]"), Constants.DEFAULT_WAIT).getText();
            case "Email Address":
            case "Email (Primary)":
            case "Email (Alternate)":
            case "Gender":
            case "Phone (Primary)":
            case "Phone (Alternate)":
            case "Emergency contact name":
            case "Phone (Emergency)":
            case "Notes":
                return elementUtils.waitForElementVisible(By.xpath("//strong[normalize-space()='" + fieldName + "']/following-sibling::span"), Constants.DEFAULT_WAIT).getText();
            // Employment Information Tab fields
            case "Employment Status":
            case "Hire Month":
            case "Hire Year":
            case "Hire Date":
            case "Employment Notes":
            case "Class Code":
            case "Class Code Month":
            case "Class Code Year":
            case "Class Code Date":
            case "Employment Type":
            case "Department Type":
                return elementUtils.waitForElementVisible(By.xpath("//td[normalize-space()='" + fieldName + "']/following-sibling::td[1]"), Constants.DEFAULT_WAIT).getText();
            // Add more cases for other fields as needed
            default:
                throw new IllegalArgumentException("Field locator not defined for: " + fieldName);
        }
        return elementUtils.waitForElementVisible(locator, Constants.DEFAULT_WAIT).getText();
    }

    /**
     * Waits for the Employment Information tab's main field to be visible.
     * This ensures the tab content is loaded before field validation.
     */
    public void waitForEmploymentTabToBeVisible() {
        // Wait for the 'Employment Status' field to be visible (as used in getFieldValue)
        elementUtils.waitForElementVisible(By.xpath("//td[normalize-space()='Employment Status']/following-sibling::td[1]"), Constants.DEFAULT_WAIT);
    }

}
