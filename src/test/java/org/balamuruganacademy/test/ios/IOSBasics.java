package org.balamuruganacademy.test.ios;


import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.balamuruganacademy.TestUtils.IOSBaseTest;
import org.balamuruganacademy.pageObjects.ios.AlertViews;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class IOSBasics extends IOSBaseTest{
	
	@Test
	public void IOSBasicsTest() throws InterruptedException
	{
						
		//Appium code -> Web Driver Agent-> IOS Apps
	
		
		AlertViews alertViews=homePage.tapAlertViews();
		
		alertViews.fillTextEntry("Hello World");
		
	
		String confirmPoptitle =alertViews.getconfirmCancelSheetTitle();
	

	
		System.out.println(confirmPoptitle);
		
		AssertJUnit.assertEquals(confirmPoptitle, "A message should be a short, complete sentence.");
		
		alertViews.tapconfirmButton();
		
	}
 
}	
