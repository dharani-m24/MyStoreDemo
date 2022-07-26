package com.mystore.testCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.page.HomePage;
import com.mystore.page.IndexPage;
import com.mystore.page.LoginPage;
import com.mystore.utilities.Log;
import com.mystore.utilities.ReadExcelFile;

import junit.framework.Assert;

public class LoginPageTest extends BaseClass {
	
	public IndexPage indexPage;
	public LoginPage loginPage;
	public HomePage homePage;
	
	@BeforeMethod
	public void setUp() {
		BaseClass.launchBrowser();
	}
	
	
	@Test(dataProvider="loginData")
	public void login(String username, String pwd) {
		indexPage=new IndexPage(driver);
		Log.startTestCase("Login");
		loginPage=indexPage.clickSigIn();
		loginPage.userLogin(username,pwd) ;
		String actualURL=homePage.getCurrURL();
	    String expectedURL="http://automationpractice.com/index.php?controller=my-account";
	    Assert.assertEquals(expectedURL, actualURL);
		Log.info("user is able to login");
		Log.endTestCase("Login");
	}
	

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
	
	@DataProvider(name="loginData")
	public Object[][] getLoginData() throws EncryptedDocumentException, InvalidFormatException, IOException {
		
		ReadExcelFile file=new ReadExcelFile();
		Object[][] testData=file.getData("Login");
		return testData;
		
	}
	
	@Test(dataProvider="loginDataforFailed", enabled=false)
	public void loginFailed(String username, String pwd) {
		indexPage=new IndexPage(driver);
		Log.startTestCase("Login");
		loginPage=indexPage.clickSigIn();
		loginPage.userLogin(username,pwd) ;
		String actualURL=homePage.getCurrURL();
	    String expectedURL="http://automationpractice.com/index.php?controller=my-account";
	    Assert.assertEquals(expectedURL, actualURL);
		Log.info("user is able to login");
		Log.endTestCase("Login");
	}
	
	@DataProvider(name="loginDataforFailed")
	public Object[][] getLoginDataForFailed() throws EncryptedDocumentException, InvalidFormatException, IOException {
		
		ReadExcelFile file=new ReadExcelFile();
		Object[][] testData=file.getData("Sheet1");
		return testData;
		
	}

}
