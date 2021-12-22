package com.Testcase;

import org.testng.annotations.Test;

import com.ReusableMethods.Baseclasss;

public class Profile {
	
public static Baseclasss bc=new Baseclasss();
	
	/*@author : jayanth
     * Description : test case execution
     * Date : 06-12-2021
     * purpose : Reusablity 
     * 
     */
	@Test
	public static void userlogin()
	{
		bc.navigatetobrowser("chrome");
		bc.navigateurl();
		bc.enterusercredentials();
	}
	

}
