package com.Mystore.pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.WebDriverWait;

import com.Mystore.utilities.HighLightElements;

public class IndexPage {

//	RemoteWebDriver driver;
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor executor;
	HighLightElements highlightElements = new HighLightElements();
	
	// identify web elements
	@FindBy(linkText = "Create an Account")
	WebElement Signup;

//	@FindBy(linkText = " Sign In ")
//	WebElement Signin;
	
	@FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul/li[2]/a")
	WebElement Signin;
	
	@FindBy(id = "search")
	WebElement SearchInput;
	
	@FindBy(xpath = "//span[contains(@class,'logged-in')]")
	WebElement customerName;

	String url = "https://magento.softwaretestingboard.com/"; 

	// constructor
//	public IndexPage(RemoteWebDriver driver, WebDriverWait wait) {
//		this.driver = driver;
//		this.wait = wait;
//		PageFactory.initElements(driver, this);
//	}

	public IndexPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);
	}
	
	//sign up elements
	public void clickOnSignup() {
		highlightElements.highlightElement(driver, Signup);
		Signup.click();
	}

	public void clickOnSignin(){
//		wait.until(ExpectedConditions.elementToBeClickable(Signin));
		highlightElements.highlightElement(driver, Signin);
		Signin.click();
	}

	//create an account
	public String getCustomerName() {
		highlightElements.highlightElement(driver, customerName);
		return customerName.getText();
	}
	
	public void setSearchInputData(String search) {
		highlightElements.highlightElement(driver, SearchInput);
		SearchInput.sendKeys(search);
	}
	
	public String IndexUrl() {
		return driver.getCurrentUrl();
	}
	
	public boolean isUrl() {
		return driver.getCurrentUrl().equals(url);
	}
}
