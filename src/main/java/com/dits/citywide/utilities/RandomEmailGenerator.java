package com.dits.citywide.utilities;

import java.util.Random;

public class RandomEmailGenerator {

	public static String generateRandomEmailForUser() {
		String name = "userautomation";
		String domain = "ditstek.com";
		StringBuilder email = new StringBuilder();
		Random random = new Random();

		int randomNum = random.nextInt(1000);

		email.append(name);
		email.append(System.currentTimeMillis());
		email.append(randomNum);
		email.append("@").append(domain);

		return email.toString();
	}

}
