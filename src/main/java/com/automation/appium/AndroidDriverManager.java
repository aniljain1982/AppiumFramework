package com.automation.appium;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.automation.helper.PropertyHelper;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class AndroidDriverManager extends DriverManager {
	public AndroidDriverManager(PropertyHelper prop, String launchType) throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
		if (launchType.equalsIgnoreCase("app")) {
			capabilities.setCapability(MobileCapabilityType.APP, prop.getPropertyValue("app"));
			driver = new AndroidDriver(new URL(prop.getPropertyValue("appiumServer")), capabilities);
		} else {
			capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
			driver = new RemoteWebDriver(new URL(APPIUM), capabilities);
		}

	}

}
