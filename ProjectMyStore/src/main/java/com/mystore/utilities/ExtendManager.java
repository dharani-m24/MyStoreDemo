package com.mystore.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendManager {

	public static ExtentSparkReporter sparkReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public static void setExtend() {
		
		sparkReporter =new ExtentSparkReporter(System.getProperty("user.dir")+"//ExtendReport//report.html");
		sparkReporter.config().setDocumentTitle("Automation Testing for MyStore");
		sparkReporter.config().setReportName("Functional Testing");
		
		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);
	}
	
	
}
