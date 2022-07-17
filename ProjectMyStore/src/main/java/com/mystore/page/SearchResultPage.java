package com.mystore.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.ActionDriver.Action;

public class SearchResultPage {

	public WebDriver driver;
	
	public SearchResultPage(WebDriver d) {
		driver=d;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id='center_column']//img")
	WebElement productResult;
	
	
	public boolean validateProductIsAvailable() {
		boolean result=Action.isDisplayed(productResult);
		return result;
	}
	
	public AddToCartPage clickProduct() {
		Action.click(driver, productResult);
		return new AddToCartPage(driver);
	}
	
}
