package com.mystore.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.ActionDriver.Action;

public class OrderPage {
	
public WebDriver driver;
	
	public OrderPage(WebDriver d) {
		driver=d;
		PageFactory.initElements(driver, this);
	}

//	@FindBy(xpath="//*[@id='product_price_1_1_0']//span")
//	WebElement unitPrice;
	
	@FindBy(id="product_price_1_3_0")
	WebElement unitPrice;
	
	@FindBy(id="total_price")
	WebElement totalPrice;
	
	@FindBy(xpath="//span[text()='Proceed to checkout']")
	WebElement proceedToCheckOutBtn;
	
	
	public double getUnitPrice() {
		
		String unitPriceValue=unitPrice.getText(); //$16.51
		System.out.println("The value from unit price element:"+unitPriceValue);
		String upValue= unitPriceValue.replaceAll("[^a-zA-Z0-9]", ""); //"1651"
		System.out.println("After removing dollar sign from unit price"+upValue);
		double finalUnitPrice=Double.parseDouble(upValue); //1651
		System.out.println("After chnaged from string to double unit price"+finalUnitPrice);
		double funitPrice=finalUnitPrice/100; 
		System.out.println("After changing to decimal point unit price:"+funitPrice);
		return funitPrice;//16.51
		
	}
	
	public double getTotalPrice() {
		String totalPriceValue=totalPrice.getText(); //$35.03
		System.out.println("The value from total price element:"+totalPriceValue);
		String tpValue=totalPriceValue.replaceAll("[^a-zA-Z0-9]", ""); //"3503"
		System.out.println("After removing dollar sign from total price"+tpValue);
		double finalTotalPrice=Double.parseDouble(tpValue); //3503
		System.out.println("After chnaged from string to double total price"+finalTotalPrice);
		double ftprice=finalTotalPrice/100; 
		System.out.println("After changing to decimal point total price:"+ftprice);
		return ftprice;
				//35.03
	}
	
	public LoginPage clickCheckOut() {
		Action.click(driver, proceedToCheckOutBtn);
		return new LoginPage(driver);
	}
	
	
	
}
