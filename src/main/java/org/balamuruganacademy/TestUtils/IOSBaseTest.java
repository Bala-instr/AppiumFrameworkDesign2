package org.balamuruganacademy.TestUtils;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.balamuruganacademy.pageObjects.ios.HomePage;
import org.balamuruganacademy.utils.AppiumUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.HttpCommandExecutor;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class IOSBaseTest extends AppiumUtils{
	
	public IOSDriver driver;
	public AppiumDriverLocalService service;
	public HomePage homePage;
	

	@BeforeClass
	public void ConfigureAppium() throws IOException
	{
		
		Properties prop = new Properties();
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"//src//main//java//org//balamuruganacademy//resources//data.properties");
		prop.load(fis);	
		
		String ipAddress=prop.getProperty("ipAddress");
		Integer port=Integer.parseInt(prop.getProperty("port"));
		
		service=startAppiumServer(ipAddress,port);
		
		XCUITestOptions options= new XCUITestOptions();
		options.setDeviceName(prop.getProperty("iPhoneDeviceName"));
		options.setApp(System.getProperty("user.dir")+"//src//test//java//org//balamuruganacademy//resources//UIKitCatalog.app");
		options.setPlatformVersion(prop.getProperty("iPhonePlatformVersion"));
		options.setWdaLaunchTimeout(Duration.ofSeconds(20));
		
		driver = new IOSDriver(service.getUrl(),options);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		
		homePage = new HomePage(driver);
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
		service.stop();
	}

}
