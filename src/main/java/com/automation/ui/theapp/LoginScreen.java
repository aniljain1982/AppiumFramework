package com.automation.ui.theapp;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginScreen extends BaseScreen {

	@FindBy(xpath = "//android.widget.EditText[@content-desc='username']")
	WebElement txtUserName;

	@FindBy(xpath = "//android.widget.EditText[@content-desc='password']")
	WebElement txtPassowrd;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='loginBtn']/android.widget.TextView")
	WebElement btnLogin;

	public LoginScreen(RemoteWebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public boolean validateThatOnLoginScreen() throws Exception {
		return webElementHelper.waitTillElementIsVisible(txtUserName).checkVisibility(txtUserName);
	}

	public SecretScreen loginToApp(String userName, String password) throws Exception {
		webElementHelper.clickAndSendkeys(txtUserName, userName).clickAndSendkeys(txtPassowrd, password)
				.click(btnLogin);
		return new SecretScreen(driver);
	}
}
