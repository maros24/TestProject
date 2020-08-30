package com.testProject.tests;

import com.testProject.conf.base.Utils;
import com.testProject.conf.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest extends Utils {
    @Test
    public void logInTest() {
        //create email
            String email = getRandomEmail();

        //open login page and enter the email
            LoginPage loginPage = new LoginPage(driver, log);
            loginPage.openLoginPage();
        long startTime = System.nanoTime();
            loginPage.getEmailField().sendKeys(email);
            loginPage.getLoginButton().submit();

        //wait for page loading
            sleep(1000); //due to unexpected issue with IE parallel testing I had to use this sleep
            waitForElement(driver, loginPage.getRegisterButton(),10);

        long stopTime = System.nanoTime();
        log.info("Used email: "+email);
        log.info("Time measure for steps: "+TimeUnit.NANOSECONDS.toMillis(stopTime - startTime));

        //check if new fields appear
            Assert.assertTrue(loginPage.getNameField().isDisplayed());
            Assert.assertTrue(loginPage.getPasswordField().isDisplayed());
    }
}
