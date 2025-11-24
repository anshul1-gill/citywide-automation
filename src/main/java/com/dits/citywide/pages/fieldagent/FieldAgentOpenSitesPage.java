package com.dits.citywide.pages.fieldagent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.dits.citywide.constants.Constants;
import com.dits.citywide.utilities.ElementUtils;

public class FieldAgentOpenSitesPage {
	private WebDriver driver;
	private ElementUtils elementUtils;

	private By openSitestab = By.xpath("//span[normalize-space()='Sites']");
	private By viewSitesBtn = By.xpath("(//button[@title='View Site'])[1]");
	private By btnBack = By.xpath("//button[normalize-space()='Back']");	
	private By dropdownbtnColumns = By.xpath("//button[normalize-space()='Columns']"); //for closing click on this 
	private By checkboxComments = By.xpath("//input[@value='comments']");
	private By btnaddcomments = By.xpath("(//button[@title ='Add Comment'])[1]");
	private By dropdownoptionaddcmnt = By.xpath("(//select[contains(@class,'form-control')])[5]");
	private By txtareacomment = By.xpath("//textarea[@id='comment']");
	private By btnSubmit = By.xpath("//button[normalize-space()='Submit']");
	
	private  By viewCommentsBtn = By.xpath("(//button[@title='View Comment'])[1]");
	private  By dropdownResponse = By.xpath("(//select[contains(@class,'form-control')])[5]");

	public FieldAgentOpenSitesPage(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(driver);
	}

	public String getOpenSitesHeaderText() {
		return elementUtils.waitForElementVisible(openSitestab, Constants.DEFAULT_WAIT).getText();
	}
	
	public void clickOnOpenSitesTab() {
		elementUtils.waitForElementToBeClickable(openSitestab, Constants.DEFAULT_WAIT).click();
	}
	
	
	public void addCommentToSite(String commentType, String commentText) throws InterruptedException {
		elementUtils.waitForElementToBeClickable(viewSitesBtn, Constants.DEFAULT_WAIT).click();
		Thread.sleep(5000); // Adding a static wait to ensure the site details load properly
	    elementUtils.waitForElementToBeClickable(btnBack, Constants.DEFAULT_WAIT).click();
	    
		elementUtils.waitForElementToBeClickable(dropdownbtnColumns, Constants.DEFAULT_WAIT).click();
		
		elementUtils.waitForElementToBeClickable(checkboxComments, Constants.DEFAULT_WAIT).click();
		Thread.sleep(2000); // Adding a static wait to ensure the column is added properly
		elementUtils.waitForElementToBeClickable(dropdownbtnColumns, Constants.DEFAULT_WAIT).click();
		Thread.sleep(5000); // Adding a static wait to ensure the column is added properly
		elementUtils.waitForElementToBeClickable(btnaddcomments, Constants.DEFAULT_WAIT).click();
		Thread.sleep(2000); // Adding a static wait to ensure the add comment modal opens properly
		selectDropdownOptionAddComment(commentType);
		elementUtils.waitForElementVisible(txtareacomment, Constants.DEFAULT_WAIT).sendKeys(commentText);
		Thread.sleep(7000); // Adding a static wait to ensure the comment is entered properly
		elementUtils.waitForElementToBeClickable(btnSubmit, Constants.DEFAULT_WAIT).click();
	}
	
	public void selectDropdownOptionAddComment(String value) {
		elementUtils.doSelectBy(dropdownoptionaddcmnt, value);
	}
	public void selectDropdownResponseComment(String value) {
		elementUtils.doSelectBy(dropdownResponse, value);
	}
	
	public void viewCommentOfSite(String Responsetype) throws InterruptedException {
		elementUtils.waitForElementToBeClickable(viewCommentsBtn, Constants.DEFAULT_WAIT).click();
		Thread.sleep(5000); // Adding a static wait to ensure the comments load properly
		selectDropdownResponseComment(Responsetype);
	}
	
}