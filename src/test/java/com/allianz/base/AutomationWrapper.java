package com.allianz.base;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class AutomationWrapper {
	protected WebDriver driver;
	private ExtentReports extent;
	protected ExtentTest test;
	
	@BeforeSuite
	public void init()
	{
		if(extent==null)
		{
		extent= new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
		extent.attachReporter(spark);
		}
	}
  @AfterSuite
  public void end()
  {
	  extent.flush();
  }
	@BeforeMethod(alwaysRun = true)
	@Parameters({"browser"})
	public void setup(@Optional("Chrome")String browserName,Method mtd) {
		test=extent.createTest(mtd.getName());
		
		if(browserName.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}else if(browserName.equalsIgnoreCase("ff"))
		{
			driver = new FirefoxDriver();
		}else
		{
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php");
	}

	@AfterMethod
	public void teardown() {
		test.log(Status.FAIL, "This is a logging event for MuFirstTest23 and t passed");
		driver.quit();
	}
}
