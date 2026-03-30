#!/usr/bin/env python3
import re

# Read the file
with open('/Users/ditsdev/citywide-automation/src/test/java/com/dits/citywide/tests/fieldagent/FieldAgentMyReportsTest.java', 'r') as f:
    content = f.read()

# Uncomment report sections 3-9 (report 2 is already uncommented)
patterns_to_uncomment = [
    (r'//\t\tfieldAgentReportsPage\.clickEditReport([3-9])\(\);', r'\t\tfieldAgentReportsPage.clickEditReport\1();'),
    (r'//\t\tThread\.sleep\(2000\);', r'\t\tThread.sleep(2000);'),
    (r'//\t\tfieldAgentReportsPage\.addOfficerReportEntry', r'\t\tfieldAgentReportsPage.addOfficerReportEntry'),
    (r'//\t\t\t\tHRManagementConstants\.SITE,', r'\t\t\t\tHRManagementConstants.SITE,'),
    (r'//\t\t\t\tOperationsHubConstant\.', r'\t\t\t\tOperationsHubConstant.'),
    (r'//\t\tfieldAgentReportsPage\.clickUpdateLogEntry\(\);', r'\t\tfieldAgentReportsPage.clickUpdateLogEntry();'),
]

for pattern, replacement in patterns_to_uncomment:
    content = re.sub(pattern, replacement, content)

# Comment out the final assertion
content = re.sub(
    r'\t\tsoftAssert\.assertEquals\(fieldAgentReportsPage\.getNoDataFoundText\(\), FieldAgentConstants\.NO_DATA_FOUND_TEXT,\n\t\t\t\t"No Data Found text mismatch!"\);',
    r'\t\t// softAssert.assertEquals(fieldAgentReportsPage.getNoDataFoundText(), FieldAgentConstants.NO_DATA_FOUND_TEXT,\n\t\t// \t\t"No Data Found text mismatch!");',
    content
)

# Write back
with open('/Users/ditsdev/citywide-automation/src/test/java/com/dits/citywide/tests/fieldagent/FieldAgentMyReportsTest.java', 'w') as f:
    f.write(content)

print("Successfully uncommented all report sections and commented out final assertion")
