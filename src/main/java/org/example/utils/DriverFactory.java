package org.example.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory
{
//    public static WebDriver driver;
//
//    public static WebDriver initDriver(String browser) {
//        if (browser.equals("chrome")) {
//            driver = new ChromeDriver();
//        }
//        driver.manage().window().maximize();
//        return driver;
//    }
//
//    public static WebDriver getDriver() {
//        return driver;
//    }
public static WebDriver initDriver() {
    WebDriverManager.chromedriver().setup();

    ChromeOptions options = new ChromeOptions();
    options.addArguments("--headless");               // Run in headless mode
    options.addArguments("--disable-gpu");            // Recommended for Windows
    options.addArguments("--window-size=1920,1080");  // Set window size
    options.addArguments("--no-sandbox");             // Required for some environments
    options.addArguments("--disable-dev-shm-usage");
    return new ChromeDriver();
}
}
