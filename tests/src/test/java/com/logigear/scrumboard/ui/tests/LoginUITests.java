package com.logigear.scrumboard.ui.tests;

import com.logigear.scrumboard.page.LoginPage;
import com.logigear.utils.GalenTestBase;
import static java.util.Arrays.asList;

import java.io.IOException;

import org.testng.annotations.Test;

public class LoginUITests extends GalenTestBase {

	private LoginPage loginPage = new LoginPage();

	@Test(groups = { "ui" })
	public void TC001_LoginUI() throws IOException {
		loginPage.openLoginPage();
		checkLayout("src/test/resources/galen/loginPage.gspec", asList("desktop"));
	}
}
