package com.mystore.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class OrderPage {
	
public WebDriver driver;
	
	public OrderPage(WebDriver d) {
		driver=d;
		PageFactory.initElements(driver, this);
	}

}
