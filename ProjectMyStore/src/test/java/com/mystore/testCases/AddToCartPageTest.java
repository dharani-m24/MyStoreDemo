package com.mystore.testCases;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.page.AddToCartPage;
import com.mystore.page.IndexPage;
import com.mystore.page.SearchResultPage;

public class AddToCartPageTest extends BaseClass{
	
	public IndexPage indexPage;
	public SearchResultPage searchResultPage;
	public AddToCartPage addToCartPage;
	
	@BeforeMethod
	public void setUp() {
		BaseClass.launchBrowser();
	}
	
//	@AfterMethod
//	public void closeBrowser() {
//		BaseClass.tearDown();
//	}
	
	@Test
	public void addTocartTest() {
		indexPage=new IndexPage(driver);
		searchResultPage=indexPage.searchProduct("t-shirt");
		addToCartPage=searchResultPage.clickProduct();
		addToCartPage.enterQuantity("2");
		addToCartPage.enterSize("M");
		addToCartPage.clickAddToCart();
		boolean status=addToCartPage.validateAddToCart();
		Assert.assertTrue(status);
		addToCartPage.clickCheckOut();
	}

}
