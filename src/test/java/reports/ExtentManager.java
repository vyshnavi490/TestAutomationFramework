package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import config.ConfigReader;
import config.Settings;
import utils.DateUtil;

public class ExtentManager {

	private static ExtentReports extent;

	public static ExtentReports createExtentReportInstance() {
		ConfigReader.load();
		String reportPath = System.getProperty("user.dir") + Settings.reportPath + "/" +"TestReport_"+DateUtil.generateDateString()
				+ ".html";
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter(reportPath);
		htmlReporter.config().setDocumentTitle("Selenium Java Framework");
		htmlReporter.config().setReportName("Test Suite");

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		return extent;
	}

}