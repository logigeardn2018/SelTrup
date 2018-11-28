package com.logigear.scrumboard.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.logigear.scrumboard.page.HomePage;
import com.logigear.scrumboard.page.LoginPage;
import com.logigear.utils.Constants;
import com.logigear.utils.TestBase;

public class LoginTests extends TestBase {

	@Test(groups = { "smoke" }, description = "Username label displays on Login Page")
	public void TC001_UserNameLabel() {
		assertTrue(loginPage.isUserNameLabelDisplayed());
	}

	@Test(groups = { "smoke" }, description = "Password label displays on Login Page")
	public void TC002_PasswordLabel() {
		assertTrue(loginPage.isPasswordLabelDisplayed());
	}

	@Test(groups = { "smoke" }, description = "Error message displays in case invalid user name")
	public void TC003_InvalidUserName() {
		loginPage.login("invalid", "invalid");
		assertEquals(loginPage.getLoginErrorMessage(), "The username or password is incorrect.");
	}

	@Test(groups = { "smoke" }, description = "User logins successful")
	public void TC004_LoginSuccessful() {
		loginPage.login(Constants.USER, Constants.PWD);
		assertTrue(homePage.isWelcomeMessageDisplayed(), "Home page should be displayed");
	}

	private LoginPage loginPage = new LoginPage();
	private HomePage homePage = new HomePage();
}
