package com.Mystore.Hooks;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;

import com.Mystore.utilities.BaseClass;
import com.Mystore.utilities.ReadConfig;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class AllHooks extends BaseClass{
	
	ReadConfig readConfig = new ReadConfig();
	String baseurl = readConfig.getBaseUrl();
	String browser = readConfig.getBrowser();
	
	@Before
	@Parameters(value={"browser"})
	public void setup()
	{
		
		String browser = "chrome";
		
		switch (browser.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		default:
			driver = null;
			break;
		}
		        
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10));
		driver.get(baseurl);
		
		//logging
		logger = LogManager.getLogger("MyStoreV2");
		
		
	}   

	@After
	public void teardown(Scenario scenario) throws IOException{
		
		if(scenario.isFailed()) {
			//step1: convert web driver object to TakesScreenshot interface
			TakesScreenshot screenshot = ((TakesScreenshot)driver);
			
			//step2: call getScreenshotAs method to create image file
			
			File src = screenshot.getScreenshotAs(OutputType.FILE);
			
			File dest = new File(System.getProperty("user.dir") + "//ScreenShots//featureFail.png");
		
			//step3: copy image file to destination
			FileUtils.copyFile(src, dest);
		}
		driver.quit();
	}
	
	
//	public boolean isUrl() {
//		return driver.getCurrentUrl().equals(baseurl);
//	}
	//user method to capture screen shot
		public void captureScreenShot(WebDriver driver,String testName) throws IOException
		{
			
		}

	
}
