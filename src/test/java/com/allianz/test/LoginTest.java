package com.allianz.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.allianz.base.AutomationWrapper;

public class LoginTest extends AutomationWrapper{
		
	@Test	
	public void validLoginTest()
	{
	driver.findElement(By.name("username")).sendKeys("Admin");
	driver.findElement(By.name("password")).sendKeys("admin123");
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	String actualText=driver.findElement(By.xpath("//h6[text()='Dashboard']")).getText();
	System.out.println("Text= "+actualText);
	Assert.assertEquals(actualText, "Dashboard");
	}
	@Test
	
	public void invalidLoginTest()
	{
	driver.findElement(By.name("username")).sendKeys("test");
	driver.findElement(By.name("password")).sendKeys("admin123");
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	String actualText=driver.findElement(By.xpath("//p[text()='Invalid credentials']")).getText();
	System.out.println("Text= "+actualText);
	Assert.assertEquals(actualText, "Invalid credentials");
	}

}
