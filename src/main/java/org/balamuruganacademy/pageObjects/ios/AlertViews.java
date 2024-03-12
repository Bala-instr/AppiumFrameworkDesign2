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
	
	@iOSXCUITFindBy(accessibility="Alert Views")
	private WebElement alertViews;
	
	@iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeStaticText[`label=='Text Entry'`]")
	private WebElement textEntryMenu;
	
	@iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeTextField")
	private WebElement enterValueTextEntry;
	
	@iOSXCUITFindBy(accessibility="OK")
	private WebElement textEntryOK;
	
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeStaticText' AND value ENDSWITH[c] 'm / Cancel'")
	private WebElement confirmCancelMenu;
	
	@iOSXCUITFindBy(iOSNsPredicate="type =='XCUIElementTypeStaticText' AND value BEGINSWITH 'A message'")
	private WebElement confirmCancelSheetTitle;
	
	@iOSXCUITFindBy(iOSNsPredicate="name == 'Confirm'")
	private WebElement confirmButton;
	

	
	
	
	public void fillTextEntry(String inputText)
	{
		textEntryMenu.click();
		textEntryMenu.sendKeys(inputText);
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
