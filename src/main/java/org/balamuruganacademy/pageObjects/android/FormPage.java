package org.balamuruganacademy.pageObjects.android;

import java.util.List;

import org.balamuruganacademy.utils.AndroidActions;
import org.balamuruganacademy.utils.AppiumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class FormPage extends AndroidActions{
	
	AndroidDriver driver;
	
	public FormPage(AndroidDriver driver)
	{
		super(driver);
		this.driver=driver;//this is used for current class instance
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);//Appiumfielddecorator is the class for constructing driver.findelement 

	}
	
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	private WebElement nameField;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/radioMale")
	private WebElement maleOption;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/radioFemale")
	private WebElement femaleOption;
	
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	private WebElement submitButton;
	
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/spinnerCountry")
	private WebElement countryField;
	
	public void preLoadFormPage()
	
	{
		//Activity activity = new Activity("com.androidsample.generalstore","com.androidsample.generalstore.SplashActivity");
		((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of(
			    "intent", "com.androidsample.generalstore/com.androidsample.generalstore.SplashActivity"
			));
	}
	
	public void setNameField(String name)
	{
		nameField.sendKeys(name);
		driver.hideKeyboard();
	}
	
	public void setGender(String gender)
	{
		if(gender.equals("Male"))
			maleOption.click();
		else
			femaleOption.click();		
	}
	
	
	public void submitForm() throws InterruptedException
	{
		submitButton.click();
		Thread.sleep(2000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(2000);
		
		//return new ProductCatalogue(driver);
	}

	public void selectCountry(String country)
	{
		countryField.click();
		scrollText(country);
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+country+"']")).click();
	}
}
	

