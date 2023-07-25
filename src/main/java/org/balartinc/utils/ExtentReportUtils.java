package org.balartinc.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportUtils {
    ExtentHtmlReporter extentHtmlReporter;
    ExtentReports extentReports;
    ExtentTest extentTest;

    public ExtentReportUtils(String fileName) {
        extentHtmlReporter = new ExtentHtmlReporter(fileName);
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentHtmlReporter);
    }

    public void createTestCase(String testCaseName) {
        extentTest = extentReports.createTest(testCaseName);
    }

    public void addLog(Status status, String comments) {
        extentTest.log(status, comments);
    }

    public void closeReports() {
        extentReports.flush();
    }
}
