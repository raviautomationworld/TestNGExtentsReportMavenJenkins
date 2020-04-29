package hms.base;

import java.io.File;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentsManager {

	private static ExtentReports extent;
	private static ExtentHtmlReporter htmlReporter;

	public static ExtentReports createInstance() {
		// Initialize all extents report configurations here
		String fileName = getReportName();
		String directory = System.getProperty("user.dir") + "/reports/";
		new File(directory).mkdir();
		String path = directory + fileName;

		htmlReporter = new ExtentHtmlReporter(path);
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("Automation Reports");
		htmlReporter.config().setReportName("Automation Test Results");
		htmlReporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.setSystemInfo("Organization", "RaviAutomationLab");
		extent.setSystemInfo("Browser", "Chrome");
		extent.attachReporter(htmlReporter);

		return extent;
	}

	public static String getReportName() {
		Date d = new Date();
		String fileName = "AutomationReport" + "_" + d.toString().replace(":", "_").replace(" ", "_") + ".html";
		return fileName;
	}

}
