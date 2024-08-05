package com.Mystore.stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Mystore.Hooks.AllHooks;
import com.Mystore.pageobjects.*;
import com.Mystore.utilities.HighLightElements;

import io.cucumber.java.en.*;

public class Signup {
	
	WebDriver driver = AllHooks.driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5));
	IndexPage indexPagelink = new IndexPage(driver, wait);
	SignupPage signup = new SignupPage(driver);
	HighLightElements highlightElements = new HighLightElements();

	@Given("User navigates to signup page")
	public void user_navigates_to_signup_page() {
		indexPagelink.clickOnSignup();
	}
	
	@When("User enters first name {string}")
	public void user_enters_first_name_fname(String fname) {
		signup.setFName("tanji");
		System.out.println(">> valid fname" + fname);
	}

	@When("enters last name {string}")
	public void enters_last_name_lname(String lname) {
		signup.setLName("L");
		System.out.println(">> valid lname" + lname);
	}
	
	@When("enters valid Email {string}")
	public void enters_valid_Email(String Email) {
		signup.setEmail("tanjiL@kamado.com");
		System.out.println(">> valid email address" + Email);
	}
	
	@When("enters valid Password {string}")
	public void enters_valid_Password(String Password) {
		signup.setpwd("TanjroL@1216");
		System.out.println(">> valid Password" + Password);
	}
	
	@When("enters valid confirm password {string}")
	public void enters_valid_confirm_password_password(String PPassword) {
		signup.setrepwd("TanjroL@1216");
	}
	
	@Then("User should signup successfully")
	public void user_should_signup_successfully() {
		signup.clickSubmitCreate();
	}

}
