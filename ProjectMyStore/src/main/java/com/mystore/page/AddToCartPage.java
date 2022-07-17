package com.mystore.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.ActionDriver.Action;

public class AddToCartPage {
	
	public WebDriver driver;
	
	public AddToCartPage(WebDriver d) {
		driver=d;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="quantity_wanted")
	WebElement quantity;
	
	@FindBy(id="group_1")
	WebElement size;
	
	@FindBy(xpath="//span[text()='Add to cart']")
	WebElement addToCartbtn;
	
	@FindBy(xpath="//i[@class='icon-ok']")
	WebElement addToCartMessage;
	
	@FindBy(xpath="//span[contains(text(),'Proceed to checkout')]")
	WebElement proceedToCheckOutBtn;
	
	public void enterQuantity(String number) {
		Action.type(quantity, number);
	}
	
	public void enterSize(String value) {
		Action.selectByVisibleText(size, value);
	}
	
	public void clickAddToCart() {
		Action.click(driver, addToCartbtn);
		
	}
	
	public boolean validateAddToCart() {
		Action.explicitWait(driver, 10, addToCartMessage);
		boolean status=Action.isDisplayed(addToCartMessage);
		return status;
	}
	
	public OrderPage clickCheckOut() {
		Action.click(driver, proceedToCheckOutBtn);
		return new OrderPage(driver);
	}
	
	

}
