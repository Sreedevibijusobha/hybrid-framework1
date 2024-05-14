package com.allianz.test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ZDemo3ExcelTest {
	public static void main(String[] args) {
		
		ExtentReports extent= new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
		extent.attachReporter(spark);
		
		ExtentTest test=extent.createTest("MyFirstTest123");
		
		
	}

}
