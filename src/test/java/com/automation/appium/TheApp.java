package com.automation.appium;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.automation.helper.PropertyHelper;
import com.automation.ui.theapp.HomeScreen;
import com.automation.ui.theapp.LoginScreen;
import com.automation.ui.theapp.SecretScreen;

import io.appium.java_client.AppiumDriver;

public class TheApp {
	RemoteWebDriver driver;
	HomeScreen homeScreen;
	LoginScreen loginScreen;
	SecretScreen secretScreen;
	PropertyHelper prop;

	@BeforeClass
	@Parameters({"environment", "platform", "launchType"})
	public void setup(String environment, String platform, String launchType) throws Exception {
		try {
			prop = new PropertyHelper(environment, "theapp");
			DriverManagerFactory factory = new DriverManagerFactory(prop);
			driver = factory.getDriverManager(platform, launchType).getDriver();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void myTest() {
		try {
			homeScreen = new HomeScreen(driver);
			Assert.assertTrue(homeScreen.validateThatOnHomeScreen());
			loginScreen = homeScreen.navigateToLoginScreen();
			Assert.assertTrue(loginScreen.validateThatOnLoginScreen());
			secretScreen = loginScreen.loginToApp(prop.getPropertyValue("userName"), prop.getPropertyValue("password"));
			Assert.assertTrue(secretScreen.validateThatOnSecretScreen());
			Assert.assertTrue(secretScreen.getLoginMessage().contains(prop.getPropertyValue("userName")));
			loginScreen=secretScreen.logout();
			Assert.assertTrue(loginScreen.validateThatOnLoginScreen());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		homeScreen.killDriver();
	}

}
