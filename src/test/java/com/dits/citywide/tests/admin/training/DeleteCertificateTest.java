package com.dits.citywide.tests.admin.training;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.constants.TrainingConstants;

public class DeleteCertificateTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test
	public void deleteCertificateTest() {
		trainingPage = dashboardPage.clickOnTrainingTab();
		certificatesPage = trainingPage.clickOnCertificates();
		softAssert.assertEquals(certificatesPage.getHeadingCertificates(), "Certificates",
				"Heading Certificates is not visible");
		certificatesPage.clickDeleteCertificateButton(TrainingConstants.CERTIFICATE_NAME);
		certificatesPage.clickOnDeleteButton();
		softAssert.assertEquals(certificatesPage.getSuccessMessage(),
				TrainingConstants.CERTIFICATE_DELETED_SUCCESS_MESSAGE);

		softAssert.assertAll();
	}

}
