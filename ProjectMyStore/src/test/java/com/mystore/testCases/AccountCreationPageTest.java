package com.mystore.testCases;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.page.AccountCreationPage;
import com.mystore.page.IndexPage;
import com.mystore.page.LoginPage;

public class AccountCreationPageTest extends BaseClass{
	
	public IndexPage indexPage;
	public LoginPage loginPage;
	public AccountCreationPage accountCreationPage;
	
	@BeforeMethod
	public void setUp() {
		BaseClass.launchBrowser();
	}
	
	@AfterMethod
	public void closeBrowser() {
		BaseClass.tearDown();
	}
	
	@Test
	public void accountCreateTest() {
		
		indexPage=new IndexPage(driver);
		loginPage=indexPage.clickSigIn();
		accountCreationPage=loginPage.createNewAccount("mithunpsr@gmail.com");
		boolean actualResult=accountCreationPage.validateFormTitle();
		Assert.assertTrue(actualResult);
	
		
	}

}
