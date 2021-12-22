package com.TestcaseObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Pages {
	
	
	
	@FindBy(xpath="//span[@id='nav-link-accountList-nav-line-1']")public static WebElement signintab;
	@FindBy(xpath="//span[text()='Sign in']")public static WebElement signinbuttion;
	@FindBy(xpath="//input[@type='email']")public static WebElement username;
	
	

}
