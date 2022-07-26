package com.mystore.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.ActionDriver.Action;
import com.mystore.base.BaseClass;

public class HomePage extends BaseClass{
	
	public  WebDriver driver;
	
	public HomePage(WebDriver d) {
		driver=d;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='My wishlists']")
	WebElement myWishList;
	
	@FindBy(xpath="//span[text()='Order history and details']")
	WebElement orderHistory;
	
	public boolean validateMywishList() {
		boolean status=Action.isDisplayed(myWishList);
		return status;
	}
	
	public boolean validateOrderHistory() {
		boolean status=Action.isDisplayed(orderHistory);
		return status;
	}
	
	public String getCurrURL()  {
		String homePageURL=driver.getCurrentUrl();
		return homePageURL;
	}
	

}
