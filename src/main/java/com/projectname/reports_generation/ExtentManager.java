package com.projectname.reports_generation;

import java.io.File;
import java.util.Date;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	public static ExtentReports reports;
	public static String screenshotFolderPath;
	public static String reportFolderPath;
	
	public static ExtentReports getReports() {
		if(reports == null) {
	       reports = new ExtentReports();
	
	Date d = new Date();
	String reportFolder = d.toString().replaceAll(":", "-") + "//screenshots";
	
	screenshotFolderPath = System.getProperty("user.dir") + "//reports//" + reportFolder;
	reportFolderPath = System.getProperty("user.dir") + "//reports//" + d.toString().replaceAll(":", "-");
	
    File f = new File(screenshotFolderPath);
    f.mkdirs();
	
	ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportFolderPath);
	sparkReporter.config().setReportName("Production Regression Testing");
	sparkReporter.config().setDocumentTitle("Automation Reports");
	sparkReporter.config().setTheme(Theme.DARK);
	sparkReporter.config().setEncoding("utf-8");
	
	reports.attachReporter(sparkReporter);

	}
		return reports;
}
	
}
