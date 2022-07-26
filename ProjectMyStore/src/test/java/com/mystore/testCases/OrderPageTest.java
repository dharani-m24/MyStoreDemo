package com.mystore.testCases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.page.AddToCartPage;
import com.mystore.page.IndexPage;
import com.mystore.page.OrderPage;
import com.mystore.page.SearchResultPage;

import junit.framework.Assert;

public class OrderPageTest extends BaseClass {

	public IndexPage indexPage;

	public SearchResultPage searchResultPage;
	public AddToCartPage addToCartPage;
	public OrderPage orderPage;

	@BeforeMethod
	public void setUp() {
		BaseClass.launchBrowser();

	}

//	@AfterMethod
//	public void tearDown() {
//		BaseClass.closeBrowser();
//	}

	@Test
	public void verifyPrice() {
		indexPage = new IndexPage(driver);
		searchResultPage = indexPage.searchProduct("t-shirt");
		addToCartPage = searchResultPage.clickProduct();
		addToCartPage.enterQuantity("2");
		addToCartPage.enterSize("M");
		addToCartPage.clickAddToCart();
		orderPage = addToCartPage.clickCheckOut();

		Double unitPrice = orderPage.getUnitPrice();
		System.out.println(unitPrice);
		Double totalPrice = orderPage.getTotalPrice();
		
		Double expectedTotalPrice = (unitPrice * 2) + 2;
		System.out.println("expectedTotalPrice"+expectedTotalPrice);
		Assert.assertEquals(totalPrice, expectedTotalPrice);

	}
}
