package com.dits.citywide.tests.patrol;

import java.util.Arrays;
import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;

public class PatrolVehicleInspectionTest extends BaseTest {

	@BeforeMethod
	public void performLogin() throws InterruptedException {
		patrolStartShiftPage = loginPage.doLoginPatrol(prop.getProperty("patrolID"),
				prop.getProperty("employeePassword"));
	}

	@Test
	public void patrolVehicleInspectionTest() throws InterruptedException {
		patrolStartShiftPage.handleMessageOfTheWeek();
		patrolVehicleInspectionPage = patrolStartShiftPage.clickOnVehicleInspectionTab();
		patrolVehicleInspectionPage.doClickVehicleNumber("5632");
		softAssert.assertEquals(patrolVehicleInspectionPage.getSelectedVehicleId(), "5632");
		String milesValues = patrolVehicleInspectionPage.getStartingMilesValue();
		patrolVehicleInspectionPage.enterEndingMiles(milesValues);
		patrolVehicleInspectionPage.clickNextButton();

		patrolVehicleInspectionPage.clickFluidCheck();
		List<String> actualValues = patrolVehicleInspectionPage.getFluidCheckValues();
		List<String> expectedValues = Arrays.asList("Fuel", "Oil", "Coolant", "Transmission", "Brake Fluid");
		for (String expected : expectedValues) {
			softAssert.assertTrue(actualValues.contains(expected), "Missing fluid value: " + expected);
		}
		patrolVehicleInspectionPage.clickTiresCheck();
		List<String> expectedTireValues = Arrays.asList("Right / Front", "Left / Front", "Right / Rear", "Left / Rear",
				"Spare Tire");
		List<String> actualTireValues = patrolVehicleInspectionPage.getTiresCheckValues();

		for (String expected : expectedTireValues) {
			softAssert.assertTrue(actualTireValues.contains(expected), "Missing tire check value: " + expected);
		}

		patrolVehicleInspectionPage.clickLightsCheck();
		List<String> expectedLightValues = Arrays.asList("Head Lights", "Tail Lights", "Brake Lights", "Flash Lights",
				"Spot Lights", "O/V Lights");
		List<String> actualLightValues = patrolVehicleInspectionPage.getLightsCheckValues();

		for (String expected : expectedLightValues) {
			softAssert.assertTrue(actualLightValues.contains(expected), "Missing light check value: " + expected);
		}

		patrolVehicleInspectionPage.clickEquipmentCheck();
		List<String> expectedEquipmentValues = Arrays.asList("Vehicle Jack", "Fire Extinguisher", "First Aid Kit",
				"Road Flares");
		List<String> actualEquipmentValues = patrolVehicleInspectionPage.getEquipmentCheckValues();

		for (String expected : expectedEquipmentValues) {
			softAssert.assertTrue(actualEquipmentValues.contains(expected),
					"Missing equipment check value: " + expected);
		}

		patrolVehicleInspectionPage.clickDamageCheck();
		List<String> expectedDamageValues = Arrays.asList("Old Interior Damage", "Old Exterior Damage",
				"New Interior Damage", "New Exterior Damage");
		List<String> actualDamageValues = patrolVehicleInspectionPage.getDamageCheckValues();

		for (String expected : expectedDamageValues) {
			softAssert.assertTrue(actualDamageValues.contains(expected), "Missing damage check value: " + expected);
		}

		patrolVehicleInspectionPage.fillFluidsAdded("10", "12", "14");
		patrolVehicleInspectionPage.fillDamageDescription("Old Test Damage Description", "New Test Damage Description");
		patrolVehicleInspectionPage.fillProblems("Tire Test Problems", "Light Test Problems",
				"Equipment Test Problems");
		patrolVehicleInspectionPage.uploadFrontImage("./src/test/resource/testdata/image.jpeg");
		patrolVehicleInspectionPage.uploadBackImage("./src/test/resource/testdata/image.jpeg");
		patrolVehicleInspectionPage.clickCompleteVehicleInspection();
		Thread.sleep(7000);
		System.out.println("✅ Patrol Vehicle Inspection completed");
		

		softAssert.assertAll();
	}

}
