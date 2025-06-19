package com.dits.citywide.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.dits.citywide.utilities.ElementUtils;

public class ActivityTemplatePage {

	private WebDriver driver;
	private ElementUtils elementUtils;

	private By txtActivityTemplateHeader = By.xpath("//h1[normalize-space()='Activity Templates']");
	private By btnAddActivityTemplate = By.xpath("//span[normalize-space()='Add New Template']");

	// Add Activity Template
	private By txtboxActivityTemplateName = By.xpath("//input[@id='template_name']");
	private By dropdownActivityCode = By.xpath("(//div[@class='ant-select-selector'])[1]");
	private By searchActivityType = By.xpath("//input[@id='code']");

	private By dropdownQuestionType = By.xpath("(//div[@class='ant-select-selector'])[3]");
	private By dropdownvalueQuestionType = By.xpath("(//div[@class='rc-virtual-list-holder-inner'])[2]/div/div");
	private By txtboxQuestion = By.xpath("//textarea[@id='question']");

	private By txtboxAddNewTemplate = By.xpath("//div[@class='questionEditor rdw-editor-main']");
	
	private By btnSaveQuestion = By.xpath("//span[normalize-space()='Save questions']");

	public ActivityTemplatePage(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(driver);
	}
	
	

}
