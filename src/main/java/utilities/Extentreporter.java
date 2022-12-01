package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extentreporter {
	  static ExtentReports extentReport;
	public static ExtentReports   getExtentReport() {
		String path = System.getProperty("user.dir")+"\\reports\\extentreport.html";
		 ExtentSparkReporter repoter=new ExtentSparkReporter(path);
		repoter.config().setReportName("Tutorials ninja automation result");
		repoter.config().setDocumentTitle("Test Results");
		extentReport=new ExtentReports();
		extentReport.attachReporter(repoter);
		extentReport.setSystemInfo("operatingsystem","window8");
		extentReport.setSystemInfo("TestedBy","Arun motoori");
		return extentReport;
	}

}
