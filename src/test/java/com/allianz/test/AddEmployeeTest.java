package com.allianz.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.allianz.base.AutomationWrapper;

public class AddEmployeeTest extends AutomationWrapper {
	@Test()
	
	public void validLoginTest()
	{

		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String actualText=driver.findElement(By.xpath("//h6[text()='Dashboard']")).getText();
		System.out.println("Text= "+actualText);
		Assert.assertEquals(actualText, "Dashboard");
		
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
		driver.findElement(By.xpath("//i[@class='oxd-icon bi-plus oxd-button-icon']")).click();
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\Administrator\\Downloads\\dummy.pdf");
		//upload pdf file
		
		String errorText=driver.findElement(By.xpath("//span[text()='File type not allowed']")).getText();
		System.out.println("Text= "+errorText);
		Assert.assertEquals(errorText, "File type not allowed");
	
	}

}
