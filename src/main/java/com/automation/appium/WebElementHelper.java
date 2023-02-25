package com.automation.appium;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class WebElementHelper {
	public RemoteWebDriver driver;

	public static long waitTime = 60;
	public WebDriverWait webDriverWait;
	private WebElement webElement;
	private List<WebElement> webElements;

	public WebElementHelper(RemoteWebDriver driver) {
		this.driver = driver;
		webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));

	}

	public WebElementHelper(WebElement webElement, AppiumDriver driver) {
		this.driver = driver;
		this.webElement = webElement;
	}

	public WebElementHelper(List<WebElement> webElements, AppiumDriver driver) {
		this.driver = driver;
		this.webElements = webElements;
	}

	public WebElementHelper(WebElement webElement) {
		this.webElement = webElement;
	}

	public WebElement getWebElement() {
		return webElement;
	}

	public List<WebElement> getWebElements() {
		return webElements;
	}

	public static long getWaitTime() {
		return waitTime;
	}

	public static void setWaitTime(long waitTime) {
		WebElementHelper.waitTime = waitTime;
	}

	public WebElement findTheElement(By byElem) throws Exception {
		return driver.findElement(byElem);
	}

	public WebElement findTheElement(AppiumBy byElem) throws Exception {
		return driver.findElement(byElem);
	}

	public WebElementHelper waitTillElementIsVisible(WebElement element) throws Exception {
		webDriverWait.until(ExpectedConditions.or(ExpectedConditions.visibilityOf(element)));
		return new WebElementHelper(driver);
	}

	public WebElementHelper waitTillElementIsPresent(By byElem) throws Exception {
		WebElement element = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(byElem));
		return new WebElementHelper(element);
	}

	public WebElementHelper click(WebElement element) throws Exception {
		element.click();
		return new WebElementHelper(driver);
	}

	public Boolean checkVisibility(WebElement element) {
		boolean visible = false;
		try {
			if (element.isDisplayed() == true) {
				visible = true;
			}
		} catch (NoSuchElementException noexcep) {
			visible = false;
		}
		return visible;
	}

	public WebElementHelper clickAndSendkeys(WebElement elem, String string) throws Exception {
		elem.click();
		elem.sendKeys(string);
		return new WebElementHelper(driver);
	}

	public WebElementHelper sendKeysTo(WebElement elem, String inputString) throws Exception {
		elem.sendKeys(inputString);
		return new WebElementHelper(driver);
	}

}
