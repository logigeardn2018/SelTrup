package com.logigear.page;

import org.openqa.selenium.By;

import com.logigear.driver.DriverUtils;

public class GoogleHomePage {

	private By searchTextBox = By.name("q");
	private By googleSearchButton = By.name("btnK");

	public boolean isAt() {
		return DriverUtils.getTitle().equals("Google");
	}

	public void search(String keyword) {
		DriverUtils.enter(searchTextBox, keyword);
		DriverUtils.submit(googleSearchButton);
	}
}
