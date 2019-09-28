package com.sunrise.selenium.utilies;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class Commons 
{
	
	public WebDriver driver;
	public FileInputStream fis;
	public Properties or = new Properties();
	
	
	public void navigateURL(WebDriver driver, String URL)
	{
		try
		{
			driver.get(URL);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}catch(Exception e)
		{
			System.out.println("navigateURL method is failed : " + e.getMessage());
		}
	}
	
	public void close(WebDriver driver)
	{
		try
		{
			driver.close();
		}catch(Exception e)
		{
			System.out.println("close method is failed : " + e.getMessage());
		}
	}
	public void quit(WebDriver driver)
	{
		try
		{
			driver.quit();
		}catch(Exception e)
		{
			System.out.println("Quit method is failed : " + e.getMessage());
		}
	}
	public void refresh(WebDriver driver)
	{
		try
		{
			driver.navigate().refresh();
		}catch(Exception e)
		{
			System.out.println("refresh method is failed : " + e.getMessage());
		}
	}
	
	public void validateTitle(WebDriver driver, String Expectedvalue)
	{
		try
		{
			 String actualvalue = driver.getTitle();
			 if(Expectedvalue.equals(actualvalue))
			 {
				 System.out.println(Expectedvalue + " is displayed");
			 }else
			 {
				 System.out.println(Expectedvalue + " is not displayed");

			 }
			 
		}catch(Exception e)
		{
			System.out.println("refresh method is failed : " + e.getMessage());
		}
	}
	
	public void validateText(WebDriver driver, String xpathvalue, String titlevalue) throws Exception
	{
	
		boolean title = driver.findElement(By.xpath(xpathvalue)).isDisplayed();
		System.out.println(title);
		if(title)
		{
			System.out.println(titlevalue + " is displayed");
			Reporter.log(titlevalue + " is displayed");
			String titlename=driver.findElement(By.xpath(xpathvalue)).getText();
			System.out.println(titlename);
			Reporter.log(titlevalue + " title is displayed");
		}else
		{
			System.out.println(titlevalue + " is not displayed");
			Reporter.log(titlevalue + " title is not displayed");

		}
	}

}
