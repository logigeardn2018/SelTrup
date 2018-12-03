package com.logigear.utils;

import java.lang.reflect.Method;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import com.galenframework.reports.GalenTestInfo;
import com.galenframework.support.GalenJavaTestBase;
import com.galenframework.support.GalenReportsContainer;
import com.galenframework.testng.GalenTestNgReportsListener;
import com.logigear.driver.DriverUtils;

@Listeners(GalenTestNgReportsListener.class)
public class GalenTestBase extends GalenJavaTestBase {

	@Override
	public WebDriver createDriver(Object[] args) {
		return DriverUtils.openChrome();
	}

	@BeforeMethod(alwaysRun = true)
	public void initReport(Method method, Object[] arguments) {
		GalenTestInfo ti = createTestInfo(method, arguments);
		testInfo.set(ti);
		report.set(GalenReportsContainer.get().registerTest(ti));
	}

	@BeforeClass(alwaysRun = true)
	public void initDriver() {
		super.initDriver(null);
	}

	@AfterClass(alwaysRun = true)
	public void quitDriver() {
		super.quitDriver();
	}

	@AfterMethod
	public void provideTestEndDate() {
		GalenTestInfo ti = testInfo.get();
		if (ti != null) {
			ti.setEndedAt(new Date());
		}
	}
}
