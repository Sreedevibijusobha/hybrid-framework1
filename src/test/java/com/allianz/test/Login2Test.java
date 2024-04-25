package com.allianz.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.allianz.base.AutomationWrapper;
import com.allianz.page.DashboardPage;
import com.allianz.page.LoginPage;
import com.allianz.utils.DataUtils;

public class Login2Test extends AutomationWrapper{
		
	@Test(dataProvider="commonDataProvider",dataProviderClass=DataUtils.class)
	public void validLoginTest(String username, String password, String expectedHeader)
	{
		LoginPage Loginpage = new LoginPage(driver);
		Loginpage.enterUsername(driver,username);
		Loginpage.enterpassword(driver,password);
		Loginpage.clickonlogin(driver);
		
		DashboardPage DashboardPage = new DashboardPage(driver);
    String actualText=DashboardPage.getDashboardHeader();
	System.out.println("Text= "+actualText);
	Assert.assertEquals(actualText, expectedHeader);
	}
	
	
	@Test(dataProvider = "commonDataProvider",dataProviderClass=DataUtils.class)
	
	public void invalidLoginTest(String username, String password, String expectedError)
	{
		LoginPage Loginpage = new LoginPage(driver);
		Loginpage.enterUsername(driver,username);
		Loginpage.enterpassword(driver,password);
		Loginpage.clickonlogin(driver);
		String actualText=Loginpage.getInvalidErrorMesssage();
	System.out.println("Text= "+actualText);
	Assert.assertEquals(actualText, expectedError);
	}

}
