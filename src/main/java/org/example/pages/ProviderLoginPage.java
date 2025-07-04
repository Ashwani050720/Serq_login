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

public class ProviderLoginPage {

    WebDriver driver;
    WebDriverWait wait;

    public ProviderLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @FindBy(xpath=" //p[normalize-space()='Sign in with your phone and password']")
    WebElement loginButton;

    @FindBy(xpath="//input[@id='phone']")
    WebElement usernameInput;

    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitButton;

    // Actions
    public void enterUsername(String username) {
        wait.until(ExpectedConditions.visibilityOf(usernameInput));
        usernameInput.sendKeys(username);

    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordInput));
        passwordInput.sendKeys(password);
    }

    public void clickSubmit() {
        submitButton.click();
    }

    public void clickLogin() {
        WebElement loginHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//p[normalize-space()='Sign in with your phone and password']")));

        loginButton.click();
    }

    public void login(String user, String pass) {
        clickLogin();
        enterUsername(user);
        enterPassword(pass);
        clickSubmit();
    }
}

