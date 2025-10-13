package com.dits.citywide.tests.admin.training;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.TrainingConstants;

public class UpdateCertificateTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test
	public void updateCertificateTest() {
		trainingPage = dashboardPage.clickOnTrainingTab();
		certificatesPage = trainingPage.clickOnCertificates();
		softAssert.assertEquals(certificatesPage.getHeadingCertificates(), TrainingConstants.CERTIFICATE_HEADING,
				"Heading Certificates is not visible");
		certificatesPage.clickEditCertificateButton(TrainingConstants.CERTIFICATE_NAME);
		//certificatesPage.clickOnSaveCertificate();
		certificatesPage.updateCertificateName(TrainingConstants.UPDATED_CERTIFICATE_NAME,
				TrainingConstants.UPDATED_SERIAL_NUMBER, TrainingConstants.UPDATED_DESCRIPTION);

		softAssert.assertTrue(certificatesPage.isAddNewCertificateButtonDisplayed(),
				"Add New Certificate button is not displayed after updating certificate");
		softAssert.assertEquals(certificatesPage.getHeadingCertificates(), TrainingConstants.CERTIFICATE_HEADING,
				"Heading Certificates is not visible after updating certificate");
		softAssert.assertEquals(certificatesPage.getCertificateName(), TrainingConstants.UPDATED_CERTIFICATE_NAME,
				"Certificate name is not matching");
		softAssert.assertTrue(certificatesPage.getAddedBy().contains(prop.getProperty("email")),
				"Added by email is not matching");
		softAssert.assertEquals(certificatesPage.getDescription(), TrainingConstants.UPDATED_DESCRIPTION,
				"Certificate description is not matching");

		softAssert.assertAll();
	}

}
