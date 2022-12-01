package Listener;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Resource.Basic;
import utilities.Extentreporter;

public class Listeners extends Basic implements ITestListener{
WebDriver driver=null;
ExtentReports extentreport=Extentreporter.getExtentReport();
ExtentTest etest;
ThreadLocal<ExtentTest> extentTestThread=new ThreadLocal<ExtentTest>();
	@Override
	public void onTestStart(ITestResult result) {
		String testName=result.getName();
		etest=extentreport.createTest(testName+"executed started");
		extentTestThread.set(etest);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testName=result.getName();
		//etest.log(Status.PASS,testName+"got passed");
		extentTestThread.get().log(Status.PASS,testName+"got passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		String testName=result.getName();
		//etest.fail(result.getThrowable());
		extentTestThread.get().fail(result.getThrowable());
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		}catch(Exception e) {
			e.printStackTrace();
		}try {
			String spath = (String) takescreenshot(testName,driver);
			extentTestThread.get().addScreenCaptureFromPath(spath,testName);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
		extentreport.flush();
	}

}
