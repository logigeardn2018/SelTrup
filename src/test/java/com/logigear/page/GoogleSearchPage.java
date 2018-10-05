package com.logigear.page;

import com.logigear.driver.DriverUtils;

public class GoogleSearchPage {

	public boolean isAt(String title) {
		return DriverUtils.getTitle().contains(title);
	}
}
