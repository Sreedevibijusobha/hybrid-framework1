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
	public class LoginTest extends AutomationWrapper {
		@Test(dataProvider = "commonDataProvider", dataProviderClass = DataUtils.class)
		public void validLoginTest(String username, String password, String expectedHeader) {

			LoginPage loginPage = new LoginPage(driver);
			loginPage.enterUsername(username);
			loginPage.enterPassword(password);
			loginPage.clickOnLogin();

			DashboardPage dashboardPage=new DashboardPage(driver);
			String actualHeader = dashboardPage.getDashboardHeader();
			Assert.assertEquals(actualHeader, expectedHeader);
		}

		@Test(dataProvider = "commonDataProvider", dataProviderClass = DataUtils.class)
		public void invalidLoginTest(String username, String password, String expectedError) {
			LoginPage loginPage = new LoginPage(driver);
			loginPage.enterUsername(username);
			loginPage.enterPassword(password);
			loginPage.clickOnLogin();
			
			String actualError =loginPage.getInvalidErrorMessage();
			Assert.assertEquals(actualError, expectedError);
		}
	}
}
