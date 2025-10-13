package com.dits.citywide.utilities;

public class NormalizePhoneNumber {

	public static String normalizePhoneNumber(String phoneNumber) {
		return phoneNumber.replaceAll("[^+\\d]", ""); // Keeps digits and '+' only
	}

}
