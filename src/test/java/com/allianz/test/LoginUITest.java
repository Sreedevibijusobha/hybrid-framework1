package com.allianz.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.allianz.base.AutomationWrapper;



public class LoginUITest extends AutomationWrapper{

	@Test
	
	public void titleTest()
	{
		WebDriver driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		 driver.get("https://opensource-demo.orangehrmlive.com/web/index.php");
		String actualTitle=driver.getTitle();
		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle, "OrangeHRM");
		driver.quit();
		
	}
	@Test
	
public void applicationDescriptionTest()
{
		WebDriver driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		 driver.get("https://opensource-demo.orangehrmlive.com/web/index.php");
		 
		 String actualVersion = driver.findElement(By.xpath("//p[normalize-space()='OrangeHRM OS 5.6.1']")).getText();
		 System.out.println(actualVersion);
		 Assert.assertEquals(actualVersion, "OrangeHRM OS 5.6.1");
		 driver.quit();

}
}
