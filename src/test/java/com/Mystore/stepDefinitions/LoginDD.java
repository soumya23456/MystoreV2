package com.Mystore.stepDefinitions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Mystore.Hooks.AllHooks;
import com.Mystore.pageobjects.CustomerAccount;
import com.Mystore.pageobjects.IndexPage;
import com.Mystore.pageobjects.LogoutPage;
import com.Mystore.pageobjects.SigninPage;

import freemarker.log.Logger;
import io.cucumber.java.en.*;

public class LoginDD {
	
	WebDriver driver = AllHooks.driver;;
	WebDriverWait wait;
	Logger logger;
	IndexPage logInlink = new IndexPage(driver, wait);
	SigninPage signin = new SigninPage(driver);
	CustomerAccount accCreate = new CustomerAccount(driver);
	LogoutPage logout = new LogoutPage(driver);

	@Given("User opens Main page")
	public void User_opens_Main_page() {
		
		System.out.println(">> Mystore Url opened");

	}
	
	@Given("^User navigates to Login page$")
	public void user_navigates_to_login_page() {
	    System.out.println(">> navigates to Login page");
	}
		
	//Data driven
	@When("^User enters valid email address (.+)$")
	public void user_enters_valid_email_address(String email) {
		System.out.println(">> valid email address" + email);
	}

	@And("^Enter valid password (.+)$")
	public void enter_valid_password(String pwd) {
		System.out.println(">> valid password" + pwd);
//		System.out.println(8/0);
	}

	@When("Clicks on Login button")
	public void clicks_on_login_button() {
		System.out.println(">> Clicks on Login button");
	}

	@Then("User should login successfully")
	public void user_should_login_successfully() {
		System.out.println(">> login successfully");
	}

	@When("User enters invalid email address (.+)")
	public void User_enters_invalid_email_address(String email) {
		System.out.println(">> invalid email address"+ email);
	}

	@And("Enter invalid password (.+)")
	public void enter_invalid_password(String pwd) {
		System.out.println(">> invalid password"+ pwd);
	}

	@Then("User should get proper warning message")
	public void user_should_get_proper_warning_message() {
		System.out.println(">> User should get proper warning message");
	}

	@Then("User should not login successfully")
	public void user_should_not_login_successfully() {
		System.out.println(">> User should not login successfully");
	}

	@And("User should get the error message for invalid email address")
	public void user_should_get_the_error_message_for_invalid_email_address() {
		System.out.println(">> User should get the error message for invalid email address");
	}

	@And("User should get the error message for invalid password")
	public void user_should_get_the_error_message_for_invalid_password() {
		System.out.println(">> User should get the error message for invalid password");
	}
	
	@When("User dont enter any email address")
	public void user_dont_enter_any_email_address() {
		System.out.println(">> User dont enter any email address");
	}

	@When("User dont enter any  password")
	public void user_dont_enter_any_password() {
		System.out.println(">> User dont enter any  password");
	}
}
