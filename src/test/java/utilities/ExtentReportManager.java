package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ExtentReportManager {
	private static ExtentReports extentReports;
	private static ExtentTest extentTest;
	private static ExtentSparkReporter htmlReporter;

	@Before
	public void setupExtentReport() {
		String reportName = "TestReport.html";
		String reportPath = "target/cucumber-reports";
		htmlReporter = new ExtentSparkReporter(reportPath + "/" + reportName);
		extentReports = new ExtentReports();
		extentReports.attachReporter(htmlReporter);
	}

	@After
	public void tearDownExtentReport(Scenario scenario) {
		if (scenario.isFailed()) {
			extentTest.log(Status.FAIL, "Test failed: " + scenario.getName());
		} else {
			extentTest.log(Status.PASS, "Test passed: " + scenario.getName());
		}
		extentReports.flush();
	}
}
