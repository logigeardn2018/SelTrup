package com.logigear.utils;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.logigear.driver.DriverUtils;

public class TestBase {

	@BeforeClass(alwaysRun = true)
	public void setup() {
		DriverUtils.openLoginScrumBoard();
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		DriverUtils.quitBrowser();
	}
}
