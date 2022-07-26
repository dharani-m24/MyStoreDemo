package com.mystore.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage {
	
public WebDriver driver;
	
	
	public OrderConfirmationPage(WebDriver d) {
		driver=d;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//p/strong[contains(text(),'Your order on My Store is complete')]")
	WebElement confirmMessage;
	
	public String valiadateMessage() {
		String message=confirmMessage.getText();
		return message;
	}

}
