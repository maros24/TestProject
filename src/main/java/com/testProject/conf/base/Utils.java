package com.testProject.conf.base;


import com.github.javafaker.Faker;
import org.openqa.selenium.*;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utils extends BaseTest {

//    protected static String generateRandomEmail() {
//        String allowedChars = "abcdefghijklmnopqrstuvwxyz" + "1234567890" + "_-.";
//        String temp = RandomStringUtils.random(10, allowedChars);
//        return temp.substring(0, temp.length() - 9) + "@test.com";
//    }

    //I prefer this method for email generating
    public static String getRandomEmail() {
        Faker faker = new Faker();
        return faker.internet().emailAddress();
    }

    public static void waitForElement(WebDriver driver, WebElement element, int timeOutInSeconds) {
          new FluentWait<>(driver)
                  .withTimeout(Duration.ofSeconds(timeOutInSeconds))
                  .pollingEvery(Duration.ofMillis(200))
                  .ignoring(StaleElementReferenceException.class, NoSuchElementException.class)
                  .until(ExpectedConditions.visibilityOf(element));
    }

    protected void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
