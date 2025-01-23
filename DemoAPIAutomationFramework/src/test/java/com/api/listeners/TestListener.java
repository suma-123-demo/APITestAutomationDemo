package com.api.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener  {
	
	private static final Logger logger = LogManager.getLogger(TestListener.class);
	
	public void onStart(ITestContext context) {
     logger.info("Test Suite started!!");
	  }

	public void onFinish(ITestContext context) {
		logger.info("Test Suite completed!!");
	  }
	
	public  void onTestStart(ITestResult result) {
		logger.info("started!"+ result.getMethod().getMethodName());
		logger.info("description"+result.getMethod().getDescription());
	  }
	
	public void onTestSuccess(ITestResult result) {
		logger.info("passed!"+ result.getMethod().getMethodName());
		logger.info("description"+result.getMethod().getDescription());

	  }

	public void onTestFailure(ITestResult result) {
		logger.error("Failed!"+ result.getMethod().getMethodName());

	  }
	
	public void onTestSkipped(ITestResult result) {
		logger.info("skipped!"+ result.getMethod().getMethodName());
	  }
}
