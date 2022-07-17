package com.mystore.testCases;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.page.HomePage;
import com.mystore.page.IndexPage;
import com.mystore.page.LoginPage;

public class HomePageTest extends BaseClass {
	
	public IndexPage indexPage;
	public LoginPage loginPage;
	public HomePage homePage;
	
	@BeforeMethod
	public void setUp() {
		BaseClass.launchBrowser();
	}
	
	@AfterMethod
	public void closeBrowser() {
		BaseClass.tearDown();
	}
	
	@Test
	public void homeTest() {
		indexPage =new IndexPage(driver);
		loginPage=indexPage.clickSigIn();
		homePage=loginPage.userLogin("dharanimani2412@gmail.com", "12345");
		boolean actualStatus=homePage.validateMywishList();
		Assert.assertTrue(actualStatus);
		boolean actualResult=homePage.validateOrderHistory();
		Assert.assertTrue(actualResult);
	}

}
