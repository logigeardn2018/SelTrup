package com.logigear.page;

import org.openqa.selenium.By;

import com.logigear.driver.DriverUtils;

public class LoginPage {

	private By userNameTextBox = By.id("txtUserName");
	private By passwordTextBox = By.id("txtPassword");
	private By loginButton = By.id("btnLogin");

	public void login(String user, String pwd) {
		DriverUtils.enter(userNameTextBox, user);
		DriverUtils.enter(passwordTextBox, pwd);
		DriverUtils.click(loginButton);
	}
}
