package com.TestRunner;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Annotationorderexecution {
	
	
	@Test
	public static void method1()
	{
		System.out.println("@Test Method");
	}
	@BeforeSuite
	public static void method2()
	{
		System.out.println("@BeforeSuite Method2");
	}
	@BeforeClass
	public static void method3()
	{
		System.out.println("@Beforeclass Method3");
		
	}

}
