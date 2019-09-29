package com.sunrise.selenium.home;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.sunrise.selenium.utilies.Commons;
import com.sunrise.selenium.utilies.OpenBrowser;

public class TC002 extends Commons
{
	OpenBrowser ob = new OpenBrowser();
	WebDriver driver;
	
	
	@BeforeSuite
	public void configuration() throws Exception
	{
		fis = new FileInputStream(System.getProperty("user.dir")+"\\Resources\\OR.properties");
		or = new Properties();
		or.load(fis);			
		
	}
	
	
	@Parameters({"browsername","URL"})
	@Test
	public void TC002(String browsername, String URL) throws Exception
	{
		try
		{	
			FileInputStream exceldata = new FileInputStream(System.getProperty("user.dir")+"\\testData\\PoliticalMembers.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(exceldata);
			XSSFSheet sheet = workbook.getSheet("TestData");
			System.out.println(sheet.getLastRowNum());
			for(int i = 1; i<=sheet.getLastRowNum();i++)
			{
				if(sheet.getRow(i).getCell(0).getStringCellValue().equalsIgnoreCase("TC002") && sheet.getRow(i).getCell(2).getStringCellValue().equalsIgnoreCase("Yes"))
				{
					driver=ob.getBrowser(browsername);
					navigateURL(driver, URL);
					validateTitle(driver, "Political Leaders India | MP | MLA | Ministers - Political Members");			
					validateText(driver, or.getProperty("Contact_Xpath"), "Contact");
					validateText(driver, or.getProperty("User_Register_Xpath"), "User Register");
					validateText(driver, or.getProperty("Login_Xpath"), "Login");
					validateText(driver, or.getProperty("Become_A_Member_Xpath"), "Become a Member");
					validateText(driver, or.getProperty("Member_Login_Xpath"), "Member Login");
					validateText(driver, or.getProperty("Party_Login_Xpath"), "Party Login");
					validateText(driver, or.getProperty("Contact_Xpath"), "Contact");
					validateText(driver, or.getProperty("Contact_Xpath"), "Contact");
					validateText(driver, or.getProperty("Contact_Xpath"), "Contact");
					validateText(driver, or.getProperty("Contact_Xpath"), "Contact");
					validateText(driver, or.getProperty("Contact_Xpath"), "Contact");
					validateText(driver, or.getProperty("Contact_Xpath"), "Contact");
					validateText(driver, or.getProperty("Contact_Xpath"), "Contact");
					
					driver.quit();
				}
				if(sheet.getRow(i).getCell(0).getStringCellValue().equalsIgnoreCase("TC002") && sheet.getRow(i).getCell(2).getStringCellValue().equalsIgnoreCase("No"))
				{
					System.out.println("TC001 Run mode mentioned as No");
					throw new SkipException("TC001 Run mode mentioned as No");
				}
			}
			
			
			
		}catch(Exception e)
		{
			System.out.println("TC001 is failed " + e.getMessage());
		}/*finally
		{
			driver.quit();			
		}*/
		
	}
	
	

	/*@AfterMethod
	public void closemethod() throws Exception
	{
		driver.quit();
	}*/

}
