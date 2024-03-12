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
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class FormPage extends AndroidActions{

	AndroidDriver driver;
	
	public FormPage(AndroidDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	private WebElement nameField;
	//driver.findElement(By.id("com.androidsample.generalstore:id/nameField"));
	
	@AndroidFindBy(xpath="//android.widget.RadioButton[@text='Male']")
	private WebElement maleOption;
	//driver.findElement(By.xpath("//android.widget.RadioButton[@text='Male']"));

	
	@AndroidFindBy(xpath="//android.widget.RadioButton[@text='Female']")
	private WebElement femaleOption;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/spinnerCountry")
	private WebElement countryField;
	
	
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	private WebElement submitButton;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/toolbar_title")
	private WebElement formPageTitle;
	
	
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
		if (gender.contains("Male"))
			maleOption.click();
		else
			femaleOption.click();
			
	}
	
	public void selectCountry(String country)
	{
		//AppiumUtils appiumActions = new AppiumUtils();
		//appiumActions.waitForElement(formPageTitle,"General Store", driver);
		
		countryField.click();
		scrollText(country);
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+country+"']")).click();
		
	}
	
	public ProductCatalogue submitForm()
	{
		submitButton.click();
		return new ProductCatalogue(driver);

	}
	
	
}
