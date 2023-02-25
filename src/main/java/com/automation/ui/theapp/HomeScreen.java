package com.automation.ui.theapp;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeScreen extends BaseScreen {

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='Login Screen']")
	public WebElement btnLoginScreen;

	public HomeScreen(RemoteWebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public boolean validateThatOnHomeScreen() throws Exception {
		return webElementHelper.waitTillElementIsVisible(btnLoginScreen).checkVisibility(btnLoginScreen);
	}

	public LoginScreen navigateToLoginScreen() {
		btnLoginScreen.click();
		return new LoginScreen(this.driver);
	}
}
