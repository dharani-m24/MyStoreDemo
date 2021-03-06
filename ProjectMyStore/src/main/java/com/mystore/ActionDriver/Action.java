package com.mystore.ActionDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Action {

	

	public static void click2(WebElement element) {
		element.click();
	}

	public static void click(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).click().perform();
	}

	public static void JSClick(WebDriver driver, WebElement element) {

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);

	}

	/*
	 * 
	 * verify
	 */

	public static boolean isDisplayed(WebElement element) {

		boolean flag = false;

		flag = element.isDisplayed();
		if (flag) {
			System.out.println("The element is displayed");
		} else {
			System.out.println("The element is not displayed");
		}
		return flag;
	}

	public static boolean isSelected(WebElement element) {

		boolean flag = false;

		flag = element.isSelected();
		if (flag) {
			System.out.println("The element is selected");
		} else {
			System.out.println("The element is not selected");
		}

		return flag;
	}

	public static boolean isEnabled(WebElement element) {

		boolean flag = false;

		flag = element.isSelected();
		if (flag) {
			System.out.println("The element is enabled");
		} else {
			System.out.println("The element is not enabled");
		}

		return flag;

	}

	/*
	 * Types
	 * 
	 */

	public static void type(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);

	}

	/*
	 * Select-to handle dropdown
	 */

	public static void selectByIndex(WebElement element, int number) {

		Select select = new Select(element);
		select.selectByIndex(number);

	}

	public static void selectByvalue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	public static void selectByVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	/*
	 * 
	 * 
	 * waits
	 */

	public static void implicitWaits(WebDriver driver, int timeOut) {

		driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);

	}

	public static void explicitWait(WebDriver driver, int timeOut, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void fluentWait(WebDriver driver,WebElement element, int timeOut) {
	    Wait<WebDriver> wait = null;
	
	        wait = new FluentWait<WebDriver>((WebDriver) driver)
	        		.withTimeout(Duration.ofSeconds(20))
	        	    .pollingEvery(Duration.ofSeconds(2))
	        	    .ignoring(Exception.class);
	        wait.until(ExpectedConditions.visibilityOf(element));
	       // element.click();
	    
	   
	}

	/*
	 * Frames
	 * 
	 */

	public static void switchToFrameByIndex(WebDriver driver, int number) {

		driver.switchTo().frame(number);

	}

	public static void switchToFrameByName(WebDriver driver, String name) {

		driver.switchTo().frame(name);

	}

	public static void switchToDeafultFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	/*
	 * Actions class
	 */

	public static void moverOverElement(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();

	}
	
	public static String screenShot(WebDriver driver, String fileName) throws IOException {
		String date=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot screenshot=(TakesScreenshot) driver;
		String destination=System.getProperty("user.dir")+"\\Screenshot\\"+fileName+"_"+date+".png";
		File source=screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File(destination));
		
		return destination;
		
		
	}
}
