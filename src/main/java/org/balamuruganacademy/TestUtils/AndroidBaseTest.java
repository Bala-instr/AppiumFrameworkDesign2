package org.balamuruganacademy.TestUtils;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Properties;

import org.balamuruganacademy.pageObjects.android.FormPage;
import org.balamuruganacademy.utils.AppiumUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;


public class AndroidBaseTest extends AppiumUtils{

	//extending to appium utils gives access to PageObject Pages(child), Android actions(P), Appium utils(GP)


		public AndroidDriver driver;
		public AppiumDriverLocalService service;
		public FormPage formPage;
		// TODO Auto-generated method stub
		
		@BeforeClass(alwaysRun=true)
		public void ConfigureAppium() throws URISyntaxException, InterruptedException, IOException
		{
			Properties prop = new Properties();
		
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//org//balamuruganacademy//resources//data.properties");
			//Users/balamcpro/eclipse-workspace/AppiumFrameworkDesign001/src/main/java/org/balamuruganacademy/resources/data.properties

			//FileInputStream fis = new FileInputStream("//Users//balamcpro//eclipse-workspace//AppiumFrameworkDesign001//src//main//java//org//				balamuruganacademy//resources//data.properties");
			String ipAddress=System.getProperty("ipAddress")!=null? System.getProperty("ipAddress") : prop.getProperty("ipAddress");
			prop.load(fis);
			//String ipAddress=prop.getProperty("ipAddress");

			String port=prop.getProperty("port");
			
			service = startAppiumServer(ipAddress, Integer.parseInt(port));		
					//AndroidDriver, IOSDriver
			//Appium code -> Appium server -> Mobile
			UiAutomator2Options options = new UiAutomator2Options();
			options.setDeviceName(prop.getProperty("AndroidDeviceName"));
			options.setChromedriverExecutable("//Users//balamcpro//Documents//chromedriver");
			//options.setApp("//Users//balamcpro//eclipse-workspace//Appium2//src//test//java//resources//ApiDemos-debug.apk");
			

			options.setApp(System.getProperty("user.dir")+"//src//test//java//org//balamuruganacademy//resources//General-Store.apk");
			driver= new AndroidDriver(service.getUrl(),options);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			formPage = new FormPage(driver);
			
		}
		
		
		
	
		@AfterClass
		public void tearDown()
		{
			driver.quit();
			service.stop();
		}

	}
