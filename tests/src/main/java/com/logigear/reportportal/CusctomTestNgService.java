package com.logigear.reportportal;

import java.util.Arrays;
import java.util.HashSet;

import org.testng.ITestResult;

import com.epam.reportportal.listeners.ListenerParameters;
import com.epam.reportportal.testng.TestNGService;
import com.epam.ta.reportportal.ws.model.FinishTestItemRQ;
import com.epam.ta.reportportal.ws.model.StartTestItemRQ;
import com.epam.ta.reportportal.ws.model.launch.StartLaunchRQ;

public class CusctomTestNgService extends TestNGService {

	
	@Override
	protected StartTestItemRQ buildStartStepRq(ITestResult testResult) {
		final StartTestItemRQ rq = super.buildStartStepRq(testResult);
		
		return rq;
	}
	@Override
	public void startConfiguration(ITestResult testResult) {
		// TODO Auto-generated method stub
		super.startConfiguration(testResult);
	}
	@Override
	protected FinishTestItemRQ buildFinishTestMethodRq(String status, ITestResult testResult) {
		FinishTestItemRQ finishTestItemRQ = super.buildFinishTestMethodRq(status, testResult);
		
		finishTestItemRQ.setDescription(testResult.getMethod().getDescription());
		// Set tags for test case based on TestNG group
		if (testResult.getMethod().getGroups().length > 0) {
			finishTestItemRQ.setTags(new HashSet<String>(Arrays.asList(testResult.getMethod().getGroups())));
		}
		
		return finishTestItemRQ;
	}
	
	@Override
	protected StartLaunchRQ buildStartLaunchRq(ListenerParameters parameters) {
		StartLaunchRQ rq = super.buildStartLaunchRq(parameters);
		

		return rq;
	}
	
	
	
}
