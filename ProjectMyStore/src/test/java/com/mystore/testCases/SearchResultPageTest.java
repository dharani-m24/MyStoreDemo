package com.mystore.testCases;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.page.IndexPage;
import com.mystore.page.SearchResultPage;

public class SearchResultPageTest extends BaseClass{
	
	public IndexPage indexPage;
	public SearchResultPage searchResultPage;
	
	@BeforeMethod
	public void setUp() {
		BaseClass.launchBrowser();
	}
	
	@AfterMethod
	public void closeBrowser() {
		BaseClass.tearDown();
	}
	
	
	@Test
	public void searchTest() {
		indexPage=new IndexPage(driver);
		searchResultPage=indexPage.searchProduct("t-shirt");
		boolean actualResult=searchResultPage.validateProductIsAvailable();
		Assert.assertTrue(actualResult);
		searchResultPage.clickProduct();
		
		
	}

}
