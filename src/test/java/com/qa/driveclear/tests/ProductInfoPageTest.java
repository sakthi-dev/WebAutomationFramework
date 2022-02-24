package com.qa.driveclear.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.driveclear.utils.Constants;

import net.bytebuddy.asm.Advice.OffsetMapping.Sort;

public class ProductInfoPageTest extends BaseTest {

	@BeforeClass
	public void productInfoSetup() {
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test
	public void productHeaderTest() {
		resultsPage = accPage.doSearch("MacBook");
		productInfoPage = resultsPage.selectProduct("MacBook Pro");
		Assert.assertEquals(productInfoPage.getProductHeaderName(), "MacBook Pro");
	}

	@DataProvider
	public Object[][] productImagesData() {
		return new Object[][] { { "MacBook", "MacBook Pro", Constants.MACBOOK_IMAGES_COUNT },
				{ "MacBook", "MacBook Air", Constants.MACBOOK_IMAGES_COUNT },
				{ "iMac", "iMac", Constants.IMAC_IMAGES_COUNT } };
	}

	@Test(dataProvider = "productImagesData")
	public void productimagesTest(String productName, String mainProductName, int imagesCount) {
		resultsPage = accPage.doSearch(productName);
		productInfoPage = resultsPage.selectProduct(mainProductName);
		int totalImages = productInfoPage.getProductImageCount();
		System.out.println("Total Product Images Count : " + imagesCount);
		Assert.assertEquals(totalImages, imagesCount);
	}
	
	@Test
	public void productInfoTest() {
		resultsPage = accPage.doSearch("Macbook");
		productInfoPage = resultsPage.selectProduct("MacBook Pro");
		Map<String, String> actualProductInfo = productInfoPage.getProductInfo();
		actualProductInfo.forEach((k,v)-> System.out.println(k + ":" + v));
		softAssert.assertEquals(actualProductInfo.get("Brand"), "Apple");
		softAssert.assertEquals(actualProductInfo.get("name"), "MacBook Pro");
		softAssert.assertEquals(actualProductInfo.get("Product Code"), "Product 18");
		softAssert.assertEquals(actualProductInfo.get("price"), "$2,000.00");
		softAssert.assertAll();
		
	}

}
