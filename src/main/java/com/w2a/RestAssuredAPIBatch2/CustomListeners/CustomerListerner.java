package com.w2a.RestAssuredAPIBatch2.CustomListeners;

import java.util.Arrays;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.w2a.RestAssuredAPIBatch2.Setup.TestSetup;

public class CustomerListerner extends TestSetup implements ITestListener, ISuiteListener {

	public void onTestStart(ITestResult result) {

		ExtentTest child = classLevelLogger.get().createNode(result.getName());
		testLevelLogger.set(child);
		
	}

	public void onTestSuccess(ITestResult result) {
		testLogger().pass("This test case got passed");
		extent.flush();
		
	}

	public void onTestFailure(ITestResult result) {
		
		String excepionMessage = Arrays.toString(result.getThrowable().getStackTrace());
		testLogger()
				.fail("<details>" + "<summary>" + "<b>" + "<font color=" + "red>" + "Exception Occured:Click to see"
						+ "</font>" + "</b >" + "</summary>" + excepionMessage.replaceAll(",", "<br>") + "</details>"
						+ " \n");


		String failureLogg = "This Test case got Failed";
		Markup m = MarkupHelper.createLabel(failureLogg, ExtentColor.RED);
		testLogger().log(Status.FAIL, m);
		
		extent.flush();
	}

	public void onTestSkipped(ITestResult result) {
		testLogger().skip("This test case got skipped");
		extent.flush();
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		
	}

}
