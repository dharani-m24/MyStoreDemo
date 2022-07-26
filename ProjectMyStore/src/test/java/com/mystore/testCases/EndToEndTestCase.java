package com.mystore.testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.mystore.base.BaseClass;
import com.mystore.page.AddToCartPage;
import com.mystore.page.AddressPage;
import com.mystore.page.IndexPage;
import com.mystore.page.LoginPage;
import com.mystore.page.OrderConfirmationPage;
import com.mystore.page.OrderPage;
import com.mystore.page.OrderSummaryPage;
import com.mystore.page.PaymentPage;
import com.mystore.page.SearchResultPage;
import com.mystore.page.ShippingPage;

import junit.framework.Assert;

public class EndToEndTestCase extends BaseClass{
	
	public IndexPage indexPage;
	public LoginPage loginPage;
	public SearchResultPage searchResultPage;
	public AddToCartPage addToCartPage;
	public OrderPage orderPage;
	public AddressPage addressPage;
	public ShippingPage shippingPage;
	public PaymentPage paymentPage;
	public OrderSummaryPage orderSummaryPage;
	public OrderConfirmationPage orderConfirmationPage;
	
	@BeforeMethod
	public void setUp() {
		BaseClass.launchBrowser();
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
	
	public void endToendTest() {
		indexPage=new IndexPage(driver);
		searchResultPage=indexPage.searchProduct("t-shirt");
		addToCartPage=searchResultPage.clickProduct();
		addToCartPage.enterQuantity("2");
		addToCartPage.enterSize("M");
		addToCartPage.clickAddToCart();
		orderPage=addToCartPage.clickCheckOut();
		loginPage=orderPage.clickCheckOut();
		addressPage=loginPage.userLoginFromOrderPage("dharanimani2412@gmail.com", "12345");
		shippingPage=addressPage.clickSubmit();
		paymentPage=shippingPage.clickProceed();
		orderSummaryPage=paymentPage.selectPaymentMode();
		orderConfirmationPage=orderSummaryPage.clickConfirmOrder();
		String expectedMessage=orderConfirmationPage.valiadateMessage();
		String actualMessage="Your order on My Store is complete.";
		Assert.assertEquals(expectedMessage, actualMessage);
		
		
		
	}

}
