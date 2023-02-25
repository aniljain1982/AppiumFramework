package com.automation.ui.theapp;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import com.automation.appium.WebElementHelper;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BaseScreen {
	public RemoteWebDriver driver;
	public WebElementHelper webElementHelper;

	public BaseScreen(RemoteWebDriver driver) {
		this.driver = driver;
		this.webElementHelper = new WebElementHelper(driver);
		WebElementHelper.setWaitTime(60);
	}

	public void killDriver() {
		driver.quit();
	}
//
//	public HomeScreen initializeHomeScreen(AppiumDriver driver) throws Exception {
//		return PageFactory.initElements(driver, HomeScreen.class);
//	}

}
