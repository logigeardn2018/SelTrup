package com.logigear.scrumboard.page;

import org.openqa.selenium.By;

import com.logigear.driver.DriverUtils;

public class LoginPage {

	private By lblUsername = By.xpath("//td[normalize-space()='Email']");
	private By lblPassword = By.xpath("//td[normalize-space()='Password']");

	private By txtUserName = By.id("txtUserName");
	private By txtPassword = By.id("txtPassword");
	private By btnLogin = By.id("btnLogin");
	private By errMsg = By.id("errMsg");

	public boolean isUserNameLabelDisplayed() {
		return DriverUtils.isElementDisplayed(lblUsername);
	}

	public boolean isPasswordLabelDisplayed() {
		return DriverUtils.isElementDisplayed(lblPassword);
	}

	public void login(String username, String password) {
		DriverUtils.enter(txtUserName, username);
		DriverUtils.enter(txtPassword, password);
		DriverUtils.click(btnLogin);
	}

	public String getLoginErrorMessage() {
		return DriverUtils.getText(errMsg);
	}
}
