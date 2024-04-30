package com.allianz.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.allianz.base.AutomationWrapper;

public class LoginUITest extends AutomationWrapper {
	
	@Test(groups= {"ui","smoke"})
	public void titleTest()
	{
		String actualTitle=driver.getTitle();
		Assert.assertEquals(actualTitle, "OrangeHRM");
	}
	
	@Test(groups= {"ui"})
	public void applicationDescriptionTest()
	{
		String actualVersion=driver.findElement(By.xpath("//p[contains(normalize-space(),'OS')]")).getText();
		Assert.assertEquals(actualVersion, "OrangeHRM OS 5.6.1");
	}

}
