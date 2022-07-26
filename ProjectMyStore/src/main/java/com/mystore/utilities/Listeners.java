package com.mystore.utilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.mystore.ActionDriver.Action;
import com.mystore.base.BaseClass;


public class Listeners extends ExtendManager implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test=extent.createTest(result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		if(result.getStatus()==ITestResult.SUCCESS) {
			test.log(Status.PASS, "Pass Test case is:"+result.getName());
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		if(result.getStatus()==ITestResult.FAILURE) {
			test.log(Status.FAIL, "Test Case failed is:"+ result.getName()); // to add name in extend report
			test.log(Status.FAIL, "Test Case failed is:"+ result.getThrowable()); //to add error /exception to extend report
			String screenshot;
			try {
				screenshot= Action.screenShot(BaseClass.driver, result.getName());
				test.addScreenCaptureFromPath(screenshot);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}

}
