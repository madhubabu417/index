package com.TestRunner;

import org.testng.annotations.Test;

import com.ReusableMethods.Baseclasss;
import com.Testcase.Profile;

public class Runner extends Baseclasss {
	public static Profile up=new Profile();
	//public static Baseclasss bc=new Baseclasss();
	/*@author : jayanth
     * Description : test case execution
     * Date : 06-12-2021
     * purpose : Reusablity 
     * 
     */
	@Test
	public static void testexecution()
	{
//		bc.logger=bc.report.createTest("HTML TEST REPORT");
//		up.userlogin();
		
		Baseclasss.logger=Baseclasss.report.createTest(getsysdateandtime());
		try
		{
			Profile.userlogin();
			Baseclasss.logger.pass("user able to login");
			
		
		}
		catch (Exception e)
		{
			Baseclasss.logger.pass("user able to login"+ e.getMessage());
			
		}
	}
	
		
	
	
	
	

}
