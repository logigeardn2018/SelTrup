package com.logigear.test;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.logigear.page.GoogleHomePage;
import com.logigear.page.GoogleSearchPage;
import com.logigear.utils.TestBase;

public class GoogleSearchTest extends TestBase {

	@Test(groups = { "smoke" })
	public void TC001_UserCanDoTheSearching() {
		googleHomePage.search("LogiGear");
		assertTrue(googleSearchPage.isAt("LogiGear"));
	}

	@Test()
	public void TC002_SearchWithNumber() {
		assertTrue(true);
	}

	@Test(groups = { "smoke" })
	public void TC003_InvalidPassword() {
		assertTrue(true);
	}

	private GoogleSearchPage googleSearchPage = new GoogleSearchPage();
	private GoogleHomePage googleHomePage = new GoogleHomePage();
}
