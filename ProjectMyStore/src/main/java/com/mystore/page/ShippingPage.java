package com.mystore.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.ActionDriver.Action;

public class ShippingPage {
	
	public WebDriver driver;
	
	
	public ShippingPage(WebDriver d) {
		driver=d;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="cgv")
	WebElement terms;
	
	@FindBy(xpath="//button[@name='processCarrier']")
	WebElement submitBtn;
	
	public void clickTerms() {
		Action.click(driver, terms);
	}
	
	public PaymentPage clickProceed() {
		Action.click(driver, submitBtn);
		return new PaymentPage(driver);
	}

}
