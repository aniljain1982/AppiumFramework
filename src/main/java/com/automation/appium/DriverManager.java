package com.automation.appium;

import org.openqa.selenium.remote.RemoteWebDriver;

public abstract class DriverManager {
	protected RemoteWebDriver driver;
	static protected final String APP = "https://github.com/cloudgrey-io/the-app/releases/download/v1.9.0/TheApp-v1.9.0.apk";
	static protected final String APPIUM = "http://localhost:4723/wd/hub";

	public RemoteWebDriver getDriver() {
		return driver;
	}

}
