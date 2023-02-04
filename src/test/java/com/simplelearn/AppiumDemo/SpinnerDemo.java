package com.simplelearn.AppiumDemo;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class SpinnerDemo {
	AndroidDriver<MobileElement>driver;
	@BeforeTest
	public void launchApplication() throws IOException {
	    //Create object for desired capability
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME,"LVRWJNQWNJUOWS55");
		cap.setCapability("plateformName","ANDROID");
		cap.setCapability("appPackage","com.touchboarder.android.api.demos");
		cap.setCapability("appActivity","com.touchboarder.androidapidemos.MainActivity");
		cap.setCapability("noReset",true);
	    driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
	    }
	    
	@Test
	public void SelectColourAndDateFromSpinner() throws InterruptedException {
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='API Demos']")).click();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//android.widget.TextView[@text='Views']")).click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Views\").instance(0))").click();
        
		//Scroll down and click
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Spinner\").instance(0))").click();
		//click on spinner 1 and select yellow
		driver.findElement(By.id("com.touchboarder.android.api.demos:id/spinner1")).click();
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='yellow']")).click();
		//click on spinner 2 and select Earth
		driver.findElement(By.id("com.touchboarder.android.api.demos:id/spinner2")).click();
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Earth']")).click();
		
		
	}

}
