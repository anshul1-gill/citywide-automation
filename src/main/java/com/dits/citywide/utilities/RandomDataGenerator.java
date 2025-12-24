package com.dits.citywide.utilities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class RandomDataGenerator {

    private static final Random random = new Random();
    private static final String[] FIRST_NAMES = { "John", "Jane", "Michael", "Sarah", "David", "Emily", "Robert",
            "Lisa", "James", "Mary" };
    private static final String[] LAST_NAMES = { "Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia", "Miller",
            "Davis", "Rodriguez", "Martinez" };

    /**
     * Generate a random first name
     */
    public static String generateFirstName() {
        return FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
    }

    /**
     * Generate a random last name
     */
    public static String generateLastName() {
        return LAST_NAMES[random.nextInt(LAST_NAMES.length)];
    }

    /**
     * Generate a random email address
     * Format: firstname.lastname.timestamp@testclient.com
     */
    public static String generateEmail(String firstName, String lastName) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        return firstName.toLowerCase() + "." + lastName.toLowerCase() + "." + timestamp + "@testclient.com";
    }

    /**
     * Generate a random badge ID
     * Format: CLS-YYYYMMDDHHMMSS
     */
    public static String generateBadgeId() {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        return "CLS-" + timestamp;
    }

    /**
     * Generate a random phone number
     * Format: 555XXXXXXX (10 digits)
     */
    public static String generatePhoneNumber() {
        int randomNumber = 1000000 + random.nextInt(9000000); // 7 digits
        return "555" + randomNumber;
    }

    /**
     * Generate a random number within a range
     */
    public static int generateRandomNumber(int min, int max) {
        return random.nextInt((max - min) + 1) + min;
    }
}
