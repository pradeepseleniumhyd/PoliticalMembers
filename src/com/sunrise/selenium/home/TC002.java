package com.sunrise.selenium.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.sunrise.selenium.utilies.Commons;
import com.sunrise.selenium.utilies.OpenBrowser;

public class TC002 extends Commons
{
	OpenBrowser ob = new OpenBrowser();
	
	
	@Parameters({"browsername","URL"})
	@Test
	public void TC002(String browsername, String URL)
	{
		try
		{
		
			driver=ob.getBrowser(browsername);
			navigateURL(driver, URL);	
			
		}catch(Exception e)
		{
			System.out.println("TC002 is failed " + e.getMessage());
		}
		
	}
	
	

}
