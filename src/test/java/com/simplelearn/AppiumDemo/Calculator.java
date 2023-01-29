package com.simplelearn.AppiumDemo;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Calculator {
	
	AndroidDriver<MobileElement>driver;
	
	@BeforeTest
	public void launchApplication() throws IOException {
	    //Create object for desired capability
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME,"LVRWJNQWNJUOWS55");
		cap.setCapability("plateformName","ANDROID");
		cap.setCapability("ignoreHiddenApiPolicyError", true);
		cap.setCapability("appPackage","com.miui.calculator");
		cap.setCapability("appActivity","com.miui.calculator.cal.CalculatorActivity");
		cap.setCapability("noReset",true);
	    driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), cap);	
	}
	
	@Test(priority = 0)
	public void verifyAdditionProcess() throws Throwable {
		driver.findElement(By.id("com.miui.calculator:id/btn_c_s")).click();
		driver.findElement(By.id("com.miui.calculator:id/digit_9")).click();
		driver.findElementByAccessibilityId("plus").click();
		driver.findElement(By.id("com.miui.calculator:id/digit_5")).click();
	    String SumValue = driver.findElement(By.id("com.miui.calculator:id/result")).getText().substring(2, 4);
		Assert.assertEquals(SumValue,"14");
		Thread.sleep(3);
		
	}
	@Test(priority = 2)
	public void verifySubtractProcess() throws Throwable {
		//First click on clear button that subtract two digit
		driver.findElement(By.id("com.miui.calculator:id/btn_c_s")).click();
		driver.findElement(By.id("com.miui.calculator:id/digit_9")).click();
		driver.findElement(By.id("com.miui.calculator:id/op_sub")).click();
		driver.findElement(By.id("com.miui.calculator:id/digit_5")).click();
	    String SumValue = driver.findElement(By.id("com.miui.calculator:id/result")).getText();
		Assert.assertEquals(SumValue,"= 4");
		Thread.sleep(3);
		}
	@Test (priority = 3)
	public void verifyMultiplyProcess() throws Throwable {
		driver.findElement(By.id("com.miui.calculator:id/btn_c_s")).click();
		driver.findElement(By.id("com.miui.calculator:id/digit_4")).click();
		driver.findElementByAccessibilityId("multiply").click();
		driver.findElement(By.id("com.miui.calculator:id/digit_3")).click();
	    String MulValue = driver.findElement(By.id("com.miui.calculator:id/result")).getText().substring(2, 4);
		Assert.assertEquals(MulValue,"12");
		Thread.sleep(3);		
		}
	
	@Test(priority = 4)
	public void verifyDelBtnPresent() {
		boolean clearButtonDisplayed = driver.findElement(By.id("com.miui.calculator:id/btn_del_s")).isDisplayed();
		Assert.assertTrue(clearButtonDisplayed);
		
	}
	
	
	@AfterTest
	public void closeApp() throws Throwable {
		Thread.sleep(3);
		driver.quit();
	}

}
