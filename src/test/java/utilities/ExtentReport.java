package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {

	static ExtentReports extent;
	
	public static ExtentReports Report() {
		
		try {
		String repName="Test-Report-"+"First test case"+".html";
		String path = System.getProperty("user.dir")+ "/test-output/"+repName;
		System.out.println(path);
		
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Extent Reports");
		reporter.config().setDocumentTitle("Automation Report");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Nikita Chaudhari", "QA");
		
		return extent;
		}
		catch(Exception e) {
			return extent;
		}
	}
}
