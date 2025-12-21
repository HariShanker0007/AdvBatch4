package pracTcs;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportDemo {
	@Test
	public void demoReport() {

		// Spark report Config
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report.html");
		spark.config().setDocumentTitle("CRM Test Suite Result");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);

		// Add Env Info & Create Test
		ExtentReports report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "WINDOWS-10");
		report.setSystemInfo("BROWSER", "CHROME-144");

		// Config Report Status
		ExtentTest test = report.createTest("demoReport");
		test.log(Status.INFO, "Login to APP");
		test.log(Status.INFO, "Navigate to Contact Page");
		test.log(Status.INFO, "Create Contact");

		if ("HDFC".equals("HDFC")) {
			test.log(Status.PASS, "=== CONTACT created Successfully =====");
		} else {
			test.log(Status.FAIL, "=== CONTACT creation Failed =====");
		}
		report.flush();
		System.out.println("=== EXECUTION SUCCESSFULL ===");
	}
}
