package com.mystore.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.ActionDriver.Action;

public class AddressPage {
	
	public WebDriver driver;
	
	public AddressPage(WebDriver d) {
		driver=d;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//span[text()='Proceed to checkout']")
	WebElement proceedToCheckOut;
	
	public ShippingPage clickSubmit() {
		Action.click(driver, proceedToCheckOut);
		return new ShippingPage(driver);
	}

}
