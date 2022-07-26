package com.mystore.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.ActionDriver.Action;

public class OrderSummaryPage {
	
public WebDriver driver;
	
	
	public OrderSummaryPage(WebDriver d) {
		driver=d;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//span[contains(text(),'I confirm my order')]")
	WebElement confirmOrderBtn;
	
	public OrderConfirmationPage clickConfirmOrder() {
		Action.click(driver, confirmOrderBtn);
		return new OrderConfirmationPage(driver);
	}
}
