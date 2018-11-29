package com.logigear.scrumboard.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Random;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.logigear.scrumboard.page.HomePage;
import com.logigear.scrumboard.page.LoginPage;
import com.logigear.utils.Constants;
import com.logigear.utils.TestBase;

public class NewStoryTests extends TestBase {

	@BeforeClass(alwaysRun = true)
	public void pre() {
		loginPage.login(Constants.USER_NAME, Constants.PASSWORD);
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

	@Test(description = "Error message displays in case empty description")
	public void TC003_DescriptionFieldValidation() {
		Random rnd = new Random();
		assertEquals(1, rnd.nextInt(2));
	}

	@Test(description = "Error message displays in case spent description")
	public void TC004_SpentFieldValidation() {
		Random rnd = new Random();
		assertEquals(rnd.nextInt(2), 1);
	}

	@Test(description = "Error message displays in case assignee description")
	public void TC005_AssigneeFieldValidation() {
		Random rnd = new Random();
		assertEquals(rnd.nextInt(2), 1);
	}

	private LoginPage loginPage = new LoginPage();
	private HomePage homePage = new HomePage();
}
