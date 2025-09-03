package generic_Utility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImplementation implements ITestListener{
	
	ExtentReports report;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println("---Started---");
		test = report.createTest(methodname);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println("---Passed---");
		test.log(Status.PASS,methodname +" ---Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println("---Failed---");
		test.log(Status.FAIL, methodname +" ---Failed");
		test.log(Status.INFO, result.getThrowable());
		WebDriverUtility wutil = new WebDriverUtility();
		JavaUtility jutil = new JavaUtility();
		String screenshotname = methodname+"-"+jutil.toGetSystemDateAndTime();
		try {
			String path = wutil.toTakeScreenshot(BaseClass.sDriver, screenshotname);
			test.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println("---Skipped---");
		test.log(Status.SKIP, methodname +" ---Skipped");
		test.log(Status.INFO, result.getThrowable());
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("---Suite Execution Started---");
		
		//extentsSparkReporter class- for setting path and design
		
		ExtentSparkReporter htmlReport = new ExtentSparkReporter(
				"./ExtentReports/Reports "+new JavaUtility().toGetSystemDateAndTime()+".html");
		htmlReport.config().setDocumentTitle("Vtiger Execution Report");
		htmlReport.config().setTheme(Theme.STANDARD);
		htmlReport.config().setReportName("VTIGER EXECUTION REPORT");
		
		// ExtentReport class
		
		report = new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("url", "http://localhost:8888");
		report.setSystemInfo("Base Browser ", "Chrome");
		report.setSystemInfo("UserName", "admin");
		report.setSystemInfo("Password", "password");
		report.setSystemInfo("Reporter Name", "Naveen PM");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("---Suite Execution Finished---");
		report.flush();
	}
	

}
