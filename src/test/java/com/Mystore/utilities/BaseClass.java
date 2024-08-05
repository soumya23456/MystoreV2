package com.Mystore.utilities;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
	
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static Logger logger;
	
	public BaseClass() {
		
	}
}
