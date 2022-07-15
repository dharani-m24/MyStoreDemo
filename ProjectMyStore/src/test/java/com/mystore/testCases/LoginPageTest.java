package com.mystore.testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.page.IndexPage;
import com.mystore.page.LoginPage;

public class LoginPageTest extends BaseClass {
	
	IndexPage indexPage;
	LoginPage loginPage;
	
	@BeforeMethod
	public void setUp() {
		BaseClass.launchBrowser();
	}
	
	
	@Test
	public void login() {
		indexPage=new IndexPage(driver);
		loginPage=indexPage.clickSigIn();
		loginPage.userLogin("dharanimani2412@gmail.com", "12345");
		System.out.println("hello");
	}
	

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

}
