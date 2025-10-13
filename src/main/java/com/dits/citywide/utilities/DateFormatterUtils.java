package com.dits.citywide.utilities;

public class DateFormatterUtils {

	public static String[] splitDateToMonthDayYear(String dateText) {
		if (dateText == null || !dateText.matches("\\d{2}/\\d{2}/\\d{4}")) {
			return new String[] { "", "", "" };
		}

		String[] parts = dateText.split("/"); // [MM, dd, yyyy]
		String monthName = getMonthName(parts[0]);

		return new String[] { monthName, parts[1], parts[2] };
	}

	private static String getMonthName(String monthNumber) {
		switch (monthNumber) {
		case "01":
			return "Jan";
		case "02":
			return "Feb";
		case "03":
			return "Mar";
		case "04":
			return "Apr";
		case "05":
			return "May";
		case "06":
			return "Jun";
		case "07":
			return "Jul";
		case "08":
			return "Aug";
		case "09":
			return "Sep";
		case "10":
			return "Oct";
		case "11":
			return "Nov";
		case "12":
			return "Dec";
		default:
			return "";
		}
	}

	public static String getMonthNumber(String monthName) {
		if (monthName == null)
			return "";

		switch (monthName.toLowerCase()) {
		case "jan":
			return "01";
		case "feb":
			return "02";
		case "mar":
			return "03";
		case "apr":
			return "04";
		case "may":
			return "05";
		case "jun":
			return "06";
		case "jul":
			return "07";
		case "aug":
			return "08";
		case "sep":
			return "09";
		case "oct":
			return "10";
		case "nov":
			return "11";
		case "dec":
			return "12";
		default:
			return "";
		}
	}
}
