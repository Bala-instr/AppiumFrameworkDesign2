package org.balamuruganacademy.pageObjects.ios;

import org.balamuruganacademy.utils.IOSActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class HomePage extends IOSActions{
	
	public IOSDriver driver;

	public HomePage(IOSDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@iOSXCUITFindBy(accessibility="Alert Views")
	private WebElement alertViewsMenu;

	public void tapAlertViews()
	{
		alertViewsMenu.click();
	}
}
 