package com.allianz.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
	private WebDriver driver;
	public DashboardPage(WebDriver driver)
	{
		this.driver=driver;
	}
	public String getDashboardHeader()
	{
		return driver.findElement(By.xpath("//h6[text()='Dashboard']")).getText();
	}
	public String clickOnAssignLeave()
	{
		return driver.findElement(By.xpath("//span[text()='Leave']")).getText();
	}
	public String clickOnLeaveList()
	{
		return driver.findElement(By.xpath("//span[text()='Leave List']")).getText();
	}
	public String clickOnTimeSheet()
	{
		return driver.findElement(By.xpath("//span[text()='Time']")).getText();
	}
}