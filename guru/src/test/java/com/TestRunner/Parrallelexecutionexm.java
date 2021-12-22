package com.TestRunner;



import org.testng.annotations.Test;

import com.ReusableMethods.Baseclasss;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

public class Parrallelexecutionexm extends Baseclasss {

	
	@Test
	public static void login()
	{
		navigatetobrowser("chrome");
		navigateurl();
		enterusercredentials();
	}
	

}
