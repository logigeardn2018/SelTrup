package com.logigear.scrumboard.page;

import org.openqa.selenium.By;

import com.logigear.driver.DriverUtils;

public class HomePage {
	private By welcome = By.id("divWelcome");
	private By btnNewStory = By.id("btnCreate");
	private By btnCreate = By.xpath("//button[span[text()='Create']]");
	private By titleRequiredMessage = By.xpath("//span[text()='Title is required']");

	public boolean isWelcomeMessageDisplayed() {
		return DriverUtils.isElementDisplayed(welcome);
	}

	public boolean isNewStoryButtonDisplayed() {
		return DriverUtils.isElementDisplayed(btnNewStory);
	}

	public void openNewStoryDialog() {
		DriverUtils.click(btnNewStory);
	}

	public void submitStoryForm() {
		DriverUtils.click(btnCreate);
	}

	public boolean isTitleRequiredMessageDisplayed() {
		return DriverUtils.isElementDisplayed(titleRequiredMessage);
	}

}
