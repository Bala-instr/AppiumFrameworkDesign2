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
		public HomePage homePage;

		public AppiumDriverLocalService service;
		// TODO Auto-generated method stub
		
		@BeforeClass
		public void ConfigureAppium() throws URISyntaxException, InterruptedException, IOException
		{
			Properties prop = new Properties();
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//org//balamuruganacademy//resources//data.properties");
			
			prop.load(fis);
			String ipAddress=prop.getProperty("ipAddress");
			String port=prop.getProperty("port");
			
			
			service = startAppiumServer(ipAddress, Integer.parseInt(port));			
					// IOSDriver
			//Appium code -> WebDriver Agent -> Mobile
			XCUITestOptions options = new XCUITestOptions();
			options.setDeviceName(prop.getProperty("iPhoneDeviceName"));
			options.setApp(System.getProperty("user.dir")+"//src//test//java//org//balamuruganacademy//resources//UIKitCatalog.app");
			//options.setApp("//Users//balamcpro//Documents//iOSTestApp//UIKitCatalog.app");
			//options.setApp(System.getProperty("user.dir")+"//src//test//java//org//balamuruganacademy//resources//General-Store.apk");
			options.setPlatformVersion("17.2");
			options.setWdaLaunchTimeout(Duration.ofSeconds(20));
			driver = new IOSDriver(new URI("http://127.0.0.1:4723").toURL(), options);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			homePage = new HomePage(driver);
		}
		
		public void longPress(WebElement ele)
		{
		
			Map<String,Object>params = new HashMap<>();
			params.put("element", ((RemoteWebElement)ele).getId());
			params.put("duration",5);
			
			driver.executeScript("mobile:touchAndHold", params);
		}
		
		public void Scroll(WebElement ele)
		{
		
			Map<String,Object>params = new HashMap<>();
			params.put("direction","down");
			params.put("element", ((RemoteWebElement)ele).getId());
			driver.executeScript("mobile:scroll", params);
		}
		
		public Double formattedAmount(String Amount)
		{
			Double formattedprice= Double.parseDouble(Amount.substring(1));
			return formattedprice;

		}
		
	
		@AfterClass
		public void tearDown()
		{
			driver.quit();
			service.stop();
		}

	}

