package com.mystore.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.ActionDriver.Action;

public class IndexPage {

	public WebDriver driver;

	public IndexPage(WebDriver d) {
		driver = d;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@class='login']")
	WebElement signIn;

	@FindBy(xpath = "//img[@class='logo img-responsive']")
	WebElement myStoreLogo;

	@FindBy(id = "search_query_top")
	WebElement searchInputBox;
	
	@FindBy(name="submit_search")
	WebElement searchBtn;
	

	public boolean validateLogo() {

		boolean status = Action.isDisplayed(myStoreLogo);

		return status;
	}

	public String getStoreTitle() {
		String title = driver.getTitle();
		return title;
	}
	
	public LoginPage clickSigIn() {
		Action.click(driver, signIn);
		return new LoginPage(driver);
	}
	
	public SearchResultPage searchProduct(String value) {
		Action.type(searchInputBox, value);
		Action.click(driver, searchBtn);
		return new SearchResultPage();
	}

}
