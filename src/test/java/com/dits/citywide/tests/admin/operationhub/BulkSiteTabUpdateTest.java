package com.dits.citywide.tests.admin.operationhub;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.dits.citywide.base.BaseTest;
import com.dits.citywide.pages.admin.ReactAdminAddNewSitePage;
import com.dits.citywide.utilities.ElementUtils;

/**
 * Bulk Site Tab Update — clicks Update on EVERY tab of EVERY site.
 *
 * HOW TO USE:
 * 1. Paste all site IDs into: src/test/resource/data/site_ids.csv (one ID per line)
 * 2. Set BASE_URL below to match your environment (stage/production)
 * 3. Run this test class
 *
 * SAFETY: No data is changed — only clicks existing Update buttons with current values.
 */
public class BulkSiteTabUpdateTest extends BaseTest {

    // ⚠️ CHANGE THIS for production vs stage
    private static final String BASE_URL = "https://stage.commandhubsolutions.com";
    private static final String SITE_EDIT_PATH = "/admin/sites/edit/";

    private ReactAdminAddNewSitePage sitePage;
    private List<String> siteIds;

    // Counters
    private int totalSites = 0;
    private int sitesCompleted = 0;
    private int sitesFailed = 0;
    private int totalTabsUpdated = 0;
    private int totalTabsSkipped = 0;
    private int totalTabsFailed = 0;

    @BeforeClass
    public void setupSiteIds() {
        siteIds = loadSiteIdsFromCsv();
        totalSites = siteIds.size();
        System.out.println("═══════════════════════════════════════════");
        System.out.println("🚀 BULK SITE TAB UPDATE");
        System.out.println("📊 Total sites to process: " + totalSites);
        System.out.println("🌐 Base URL: " + BASE_URL);
        System.out.println("═══════════════════════════════════════════");
    }

    @Test
    public void bulkUpdateAllSiteTabs() throws InterruptedException {
        // Login
        dashboardPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
        Thread.sleep(3000);

        ElementUtils elementUtils = new ElementUtils(driver);
        sitePage = new ReactAdminAddNewSitePage(driver, elementUtils);

        for (int idx = 0; idx < siteIds.size(); idx++) {
            String siteId = siteIds.get(idx).trim();
            if (siteId.isEmpty() || siteId.startsWith("#")) continue;

            System.out.println("\n═══════════════════════════════════════════");
            System.out.println("🏢 Site " + (idx + 1) + "/" + totalSites + " — ID: " + siteId);
            System.out.println("═══════════════════════════════════════════");

            try {
                String siteUrl = BASE_URL + SITE_EDIT_PATH + siteId;
                driver.get(siteUrl);
                Thread.sleep(3000);

                try {
                    WebDriverWait shortWait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
                    shortWait.until(ExpectedConditions.or(
                            ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@role='tab']")),
                            ExpectedConditions.urlContains("/sites/edit/")
                    ));
                } catch (Exception e) {
                    System.out.println("⚠️ Site " + siteId + " — Page did not load properly. Skipping.");
                    sitesFailed++;
                    continue;
                }

                // result = {tabsAttempted, tabsSucceeded, tabsSkipped, tabsFailed}
                int[] result = sitePage.clickUpdateOnAllTabs(siteId);
                totalTabsUpdated += result[1];
                totalTabsSkipped += result[2];
                totalTabsFailed += result[3];
                sitesCompleted++;

            } catch (Exception e) {
                sitesFailed++;
                System.out.println("❌ Site " + siteId + " — Error: " + e.getMessage());
            }
        }

        // Final Summary
        System.out.println("\n");
        System.out.println("═══════════════════════════════════════════════════");
        System.out.println("📊 BULK UPDATE COMPLETE — FINAL REPORT");
        System.out.println("═══════════════════════════════════════════════════");
        System.out.println("🏢 Total Sites:        " + totalSites);
        System.out.println("✅ Sites Completed:    " + sitesCompleted);
        System.out.println("❌ Sites Failed:       " + sitesFailed);
        System.out.println("📑 Total Tabs Updated:  " + totalTabsUpdated);
        System.out.println("⏭️ Total Tabs Skipped:  " + totalTabsSkipped);
        System.out.println("⚠️ Total Tabs Failed:   " + totalTabsFailed);
        System.out.println("═══════════════════════════════════════════════════");
    }

    /**
     * Reads site IDs from the CSV file (one ID per line).
     * Lines starting with # are treated as comments and skipped.
     */
    private List<String> loadSiteIdsFromCsv() {
        List<String> ids = new ArrayList<>();
        String filePath = System.getProperty("user.dir") + "/src/test/resource/data/site_ids.csv";
        File file = new File(filePath);
        System.out.println("📁 Reading site IDs from: " + file.getAbsolutePath());
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty() && !line.startsWith("#")) {
                    ids.add(line);
                }
            }
        } catch (Exception e) {
            System.out.println("❌ Failed to read site_ids.csv: " + e.getMessage());
            System.out.println("📁 Expected location: " + filePath);
        }
        return ids;
    }
}
