package com.simplelearn.AppiumDemo;

import java.io.IOException;
import java.net.URL;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class ContextSwitchingDemo {
	
AndroidDriver<MobileElement>driver;
	
	@BeforeTest
	public void launchApplication() throws IOException {
	    //Create object for desired capability
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME,"LVRWJNQWNJUOWS55");
		cap.setCapability("plateformName","ANDROID");
		cap.setCapability("browserName","Chrome");
		cap.setCapability("ignoreHiddenApiPolicyError", true);
		cap.setCapability("noReset",true);
	    driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
	    driver.get("https://ebay.com");
	}
	@Test
	public void addShortcutHomeScreen() throws Throwable {
		Set<String> Contexts = driver.getContextHandles();
		for(String t: Contexts) {		
			System.out.println(t);
		}
		System.out.println("CurrentContext = " + driver.getContext());
		//Go to Native app
		driver.context("NATIVE_APP");
		//click on 3 dot
		driver.findElement(By.id("com.android.chrome:id/menu_button")).click();
		Thread.sleep(2);
		//click on add to home screen context menu
		driver.findElement(By.xpath("//android.widget.TextView[@text='Add to Home screen']")).click();
		//driver.findElement(By.xpath("//android.widget.TextView[@text ='add to Home screen']")).click();
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("com.android.chrome:id/positive_button")));
		//click on pop-up
		driver.findElement(By.id("com.android.chrome:id/positive_button")).click();
		
		//the below code vary as per android device
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@text='Add to Home screen']")));
		//driver.findElement(By.xpath("//android.widget.Button[@text='Add to Home screen']")).click();
		
	}
	

}
