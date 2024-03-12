package org.balamuruganacademy.pageObjects.android;

import java.util.List;

import org.balamuruganacademy.utils.AndroidActions;
import org.balamuruganacademy.utils.AppiumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CartPage extends AndroidActions{
	
	AndroidDriver driver;
	public CartPage(AndroidDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/productPrice")
	private List<WebElement> productPrices;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
	private WebElement totalPurchaseAmount;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/termsButton")
	private WebElement termsButton;
	
	@AndroidFindBy(id="android:id/button1")
	private WebElement termsCloseButton;
	
	@AndroidFindBy(className="android.widget.CheckBox")
	private WebElement checkBox;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnProceed")
	private WebElement submitOrderButton;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/productPrice")
	private List<WebElement> productPrice;
	
	
	public double sumOfProdcutPrices()
	{
		int size=productPrices.size();
		double sum=0;
		for(int i=0;i<size;i++)
			{
				String amountString = productPrice.get(i).getText();
				
				Double productPrice= formattedAmount(amountString);
				
				sum=sum+productPrice;
			}
		return sum;
	}
	
	public Double displayTotalPurchaseAmount()
	{
	
		return formattedAmount(totalPurchaseAmount.getText());
	}
	
	public void readTerms()
	{
		
		longPressAction(termsButton);
		termsCloseButton.click();
	}
	
	public void clickCheckboxandSubmit() throws InterruptedException
	{
		checkBox.click();
		submitOrderButton.click();
		//AppiumActions appiumActions=new AppiumActions(driver);
		//appiumActions.switchToNative();
		Thread.sleep(2000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(2000);
		
	}
	
}
