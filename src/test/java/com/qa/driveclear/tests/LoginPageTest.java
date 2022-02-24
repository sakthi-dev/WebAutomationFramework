package com.qa.driveclear.tests;

import org.testng.annotations.Test;

import com.qa.driveclear.utils.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

import org.testng.Assert;

@Epic("EPIC-1423 : Design Login Page for Open Cart Application.......")
@Story("US - 1521 : Login Page Features")
public class LoginPageTest extends BaseTest {

	@Description("Login Page Title Test")
	@Severity(SeverityLevel.MINOR)
	@Test
	public void loginPageTitleTest() {

		String title = loginPage.getLoginTitle();
		System.out.println("Login Page Title : " + title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
	}

	@Description("Login Page URL Test")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void loginPageUrlTest() {

		String url = loginPage.getLoginPageUrl();
		System.out.println("Login Page URL :" + url);
		Assert.assertTrue(url.contains(Constants.LOGIN_PAGE_URL_FRACTION));
	}

	@Description("Forgot Password Test In The Login Page ")
	@Severity(SeverityLevel.CRITICAL)
	@Test
	public void forgotPwdLinkTest() {
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	}

	@Description("Positive Test Case With The Valid Crendentails....")
	@Severity(SeverityLevel.BLOCKER)
	@Test
	public void loginTest() {
		accPage = loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		Assert.assertTrue(accPage.isLogoutLinkExist());
	}

}
