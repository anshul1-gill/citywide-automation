package com.dits.citywide.utilities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CurrentDateTimeUtils {

	/**
	 * Returns current date and time in MM/dd/yyyy HH:mm format Example: 09/02/2025
	 * 12:30
	 */
	public static String getCurrentDateTime() {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");
		return now.format(formatter);
	}

	public static void main(String[] args) {
		System.out.println("Current Date & Time: " + getCurrentDateTime());
	}

}
