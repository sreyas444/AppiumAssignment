package com.appium.setup;

import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

@SuppressWarnings("deprecation")
public class setUp {
	@SuppressWarnings("rawtypes") 
	public static AppiumDriver driver;
	public static AndroidDriver androidDriver;
	
	@SuppressWarnings("deprecation")
	@Test
	public void scenario1() throws MalformedURLException {
		setupAppium();
		login();
		By productPage=MobileBy.xpath("(//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"])[1]/android.widget.TextView");
		driver.findElement(productPage).click();
		By cartView=MobileBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.view.ViewGroup\r\n");
		driver.findElement(cartView).click();
		By checkout=MobileBy.AccessibilityId("test-CHECKOUT");
		driver.findElement(checkout).click();
		By firstName=MobileBy.AccessibilityId("test-First Name");
		driver.findElement(firstName).click();
		driver.findElement(firstName).sendKeys("abc");
		By lastName=MobileBy.AccessibilityId("test-Last Name");
		driver.findElement(lastName).click();
		driver.findElement(lastName).sendKeys("def");
		By PostalCode=MobileBy.AccessibilityId("test-Zip/Postal Code");
		driver.findElement(PostalCode).click();
		driver.findElement(PostalCode).sendKeys("400087"+"\n");
     	By checkoutContinue=MobileBy.xpath("//android.view.ViewGroup[@content-desc=\"test-CONTINUE\"]/android.widget.TextView");
		driver.findElement(checkoutContinue).click();
		String visibleText="FINISH";
	//	androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+visibleText+"\").instance(0))").click();
		By finishBtn=MobileBy.xpath("//android.view.ViewGroup[@content-desc=\"test-FINISH\"]/android.widget.TextView");
		driver.findElement(finishBtn).click();
		
		By confirmMsg=MobileBy.xpath("//android.widget.ScrollView[@content-desc=\"test-CHECKOUT: COMPLETE!\"]/android.view.ViewGroup/android.widget.TextView[1]");
		String msgConfirm=driver.findElement(confirmMsg).getText();
		Boolean confirmation=msgConfirm.equalsIgnoreCase("THANK YOU FOR YOU ORDER");
		assertTrue(confirmation);
		closeDriver();
	}
	
	@Test
	public void scenario2() throws MalformedURLException {
		setupAppium();
		login();
		By productPage=MobileBy.xpath("(//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"])[1]/android.widget.TextView");
		driver.findElement(productPage).click();
		By cartView=MobileBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.view.ViewGroup\r\n");
		driver.findElement(cartView).click();
		By removeBtn=MobileBy.AccessibilityId("test-REMOVE");
		driver.findElement(removeBtn).click();
		By backToPLP=MobileBy.AccessibilityId("test-CONTINUE SHOPPING");
		driver.findElement(backToPLP).click();
		driver.findElement(productPage).click();
		driver.findElement(cartView).click();
		By checkout=MobileBy.AccessibilityId("test-CHECKOUT");
		driver.findElement(checkout).click();
		By firstName=MobileBy.AccessibilityId("test-First Name");
		driver.findElement(firstName).click();
		driver.findElement(firstName).sendKeys("abc");
		By lastName=MobileBy.AccessibilityId("test-Last Name");
		driver.findElement(lastName).click();
		driver.findElement(lastName).sendKeys("def");
		By PostalCode=MobileBy.AccessibilityId("test-Zip/Postal Code");
		driver.findElement(PostalCode).click();
		driver.findElement(PostalCode).sendKeys("400087"+"\n");
		By checkoutContinue=MobileBy.xpath("//android.view.ViewGroup[@content-desc=\"test-CONTINUE\"]/android.widget.TextView");
		driver.findElement(checkoutContinue).click();
		String visibleText="FINISH";
		By finishBtn=MobileBy.xpath("//android.view.ViewGroup[@content-desc=\"test-FINISH\"]/android.widget.TextView");
		driver.findElement(finishBtn).click();
		By confirmMsg=MobileBy.xpath("//android.widget.ScrollView[@content-desc=\"test-CHECKOUT: COMPLETE!\"]/android.view.ViewGroup/android.widget.TextView[1]");
		String msgConfirm=driver.findElement(confirmMsg).getText();
		Boolean confirmation=msgConfirm.equalsIgnoreCase("THANK YOU FOR YOU ORDER");
		assertTrue(confirmation);
		closeDriver();
	}
	
	public void login() {
		
		By userName=MobileBy.AccessibilityId("test-Username");
		driver.findElement(userName).click();
		driver.findElement(userName).sendKeys("standard_user");
		By password=MobileBy.AccessibilityId("test-Password");
		driver.findElement(password).click();
		driver.findElement(password).sendKeys("secret_sauce");
		By loginBtn=MobileBy.AccessibilityId("test-LOGIN");
		driver.findElement(loginBtn).click();
		
	}
	//		
		
		public void closeDriver() {
		driver.quit();
	
	 }

public void setupAppium() throws MalformedURLException {
	DesiredCapabilities caps=new DesiredCapabilities();
	
	caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 4 API 31");
	caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiAutomator2");
	caps.setCapability(MobileCapabilityType.APP, "C:/Users/001ZKU744/Downloads/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");
	caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
	caps.setCapability("appPackage", "com.swaglabsmobileapp");
	caps.setCapability("appActivity", "com.swaglabsmobileapp.SplashActivity");
	URL url=new URL("http://0.0.0.0:4723/wd/hub");
	driver = new AppiumDriver(url, caps);
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
}
	

}
