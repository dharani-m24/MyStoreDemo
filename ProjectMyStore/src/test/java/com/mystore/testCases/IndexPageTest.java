package com.mystore.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.page.IndexPage;



public class IndexPageTest extends BaseClass {
	
	IndexPage indexPage;
	
	@BeforeMethod
	public void setUp() {
		BaseClass.launchBrowser();
	}
	
	@Test
	public void verifyLogo() {
		
		indexPage=new IndexPage(driver);
		boolean expectedResult=indexPage.validateLogo();
		Assert.assertEquals(expectedResult, true);
	}
	
	@Test
	public void verifyTitle() {
		 indexPage=new IndexPage(driver);
		 String expectedTitle=indexPage.getStoreTitle();
		 Assert.assertEquals(expectedTitle, "My Store");
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

}
