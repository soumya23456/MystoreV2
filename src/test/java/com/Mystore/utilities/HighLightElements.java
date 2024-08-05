package com.Mystore.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HighLightElements {
	
	WebDriver driver;
	JavascriptExecutor executor;

	public HighLightElements() {

	}

	public void highlightElement(WebDriver driver, WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].setAttribute('style', 'border: 2px solid yellow;')", element);
	}
}
