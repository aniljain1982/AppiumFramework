package com.automation.helper;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public final class PropertyHelper {
	private final Properties properties;

	public PropertyHelper(String fileName, String folderName) throws Exception {
		properties = new Properties();
		String path = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator
				+ "resources" + File.separator + folderName + File.separator + fileName;
		File file = new File(path);
		FileInputStream fileInput = new FileInputStream(file);
		properties.load(fileInput);
	}

	public String getPropertyValue(String propertyName) {
		return this.properties.getProperty(propertyName,
				String.format("The property %s does not exists!", propertyName));
	}

	public static void main(String[] args) throws Exception {
		PropertyHelper prop = new PropertyHelper("config.properties", "theapp");
		prop = new PropertyHelper("config2.properties", "theapp");

		System.out.println(prop.getPropertyValue("userName"));
		System.out.println(prop.getPropertyValue("password"));
	}
}
