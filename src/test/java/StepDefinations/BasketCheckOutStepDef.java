package StepDefinations;

import java.io.IOException;

import org.openqa.selenium.By;

import io.cucumber.java.en.Then;
import junit.framework.Assert;
import pages.BasketChekoutPage;
import pages.ObjectManager;

public class BasketCheckOutStepDef extends ObjectManager{

	@Then("click on basket icon")
	public void click_on_basket_icon() {
		basketChekoutPage.BasketIconbutton();
	    
	}
	@Then("verify user is on basket checkout page")
	public void verify_user_is_on_basket_checkout_page() {
		basketChekoutPage.verifyuserIsOnBasketPage();
    
	}
	@Then("verify product is added to cart")
	public void verify_product_is_added_to_cart() {
		basketChekoutPage.verifyProductAddedToCart();
	}
	@Then("fetch all the product information in to excel like product name price reviews seller information")
	public void fetch_all_the_product_information_in_to_excel_like_product_name_price_reviews_seller_information() throws IOException {
		basketChekoutPage.addCartDetailsInExcelSheet();
	    
	}

	
}
