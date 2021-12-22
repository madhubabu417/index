package com.TestRunner;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ReusableMethods.Baseclasss;
import com.beust.jcommander.Parameter;

public class Compatability extends Baseclasss {
	
	@Parameters("browser")
	@Test
	public static void login()
	{
		navigatetobrowser("chrome");
		navigateurl();
		enterusercredentials();
	}
	

}
