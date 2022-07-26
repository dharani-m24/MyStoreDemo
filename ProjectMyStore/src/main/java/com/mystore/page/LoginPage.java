package com.mystore.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.ActionDriver.Action;

public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver d) {
		driver=d;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="email")
	WebElement userName;
	
	@FindBy(id="passwd")
	WebElement paasword;
	
	@FindBy(id="SubmitLogin")
	WebElement signInBtn;

	@FindBy(id="email_create")
	WebElement emailForNewAccount;
	
	@FindBy(id="SubmitCreate")
	WebElement createNewAccountBtn;
	
	public HomePage userLogin(String uname, String pwd) {
		Action.type(userName, uname);
		Action.type(paasword, pwd);
		Action.click(driver, signInBtn);
		return new HomePage(driver);
		
	}
	
	public AddressPage userLoginFromOrderPage(String uname, String pwd)
	{
		Action.type(userName, uname);
		Action.type(paasword, pwd);
		Action.click(driver, signInBtn);
		return new AddressPage(driver);
	}
	public AccountCreationPage createNewAccount(String email) {
		Action.type(emailForNewAccount, email);
		Action.click(driver, createNewAccountBtn);
		return new AccountCreationPage(driver);
	}
}
