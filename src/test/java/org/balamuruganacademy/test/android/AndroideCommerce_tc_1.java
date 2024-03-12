package org.balamuruganacademy.test.android;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.balamuruganacademy.TestUtils.AndroidBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;

public class AndroideCommerce_tc_1 extends AndroidBaseTest{
	
	@BeforeMethod(alwaysRun=true)
	public void preSetup()
	
	
	{
		//Activity activity = new Activity("com.androidsample.generalstore","com.androidsample.generalstore.SplashActivity");
		((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of(
			    "intent", "com.androidsample.generalstore/com.androidsample.generalstore.SplashActivity"
			));
	}

	@Test(groups={"Regression"})
	public void FillForm_errorvalidation() throws InterruptedException
	{
		
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();

		
		//driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Balamurugan");
		
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		
	
		//driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		String toastmsg=driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		Assert.assertEquals(toastmsg, "Please your name");
	Thread.sleep(2000);
		
		
	}
	
	@Test(groups={"Regression"})
	public void FillForm_positiveflow() throws InterruptedException
	{
		
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();

		
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Balamurugan");
		driver.hideKeyboard();

		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		
	
		//driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Assert.assertTrue(driver.findElements(By.xpath("(//android.widget.Toast)[1]")).size()<1);
		
		//Assert.assertEquals(toastmsg, "Please enter your name");
		
		
	}
	
}
