package com.mystore.base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;

import com.mystore.ActionDriver.Action;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;

	public static Properties prop;
	
	
	@BeforeSuite
	public void loadConfig() throws IOException {

		FileReader file = new FileReader(
				System.getProperty("user.dir")+"\\src\\test\\resources\\Configuration\\config.properties");

		prop = new Properties();
		prop.load(file);
	}

	public static void launchBrowser() {

		if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver();
		}
		
		else if(prop.getProperty("browser").equalsIgnoreCase("fireFox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		Action.implicitWaits(driver, 60);
		driver.get(prop.getProperty("url"));

	}
	
	public static void tearDown() {
		driver.close();
	}

}
