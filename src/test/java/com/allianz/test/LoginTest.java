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
import com.allianz.utils.DataUtils;

public class LoginTest extends AutomationWrapper{
		
	@Test(dataProvider="commonDataProvider",dataProviderClass=DataUtils.class)
	public void validLoginTest(String username, String password, String expectedHeader)
	{
	driver.findElement(By.name("username")).sendKeys(username);
	driver.findElement(By.name("password")).sendKeys(password);
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	String actualText=driver.findElement(By.xpath("//h6[text()='Dashboard']")).getText();
	System.out.println("Text= "+actualText);
	Assert.assertEquals(actualText, expectedHeader);
	}
	
	/*
	
@DataProvider
	
	public Object[][] invalidData()
	{
		Object[][] data = new Object[2][3];
		
		data[0][0]="saul";
		data[0][1]="saul123";
		data[0][2]="Invalid credentials";
		
		data[1][0]="peter";
		data[1][1]="peter123";
		data[1][2]="Invalid credentials";

		
		return data;
	}  */
	

	@Test(dataProvider = "commonDataProvider",dataProviderClass=DataUtils.class)
	
	public void invalidLoginTest(String username, String password, String expectedError)
	{
	driver.findElement(By.name("username")).sendKeys(username);
	driver.findElement(By.name("password")).sendKeys(password);
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	String actualText=driver.findElement(By.xpath("//p[text()='Invalid credentials']")).getText();
	System.out.println("Text= "+actualText);
	Assert.assertEquals(actualText, expectedError);
	}

}
