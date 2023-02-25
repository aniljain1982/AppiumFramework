package com.automation.appium;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.automation.helper.PropertyHelper;

public class Browser {

	RemoteWebDriver driver;
	PropertyHelper prop;

	@BeforeClass
	@Parameters({ "environment", "platform", "launchType" })
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
			driver.get("https://katalon-demo-cura.herokuapp.com/");
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
