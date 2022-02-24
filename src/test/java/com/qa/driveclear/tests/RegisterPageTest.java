package com.qa.driveclear.tests;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.driveclear.utils.Constants;
import com.qa.driveclear.utils.ExcelUtil;

public class RegisterPageTest extends BaseTest {

	@BeforeClass
	public void regSetUP() {
		regPage = loginPage.goToRegisterPage();
	}

	public String getRandomNumber() {
		Random randomGen = new Random();
		String email = "testautomationcompany"+randomGen.nextInt(1000)+"@gmail.com";
		return email;
		
	}
	
	@DataProvider
	public Object[][] getRegisterData() {
		Object regData[][] = ExcelUtil.getTestData(Constants.REGISTER_SHEET_NAME);
		return regData;
	}

	@Test(dataProvider = "getRegisterData")
	public void userRegistrationTest(String firstName, String lastName, 
									 String telephone, String password,
									 String subscribe) {
		Assert.assertTrue(regPage.accountRegistration(firstName, lastName, getRandomNumber(), telephone, password, subscribe ));
	}

}
