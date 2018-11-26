package com.logigear.reportportal;

import java.io.File;
import java.util.Date;
import java.util.UUID;

import org.testng.ISuite;
import org.testng.ITestResult;

import com.epam.reportportal.service.ReportPortal;
import com.epam.reportportal.testng.BaseTestNGListener;
import com.logigear.driver.DriverUtils;

public class ReportPortalListener extends BaseTestNGListener {

	public ReportPortalListener() {
		super(new CusctomTestNgService());
	}

	@Override
	public void onExecutionStart() {

		// TODO Auto-generated method stub
		super.onExecutionStart();
	}

	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		super.onStart(suite);
	}

	@Override
	public void beforeConfiguration(ITestResult testResult) {
		// TODO Auto-generated method stub
		super.beforeConfiguration(testResult);
	}

	@Override
	public void onTestFailure(ITestResult testResult) {
		String path = DriverUtils.captureScreenshot(UUID.randomUUID().toString(), "screenshots");
		ReportPortal.emitLog("", "info", new Date(), new File(path));
		super.onTestFailure(testResult);
	}

}
