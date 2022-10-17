package com.browserstack.tests;

import com.browserstack.utils.BaseClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseClass {

    @Test
    public void loginSuccessfully() throws Exception {
        driver.get(loginTestUrl);

        WebElement usernameField = driver.findElement(By.cssSelector("#username"));
        usernameField.sendKeys(username);

        WebElement passwordField = driver.findElement(By.cssSelector("#password"));
        passwordField.sendKeys(password);

        WebElement submitButton = driver.findElement(By.cssSelector("#submit"));
        submitButton.click();

        Assert.assertTrue(driver.getCurrentUrl().contains(loggedInUrlSnippet));
    }

    @Test
    public void wrongUsernameEntered() throws Exception {
        driver.get(loginTestUrl);

        WebElement usernameField = driver.findElement(By.cssSelector("#username"));
        usernameField.sendKeys(wrongUsername);

        WebElement passwordField = driver.findElement(By.cssSelector("#password"));
        passwordField.sendKeys(password);

        WebElement submitButton = driver.findElement(By.cssSelector("#submit"));
        submitButton.click();

        WebElement invalidUsernameElement = driver.findElement(By.cssSelector("#error"));
        Assert.assertTrue(invalidUsernameElement.isDisplayed());
        Assert.assertEquals(invalidUsernameElement.getText(), invalidUserMessage);
    }

    @Test
    public void wrongPasswordEntered() throws Exception {
        driver.get(loginTestUrl);

        WebElement usernameField = driver.findElement(By.cssSelector("#username"));
        usernameField.sendKeys(username);

        WebElement passwordField = driver.findElement(By.cssSelector("#password"));
        passwordField.sendKeys(wrongPassword);

        WebElement submitButton = driver.findElement(By.cssSelector("#submit"));
        submitButton.click();

        WebElement invalidUsernameElement = driver.findElement(By.cssSelector("#error"));
        Assert.assertTrue(invalidUsernameElement.isDisplayed());
        Assert.assertEquals(invalidUsernameElement.getText(), invalidPasswordMessage);
    }
}
