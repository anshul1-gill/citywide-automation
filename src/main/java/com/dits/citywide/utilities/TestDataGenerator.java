package com.dits.citywide.utilities;

/**
 * Utility class for generating unique test data with timestamps
 * to prevent "already exists" errors in regression tests.
 * 
 * Usage:
 * String uniqueName = TestDataGenerator.addTimestamp("Vacation Leave");
 * // Output: "Vacation Leave 1735059522123"
 */
public class TestDataGenerator {

    /**
     * Adds a timestamp suffix to a base name to make it unique
     * 
     * @param baseName - The base name (e.g., "Vacation Leave")
     * @return Unique name with timestamp (e.g., "Vacation Leave 1735059522123")
     */
    public static String addTimestamp(String baseName) {
        return baseName + " " + System.currentTimeMillis();
    }

    /**
     * Adds a timestamp to a code/ID prefix to make it unique
     * 
     * @param prefix - The code prefix (e.g., "NP", "B0")
     * @return Unique code with timestamp (e.g., "NP1735059522123")
     */
    public static String addTimestampCode(String prefix) {
        return prefix + System.currentTimeMillis();
    }

    /**
     * Generates a unique name with a shorter timestamp (last 6 digits)
     * Useful when full timestamp is too long
     * 
     * @param baseName - The base name
     * @return Unique name with short timestamp
     */
    public static String addShortTimestamp(String baseName) {
        long timestamp = System.currentTimeMillis();
        String shortTimestamp = String.valueOf(timestamp).substring(7); // Last 6 digits
        return baseName + " " + shortTimestamp;
    }
}
