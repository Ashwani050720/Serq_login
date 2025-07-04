package com.example.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import org.example.utils.DriverFactory;
import org.example.utils.ExtentReportManager;
import org.example.utils.ScreenshotUtil;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class BaseTest {
    protected WebDriver driver;
    protected static ExtentReports extent;
    protected static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @BeforeSuite
    public void startReport() {
        extent = ExtentReportManager.getInstance();
    }

    @AfterSuite
    public void flushReport() {
        extent.flush();
    }

    @BeforeMethod
    public void setUpTest(Method method) {
        driver = DriverFactory.initDriver();
        ExtentTest extentTest = extent.createTest(method.getName());
        test.set(extentTest);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.get().fail(result.getThrowable());

            // 📸 Capture and attach screenshot
            String screenshotPath = ScreenshotUtil.takeScreenshot(driver, result.getName());
            try {
                test.get().addScreenCaptureFromPath(screenshotPath);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.get().pass("Test Passed");
        } else {
            test.get().skip("Test Skipped");
        }

        if (driver != null) {
            driver.quit();
        }
    }

    public ExtentTest getTest() {
        return test.get();
    }
}
