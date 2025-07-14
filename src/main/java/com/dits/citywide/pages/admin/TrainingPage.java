package com.dits.citywide.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.dits.citywide.constants.Constants;
import com.dits.citywide.utilities.ElementUtils;

public class TrainingPage {

	private WebDriver driver;
	private ElementUtils elementUtils;

	private By lnkTotalCourses = By.xpath("//h4[normalize-space()='Total Courses']");
	private By lnkAssessmentsResults = By.xpath("//h4[normalize-space()='Assessments Results']");
	private By lnkCertificates = By.xpath("//h4[normalize-space()='Certificates']");
	private By lnkCourseCategories = By.xpath("//h4[normalize-space()='Course Categories']");

	public TrainingPage(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(driver);
	}

	public CourseCategoriesPage clickOnCourseCategories() {
		elementUtils.waitForElementToBeClickable(lnkCourseCategories, Constants.DEFAULT_WAIT).click();
		return new CourseCategoriesPage(driver);
	}
	
	public CertificatesPage clickOnCertificates() {
		elementUtils.waitForElementToBeClickable(lnkCertificates, Constants.DEFAULT_WAIT).click();
		return new CertificatesPage(driver);
	}
	
	public TotalCoursesPage clickOnTotalCourses() {
		elementUtils.waitForElementToBeClickable(lnkTotalCourses, Constants.DEFAULT_WAIT).click();
		return new TotalCoursesPage(driver);
	}

}
