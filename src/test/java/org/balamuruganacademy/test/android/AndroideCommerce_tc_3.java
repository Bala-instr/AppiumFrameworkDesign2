package org.balamuruganacademy.test.android;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.balamuruganacademy.TestUtils.AndroidBaseTest;
import org.balamuruganacademy.pageObjects.android.CartPage;
import org.balamuruganacademy.pageObjects.android.FormPage;
import org.balamuruganacademy.pageObjects.android.ProductCatalogue;
import org.balamuruganacademy.utils.AppiumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class AndroideCommerce_tc_3 extends AndroidBaseTest{
	
	//extending to Android Base test gives access to PageObject Pages(child), Android actions(P), Appium utils(GP)

	@Test(dataProvider="getData", groups={"Smoke"})
	public void FillForm(HashMap<String,String> input ) throws InterruptedException
	{
	
		formPage.selectCountry(input.get("country"));
		formPage.setNameField(input.get("name"));
		formPage.setGender(input.get("gender"));
		//formPage.submitForm();
		
		ProductCatalogue productCatalogue= formPage.submitForm();
		
		productCatalogue.addItemToCartByIndex(0);
		productCatalogue.addItemToCartByIndex(0);
		
		//Thread.sleep(2000);
		CartPage cartPage= productCatalogue.clickCartButton();
		
		
		double sum = cartPage.sumOfProdcutPrices();
		double formattedPurchaseAmount = cartPage.displayTotalPurchaseAmount();
		
		AssertJUnit.assertEquals(sum,formattedPurchaseAmount,formattedPurchaseAmount); //Assert.assertEquals(expected,actual,delta)
		System.out.println("sum of product prices: "+sum);
		System.out.println("total purchase price: "+formattedPurchaseAmount);
		
		cartPage.readTerms();
		cartPage.clickCheckboxandSubmit();

		
	}
	
	@BeforeMethod(alwaysRun=true)
	
	public void presetup()
	{
		formPage.preLoadFormPage(); 
	}
	
	@DataProvider
	
	public Object[][] getData() throws IOException
	{
		//return new Object[][] {{"Argentina","Balamurugan","Male"},{"Australia","Tom Cruise","Female"}};
	
		List<HashMap<String, String>>	data =getJsonData(System.getProperty("user.dir")+"//src//test//java//org//balamuruganacademy//testData//eCommerce.json");
		///Users/balamcpro/eclipse-workspace/AppiumFrameworkDesign001/src/test/java/org/balamuruganacademy/testData/eCommerce.json
		
		return new Object[][] { {data.get(0)},{data.get(1)}  };
	}
	
	
}
