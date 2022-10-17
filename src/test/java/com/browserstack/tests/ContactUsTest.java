package com.browserstack.tests;

import com.browserstack.utils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactUsTest extends BaseClass {

    @Test
    public void fillContactForm() throws Exception {
        driver.get(contactTestUrl);

        WebElement contactUsMenuElement = fluentWait.until(webDriver -> driver.findElement(By.xpath("//a[@href='/contact_us']")));
        contactUsMenuElement.click();

        WebElement nameField = fluentWait.until(webDriver -> driver.findElement(By.name("name")));
        nameField.sendKeys("FirstName LastName");

        WebElement emailAddressField = driver.findElement(By.name("email"));
        emailAddressField.sendKeys(emailAddress);

        WebElement subjectField = driver.findElement(By.name("subject"));
        subjectField.sendKeys("Subject");

        WebElement messageField = driver.findElement(By.id("message"));
        messageField.sendKeys("Message Text");

        WebElement submitButtonElement = driver.findElement(By.name("submit"));
        submitButtonElement.click();

        driver.switchTo().alert().accept();

        Assert.assertTrue(fluentWait.until(webDriver -> driver.findElement(By.xpath("//div[@class='status alert alert-success']")).isDisplayed()));
    }

}
