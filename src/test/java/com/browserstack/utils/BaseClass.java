package com.browserstack.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.URL;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Random;

public class BaseClass {
    public WebDriver driver;
    public Wait<WebDriver> fluentWait;

    public String contactTestUrl = "https://automationexercise.com";
    public String emailAddress = "test" + getRandomNumber() + "@testemail" + getRandomNumber() + ".com";
    public String loginTestUrl = "https://practicetestautomation.com/practice-test-login/";
    public String loggedInUrlSnippet = "logged-in-successfully";
    public String username = "student";
    public String password = "Password123";
    public String wrongUsername = "wrong-student";
    public String wrongPassword = "Password456";
    public String invalidUserMessage = "Your username is invalid!";
    public String invalidPasswordMessage = "Your password is invalid!";

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        driver = new RemoteWebDriver(
                new URL("https://hub.browserstack.com/wd/hub"), capabilities);

        driver.manage().window().maximize();

        fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
    }



    public int getRandomNumber() {
        Random rnd = new Random();
        return rnd.nextInt(10000, 99999);
    }
}
