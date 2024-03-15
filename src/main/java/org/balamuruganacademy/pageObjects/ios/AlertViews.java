package org.balamuruganacademy.pageObjects.ios;

import org.balamuruganacademy.utils.IOSActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class AlertViews extends IOSActions{

	IOSDriver driver;
	public AlertViews(IOSDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@iOSXCUITFindBy(accessibility="Text Entry")
	private WebElement textEntryMenu;
	
	@iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeStaticText[`name=='Alert Views'`]")
	private WebElement alertViews;
	
	@iOSXCUITFindBy(className="XCUIElementTypeTextField")
	private WebElement enterValueTextEntry;
	
	@iOSXCUITFindBy(accessibility="OK")
	private WebElement textEntryOK;
	
	@iOSXCUITFindBy(iOSNsPredicate="name == 'Confirm / Cancel'")
	private WebElement confirmCancelMenu;
	
	@iOSXCUITFindBy(accessibility="A message should be a short, complete sentence.")
	private WebElement confirmCancelSheetTitle;
	
	@iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeButton[`name == 'Confirm'`]")
	private WebElement confirmButton;
	
	public String alertViewsPageTitle()
	{
		return alertViews.getText();

	}
	
	public void fillTextEntry(String input)
	{
		textEntryMenu.click();
		enterValueTextEntry.sendKeys(input);
		textEntryOK.click();
		
	}
	
	public String getconfirmCancelSheetTitle()
	{
		confirmCancelMenu.click();
		return confirmCancelSheetTitle.getText();
	}
	
	public void tapconfirmButton()
	{
		confirmButton.click();
	}
}
