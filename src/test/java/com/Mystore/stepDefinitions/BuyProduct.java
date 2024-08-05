package com.Mystore.stepDefinitions;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Mystore.Hooks.AllHooks;
import com.Mystore.pageobjects.*;

import io.cucumber.java.en.*;

public class BuyProduct {

	WebDriver driver = AllHooks.driver;;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	IndexPage indexPageLink = new IndexPage(driver, wait);
	SigninPage signin = new SigninPage(driver);
	LogoutPage logout = new LogoutPage(driver);
	SearchProductPage searchProductPage = new SearchProductPage(driver, wait);
	OrderSuccessPage ordersuccessPage = new OrderSuccessPage(driver, wait);
	String searchEntry = "Radient Tee";
	
	@When("User navigates to LogIn page")
	public void User_navigates_to_LogIn_page() {
		indexPageLink.clickOnSignin();
		System.out.println(">> Log In to page");
	}
	
	@When("User enter email address {string}")
	public void user_enter_email_address(String email1) {
		signin.setEmail(email1);
		System.out.println(">> valid email address" + email1);
	}

	@And("User enter password {string}")
	public void User_enter_password(String password1) {
		signin.setpwd(password1);
		System.out.println(">> valid password" + password1);
	}
	
	@Then("User logged in successfully")
	public void User_logged_in_successfully() {
		signin.clicklogInButton();
		System.out.println("logged in successfully");
	}
	
	@When("User enters product name")
	public void user_enters_product_name() {
		
		indexPageLink.setSearchInputData(searchEntry + Keys.ENTER);
		
	}

	@And("searches for product")
	public void searches_for_product() {
		assertTrue(searchProductPage.searchValuePresent(searchEntry));
	}

	@And("User should get redirected to product page")
	public void user_should_get_redirected_to_product_page() {
		wait.until(d -> driver.getCurrentUrl().equals("https://magento.softwaretestingboard.com/catalogsearch/result/?q=Radient+Tee"));
	}

	@And("product found successfully")
	public void product_found_successfully() {
		searchProductPage.getSearchedProduct();
		assertFalse(searchProductPage.searchedProductPresent(searchEntry));
	}

	@And("User selects product size")
	public void user_selects_product_size() {
		searchProductPage.selectSize();
	}

	@And("selects product color")
	public void selects_product_color() {
		searchProductPage.selectProductColor();
	}

	@And("clicks product to add to cart button")
	public void clicks_product_to_add_to_cart_button() {
		searchProductPage.clickProdAddtoCart();
		
	}

	@And("product cart alert message appears")
	public void product_cart_alert_message_appears() {
		//success add to cart alert
				wait.until(d->searchProductPage.isProductAddedToCartAlertPresent());
				searchProductPage.isProductAddedToCartAlertPresent();
	}

	@And("User opens add to cart dropdown")
	public void user_opens_add_to_cart_dropdown() throws InterruptedException{
		//add to cart drop down
		
			searchProductPage.addtocartsectionLink();
			Thread.sleep(2000);
	}

	@And("clicked on procced to check out")
	public void clicked_on_procced_to_check_out() throws InterruptedException{
		Thread.sleep(2000);
		searchProductPage.clickProceedtoCheckoutButton();
	}

	@And("enters to shipping page")
	public void enters_to_shipping_page() {
		wait.until(d -> driver.getCurrentUrl().equals("https://magento.softwaretestingboard.com/checkout/#shipping"));
		ordersuccessPage.shippingorderElement();
	}

	@And("clicked on Next button")
	public void clicked_on_next_button() {
		ordersuccessPage.checkoutradioButton();
		ordersuccessPage.nextButton();
	}

	@And("clicked on place order button")
	public void clicked_on_place_order_button() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		OrderSuccessPage ordersuccessPage = new OrderSuccessPage(driver, wait);
		ordersuccessPage.placeorderButton();
	}

	@And("product checked out successfully")
	public void product_checked_out_successfully() {
		wait.until(d -> driver.getCurrentUrl().equals("https://magento.softwaretestingboard.com/checkout/onepage/success/"));
	}

	@And("clicked on order number")
	public void clicked_on_order_number() throws InterruptedException {
		ordersuccessPage.orderNumber();
	}

	@And("prints order")
	public void prints_order() {
		Object[] currentWindowHandles = driver.getWindowHandles().toArray();
		driver.switchTo().window(currentWindowHandles[1].toString());
	}

	@And("closes driver")
	public void closes_driver() {
		driver.close();
	}

	@And("views order details")
	public void views_order_details() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		Object[] newWindowHandles = driver.getWindowHandles().toArray();
		driver.switchTo().window(newWindowHandles[0].toString());
//		wait.until(d -> driver.getCurrentUrl().contains("https://magento.softwaretestingboard.com/sales/order/view/order_id/"));
	}

	@Then("logouts")
	public void logouts() {
		logout.logoutdropdownaccCreate();
		logout.logoutbutton();
	}
}
