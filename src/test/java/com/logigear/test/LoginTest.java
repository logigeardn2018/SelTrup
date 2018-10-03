package com.logigear.test;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.logigear.page.LoginPage;
import com.logigear.page.ScrumBoardPage;
import com.logigear.utils.Constants;
import com.logigear.utils.TestBase;

public class LoginTest extends TestBase {

	@Test(groups = { "smoke" })
	public void TC001_UserCanLogin() {
		loginPage.login(Constants.USER, Constants.PWD);
		assertTrue(scrumBoardPage.isAt());
	}

	@Test()
	public void TC002_InvalidUser() {

	}

	private LoginPage loginPage = new LoginPage();
	private ScrumBoardPage scrumBoardPage = new ScrumBoardPage();
}
