package com.dits.citywide.utilities;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestCaseGenerator {

    private static final String SYSTEM_PROMPT =
        "You are a Senior QA Automation Engineer expert in Java Selenium.\n" +
        "When given a page or feature description, generate Java Selenium test cases using:\n" +
        "- TestNG @Test annotations\n" +
        "- WebDriverWait for explicit waits (never Thread.sleep)\n" +
        "- Page Object pattern with a simple inner Page class\n" +
        "- Meaningful test method names like: should_showError_when_passwordIsEmpty\n" +
        "- Both positive (happy path) AND negative (error) test scenarios\n" +
        "- By.id, By.xpath, By.cssSelector for locators\n\n" +
        "Return ONLY the Java code. No explanation. No markdown code fences.";

    private final ClaudeApiClient claude;

    public TestCaseGenerator() {
        this.claude = new ClaudeApiClient();
    }

    /**
     * Generate test cases from a plain English feature description.
     *
     * @param featureDescription  e.g. "Login page with email, password, submit button"
     * @return  Java test class as a String — ready to save and run
     */
    public String generateTests(String featureDescription) throws IOException {
        String prompt =
            "Generate Selenium Java TestNG test cases for this feature:\n\n"
            + featureDescription;
        return claude.ask(SYSTEM_PROMPT, prompt);
    }

    /**
     * Generate tests reusing your existing locators.
     *
     * @param featureDescription  Plain English page/feature description
     * @param existingLocators    Your existing XPath/CSS locators, one per line
     * @return  Java test class using your locators
     */
    public String generateTestsWithLocators(String featureDescription,
                                            String existingLocators) throws IOException {
        String prompt =
            "Feature description:\n" + featureDescription + "\n\n" +
            "Use ONLY these existing locators — do not create new ones:\n" +
            existingLocators;
        return claude.ask(SYSTEM_PROMPT, prompt);
    }

    /**
     * Saves the generated test code to a .java file.
     *
     * @param code      The generated Java code string
     * @param filePath  Where to save, e.g. "src/test/java/com/dits/citywide/tests/LoginTest.java"
     */
    public void saveToFile(String code, String filePath) throws IOException {
        Files.createDirectories(Paths.get(filePath).getParent());
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(code);
        }
        System.out.println("✅ Test file saved: " + filePath);
    }

    // ── Quick test — run this as Java Application to verify everything works ──

    public static void main(String[] args) throws IOException {

        System.out.println("🤖 Connecting to Claude API...\n");

        TestCaseGenerator generator = new TestCaseGenerator();

        // ── Example 1: Simple feature description ──────────────────────────
        String loginTests = generator.generateTests(
            "Login page with:\n" +
            "- Email input field  (id='email')\n" +
            "- Password input field (id='password')\n" +
            "- Submit button (id='login-btn')\n" +
            "- Valid credentials redirect to /dashboard\n" +
            "- Invalid credentials show error: 'Invalid email or password'\n" +
            "- Empty fields show validation: 'This field is required'"
        );

        System.out.println("✅ Generated Login Tests:\n");
        System.out.println(loginTests);

        // Save to your project
        generator.saveToFile(loginTests,
            "src/test/java/com/dits/citywide/tests/LoginTest.java");

        // ── Example 2: With your own existing locators ─────────────────────
        String searchTests = generator.generateTestsWithLocators(
            "Product search page with search input and results grid",
            "searchInput : //input[@data-qa='search-input']\n" +
            "searchButton: //button[@data-qa='search-btn']\n" +
            "resultGrid  : //div[@class='product-grid']\n" +
            "noResults   : //p[@class='no-results-msg']"
        );

        System.out.println("\n✅ Generated Search Tests:\n");
        System.out.println(searchTests);

        generator.saveToFile(searchTests,
            "src/test/java/com/dits/citywide/tests/SearchTest.java");
    }
}