package com.example.tests;

import org.example.pages.LoginPage;
import org.testng.annotations.Test;



public class LoginTest extends BaseTest {
//    @Test
//    public void testValidLogin() {
       // LoginPage loginPage = new LoginPage(driver);
//        loginPage.login(
//                prop.getProperty("username"),
//                prop.getProperty("password")
//        );

//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.login("Admin", "admin123"); // Replace with real test data
//
//        // You can add assertions here to verify successful login
//        System.out.println("Login test executed.");
        @Test
        public void loginWithValidCredentials() {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.login("9097397966", "test@123"); // Replace with real test data

            // You can add assertions here to verify successful login
            System.out.println("Login test executed.");
        }
    }
