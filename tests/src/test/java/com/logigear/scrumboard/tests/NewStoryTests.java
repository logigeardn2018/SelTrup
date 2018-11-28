package com.logigear.scrumboard.tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.logigear.scrumboard.page.HomePage;
import com.logigear.scrumboard.page.LoginPage;
import com.logigear.utils.Constants;
import com.logigear.utils.TestBase;

public class NewStoryTests extends TestBase {

	@BeforeClass
	public void pre() {
		loginPage.login(Constants.USER, Constants.PWD);
	}

	@Test(groups = { "smoke" }, description = "New Story button displays on Home Page")
	public void TC001_NewStoryButton() {
		assertTrue(homePage.isNewStoryButtonDisplayed(), "New Story button displays on Home Page");
	}

	@Test(description = "Error message displays in case empty title")
	public void TC002_TitleFieldValidation() {
		homePage.openNewStoryDialog();
		homePage.submitStoryForm();
		assertTrue(homePage.isTitleRequiredMessageDisplayed(), "Error message displays in case empty title");
	}

	private LoginPage loginPage = new LoginPage();
	private HomePage homePage = new HomePage();
}
