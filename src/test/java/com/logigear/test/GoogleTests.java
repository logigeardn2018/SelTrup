package com.logigear.test;

import static org.testng.Assert.assertTrue;

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
		assertTrue(true);
	}

	@Test(description = "User can go to home")
	public void TC004_GoToHome() {
		assertTrue(true);
	}
	
	@Test(description = "User can go to doodles")
	public void TC005_GoToDoodles() {
		assertTrue(true);
	}

	private GoogleSearchPage googleSearchPage = new GoogleSearchPage();
	private GoogleHomePage googleHomePage = new GoogleHomePage();
}
