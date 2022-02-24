package com.qa.driveclear.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.qa.driveclear.factory.DriverFactory;
import com.qa.driveclear.pages.AccountsPage;
import com.qa.driveclear.pages.LoginPage;
import com.qa.driveclear.pages.ProductInfoPage;
import com.qa.driveclear.pages.RegisterPage;
import com.qa.driveclear.pages.ResultsPage;

public class BaseTest {
	
	DriverFactory df;
	WebDriver driver;
	Properties prop;
	
	LoginPage loginPage;
	AccountsPage accPage;
	RegisterPage regPage;
	ResultsPage resultsPage;
	ProductInfoPage productInfoPage; 
	
	SoftAssert softAssert;
	
		
	@BeforeTest
	public void setUp() {
	
		df = new DriverFactory();
		prop = df.init_prop();
		driver = df.init_driver(prop);
		loginPage = new LoginPage(driver);
		softAssert = new SoftAssert();
	}
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
