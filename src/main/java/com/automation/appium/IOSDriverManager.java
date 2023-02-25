package com.automation.appium;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.automation.helper.PropertyHelper;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class IOSDriverManager extends DriverManager {
	public IOSDriverManager(PropertyHelper prop, String launchType) throws Exception{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13.5");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 11");
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
		capabilities.setCapability(MobileCapabilityType.APP, APP);
		driver = new IOSDriver(new URL(APPIUM), capabilities);
	}

}
