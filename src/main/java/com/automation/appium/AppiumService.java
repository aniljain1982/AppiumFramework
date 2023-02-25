package com.automation.appium;

import java.io.File;
import java.util.HashMap;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumService {
	private static AppiumDriverLocalService service;

	public static void startAppiumServer() throws Exception{
//		AppiumServiceBuilder builder = new AppiumServiceBuilder();
//		builder.usingPort(4723);
//		builder.usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"));
//		builder.withAppiumJS(new File(
//				"C:\\Program Files\\Appium Server GUI\\resources\\app\\node_modules\\appium\\build\\lib\\main.js"));
//
//		HashMap<String, String> environment = new HashMap();
//		environment.put("PATH", "/usr/local/bin:" + System.getenv("PATH"));
//		builder.withEnvironment(environment);
//		service = AppiumDriverLocalService.buildService(builder);
//		service.start();

		service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
				.usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
				.withAppiumJS(new File(
						"C:\\Program Files\\Appium Server GUI\\resources\\app\\node_modules\\appium\\build\\lib\\main.js"))
				.usingPort(4723).withIPAddress("0.0.0.0"));
		service.start();
		Thread.sleep(10000);
	}
	
	public static void main(String[] args) throws Exception{
		new AppiumService().startAppiumServer();
		System.out.println(service.isRunning());
	}

}
