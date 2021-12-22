package com.ReusableMethods;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.TestcaseObjects.Pages;
import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import com.sun.corba.se.spi.orbutil.fsm.Action;

public class Baseclasss {

public static WebDriver driver;
public static ExtentReports report;
public static ExtentTest logger;


     /*@author : jayanth
      * Description : browser lunch
      * Date : 06-12-2021
      * purpose : Reusablity 
      * 
      */
	
	
@org.testng.annotations.Parameters("browser")
	public static void navigatetobrowser(String browser)
	{
		if (browser.equalsIgnoreCase("chrome"))
		{
            String chromedriverexepath="/BrowserDrivers/chromedriver.exe";
			String path = System.getProperty("user.dir")+ chromedriverexepath;
			System.setProperty("webdriver.chrome.driver",path);
		    driver = new ChromeDriver();	
		}
		else if (browser.equalsIgnoreCase("Firefox"))
		{
            String chromedriverexepath="/BrowserDrivers/chromedriver.exe";
			String path = System.getProperty("user.dir")+ chromedriverexepath;
			System.setProperty("webdriver.gecko.driver",path);
		    driver = new FirefoxDriver();	
		}
		else
		{
			System.out.println("Browser is not intilized due to driver undefined");
		
		}
	}
	/*@author : jayanth
     * Description :navigate url
     * Date : 06-12-2021
     * purpose : Reusablity 
     * 
     */
	
	public static void navigateurl()
	{
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
	}
	/*@author : jayanth
     * Description : login
     * Date : 06-12-2021
     * purpose : Reusablity 
     * 
     */
	public static void enterusercredentials()
	{
		Pages po=PageFactory.initElements(driver, Pages.class);
		movetoelements(po.signintab);
		po.signinbuttion.click();
		po.username.sendKeys("jayanth");
		
	}
	/*@author : jayanth
     * Description : mouseovr
     * Date : 06-12-2021
     * purpose : Reusablity 
     * 
     */
	public static void movetoelements(WebElement element )
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();
		
	}
	@BeforeSuite
	public static void createhtmlreport()
	{
		System.out.println("report creating");
		//String reportlocation= System.getProperty("user.dir")+"/Test Reports//"+".html";
		ExtentHtmlReporter extent= new ExtentHtmlReporter("C:\\Users\\jayan\\eclipse-workspace\\Newfolder1\\Newfolder2\\guru\\Test Reports\\TEST_"+getsysdateandtime()+".html");
	    report = new ExtentReports();
	    report.attachReporter(extent);
	
		
	}
		public static String getsysdateandtime()
		{
			SimpleDateFormat sdf=new SimpleDateFormat("dd_mm_yyyy_HH_mm_ss");
			Date date=new Date(0);
			String curenttimedate=sdf.format(date);
			System.out.println(curenttimedate);
			return curenttimedate;
					
		}
		@AfterMethod
		public static void addingscreenshotsintoreport(ITestResult result) throws IOException
		{
			Reporter.log("Capturing the screenshots based on condition check true/false");
			if(result.getStatus()==ITestResult.SUCCESS)
			{
			 logger.pass("Success",MediaEntityBuilder.createScreenCaptureFromPath(getscreenshot()).build() );
			 Reporter.log("All pass screenshot as added");
			}
			else if (result.getStatus()==ITestResult.FAILURE)
			{
				logger.fail("filure", MediaEntityBuilder.createScreenCaptureFromPath(getscreenshot()).build());
				Reporter.log("All pass screenshot as added");
			}
			report.flush();
			Reporter.log("HTML report is created ", true);
		}
		@AfterTest
		private static String getscreenshot() throws IOException {
			
			String scrlocation="C:\\Users\\jayan\\eclipse-workspace\\Newfolder1\\Newfolder2\\guru\\Screenshots\\TEST_"+getsysdateandtime()+".png";
			TakesScreenshot ts=(TakesScreenshot)driver;
			File src=ts.getScreenshotAs(OutputType.FILE);
			FileHandler.copy(src, new File (scrlocation));
			

			return scrlocation;
		}
		
	

	
	
}
