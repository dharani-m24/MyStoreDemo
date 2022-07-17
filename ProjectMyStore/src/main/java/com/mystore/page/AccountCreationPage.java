package com.mystore.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.ActionDriver.Action;

public class AccountCreationPage {
	
	public WebDriver driver;
	
	public AccountCreationPage(WebDriver d) {
		driver=d;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h1[text()='Create an account']")
	WebElement formTitle;
	
	public boolean validateFormTitle() {
		boolean status=Action.isDisplayed(formTitle);
		return status;
	}
	
	

}
