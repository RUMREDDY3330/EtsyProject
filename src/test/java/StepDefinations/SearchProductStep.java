package StepDefinations;

import java.time.Duration;

import org.bouncycastle.crypto.prng.ThreadedSeedGenerator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Then;
import junit.framework.Assert;
import pages.ObjectManager;
import utils.TestBase;

public class SearchProductStep extends ObjectManager{
	
	@Then("Enter the product name")
	public void enter_the_product_name() {
		ProductSearch.SearchProduct();
		
	    
	}
	@Then("Click on search button")
	public void click_on_search_button() {
		ProductSearch.SearchButoonClick();
	    
	}
	@Then("select the product")
	public void select_the_product() {
		ProductSearch.SelectProduct();
		
	}
	@Then("click on add to cart button")
	public void click_on_add_to_cart_button() throws InterruptedException {
		ProductSearch.addToCart();
		
	}
	@Then("Verify product is added to cart")
	public void verify_product_is_added_to_cart() throws InterruptedException {
		ProductSearch.verifyProductIsAdded();
		
		
	}
	@Then("click on close button")
	public void click_on_close_button() throws InterruptedException {
		ProductSearch.onClickCloseIcon();
	}

}
