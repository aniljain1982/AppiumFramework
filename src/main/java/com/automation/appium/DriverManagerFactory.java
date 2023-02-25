package com.automation.appium;

import com.automation.helper.PropertyHelper;

public class DriverManagerFactory {
	PropertyHelper prop;

	public DriverManagerFactory(PropertyHelper prop) {
		this.prop = prop;
	}

	public DriverManager getDriverManager(String platform, String launchType) throws Exception {
		DriverManager driverManager = null;
		switch (platform) {
		case "Android":
			driverManager = new AndroidDriverManager(prop, launchType);
			break;
		case "iOS":
			driverManager = new IOSDriverManager(prop, launchType);
			break;
		default:
			driverManager = new AndroidDriverManager(prop, launchType);
			break;
		}
		return driverManager;
	}
}
