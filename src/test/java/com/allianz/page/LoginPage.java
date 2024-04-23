package com.allianz.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	public static void enterUsername(WebDriver driver,String username)
	{
		driver.findElement(By.name("username")).sendKeys(username);
	}
	public static void enterpassword(WebDriver driver,String password)
	{
		driver.findElement(By.name("password")).sendKeys(password);
	}
	public static void clickonlogin(WebDriver driver)
	{
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

}
