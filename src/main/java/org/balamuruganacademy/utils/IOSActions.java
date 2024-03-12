package org.balamuruganacademy.utils;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class IOSActions extends AppiumUtils{
	
	IOSDriver driver;
	
	public IOSActions(IOSDriver driver)
	{
		
	
		this.driver=driver;
	}

	public void longPressAction(WebElement ele)
	{
		Map<String,Object>params = new HashMap<>();
		params.put("element", ((RemoteWebElement)ele).getId());
		params.put("duration",5);
		
		driver.executeScript("mobile:touchAndHold", params);
	}
	

	
	public void swipeAction( String direction)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Map<String, Object> params1 = new HashMap<>();
		params1.put("direction", direction);
		//params.put("element", ((RemoteWebElement) element).getId());
		js.executeScript("mobile: swipe", params1);
	}
	

	
	public void scrollToWebElement(WebElement ele)
	{
		Map<String,Object>params = new HashMap<>();
		params.put("direction","down");
		params.put("element", ((RemoteWebElement)ele).getId());
		driver.executeScript("mobile:scroll", params);
	}

	
}
