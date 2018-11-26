package com.logigear.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Random;

import org.testng.annotations.Test;

import com.logigear.page.GoogleHomePage;
import com.logigear.page.GoogleSearchPage;
import com.logigear.utils.TestBase;

public class GoogleTests extends TestBase {

	@Test(groups = { "smoke" }, description = "Direct user to google home page")
	public void TC001_GoogleHome() {
		assertTrue(googleHomePage.isAt());

	}

	@Test(groups = { "smoke" }, description = "User can search something")
	public void TC002_GoogleSearch() {
		googleHomePage.search("LogiGear");
		assertTrue(googleSearchPage.isAt("LogiGear"));
	}

	@Test(description = "Refresh search results page")
	public void TC003_RefreshSearchResult() {
		Random random = new Random();
		int i = random.nextInt(2);
		assertEquals(1, i);
	}

	@Test(description = "User can go to home")
	public void TC004_GoToHome() {
		assertTrue(true);
	}

	private GoogleSearchPage googleSearchPage = new GoogleSearchPage();
	private GoogleHomePage googleHomePage = new GoogleHomePage();
}
