package com.simplelearn.AppiumDemo;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class ZoomInOutDemo {
	AndroidDriver<MobileElement>driver;
	@BeforeTest
	public void launchApplication() throws IOException {
	    //Create object for desired capability
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME,"LVRWJNQWNJUOWS55");
		cap.setCapability("plateformName","ANDROID");
		cap.setCapability("appPackage","com.google.android.apps.maps");
		cap.setCapability("appActivity","com.google.android.maps.MapsActivity");
		cap.setCapability("noReset",true);
	    driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
	    }
	@Test
	public void ZoomOutDemo() throws InterruptedException {
		Thread.sleep(3000);
		
		TouchAction<?> TA1 = new TouchAction<>(driver);
		TA1.press(PointOption.point(13, 472)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(3000))).moveTo(PointOption.point(329, 480)).release().perform();
		
		TouchAction<?> TA2 = new TouchAction<>(driver);
	    TA2.press(PointOption.point(715, 465)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(3000))).moveTo(PointOption.point(403, 465)).release().perform();
	    
	    MultiTouchAction MTA = new MultiTouchAction(driver);
	    MTA.add(TA1).add(TA2).perform();
}


}
