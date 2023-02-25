package com.automation.ui.theapp;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SecretScreen extends BaseScreen {

	@FindBy(xpath = "//android.widget.TextView[contains(@text,'You are logged in')]")
	WebElement message;

	@FindBy(xpath = "//android.widget.TextView[contains(@text,'Logout')]")
	WebElement btnLogout;

	public SecretScreen(RemoteWebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public boolean validateThatOnSecretScreen() throws Exception {
		return webElementHelper.waitTillElementIsVisible(message).checkVisibility(message);
	}

	public LoginScreen logout() throws Exception {
		webElementHelper.click(btnLogout);
		return new LoginScreen(this.driver);
	}

	public String getLoginMessage() {
		return message.getText();
	}

}
