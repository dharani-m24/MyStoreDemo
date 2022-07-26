package com.mystore.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.ActionDriver.Action;

public class PaymentPage {
	

	public WebDriver driver;
	
	
	public PaymentPage(WebDriver d) {
		driver=d;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Pay by bank wire ')]")
	WebElement bankWireMethod;
	
	
	public  OrderSummaryPage selectPaymentMode() {
		Action.click(driver, bankWireMethod);
		return new OrderSummaryPage(driver);
	}
	

}
