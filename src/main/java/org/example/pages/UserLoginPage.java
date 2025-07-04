package org.example.pages;

import org.openqa.selenium.WebDriver;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UserLoginPage {


WebDriver driver;
    WebDriverWait wait;

    public UserLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @FindBy(xpath=" //div[@class='flex items-center justify-between space-x-2 md:space-x-4']//a")
    WebElement loginButton;

     @FindBy(xpath="//input[@id='phoneNumber']")
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
        loginButton.click();
    }

    public void login(String user, String pass) {
        clickLogin();
        enterUsername(user);
        enterPassword(pass);
        clickLogin();
        clickSubmit();
    }
}

