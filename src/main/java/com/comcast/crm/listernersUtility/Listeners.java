package com.comcast.crm.listernersUtility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.genricUtilities.BaseClass;

public class Listeners implements ITestListener, ISuiteListener {
	
	public  ExtentSparkReporter spark;
	public ExtentReports report;
	public ExtentTest test;

	@Override
	public void onStart(ISuite result) {

		Reporter.log("Report configuration", true);
		Date date=new Date(); 
		String newDate = date.toString().replace(" ","_").replace(":","_");
		spark= new ExtentSparkReporter("./AdvanceReport/report_"+newDate+".html");
		spark.config().setDocumentTitle("NinzaCRM Test Suite Results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "WINDOWS-10");
		report.setSystemInfo("BROWSER", "CHROME-143");
	}

	@Override
	public void onTestStart(ITestResult result) {
		test = report.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test = report.createTest(result.getMethod().getMethodName());
		test.log(Status.INFO, "=====" + result.getMethod().getMethodName() + "=== Execution STARTED ====");
		test.log(Status.PASS, "=====" + result.getMethod().getMethodName() + "=== Execution SUCCESSFULL ====");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test = report.createTest(result.getMethod().getMethodName());
		test.log(Status.SKIP, "=====" + result.getMethod().getMethodName() + "=== Execution SKIPPED ====");
	}

	@Override
	public void onTestFailure(ITestResult result) {

		String testName = result.getMethod().getMethodName();
		Date d = new Date();
		String newDate = d.toString().replace(" ", "_").replace(":", "_");

		TakesScreenshot ts = (TakesScreenshot) BaseClass.sdriver;
		String temp = ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(temp, testName + newDate);
		test.log(Status.FAIL, " ===" + testName + " FAILED ===");
	}

	@Override
	public void onFinish(ISuite result) {
		Reporter.log("REPORT BACKUP DONE", true);
		report.flush();
	}
}
