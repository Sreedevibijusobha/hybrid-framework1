package com.allianz.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.allianz.base.WebDriverKeywords;

public class LoginPage extends WebDriverKeywords{
	private By usernameLocator=By.name("username");
	private By passwordLocator=By.name("password");
	private By loginLocator=By.xpath("//button[@type='submit']");
	private By errorLocator=By.xpath("//p[text()='Invalid credentials']");
	private WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{super(driver);
		this.driver=driver;
	}
	
	public void enterUsername(WebDriver driver,String username)
	{ 
	
		//super.setInputText(usernameLocator, username);
		this.driver.findElement(usernameLocator).sendKeys(username);
	}
	public void enterpassword(WebDriver driver,String password)
	{  //setInputText(passwordLocator, password);
		driver.findElement(passwordLocator).sendKeys(password);
	}
	public void clickonlogin(WebDriver driver)
	{
		
	driver.findElement(loginLocator).click();
	}
public String getInvalidErrorMesssage()
{
	return driver.findElement(errorLocator).getText();
	
}
public String getUsernamePlaceholder()
{
	return driver.findElement(By.name("username")).getAttribute("placeholder");
}
public String getPasswordPlaceholder()
{
	return driver.findElement(By.name("password")).getAttribute("placeholder");
}
}
