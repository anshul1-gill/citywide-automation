package com.dits.citywide.utilities;

public class StringUtils {

	public static String convertToCamelCase(String text) {
		String[] words = text.split("\\s+");
		StringBuilder camelCaseText = new StringBuilder();

		for (int i = 0; i < words.length; i++) {
			String word = words[i];

			if (word.length() > 0) {
				camelCaseText.append(word.substring(0, 1).toUpperCase());
				camelCaseText.append(word.substring(1).toLowerCase());
			}

			if (i < words.length - 1) {
				camelCaseText.append(" ");
			}
		}

		return camelCaseText.toString();
	}

}
