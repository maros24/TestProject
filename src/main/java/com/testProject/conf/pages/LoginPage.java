package com.testProject.conf.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	private static final By LOGIN_BUTTON = By.id("login-submit");
	private static final By EMAIL_FIELD = By.id("username");
	private static final By NAME_FIELD = By.id("displayName");
	private static final By PASSWORD_FIELD = By.id("password");
	private static final By REGISTER_BUTTON = By.className("css-t5emrf");
	private static final String LOGIN_URL = "https://id.atlassian.com/login";

	public WebElement getLoginButton(){ return find(LOGIN_BUTTON); }

	public WebElement getEmailField(){ return find(EMAIL_FIELD); }

	public WebElement getNameField(){ return find(NAME_FIELD); }

	public WebElement getPasswordField(){ return find(PASSWORD_FIELD); }

	public WebElement getRegisterButton(){ return find(REGISTER_BUTTON); }

	public void openLoginPage() { openUrl(LOGIN_URL); }

}
