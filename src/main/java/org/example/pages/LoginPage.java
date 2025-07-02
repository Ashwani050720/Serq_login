package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
//    private WebDriver driver;
//
//    WebDriverWait wait;
//
//    public LoginPage(WebDriver driver) {
//        this.driver = driver;
//        PageFactory.initElements(driver, this);
//        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//    }
//
//
//
//    @FindBy(xpath="//input[@id='phoneNumber']")
//    private WebElement usernameField;
//
//    @FindBy(xpath = "//input[@id='password']")
//    private WebElement passwordField;
//
//    @FindBy(xpath = "//button[@type='submit']")
//    private WebElement loginBtn;
//
//    public LoginPage(WebDriver driver) {
//        this.driver = driver;
//        PageFactory.initElements(driver, this);
//    }
//
//    public void enterUsername(String username) {
//        usernameField.clear();
//        usernameField.sendKeys(username);
//    }
//
//    public void enterPassword(String password) {
//        passwordField.clear();
//        passwordField.sendKeys(password);
//    }
//
//    public void clickLogin() {
//        loginBtn.click();
//    }
//
//    public void login(String username, String password) {
//        enterUsername(username);
//        enterPassword(password);
//        clickLogin();
//    }
//
//    public String getLoginPageTitle() {
//        return driver.getTitle();
//    }
WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


     @FindBy(xpath="//input[@id='phoneNumber']")
     WebElement usernameInput;

    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;

    // Actions
    public void enterUsername(String username) {
        wait.until(ExpectedConditions.visibilityOf(usernameInput));
        usernameInput.sendKeys(username);

    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordInput));
        passwordInput.sendKeys(password);
    }

    public void clickLogin() {
        loginButton.click();
    }

    public void login(String user, String pass) {
        enterUsername(user);
        enterPassword(pass);
        clickLogin();
    }
}

