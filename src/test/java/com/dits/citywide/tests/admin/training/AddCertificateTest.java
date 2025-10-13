package com.dits.citywide.tests.admin.training;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.TrainingConstants;

public class AddCertificateTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test
	public void addCertificateTest() throws InterruptedException {
		trainingPage = dashboardPage.clickOnTrainingTab();
		certificatesPage = trainingPage.clickOnCertificates();
		softAssert.assertEquals(certificatesPage.getHeadingCertificates(), TrainingConstants.CERTIFICATE_HEADING,
				"Heading Certificates is not visible");
		certificatesPage.clickOnAddNewCertificate();
		certificatesPage.fillCertificateName(TrainingConstants.CERTIFICATE_NAME,
				TrainingConstants.CERTIFICATE_SERIAL_NUMBER, TrainingConstants.CERTIFICATE_FILE_PATH,
				TrainingConstants.CERTIFICATE_DESCRIPTION);
		certificatesPage.clickOnSaveCertificate();
		softAssert.assertTrue(certificatesPage.isAddNewCertificateButtonDisplayed(),
				"Add New Certificate button is not displayed after adding certificate");
		softAssert.assertEquals(certificatesPage.getHeadingCertificates(), TrainingConstants.CERTIFICATE_HEADING,
				"Heading Certificates is not visible after adding certificate");
		softAssert.assertEquals(certificatesPage.getCertificateName(), TrainingConstants.CERTIFICATE_NAME,
				"Certificate name is not matching");
		softAssert.assertTrue(certificatesPage.getAddedBy().contains(prop.getProperty("email")),
				"Added by email is not matching");
		softAssert.assertEquals(certificatesPage.getDescription(), TrainingConstants.CERTIFICATE_DESCRIPTION,
				"Certificate description is not matching");

		softAssert.assertAll();
	}

}
