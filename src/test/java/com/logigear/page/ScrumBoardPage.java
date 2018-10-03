package com.logigear.page;

import com.logigear.driver.DriverUtils;

public class ScrumBoardPage {

	public boolean isAt() {
		return DriverUtils.getTitle().equals("Scrum Board 1");
	}
}
