package com.logigear.test;

import static org.testng.Assert.assertEquals;

import java.util.Random;

import org.testng.annotations.Test;

import com.logigear.utils.TestBase;

public class LogiGearTests extends TestBase {

	@Test(description = "Direct user to logigear home page")
	public void TC001_LogiGearHome() {
		Random random = new Random();
		int i = random.nextInt(2);
		assertEquals(1, i);
	}

	@Test(description = "User can search something")
	public void TC002_LogiGearSearch() {
		Random random = new Random();
		int i = random.nextInt(2);
		assertEquals(1, i);
	}

	@Test(description = "Refresh search results page")
	public void TC003_RefreshSearchResult() {
		Random random = new Random();
		int i = random.nextInt(2);
		assertEquals(1, i);
	}

	@Test(description = "User can go to home")
	public void TC004_GoToHome() {
		Random random = new Random();
		int i = random.nextInt(2);
		assertEquals(1, i);
	}
	
	@Test(description = "User can go to home")
	public void TC005_GoToHome() {
		Random random = new Random();
		int i = random.nextInt(2);
		assertEquals(1, i);
	}
}
