package com.example.tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.pages.UserLoginPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

public class UserLoginTest extends BaseTest {
    LoginData data;

    @BeforeClass
    public void setup() throws Exception {
        data = new ObjectMapper().readValue(new File("src/test/resources/userData.json"), LoginData.class);
    }

    @Test
    public void userLoginTest() {
        getTest().info("Navigating to: " + data.getUrl());
        driver.get(data.getUrl());

        getTest().info("Performing login...");

        UserLoginPage loginPage = new UserLoginPage(driver);
        loginPage.login(data.getUsername(), data.getPassword());

        getTest().info("Waiting for title...");
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.titleIs(data.getExpectedTitle()));

        Assert.assertEquals(driver.getTitle(), data.getExpectedTitle(), "Title does not match");
        getTest().pass("Title matched: " + data.getExpectedTitle());
    }

}

