package org.balamuruganacademy.pageObjects.android;

import java.util.List;

import org.balamuruganacademy.utils.AndroidActions;
import org.balamuruganacademy.utils.AppiumUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductCatalogue extends AndroidActions{
	
	AndroidDriver driver;
	public ProductCatalogue(AndroidDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='ADD TO CART']")
	private List<WebElement> addToCartButton;
	
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
	private WebElement cartButton;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/toolbar_title")
	private WebElement productsPageTitle;
	
	
	public void addItemToCartByIndex(int index)
	
	{
		//AppiumUtils appiumActions = new AppiumUtils();
		//appiumActions.waitForElement(productsPageTitle,"Products", driver);
		
		addToCartButton.get(index).click();
	}
	
	public CartPage clickCartButton() throws InterruptedException
	{
		cartButton.click();
		Thread.sleep(2000);
		return new CartPage(driver);
		
	}
	
}
