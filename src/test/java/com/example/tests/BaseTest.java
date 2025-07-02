package com.example.tests;

import org.example.utils.ConfigReader;
import org.example.utils.DriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.Properties;

public class BaseTest
{
    protected WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.initDriver();
        driver.manage().window().maximize();
        driver.get("https://user.serq.in/auth");

        new WebDriverWait(driver, Duration.ofSeconds(15)).until(
                webDriver -> ((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState").equals("complete")
        );
        // Replace with your login URL
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
     //       driver.quit();
        }
    }

}
